package visao;

import dao.MovimentacaoDAO;
import dao.ProdutoDAO;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Movimentacao;
import modelo.Produto;

public class FrmEditarMovimentacoes extends javax.swing.JFrame {

    private Map<String, Integer> nomeParaIdProduto = new HashMap<>();
    private boolean atualizando = false;
    
    public FrmEditarMovimentacoes() {
        initComponents();
        carregarProdutos();
        listarMovimentacoes();
        JTFproduto.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) { sincronizarProduto(); }
            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) { sincronizarProduto(); }
            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) { sincronizarProduto(); }

            private void sincronizarProduto() {
                if (atualizando) return;
                atualizando = true;
                String nome = JTFproduto.getText();
                JCBproduto.setSelectedItem(nome);
                atualizando = false;
            }
        });
    }
    
    private void listarMovimentacoes() {
        MovimentacaoDAO movimentacaoDAO = new MovimentacaoDAO();
        ProdutoDAO produtoDAO = new ProdutoDAO();

        DefaultTableModel model = (DefaultTableModel) JTableMovimentacoes.getModel();
        model.setRowCount(0); // Limpa a tabela

        ArrayList<Movimentacao> lista = movimentacaoDAO.getMinhaLista();

        for (Movimentacao mov : lista) {
            Produto produto = produtoDAO.carregaProduto(mov.getProdutoId());
            String nomeProduto = (produto != null) ? produto.getNome() : "Desconhecido";

            model.addRow(new Object[]{
                mov.getId(),
                mov.getTipo(),
                mov.getDataMovimentacao(),
                mov.getQuantidade(),
                nomeProduto
            });
        }
    }
    
    private void carregarProdutos() {
        nomeParaIdProduto.clear();
        JCBproduto.removeAllItems();

        ProdutoDAO dao = new ProdutoDAO();
        for (Produto produto : dao.getMinhaLista()) {
            nomeParaIdProduto.put(produto.getNome(), produto.getId());
            JCBproduto.addItem(produto.getNome());
        }
    }
    
    private void limparCampos() {
        JCBtipo.setSelectedIndex(0);
        JTFdataMov.setText("");
        JTFquantidade.setText("");
        JTFproduto.setText("");
        JCBproduto.setSelectedIndex(0);
        JTableMovimentacoes.clearSelection();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        JTableMovimentacoes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JCBtipo = new javax.swing.JComboBox<>();
        JTFquantidade = new javax.swing.JTextField();
        JTFdataMov = new javax.swing.JTextField();
        JTFproduto = new javax.swing.JTextField();
        JCBproduto = new javax.swing.JComboBox<>();
        JBvoltar = new javax.swing.JButton();
        JBapagar = new javax.swing.JButton();
        JBalterar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Editar Movimentações");

        JTableMovimentacoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Tipo", "Data Mov.", "Quantidade", "Produto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        JTableMovimentacoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableMovimentacoesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTableMovimentacoes);

        jLabel1.setText("Produto:");

        jLabel2.setText("Tipo:");

        jLabel3.setText("Data Mov.:");

        jLabel4.setText("Quantidade:");

        JCBtipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Entrada", "Saída" }));

        JTFquantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFquantidadeActionPerformed(evt);
            }
        });

        JCBproduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBprodutoActionPerformed(evt);
            }
        });

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

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel5.setText("Editar Movimentações");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JCBtipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JBvoltar)
                                    .addComponent(JTFdataMov, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(JBapagar)
                                .addGap(73, 73, 73)
                                .addComponent(JBalterar)
                                .addContainerGap(177, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JTFquantidade))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(JCBproduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(JTFproduto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(115, 115, 115))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(JCBtipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTFquantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(JTFdataMov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(JTFproduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(JCBproduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBvoltar)
                    .addComponent(JBapagar)
                    .addComponent(JBalterar))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTFquantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFquantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFquantidadeActionPerformed

    private void JCBprodutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBprodutoActionPerformed
        if (atualizando) return;
        atualizando = true;
        String nome = (String) JCBproduto.getSelectedItem();
        JTFproduto.setText(nome);
        atualizando = false;
    }//GEN-LAST:event_JCBprodutoActionPerformed

    private void JBapagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBapagarActionPerformed
        int linhaSelecionada = JTableMovimentacoes.getSelectedRow();

        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma movimentação para apagar.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Deseja realmente apagar esta movimentação?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        // Recupera ID da movimentação
        int idMov = (int) JTableMovimentacoes.getValueAt(linhaSelecionada, 0);

        MovimentacaoDAO movDAO = new MovimentacaoDAO();
        Movimentacao movSelecionada = null;

        for (Movimentacao m : movDAO.getMinhaLista()) {
            if (m.getId() == idMov) {
                movSelecionada = m;
                break;
            }
        }

        if (movSelecionada == null) {
            JOptionPane.showMessageDialog(this, "Erro ao localizar movimentação.");
            return;
        }

        try {
            ProdutoDAO produtoDAO = new ProdutoDAO();
            Produto produto = produtoDAO.carregaProduto(movSelecionada.getProdutoId());

            if (produto == null) {
                JOptionPane.showMessageDialog(this, "Produto associado à movimentação não encontrado.");
                return;
            }

            int estoqueAtual = produto.getQuantidadeEstoque();
            int novaQuantidade = estoqueAtual;

            // Ajuste do estoque ao apagar movimentação
            if (movSelecionada.getTipo().equalsIgnoreCase("Entrada")) {
                novaQuantidade -= movSelecionada.getQuantidade();
            } else if (movSelecionada.getTipo().equalsIgnoreCase("Saída")) {
                novaQuantidade += movSelecionada.getQuantidade();
            }

            // Impede estoque negativo
            if (novaQuantidade < 0) {
                JOptionPane.showMessageDialog(this, "Não é possível apagar essa movimentação pois o estoque ficaria negativo.");
                return;
            }

            // Verifica se estoque fica fora dos limites
            if (novaQuantidade < produto.getQuantidadeMin() || novaQuantidade > produto.getQuantidadeMax()) {
                String mensagem = "Após apagar esta movimentação, a quantidade em estoque será: " + novaQuantidade +
                        "\nIsso está fora dos limites definidos (" + produto.getQuantidadeMin() + " - " + produto.getQuantidadeMax() + ").\n" +
                        "Deseja continuar?";

                int resposta = JOptionPane.showConfirmDialog(this, mensagem, "Estoque fora do limite", JOptionPane.YES_NO_OPTION);
                if (resposta != JOptionPane.YES_OPTION) {
                    return;
                }
            }

            // Apaga movimentação do banco
            movDAO.deleteMovimentacaoBD(idMov);

            // Atualiza estoque no banco
            produto.setQuantidadeEstoque(novaQuantidade);
            produtoDAO.updateProdutoBD(produto);

            JOptionPane.showMessageDialog(this, "Movimentação apagada e estoque atualizado com sucesso.");
            listarMovimentacoes(); // Atualiza tabela
            limparCampos();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao apagar movimentação: " + ex.getMessage());
        }
    }//GEN-LAST:event_JBapagarActionPerformed

    private void JBvoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBvoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_JBvoltarActionPerformed

    private void JBalterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBalterarActionPerformed
        int linhaSelecionada = JTableMovimentacoes.getSelectedRow();

        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma movimentação na tabela.");
            return;
        }

        int idMov = (int) JTableMovimentacoes.getValueAt(linhaSelecionada, 0);

        MovimentacaoDAO movDAO = new MovimentacaoDAO();
        Movimentacao movAntigo = null;

        for (Movimentacao m : movDAO.getMinhaLista()) {
            if (m.getId() == idMov) {
                movAntigo = m;
                break;
            }
        }

        if (movAntigo == null) {
            JOptionPane.showMessageDialog(this, "Erro ao localizar movimentação original.");
            return;
        }

        try {
            String tipoNovo = JCBtipo.getSelectedItem().toString();
            String dataMov = JTFdataMov.getText();
            int quantidadeNova = Integer.parseInt(JTFquantidade.getText());

            String nomeProduto = JTFproduto.getText();
            ProdutoDAO produtoDAO = new ProdutoDAO();
            Produto produto = produtoDAO.getProdutoPorNome(nomeProduto);

            if (produto == null) {
                JOptionPane.showMessageDialog(this, "Produto não encontrado.");
                return;
            }

            // Atualizar movimentação
            Movimentacao movNova = new Movimentacao();
            movNova.setId(idMov);
            movNova.setTipo(tipoNovo);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
            LocalDateTime dataMovimentacao = LocalDateTime.parse(dataMov, formatter);
            movNova.setDataMovimentacao(dataMovimentacao);
            movNova.setQuantidade(quantidadeNova);
            movNova.setProdutoId(produto.getId());

            int estoqueAtual = produto.getQuantidadeEstoque();

            // Reverter movimentação antiga
            if (movAntigo.getTipo().equalsIgnoreCase("Entrada")) {
                estoqueAtual -= movAntigo.getQuantidade();
            } else if (movAntigo.getTipo().equalsIgnoreCase("Saída")) {
                estoqueAtual += movAntigo.getQuantidade();
            }

            // Aplicar nova movimentação
            if (tipoNovo.equalsIgnoreCase("Entrada")) {
                estoqueAtual += quantidadeNova;
            } else if (tipoNovo.equalsIgnoreCase("Saída")) {
                estoqueAtual -= quantidadeNova;
            }

            // ⚠️ Verificação de estoque negativo
            if (estoqueAtual < 0) {
                JOptionPane.showMessageDialog(this, "Operação inválida: o estoque não pode ficar negativo.");
                return;
            }

            // ⚠️ Verificação de estoque fora da faixa mínima/máxima
            if (estoqueAtual < produto.getQuantidadeMin() || estoqueAtual > produto.getQuantidadeMax()) {
                String msgAviso = "A nova quantidade em estoque (" + estoqueAtual + 
                    ") está fora dos limites definidos (" + produto.getQuantidadeMin() + " - " + produto.getQuantidadeMax() + ").\n" +
                    "Deseja continuar com a alteração?";
                int resposta = JOptionPane.showConfirmDialog(this, msgAviso, "Aviso de Estoque Fora do Limite", JOptionPane.YES_NO_OPTION);

                if (resposta != JOptionPane.YES_OPTION) {
                    return;
                }
            }

            // Atualiza movimentação no banco
            movDAO.updateMovimentacaoBD(movNova);

            // Atualiza estoque no banco
            produto.setQuantidadeEstoque(estoqueAtual);
            produtoDAO.updateProdutoBD(produto);

            JOptionPane.showMessageDialog(this, "Movimentação e estoque atualizados com sucesso.");
            listarMovimentacoes();
            limparCampos();

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao atualizar: " + ex.getMessage());
        }
    }//GEN-LAST:event_JBalterarActionPerformed

    private void JTableMovimentacoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableMovimentacoesMouseClicked
        int linhaSelecionada = JTableMovimentacoes.getSelectedRow();
        if (linhaSelecionada == -1) return; // Nenhuma linha selecionada

        // Obtem os valores da tabela
        String tipo = JTableMovimentacoes.getValueAt(linhaSelecionada, 1).toString();
        String dataMov = JTableMovimentacoes.getValueAt(linhaSelecionada, 2).toString();
        String quantidade = JTableMovimentacoes.getValueAt(linhaSelecionada, 3).toString();
        String nomeProduto = JTableMovimentacoes.getValueAt(linhaSelecionada, 4).toString();

        // Preenche os campos
        JCBtipo.setSelectedItem(tipo);
        JTFdataMov.setText(dataMov);
        JTFquantidade.setText(quantidade);

        atualizando = true;
        JTFproduto.setText(nomeProduto);
        JCBproduto.setSelectedItem(nomeProduto);
        atualizando = false;
    }//GEN-LAST:event_JTableMovimentacoesMouseClicked

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
            java.util.logging.Logger.getLogger(FrmEditarMovimentacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmEditarMovimentacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmEditarMovimentacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmEditarMovimentacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmEditarMovimentacoes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBalterar;
    private javax.swing.JButton JBapagar;
    private javax.swing.JButton JBvoltar;
    private javax.swing.JComboBox<String> JCBproduto;
    private javax.swing.JComboBox<String> JCBtipo;
    private javax.swing.JTextField JTFdataMov;
    private javax.swing.JTextField JTFproduto;
    private javax.swing.JTextField JTFquantidade;
    private javax.swing.JTable JTableMovimentacoes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}