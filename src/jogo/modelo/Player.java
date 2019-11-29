package jogo.modelo;

import java.util.ArrayList;

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

    public Player(String name, Double money, ArrayList<Loan> loanList, FixedIncome fixedIncome, ArrayList<Action> playerListActions) {
        this.name = name;
        this.money = money;
        this.loanList = loanList;
        this.fixedIncome = fixedIncome;
        this.playerListActions = playerListActions;
    }

    public Player() {
    }

}
