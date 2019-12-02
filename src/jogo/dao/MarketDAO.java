package jogo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import jogo.modelo.Market;
import jogo.modelo.StatusEnum;

/**
 * DAO Market
 *
 * @see Market
 */
public class MarketDAO implements IDAO<Market> {

    private Connection con = null;
    private ConnectionFactory dao;
    private PreparedStatement stm;
    private ResultSet rs;

    //contrutor para conexão com o DB
    public MarketDAO() {
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

    @Override
    public void inserir(Market obj, int id) throws SQLException {
        String sql = "Insert into Market (idMatch, inflation, cdi, selic, Status)"
                + "values (?, ?)";
        stm = con.prepareStatement(sql);
        stm.setInt(1, id);
        stm.setFloat(2, obj.getInflation());
        stm.setFloat(3, obj.getCdi());
        stm.setFloat(4, obj.getSelic());
        stm.setString(5, obj.getStatus().toString());

        stm.executeUpdate();

    }

    @Override
    public void alterar(Market obj) throws SQLException {
        String sql = "update Market set idMatch = ?, inflation = ?, cdi = ?, selic = ?, Status = ? WHERE idMatch = ?";
        stm = con.prepareStatement(sql);
        stm.setInt(1, obj.getId());
        stm.setFloat(2, obj.getInflation());
        stm.setFloat(3, obj.getCdi());
        stm.setFloat(4, obj.getSelic());
        stm.setString(5, obj.getStatus().toString());
        stm.setInt(6, obj.getId());
        stm.executeUpdate();
    }

    @Override
    public void excluir(Market obj) throws SQLException {
        String sql = "DELETE FROM Market where idMatch=?";
        stm = con.prepareStatement(sql);
        stm.setInt(1, obj.getId());

        stm.executeUpdate();
    }

    public Market localizarMarket(int id) throws SQLException {
        //try {
            String sql = "SELECT * from Market where idMatch = ?";

            stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            rs = stm.executeQuery();

            rs.next();

            ActionDAO action = new ActionDAO();


            Market market = new Market(rs.getInt(1), rs.getFloat(2),rs.getFloat(3),rs.getFloat(4),StatusEnum.parseStatusEnum(rs.getString(5)), action.listaActions(id));
            System.out.println(market);
            return market;
        /*} catch (SQLException e) {
            System.err.println(e);
            return null;
        }*/
    }
}


