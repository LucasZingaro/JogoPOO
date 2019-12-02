package jogo.controle;

import javax.swing.JOptionPane;
import jogo.Main;
import jogo.modelo.Game;
import jogo.modelo.Player;
import jogo.visao.FrmLoading;
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
        Main.frmNewGame = frmNewGame;
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
     *
     * @see FrmMainGame
     */
    private void actionBtnIniciar() {
        String nome = frmNewGame.getTxtNome().getText();
        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(frmNewGame, "Digite um nome válido");
            return;
        }
        //Criando o jogo
        Main.game = new Game(new Player(nome));
        FrmMainGame frmMainGame = new FrmMainGame();

        //display loading
        new FrmLoading().getListeners().runLoadingJFrame(frmMainGame);

        //Carrega o jogo
        frmMainGame.setGame(Main.game);
        frmMainGame.getListeners().reloadComponents();
        new Thread(() -> {
            System.out.println(Main.game);
        }).start();

        //Montrar introdução(se tiver)
        //frmMainGame.setVisible(true); //Já feito pelo Loading
        frmNewGame.dispose();
    }

    public void reloadComponents() {
        frmNewGame.getTxtNome().setText("");
    }

}
