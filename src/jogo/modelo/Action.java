package jogo.modelo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

/**
 * Representação de uma ação financeira
 *
 * @author Lucas
 */
public class Action {
    
    /**
     * Identificador da Ação
     */
    private int id;

    /**
     * Nome da ação
     */
    private String name;
    
    /**
     * Status da Ação
     */
    private StatusEnum status;
    
    /**
     * Valor atual da Ação.
     * @see "É o último registro do histórico de valores da ação"
     */
    private double value;
    
    /**
     * Histórico de valores da ação
     */
    private ArrayList<Double> valueHistory;
    
    /**
     * Variação do valor atual da Ação em comparação com o valor anterior.
     * @see "É o último registro do histórico de variação"
     */
    private double variation;
    
    /**
     * Histórico de valores da variação
     */
    private double variationHistory;
    
    /**
     * Quantidade de ações no marcado
     */
    private double marketQuantity;
    
    /**
     * Quantidade de ações do jogador
     */
    private double playerQuantity;
    
    /**
     * Lista de ordens de compra
     */
    private ArrayList<PurchaseOrder> purchaseOrderList;
    
    /**
     * Lista de ordens de venda
     */
    private ArrayList<SalesOrder> salesOrderList;

    public Action(String nome, double quantidade, double valor) {
        this.name = nome;
        this.marketQuantity = quantidade;
        this.value = valor;
        this.variation = 0;
    }

    public Action(String nome, double quantidade, double valor, double variacao) {
        this.name = nome;
        this.marketQuantity = quantidade;
        this.value = valor;
        this.variation = variacao;
    }

    /**
     * Criação Random, para testes
     */
    public Action() {
        this.name = "A" + Action.getRandomChar() + Action.getRandomChar() + Action.getRandomChar();
        this.marketQuantity = gerarQuantidade();
        this.value = gerarValor();
        this.variation = Double.parseDouble(String.valueOf(Math.random() * (Math.random() * (Math.random() * 100))).substring(0, 4));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMarketQuantity() {
        return marketQuantity;
    }

    public void setMarketQuantity(double marketQuantity) {
        this.marketQuantity = marketQuantity;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.name);
        hash = 47 * hash + Objects.hashCode(this.marketQuantity);
        hash = 47 * hash + Objects.hashCode(this.value);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Action other = (Action) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.marketQuantity, other.marketQuantity)) {
            return false;
        }
        if (!Objects.equals(this.value, other.value)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Acao{" + "nome=" + name + ", quantidade=" + marketQuantity + ", valor=" + value + ", variacao=" + variation + '}';
    }

    public static char getRandomChar() {
        return ((char) (new Random().nextInt(26) + 'a'));
    }

    private double gerarQuantidade() {
        return Math.round(Math.random() * 10000);
    }

    private double gerarValor() {
        return Math.round(Math.random() * 10000) / 100;
    }

    private double gerarValor(double valorAnterior) {
        double upOrDown = (Math.round(Math.random()) == 1) ? (1) : (-1);
        double howMuchChange = (upOrDown == 1)
                ? (Math.round(Math.random() * (valorAnterior)))
                : (Math.round(Math.random() * (valorAnterior / 2)));
        double valorNovo = (valorAnterior + (upOrDown * howMuchChange));
        return (valorNovo < 1) ? (1) : (valorNovo);
    }

    public void passarTurno() {
        double valorAntigo = this.value;
        this.value = round(this.gerarValor(valorAntigo), 2);
        this.variation = round(((this.value / valorAntigo) - 1) * 100, 2);

    }

    public static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        BigDecimal bd = BigDecimal.valueOf(value);
        try {
            bd = bd.setScale(places, RoundingMode.HALF_UP);
        } catch (Exception e) {
        }
        return bd.doubleValue();
    }

}
