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
     */
    private int id;

    /**
     * Valor atual em renda fixa
     */
    private double value;

    /**
     * Juros da renda fixa.
     *
     * @see "Calculado pelas variáveis do mercado"
     */
    private double interest;

    /**
     * Tempo de espera para recuperar um valor, em turnos
     *
     * @see Config
     */
    private int recoveryDelay;

    /**
     * Lista de solicitações de recuperação de um valor
     */
    private ArrayList<RedemptionRequests> redemptionRequests;

    public FixedIncome(int id, double value, double interest, ArrayList<RedemptionRequests> redemptionRequests) {
        this.id = id;
        this.value = value;
        this.interest = interest;
        this.recoveryDelay = Config.FIXED_INCOME_RECOVERY_DELAY;
        this.redemptionRequests = redemptionRequests;
    }

    public FixedIncome(double value, double interest, ArrayList<RedemptionRequests> redemptionRequests) {
        this.value = value;
        this.interest = interest;
        this.recoveryDelay = Config.FIXED_INCOME_RECOVERY_DELAY;
        this.redemptionRequests = redemptionRequests;
    }

    public FixedIncome(double value, double interest) {
        this(value, interest, new ArrayList<>());
    }

    public FixedIncome() {
        this(0, 0);
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

    public ArrayList<RedemptionRequests> getRedemptionRequests() {
        return redemptionRequests;
    }

    public void setRedemptionRequests(ArrayList<RedemptionRequests> redemptionRequests) {
        this.redemptionRequests = redemptionRequests;
    }

}

/**
 * Pedido de Recuperação
 */
class RedemptionRequests {

    private double value;
    private int delay;

    public RedemptionRequests(double value, int delay) {
        this.value = value;
        this.delay = delay;
    }
}
