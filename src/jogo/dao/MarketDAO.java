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
import jogo.modelo.Market;

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

    }

    @Override
    public void alterar(Market obj) throws SQLException {
        String sql = "update Market set (idMatch, Status)"
                + "values (?, ?)";
        stm = con.prepareStatement(sql);
        stm.setInt(1, obj.getId());
        stm.setString(2, obj.getStatus().toString());
        stm.executeUpdate();
    }

    @Override
    public void excluir(Market obj) throws SQLException {
        String sql = "DELETE FROM Market where idMatch=?";
        stm = con.prepareStatement(sql);
        stm.setInt(1, obj.getId());

        stm.executeUpdate();
    }

    public Market LocalizarPlayer(int id) throws SQLException {

        String sql = "SELECT * from Player where idMatch = ?";

        stm = con.prepareStatement(sql);
        stm.setInt(1, id);
        rs = stm.executeQuery();

        rs.next();

        Market market = new Market();
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

    //cdiHistory
    //selicHistory
}
