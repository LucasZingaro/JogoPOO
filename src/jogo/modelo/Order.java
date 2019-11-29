package jogo.modelo;

/**
 * Representação de Ordens para operações da ação financeira
 *
 * @author Lucas
 */
public abstract class Order {

    /**
     * Identificador da Operação
     */
    private int id;

    /**
     * Ação operada
     */
    private Action Acao;

    /**
     * Quantidades de ações
     */
    private int quantity;

    /**
     * Valor da operação
     */
    private int value;

    /**
     * Turno inicial da Ordem
     */
    private int startTurn;

    /**
     * Turno final ou máximo da Ordem
     */
    private int endTurn;

    /**
     * Se esta ordem vem de um Jogador
     */
    private boolean isFromPlayer;

    public Order(int id, Action Acao, int quantity, int value, int startTurn, int endTurn, boolean isFromPlayer) {
        this.id = id;
        this.Acao = Acao;
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

    public Action getAcao() {
        return Acao;
    }

    public void setAcao(Action Acao) {
        this.Acao = Acao;
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
