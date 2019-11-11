/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo.modelo;

import java.util.Objects;
import java.util.Random;

/**
 *
 * @author Lucas
 */
public class Acao {

    String nome;
    double quantidade;
    float valor;
    float variacao;

    public Acao(String nome, double quantidade, float valor) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.valor = valor;
        this.variacao = 0;
    }

    public Acao(String nome, double quantidade, float valor, float variacao) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.valor = valor;
        this.variacao = variacao;
    }
    public static char getRandomChar(){
        return ((char) (new Random().nextInt(26) + 'a'));
    }

    /**
     * Criação Random, para testes
     */
    public Acao() { 
        this("A" + Acao.getRandomChar() + Acao.getRandomChar()+ Acao.getRandomChar(),
                Math.round(Math.random() * 10000),
                Math.round(Math.random() * 10000) / 100,
                Float.parseFloat(String.valueOf(Math.random() * (Math.random() * (Math.random() * 100))).substring(0, 4)));
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

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public float getVariacao() {
        return variacao;
    }

    public void setVariacao(float variacao) {
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

}
