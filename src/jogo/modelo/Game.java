package jogo.modelo;

/**
 * Representa a partida do jogo
 *
 * @author Lucas
 */
public class Game {
    

    /**
     * Identificador da partida
     */
    private int id;

    /**
     * Jogador da partida
     */
    private Player player;

    /**
     * Mercado da partida
     */
    private Market market;

    /**
     * Número do turno da partida
     */
    private int numTurn;

    public Game(Player player, Market market, int numTurn) {
        this.player = player;
        this.market = market;
        this.numTurn = numTurn;
    }

    public Game() {

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
