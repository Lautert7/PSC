package visao;

import dao.CategoriaDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Categoria;


public class FrmEditarCategoria extends javax.swing.JFrame {

    public FrmEditarCategoria() {
        initComponents();
        listarCategorias();
    }
    
    private void listarCategorias() {
        try {
            DefaultTableModel modelo = (DefaultTableModel) JTableCategorias.getModel();
            modelo.setRowCount(0);

            CategoriaDAO dao = new CategoriaDAO();
            ArrayList<Categoria> lista = dao.getMinhaLista();

            for (Categoria c : lista) {
                modelo.addRow(new Object[]{
                    c.getIdCategoria(),
                    c.getNome(),
                    c.getTamanho(),
                    c.getEmbalagem()
                });
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao listar categorias: " + e.getMessage());
        }
    }
    
    private void limparCampos() {
        JTFnome.setText("");
        JCBtamanho.setSelectedIndex(0);
        JCBembalagem.setSelectedIndex(0);
        JTableCategorias.clearSelection();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        JTableCategorias = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        JTFnome = new javax.swing.JTextField();
        JCBtamanho = new javax.swing.JComboBox<>();
        JCBembalagem = new javax.swing.JComboBox<>();
        JBvoltar = new javax.swing.JButton();
        JBapagar = new javax.swing.JButton();
        JBalterar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JTableCategorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Nome", "Tamanho", "Embalagem"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        JTableCategorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableCategoriasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTableCategorias);

        jLabel1.setText("Nome:");

        jLabel2.setText("Tamanho:");

        jLabel3.setText("Embalagem:");

        JCBtamanho.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pequeno", "Médio", "Grande" }));

        JCBembalagem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lata", "Vidro", "Plástico" }));

        JBvoltar.setText("Voltar");
        JBvoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBvoltarActionPerformed(evt);
            }
        });

        JBapagar.setText("Apagar");
        JBapagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBapagarActionPerformed(evt);
            }
        });

        JBalterar.setText("Alterar");
        JBalterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBalterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JBvoltar)
                                .addGap(82, 82, 82)
                                .addComponent(JBapagar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JBalterar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTFnome))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JCBtamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(99, 99, 99)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JCBembalagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 98, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JTFnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(JCBtamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCBembalagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBvoltar)
                    .addComponent(JBapagar)
                    .addComponent(JBalterar))
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBvoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBvoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_JBvoltarActionPerformed

    private void JBapagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBapagarActionPerformed
        int linhaSelecionada = JTableCategorias.getSelectedRow();

        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma categoria para apagar.");
            return;
        }

        int confirmacao = JOptionPane.showConfirmDialog(this,
                "Tem certeza que deseja apagar essa categoria?\n" +
                "Todos os produtos associados serão movidos para a categoria 'Sem Categoria'.",
                "Confirmar exclusão", JOptionPane.YES_NO_OPTION);

        if (confirmacao == JOptionPane.YES_OPTION) {
            try {
                int idCategoria = Integer.parseInt(JTableCategorias.getValueAt(linhaSelecionada, 0).toString());

                CategoriaDAO categoriaDAO = new CategoriaDAO();

                // 1. Garantir que "Sem Categoria" existe
                int idSemCategoria = categoriaDAO.getOuCriaCategoriaPadrao();

                // 2. Atualizar os produtos para usarem a nova categoria
                categoriaDAO.atualizarProdutosParaNovaCategoria(idCategoria, idSemCategoria);

                // 3. Apagar a categoria
                categoriaDAO.deleteCategoriaBD(idCategoria);

                JOptionPane.showMessageDialog(this, "Categoria removida com sucesso! Produtos foram movidos para 'Sem Categoria'.");

                listarCategorias();
                limparCampos();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro ao apagar categoria: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_JBapagarActionPerformed

    private void JBalterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBalterarActionPerformed
        int linhaSelecionada = JTableCategorias.getSelectedRow();

        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma categoria para alterar.");
            return;
        }

        try {
            int id = Integer.parseInt(JTableCategorias.getValueAt(linhaSelecionada, 0).toString());
            String nome = JTFnome.getText().trim();
            String tamanho = JCBtamanho.getSelectedItem().toString();
            String embalagem = JCBembalagem.getSelectedItem().toString();

            if (nome.isEmpty()) {
                JOptionPane.showMessageDialog(this, "O nome da categoria não pode estar vazio.");
                return;
            }

            // Mensagem de confirmação
            int confirmacao = JOptionPane.showConfirmDialog(
                this,
                "Ao alterar esta categoria, todos os produtos associados a ela também terão suas informações de categoria alteradas.\nDeseja realmente continuar?",
                "Confirmar alteração",
                JOptionPane.YES_NO_OPTION
            );

            if (confirmacao != JOptionPane.YES_OPTION) {
                return; // O usuário cancelou a operação
            }

            Categoria categoria = new Categoria();
            categoria.setIdCategoria(id);
            categoria.setNome(nome);
            categoria.setTamanho(tamanho);
            categoria.setEmbalagem(embalagem);

            CategoriaDAO dao = new CategoriaDAO();
            dao.updateCategoriaBD(categoria);

            JOptionPane.showMessageDialog(this, "Categoria atualizada com sucesso!");

            listarCategorias(); // Atualiza a tabela após a alteração
            limparCampos();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao alterar categoria: " + e.getMessage());
        }
    }//GEN-LAST:event_JBalterarActionPerformed

    private void JTableCategoriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableCategoriasMouseClicked
        int linhaSelecionada = JTableCategorias.getSelectedRow();
        if (linhaSelecionada != -1) {
            // Obtém valores da linha selecionada
            String nome = JTableCategorias.getValueAt(linhaSelecionada, 1).toString();
            String tamanho = JTableCategorias.getValueAt(linhaSelecionada, 2).toString();
            String embalagem = JTableCategorias.getValueAt(linhaSelecionada, 3).toString();

            // Preenche os campos com os valores da tabela
            JTFnome.setText(nome);
            JCBtamanho.setSelectedItem(tamanho);
            JCBembalagem.setSelectedItem(embalagem);
        }
    }//GEN-LAST:event_JTableCategoriasMouseClicked

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
            java.util.logging.Logger.getLogger(FrmEditarCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmEditarCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmEditarCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmEditarCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmEditarCategoria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBalterar;
    private javax.swing.JButton JBapagar;
    private javax.swing.JButton JBvoltar;
    private javax.swing.JComboBox<String> JCBembalagem;
    private javax.swing.JComboBox<String> JCBtamanho;
    private javax.swing.JTextField JTFnome;
    private javax.swing.JTable JTableCategorias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}