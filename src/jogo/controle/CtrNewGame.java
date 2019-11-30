/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo.controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import jogo.modelo.Game;
import jogo.visao.FrmMainGame;
import jogo.visao.FrmNewGame;
import jogo.visao.FrmStart;

/**
 * Classe de controle do FrmNewGame.
 *
 * @see FrmNewGame
 * @author Lucas
 */
public class CtrNewGame implements ActionListener {

    FrmNewGame frm;

    public CtrNewGame(FrmNewGame frm) {
        this.frm = frm;
        addActionListeners();
    }

    /**
     * Adiciona os listadores de Ações
     */
    private void addActionListeners() {
        frm.getBtnVoltar().addActionListener(this);
        frm.getBtnIniciar().addActionListener(this);
    }

    /**
     * Chamado quando uma ação ocorre.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(frm.getBtnVoltar().getText())) {
            actionBtnVoltar();
        }else if (e.getActionCommand().equals(frm.getBtnIniciar().getText())) {
            actionBtnIniciar();
        }
    }

    /**
     * Ação para Voltar ao o FrmStart
     *
     * @see FrmStart
     */
    private void actionBtnVoltar() {
        new FrmStart().setVisible(true);
        frm.dispose();
    }
    /**
     * Ação para Iniciar a Partida
     */
    private void actionBtnIniciar() {
        FrmMainGame frmMainGame = new FrmMainGame();
        frmMainGame.setGame(new Game());
        //Montrar introdução(se tiver)
        frmMainGame.setVisible(true);
        frm.dispose();
        
        JOptionPane.showMessageDialog(frm, "Olá,"+frm.getTxtNome().getText()+";\n\nIniciando....", "Iniciar", JOptionPane.INFORMATION_MESSAGE);
    }

}
