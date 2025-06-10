
package visao;

import modelo.Produto;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class FrmListaDePreços extends javax.swing.JFrame {

    public FrmListaDePreços() {
        initComponents();
        carregarProdutos();
        setLocationRelativeTo(null); 
    }

    private void carregarProdutos() {        
        Produto produto = new Produto();
        ArrayList<Produto> listaProdutos = produto.getMinhaLista();
        
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setNumRows(0); 
        
        for (Produto p : listaProdutos) {
            modelo.addRow(new Object[]{
                p.getNome(),
                String.format("R$ %.2f", p.getPrecoUnitario()),
                p.getUnidade(),
                p.getCategoriaId() 
            });
        }
        
        
        jTable1.setAutoCreateRowSorter(true);
        jTable1.getRowSorter().toggleSortOrder(0);
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        JBatualizar = new javax.swing.JButton();
        JBfechar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lista de Preços");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "Preço", "Unidade de Medida", "Categoria"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        JBatualizar.setText("Atualizar");
        JBatualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBatualizarActionPerformed(evt);
            }
        });

        JBfechar.setText("Fechar");
        JBfechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBfecharActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setText("Lista de Preços");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(JBatualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JBfechar)
                        .addGap(25, 25, 25))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72))
            .addGroup(layout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBatualizar)
                    .addComponent(JBfechar))
                .addGap(61, 61, 61))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBatualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBatualizarActionPerformed
        carregarProdutos();
    }//GEN-LAST:event_JBatualizarActionPerformed

    private void JBfecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBfecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_JBfecharActionPerformed

  
    
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new FrmListaDePreços().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBatualizar;
    private javax.swing.JButton JBfechar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
