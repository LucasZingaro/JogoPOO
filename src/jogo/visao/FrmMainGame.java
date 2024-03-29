package jogo.visao;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import jogo.controle.CtrMainGame;
import jogo.modelo.Game;

/**
 * Tela principal da Partida
 *
 * @see Game
 * @see CtrMainGame
 */
public class FrmMainGame extends javax.swing.JFrame {

    private final CtrMainGame listeners;
    private Game game;

    /**
     * Creates new form FrmTelaPrincipal
     */
    public FrmMainGame() {
        initComponents();
        listeners = new CtrMainGame(this);
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/jogo/img/WinIcon.png")).getImage());
    }

    public CtrMainGame getListeners() {
        return listeners;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
        this.listeners.reloadTableAcoes();
    }

    public JButton getBtnPassarTurno() {
        return btnPassarTurno;
    }

    public void setBtnPassarTurno(JButton btnPassarTurno) {
        this.btnPassarTurno = btnPassarTurno;
    }

    public JButton getBtnPatrimonio() {
        return btnPatrimonio;
    }

    public void setBtnPatrimonio(JButton btnPatrimonio) {
        this.btnPatrimonio = btnPatrimonio;
    }

    public JButton getBtnVisaoGeral() {
        return btnVisaoGeral;
    }

    public void setBtnVisaoGeral(JButton btnVisaoGeral) {
        this.btnVisaoGeral = btnVisaoGeral;
    }

    public JMenuBar getFrmMenuBar() {
        return frmMenuBar;
    }

    public void setFrmMenuBar(JMenuBar frmMenuBar) {
        this.frmMenuBar = frmMenuBar;
    }

    public JLabel getLblNomeValor() {
        return lblNomeValor;
    }

    public void setLblNomeValor(JLabel lblNomeValor) {
        this.lblNomeValor = lblNomeValor;
    }

    public JLabel getLblSaldoValor() {
        return lblSaldoValor;
    }

    public void setLblSaldoValor(JLabel lblSaldoValor) {
        this.lblSaldoValor = lblSaldoValor;
    }

    public JLabel getLblTurnoValor() {
        return lblTurnoValor;
    }

    public void setLblTurnoValor(JLabel lblTurnoValor) {
        this.lblTurnoValor = lblTurnoValor;
    }

    public JMenu getMenuAjuda() {
        return menuAjuda;
    }

    public void setMenuAjuda(JMenu menuAjuda) {
        this.menuAjuda = menuAjuda;
    }

    public JMenu getMenuJogo() {
        return menuJogo;
    }

    public void setMenuJogo(JMenu menuJogo) {
        this.menuJogo = menuJogo;
    }

    public JMenuItem getMiMenu() {
        return miMenu;
    }

    public void setMiMenu(JMenuItem miMenu) {
        this.miMenu = miMenu;
    }

    public JMenuItem getMiSair() {
        return miSair;
    }

    public void setMiSair(JMenuItem miSair) {
        this.miSair = miSair;
    }

    public JMenuItem getMiSalvar() {
        return miSalvar;
    }

    public void setMiSalvar(JMenuItem miSalvar) {
        this.miSalvar = miSalvar;
    }

    public JTable getTabelaAcoes() {
        return tabelaAcoes;
    }

    public void setTabelaAcoes(JTable tabelaAcoes) {
        this.tabelaAcoes = tabelaAcoes;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTelaPrincipal = new javax.swing.JPanel();
        panelDados = new javax.swing.JPanel();
        btnPassarTurno = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblSaldoValor = new javax.swing.JLabel();
        btnVisaoGeral = new javax.swing.JButton();
        btnPatrimonio = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblNomeValor = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblTurnoValor = new javax.swing.JLabel();
        scrollPaneTabelaAcoes = new javax.swing.JScrollPane();
        tabelaAcoes = new javax.swing.JTable();
        frmMenuBar = new javax.swing.JMenuBar();
        menuJogo = new javax.swing.JMenu();
        miSalvar = new javax.swing.JMenuItem();
        miMenu = new javax.swing.JMenuItem();
        miSair = new javax.swing.JMenuItem();
        menuAjuda = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Game");

        panelTelaPrincipal.setBackground(new java.awt.Color(153, 153, 153));

        panelDados.setBackground(new java.awt.Color(153, 153, 153));

        btnPassarTurno.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnPassarTurno.setText("Terminar Turno");
        btnPassarTurno.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnPassarTurno.setOpaque(false);

        jLabel1.setText("Saldo:");

        lblSaldoValor.setText("saldoValor");

        btnVisaoGeral.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnVisaoGeral.setText("Visão Geral do Mercado");
        btnVisaoGeral.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnVisaoGeral.setOpaque(false);

        btnPatrimonio.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnPatrimonio.setText("Meu Patrimônio");
        btnPatrimonio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnPatrimonio.setOpaque(false);

        jLabel2.setText("Nome:");

        lblNomeValor.setText("nomeValor");

        jLabel3.setText("Turno:");

        lblTurnoValor.setText("turnoValor");

        javax.swing.GroupLayout panelDadosLayout = new javax.swing.GroupLayout(panelDados);
        panelDados.setLayout(panelDadosLayout);
        panelDadosLayout.setHorizontalGroup(
            panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDadosLayout.createSequentialGroup()
                        .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDadosLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTurnoValor))
                            .addGroup(panelDadosLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNomeValor)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPassarTurno))
                    .addGroup(panelDadosLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSaldoValor)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelDadosLayout.createSequentialGroup()
                        .addComponent(btnVisaoGeral)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPatrimonio)))
                .addContainerGap())
        );
        panelDadosLayout.setVerticalGroup(
            panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPassarTurno)
                    .addGroup(panelDadosLayout.createSequentialGroup()
                        .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lblTurnoValor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lblNomeValor))))
                .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDadosLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lblSaldoValor))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDadosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPatrimonio)
                            .addComponent(btnVisaoGeral))
                        .addContainerGap())))
        );

        scrollPaneTabelaAcoes.setForeground(new java.awt.Color(102, 102, 102));

        tabelaAcoes.setBackground(new java.awt.Color(102, 102, 102));
        tabelaAcoes.setForeground(new java.awt.Color(102, 102, 102));
        tabelaAcoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ações", "Ações", "Ações", "Ações"
            }
        ));
        tabelaAcoes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        scrollPaneTabelaAcoes.setViewportView(tabelaAcoes);
        if (tabelaAcoes.getColumnModel().getColumnCount() > 0) {
            tabelaAcoes.getColumnModel().getColumn(0).setMinWidth(150);
            tabelaAcoes.getColumnModel().getColumn(1).setMinWidth(150);
            tabelaAcoes.getColumnModel().getColumn(2).setMinWidth(150);
            tabelaAcoes.getColumnModel().getColumn(3).setMinWidth(150);
        }

        javax.swing.GroupLayout panelTelaPrincipalLayout = new javax.swing.GroupLayout(panelTelaPrincipal);
        panelTelaPrincipal.setLayout(panelTelaPrincipalLayout);
        panelTelaPrincipalLayout.setHorizontalGroup(
            panelTelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTelaPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPaneTabelaAcoes, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelTelaPrincipalLayout.setVerticalGroup(
            panelTelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTelaPrincipalLayout.createSequentialGroup()
                .addComponent(panelDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPaneTabelaAcoes, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                .addContainerGap())
        );

        frmMenuBar.setBackground(new java.awt.Color(153, 153, 153));

        menuJogo.setText("Jogo");
        menuJogo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        miSalvar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        miSalvar.setText("Salvar");
        menuJogo.add(miSalvar);

        miMenu.setText("Menu");
        menuJogo.add(miMenu);

        miSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        miSair.setText("Sair");
        menuJogo.add(miSair);

        frmMenuBar.add(menuJogo);

        menuAjuda.setText("Ajuda");
        menuAjuda.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        frmMenuBar.add(menuAjuda);

        setJMenuBar(frmMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTelaPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTelaPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMainGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMainGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMainGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMainGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMainGame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPassarTurno;
    private javax.swing.JButton btnPatrimonio;
    private javax.swing.JButton btnVisaoGeral;
    private javax.swing.JMenuBar frmMenuBar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblNomeValor;
    private javax.swing.JLabel lblSaldoValor;
    private javax.swing.JLabel lblTurnoValor;
    private javax.swing.JMenu menuAjuda;
    private javax.swing.JMenu menuJogo;
    private javax.swing.JMenuItem miMenu;
    private javax.swing.JMenuItem miSair;
    private javax.swing.JMenuItem miSalvar;
    private javax.swing.JPanel panelDados;
    private javax.swing.JPanel panelTelaPrincipal;
    private javax.swing.JScrollPane scrollPaneTabelaAcoes;
    private javax.swing.JTable tabelaAcoes;
    // End of variables declaration//GEN-END:variables
}
