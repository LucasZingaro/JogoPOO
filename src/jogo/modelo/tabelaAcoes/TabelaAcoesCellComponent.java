package jogo.modelo.tabelaAcoes;

import javax.swing.JTable;
import jogo.modelo.Action;
import jogo.visao.PanelAction;

/**
 * Componente Painel para representação das Ações na tabela.
 *
 * @see PanelAction
 * @see TabelaAcoesTableModel
 *
 * @author Lucas
 */
public class TabelaAcoesCellComponent extends PanelAction {

    /**
     * Atualização dos dados do componente
     *
     * @param acao
     * @param isSelected
     * @param table
     */
    public void updateData(Action acao, boolean isSelected, JTable table) {
        this.setAcao(acao);
        this.reloadMyComponents();
        this.setBackground((isSelected)
                ? table.getSelectionBackground()
                : table.getBackground()
        );
    }
}
