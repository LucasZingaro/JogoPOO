package jogo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jogo.modelo.FixedIncome;
import jogo.modelo.Player;

/**
 * DAO Player
 * @see Player
 */
public class PlayerDAO implements IDAO<Player> {

    private Connection con = null;
    private ConnectionFactory dao;
    private PreparedStatement stm;
    private ResultSet rs;

    //contrutor para conexão com o DB
    public PlayerDAO() {
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
    public void inserir(Player obj, int id) throws SQLException {
        String sql = "Insert into Player (idMatch, name, Money, Income)"
                + "values (?, ?, ?, ?)";
        stm = con.prepareStatement(sql);
        stm.setInt(1, id);
        stm.setString(2, obj.getName());
        stm.setDouble(3, obj.getMoney());
        stm.setDouble(4, obj.getFixedIncome().getValue());

        stm.executeUpdate();
    }

    @Override
    public void alterar(Player obj) throws SQLException {
        String sql = "update Player set name = ?, Money = ?, Income = ? WHERE idMatch = ?";
        stm = con.prepareStatement(sql);
        stm.setString(1, obj.getName());
        stm.setDouble(2, obj.getMoney());
        stm.setDouble(3, obj.getFixedIncome().getValue());
        stm.setInt(4, obj.getId());

        stm.executeUpdate();

    }

    @Override
    public void excluir(Player obj) throws SQLException {
        String sql = "DELETE FROM Player where idMatch=?";
        stm = con.prepareStatement(sql);
        stm.setInt(1, obj.getId());

        stm.executeUpdate();
    }

    public Player LocalizarPlayer(int id) throws SQLException {
        try {
            String sql = "SELECT * from Player where idMatch = ?";

            stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            rs = stm.executeQuery();

            rs.next();

            LoanDAO loan = new LoanDAO();

            Player player = new Player(rs.getInt(1), rs.getString(2), rs.getDouble(3), loan.ListarLoan(id), new FixedIncome(rs.getInt(1), rs.getDouble(4)));
            return player;
        } catch (SQLException e) {
            return null;
        }
    }
}
