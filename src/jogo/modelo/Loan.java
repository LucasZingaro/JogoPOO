package jogo.modelo;

/**
 * Representa um empréstimo do jogador;
 *
 * @author Lucas
 */
public class Loan {

    /**
     * Identificador do empréstimo
     */
    private int id;

    /**
     * Valor atual
     */
    private double value;

    /**
     * Juros
     */
    private double interest;

    /**
     * Turno inicial
     */
    private int startTurn;

    public Loan(double value, double interest, int startTurn) {
        this.value = value;
        this.interest = interest;
        this.startTurn = startTurn;
    }

    public Loan() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public int getStartTurn() {
        return startTurn;
    }

    public void setStartTurn(int startTurn) {
        this.startTurn = startTurn;
    }

}
