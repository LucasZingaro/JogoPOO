package jogo;

import java.util.ArrayList;
import javax.swing.JFrame;
import jogo.modelo.Action;
import jogo.modelo.Game;
import jogo.modelo.PurchaseOrder;
import jogo.modelo.StatusEnum;
import jogo.visao.FrmActionDetails;
import jogo.visao.FrmLoading;
import jogo.visao.FrmLoansDetails;
import jogo.visao.FrmMainGame;
import jogo.visao.FrmMarketDetails;
import jogo.visao.FrmNewGame;
import jogo.visao.FrmPlayerDetails;
import jogo.visao.FrmSaveRecovery;
import jogo.visao.FrmStart;

/**
 * Classe Principal e refêrencia para reiniciar
 */
public class Main {

    //Referências da sessão do jogo
    public static Game game;
    public static FrmStart frmStart;
    public static FrmLoading frmLoading;
    public static FrmNewGame frmNewGame;
    public static FrmSaveRecovery frmSaveRecovery;
    public static FrmMainGame frmMainGame;
    public static FrmMarketDetails frmMarketDetails;
    public static FrmActionDetails frmActionDetails;
    public static FrmPlayerDetails frmPlayerDetails;
    public static FrmLoansDetails frmLoansDetails;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Main.frmStart = new FrmStart();
        Main.frmLoading = new FrmLoading();
        Main.frmLoading.getListeners().runLoadingJFrame(frmStart);
    }

    public static void disposeAllFrames() {
        JFrame[] jframes = {frmStart, frmLoading, frmNewGame, frmSaveRecovery,
            frmMainGame, frmMarketDetails, frmActionDetails, frmPlayerDetails, frmLoansDetails};
        for (JFrame jframe : jframes) {
            try {
                jframe.setVisible(false);
                jframe.dispose();
            } catch (Exception e) {
            }
        }
    }

    public static void reloadAllFrames() {
        try {
            frmStart.getListener();
        } catch (Exception e) {
        }
        try {
            frmLoading.getListeners();
        } catch (Exception e) {
        }
        try {
            frmNewGame.getListeners().reloadComponents();
        } catch (Exception e) {
        }
        try {
            frmSaveRecovery.getListeners().reloadComponents();
        } catch (Exception e) {
        }
        try {
            frmMainGame.getListeners().reloadComponents();
        } catch (Exception e) {
        }
        try {
            frmMarketDetails.getListeners().reloadComponents();
        } catch (Exception e) {
        }
        try {
            frmActionDetails.getListeners().reloadComponents();
        } catch (Exception e) {
        }
        try {
            frmPlayerDetails.getListeners().reloadComponents();
        } catch (Exception e) {
        }
        try {
            frmLoansDetails.getListeners().reloadComponents();
        } catch (Exception e) {
        }
    }
}
