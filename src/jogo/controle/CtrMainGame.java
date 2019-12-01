/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo.controle;

import java.awt.Dimension;
import javax.swing.JOptionPane;
import jogo.Main;
import jogo.modelo.Action;
import jogo.modelo.tabelaAcoes.TabelaAcoesCellComponent;
import jogo.modelo.tabelaAcoes.TabelaAcoesCellEditor;
import jogo.modelo.tabelaAcoes.TabelaAcoesCellRender;
import jogo.modelo.tabelaAcoes.TabelaAcoesTableModel;
import jogo.visao.FrmLoading;
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
    TabelaAcoesTableModel tabelaAcoesTableModel;
    FrmPlayerDetails frmPlayerDetails = null;
    FrmMarketDetails frmMarketDetails = null;

    public CtrMainGame(FrmMainGame frmMainGame) {
        this.frmMainGame = frmMainGame;
        startTbModel();
        addActionListeners();
    }

    private void startTbModel() {
        this.tabelaAcoesTableModel = new TabelaAcoesTableModel(5, Main.game.getMarket().getMarketListActions());
        this.frmMainGame.getTabelaAcoes().setModel(tabelaAcoesTableModel);
        frmMainGame.getTabelaAcoes().setDefaultRenderer(
                TabelaAcoesCellComponent.class,
                new TabelaAcoesCellRender()
        );
        frmMainGame.getTabelaAcoes().setDefaultEditor(
                TabelaAcoesCellComponent.class,
                new TabelaAcoesCellEditor()
        );
        Dimension d = new TabelaAcoesCellComponent().getMaximumSize();
        frmMainGame.getTabelaAcoes().setRowHeight(d.height);
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
        frmMainGame.getGame().passarTurno();
        this.reloadComponents();
        if (frmMainGame.getGame().getPlayer().getMoney() < 0) {
            JOptionPane.showConfirmDialog(frmMainGame,
                    "Você declara falência financeira"
                    + "\n\nVocê faliu em: " + frmMainGame.getGame().getNumTurn() + " turnos"
                    + "\n Saldo: R$ " + frmMainGame.getGame().getPlayer().getMoney()
                    + "\n\nEmpréstimos: \n" + frmMainGame.getGame().getPlayer().getLoanList()
                    + "\n\n\nAções:\n" + frmMainGame.getGame().getPlayer().getPlayerListActions(),
                    "Game Over",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.OK_OPTION);
        }
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
                Main.frmStart = new FrmStart();
                new FrmLoading().getListeners().runLoadingJFrame(Main.frmStart);
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
        try {
            frmMarketDetails.setVisible(false);
            frmMarketDetails.dispose();
            frmPlayerDetails.setVisible(false);
            frmPlayerDetails.dispose();
            frmMainGame.setVisible(false);
            frmMainGame.dispose();
        } catch (Exception e) {
        }
    }

    public void reloadComponents() {
        frmMainGame.getLblNomeValor()
                .setText(String.valueOf(this.frmMainGame.getGame().getPlayer().getName()));
        frmMainGame.getLblSaldoValor()
                .setText(String.valueOf(this.frmMainGame.getGame().getPlayer().getMoney()));
        frmMainGame.getLblTurnoValor()
                .setText(String.valueOf(this.frmMainGame.getGame().getNumTurn()));

        //tabela de ações
        tabelaAcoesTableModel.fireTableDataChanged();
        tabelaAcoesTableModel.reloadSelectionJTable(frmMainGame.getTabelaAcoes());
    }

}
