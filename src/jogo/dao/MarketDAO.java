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
import jogo.modelo.Market;
import jogo.modelo.StatusEnum;

/**
 *
 * @author MukaFelix
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
    public void inserir(Market obj) throws SQLException {
        String sql = "Insert into Market (idMatch, Status)"
                + "values (?, ?)";
        stm = con.prepareStatement(sql);
        stm.setInt(1, obj.getId());
        stm.setString(2, obj.getStatus().toString());

        stm.executeUpdate();

        inserirInflationHistory(obj);
        inserirCdiHistory(obj);
        inserirSelicHistory(obj);
    }

    @Override
    public void alterar(Market obj) throws SQLException {
        String sql = "update Market set idMatch = ?, Status = ? WHERE idMatch = ?";
        stm = con.prepareStatement(sql);
        stm.setInt(1, obj.getId());
        stm.setString(2, obj.getStatus().toString());
        stm.setInt(3, obj.getId());
        stm.executeUpdate();
    }

    @Override
    public void excluir(Market obj) throws SQLException {
        String sql = "DELETE FROM Market where idMatch=?";
        stm = con.prepareStatement(sql);
        stm.setInt(1, obj.getId());

        stm.executeUpdate();
        excluirCdiHistory(obj);
        excluirInflationHistory(obj);
        excluirSelicHistory(obj);
    }

    public Market localizarMarket(int id) throws SQLException {

        String sql = "SELECT * from Market where idMatch = ?";

        stm = con.prepareStatement(sql);
        stm.setInt(1, id);
        rs = stm.executeQuery();

        rs.next();
        
        ActionDAO action = new ActionDAO();

        Market market = new Market(rs.getInt(1),inflationHistoryList(id),cdiHistoryList(id),selicHistoryList(id),StatusEnum.parseStatusEnum(rs.getString(2)),action.listaActions());
        return market;

    }

    //inflationHistory
    private void inserirInflationHistory(Market obj) throws SQLException {
        String sql = "Insert into inflationHistory (idMatch, Inflation)"
                + "values (?, ?)";
        stm = con.prepareStatement(sql);
        stm.setInt(1, obj.getId());

        for (int i = 0; i < obj.getInflationHistory().size(); i++) {
            stm.setDouble(2, obj.getInflationHistory().get(i));
            stm.executeUpdate();
        }
    }

    private void excluirInflationHistory(Market obj) throws SQLException {
        String sql = "DELETE FROM inflationHistory WHERE idMatch = ?";
        stm = con.prepareStatement(sql);
        stm.setInt(1, obj.getId());

        stm.executeUpdate();
    }

    private ArrayList<Float> inflationHistoryList(int id) throws SQLException {
        ArrayList<Float> History = new ArrayList<Float>();

        String sql = "SELECT * FROM historyList WHERE idMatch = ?";

        stm = con.prepareStatement(sql);
        stm.setInt(1, id);
        rs = stm.executeQuery();

        while (rs.next()) {
            History.add(rs.getFloat(2));
        }
        return History;
    }
    /*private void alterarInflationHistory(Market obj) throws SQLException {
        String sql = "update inflationHistory set (idMatch, Inflation)"
                + "values (?, ?)";
        stm = con.prepareStatement(sql);
        stm.setInt(1, obj.getId());
        
        for (int i = 0; i < obj.getInflationHistory().size(); i++) {
            stm.setDouble(2, obj.getInflationHistory().get(i));
            stm.executeUpdate();
        }
    }*/
    //cdiHistory
    private void inserirCdiHistory(Market obj) throws SQLException {
        String sql = "Insert into cdiHistory(idMatch, CDI)"
                + "values (?, ?)";
        stm = con.prepareStatement(sql);
        stm.setInt(1, obj.getId());

        for (int i = 0; i < obj.getCdiHistory().size(); i++) {
            stm.setDouble(2, obj.getInflationHistory().get(i));
            stm.executeUpdate();
        }
    }

    private void excluirCdiHistory(Market obj) throws SQLException {
        String sql = "DELETE FROM cdiHistory WHERE idMatch=?";
        stm = con.prepareStatement(sql);
        stm.setInt(1, obj.getId());

        stm.executeUpdate();
    }
    
    private ArrayList<Float> cdiHistoryList(int id) throws SQLException {
        ArrayList<Float> History = new ArrayList<Float>();

        String sql = "SELECT * FROM cdiHistory WHERE idMatch = ?";

        stm = con.prepareStatement(sql);
        stm.setInt(1, id);
        rs = stm.executeQuery();

        while (rs.next()) {
            History.add(rs.getFloat(2));
        }
        return History;
    }

    //selicHistory
    private void inserirSelicHistory(Market obj) throws SQLException {
        String sql = "Insert into selicHistory(idMatch, Selic)"
                + "values (?, ?)";
        stm = con.prepareStatement(sql);
        stm.setInt(1, obj.getId());

        for (int i = 0; i < obj.getSelicHistory().size(); i++) {
            stm.setDouble(2, obj.getSelicHistory().get(i));
            stm.executeUpdate();
        }
    }

    private void excluirSelicHistory(Market obj) throws SQLException {
        String sql = "DELETE FROM selicHistory where idMatch=?";
        stm = con.prepareStatement(sql);
        stm.setInt(1, obj.getId());

        stm.executeUpdate();
    }
    
     private ArrayList<Float> selicHistoryList(int id) throws SQLException {
        ArrayList<Float> History = new ArrayList<Float>();

        String sql = "SELECT * FROM selicHistory WHERE idMatch = ?";

        stm = con.prepareStatement(sql);
        stm.setInt(1, id);
        rs = stm.executeQuery();

        while (rs.next()) {
            History.add(rs.getFloat(2));
        }
        return History;
    }
}
