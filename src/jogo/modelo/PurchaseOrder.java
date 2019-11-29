package jogo.modelo;

/**
 * Representação da ordem de compra de uma ação
 *
 * @author Lucas
 */
public class PurchaseOrder extends Order {

    public PurchaseOrder(int id, Action Acao, int quantity, int value, int startTurn, int endTurn, boolean isFromPlayer) {
        super(id, Acao, quantity, value, startTurn, endTurn, isFromPlayer);
    }
    
    /*Methods...*/
}
