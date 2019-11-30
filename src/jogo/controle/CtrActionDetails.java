/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo.controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import jogo.visao.FrmActionDetails;

/**
 * Classe de controle do FrmActionDetails.
 *
 * @see FrmActionDetails
 * @author Lucas
 */
public class CtrActionDetails implements ActionListener {

    FrmActionDetails frm;

    public CtrActionDetails(FrmActionDetails frm) {
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
