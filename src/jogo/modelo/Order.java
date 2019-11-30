package jogo.modelo;

/**
 * Representação de Ordens para operações da ação financeira
 *
 * @author Lucas
 */
public abstract class Order {

    /**
     * Identificador da Operação
     *
     * @hidden savable
     */
    private int id;

    /**
     * Ação operada
     *
     * @see "Deve estár associada a lista de ações do Jogo"
     * @see Game
     * @hidden savable
     */
    private Action Action;

    /**
     * Quantidades de ações
     *
     * @hidden savable
     */
    private int quantity;

    /**
     * Valor da operação
     *
     * @hidden savable
     */
    private int value;

    /**
     * Turno inicial da Ordem
     *
     * @hidden savable
     */
    private int startTurn;

    /**
     * Turno final ou máximo da Ordem
     *
     * @hidden savable
     */
    private int endTurn;

    /**
     * Se esta ordem vem de um Jogador
     *
     * @hidden savable
     */
    private boolean isFromPlayer;

    /**
     * Construtor BD
     */
    public Order(int id, Action action, int quantity, int value, int startTurn, int endTurn, boolean isFromPlayer) {
        this.id = id;
        this.Action = action;
        this.quantity = quantity;
        this.value = value;
        this.startTurn = startTurn;
        this.endTurn = endTurn;
        this.isFromPlayer = isFromPlayer;
    }

    public Order(Action Action, int quantity, int value, int startTurn, int endTurn, boolean isFromPlayer) {
        this.Action = Action;
        this.quantity = quantity;
        this.value = value;
        this.startTurn = startTurn;
        this.endTurn = endTurn;
        this.isFromPlayer = isFromPlayer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Action getAction() {
        return Action;
    }

    public void setAction(Action Action) {
        this.Action = Action;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getStartTurn() {
        return startTurn;
    }

    public void setStartTurn(int startTurn) {
        this.startTurn = startTurn;
    }

    public int getEndTurn() {
        return endTurn;
    }

    public void setEndTurn(int endTurn) {
        this.endTurn = endTurn;
    }

    public boolean isIsFromPlayer() {
        return isFromPlayer;
    }

    public void setIsFromPlayer(boolean isFromPlayer) {
        this.isFromPlayer = isFromPlayer;
    }

}
