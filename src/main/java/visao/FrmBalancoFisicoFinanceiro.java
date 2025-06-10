
package visao;

import modelo.Produto;
import java.util.ArrayList;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.Box;
import java.awt.BorderLayout;
import javax.swing.SwingUtilities;

public class FrmBalancoFisicoFinanceiro extends javax.swing.JFrame {

    private NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
    private JLabel lblTotalEstoque;

    public FrmBalancoFisicoFinanceiro() {
        initComponents();
        adicionarComponentesDinamicamente();
        carregarDados();
        this.setLocationRelativeTo(null);
    }

    private void adicionarComponentesDinamicamente() {
        lblTotalEstoque = new JLabel("Total do Estoque: R$ 0,00");
        lblTotalEstoque.setFont(new java.awt.Font("Dialog", 1, 14));
        
        // Adiciona espaço e o label abaixo dos botões
        getContentPane().add(Box.createVerticalStrut(10), BorderLayout.SOUTH);
        getContentPane().add(lblTotalEstoque, BorderLayout.SOUTH);
        
        this.setSize(this.getWidth(), this.getHeight() + 30);
    }


    // Método main para executar a janela
    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> {
            new FrmBalancoFisicoFinanceiro().setVisible(true);
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        JBalterar = new javax.swing.JButton();
        JBfechar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Balanço Físico/Financeiro");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nome", "Valor Unitário", "Valor Total do Estoque"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        JBalterar.setText("Alterar");
        JBalterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBalterarActionPerformed(evt);
            }
        });

        JBfechar.setText("Fechar");
        JBfechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBfecharActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel5.setText("Balanço Físico/Financeiro");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(130, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126))
            .addGroup(layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addComponent(JBalterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JBfechar)
                .addGap(173, 173, 173))
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBalterar)
                    .addComponent(JBfechar))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBfecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBfecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_JBfecharActionPerformed

    private void JBalterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBalterarActionPerformed
        carregarDados();
    }//GEN-LAST:event_JBalterarActionPerformed

    private void carregarDados() {
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0); // Limpa a tabela
    
    Produto produto = new Produto();
    ArrayList<Produto> listaProdutos = produto.getMinhaLista();
    
    // Ordena a lista por nome (ordem alfabética)
    listaProdutos.sort((p1, p2) -> p1.getNome().compareToIgnoreCase(p2.getNome()));
    
    double totalEstoque = 0.0;

    for (Produto p : listaProdutos) {
        double valorTotal = p.getPrecoUnitario() * p.getQuantidadeEstoque();
        totalEstoque += valorTotal;
        
        model.addRow(new Object[]{
            p.getNome(),
            p.getUnidade(),
            p.getQuantidadeEstoque(),
            currencyFormat.format(p.getPrecoUnitario()),
            currencyFormat.format(valorTotal)
        });
    }
    
    
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBalterar;
    private javax.swing.JButton JBfechar;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
