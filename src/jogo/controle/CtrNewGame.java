package jogo.controle;

import javax.swing.JOptionPane;
import jogo.modelo.Game;
import jogo.modelo.Player;
import jogo.visao.FrmMainGame;
import jogo.visao.FrmNewGame;
import jogo.visao.FrmStart;

/**
 * Classe de controle do FrmNewGame.
 *
 * @see FrmNewGame
 * @author Lucas
 */
public class CtrNewGame {

    FrmNewGame frmNewGame;

    public CtrNewGame(FrmNewGame frmNewGame) {
        this.frmNewGame = frmNewGame;
        addActionListeners();
    }

    /**
     * Adiciona os listadores de Ações
     */
    private void addActionListeners() {
        frmNewGame.getBtnVoltar().addActionListener(e -> actionBtnVoltar());
        frmNewGame.getBtnIniciar().addActionListener(e -> actionBtnIniciar());
    }

    /**
     * Ação para Voltar ao o FrmStart
     *
     * @see FrmStart
     */
    private void actionBtnVoltar() {
        new FrmStart().setVisible(true);
        frmNewGame.dispose();
    }

    /**
     * Ação para Iniciar a Partida
     */
    private void actionBtnIniciar() {
        String nome = frmNewGame.getTxtNome().getText();
        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(frmNewGame, "Digite um nome válido");
            return;
        }
        FrmMainGame frmMainGame = new FrmMainGame();
        frmMainGame.setGame(new Game(new Player(nome)));
        //Montrar introdução(se tiver)
        frmMainGame.getListeners().reloadComponents();
        frmMainGame.setVisible(true);
        frmNewGame.dispose();
    }

}
