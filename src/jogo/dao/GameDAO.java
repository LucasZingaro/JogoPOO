package jogo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jogo.modelo.Game;

/**
 * DAO Game
 *
 * @see Game
 */
public class GameDAO {


    private Connection con = null;
    private ConnectionFactory dao;
    private PreparedStatement stm;
    private ResultSet rs;

    //contrutor para conexão com o DB
    public GameDAO() {
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

    public void inserir(Game obj) throws SQLException {
        String sql = "Insert into Game (NumTurn) values (?)";
        stm = con.prepareStatement(sql);

        stm.setInt(1, obj.getNumTurn());

        stm.executeUpdate();

        sql = "Select idMatch FROM Game";
        stm = con.prepareStatement(sql);

        rs = stm.executeQuery();
        rs.last();
        int id = rs.getInt(1);

        PlayerDAO player = new PlayerDAO();
        player.inserir(obj.getPlayer(), id);

        MarketDAO market = new MarketDAO();
        market.inserir(obj.getMarket(), id);

        ActionDAO action = new ActionDAO();
        action.inserir(obj.getMarket().getMarketListActions(), id);

        LoanDAO loan = new LoanDAO();
        loan.inserir(obj.getPlayer().getLoanList(), id);

    }

    public void alterar(Game obj) throws SQLException {
        String sql = "update Game set NumTurn = ? WHERE idMatch = ?";
        stm = con.prepareStatement(sql);
        stm.setInt(1, obj.getNumTurn());
        stm.setInt(2, obj.getId());

        stm.executeUpdate();
    }

    public void excluir(Game obj) throws SQLException {
        String sql = "DELETE FROM Game where idMatch=?";
        stm = con.prepareStatement(sql);
        stm.setInt(1, obj.getId());

        stm.executeUpdate();
    }
    
    public Game localizarGame(int id) throws SQLException {
        try {
            String sql = "SELECT * FROM Game WHERE idMatch = ?";
            stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            rs = stm.executeQuery();

            rs.next();

            PlayerDAO player = new PlayerDAO();
            MarketDAO maket = new MarketDAO();

            Game game = new Game(rs.getInt(1), player.LocalizarPlayer(id), maket.localizarMarket(id), rs.getInt(2));
            return game;
        } catch (SQLException e) {
            return null;
        }
    }
}
