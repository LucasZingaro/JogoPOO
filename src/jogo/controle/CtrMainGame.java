/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo.controle;

import javax.swing.JOptionPane;
import jogo.visao.FrmMainGame;
import jogo.visao.FrmMarketDetails;
import jogo.visao.FrmPlayerDetails;
import jogo.visao.FrmStart;

/**
 *
 * @author Lucas
 */
public class CtrMainGame {

    FrmMainGame frmMainGame;
    FrmPlayerDetails frmPlayerDetails = null;
    FrmMarketDetails frmMarketDetails = null;

    public CtrMainGame(FrmMainGame frmMainGame) {
        this.frmMainGame = frmMainGame;
        addActionListeners();
    }

    /**
     * Adiciona os listadores de Ações
     */
    private void addActionListeners() {
        frmMainGame.getBtnPassarTurno().addActionListener(e -> actionBtnPassarTurno());
        frmMainGame.getBtnPatrimonio().addActionListener(e -> actionBtnPatrimonio());
        frmMainGame.getBtnVisaoGeral().addActionListener(e -> actionBtnVisaoGeral());

        frmMainGame.getMiMenu().addActionListener(e -> actionMiMenu());
        frmMainGame.getMiSair().addActionListener(e -> actionMiSair());
        frmMainGame.getMiSalvar().addActionListener(e -> actionMiSalvar());
        frmMainGame.getMenuAjuda().addActionListener(e -> actionMenuAjuda());
    }

    private void actionBtnPassarTurno() {
        System.out.println("PassarTurno");
    }

    private void actionBtnPatrimonio() {
        if (!(frmPlayerDetails instanceof FrmPlayerDetails)) {
            System.out.println("Criando frmPlayerDetails");
            frmPlayerDetails = new FrmPlayerDetails();
            frmPlayerDetails.setPlayer(frmMainGame.getGame().getPlayer());
        }
        frmPlayerDetails.getListeners().reloadComponents();
        frmPlayerDetails.setVisible(true);
        frmPlayerDetails.requestFocus();
    }

    private void actionBtnVisaoGeral() {
        if (!(frmMarketDetails instanceof FrmMarketDetails)) {
            System.out.println("Criando frmMarketDetails");
            frmMarketDetails = new FrmMarketDetails();
            frmMarketDetails.setMercado(frmMainGame.getGame().getMarket());
        }
        frmMarketDetails.getListeners().reloadComponents();
        frmMarketDetails.setVisible(true);
        frmMarketDetails.requestFocus();
    }

    private void actionMiMenu() {
        int res = JOptionPane.showConfirmDialog(frmMainGame,
                "Deseja voltar ao menu?", "Menu Inicial",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        switch (res) {
            case JOptionPane.YES_OPTION:
                disposeFrames();
                new FrmStart().setVisible(true);
                break;
            default:
                break;
        }
    }

    private void actionMiSair() {
        int res = JOptionPane.showConfirmDialog(frmMainGame,
                "Deseja sair do jogo?", "Sair",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        switch (res) {
            case JOptionPane.YES_OPTION:
                disposeFrames();
                System.exit(0);
                break;
            default:
                break;
        }
    }

    private void actionMiSalvar() {
        JOptionPane.showMessageDialog(frmMainGame, "Salvando...");
    }

    private void actionMenuAjuda() {
        JOptionPane.showMessageDialog(frmMainGame, "Ajuda:...XD", "Ajuda", JOptionPane.OK_OPTION);
    }

    private void disposeFrames() {
        frmMarketDetails.dispose();
        frmPlayerDetails.dispose();
        frmMainGame.dispose();
    }

    public void reloadComponents() {
        frmMainGame.getLblNomeValor()
                .setText(String.valueOf(this.frmMainGame.getGame().getPlayer().getName()));
        frmMainGame.getLblSaldoValor()
                .setText(String.valueOf(this.frmMainGame.getGame().getPlayer().getMoney()));
        frmMainGame.getLblTurnoValor()
                .setText(String.valueOf(this.frmMainGame.getGame().getNumTurn()));
    }

}
