package jogo.controle;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jogo.Main;
import jogo.visao.FrmSaveRecovery;
import jogo.visao.FrmStart;

/**
 * Classe de controle do FrmSaveRecovery.
 *
 * @see FrmSaveRecovery
 */
public class CtrSaveRecovery {

    FrmSaveRecovery frmSaveRecovery;
    DefaultTableModel tbCarregarJogoTM;

    public CtrSaveRecovery(FrmSaveRecovery frmSaveRecovery) {
        this.frmSaveRecovery = frmSaveRecovery;
        Main.frmSaveRecovery = frmSaveRecovery;
        addActionListeners();
        startTbCarregarJogo();
    }

    /**
     * Adiciona os listadores de Ações
     */
    private void addActionListeners() {
        frmSaveRecovery.getBtnVoltar().addActionListener(e -> actionBtnVoltar());
        frmSaveRecovery.getBtnCarregarJogo().addActionListener(e -> actionBtnCarregarJogo());
    }

    private void startTbCarregarJogo() {
        String columnNames[] = {"Nome Jogador", "Saldo", "Turno"};
        tbCarregarJogoTM = new DefaultTableModel(columnNames, 0);
        frmSaveRecovery.getTbCarregarJogo().setModel(tbCarregarJogoTM);
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

    public void reloadComponents() {
        frmSaveRecovery.getTbCarregarJogo();
        this.reloadTabela();
    }

    private void reloadTabela() {
        //recarregar tabela com dados do banco
        System.out.println("Recarregando tabela com dados do banco");
    }

}
