package jogo.visao;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import jogo.controle.CtrPlayerDetails;
import jogo.modelo.Player;

/**
 * Tela de detalhes do jogador;
 *
 * @see Player
 * @see CtrPlayerDetails
 */
public class FrmPlayerDetails extends javax.swing.JFrame {

    private final CtrPlayerDetails listeners;
    private Player player;

    /**
     * Creates new form FrmPlayerDetails
     */
    public FrmPlayerDetails() {
        initComponents();
        listeners = new CtrPlayerDetails(this);
    }

    public CtrPlayerDetails getListeners() {
        return listeners;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public JButton getBtnAdicionarValorRF() {
        return btnAdicionarValorRF;
    }

    public void setBtnAdicionarValorRF(JButton btnAdicionarValorRF) {
        this.btnAdicionarValorRF = btnAdicionarValorRF;
    }

    public JButton getBtnEmprestimos() {
        return btnEmprestimos;
    }

    public void setBtnEmprestimos(JButton btnEmprestimos) {
        this.btnEmprestimos = btnEmprestimos;
    }

    public JButton getBtnRetirarValorRF() {
        return btnRetirarValorRF;
    }

    public void setBtnRetirarValorRF(JButton btnRetirarValorRF) {
        this.btnRetirarValorRF = btnRetirarValorRF;
    }

    public JLabel getLblGastosValor() {
        return lblGastosValor;
    }

    public void setLblGastosValor(JLabel lblGastosValor) {
        this.lblGastosValor = lblGastosValor;
    }

    public JLabel getLblJurosValor() {
        return lblJurosValor;
    }

    public void setLblJurosValor(JLabel lblJurosValor) {
        this.lblJurosValor = lblJurosValor;
    }

    public JLabel getLblNomeValor() {
        return lblNomeValor;
    }

    public void setLblNomeValor(JLabel lblNomeValor) {
        this.lblNomeValor = lblNomeValor;
    }

    public JLabel getLblRendaFixaValor() {
        return lblRendaFixaValor;
    }

    public void setLblRendaFixaValor(JLabel lblRendaFixaValor) {
        this.lblRendaFixaValor = lblRendaFixaValor;
    }

    public JLabel getLblSaldoValor() {
        return lblSaldoValor;
    }

    public void setLblSaldoValor(JLabel lblSaldoValor) {
        this.lblSaldoValor = lblSaldoValor;
    }

    public JTextField getTxtValorAdicionadoRF() {
        return txtValorAdicionadoRF;
    }

    public void setTxtValorAdicionadoRF(JTextField txtValorAdicionadoRF) {
        this.txtValorAdicionadoRF = txtValorAdicionadoRF;
    }

    public JTextField getTxtValorRemovidoRF() {
        return txtValorRemovidoRF;
    }

    public void setTxtValorRemovidoRF(JTextField txtValorRemovidoRF) {
        this.txtValorRemovidoRF = txtValorRemovidoRF;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnEmprestimos = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblNomeValor = new javax.swing.JLabel();
        lblSaldoValor = new javax.swing.JLabel();
        lblGastosValor = new javax.swing.JLabel();
        lblRendaFixaValor = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtValorAdicionadoRF = new javax.swing.JTextField();
        txtValorRemovidoRF = new javax.swing.JTextField();
        btnRetirarValorRF = new javax.swing.JButton();
        btnAdicionarValorRF = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        lblJurosValor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Nome do Jogador:");

        jLabel2.setText("Saldo em conta:");

        btnEmprestimos.setText("Empréstimos");

        jLabel3.setText("Gastos por Turno:");

        jLabel4.setText("Saldo Renda Fixa:");

        lblNomeValor.setText("nomeValor");

        lblSaldoValor.setText("saldoValor");

        lblGastosValor.setText("gastosValor");

        lblRendaFixaValor.setText("rendaFixaValor");

        btnRetirarValorRF.setText("Retirar da Renda Fixa");

        btnAdicionarValorRF.setText("Adicionar á Renda Fixa");

        jLabel9.setText("Juros Renda Fixa (SELIC):");

        lblJurosValor.setText("jurosValor");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtValorAdicionadoRF)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdicionarValorRF))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtValorRemovidoRF)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRetirarValorRF))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblJurosValor)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblJurosValor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValorRemovidoRF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRetirarValorRF))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValorAdicionadoRF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdicionarValorRF)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNomeValor))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblSaldoValor)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                        .addComponent(btnEmprestimos))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRendaFixaValor))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblGastosValor)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEmprestimos)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lblNomeValor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lblSaldoValor))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblGastosValor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblRendaFixaValor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPlayerDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPlayerDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPlayerDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPlayerDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPlayerDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarValorRF;
    private javax.swing.JButton btnEmprestimos;
    private javax.swing.JButton btnRetirarValorRF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblGastosValor;
    private javax.swing.JLabel lblJurosValor;
    private javax.swing.JLabel lblNomeValor;
    private javax.swing.JLabel lblRendaFixaValor;
    private javax.swing.JLabel lblSaldoValor;
    private javax.swing.JTextField txtValorAdicionadoRF;
    private javax.swing.JTextField txtValorRemovidoRF;
    // End of variables declaration//GEN-END:variables

}
