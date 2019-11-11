/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo.visao;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import jogo.modelo.Acao;

/**
 *
 * @author Lucas
 */
public class AcaoPainel extends javax.swing.JPanel {

    private Acao acao;

    /**
     * Creates new form AcaoPainel
     */
    public AcaoPainel(/*Acao acao*/) {
        initComponents();
        for (Component myComponent : getMyComponents()) {
            if (myComponent instanceof JLabel) {
                ((JLabel) myComponent).setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                ((JLabel) myComponent).setVerticalAlignment(javax.swing.SwingConstants.CENTER);
            }
        }
        //this.setAcao(acao);
        //this.reloadMyComponents();
        this.getJlblInformacao().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, acao);
            }
        });
    }
    
    public void reloadMyComponents(){
        this.jlblNome.setText(acao.getNome());
        this.jlblPreco.setText("R$" + String.valueOf(acao.getValor()));
        this.jlblVariacao.setText(String.valueOf(acao.getVariacao()) + '%');        
    }

    public Component[] getMyComponents() {
        Component[] myComponents = {
            this.getJlblInformacao(),
            this.getJlblNome(),
            this.getJlblPreco(),
            this.getJlblVariacao()
        };
        return myComponents;
    }

    public Acao getAcao() {
        return acao;
    }

    public void setAcao(Acao acao) {
        this.acao = acao;
        this.reloadMyComponents();
    }

    public JButton getJlblInformacao() {
        return jlblInformacao;
    }

    public void setJlblInformacao(JButton jlblInformacao) {
        this.jlblInformacao = jlblInformacao;
    }

    public JLabel getJlblNome() {
        return jlblNome;
    }

    public void setJlblNome(JLabel jlblNome) {
        this.jlblNome = jlblNome;
    }

    public JLabel getJlblPreco() {
        return jlblPreco;
    }

    public void setJlblPreco(JLabel jlblPreco) {
        this.jlblPreco = jlblPreco;
    }

    public JLabel getJlblVariacao() {
        return jlblVariacao;
    }

    public void setJlblVariacao(JLabel jlblVariacao) {
        this.jlblVariacao = jlblVariacao;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpainel = new javax.swing.JPanel();
        jlblNome = new javax.swing.JLabel();
        jlblVariacao = new javax.swing.JLabel();
        jlblPreco = new javax.swing.JLabel();
        jlblInformacao = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setMaximumSize(new java.awt.Dimension(132, 76));

        jpainel.setLayout(new java.awt.GridLayout(2, 2));

        jlblNome.setText("Nome");
        jlblNome.setFocusable(false);
        jlblNome.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jpainel.add(jlblNome);

        jlblVariacao.setText("Variacao %");
        jlblVariacao.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 0, new java.awt.Color(0, 0, 0)));
        jlblVariacao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jpainel.add(jlblVariacao);

        jlblPreco.setText("Preco");
        jlblPreco.setToolTipText("");
        jlblPreco.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jpainel.add(jlblPreco);

        jlblInformacao.setText("Info");
        jpainel.add(jlblInformacao);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jpainel, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpainel, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jlblInformacao;
    private javax.swing.JLabel jlblNome;
    private javax.swing.JLabel jlblPreco;
    private javax.swing.JLabel jlblVariacao;
    private javax.swing.JPanel jpainel;
    // End of variables declaration//GEN-END:variables
}