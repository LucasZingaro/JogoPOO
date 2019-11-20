/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo.modelo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
import java.util.Random;

/**
 *
 * @author Lucas
 */
public class Acao {

    String nome;
    double quantidade;
    double valor;
    double variacao;

    public Acao(String nome, double quantidade, double valor) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.valor = valor;
        this.variacao = 0;
    }

    public Acao(String nome, double quantidade, double valor, double variacao) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.valor = valor;
        this.variacao = variacao;
    }

    /**
     * Criação Random, para testes
     */
    public Acao() {
        this.nome = "A" + Acao.getRandomChar() + Acao.getRandomChar() + Acao.getRandomChar();
        this.quantidade = gerarQuantidade();
        this.valor = gerarValor();
        this.variacao = Double.parseDouble(String.valueOf(Math.random() * (Math.random() * (Math.random() * 100))).substring(0, 4));
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getVariacao() {
        return variacao;
    }

    public void setVariacao(double variacao) {
        this.variacao = variacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.nome);
        hash = 47 * hash + Objects.hashCode(this.quantidade);
        hash = 47 * hash + Objects.hashCode(this.valor);
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
        final Acao other = (Acao) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.quantidade, other.quantidade)) {
            return false;
        }
        if (!Objects.equals(this.valor, other.valor)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Acao{" + "nome=" + nome + ", quantidade=" + quantidade + ", valor=" + valor + ", variacao=" + variacao + '}';
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
        double valorAntigo = this.valor;
        this.valor = round(this.gerarValor(valorAntigo), 2);
        this.variacao = round(((this.valor / valorAntigo) - 1) * 100, 2);

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
