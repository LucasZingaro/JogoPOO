package tabelaAcoes;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import jogo.modelo.Action;
import java.util.ArrayList;
import jogo.modelo.tabelaAcoes.TabelaAcoesCellComponent;
import jogo.modelo.tabelaAcoes.TabelaAcoesCellEditor;
import jogo.modelo.tabelaAcoes.TabelaAcoesCellRender;
import jogo.modelo.tabelaAcoes.TabelaAcoesCellUnifer;
import jogo.modelo.tabelaAcoes.TabelaAcoesCellUnifer;
import jogo.modelo.tabelaAcoes.TabelaAcoesTableModel;
import jogo.visao.PanelAction;

/**
 * Controle do formulário de ações
 *
 * @see FrmTabelaAcoes
 * @see TabelaAcoesTableModel
 * @author Lucas
 */
public class CtrFrmTabelaAcoes implements ActionListener, ListSelectionListener {

    FrmTabelaAcoes frm;
    TabelaAcoesTableModel tmTabelaAcoes;

    public CtrFrmTabelaAcoes(FrmTabelaAcoes aThis) {
        this.frm = aThis;
        inicializarTableModel();
        adicionarListeners();

        //Exemplo de ações iniciais
        //ArrayList<Acao> acaoList = new ArrayList<>();
        //acaoList.add(new Action("AAA", 100, 11));
        //acaoList.add(new Action("BBB", 100, 22));
        //acaoList.add(new Action("CCC", 100, 33));
        //acaoList.add(new Action("DDD", 100, 44));
        //tmTabelaAcoes.setAcaoList(acaoList);
    }

    private void inicializarTableModel() {
        tmTabelaAcoes = new TabelaAcoesTableModel(5);
        frm.getTbAcoes().setModel(tmTabelaAcoes);

        //Possibilitam a renderização e edição dos componentes na tabela
//        /*
        frm.getTbAcoes().setDefaultRenderer(
                TabelaAcoesCellComponent.class,
                new TabelaAcoesCellRender()
        );
        frm.getTbAcoes().setDefaultEditor(
                TabelaAcoesCellComponent.class,
                new TabelaAcoesCellEditor()
        );
        //*/
        //Ou
//        frm.getTbAcoes().setDefaultRenderer(TabelaAcoesCellUnifer.CellComponent.class, new TabelaAcoesCellUnifer());
//        frm.getTbAcoes().setDefaultEditor(TabelaAcoesCellUnifer.CellComponent.class, new TabelaAcoesCellUnifer());

        //Definir tabanho das linhas
        Dimension d = new PanelAction().getMaximumSize();
        frm.getTbAcoes().setRowHeight(d.height);
    }

    private void adicionarListeners() {
        frm.getBtnAddAcao().addActionListener(this);
        frm.getBtnNewAcao().addActionListener(this);
        frm.getTbAcoes().getSelectionModel().addListSelectionListener(this);
        frm.getBtnPassarTurno().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Action:" + e.getActionCommand());
        if (e.getActionCommand().equals(frm.getBtnAddAcao().getText())) {
            tmTabelaAcoes.addAcao(new Action()
            );
            tmTabelaAcoes.reloadSelectionJTable(frm.getTbAcoes());

        } else if (e.getActionCommand().equals(frm.getBtnNewAcao().getText())) {
            tmTabelaAcoes.setValueAt(new Action(),
                    frm.getTbAcoes().getSelectedRow(),
                    frm.getTbAcoes().getSelectedColumn()
            );
            tmTabelaAcoes.reloadSelectionJTable(frm.getTbAcoes());

        } else if (e.getActionCommand().equals(frm.getBtnPassarTurno().getText())) {
            tmTabelaAcoes.getAcaoList().forEach((acao) -> {
                if (acao instanceof Action) {
                    acao.passarTurno();
                    System.out.println(acao);
                }
            });
            tmTabelaAcoes.fireTableDataChanged();
            tmTabelaAcoes.reloadSelectionJTable(frm.getTbAcoes());

        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        System.out.println("CtrAcoes.valueChanged()");

    }
}
