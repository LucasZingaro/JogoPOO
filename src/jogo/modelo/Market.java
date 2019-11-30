package jogo.modelo;

import java.util.ArrayList;

/**
 * Representação do mercado financeiro
 *
 * @author Lucas
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

    public Market(float inflation, float cdi, float selic, StatusEnum status, ArrayList<Action> listActions) {
        this.inflation = inflation;
        this.inflationHistory = new ArrayList<>();
        this.cdi = cdi;
        this.cdiHistory = new ArrayList<>();
        this.selic = selic;
        this.selicHistory = new ArrayList<>();
        this.status = status;
        this.marketListActions = new ArrayList<>();
    }
    
    public Market() {
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
        this.inflation = inflation;
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
        this.cdi = cdi;
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
        this.selic = selic;
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

}
