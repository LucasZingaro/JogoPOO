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
import jogo.modelo.Game;

/**
 *
 * @author MukaFelix
 */
public class GameDAO implements IDAO<Game>{

    private Connection con = null;
    private ConnectionFactory dao;
    private PreparedStatement stm;
    private ResultSet rs;

    //contrutor para conexão com o DB
    public GameDAO(){
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
    public void inserir(Game obj) throws SQLException {
        String sql = "Insert into Game (NumTurn)"
                + "values (?)";
        stm = con.prepareStatement(sql);
        stm.setInt(1, obj.getNumTurn());

        stm.executeUpdate();
    }

    @Override
    public void alterar(Game obj) throws SQLException {
        String sql = "update Game set NumTurn = ? WHERE idMatch = ?";
        stm = con.prepareStatement(sql);
        stm.setInt(1, obj.getNumTurn());
        stm.setInt(2, obj.getId());
        
        stm.executeUpdate();
    }

    @Override
    public void excluir(Game obj) throws SQLException {
        String sql = "DELETE FROM Game where idMatch=?";
        stm = con.prepareStatement(sql);
        stm.setInt(1, obj.getId());

        stm.executeUpdate();
    }
    
}
