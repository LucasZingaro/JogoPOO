package jogo.modelo;

/**
 * Representação da ordem de compra de uma ação.
 */
public class PurchaseOrder extends Order {

    /**
     * Contrutor BD
     */
    public PurchaseOrder(int id, Action action, int quantity, double value, int startTurn, int endTurn, boolean isFromPlayer) {
        super(id, action, quantity, value, startTurn, endTurn, isFromPlayer);
    }

    public PurchaseOrder(Action action, int quantity, double value, int startTurn, int endTurn, boolean isFromPlayer) {
        super(action, quantity, value, startTurn, endTurn, isFromPlayer);
    }

    public PurchaseOrder(jogo.modelo.Action Action, int endTurn, boolean isFromPlayer) {
        super(Action, endTurn, isFromPlayer);
    }
    
    
    

    /*Methods...*/
    @Override
    public String toString() {
        return PurchaseOrder.class.getSimpleName() + super.toString();
    }

    void tryBuy(Market market) {
//        System.out.println("Tentando Comprar:" + this.toString());
    }

}
