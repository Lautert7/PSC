package visao;

import javax.swing.*;
import dao.CategoriaDAO;
import java.util.ArrayList;
import modelo.Categoria;
import modelo.Produto;

public class FrmCadastroProduto extends javax.swing.JFrame {

    private void carregarCategorias() {
        try {
            CategoriaDAO dao = new CategoriaDAO();
            ArrayList<Categoria> lista = dao.getMinhaLista();
            JCBcategoria.removeAllItems(); // Limpa o comboBox
            for (Categoria cat : lista) {
                JCBcategoria.addItem(cat.getNome());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar categorias: " + e.getMessage());
        }
    }
    
    public FrmCadastroProduto() {
        initComponents();
        carregarCategorias();
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
        JTFprecoUnitario.setText("");
        JTFunidade.setText("");
        JTFquantidadeEstoque.setText("");
        JTFquantidadeMinEstoque.setText("");
        JTFquantidadeMaxEstoque.setText("");
        JCBcategoria.setSelectedIndex(0);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        JTFnome = new javax.swing.JTextField();
        JTFprecoUnitario = new javax.swing.JTextField();
        JTFunidade = new javax.swing.JTextField();
        JTFquantidadeEstoque = new javax.swing.JTextField();
        JTFquantidadeMinEstoque = new javax.swing.JTextField();
        JTFquantidadeMaxEstoque = new javax.swing.JTextField();
        JCBcategoria = new javax.swing.JComboBox<>();
        JBvoltar = new javax.swing.JButton();
        JBcadastrar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Produto");
        setSize(new java.awt.Dimension(500, 415));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Informe as características do produto");

        jLabel2.setText("Nome:");

        jLabel3.setText("Preço unitario:");

        jLabel4.setText("Unidade:");

        jLabel5.setText("Quantidade em estoque:");

        jLabel6.setText("Quantidade mínima do estoque:");

        jLabel7.setText("Quantidade máxima do estoque:");

        jLabel8.setText("Categoria:");

        JTFunidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFunidadeActionPerformed(evt);
            }
        });

        JBvoltar.setText("Voltar");
        JBvoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBvoltarActionPerformed(evt);
            }
        });

        JBcadastrar.setText("Cadastrar");
        JBcadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBcadastrarActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel9.setText("Cadastro de Produto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(JBvoltar)
                        .addGap(66, 66, 66)
                        .addComponent(JBcadastrar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JCBcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel7)
                                .addComponent(jLabel6)
                                .addComponent(jLabel5)
                                .addComponent(jLabel4)
                                .addComponent(jLabel2)
                                .addComponent(JTFnome)
                                .addComponent(jLabel3)
                                .addComponent(JTFprecoUnitario)
                                .addComponent(JTFunidade)
                                .addComponent(JTFquantidadeEstoque)
                                .addComponent(JTFquantidadeMinEstoque)
                                .addComponent(JTFquantidadeMaxEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(jLabel9)))
                .addContainerGap(130, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTFnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTFprecoUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTFunidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTFquantidadeEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTFquantidadeMinEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTFquantidadeMaxEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(JCBcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBcadastrar)
                    .addComponent(JBvoltar))
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTFunidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFunidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFunidadeActionPerformed

    private void JBvoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBvoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_JBvoltarActionPerformed

    private void JBcadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBcadastrarActionPerformed
        try {
            String nome = JTFnome.getText().trim();
            double precoUnitario = Double.parseDouble(JTFprecoUnitario.getText());
            String unidade = JTFunidade.getText().trim();
            int quantidadeEstoque = Integer.parseInt(JTFquantidadeEstoque.getText());
            int quantidadeMin = Integer.parseInt(JTFquantidadeMinEstoque.getText());
            int quantidadeMax = Integer.parseInt(JTFquantidadeMaxEstoque.getText());
            String nomeCategoria = (String) JCBcategoria.getSelectedItem();
            int categoriaId = obterIdCategoriaPorNome(nomeCategoria);

            // Validação simples
            if (nome.isEmpty() || unidade.isEmpty() || nomeCategoria == null || categoriaId == -1) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos corretamente.");
                return;
            }

            Produto produto = new Produto();
            boolean sucesso = produto.insertProdutoBD(nome, precoUnitario, unidade,
                    quantidadeEstoque, quantidadeMin, quantidadeMax, categoriaId);

            if (sucesso) {
                JOptionPane.showMessageDialog(this, "Produto cadastrado com sucesso!");
                limparCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar produto.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Valores numéricos inválidos: " + e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_JBcadastrarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmCadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCadastroProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBcadastrar;
    private javax.swing.JButton JBvoltar;
    private javax.swing.JComboBox<String> JCBcategoria;
    private javax.swing.JTextField JTFnome;
    private javax.swing.JTextField JTFprecoUnitario;
    private javax.swing.JTextField JTFquantidadeEstoque;
    private javax.swing.JTextField JTFquantidadeMaxEstoque;
    private javax.swing.JTextField JTFquantidadeMinEstoque;
    private javax.swing.JTextField JTFunidade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}