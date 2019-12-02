package jogo.modelo;

import jogo.Main;
import jogo.Util;

/**
 * Representação da ordem de venda de uma ação.
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

    SalesOrder(jogo.modelo.Action action, int endTurn, boolean isFromPayer) {
        super(action, endTurn, isFromPayer);
    }

    /*Methods...*/
    @Override
    public String toString() {
        return SalesOrder.class.getSimpleName() + super.toString();
    }

    void trySell(Market market) {
        if (getQuantity() <= 0) {
            setQuantity(0);
            return;
        }
        boolean isSucess = false;
        double chance = 0.5 + Util.round((this.getValue() / this.getAction().getValue()) - 1, 2);
        isSucess = (Util.generateValue(0, 1) <= chance);
        if (isSucess) {
            double pMoney = Main.game.getPlayer().getMoney();

            //clac qtdMax
            int qtdMax = (int) this.getAction().getPlayerQuantity();
            qtdMax = (qtdMax > this.getQuantity()) ? (this.getQuantity()) : (qtdMax);

            //qtd vender
            int qtd = (int) Util.round(Util.generateValue(1, qtdMax), 0);

            //calc money
            pMoney += (qtd * getValue());
            double pQtd = this.getAction().getPlayerQuantity();

            //definir quantidade final
            this.setQuantity(getQuantity() - qtd);
            this.getAction().setPlayerQuantity(pQtd - qtd);

            //definir dinheiro final
            Main.game.getPlayer().setMoney(pMoney);
        }
    }
}
