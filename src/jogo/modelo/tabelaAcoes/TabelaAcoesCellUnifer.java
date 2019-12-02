package jogo.modelo.tabelaAcoes;

import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import jogo.modelo.Action;
import jogo.visao.PanelAction;

/**
 * Composta pelas 3 classes TabelaAcoes{CellComponent, CellEditor, CellRender}
 * para uso da tabela de ações
 *
 * @see TabelaAcoesCellComponent
 * @see TabelaAcoesCellEditor
 * @see TabelaAcoesCellRender
 *
 * @author Lucas
 */
public class TabelaAcoesCellUnifer extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {

    /**
     * @see TabelaAcoesCellComponent
     */
    public class CellComponent extends PanelAction {

        /**
         * Atualização dos dados do componente
         *
         * @param ac
         * @param isSelected
         * @param table
         */
        public void updateData(Action ac, boolean isSelected, JTable table) {
            this.setAcao(ac);
            this.reloadMyComponents();
            this.setBackground((isSelected)
                    ? table.getSelectionBackground()
                    : table.getBackground()
            );
        }

    }

    CellComponent cellComponent;

    public TabelaAcoesCellUnifer() {
        cellComponent = new CellComponent();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        if (!(value instanceof Action)) {
            return new JPanel();
        }

        cellComponent.updateData((Action) value, true, table);
        return cellComponent;
    }

    @Override
    public Object getCellEditorValue() {
        return null;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {

        if (!(value instanceof Action)) {
            return new JPanel();
        }

        cellComponent.updateData((Action) value, false, table);
        return cellComponent;
    }

}
