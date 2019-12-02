package jogo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import jogo.modelo.Action;
import jogo.modelo.PurchaseOrder;
import jogo.modelo.SalesOrder;
import jogo.modelo.StatusEnum;

/**
 * DAO Action
 *
 * @see Action
 */
public class ActionDAO {

    private Connection con = null;
    private ConnectionFactory dao;
    private PreparedStatement stm;
    private ResultSet rs;

    //contrutor para conexão com o DB
    public ActionDAO() {
        dao = new ConnectionFactory();
        try {
            con = dao.getConnection();
        } catch (SQLException e) {
            System.err.println("Erro de Conexão");
        }
    }

    @Override
    protected void finalize() throws Throwable {
        dao = new ConnectionFactory();
        try {
            dao.closeConnection(con, stm, rs);
        } catch (Exception e) {
            System.err.println("Erro");
        }
    }

    public void inserir(Action obj, int idMatch) throws SQLException {
        String sql = "Insert into Action (idMatch, Name, Status, MarketQuantity, PlayerQuantity)"
                + "values (?, ?, ?, ? ,?)";
        stm = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        stm.setInt(1, idMatch);
        stm.setString(2, obj.getName());
        stm.setString(3, obj.getStatus().toString());
        stm.setDouble(4, obj.getMarketQuantity());
        stm.setDouble(5, obj.getPlayerQuantity());

        stm.executeUpdate();

        rs = stm.getGeneratedKeys();
        rs.next();

        InserirPurchaseOrderList(obj);
        InserirSalesOrderList(obj);

    }

    public void inserir(ArrayList<Action> list, int idMatch) throws SQLException {
        for (Action obj : list) {
            inserir(obj, idMatch);
        }
    }

    public void alterar(Action obj) throws SQLException {
        String sql = "update Action set Name = ?, Status = ?, value = ?,variation = ?, MarketQuantity=?, PlayerQuantity=?"
                + "where id=?";

        stm = con.prepareStatement(sql);
        stm.setString(1, obj.getName());
        stm.setString(2, obj.getStatus().toString());
        stm.setDouble(3, obj.getValue());
        stm.setDouble(4, obj.getVariation());
        stm.setDouble(5, obj.getMarketQuantity());
        stm.setDouble(6, obj.getPlayerQuantity());
        stm.setInt(7, obj.getId());

        stm.executeUpdate();

    }

    public void excluir(Action obj) throws SQLException {
        String sql = "DELETE FROM Action where codigo=?";
        stm = con.prepareStatement(sql);
        stm.setInt(1, obj.getId());

        stm.executeUpdate();

    }

    public ArrayList<Action> listaActions(int id) throws SQLException {
        try {
            ArrayList<Action> actions = new ArrayList<Action>();

            String sql = "SELECT * FROM Action WHERE idMatch = ?";

            stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            rs = stm.executeQuery();

            while (rs.next()) {
                actions.add(new Action(rs.getInt(2), rs.getString(3), StatusEnum.parseStatusEnum(rs.getString(4)),
                        rs.getDouble(5),rs.getDouble(6),rs.getDouble(7),rs.getDouble(8),
                        ListPurchaseOrder(rs.getInt(2)), ListSalesOrder(rs.getInt(2))));
            }
            return actions;
        } catch (SQLException e) {
            return null;
        }
    }

    public void save(ArrayList<Action> listGame, int id) throws SQLException {
        ArrayList<Action> listDB = listaActions(id);
        for (int j = 0; j < listGame.size(); j++) {
            alterar(listGame.get(j));
            alterarPurchaseOrderList(listGame.get(j).getPurchaseOrderList(), listGame.get(j).getId());
            alterarSalesOrderList(listGame.get(j).getSalesOrderList(), listGame.get(j).getId());
        }
    }

    //PurchaseOrderList
    private void InserirPurchaseOrderList(Action action) throws SQLException {
        for (int i = 0; i < action.getPurchaseOrderList().size(); i++) {
            InserirPurchaseOrder(action.getPurchaseOrderList().get(i));
        }

    }

    private void InserirPurchaseOrder(PurchaseOrder obj) throws SQLException {
        String sql = "Insert into PurchaseOrderList (idAction, Quantity, Value, StartTurn, EndTurn, IsFromPlayer)"
                + "values (?, ?, ?, ?, ?, ?)";
        stm = con.prepareStatement(sql);
        stm.setInt(1, obj.getAction().getId());
        stm.setInt(2, obj.getQuantity());
        stm.setDouble(3, obj.getValue());
        stm.setInt(4, obj.getStartTurn());
        stm.setInt(5, obj.getEndTurn());
        stm.setBoolean(6, obj.isIsFromPlayer());
        stm.executeUpdate();

    }

    public void alterarPurchaseOrderList(ArrayList<PurchaseOrder> listGame, int idAction) throws SQLException {
        ArrayList<PurchaseOrder> listdb = ListPurchaseOrder(idAction);
        for (int i = 0; i < listdb.size(); i++) {
            if (!listGame.contains(listdb.get(i))) {
                deletarPurchaseOrder(listdb.get(i));
            }
            for (int j = 0; j < listGame.size(); j++) {
                if (listGame.get(j).getId() == 0) {
                    InserirPurchaseOrder(listGame.get(j));
                } else {
                    alterarPurchaseOrder(listGame.get(j), idAction);
                }
            }
        }
    }

    private void alterarPurchaseOrder(PurchaseOrder obj, int idAction) throws SQLException {
        String sql = "update PurchaseOrderList set idAction = ?, Quantity = ?, Value = ?, StartTurn = ?, EndTurn = ?, IsFromPlayer = ? Where id = ?";

        stm = con.prepareStatement(sql);
        stm.setInt(1, idAction);
        stm.setDouble(2, obj.getQuantity());
        stm.setDouble(3, obj.getValue());
        stm.setInt(4, obj.getStartTurn());
        stm.setInt(5, obj.getEndTurn());
        stm.setBoolean(6, obj.isIsFromPlayer());
        stm.setInt(7, obj.getId());

        stm.executeUpdate();

    }

    private void deletarPurchaseOrder(PurchaseOrder obj) throws SQLException {
        String sql = "DELETE FROM PurchaseOrderList where id=?";
        stm = con.prepareStatement(sql);
        stm.setInt(1, obj.getId());

        stm.executeUpdate();
    }

    private ArrayList<PurchaseOrder> ListPurchaseOrder(int idAction) throws SQLException {
        try {
            ArrayList<PurchaseOrder> List = new ArrayList<PurchaseOrder>();

            String sql = "SELECT * FROM PurchaseOrderList WHERE idAction = ?";

            stm = con.prepareStatement(sql);
            stm.setInt(1, idAction);
            rs = stm.executeQuery();

            while (rs.next()) {
                List.add(new PurchaseOrder(rs.getInt(1), null, rs.getInt(3), rs.getDouble(4), rs.getInt(5), rs.getInt(6), rs.getBoolean(7)));
            }
            return List;
        } catch (SQLException e) {
            return null;
        }
    }

    //SalesOrderList
    private void InserirSalesOrderList(Action action) throws SQLException {
        for (int i = 0; i < action.getSalesOrderList().size(); i++) {
            InserirSalesOrder(action.getSalesOrderList().get(i));
        }

    }

    private void InserirSalesOrder(SalesOrder obj) throws SQLException {
        String sql = "Insert into SalesOrderList (idAction, Quantity, Value, StartTurn, EndTurn, IsFromPlayer)"
                + "values (?, ?, ?, ?, ?, ?)";
        stm = con.prepareStatement(sql);
        stm.setInt(1, obj.getAction().getId());
        stm.setInt(2, obj.getQuantity());
        stm.setDouble(3, obj.getValue());
        stm.setInt(4, obj.getStartTurn());
        stm.setInt(5, obj.getEndTurn());
        stm.setBoolean(6, obj.isIsFromPlayer());
        stm.executeUpdate();

    }

    public void alterarSalesOrderList(ArrayList<SalesOrder> listGame, int idAction) throws SQLException {
        ArrayList<SalesOrder> listdb = ListSalesOrder(idAction);
        for (int i = 0; i < listdb.size(); i++) {
            if (!listGame.contains(listdb.get(i))) {
                deletarSalesOrder(listdb.get(i));
            }
            for (int j = 0; j < listGame.size(); j++) {
                if (listGame.get(j).getId() == 0) {
                    InserirSalesOrder(listGame.get(j));
                } else {
                    alterarSalesOrder(listGame.get(j), idAction);
                }
            }
        }
    }

    private void alterarSalesOrder(SalesOrder obj, int idAction) throws SQLException {
        String sql = "update SalesOrderList set idAction = ?, Quantity = ?, Value = ?, StartTurn = ?, EndTurn = ?, IsFromPlayer = ? Where id = ?";

        stm = con.prepareStatement(sql);
        stm.setInt(1, idAction);
        stm.setDouble(2, obj.getQuantity());
        stm.setDouble(3, obj.getValue());
        stm.setInt(4, obj.getStartTurn());
        stm.setInt(5, obj.getEndTurn());
        stm.setBoolean(6, obj.isIsFromPlayer());
        stm.setInt(7, obj.getId());

        stm.executeUpdate();

    }

    private void deletarSalesOrder(SalesOrder obj) throws SQLException {
        String sql = "DELETE FROM SalesOrderList where id=?";
        stm = con.prepareStatement(sql);
        stm.setInt(1, obj.getId());

        stm.executeUpdate();
    }

    private ArrayList<SalesOrder> ListSalesOrder(int idAction) throws SQLException {
        try {
            ArrayList<SalesOrder> List = new ArrayList<SalesOrder>();

            String sql = "SELECT * FROM SalesOrderList WHERE idAction = ?";

            stm = con.prepareStatement(sql);
            stm.setInt(1, idAction);
            rs = stm.executeQuery();

            while (rs.next()) {
                List.add(new SalesOrder(rs.getInt(1), null, rs.getInt(3), rs.getDouble(4), rs.getInt(5), rs.getInt(6), rs.getBoolean(7)));
            }
            return List;
        } catch (SQLException e) {
            return null;
        }
    }

}
