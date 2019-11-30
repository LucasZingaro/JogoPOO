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
     */
    private int id;

    /**
     * Nome do Jogador
     */
    private String name;

    /**
     * Dinheiro líquido do Jogador
     */
    private Double money;

    /**
     * Lista de Empréstimos do Jogador
     */
    private ArrayList<Loan> loanList;

    /**
     * Renda fixa do jogador
     */
    private FixedIncome fixedIncome;

    /**
     * Lista de ações que o jogador tem participação
     */
    private ArrayList<Action> playerListActions;

    public Player(int id, String name, Double money, ArrayList<Loan> loanList, FixedIncome fixedIncome, ArrayList<Action> playerListActions) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.loanList = loanList;
        this.fixedIncome = fixedIncome;
        this.playerListActions = playerListActions;
    }

    public Player(String name, Double money, ArrayList<Loan> loanList, FixedIncome fixedIncome, ArrayList<Action> playerListActions) {
        this.name = name;
        this.money = money;
        this.loanList = loanList;
        this.fixedIncome = fixedIncome;
        this.playerListActions = playerListActions;
    }

    public Player(String name, Double money, ArrayList<Loan> loanList, FixedIncome fixedIncome) {
        this(name, money, loanList, fixedIncome, new ArrayList<>());
    }

    public Player(String name, Double money, ArrayList<Loan> loanList) {
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

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
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
