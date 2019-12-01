package jogo;

import jogo.modelo.Game;
import jogo.visao.FrmLoading;
import jogo.visao.FrmStart;

/**
 * Classe Principal e refêrencia para reiniciar
 */
public class Main {

    public static FrmStart frmStart;
    public static FrmLoading frmLoading;
    public static Game game = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        frmStart = new FrmStart();
        frmLoading = new FrmLoading();
        frmLoading.getListeners().runLoadingJFrame(frmStart);
    }
}
