package jogo.controle;

import jogo.Main;
import jogo.visao.FrmSaveRecovery;
import jogo.visao.FrmNewGame;
import jogo.visao.FrmStart;

/**
 * Classe de controle do FrmStart.
 *
 * @see FrmStart
 * @author Lucas
 */
public class CtrStart {

    FrmStart frmStart;

    public CtrStart(FrmStart frmStart) {
        this.frmStart = frmStart;
        Main.frmStart = frmStart;
        addActionListeners();
    }

    /**
     * Adiciona os listadores de Ações
     */
    private void addActionListeners() {
        frmStart.getBtnCarregarJogo().addActionListener(e -> actionBtnCarregarJogo());
        frmStart.getBtnNovoJogo().addActionListener(e -> actionBtnNovoJogo());
    }

    /**
     * Ação para abrir o FrmCarregaJogo
     *
     * @see FrmSaveRecovery
     */
    private void actionBtnCarregarJogo() {
        if (!(Main.frmSaveRecovery instanceof FrmSaveRecovery)) {
            new FrmSaveRecovery().setVisible(true);
            frmStart.dispose();
            return;
        }
        try {
            Main.frmSaveRecovery.setVisible(true);
        } catch (Exception e) {
            new FrmSaveRecovery().setVisible(true);
        }
        frmStart.dispose();
    }

    /**
     * Ação para abrir o FrmIniciarComNome
     *
     * @see FrmNewGame
     */
    private void actionBtnNovoJogo() {
        if (!(Main.frmNewGame instanceof FrmNewGame)) {
            new FrmNewGame().setVisible(true);
            frmStart.dispose();
            return;
        }
        try {
            Main.frmNewGame.setVisible(true);
        } catch (Exception e) {
            new FrmNewGame().setVisible(true);
        }
        frmStart.dispose();
    }

}
