/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo.controle;

import javax.swing.JOptionPane;
import jogo.visao.FrmLoansDetails;

/**
 *
 * @author Lucas
 */
public class CtrLoansDetails {
    
    FrmLoansDetails frmLoansDetails;
    
    public CtrLoansDetails(FrmLoansDetails frmLoansDetails) {
        this.frmLoansDetails = frmLoansDetails;
        addActionListeners();
    }

    /**
     * Adiciona os listadores de Ações
     */
    private void addActionListeners() {
        frmLoansDetails.getBtnPagar().addActionListener(e -> actionBtnPagar());
        frmLoansDetails.getBtnPegar().addActionListener(e -> actionBtnPegar());
        frmLoansDetails.getBtnSelecionar().addActionListener(e -> actionBtnSelecionar());
    }
    
    private void actionBtnPagar() {
        JOptionPane.showMessageDialog(frmLoansDetails, "Pagar empréstimo");
    }
    
    private void actionBtnPegar() {
        JOptionPane.showMessageDialog(frmLoansDetails, "Pegar empréstimo");
    }
    
    private void actionBtnSelecionar() {
        if (frmLoansDetails.getTbEmprestimos().getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(frmLoansDetails,
                    "Nenhum empréstimo selecionado!!!",
                    "Aviso",
                    JOptionPane.INFORMATION_MESSAGE
            );
            return;
        }
        JOptionPane.showMessageDialog(frmLoansDetails,
                "Linha selecionada = " + frmLoansDetails.getTbEmprestimos().getSelectedRow());
        
    }
    
}
