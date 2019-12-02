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
import jogo.modelo.Loan;

/**
 *
 * @author MukaFelix
 */
public class LoanDAO implements IDAO<Loan> {

    private Connection con = null;
    private ConnectionFactory dao;
    private PreparedStatement stm;
    private ResultSet rs;

    //contrutor para conexão com o DB
    public LoanDAO() {
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
    public void inserir(Loan obj, int id) throws SQLException {
        String sql = "Insert into Loan (idMatch, Value, Interest, StartTurn)"
                + "values (?, ?, ?, ?)";
        stm = con.prepareStatement(sql);
        stm.setInt(1, id);
        stm.setDouble(2, obj.getValue());
        stm.setDouble(3, obj.getInterest());
        stm.setInt(4, obj.getStartTurn());

        stm.executeUpdate();
    }

    public void inserir(ArrayList<Loan> list, int id) throws SQLException {
        for (Loan obj : list) {

            String sql = "Insert into Loan (idMatch, Value, Interest, StartTurn)"
                    + "values (?, ?, ?, ?)";
            stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            stm.setDouble(2, obj.getValue());
            stm.setDouble(3, obj.getInterest());
            stm.setInt(4, obj.getStartTurn());

            stm.executeUpdate();
        }
    }

    @Override
    public void alterar(Loan obj) throws SQLException {
        String sql = "update Loan set idMatch = ?, Value = ?, Interest = ?, StartTurn = ? WHERE idMatch = ?";
        stm = con.prepareStatement(sql);
        stm.setInt(1, obj.getId());
        stm.setDouble(2, obj.getValue());
        stm.setDouble(3, obj.getInterest());
        stm.setInt(4, obj.getStartTurn());
        stm.setInt(5, obj.getId());

        stm.executeUpdate();
    }

    @Override
    public void excluir(Loan obj) throws SQLException {
        String sql = "DELETE FROM Loan where idMatch=?";
        stm = con.prepareStatement(sql);
        stm.setInt(1, obj.getId());

        stm.executeUpdate();
    }

    public ArrayList<Loan> ListarLoan(int id) throws SQLException {
        try {
            ArrayList<Loan> loans = new ArrayList<Loan>();

            String sql = "SELECT * FROM Loan WHERE idMatch = ?";

            stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            rs = stm.executeQuery();

            while (rs.next()) {
                loans.add(new Loan(rs.getInt(1), rs.getDouble(3), rs.getDouble(4), rs.getInt(5)));
            }
            return loans;
        } catch (SQLException e) {
            return null;
        }
    }

    public Loan LocalizarLoan(int id) throws SQLException {
        try {
            String sql = "SELECT * from Loan where idMatch = ?";

            stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            rs = stm.executeQuery();

            rs.next();

            Loan loan = new Loan(rs.getInt(1), rs.getDouble(3), rs.getDouble(4), rs.getInt(5));
            return loan;
        } catch (SQLException e) {
            return null;
        }
    }
}
