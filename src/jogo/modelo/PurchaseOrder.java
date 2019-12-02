package jogo.modelo;

import jogo.Main;
import jogo.Util;

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
        return "\nOrdem de Compra: {"
                + "\n Quantidade:" + getQuantity()
                + "\n valor: R$ " + getValue()
                + "\n Turno inicial:" + getStartTurn()
                + "\n Turno final:" + getEndTurn()
                + "\n}";
    }

    void tryBuy(Market market) {
        if (getQuantity() <= 0) {
            setQuantity(0);
            return;
        }
        boolean isSucess = false;
        double chance = 0.5 + Util.round((this.getAction().getValue() / this.getValue()) - 1, 2);
        isSucess = (Util.generateValue(0, 1) <= chance);
        if (isSucess) {
            double pMoney = Main.game.getPlayer().getMoney();

            //clac qtdMax
            int qtdMax = (int) (pMoney / getValue());
            if (qtdMax >= getQuantity()) {
                qtdMax = (int) getQuantity();
            }

            //qtd comprada
            int qtd = (int) Util.generateValue(1, qtdMax);

            //calc money
            pMoney -= Util.round((qtd * getValue()), 2);
            double pQtd = this.getAction().getPlayerQuantity();
            //definir quantidade final
            this.setQuantity(getQuantity() - qtd);
            this.getAction().setPlayerQuantity(pQtd + qtd);

            //definir dinheiro final
            Main.game.getPlayer().setMoney(pMoney);
        }
    }

}
