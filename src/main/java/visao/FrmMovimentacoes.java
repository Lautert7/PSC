package visao;

import modelo.Movimentacao;
import dao.MovimentacaoDAO;
import modelo.Produto;
import dao.ProdutoDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FrmMovimentacoes extends javax.swing.JFrame {
    
    private ArrayList<Produto> listaProdutos;

    public FrmMovimentacoes() {
        initComponents();
        carregarProdutos();
        
        JCBproduto.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String nomeSelecionado = (String) JCBproduto.getSelectedItem();
                if (nomeSelecionado != null) {
                    JTFproduto.setText(nomeSelecionado);
                }
            }
        });

        // Sincroniza JCBproduto quando JTFproduto perde o foco
        JTFproduto.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                atualizarComboBoxPorTexto();
            }
        });
    }
    
    private void carregarProdutos() {
        ProdutoDAO dao = new ProdutoDAO();
        listaProdutos = dao.getMinhaLista();  // Armazena a lista para uso posterior
        JCBproduto.removeAllItems();
        for (Produto p : listaProdutos) {
            JCBproduto.addItem(p.getNome());
        }
    }
    
    private void atualizarComboBoxPorTexto() {
        String nomeDigitado = JTFproduto.getText().trim();
        for (int i = 0; i < JCBproduto.getItemCount(); i++) {
            if (JCBproduto.getItemAt(i).equalsIgnoreCase(nomeDigitado)) {
                JCBproduto.setSelectedIndex(i);
                return;
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JCBtipo = new javax.swing.JComboBox<>();
        JTFquantidade = new javax.swing.JTextField();
        JTFproduto = new javax.swing.JTextField();
        JBvoltar = new javax.swing.JButton();
        JBmovimentar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        JCBproduto = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Movimentações");

        jLabel2.setText("Tipo:");

        jLabel4.setText("Quantidade:");

        jLabel5.setText("Produto:");

        JCBtipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Entrada", "Saída" }));

        JTFquantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFquantidadeActionPerformed(evt);
            }
        });

        JBvoltar.setText("Voltar");
        JBvoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBvoltarActionPerformed(evt);
            }
        });

        JBmovimentar.setText("Movimentar");
        JBmovimentar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBmovimentarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Informe as características da movimentação");

        JCBproduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBprodutoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel7.setText("Apenas este campo será");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel8.setText("validado como produto*");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel3.setText("Movimentações");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JCBtipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(JTFproduto, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(JCBproduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(JBvoltar)
                                        .addComponent(jLabel8)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(JBmovimentar)
                                .addGap(153, 159, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTFquantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(112, 112, 112))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(224, 224, 224)
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(JCBtipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(JTFquantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(JTFproduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JCBproduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JBmovimentar)
                            .addComponent(JBvoltar))))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTFquantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFquantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFquantidadeActionPerformed

    private void JBvoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBvoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_JBvoltarActionPerformed

    private void JBmovimentarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBmovimentarActionPerformed
        try {
            String tipo = JCBtipo.getSelectedItem().toString();
            int quantidade = Integer.parseInt(JTFquantidade.getText());
            String nomeProduto = JTFproduto.getText().trim();

            // Encontra o produto na lista pelo nome
            Produto produtoSelecionado = null;
            for (Produto p : listaProdutos) {
                if (p.getNome().equalsIgnoreCase(nomeProduto)) {
                    produtoSelecionado = p;
                    break;
                }
            }

            if (produtoSelecionado == null) {
                JOptionPane.showMessageDialog(null, "Produto não encontrado.");
                return;
            }

            int produtoId = produtoSelecionado.getId();

            // Carrega dados atualizados do produto do banco
            ProdutoDAO produtoDAO = new ProdutoDAO();
            Produto produtoAtual = produtoDAO.carregaProduto(produtoId);

            int estoqueAtual = produtoAtual.getQuantidadeEstoque();
            int novoEstoque;

            if (tipo.equalsIgnoreCase("Entrada")) {
                novoEstoque = estoqueAtual + quantidade;
            } else if (tipo.equalsIgnoreCase("Saída")) {
                if (quantidade > estoqueAtual) {
                    JOptionPane.showMessageDialog(null, "Erro: Estoque insuficiente para saída.");
                    return;
                }
                novoEstoque = estoqueAtual - quantidade;
            } else {
                JOptionPane.showMessageDialog(null, "Tipo de movimentação inválido.");
                return;
            }

            // Verificação de limites mínimo e máximo
            int min = produtoAtual.getQuantidadeMin();
            int max = produtoAtual.getQuantidadeMax();

            if (novoEstoque < min || novoEstoque > max) {
                String aviso = "A movimentação resultará em um estoque de " + novoEstoque + 
                               ", que está fora dos limites definidos (" + min + " - " + max + ").\n" +
                               "Deseja continuar mesmo assim?";
                int resposta = JOptionPane.showConfirmDialog(null, aviso, "Estoque fora do limite", JOptionPane.YES_NO_OPTION);
                if (resposta != JOptionPane.YES_OPTION) {
                    return;
                }
            }

            // Registra a movimentação
            Movimentacao mov = new Movimentacao();
            mov.setTipo(tipo);
            mov.setQuantidade(quantidade);
            mov.setProdutoId(produtoId);

            MovimentacaoDAO dao = new MovimentacaoDAO();
            dao.insertMovimentacaoBD(mov);

            // Atualiza o estoque no banco
            produtoAtual.setQuantidadeEstoque(novoEstoque);
            produtoDAO.updateProdutoBD(produtoAtual);

            JOptionPane.showMessageDialog(null, "Movimentação registrada e estoque atualizado com sucesso!");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Erro: Quantidade deve ser um número válido.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar movimentação: " + e.getMessage());
        }
    }//GEN-LAST:event_JBmovimentarActionPerformed

    private void JCBprodutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBprodutoActionPerformed
        String nomeSelecionado = (String) JCBproduto.getSelectedItem();
        if (nomeSelecionado != null) {
            JTFproduto.setText(nomeSelecionado);
        }
    }//GEN-LAST:event_JCBprodutoActionPerformed

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
            java.util.logging.Logger.getLogger(FrmMovimentacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMovimentacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMovimentacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMovimentacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMovimentacoes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBmovimentar;
    private javax.swing.JButton JBvoltar;
    private javax.swing.JComboBox<String> JCBproduto;
    private javax.swing.JComboBox<String> JCBtipo;
    private javax.swing.JTextField JTFproduto;
    private javax.swing.JTextField JTFquantidade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}