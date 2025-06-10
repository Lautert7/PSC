package visao;

import dao.CategoriaDAO;
import dao.MovimentacaoDAO;
import dao.ProdutoDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Categoria;
import modelo.Produto;

public class FrmEditarProduto extends javax.swing.JFrame {

    public FrmEditarProduto() {
        initComponents();
        carregarTabelaProdutos();
        carregarCategorias();
        JTableProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableProdutosMouseClicked(evt);
            }
        });
    }
    
    private void carregarTabelaProdutos() {
        DefaultTableModel modelo = (DefaultTableModel) JTableProdutos.getModel();
        modelo.setRowCount(0); // limpa a tabela

        ProdutoDAO dao = new ProdutoDAO();
        CategoriaDAO categoriaDAO = new CategoriaDAO();

        for (Produto p : dao.getMinhaLista()) {
            String nomeCategoria = "Desconhecida";
            try {
                Categoria c = categoriaDAO.carregaCategoria(p.getCategoriaId());
                if (c != null) {
                    nomeCategoria = c.getNome();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            modelo.addRow(new Object[]{
                p.getId(),
                p.getNome(),
                p.getPrecoUnitario(),
                p.getUnidade(),
                p.getQuantidadeEstoque(),
                p.getQuantidadeMin(),
                p.getQuantidadeMax(),
                nomeCategoria
            });
        }
    }
    
    private void carregarCategorias() {
        JCBcategoria.removeAllItems(); // Limpa itens antigos
        CategoriaDAO dao = new CategoriaDAO();
        ArrayList<Categoria> lista = dao.getMinhaLista();

        for (Categoria cat : lista) {
            JCBcategoria.addItem(cat.getNome()); // Adiciona o nome à ComboBox
        }
    }
    
    private int obterIdCategoriaPorNome(String nomeCategoria) {
        CategoriaDAO dao = new CategoriaDAO();
        ArrayList<Categoria> lista = dao.getMinhaLista();
        for (Categoria cat : lista) {
            if (cat.getNome().equals(nomeCategoria)) {
                return cat.getIdCategoria();
            }
        }
        return -1; // Não encontrado
    }
    
    private void limparCampos() {
        JTFnome.setText("");
        JTFpreco.setText("");
        JTFunidade.setText("");
        JTFqntEstoque.setText("");
        JTFqntMinEstoque.setText("");
        JTFqntMaxEstoque.setText("");
        JCBcategoria.setSelectedIndex(-1); // Limpa seleção da combo box
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        JTableProdutos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        JTFnome = new javax.swing.JTextField();
        JTFpreco = new javax.swing.JTextField();
        JTFunidade = new javax.swing.JTextField();
        JTFqntEstoque = new javax.swing.JTextField();
        JTFqntMinEstoque = new javax.swing.JTextField();
        JTFqntMaxEstoque = new javax.swing.JTextField();
        JCBcategoria = new javax.swing.JComboBox<>();
        JBvoltar = new javax.swing.JButton();
        JBapagar = new javax.swing.JButton();
        JBalterar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Editar Produto");

        JTableProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Nome", "Preço", "Unidade", "Qnt. Estoque", "Qnt. Min. Estoque", "Qnt. Max. Estoque", "Categoria"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        JTableProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableProdutosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTableProdutos);

        jLabel1.setText("Nome:");

        jLabel2.setText("Preço:");

        jLabel3.setText("Unidade:");

        jLabel4.setText("Qnt. Estoque:");

        jLabel5.setText("Qnt. Min. Estoque:");

        jLabel6.setText("Qnt. Max. Estoque:");

        jLabel7.setText("Categoria:");

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

        jLabel8.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel8.setText("Editar Produto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTFpreco))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTFunidade))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTFnome, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(105, 232, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JCBcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(13, 13, 13)))
                        .addGap(131, 131, 131))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTFqntMaxEstoque))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(JTFqntMinEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(JTFqntEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(JBvoltar)
                        .addGap(100, 100, 100)
                        .addComponent(JBapagar)
                        .addGap(94, 94, 94)
                        .addComponent(JBalterar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(328, 328, 328)
                .addComponent(jLabel8)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel8)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(JTFnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTFqntEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(JTFpreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTFqntMinEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JCBcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(JTFunidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(JTFqntMaxEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBvoltar)
                    .addComponent(JBapagar)
                    .addComponent(JBalterar))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBapagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBapagarActionPerformed
        int selectedRow = JTableProdutos.getSelectedRow();
        if (selectedRow != -1) {
            int idProduto = Integer.parseInt(JTableProdutos.getValueAt(selectedRow, 0).toString());

            MovimentacaoDAO movDao = new MovimentacaoDAO();
            boolean possuiMov = movDao.possuiMovimentacoes(idProduto);

            int confirm;

            if (possuiMov) {
                confirm = JOptionPane.showConfirmDialog(this,
                    "Este produto está associado a movimentações.\nDeseja apagar o produto e todas as movimentações relacionadas?",
                    "Confirmar exclusão em cascata",
                    JOptionPane.YES_NO_OPTION);
            } else {
                confirm = JOptionPane.showConfirmDialog(this,
                    "Tem certeza que deseja apagar este produto?",
                    "Confirmar exclusão",
                    JOptionPane.YES_NO_OPTION);
            }

            if (confirm == JOptionPane.YES_OPTION) {
                if (possuiMov) {
                    movDao.deleteMovimentacoesProdutoBD(idProduto);
                }

                ProdutoDAO dao = new ProdutoDAO();
                boolean sucesso = dao.deleteProdutoBD(idProduto);

                if (sucesso) {
                    JOptionPane.showMessageDialog(this, "Produto apagado com sucesso" +
                        (possuiMov ? " (e movimentações relacionadas)." : "."));
                    carregarTabelaProdutos();
                    limparCampos();
                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao apagar o produto.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um produto para apagar.");
        }
    }//GEN-LAST:event_JBapagarActionPerformed

    private void JBvoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBvoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_JBvoltarActionPerformed

    private void JBalterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBalterarActionPerformed
        int linha = JTableProdutos.getSelectedRow();
        if (linha != -1) {
            // Mensagem de confirmação
            int resposta = JOptionPane.showConfirmDialog(
                this,
                "Ao alterar este produto, todas as movimentações ligadas a ele podem mudar.\nDeseja continuar?",
                "Confirmar Alteração",
                JOptionPane.YES_NO_OPTION
            );

            if (resposta == JOptionPane.YES_OPTION) {
                try {
                    int idProduto = Integer.parseInt(JTableProdutos.getValueAt(linha, 0).toString());

                    String nome = JTFnome.getText();
                    double preco = Double.parseDouble(JTFpreco.getText());
                    String unidade = JTFunidade.getText();
                    int qntEstoque = Integer.parseInt(JTFqntEstoque.getText());
                    int qntMin = Integer.parseInt(JTFqntMinEstoque.getText());
                    int qntMax = Integer.parseInt(JTFqntMaxEstoque.getText());

                    String nomeCategoria = (String) JCBcategoria.getSelectedItem();
                    int categoriaId = obterIdCategoriaPorNome(nomeCategoria); // método local

                    Produto produto = new Produto(idProduto, nome, preco, unidade, qntEstoque, qntMin, qntMax, categoriaId);

                    ProdutoDAO produtoDAO = new ProdutoDAO();
                    boolean sucesso = produtoDAO.updateProdutoBD(produto);

                    if (sucesso) {
                        JOptionPane.showMessageDialog(this, "Produto alterado com sucesso!");
                        carregarTabelaProdutos();
                        limparCampos();
                    } else {
                        JOptionPane.showMessageDialog(this, "Erro ao alterar produto.");
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Erro ao alterar: " + e.getMessage());
                }
            } else {
                // Usuário cancelou
                JOptionPane.showMessageDialog(this, "Alteração cancelada pelo usuário.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um produto na tabela.");
        }
    }//GEN-LAST:event_JBalterarActionPerformed

    private void JTableProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableProdutosMouseClicked
        int linhaSelecionada = JTableProdutos.getSelectedRow();
        if (linhaSelecionada != -1) {
            // Pega valores da linha selecionada
            int id = (int) JTableProdutos.getValueAt(linhaSelecionada, 0);
            String nome = (String) JTableProdutos.getValueAt(linhaSelecionada, 1);
            double preco = (double) JTableProdutos.getValueAt(linhaSelecionada, 2);
            String unidade = (String) JTableProdutos.getValueAt(linhaSelecionada, 3);
            int qntEstoque = (int) JTableProdutos.getValueAt(linhaSelecionada, 4);
            int qntMin = (int) JTableProdutos.getValueAt(linhaSelecionada, 5);
            int qntMax = (int) JTableProdutos.getValueAt(linhaSelecionada, 6);
            String categoriaNome = (String) JTableProdutos.getValueAt(linhaSelecionada, 7);

            // Preenche os campos
            JTFnome.setText(nome);
            JTFpreco.setText(String.valueOf(preco));
            JTFunidade.setText(unidade);
            JTFqntEstoque.setText(String.valueOf(qntEstoque));
            JTFqntMinEstoque.setText(String.valueOf(qntMin));
            JTFqntMaxEstoque.setText(String.valueOf(qntMax));

            // Seleciona a categoria correspondente na ComboBox
            for (int i = 0; i < JCBcategoria.getItemCount(); i++) {
                if (JCBcategoria.getItemAt(i).toString().equals(categoriaNome)) {
                    JCBcategoria.setSelectedIndex(i);
                    break;
                }
            }
        }
    }//GEN-LAST:event_JTableProdutosMouseClicked

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
            java.util.logging.Logger.getLogger(FrmEditarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmEditarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmEditarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmEditarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmEditarProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBalterar;
    private javax.swing.JButton JBapagar;
    private javax.swing.JButton JBvoltar;
    private javax.swing.JComboBox<String> JCBcategoria;
    private javax.swing.JTextField JTFnome;
    private javax.swing.JTextField JTFpreco;
    private javax.swing.JTextField JTFqntEstoque;
    private javax.swing.JTextField JTFqntMaxEstoque;
    private javax.swing.JTextField JTFqntMinEstoque;
    private javax.swing.JTextField JTFunidade;
    private javax.swing.JTable JTableProdutos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
