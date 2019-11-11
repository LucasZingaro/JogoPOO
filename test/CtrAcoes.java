/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import jogo.modelo.Acao;
import jogo.modelo.AcaoPainelCell;
import jogo.modelo.TabelaAcoesTM;
import jogo.visao.AcaoPainel;

/**
 *
 * @author Lucas
 */
public class CtrAcoes implements ActionListener, ListSelectionListener {

    FrmTabela frm;
    TabelaAcoesTM tmTabelaAcoes;
    ArrayList<Acao> acaos = new ArrayList<>();
    ArrayList<AcaoPainel> acaosP = new ArrayList<>();

    public CtrAcoes(FrmTabela aThis) {
        this.frm = aThis;
        inicializarTableModel();
        adicionarListeners();
    }

    private void inicializarTableModel() {

        tmTabelaAcoes = new TabelaAcoesTM();

        frm.getJtbAcoes().setModel(tmTabelaAcoes);

        frm.getJtbAcoes().setDefaultRenderer(AcaoPainel.class, new AcaoPainelCell());
        frm.getJtbAcoes().setDefaultEditor(AcaoPainel.class, new AcaoPainelCell());

        Dimension d = new AcaoPainel().getMaximumSize();
        frm.getJtbAcoes().setRowHeight(d.height);
    }

    private void adicionarListeners() {
        frm.getJbtnShow().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Action:" + e.getActionCommand());
        if (e.getActionCommand().equals(frm.getJbtnShow().getText())) {
            tmTabelaAcoes.addAcao(
                    new Acao()
            );
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
