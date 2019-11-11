/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo.modelo;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import jogo.visao.AcaoPainel;
public class TabelaAcoesTM extends AbstractTableModel {

    ArrayList<Acao> panels;

    public TabelaAcoesTM() {
        this.panels = new ArrayList<>();
    }

    public Class getColumnClass(int columnIndex) {
        return AcaoPainel.class;
    }

    public int getColumnCount() {
        return 1;
    }

    public String getColumnName(int columnIndex) {
        return "Ação";
    }

    public int getRowCount() {
        return panels.size();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return (getRowCount()<=0) ? null : panels.get(rowIndex);
    }

    public boolean isCellEditable(int columnIndex, int rowIndex) {
        return true;
    }
    
     public void addAcao(Acao acao) {
        panels.add(acao);
        fireTableDataChanged();
    }

    public Acao removeAcao(int linha) {
        Acao acao = panels.remove(linha);
        fireTableRowsDeleted(linha, linha);
        return acao;
    }

    public void remove(int linha) {
        panels.remove(linha);
        fireTableRowsDeleted(linha, linha);
    }

    public Acao getAcao(int linha) {
        return panels.get(linha);
    }

    public List<Acao> getAcaos() {
        return panels;
    }

    public void setAcaos(List<Acao> acaos) {
        int tamanhoArtigo = this.getRowCount();

        panels.addAll(acaos);
        fireTableRowsInserted(tamanhoArtigo, this.getRowCount());
    }

    public void limpar() {
        panels.clear();
        fireTableDataChanged();
    }

}
