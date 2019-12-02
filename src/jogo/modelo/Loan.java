package jogo.modelo;

/**
 * Representa um empréstimo do jogador.
 */
public class Loan {

    /**
     * Identificador do empréstimo
     *
     * @hidden savable
     */
    private int id;

    /**
     * Valor atual
     *
     * @hidden savable
     */
    private double value;

    /**
     * Juros
     *
     * @hidden savable
     */
    private double interest;

    /**
     * Turno inicial
     *
     * @hidden savable
     */
    private int startTurn;

    public Loan(int id, double value, double interest, int startTurn) {
        this.id = id;
        this.value = value;
        this.interest = interest;
        this.startTurn = startTurn;
    }

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

    @Override
    public String toString() {
        return "\n      Loan{"
                + " \n          id=" + id
                + ",\n          value=" + value
                + ",\n          interest=" + interest
                + ",\n          startTurn=" + startTurn
                + " \n      }";
    }

}
