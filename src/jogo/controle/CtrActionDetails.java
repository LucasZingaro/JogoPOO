package jogo.controle;

import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import jogo.Config;
import jogo.Main;
import jogo.Util;
import jogo.modelo.PurchaseOrder;
import jogo.modelo.SalesOrder;
import jogo.visao.FrmActionDetails;

/**
 * Classe de controle do FrmActionDetails.
 *
 * @see FrmActionDetails
 */
public class CtrActionDetails {

    FrmActionDetails frmActionDetails;
    DefaultTableModel tbAcoesCompraTM;
    DefaultTableModel tbAcoesVEndaTM;

    public CtrActionDetails(FrmActionDetails frmActionDetails) {
        this.frmActionDetails = frmActionDetails;
        Main.frmActionDetails = frmActionDetails;
        addActionListeners();
        startTables();
    }

    /**
     * Adiciona os listadores de Ações
     */
    private void addActionListeners() {
        frmActionDetails.getBtnOrdens().addActionListener(e -> actionBtnOrdens());
        frmActionDetails.getBtnComprar().addActionListener(e -> actionBtnComprar());
        frmActionDetails.getBtnVender().addActionListener(e -> actionBtnVender());
    }

    private void startTables() {
        String columnsNames[] = {"Quantidades", "Valor"};
        tbAcoesCompraTM = new DefaultTableModel(columnsNames, 0);
        frmActionDetails.getTbAcoesCompra().setModel(tbAcoesCompraTM);
        reloadTbAcoesCompra();
        tbAcoesVEndaTM = new DefaultTableModel(columnsNames, 0);
        frmActionDetails.getTbAcoesVenda().setModel(tbAcoesVEndaTM);
        reloadTbAcoesVenda();
    }

    private void reloadTbAcoesCompra() {
        for (int i = 0; i < tbAcoesCompraTM.getRowCount(); i++) {
            tbAcoesCompraTM.removeRow(i);
        }
        frmActionDetails.getAction().getPurchaseOrderList().forEach((PurchaseOrder po) -> {
            if (!po.isIsFromPlayer()) {
                tbAcoesCompraTM.addRow(new Object[]{
                    po.getQuantity(), po.getValue()}
                );
            }
        });

        tbAcoesCompraTM.fireTableDataChanged();
    }

    private void reloadTbAcoesVenda() {
        for (int i = 0; i < tbAcoesVEndaTM.getRowCount(); i++) {
            tbAcoesVEndaTM.removeRow(i);
        }
        frmActionDetails.getAction().getSalesOrderList().forEach((SalesOrder so) -> {
            if (!so.isIsFromPlayer()) {
                tbAcoesVEndaTM.addRow(new Object[]{
                    so.getQuantity(), so.getValue()}
                );
            }
        });

        tbAcoesVEndaTM.fireTableDataChanged();
    }

    public void reloadComponents() {
        frmActionDetails.getLblNomeValor()
                .setText(String.valueOf(frmActionDetails
                        .getAction().getName()));

        frmActionDetails.getLblPrecoUniValor()
                .setText("R$ " + String.valueOf(frmActionDetails
                        .getAction().getValue()));

        frmActionDetails.getLblQuantidadeJogadorValor()
                .setText(String.valueOf(frmActionDetails
                        .getAction().getPlayerQuantity()));

        frmActionDetails.getLblQuantidadeValor()
                .setText(String.valueOf(frmActionDetails
                        .getAction().getMarketQuantity()));

        frmActionDetails.getLblStatusAcaoValor()
                .setText(String.valueOf(frmActionDetails
                        .getAction().getStatus()));

        frmActionDetails.getLblVariacaoValor()
                .setText(String.valueOf(frmActionDetails
                        .getAction().getVariation()) + "%");
        try {
            reloadTbAcoesCompra();
        } catch (Exception e) {
        }

        try {
            reloadTbAcoesVenda();
        } catch (Exception e) {
        }
    }

    private void actionBtnOrdens() {
        //exibir ordens de compra
        ArrayList<PurchaseOrder> playerPurchaseOrderList = new ArrayList<>();
        System.out.println(this.frmActionDetails.getAction());
        if (this.frmActionDetails.getAction().getPurchaseOrderList().size() > 0) {
            this.frmActionDetails.getAction().getPurchaseOrderList().forEach((purchaseOrder) -> {
                if (purchaseOrder.isIsFromPlayer()) {
                    playerPurchaseOrderList.add(purchaseOrder);
                }
            });
            JScrollPane jp = new JScrollPane(new JTextArea(playerPurchaseOrderList.toString()));
            JOptionPane.showMessageDialog(frmActionDetails, jp,
                    "Ordens de Compra", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(frmActionDetails,
                    "Você não tem nenhuma Ordem de Compra!!!",
                    "Ordens de Compra", JOptionPane.INFORMATION_MESSAGE);
        }

        //exibir ordens de venda
        ArrayList<SalesOrder> playerSalesOrderList = new ArrayList<>();
        if (this.frmActionDetails.getAction().getSalesOrderList().size() > 0) {
            this.frmActionDetails.getAction().getSalesOrderList().forEach((salesOrder) -> {
                if (salesOrder.isIsFromPlayer()) {
                    playerSalesOrderList.add(salesOrder);
                }
            });
            JScrollPane js = new JScrollPane(new JTextArea(playerSalesOrderList.toString()));
            JOptionPane.showMessageDialog(frmActionDetails, js,
                    "Ordens de Venda", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(frmActionDetails,
                    "Você não tem nenhuma Ordem de Venda!!!",
                    "Ordens de Venda", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void actionBtnComprar() {
        //pegar a quantidade desejada
        int qtd = getIntFromJOP(frmActionDetails,
                "Quantidade desejada:", "Ordem de Compra");
        if (qtd < 1) {
            return;
        }

        //pegar valor desejado para comprar
        double valor = getDoubleFromJOP(frmActionDetails,
                "Valor desejado:", "Ordem de Compra");
        if (valor < 0) {
            return;
        }

        //pegar turno final
        int turnoFinal = 0;
        do {
            turnoFinal = getIntFromJOP(frmActionDetails,
                    "Turno de vencimento(até " + Config.MAX_TURN + "):", "Ordem de Compra");
            if (turnoFinal < 0) {
                return;
            }
        } while (turnoFinal <= Main.game.getNumTurn());

        PurchaseOrder purchaseOrder = new PurchaseOrder(
                frmActionDetails.getAction(), qtd, valor,
                Main.game.getNumTurn(), turnoFinal, true);

        //Confirmar venda
        switch (JOptionPane.showConfirmDialog(frmActionDetails,
                "Confirma a ordem de compra?\n"
                + "\nAção:" + purchaseOrder.getAction().getName()
                + "\nQuantidade" + purchaseOrder.getQuantity()
                + "\nValor Desejado:" + purchaseOrder.getValue()
                + "\nTurno de Vencimento:" + purchaseOrder.getEndTurn(),
                "Odem de compra",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {

            case JOptionPane.YES_OPTION:
                frmActionDetails.getAction()
                        .getPurchaseOrderList().add(purchaseOrder);
                break;
        }
    }

    private void actionBtnVender() {
        //verificar se têm esse valor
        if (frmActionDetails.getAction().getPlayerQuantity() < 1) {
            JOptionPane.showConfirmDialog(frmActionDetails,
                    "Você não possue nenhuma quantidade desta ação!!", "Aviso",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.OK_OPTION);
            return;
        }

        //pegar a quantidade desejada
        int qtd = 0;
        do {
            qtd = getIntFromJOP(frmActionDetails,
                    "Quantidade desejada:", "Ordem de Venda");
            if (qtd < 1) {
                return;
            }
            if (qtd > frmActionDetails.getAction().getPlayerQuantity()) {
                JOptionPane.showConfirmDialog(frmActionDetails,
                        "Você não possue essa quantidade desta ação!!\n\n"
                        + "Você posssue:" + frmActionDetails.getAction().getPlayerQuantity());
            }
        } while (qtd > frmActionDetails.getAction().getPlayerQuantity());

        //pegar valor desejado para comprar
        double valor = getDoubleFromJOP(frmActionDetails,
                "Valor desejado:", "Ordem de Venda");
        if (valor < 0) {
            return;
        }

        //pegar turno final
        int turnoFinal = 0;
        do {
            turnoFinal = getIntFromJOP(frmActionDetails,
                    "Turno de vencimento(até " + Config.MAX_TURN + "):",
                    "Ordem de Venda");
            if (turnoFinal < 0) {
                return;
            }
        } while (turnoFinal <= Main.game.getNumTurn());

        SalesOrder salesOrder = new SalesOrder(
                frmActionDetails.getAction(), qtd, valor,
                Main.game.getNumTurn(), turnoFinal, true);

        //Confirmar venda
        switch (JOptionPane.showConfirmDialog(frmActionDetails,
                "Confirma a ordem de Venda?\n"
                + "\nAção:" + salesOrder.getAction().getName()
                + "\nQuantidade" + salesOrder.getQuantity()
                + "\nValor Desejado:" + salesOrder.getValue()
                + "\nTurno de Vencimento:" + salesOrder.getEndTurn(),
                "Odem de Venda",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {

            case JOptionPane.YES_OPTION:
                frmActionDetails.getAction()
                        .getSalesOrderList().add(salesOrder);
                break;
        }
    }

    /**
     * Obter um número inteiro com JOptionPane
     *
     * @param parentComponent
     * @param message
     * @param initialValue
     * @return inteiro ou -1 se cancelar
     */
    private int getIntFromJOP(Component parentComponent, String message, String title) {
        String res = "";
        int n = 0;
        do {
            res = JOptionPane.showInputDialog(parentComponent, message,
                    title, JOptionPane.QUESTION_MESSAGE);
            if (Util.isNullOrEnpty(res)) {
                return -1;
            }
            try {
                n = Integer.parseInt(res);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(parentComponent, "Valor inválido!!");
            }
        } while (n < 1);
        return n;
    }

    /**
     * Obter um número real(double) com JOptionPane
     *
     * @param parentComponent
     * @param message
     * @param title
     * @return double ou -1 se cancelar
     */
    private double getDoubleFromJOP(Component parentComponent, String message, String title) {
        String res = "";
        double n = 0;
        do {
            res = JOptionPane.showInputDialog(parentComponent, message,
                    title, JOptionPane.QUESTION_MESSAGE);
            if (Util.isNullOrEnpty(res)) {
                return -1;
            }
            try {
                n = Double.parseDouble(res);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(parentComponent, "Valor inválido!!");
            }
        } while (n < 1);
        return n;
    }

}
