package jogo.modelo.tabelaAcoes;

import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import jogo.modelo.Acao;

/**
 * Editor de células para tabela de ações
 *
 * @see TabelaAcoesCellComponent
 * @see TabelaAcoesTableModel
 * @author Lucas
 */
public class TabelaAcoesCellEditor extends AbstractCellEditor implements TableCellEditor {

    TabelaAcoesCellComponent cellComponent;

    public TabelaAcoesCellEditor() {
        cellComponent = new TabelaAcoesCellComponent();
    }

    @Override
    public Object getCellEditorValue() {
        return null;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {

        if (!(value instanceof Acao)) {
            return new JPanel();
        }
        cellComponent.updateData((Acao) value, true, table);
        return cellComponent;
    }

}
