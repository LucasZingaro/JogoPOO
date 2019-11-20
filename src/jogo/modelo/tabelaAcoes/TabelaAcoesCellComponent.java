/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo.modelo.tabelaAcoes;

import javax.swing.JTable;
import jogo.modelo.Acao;
import jogo.visao.AcaoPainel;

/**
 * Componente Painel para representação das Ações na tabela.
 *
 * @see AcaoPainel
 * @see TabelaAcoesTableModel
 *
 * @author Lucas
 */
public class TabelaAcoesCellComponent extends AcaoPainel {

    /**
     * Atualização dos dados do componente
     *
     * @param acao
     * @param isSelected
     * @param table
     */
    public void updateData(Acao acao, boolean isSelected, JTable table) {
        this.setAcao(acao);
        this.reloadMyComponents();
        this.setBackground((isSelected)
                ? table.getSelectionBackground()
                : table.getBackground()
        );
    }
}
