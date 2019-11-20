package jogo.modelo.tabelaAcoes;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import jogo.modelo.Acao;

/**
 * Modelo da tabela de ações
 *
 * @see Acao
 * @see TabelaAcoesCellUnifer
 *
 * @author Lucas
 */
public final class TabelaAcoesTableModel extends AbstractTableModel {

    ArrayList<Acao> acaoList;
    private String[] colunas;

    public TabelaAcoesTableModel(Integer nColulas) {
        this.acaoList = new ArrayList<>();

        nColulas = (nColulas == null || nColulas <= 0) ? 1 : nColulas;
        this.colunas = new String[nColulas];
        for (int i = 0; i < nColulas; i++) {
            colunas[i] = "Ações";
        }
    }

    public TabelaAcoesTableModel(Integer nColulas, ArrayList<Acao> acaoList) {
        this(nColulas);
        this.setAcaoList(acaoList);
    }

    public TabelaAcoesTableModel(Integer nColulas, List<Acao> acaoList) {
        this(nColulas);
        this.setAcaoList(acaoList);
    }

    public TabelaAcoesTableModel() {
        this(3);
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        return TabelaAcoesCellUnifer.CellComponent.class;
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public int getRowCount() {
        float percentual = (acaoList.size() / colunas.length);
        int pInteger = Math.round(percentual);

        percentual = (pInteger > percentual) ? (pInteger) : (percentual);

        percentual = (pInteger < percentual) ? (pInteger + 1) : (percentual);

        return ((int) percentual);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (this.getIndexBy(rowIndex, columnIndex) == -1) {
            return null;
        }
        return (getRowCount() <= 0) ? null : acaoList.get(this.getIndexBy(rowIndex, columnIndex));
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (this.getIndexBy(rowIndex, columnIndex) >= 0 && aValue instanceof Acao) {
            acaoList.set(this.getIndexBy(rowIndex, columnIndex), (Acao) aValue);
            fireTableCellUpdated(rowIndex, columnIndex);
        }
    }

    @Override
    public boolean isCellEditable(int columnIndex, int rowIndex) {
        return true;
    }

    public ArrayList<Acao> getAcaoList() {
        return acaoList;
    }

    public void setAcaoList(ArrayList<Acao> acaoList) {
        this.acaoList = acaoList;
        this.nullCompletation();
        fireTableDataChanged();
    }

    public void setAcaoList(List<Acao> acaoList) {
        this.acaoList.clear();
        this.acaoList.addAll(acaoList);
        this.nullCompletation();
        fireTableDataChanged();
    }

    public void setAcaoList(Acao[] acaoList) {
        this.acaoList.clear();
        for (Acao acao : acaoList) {
            this.acaoList.add(acao);
        }
        this.nullCompletation();
        fireTableDataChanged();
    }

    public void addAcao(Acao acao) {
        this.nullRemotion();
        acaoList.add(acao);
        this.nullCompletation();
        fireTableDataChanged();
    }

    public void addAcoes(List<Acao> acoes) {
        int tamanhoArtigo = this.getRowCount();
        acaoList.addAll(acoes);
        fireTableRowsInserted(tamanhoArtigo, this.getRowCount());
    }

    /**
     * Remoção de um item da tabela
     *
     * @param linha
     * @param coluna
     * @return Acão desejada
     */
    public Acao removeAcao(int linha, int coluna) {
        Acao acao = acaoList.remove(this.getIndexBy(linha, coluna));
        fireTableRowsDeleted(linha, linha);
        return acao;
    }

    /**
     * Deletar ação da tabela
     *
     * @param rowIndex index da linha
     * @param columnIndex index da coluna
     */
    public void delete(int rowIndex, int columnIndex) {
        acaoList.remove(this.getIndexBy(rowIndex, columnIndex));
        fireTableRowsDeleted(rowIndex, rowIndex);
    }

    /**
     * Deletar ação tabela
     *
     * @param acao Objeto desejado
     * @return Se foi deletado com sucesso.
     */
    public boolean delete(Acao acao) {
        boolean isDeleted = acaoList.remove(acao);
        fireTableDataChanged();
        return isDeleted;
    }

    public void limpar() {
        acaoList.clear();
        fireTableDataChanged();
    }

    /**
     * Obter index do Array de Ações, pelas coordenadas da tabela
     *
     * @param rowIndex Index da Linha
     * @param columnIndex Index da Coluna
     * @return Index
     */
    private int getIndexBy(int rowIndex, int columnIndex) {
        if (rowIndex > this.getRowCount() || rowIndex < 0) {
            return -1;
        }
        if (columnIndex > this.getColumnCount() || columnIndex < 0) {
            return -1;
        }
        int index = (rowIndex + columnIndex) + ((getColumnCount() - 1) * rowIndex);
        return index;
    }

    /**
     * Recarrega a seleção de uma Jtable qualquer, para corrigir eventuais bugs
     *
     * @param jtable
     */
    public void reloadSelectionJTable(JTable jtable) {
        jtable.selectAll();
        jtable.clearSelection();
    }

    /**
     * Remoção de todos os componentes nullos da lista
     */
    private void nullRemotion() {
        while (acaoList.indexOf(null) >= 0) {
            acaoList.remove(null);
        }
    }

    /**
     * Preenchimento da linha incompleta, para renderização na JTable
     */
    private void nullCompletation() {
        while ((acaoList.size() % colunas.length) != 0) {
            acaoList.add(null);
        }
    }


}
