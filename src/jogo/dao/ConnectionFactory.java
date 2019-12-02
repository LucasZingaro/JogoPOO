package jogo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import jogo.Config;


/**
 * Classe para manipulação de conexões com o banco de dados
 *
 * @see Config
 */
public class ConnectionFactory {

    /**
     * Produz uma conexão com o banco de dados, seguindo as definições da
     * configuração.
     *
     * @return Conexão SQL
     * @throws SQLException
     *
     * @see Config
     */
    public Connection getConnection() throws SQLException {
        Connection con = null;
        try {
            Class.forName(Config.db_DRIVER);
            con = DriverManager.getConnection(
                    Config.db_ROOT,
                    Config.db_USER,
                    Config.db_PASSWORD
            );
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Problemas na conexão com a fonte de dados! " + e, "Banco da dados", JOptionPane.ERROR_MESSAGE);
        }
        return con;
    }

    /**
     * Testa a conexão com o banco de dados.
     *
     * @return Se a conexão está funcionando
     */
    public static boolean tryConnection() {
        Connection c;
        try {
            c = new ConnectionFactory().getConnection();
            c.close();
            return c.isClosed();
        } catch (SQLException e) {
            return false;
        }
    }

    /**
     * Fecha a conexão e seus derivados.
     *
     * @param con Conexão com o banco de dados
     * @param stmt Declaração de Queries SQL
     * @param rs Resultados de Queries SQL
     */
    public void closeConnection(Connection con, Statement stmt, ResultSet rs) {
        //Close the Statemant
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {}

        //Close the ResultSet
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {}

        //Close the Connection
        try {
            con.close();
        } catch (SQLException e) {}
    }
}
