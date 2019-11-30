/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo.controle;

import jogo.visao.FrmSaveRecovery;
import jogo.visao.FrmNewGame;
import jogo.visao.FrmStart;

/**
 * Classe de controle do FrmStart.
 *
 * @see FrmStart
 * @author Lucas
 */
public class CtrStart {

    FrmStart frm;

    public CtrStart(FrmStart frm) {
        this.frm = frm;
        addActionListeners();
    }

    /**
     * Adiciona os listadores de Ações
     */
    private void addActionListeners() {
        frm.getBtnCarregarJogo().addActionListener(e -> actionBtnCarregarJogo());
        frm.getBtnNovoJogo().addActionListener(e -> actionBtnNovoJogo());
    }

    /**
     * Ação para abrir o FrmCarregaJogo
     *
     * @see FrmSaveRecovery
     */
    private void actionBtnCarregarJogo() {
        new FrmSaveRecovery().setVisible(true);
        frm.dispose();
    }

    /**
     * Ação para abrir o FrmIniciarComNome
     *
     * @see FrmNewGame
     */
    private void actionBtnNovoJogo() {
        new FrmNewGame().setVisible(true);
        frm.dispose();
    }

}
