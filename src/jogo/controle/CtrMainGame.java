package jogo.controle;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
 * Controle da tela principal do jogo
 */
public class CtrMainGame {

    FrmMainGame frmMainGame;
    TabelaAcoesTableModel tabelaAcoesTableModel;

    public CtrMainGame(FrmMainGame frmMainGame) {
        this.frmMainGame = frmMainGame;
        Main.frmMainGame = frmMainGame;
        startTbModel();
        addActionListeners();
    }

    private void startTbModel() {
        this.tabelaAcoesTableModel = new TabelaAcoesTableModel(5);
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
        reloadTableAcoes();
    }

    /**
     * Adiciona os listadores de Ações
     */
    private void addActionListeners() {
        frmMainGame.getBtnPassarTurno()
                .addActionListener((ActionEvent e) -> actionBtnPassarTurno());
        frmMainGame.getBtnPatrimonio()
                .addActionListener((ActionEvent e) -> actionBtnPatrimonio());
        frmMainGame.getBtnVisaoGeral()
                .addActionListener((ActionEvent e) -> actionBtnVisaoGeral());

        frmMainGame.getMiMenu()
                .addActionListener((ActionEvent e) -> actionMiMenu());
        frmMainGame.getMiSair()
                .addActionListener((ActionEvent e) -> actionMiSair());
        frmMainGame.getMiSalvar()
                .addActionListener((ActionEvent e) -> actionMiSalvar());
//        frmMainGame.getMenuAjuda()
//                .addActionListener((ActionEvent e) -> actionMenuAjuda());
        frmMainGame.getMenuAjuda()
                .addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        actionMenuAjuda();
                    }
                });
    }

    private void actionBtnPassarTurno() {
        System.out.println("PassarTurno");
        frmMainGame.getGame().passarTurno();
        Main.reloadAllFrames();
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
            disposeGameFrames();
            try {
                new FrmLoading().getListeners().runLoadingJFrame(Main.frmStart);
            } catch (Exception e) {
                new FrmLoading().getListeners().runLoadingJFrame(new FrmStart());
            }
        }
    }

    private void actionBtnPatrimonio() {
        try {
            Main.frmPlayerDetails.getListeners().reloadComponents();
            Main.frmPlayerDetails.setVisible(true);
            Main.frmPlayerDetails.requestFocus();
        } catch (Exception e) {
            System.out.println("Criando frmPlayerDetails");
            Main.frmPlayerDetails = new FrmPlayerDetails();
            Main.frmPlayerDetails.setPlayer(frmMainGame.getGame().getPlayer());
            Main.frmPlayerDetails.getListeners().reloadComponents();
            Main.frmPlayerDetails.setVisible(true);
            Main.frmPlayerDetails.requestFocus();
        }

    }

    private void actionBtnVisaoGeral() {
        try {
            Main.frmMarketDetails.getListeners().reloadComponents();
            Main.frmMarketDetails.setVisible(true);
            Main.frmMarketDetails.requestFocus();
        } catch (Exception e) {
            System.out.println("Criando frmMarketDetails");
            Main.frmMarketDetails = new FrmMarketDetails();
            Main.frmMarketDetails.setMercado(frmMainGame.getGame().getMarket());
            Main.frmMarketDetails.getListeners().reloadComponents();
            Main.frmMarketDetails.setVisible(true);
            Main.frmMarketDetails.requestFocus();
        }
    }

    private void actionMiMenu() {
        switch (JOptionPane.showConfirmDialog(frmMainGame,
                "Deseja voltar ao menu?", "Menu Inicial",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE)) {

            case JOptionPane.YES_OPTION:
                disposeGameFrames();
                try {
                    new FrmLoading().getListeners()
                            .runLoadingJFrame(Main.frmStart);
                } catch (Exception e) {
                    new FrmLoading().getListeners()
                            .runLoadingJFrame(new FrmStart());
                }
                break;
        }
    }

    private void actionMiSair() {
        switch (JOptionPane.showConfirmDialog(frmMainGame,
                "Deseja sair do jogo?", "Sair",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE)) {

            case JOptionPane.YES_OPTION:
                disposeGameFrames();
                System.exit(0);
                break;
        }
    }

    private void actionMiSalvar() {
        JOptionPane.showMessageDialog(frmMainGame, "Salvando...");
    }

    private void actionMenuAjuda() {
        JOptionPane.showMessageDialog(frmMainGame,
                "Ajuda:...XD",
                "Ajuda",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void disposeGameFrames() {
        try {
            Main.frmLoansDetails.setVisible(false);
            Main.frmLoansDetails.dispose();
        } catch (Exception e) {
        }
        try {
            Main.frmActionDetails.setVisible(false);
            Main.frmActionDetails.dispose();
        } catch (Exception e) {
        }
        try {
            Main.frmMarketDetails.setVisible(false);
            Main.frmMarketDetails.dispose();
        } catch (Exception e) {
        }
        try {
            Main.frmPlayerDetails.setVisible(false);
            Main.frmPlayerDetails.dispose();
        } catch (Exception e) {
        }
        try {
            Main.frmMainGame.setVisible(false);
            Main.frmMainGame.dispose();
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

    public void reloadTableAcoes() {
        //recarregar tabela com dados

        tabelaAcoesTableModel.limpar();
        Main.game.getMarket().getMarketListActions().forEach((Action a) -> {
            tabelaAcoesTableModel.addAcao(a);
        });
        tabelaAcoesTableModel.fireTableDataChanged();
    }

}
