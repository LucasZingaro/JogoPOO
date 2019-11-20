package jogo.modelo.tabelaAcoes;

import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import jogo.modelo.Acao;

/**
 * Renderizador de célula para tabela de ações;
 *
 * @see TabelaAcoesCellComponent
 * @see TabelaAcoesTableModel
 * @author Lucas
 */
public class TabelaAcoesCellRender implements TableCellRenderer {

    TabelaAcoesCellComponent cellComponent;

    public TabelaAcoesCellRender() {
        cellComponent = new TabelaAcoesCellComponent();
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {

        if (!(value instanceof Acao)) {
            return new JPanel();
        }
        cellComponent.updateData((Acao) value, false, table);
        return cellComponent;
    }

}
