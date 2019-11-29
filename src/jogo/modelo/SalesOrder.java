package jogo.modelo;

/**
 * Representação da ordem de venda de uma ação
 *
 * @author Lucas
 */
public class SalesOrder extends Order {

    public SalesOrder(int id, Action Acao, int quantity, int value, int startTurn, int endTurn, boolean isFromPlayer) {
        super(id, Acao, quantity, value, startTurn, endTurn, isFromPlayer);
    }

    /*Methods...*/
}
