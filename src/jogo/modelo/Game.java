package jogo.modelo;

import java.util.ArrayList;

/**
 * Representa a partida do jogo
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
        this(player, market, 1);
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

    @Override
    public String toString() {
        return "Game{"
                + " \n    id=" + id
                + ",\n    player=" + player
                + ",\n    market=" + market
                + ",\n    numTurn=" + numTurn
                + "\n}";
    }

    public void passarTurno() {
        //player passar turno
        this.getPlayer().passarTurno();
        
        //mercado passar turno
        this.getMarket().passarTurno();

        //player->actionlist
        this.refazerPlayerListAction(
                this.getPlayer().getPlayerListActions(),
                this.getMarket().getMarketListActions());

        //numTurn
        this.setNumTurn(this.getNumTurn() + 1);
    }

    private void refazerPlayerListAction(ArrayList<Action> playerListActions, ArrayList<Action> marketListActions) {
        playerListActions.clear();

        marketListActions.forEach((Action action) -> {
            if (action.getPlayerQuantity() > 0) {
                playerListActions.add(action);
            }
        });
    }
}
