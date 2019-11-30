/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;

import jogo.modelo.Action;
import jogo.visao.PanelAction;
import jogo.visao.FrmSaveRecovery;
import jogo.visao.FrmNewGame;
import jogo.visao.FrmStart;

/**
 *
 * @author Lucas
 */
public class Main {

    FrmStart frmStart;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FrmStart start = new FrmStart();
        start.setVisible(true);
        
    }
}
