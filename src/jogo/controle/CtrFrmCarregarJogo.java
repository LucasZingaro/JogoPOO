/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo.controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import jogo.visao.FrmCarregarJogo;
import jogo.visao.FrmStart;

/**
 * Classe de controle do FrmCarregarJogo.
 *
 * @see FrmCarregarJogo
 * @author Lucas
 */
public class CtrFrmCarregarJogo implements ActionListener {

    FrmCarregarJogo frm;

    public CtrFrmCarregarJogo(FrmCarregarJogo frm) {
        this.frm = frm;
        addActionListeners();
    }

    /**
     * Adiciona os listadores de Ações
     */
    private void addActionListeners() {
        frm.getBtnVoltar().addActionListener(this);
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

}
