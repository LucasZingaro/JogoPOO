/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author MukaFelix
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
        String sql = "Insert into Action (idMatch, Name, MarketQuantity, PlayerQuantity)"
                + "values (?, ?, ?, ?)";
        stm = con.prepareStatement(sql);
        stm.setInt(1, idMatch);
        stm.setString(2, obj.getName());
        stm.setDouble(3, obj.getMarketQuantity());
        stm.setDouble(4, obj.getPlayerQuantity());

        stm.executeUpdate();

        InserirValueHistory(obj);
        InserirVariationHistory(obj);
        InserirPurchaseOrderList(obj);
        InserirSalesOrderList(obj);
    }

    public void alterar(Action obj) throws SQLException {
        String sql = "update Action set Name=?, Status = ?,MarketQuantity=?, PlayerQuantity=?"
                + "where id=?";

        stm = con.prepareStatement(sql);
        stm.setString(1, obj.getName());
        stm.setString(2, obj.getStatus().toString());
        stm.setDouble(3, obj.getMarketQuantity());
        stm.setDouble(4, obj.getPlayerQuantity());
        stm.setInt(5, obj.getId());

        stm.executeUpdate();

    }

    public void excluir(Action obj) throws SQLException {
        String sql = "DELETE FROM Action where codigo=?";
        stm = con.prepareStatement(sql);
        stm.setInt(1, obj.getId());

        stm.executeUpdate();

    }

    public ArrayList<Action> listaActions() throws SQLException {
        ArrayList<Action> actions = new ArrayList<Action>();

        String sql = "SELECT * FROM Action";

        stm = con.prepareStatement(sql);
        rs = stm.executeQuery();

        while (rs.next()) {
            actions.add(new Action(rs.getInt(2), rs.getString(3), StatusEnum.parseStatusEnum(rs.getString(4)),
                    ListValueHistory(rs.getInt(2)), ListVariationHistory(rs.getInt(2)), rs.getDouble(5),
                    rs.getDouble(6), ListPurchaseOrder(rs.getInt(2)), ListSalesOrder(rs.getInt(2))));
        }
        return actions;
    }

    //ValueHistory
    private void InserirValueHistory(Action action) throws SQLException {
        String sql = "Insert into ValueHistory (idAction, Value)"
                + "values (?, ?)";
        stm = con.prepareStatement(sql);
        for (int i = 0; i < action.getValueHistory().size(); i++) {
            stm.setInt(1, action.getId());
            stm.setDouble(2, action.getValueHistory().get(i));
            stm.executeUpdate();
        }

    }

    private ArrayList<Double> ListValueHistory(int idAction) throws SQLException {
        ArrayList<Double> history = new ArrayList<Double>();

        String sql = "SELECT * FROM ValueHistory WHERE idAction = ?";

        stm = con.prepareStatement(sql);
        stm.setInt(1, idAction);
        rs = stm.executeQuery();

        while (rs.next()) {
            history.add(rs.getDouble(3));
        }
        return history;
    }

    //variationHistory
    private void InserirVariationHistory(Action action) throws SQLException {
        String sql = "Insert into VariationHistory (idAction, Value)"
                + "values (?, ?)";
        stm = con.prepareStatement(sql);
        for (int i = 0; i < action.getValueHistory().size(); i++) {
            stm.setInt(1, action.getId());
            stm.setDouble(2, action.getValueHistory().get(i));
            stm.executeUpdate();
        }

    }

    private ArrayList<Double> ListVariationHistory(int idAction) throws SQLException {
        ArrayList<Double> history = new ArrayList<Double>();

        String sql = "SELECT * FROM VariationHistory WHERE idAction = ?";

        stm = con.prepareStatement(sql);
        stm.setInt(1, idAction);
        rs = stm.executeQuery();

        while (rs.next()) {
            history.add(rs.getDouble(3));
        }
        return history;
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
        /*for (int i = 0; i < listdb.size(); i++) {
            int contador = 0;
            for (int j = 0; j < listGame.size(); j++) {
                if (listdb.get(i).getId() == listGame.get(j).getId()) {
                   alterarPurchaseOrder(listGame.get(j),idAction);
                }else if(listGame.get(j).getId() == 0){
                    InserirPurchaseOrder(listGame.get(j));
                }else{
                    contador++;
                }
            }
            if(contador == listGame.size()){
                
            }
        }*/

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
        ArrayList<PurchaseOrder> List = new ArrayList<PurchaseOrder>();

        String sql = "SELECT * FROM PurchaseOrderList WHERE idAction = ?";

        stm = con.prepareStatement(sql);
        stm.setInt(1, idAction);
        rs = stm.executeQuery();

        while (rs.next()) {
            List.add(new PurchaseOrder(rs.getInt(1), null, rs.getInt(3), rs.getDouble(4), rs.getInt(5), rs.getInt(6), rs.getBoolean(7)));
        }
        return List;
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
        ArrayList<SalesOrder> List = new ArrayList<SalesOrder>();

        String sql = "SELECT * FROM SalesOrderList WHERE idAction = ?";

        stm = con.prepareStatement(sql);
        stm.setInt(1, idAction);
        rs = stm.executeQuery();

        while (rs.next()) {
            List.add(new SalesOrder(rs.getInt(1), null, rs.getInt(3), rs.getDouble(4), rs.getInt(5), rs.getInt(6), rs.getBoolean(7)));
        }
        return List;
    }

}
