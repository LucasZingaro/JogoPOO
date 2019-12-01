package jogo.modelo;

import java.util.ArrayList;
import jogo.Config;

/**
 * Representa a renda fixa de um jogador
 *
 * @author Lucas
 */
public class FixedIncome {

    /**
     * Identificador da Renda fixa
     *
     * @hidden savable
     */
    private int id;

    /**
     * Valor atual em renda fixa
     *
     * @hidden savable
     */
    private double value;

    /**
     * Juros da renda fixa.
     *
     * @see "Calculado pelas variáveis do mercado"
     * @see Market
     * @hidden unsavable
     */
    private double interest;

    /**
     * Tempo de espera para recuperar um valor, em turnos
     *
     * @see Config
     * @hidden unsavable
     */
    private int recoveryDelay;

    /**
     * Construtor BD
     */
    public FixedIncome(int id, double value) {
        this.id = id;
        this.value = value;
        this.recoveryDelay = Config.FIXED_INCOME_RECOVERY_DELAY;
    }

    public FixedIncome(double value, double interest) {
        this.value = value;
        this.interest = interest;
        this.recoveryDelay = Config.FIXED_INCOME_RECOVERY_DELAY;
    }

    public FixedIncome(double value) {
        this(value, 0);
    }

    public FixedIncome() {
        this(0);
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

    public int getRecoveryDelay() {
        return recoveryDelay;
    }

    public void setRecoveryDelay(int recoveryDelay) {
        this.recoveryDelay = recoveryDelay;
    }

    @Override
    public String toString() {
        return "FixedIncome{"
                + " \n    id=" + id
                + ",\n    value=" + value
                + ",\n    interest=" + interest
                + ",\n    recoveryDelay=" + recoveryDelay
                + " \n}";
    }

}
