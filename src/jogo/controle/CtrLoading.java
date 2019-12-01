package jogo.controle;

import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import jogo.visao.FrmLoading;

/**
 *
 * @author Lucas
 */
public class CtrLoading {

    private final FrmLoading frmLoading;

    public CtrLoading(FrmLoading frmLoading) {
        this.frmLoading = frmLoading;
    }

    public FrmLoading getFrmLoading() {
        return frmLoading;
    }

    public void runLoadingJFrame(JFrame jframe, long period, long delay) {
        frmLoading.getProgressBarOfGame().setValue(0);
        frmLoading.setVisible(true);
        jframe.setVisible(false);
        new Thread(() -> {
            new Timer().scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    int value = frmLoading.getProgressBarOfGame().getValue();
                    frmLoading.getProgressBarOfGame().setValue(++value);
                    if (frmLoading.getProgressBarOfGame().getValue() >= 100) {
                        frmLoading.setVisible(false);
                        this.cancel();
                        jframe.setVisible(true);
                        jframe.requestFocus();
                    }
                }
            }, delay, period);
        }).start();
    }

    public void runLoadingJFrame(JFrame jframe, long period) {
        runLoadingJFrame(jframe, period, 0);
    }

    public void runLoadingJFrame(JFrame jframe) {
        runLoadingJFrame(jframe, 10);
    }

}
