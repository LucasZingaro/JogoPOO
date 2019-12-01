package jogo.modelo;

import java.util.ArrayList;
import jogo.Util;

/**
 * Representação de uma ação financeira
 *
 * @author Lucas
 */
public class Action {

    /**
     * Identificador da Ação
     *
     * @hidden savable
     */
    private int id;

    /**
     * Nome da ação
     *
     * @hidden savable
     */
    private String name;

    /**
     * Status da Ação
     *
     * @hidden savable
     */
    private StatusEnum status;

    /**
     * Valor atual da Ação.
     *
     * @see "É o último registro do histórico de valores da ação"
     * @hidden unsavable
     */
    private double value;

    /**
     * Histórico de valores da ação
     *
     * @hidden savable
     */
    private ArrayList<Double> valueHistory;

    /**
     * Variação do valor atual da Ação em comparação com o valor anterior.
     *
     * @see "É o último registro do histórico de variação"
     * @hidden unsavable
     */
    private double variation;

    /**
     * Histórico de valores da variação
     *
     * @hidden savable
     */
    private ArrayList<Double> variationHistory;

    /**
     * Quantidade de ações no marcado
     *
     * @hidden savable
     */
    private double marketQuantity;

    /**
     * Quantidade de ações do jogador
     *
     * @hidden savable
     */
    private double playerQuantity;

    /**
     * Lista de ordens de compra
     *
     * @hidden savable
     */
    private ArrayList<PurchaseOrder> purchaseOrderList;

    /**
     * Lista de ordens de venda
     *
     * @hidden savable
     */
    private ArrayList<SalesOrder> salesOrderList;

    /**
     * Construtor BD
     */
    public Action(int id, String name, StatusEnum status, ArrayList<Double> valueHistory,
            ArrayList<Double> variationHistory, double marketQuantity, double playerQuantity,
            ArrayList<PurchaseOrder> purchaseOrderList, ArrayList<SalesOrder> salesOrderList) {

        this.id = id;
        this.name = name;
        this.status = status;
        this.value = valueHistory.get(valueHistory.size() - 1);
        this.valueHistory = valueHistory;
        this.variation = variationHistory.get(this.valueHistory.size() - 1);;
        this.variationHistory = variationHistory;
        this.marketQuantity = marketQuantity;
        this.playerQuantity = playerQuantity;
        this.purchaseOrderList = purchaseOrderList;
        this.salesOrderList = salesOrderList;
    }

    public Action(String name, StatusEnum status, double value, ArrayList<Double> valueHistory, double variation, ArrayList<Double> variationHistory, double marketQuantity, double playerQuantity, ArrayList<PurchaseOrder> purchaseOrderList, ArrayList<SalesOrder> salesOrderList) {
        this.name = name;
        this.status = status;
        this.value = value;
        this.valueHistory = valueHistory;
        this.variation = variation;
        this.variationHistory = variationHistory;
        this.marketQuantity = marketQuantity;
        this.playerQuantity = playerQuantity;
        this.purchaseOrderList = purchaseOrderList;
        this.salesOrderList = salesOrderList;
    }

    public Action(String name, StatusEnum status, double value, double variation, double marketQuantity, double playerQuantity) {
        this(name, status,
                value, new ArrayList<>(),
                variation, new ArrayList<>(),
                marketQuantity, playerQuantity,
                new ArrayList<>(),
                new ArrayList<>()
        );
        this.valueHistory.add(value);
        this.variationHistory.add(variation);
    }

    public Action(String name, StatusEnum status, double value, double marketQuantity) {
        this(name, status, value, 0, marketQuantity, 0);
    }

    /**
     * Criação Random
     */
    public Action() {
        this(
                ("B" + Util.getSequencialRandomCharBetweenAandZ(4)),
                StatusEnum.NEUTRAL,
                gerarValor(),
                gerarVariacao(),
                gerarQuantidade(),
                0
        );

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public ArrayList<Double> getValueHistory() {
        return valueHistory;
    }

    public void setValueHistory(ArrayList<Double> valueHistory) {
        this.valueHistory = valueHistory;
    }

    public double getVariation() {
        return variation;
    }

    public void setVariation(double variation) {
        this.variation = variation;
    }

    public ArrayList<Double> getVariationHistory() {
        return variationHistory;
    }

    public void setVariationHistory(ArrayList<Double> variationHistory) {
        this.variationHistory = variationHistory;
    }

    public double getMarketQuantity() {
        return marketQuantity;
    }

    public void setMarketQuantity(double marketQuantity) {
        this.marketQuantity = marketQuantity;
    }

    public double getPlayerQuantity() {
        return playerQuantity;
    }

    public void setPlayerQuantity(double playerQuantity) {
        this.playerQuantity = playerQuantity;
    }

    public ArrayList<PurchaseOrder> getPurchaseOrderList() {
        return purchaseOrderList;
    }

    public void setPurchaseOrderList(ArrayList<PurchaseOrder> purchaseOrderList) {
        this.purchaseOrderList = purchaseOrderList;
    }

    public ArrayList<SalesOrder> getSalesOrderList() {
        return salesOrderList;
    }

    public void setSalesOrderList(ArrayList<SalesOrder> salesOrderList) {
        this.salesOrderList = salesOrderList;
    }

    public static double gerarQuantidade() {
        return Math.round(Util.generateValue(100, 50000));
    }

    public static double gerarValor() {
        return Math.round(Util.generateValue(100, 10000)) / 100;
    }

    public static double gerarValor(double valorAnterior) {
        double upOrDown = (Math.round(Math.random()) == 1) ? (1) : (-1);
        double howMuchChange = (upOrDown == 1)
                ? (Math.round(Math.random() * (valorAnterior)))
                : (Math.round(Math.random() * (valorAnterior / 2)));
        double valorNovo = (valorAnterior + (upOrDown * howMuchChange));
        return (valorNovo < 1) ? (1) : (valorNovo);
    }

    public static double gerarVariacao() {
        return Double.parseDouble(String.valueOf(
                Util.multGenerateValue(0.1, 100, 42)
        ).substring(0, 4));
    }

    public void passarTurno() {
        double valorAntigo = this.value;
        this.value = Util.round(Action.gerarValor(valorAntigo), 2);
        this.variation = Util.round(((this.value / valorAntigo) - 1) * 100, 2);

    }

    public String toString() {
        return "\n      Action{"
                + " \n          id=" + id
                + ",\n          name=" + name
                + ",\n          status=" + status
                + ",\n          value=" + value
                + ",\n          valueHistory=" + valueHistory
                + ",\n          variation=" + variation
                + ",\n          variationHistory=" + variationHistory
                + ",\n          marketQuantity=" + marketQuantity
                + ",\n          playerQuantity=" + playerQuantity
                + ",\n          purchaseOrderList=" + purchaseOrderList
                + ",\n          salesOrderList=" + salesOrderList
                + " \n      }";
    }

}
