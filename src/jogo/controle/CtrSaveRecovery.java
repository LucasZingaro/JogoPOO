/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo.controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import jogo.visao.FrmSaveRecovery;
import jogo.visao.FrmStart;

/**
 * Classe de controle do FrmSaveRecovery.
 *
 * @see FrmSaveRecovery
 * @author Lucas
 */
public class CtrSaveRecovery {

    FrmSaveRecovery frm;

    public CtrSaveRecovery(FrmSaveRecovery frm) {
        this.frm = frm;
        addActionListeners();
    }

    /**
     * Adiciona os listadores de Ações
     */
    private void addActionListeners() {
        frm.getBtnVoltar().addActionListener(e -> actionBtnVoltar());
        frm.getBtnCarregarJogo().addActionListener(e -> actionBtnCarregarJogo());
    }

    /**
     * Ação para Voltar ao o FrmStart
     *
     * @see FrmStart
     */
    private void actionBtnVoltar() {
        new FrmStart().setVisible(true);
        frm.dispose();
    }

    /**
     * Ação para recuperar jogo salvo
     */
    private void actionBtnCarregarJogo() {
        if (frm.getTbCarregarJogo().getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(frm,
                    "Nenhum jogo selecionado!!!",
                    "Aviso",
                    JOptionPane.INFORMATION_MESSAGE
            );
            return;
        }
        JOptionPane.showMessageDialog(frm,
                "Recuperar jogo da linha selecionada = " + frm.getTbCarregarJogo().getSelectedRow());
    }

}
