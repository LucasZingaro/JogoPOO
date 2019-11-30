package jogo.controle;

import jogo.visao.FrmMarketDetails;

/**
 *
 * @author Lucas
 */
public class CtrMarketDetails {

    FrmMarketDetails frmMarketDetails;

    public CtrMarketDetails(FrmMarketDetails frmMarketDetails) {
        this.frmMarketDetails = frmMarketDetails;
    }

    public void reloadComponents() {
        frmMarketDetails.getLblValorCdi()
                .setText(String.valueOf(frmMarketDetails.getMercado().getCdi()));
        frmMarketDetails.getLblValorInflacao()
                .setText(String.valueOf(frmMarketDetails.getMercado().getInflation()));
        frmMarketDetails.getLblValorSelic()
                .setText(String.valueOf(frmMarketDetails.getMercado().getSelic()));
        frmMarketDetails.getLblValorStatus()
                .setText(String.valueOf(frmMarketDetails.getMercado().getStatus()));
    }

}
