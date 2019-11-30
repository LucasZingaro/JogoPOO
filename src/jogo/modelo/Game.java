package jogo.modelo;

/**
 * Representa a partida do jogo
 *
 * @author Lucas
 */
public class Game {

    /**
     * Identificador da partida
     *
     * @hidden savable
     */
    private int id;

    /**
     * Jogador da partida
     *
     * @hidden savable
     */
    private Player player;

    /**
     * Mercado da partida
     *
     * @hidden savable
     */
    private Market market;

    /**
     * Número do turno da partida
     *
     * @hidden savable
     */
    private int numTurn;

    /**
     * Construtor BD
     */
    public Game(int id, Player player, Market market, int numTurn) {
        this.id = id;
        this.player = player;
        this.market = market;
        this.numTurn = numTurn;
    }

    public Game(Player player, Market market, int numTurn) {
        this.player = player;
        this.market = market;
        this.numTurn = numTurn;
    }

    public Game(Player player, Market market) {
        this(player, market, 0);
    }

    public Game(Player player) {
        this(player, new Market());
    }

    /**
     * @deprecated Só para testes
     */
    public Game() {
        this(new Player("Teste"));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    public int getNumTurn() {
        return numTurn;
    }

    public void setNumTurn(int numTurn) {
        this.numTurn = numTurn;
    }

}
