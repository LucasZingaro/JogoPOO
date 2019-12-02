package jogo.controle;

import javax.swing.JOptionPane;
import jogo.Main;
import jogo.Util;
import jogo.visao.FrmLoansDetails;
import jogo.visao.FrmPlayerDetails;

/**
 * Controle da tela de detalhes do jogador
 */
public class CtrPlayerDetails {

    FrmPlayerDetails frmPlayerDetails;
    FrmLoansDetails frmLoansDetails;

    public CtrPlayerDetails(FrmPlayerDetails frmPlayerDetails) {
        this.frmPlayerDetails = frmPlayerDetails;
        Main.frmPlayerDetails = frmPlayerDetails;
        addActionListeners();
    }

    /**
     * Adiciona os listadores de Ações
     */
    private void addActionListeners() {
        frmPlayerDetails.getBtnAdicionarValorRF()
                .addActionListener(e -> actionBtnAdicionarValorRF());
        frmPlayerDetails.getBtnEmprestimos()
                .addActionListener(e -> actionBtnEmprestimos());
        frmPlayerDetails.getBtnRetirarValorRF()
                .addActionListener(e -> actionBtnRetirarValorRF());
    }

    private void actionBtnAdicionarValorRF() {
        double valorAdd = 0;
        try {
            valorAdd = Double.parseDouble(frmPlayerDetails.getTxtValorAdicionadoRF().getText());
            valorAdd = Util.round(valorAdd, 2);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frmLoansDetails, "Valor Inválido!!");
            frmPlayerDetails.getTxtValorAdicionadoRF().setText("");
            return;
        }
        double oldMoney = frmPlayerDetails.getPlayer().getMoney();

        if (valorAdd > oldMoney) {
            JOptionPane.showMessageDialog(frmLoansDetails, "Valor maior que o Saldo!!");
            return;
        }
        switch (JOptionPane.showConfirmDialog(frmPlayerDetails,
                "Adicionar: R$ " + valorAdd + " ?",
                "Investimento Renda Fixa", JOptionPane.OK_CANCEL_OPTION)) {

            case JOptionPane.OK_OPTION:
                double valorFI = frmPlayerDetails.getPlayer().getFixedIncome().getValue();
                frmPlayerDetails.getPlayer().getFixedIncome().setValue(valorFI + valorAdd);
                frmPlayerDetails.getPlayer().setMoney(oldMoney - valorAdd);
                frmPlayerDetails.getTxtValorAdicionadoRF().setText("");
                Main.reloadAllFrames();
                break;
            default:
                break;
        }
    }

    private void actionBtnRetirarValorRF() {
        double valorRemover = 0;
        try {
            valorRemover = Double.parseDouble(frmPlayerDetails.getTxtValorRemovidoRF().getText());
            valorRemover = Util.round(valorRemover, 2);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frmLoansDetails, "Valor Inválido!!");
            frmPlayerDetails.getTxtValorRemovidoRF().setText("");
            return;
        }
        double valorRF = frmPlayerDetails.getPlayer().getFixedIncome().getValue();

        if (valorRemover > valorRF) {
            JOptionPane.showMessageDialog(frmLoansDetails, "Valor maior que o Investido!!");
            return;
        }

        switch (JOptionPane.showConfirmDialog(frmPlayerDetails,
                "Remover: R$ " + valorRemover + " ?",
                "Recuperação Renda Fixa", JOptionPane.OK_CANCEL_OPTION)) {

            case JOptionPane.OK_OPTION:
                double oldMoney = frmPlayerDetails.getPlayer().getMoney();
                frmPlayerDetails.getPlayer().getFixedIncome().setValue(valorRF - valorRemover);
                frmPlayerDetails.getPlayer().setMoney(oldMoney + valorRemover);
                frmPlayerDetails.getTxtValorRemovidoRF().setText("");
                Main.reloadAllFrames();
                break;
            default:
                break;
        }
    }

    private void actionBtnEmprestimos() {
        if (!(frmLoansDetails instanceof FrmLoansDetails)) {
            frmLoansDetails = new FrmLoansDetails();
            frmLoansDetails.setPlayer(this.frmPlayerDetails.getPlayer());
        }
        frmLoansDetails.setVisible(true);
        frmLoansDetails.requestFocus();
    }

    public void reloadComponents() {
        frmPlayerDetails.getLblGastosValor()
                .setText(String.valueOf(frmPlayerDetails.getPlayer().calcDespesas(Main.game)));
        double selic = Main.game.getMarket().getSelic();
        frmPlayerDetails.getPlayer().getFixedIncome().setInterest(selic);
        frmPlayerDetails.getLblJurosValor().setText(Util.round(selic, 2) + "%");

        frmPlayerDetails.getLblNomeValor()
                .setText(String.valueOf(frmPlayerDetails.getPlayer().getName()));
        frmPlayerDetails.getLblRendaFixaValor()
                .setText(String.valueOf(frmPlayerDetails.getPlayer()
                        .getFixedIncome().getValue()));
        frmPlayerDetails.getLblSaldoValor()
                .setText(String.valueOf(frmPlayerDetails.getPlayer().getMoney()));
    }

}
