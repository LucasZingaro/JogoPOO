package jogo.controle;

import javax.swing.JOptionPane;
import jogo.Main;
import jogo.visao.FrmLoansDetails;
import jogo.visao.FrmPlayerDetails;

/**
 *
 * @author Lucas
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
        switch (JOptionPane.showConfirmDialog(frmPlayerDetails,
                "Adicionando:" + frmPlayerDetails.getTxtValorAdicionadoRF().getText(),
                "Investimento Renda Fixa", JOptionPane.OK_CANCEL_OPTION)) {
            
            case JOptionPane.OK_OPTION:
                frmPlayerDetails.getTxtValorAdicionadoRF().setText("");
                break;
            default:
                break;
        }
    }
    
    private void actionBtnEmprestimos() {
        if (!(frmLoansDetails instanceof FrmLoansDetails)) {
            System.out.println("Criando frmMarketDetails");
            frmLoansDetails = new FrmLoansDetails();
            frmLoansDetails.setPlayer(this.frmPlayerDetails.getPlayer());
        }
        frmLoansDetails.setVisible(true);
        frmLoansDetails.requestFocus();
    }
    
    private void actionBtnRetirarValorRF() {
        switch (JOptionPane.showConfirmDialog(frmPlayerDetails,
                "Removendo:" + frmPlayerDetails.getTxtValorRemovidoRF().getText(),
                "Recuperação Renda Fixa", JOptionPane.OK_CANCEL_OPTION)) {
            
            case JOptionPane.OK_OPTION:
                frmPlayerDetails.getTxtValorAdicionadoRF().setText("");
                break;
            default:
                break;
        }
    }
    
    void reloadComponents() {
        frmPlayerDetails.getLblGastosValor()
                .setText(String.valueOf(frmPlayerDetails.getPlayer().calcDespesas(Main.game)));
        frmPlayerDetails.getLblJurosValor()
                .setText(String.valueOf(Main.game.getMarket().getSelic()));
        frmPlayerDetails.getLblNomeValor()
                .setText(String.valueOf(frmPlayerDetails.getPlayer().getName()));
        frmPlayerDetails.getLblRendaFixaValor()
                .setText(String.valueOf(frmPlayerDetails.getPlayer().getFixedIncome().getValue()));
        frmPlayerDetails.getLblSaldoValor()
                .setText(String.valueOf(frmPlayerDetails.getPlayer().getMoney()));
    }
    
}
