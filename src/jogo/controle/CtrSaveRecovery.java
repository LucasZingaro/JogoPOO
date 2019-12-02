package jogo.controle;

import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jogo.Main;
import static jogo.Main.frmNewGame;
import jogo.dao.GameDAO;
import jogo.modelo.Game;
import jogo.modelo.Player;
import jogo.modelo.PurchaseOrder;
import jogo.visao.FrmLoading;
import jogo.visao.FrmMainGame;
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
        String columnNames[] = {"id", "Nome Jogador", "Saldo", "Turno"};
        tbCarregarJogoTM = new DefaultTableModel(columnNames, 0);
        frmSaveRecovery.getTbCarregarJogo().setModel(tbCarregarJogoTM);
        try {
            reloadTabela();
        } catch (SQLException ex) {
            Logger.getLogger(CtrSaveRecovery.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        int id = (int) tbCarregarJogoTM.getValueAt(frmSaveRecovery.getTbCarregarJogo().getSelectedRow(), 0);

        GameDAO gamedao = new GameDAO();
        try {
            Game loadGame = gamedao.localizarGame(id);

            //GameCarregando
            Main.game = new Game(new Player("Carregando..."));

            FrmMainGame frmMainGame = new FrmMainGame();
            //display loading
            new FrmLoading().getListeners().runLoadingJFrame(frmMainGame);

            //buscando o jogo
            Main.game = loadGame;
            frmMainGame.setGame(Main.game);
            frmMainGame.getListeners().reloadComponents();
            //frmNewGame.dispose();

        } catch (SQLException ex) {
            Logger.getLogger(CtrSaveRecovery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void reloadComponents() {
        //reload components, chamado geral
    }

    private void reloadTabela() throws SQLException {
        //recarregar tabela com dados do banco
        System.out.println("Recarregando tabela com dados do banco");
        //limpa todas as linhas
        for (int i = 0; i < tbCarregarJogoTM.getRowCount(); i++) {
            tbCarregarJogoTM.removeRow(i);
        }

        GameDAO gamedao = new GameDAO();
        ArrayList<Game> gameList = gamedao.ListaGames();
        for (Game obj : gameList) {
            //popular com 1 item (pode fazer repetição)
            tbCarregarJogoTM.addRow(new Object[]{
                obj.getId(),
                obj.getPlayer().getName(),
                obj.getPlayer().getMoney(),
                obj.getNumTurn()
            });
        }

        tbCarregarJogoTM.fireTableDataChanged();

    }

}
