/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo.modelo;

import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import jogo.visao.AcaoPainel;

/**
 *
 * @author Lucas
 */
public class AcaoPainelCell extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {

    AcaoPainelCellComponent acaoComponent;

    Acao feed;

    public AcaoPainelCell() {
        acaoComponent = new AcaoPainelCellComponent();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        Acao feed = (Acao) value;
        acaoComponent.updateData(feed, true, table);
        return acaoComponent;
    }

    @Override
    public Object getCellEditorValue() {
        return null;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        Acao acao = (Acao) value;
        acaoComponent.updateData(acao, isSelected, table);
        return acaoComponent;
    }
}

/**
 * Componente do Painel para as Céluas da tabela. Extenção do modelo gráfico de
 * Paineis para a ação
 *
 * @see AcaoPainel
 *
 * @author Lucas
 */
class AcaoPainelCellComponent extends AcaoPainel {

    /**
     * Atualização do dos dados da Célula
     *
     * @param ac
     * @param isSelected
     * @param table
     */
    public void updateData(Acao ac, boolean isSelected, JTable table) {
        this.setAcao(ac);
        this.reloadMyComponents();
        if (isSelected) {
            setBackground(table.getSelectionBackground());
        } else {
            setBackground(table.getBackground());
        }
    }

}
