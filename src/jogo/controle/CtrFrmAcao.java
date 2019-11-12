/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo.controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import jogo.visao.FrmAcao;

/**
 * Classe de controle do FrmAcao.
 *
 * @see FrmAcao
 * @author Lucas
 */
public class CtrFrmAcao implements ActionListener {

    FrmAcao frm;

    public CtrFrmAcao(FrmAcao frm) {
        this.frm = frm;
        addActionListeners();
    }

    /**
     * Adiciona os listadores de Ações
     */
    private void addActionListeners() {

    }

    /**
     * Chamado quando uma ação ocorre.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
