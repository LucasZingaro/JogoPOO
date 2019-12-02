package jogo;

/**
 * Configurações do Jogo
 *
 * @author Lucas
 */
public abstract class Config {

    /**
     * Numero máximo de turnos
     */
    public static final int MAX_TURN = 100;
    /**
     * Tamanho máximo do nome do jogador
     */
    public static final int MAX_SIZE_PLAYER_NAME = 64;

    /**
     * Driver do banco de dados
     */
    public static String db_DRIVER = "com.mysql.jdbc.Driver";

    /** Link base de acesso ao banco de dados*/
    public static String db_ROOT = "jdbc:mysql://localhost:3306/jogo_poo";
    /** Nome do banco de dados*/
    public static String db_NAME = "jogo_poo";
    /** Nome de usuário do banco de dados*/
    public static String db_USER = "root";
    /** Senha do usuário do banco de dados*/
    public static String db_PASSWORD = "";
    
    /** Atraso na recuperação de renda fixa (em Turnos)*/
    public static final int FIXED_INCOME_RECOVERY_DELAY = 1;
    public static final double INITIAL_PLAYER_MONEY = 25000.00;

}
