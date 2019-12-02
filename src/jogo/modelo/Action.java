package jogo.modelo;

import java.util.ArrayList;
import jogo.Main;
import jogo.Util;

/**
 * Representação de uma ação financeira;
 *
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
     * Variação do valor atual da Ação em comparação com o valor anterior.
     *
     * @hidden savable
     */
    private double variation;

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
     *
     * @param id Identificador
     * @param name Nome
     * @param status Status
     * @param value valore
     * @param variation variação
     * @param marketQuantity Quantidade de ações no mercado
     * @param playerQuantity Quantidade de ações do jogador
     * @param purchaseOrderList Lista de ordens de compra (Action==null)
     * @param salesOrderList Lista de ordens de venda (Action==null)
     */
    public Action(int id, String name, StatusEnum status, double value,
            double variation, double marketQuantity, double playerQuantity,
            ArrayList<PurchaseOrder> purchaseOrderList, ArrayList<SalesOrder> salesOrderList) {

        this.id = id;
        this.name = name;
        this.status = status;
        this.value = value;
        this.variation = variation;
        this.marketQuantity = marketQuantity;
        this.playerQuantity = playerQuantity;

        //Associação de action anteriormente null
        purchaseOrderList.forEach((PurchaseOrder purchaseOrder) -> {
            purchaseOrder.setAction(this);
        });
        this.purchaseOrderList = purchaseOrderList;

        //Associação de action anteriormente null
        salesOrderList.forEach((SalesOrder salesOrder) -> {
            salesOrder.setAction(this);
        });
        this.salesOrderList = salesOrderList;
    }

    public Action(String name, StatusEnum status, double value, ArrayList<Double> valueHistory, double variation, ArrayList<Double> variationHistory, double marketQuantity, double playerQuantity, ArrayList<PurchaseOrder> purchaseOrderList, ArrayList<SalesOrder> salesOrderList) {
        this.name = name;
        this.status = status;
        this.value = value;
        this.variation = variation;
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

        //lista de ordens iniciais(sem quantidade do jogador)
        this.purchaseOrderList = gerarListaCompra(2, 10);
        this.salesOrderList = gerarListaVenda(2, 10);
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

    public double getVariation() {
        return variation;
    }

    public void setVariation(double variation) {
        this.variation = variation;
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
        this.setValue(Util.round(Action.gerarValor(valorAntigo), 2));
        this.setVariation(Util.round(((this.value / valorAntigo) - 1) * 100, 2));

        //Limpar ordens do mercado(não player)
        this.removeOrderListPurchaseIsNotFromPlayer();
        this.removeOrderListSalesIsNotFromPlayer();

        //Lista de orderns só do usuário
        ArrayList<PurchaseOrder> removeListPO = new ArrayList<>();
        this.getPurchaseOrderList().forEach((PurchaseOrder po) -> {
            if (po.isIsFromPlayer()) {
                if (po.getEndTurn() == Main.game.getNumTurn()
                        || po.getQuantity() <= 0) {
                    removeListPO.add(po);
                    return;
                }
                po.tryBuy(Main.game.getMarket());
            }
        });
        this.getPurchaseOrderList().removeAll(removeListPO);

        ArrayList<SalesOrder> removeListSO = new ArrayList<>();
        this.getSalesOrderList().forEach((SalesOrder so) -> {
            if (so.isIsFromPlayer()) {
                if (so.getEndTurn() == Main.game.getNumTurn()
                        || so.getQuantity() <= 0) {
                    removeListSO.add(so);
                    return;
                }
                so.trySell(Main.game.getMarket());
            }
        });
        this.getSalesOrderList().removeAll(removeListSO);
        //Refazer ordens do mercado(não player)
        this.getPurchaseOrderList().addAll(gerarListaCompra(Main.game.getNumTurn() + 1, 10));
        this.getSalesOrderList().addAll(gerarListaVenda(Main.game.getNumTurn() + 1, 10));

    }

    ;

    public String toString() {
        return "\n      Action{"
                + " \n          id=" + id
                + ",\n          name=" + name
                + ",\n          status=" + status
                + ",\n          value=" + value
                + ",\n          variation=" + variation
                + ",\n          marketQuantity=" + marketQuantity
                + ",\n          playerQuantity=" + playerQuantity
                + ",\n          purchaseOrderList=" + purchaseOrderList
                + ",\n          salesOrderList=" + salesOrderList
                + " \n      }";
    }

    private ArrayList<PurchaseOrder> gerarListaCompra(int turnofim, int n) {
        ArrayList<PurchaseOrder> po = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            po.add(new PurchaseOrder(this, turnofim, false));
        }
        return po;
    }

    private ArrayList<SalesOrder> gerarListaVenda(int turnofim, int n) {
        ArrayList<SalesOrder> so = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            so.add(new SalesOrder(this, turnofim, false));
        }
        return so;
    }

    private void removeOrderListPurchaseIsNotFromPlayer() {
        ArrayList<PurchaseOrder> removerPO = new ArrayList<>();
        this.getPurchaseOrderList().forEach((PurchaseOrder po) -> {
            if (!po.isIsFromPlayer()) {
                removerPO.add(po);
            }
        });
        this.getPurchaseOrderList().removeAll(removerPO);
    }

    private void removeOrderListSalesIsNotFromPlayer() {
        ArrayList<SalesOrder> removerSO = new ArrayList<>();
        this.getSalesOrderList().forEach((SalesOrder so) -> {
            if (!so.isIsFromPlayer()) {
                removerSO.add(so);
            }
        });
        this.getSalesOrderList().removeAll(removerSO);
    }

}
