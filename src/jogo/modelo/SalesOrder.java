package jogo.modelo;

/**
 * Representação da ordem de venda de uma ação
 *
 * @author Lucas
 */
public class SalesOrder extends Order {

    /**
     * Contrutor BD
     */
    public SalesOrder(int id, Action action, int quantity, double value, int startTurn, int endTurn, boolean isFromPlayer) {
        super(id, action, quantity, value, startTurn, endTurn, isFromPlayer);
    }

    public SalesOrder(Action action, int quantity, double value, int startTurn, int endTurn, boolean isFromPlayer) {
        super(action, quantity, value, startTurn, endTurn, isFromPlayer);
    }

    /*Methods...*/
    @Override
    public String toString() {
        return SalesOrder.class.getSimpleName() + super.toString();
    }

    void trySell(Market market) {
        System.out.println("Tentando Vender:" + this.toString());
    }
}
