/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo.controle;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jogo.Main;
import jogo.visao.FrmLoansDetails;

/**
 *
 * @author Lucas
 */
public class CtrLoansDetails {

    FrmLoansDetails frmLoansDetails;
    DefaultTableModel tbEmprestimosTM;

    public CtrLoansDetails(FrmLoansDetails frmLoansDetails) {
        this.frmLoansDetails = frmLoansDetails;
        Main.frmLoansDetails = frmLoansDetails;
        addActionListeners();
        startTbEmprestimos();
    }

    /**
     * Adiciona os listadores de Ações
     */
    private void addActionListeners() {
        frmLoansDetails.getBtnPagar().addActionListener(e -> actionBtnPagar());
        frmLoansDetails.getBtnPegar().addActionListener(e -> actionBtnPegar());
        frmLoansDetails.getBtnSelecionar().addActionListener(e -> actionBtnSelecionar());
    }

    private void startTbEmprestimos() {
        tbEmprestimosTM = new DefaultTableModel(new String[]{"Valor", "Juros", "Turno Início"}, 0);
        frmLoansDetails.getTbEmprestimos().setModel(tbEmprestimosTM);
        reloadTbEmprestimos();
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

    public void reloadComponents() {
        frmLoansDetails.getTxtValor().setText("");
        frmLoansDetails.getTxtJurosValor().setText("R$ " + Main.game.getMarket().getSelic());
        reloadTbEmprestimos();
    }

    private void reloadTbEmprestimos() {
        try {
            frmLoansDetails.getTbEmprestimos().removeAll();
            frmLoansDetails.getPlayer().getLoanList().forEach((loan) -> {
                tbEmprestimosTM.addRow(new Object[]{
                    loan.getValue(),
                    loan.getInterest(),
                    loan.getStartTurn()
                });
            });
        } catch (Exception e) {
        }

    }
}
