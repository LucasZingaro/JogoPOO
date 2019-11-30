package jogo.modelo;

/**
 * Representação da ordem de compra de uma ação
 *
 * @author Lucas
 */
public class PurchaseOrder extends Order {

    /**
     * Contrutor BD
     */
    public PurchaseOrder(int id, Action action, int quantity, int value, int startTurn, int endTurn, boolean isFromPlayer) {
        super(id, action, quantity, value, startTurn, endTurn, isFromPlayer);
    }

    public PurchaseOrder(Action action, int quantity, int value, int startTurn, int endTurn, boolean isFromPlayer) {
        super(action, quantity, value, startTurn, endTurn, isFromPlayer);
    }

    /*Methods...*/
}
