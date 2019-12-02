package jogo.modelo;

import jogo.Util;
import java.util.ArrayList;
import jogo.Main;

/**
 * Representação do mercado financeiro.
 */
public class Market {

    /**
     * Identificador do mercado
     *
     * @hidden savable
     */
    private int id;

    /**
     * Valor da Inflação atual
     *
     * @see "É o último registro do histórico de valores da inflação"
     * @hidden unsavable
     */
    private float inflation;

    /**
     * Valor do CDI atual
     *
     * @hidden savable
     */
    private float cdi;

    /**
     * Valor da taxa SELIC Atual
     *
     * @hidden savable
     */
    private float selic;

    /**
     * Status ou tendência do mercado
     *
     * @hidden savable
     */
    private StatusEnum status;

    /**
     * Lista de ações do mercado
     *
     * @hidden savable
     */
    private ArrayList<Action> marketListActions;

    /**
     * Construtor do BD
     *
     * @param id
     * @param inflation
     * @param cdi
     * @param selic
     * @param status
     * @param marketListActions
     */
    public Market(int id, float inflation, float cdi, float selic,
            StatusEnum status, ArrayList<Action> marketListActions) {
        this.id = id;
        this.inflation = inflation;
        this.cdi = cdi;
        this.selic = selic;
        this.status = status;
        this.marketListActions = marketListActions;
    }

    public Market(float inflation, float cdi, float selic,
            StatusEnum status, ArrayList<Action> marketListActions) {

        this.inflation = Util.round(inflation, 2);
        this.cdi = Util.round(cdi, 2);
        this.selic = Util.round(selic, 2);
        this.status = status;
        this.marketListActions = marketListActions;
    }

    public Market() {
        this.inflation = Util.round(Market.generateInflation(), 2);

        this.selic = Util.round(Market.generateSelic(this.inflation), 2);

        this.cdi = Util.round(Market.calcCdi(selic), 2);

        this.status = StatusEnum.NEUTRAL;
        this.marketListActions = Market.generateMarketListActions(50);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getInflation() {
        return inflation;
    }

    public void setInflation(float inflation) {
        this.inflation = Util.round(inflation, 2);
    }

    public float getCdi() {
        return cdi;
    }

    public void setCdi(float cdi) {
        this.cdi = Util.round(cdi, 2);
    }

    public float getSelic() {
        return selic;
    }

    public void setSelic(float selic) {
        this.selic = Util.round(selic, 2);
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public ArrayList<Action> getMarketListActions() {
        return marketListActions;
    }

    public void setMarketListActions(ArrayList<Action> marketListActions) {
        this.marketListActions = marketListActions;
    }

    @Override
    public String toString() {
        return "Market{" + " id=" + id + ", inflation=" + inflation
                + ",\n    cdi=" + cdi
                + ",\n    selic=" + selic
                + ",\n    status=" + status
                + ",\n    marketListActions=" + marketListActions
                + "\n}";
    }

    public static float generateInflation() {
        return Float.parseFloat(String.valueOf(Util.generateValue(0.6, 20)));

    }

    public static float generateInflation(float inflation) {
        String s = String.valueOf(
                ((generateInflation() * generateInflation()) % (inflation * 2) + 0.01)
        );
        Util.tryCutString(s, 0, 10);
        return Float.parseFloat(s);
    }

    public static float generateSelic(float inflation) {
        String s = String.valueOf(
                (inflation + 0.01 + (Util.multGenerateValue(0.5, 5.0, 30)))
        );
        Util.tryCutString(s, 0, 10);
        return Float.parseFloat(s);
    }

    public static float calcSelic(float inflation, float selic) {
        String s = String.valueOf(inflation + 1
                + ((Util.multGenerateValue(0.5, 20.0, 256)
                + (selic - inflation - 1)) / (selic - inflation - 1)));
        Util.tryCutString(s, 0, 10);
        return Float.parseFloat(s);
    }

    public static float calcCdi(float selic) {
        return Float.parseFloat(String.valueOf(selic + Util.generateValue(0.1, 3)));
    }

    public static ArrayList<Action> generateMarketListActions(int i) {
        ArrayList<Action> list = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            list.add(new Action());
        }
        return list;
    }

    void passarTurno() {
        //Mercado->Ações
        this.getMarketListActions().forEach((action) -> {
            //Ações->Ordens de Compra
            ArrayList<PurchaseOrder> removeListPO = new ArrayList<>();
            action.getPurchaseOrderList().forEach((PurchaseOrder purchaseOrder) -> {
                try {
                    purchaseOrder.tryBuy(this);
                    if (purchaseOrder.getEndTurn() == Main.game.getNumTurn()) {
                        removeListPO.add(purchaseOrder);
                    }
                } catch (Exception e) {
                }
            });
            action.getPurchaseOrderList().removeAll(removeListPO);

            //Ações->Ordens de Venda
            ArrayList<SalesOrder> removeListSO = new ArrayList<>();
            action.getSalesOrderList().forEach((SalesOrder salesOrder) -> {
                try {
                    salesOrder.trySell(this);
                    if (salesOrder.getEndTurn() == Main.game.getNumTurn()) {
                        removeListSO.add(salesOrder);
                    }
                } catch (Exception e) {
                }
            });
            action.getSalesOrderList().removeAll(removeListSO);

            //Ações->turno
            action.passarTurno();
        });
        //status
        this.setStatus(status);
        //inflação
        this.setInflation(generateInflation(inflation));
        //selic
        this.setSelic(calcSelic(inflation, selic));
        //cdi
        this.setCdi(calcCdi(selic));
    }

}
