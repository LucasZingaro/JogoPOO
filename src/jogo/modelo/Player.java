package jogo.modelo;

import java.util.ArrayList;
import jogo.Config;

/**
 * Representa um jogador
 *
 * @author Lucas
 */
public class Player {

    /**
     * Identificador do jogador
     *
     * @hidden savable
     */
    private int id;

    /**
     * Nome do Jogador
     *
     * @hidden savable
     */
    private String name;

    /**
     * Dinheiro líquido do Jogador
     *
     * @hidden savable
     */
    private double money;

    /**
     * Lista de Empréstimos do Jogador
     *
     * @hidden savable
     */
    private ArrayList<Loan> loanList;

    /**
     * Renda fixa do jogador
     *
     * @hidden savable
     */
    private FixedIncome fixedIncome;

    /**
     * Lista de ações que o jogador tem participação
     *
     * @see "Associados as ações do mercado que o jogador tem algma quantidade"
     * @see Market
     * @hidden unsavable
     */
    private ArrayList<Action> playerListActions;

    /** 
     * Contrutor BD
     */
    public Player(int id, String name, Double money, ArrayList<Loan> loanList, FixedIncome fixedIncome) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.loanList = loanList;
        this.fixedIncome = fixedIncome;
        this.playerListActions = new ArrayList<>();
    }

    public Player(String name, Double money, ArrayList<Loan> loanList, FixedIncome fixedIncome, ArrayList<Action> playerListActions) {
        this.name = name;
        this.money = money;
        this.loanList = loanList;
        this.fixedIncome = fixedIncome;
        this.playerListActions = playerListActions;
    }

    public Player(String name, double money, ArrayList<Loan> loanList, FixedIncome fixedIncome) {
        this(name, money, loanList, fixedIncome, new ArrayList<>());
    }

    public Player(String name, double money, ArrayList<Loan> loanList) {
        this(name, money, loanList, new FixedIncome());
    }

    public Player(String name, Double money) {
        this(name, money, new ArrayList<>());
    }

    public Player(String name) {
        this(name, Config.INITIAL_PLAYER_MONEY);
    }

    /**
     * @deprecated Só para testes
     */
    public Player() {
        this("TestPlayer");
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

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public ArrayList<Loan> getLoanList() {
        return loanList;
    }

    public void setLoanList(ArrayList<Loan> loanList) {
        this.loanList = loanList;
    }

    public FixedIncome getFixedIncome() {
        return fixedIncome;
    }

    public void setFixedIncome(FixedIncome fixedIncome) {
        this.fixedIncome = fixedIncome;
    }

    public ArrayList<Action> getPlayerListActions() {
        return playerListActions;
    }

    public void setPlayerListActions(ArrayList<Action> playerListActions) {
        this.playerListActions = playerListActions;
    }

}
