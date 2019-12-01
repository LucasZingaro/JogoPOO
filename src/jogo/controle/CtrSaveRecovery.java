package jogo.controle;

import javax.swing.JOptionPane;
import jogo.Main;
import jogo.visao.FrmSaveRecovery;
import jogo.visao.FrmStart;

/**
 * Classe de controle do FrmSaveRecovery.
 *
 * @see FrmSaveRecovery
 * @author Lucas
 */
public class CtrSaveRecovery {

    FrmSaveRecovery frmSaveRecovery;

    public CtrSaveRecovery(FrmSaveRecovery frmSaveRecovery) {
        this.frmSaveRecovery = frmSaveRecovery;
        Main.frmSaveRecovery = frmSaveRecovery;
        addActionListeners();
    }

    /**
     * Adiciona os listadores de Ações
     */
    private void addActionListeners() {
        frmSaveRecovery.getBtnVoltar().addActionListener(e -> actionBtnVoltar());
        frmSaveRecovery.getBtnCarregarJogo().addActionListener(e -> actionBtnCarregarJogo());
    }

    /**
     * Ação para Voltar ao o FrmStart
     *
     * @see FrmStart
     */
    private void actionBtnVoltar() {
        if (!(Main.frmStart instanceof FrmStart)) {
            new FrmStart().setVisible(true);
            frmSaveRecovery.dispose();
            return;
        }
        try {
            Main.frmStart.setVisible(true);
        } catch (Exception e) {
            new FrmStart().setVisible(true);
        }
        frmSaveRecovery.dispose();
    }

    /**
     * Ação para recuperar jogo salvo
     */
    private void actionBtnCarregarJogo() {
        if (frmSaveRecovery.getTbCarregarJogo().getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(frmSaveRecovery,
                    "Nenhum jogo selecionado!!!",
                    "Aviso",
                    JOptionPane.INFORMATION_MESSAGE
            );
            return;
        }
        JOptionPane.showMessageDialog(frmSaveRecovery,
                "Recuperar jogo da linha selecionada = " + frmSaveRecovery.getTbCarregarJogo().getSelectedRow());
    }

}
