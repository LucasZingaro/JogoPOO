package jogo;

/**
 * Configurações do Jogo
 *
 * @author Lucas
 */
public abstract class Config {
    /** Numero máximo de turnos*/
    public static final int MAX_TURN = 100;
    /** Tamanho máximo do nome do jogador*/
    public static final int MAX_SIZE_PLAYER_NAME = 64;

    /** Link base de acesso ao banco de dados*/
    public static String db_ROOT = "localhost:3307";
    /** Nome do banco de dados*/
    public static String db_NAME = "economygamedb";
    /** Nome de usuário do banco de dados*/
    public static String db_USER = "root";
    /** Senha do usuário do banco de dados*/
    public static String db_PASSWORD = "root";
    
    /** Atraso na recuperação de renda fixa (em Turnos)*/
    public static int FIXED_INCOME_RECOVERY_DELAY = 3;
}
