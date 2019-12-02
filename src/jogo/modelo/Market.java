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
     * Histórico de valores da inflação
     *
     * @hidden savable
     */
    private ArrayList<Float> inflationHistory;

    /**
     * Valor do CDI atual
     *
     * @see "É o último registro do histórico de valores do CDI"
     * @hidden unsavable
     */
    private float cdi;

    /**
     * Histórico de valores do CDI
     *
     * @hidden savable
     */
    private ArrayList<Float> cdiHistory;

    /**
     * Valor da taxa SELIC Atual
     *
     * @see "É o último registro do histórico de valores da SELIC"
     * @hidden unsavable
     */
    private float selic;

    /**
     * Histórico de valores da SELIC
     *
     * @hidden savable
     */
    private ArrayList<Float> selicHistory;

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
     */
    public Market(int id, ArrayList<Float> inflationHistory, ArrayList<Float> cdiHistory, ArrayList<Float> selicHistory, StatusEnum status, ArrayList<Action> marketListActions) {
        this.id = id;
        this.inflation = inflationHistory.get(inflationHistory.size() - 1);
        this.inflationHistory = inflationHistory;
        this.cdi = cdiHistory.get(cdiHistory.size() - 1);
        this.cdiHistory = cdiHistory;
        this.selic = selicHistory.get(selicHistory.size() - 1);
        this.selicHistory = selicHistory;
        this.status = status;
        this.marketListActions = marketListActions;
    }

    public Market(float inflation, ArrayList<Float> inflationHistory, float cdi,
            ArrayList<Float> cdiHistory, float selic, ArrayList<Float> selicHistory,
            StatusEnum status, ArrayList<Action> marketListActions) {

        this.inflation = Util.round(inflation, 2);
        this.inflationHistory = inflationHistory;
        this.cdi = Util.round(cdi, 2);
        this.cdiHistory = cdiHistory;
        this.selic = Util.round(selic, 2);
        this.selicHistory = selicHistory;
        this.status = status;
        this.marketListActions = marketListActions;
    }

    public Market(float inflation, float cdi, float selic, StatusEnum status,
            ArrayList<Action> listActions) {

        this(inflation, new ArrayList<>(),
                cdi, new ArrayList<>(),
                selic, new ArrayList<>(),
                status, listActions);
    }

    public Market() {
        this.inflation = Util.round(Market.generateInflation(), 2);
        this.inflationHistory = new ArrayList<>();
        this.inflationHistory.add(this.inflation);

        this.selic = Util.round(Market.generateSelic(this.inflation), 2);
        this.selicHistory = new ArrayList<>();
        this.selicHistory.add(this.selic);

        this.cdi = Util.round(Market.calcCdi(selic), 2);
        this.cdiHistory = new ArrayList<>();
        this.cdiHistory.add(this.cdi);

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
        inflationHistory.add(this.getInflation());
    }

    public ArrayList<Float> getInflationHistory() {
        return inflationHistory;
    }

    public void setInflationHistory(ArrayList<Float> inflationHistory) {
        this.inflationHistory = inflationHistory;
    }

    public float getCdi() {
        return cdi;
    }

    public void setCdi(float cdi) {
        this.cdi = Util.round(cdi, 2);
        cdiHistory.add(this.getCdi());
    }

    public ArrayList<Float> getCdiHistory() {
        return cdiHistory;
    }

    public void setCdiHistory(ArrayList<Float> cdiHistory) {
        this.cdiHistory = cdiHistory;
    }

    public float getSelic() {
        return selic;
    }

    public void setSelic(float selic) {
        this.selic = Util.round(selic, 2);
        selicHistory.add(this.getSelic());
    }

    public ArrayList<Float> getSelicHistory() {
        return selicHistory;
    }

    public void setSelicHistory(ArrayList<Float> selicHistory) {
        this.selicHistory = selicHistory;
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
                + ",\n    inflationHistory=" + inflationHistory
                + ",\n    cdi=" + cdi
                + ",\n    cdiHistory=" + cdiHistory
                + ",\n    selic=" + selic
                + ",\n    selicHistory=" + selicHistory
                + ",\n    status=" + status
                + ",\n    marketListActions=" + marketListActions
                + "\n}";
    }

    public static float generateInflation() {
        return Float.parseFloat(String.valueOf(Util.generateValue(0.5, 20)));

    }

    public static float generateInflation(float inflation) {
        String s = String.valueOf(
                ((generateInflation() * generateInflation()) % (inflation * 2.5) + 0.01)
        );
        Util.tryCutString(s, 0, 10);
        return Float.parseFloat(s);
    }

    public static float generateSelic(float inflation) {
        String s = String.valueOf(
                (inflation + 1 + (Util.multGenerateValue(0.5, 20.0, 256)))
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
