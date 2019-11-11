/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo.controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import jogo.visao.FrmCarregarJogo;
import jogo.visao.FrmNovoJogo;
import jogo.visao.FrmStart;

/**
 * Classe de controle do FrmStart.
 *
 * @see FrmStart
 * @author Lucas
 */
public class CtrFrmStart implements ActionListener {

    FrmStart frm;

    public CtrFrmStart(FrmStart frm) {
        this.frm = frm;
        addActionListeners();
    }

    /**
     * Adiciona os listadores de Ações
     */
    private void addActionListeners() {
        frm.getBtnCarregarJogo().addActionListener(this);
        frm.getBtnNovoJogo().addActionListener(this);
    }

    /**
     * Chamado quando uma ação ocorre.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(frm.getBtnCarregarJogo().getText())) {
            actionBtnCarregarJogo();
        } else if (e.getActionCommand().equals(frm.getBtnNovoJogo().getText())) {
            actionBtnNovoJogo();
        }
    }

    /**
     * Ação para abrir o FrmCarregaJogo
     *
     * @see FrmCarregarJogo
     */
    private void actionBtnCarregarJogo() {
        new FrmCarregarJogo().setVisible(true);
        frm.dispose();
    }

    /**
     * Ação para abrir o FrmIniciarComNome
     *
     * @see FrmNovoJogo
     */
    private void actionBtnNovoJogo() {
        new FrmNovoJogo().setVisible(true);
        frm.dispose();
    }

}
