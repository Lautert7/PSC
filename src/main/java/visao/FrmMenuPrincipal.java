package visao;

public class FrmMenuPrincipal extends javax.swing.JFrame {

    public FrmMenuPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenu2 = new javax.swing.JMenu();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuGerenciar = new javax.swing.JMenu();
        jMenuItemCadastrarCategoria = new javax.swing.JMenuItem();
        jMenuItemEditarCategoria = new javax.swing.JMenuItem();
        jMenuItemCadastrarProduto = new javax.swing.JMenuItem();
        jMenuItemEditarProduto = new javax.swing.JMenuItem();
        jMenuItemMovimentacoes = new javax.swing.JMenuItem();
        jMenuItemEditarMovimentacoes = new javax.swing.JMenuItem();
        jMenuItemRelatoriosGerenciais = new javax.swing.JMenuItem();
        jMenuItemSair = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerenciador de Estoque");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(0, 0));
        setPreferredSize(new java.awt.Dimension(500, 415));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setText("Gerenciador de Estoque");

        jMenuGerenciar.setText("Gerenciar");
        jMenuGerenciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuGerenciarActionPerformed(evt);
            }
        });

        jMenuItemCadastrarCategoria.setText("Cadastrar Categoria");
        jMenuItemCadastrarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastrarCategoriaActionPerformed(evt);
            }
        });
        jMenuGerenciar.add(jMenuItemCadastrarCategoria);

        jMenuItemEditarCategoria.setText("Gerenciar Categoria");
        jMenuItemEditarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEditarCategoriaActionPerformed(evt);
            }
        });
        jMenuGerenciar.add(jMenuItemEditarCategoria);

        jMenuItemCadastrarProduto.setText("Cadastrar Produto");
        jMenuItemCadastrarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastrarProdutoActionPerformed(evt);
            }
        });
        jMenuGerenciar.add(jMenuItemCadastrarProduto);

        jMenuItemEditarProduto.setText("Gerenciar Produto");
        jMenuItemEditarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEditarProdutoActionPerformed(evt);
            }
        });
        jMenuGerenciar.add(jMenuItemEditarProduto);

        jMenuItemMovimentacoes.setText("Adicionar Movimentação");
        jMenuItemMovimentacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMovimentacoesActionPerformed(evt);
            }
        });
        jMenuGerenciar.add(jMenuItemMovimentacoes);

        jMenuItemEditarMovimentacoes.setText("Gerenciar Movimentação");
        jMenuItemEditarMovimentacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEditarMovimentacoesActionPerformed(evt);
            }
        });
        jMenuGerenciar.add(jMenuItemEditarMovimentacoes);

        jMenuItemRelatoriosGerenciais.setText("Relatórios Gerenciais");
        jMenuItemRelatoriosGerenciais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRelatoriosGerenciaisActionPerformed(evt);
            }
        });
        jMenuGerenciar.add(jMenuItemRelatoriosGerenciais);

        jMenuItemSair.setText("Sair");
        jMenuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSairActionPerformed(evt);
            }
        });
        jMenuGerenciar.add(jMenuItemSair);

        jMenuBar1.add(jMenuGerenciar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel2)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(jLabel2)
                .addContainerGap(210, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuGerenciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuGerenciarActionPerformed
        
    }//GEN-LAST:event_jMenuGerenciarActionPerformed

    private void jMenuItemCadastrarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastrarCategoriaActionPerformed
        FrmCadastroCategoria objeto = new FrmCadastroCategoria();
        objeto.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadastrarCategoriaActionPerformed

    private void jMenuItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItemSairActionPerformed

    private void jMenuItemCadastrarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastrarProdutoActionPerformed
        FrmCadastroProduto objeto = new FrmCadastroProduto();
        objeto.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadastrarProdutoActionPerformed

    private void jMenuItemMovimentacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMovimentacoesActionPerformed
        FrmMovimentacoes objeto = new FrmMovimentacoes();
        objeto.setVisible(true);
    }//GEN-LAST:event_jMenuItemMovimentacoesActionPerformed

    private void jMenuItemRelatoriosGerenciaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRelatoriosGerenciaisActionPerformed
        FrmRelatoriosGerenciais objeto = new FrmRelatoriosGerenciais();
        objeto.setVisible(true);
    }//GEN-LAST:event_jMenuItemRelatoriosGerenciaisActionPerformed

    private void jMenuItemEditarMovimentacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEditarMovimentacoesActionPerformed
        FrmEditarMovimentacoes objeto = new FrmEditarMovimentacoes();
        objeto.setVisible(true);
    }//GEN-LAST:event_jMenuItemEditarMovimentacoesActionPerformed

    private void jMenuItemEditarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEditarCategoriaActionPerformed
        FrmEditarCategoria objeto = new FrmEditarCategoria();
        objeto.setVisible(true);
    }//GEN-LAST:event_jMenuItemEditarCategoriaActionPerformed

    private void jMenuItemEditarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEditarProdutoActionPerformed
        FrmEditarProduto objeto = new FrmEditarProduto();
        objeto.setVisible(true);
    }//GEN-LAST:event_jMenuItemEditarProdutoActionPerformed

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
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuGerenciar;
    private javax.swing.JMenuItem jMenuItemCadastrarCategoria;
    private javax.swing.JMenuItem jMenuItemCadastrarProduto;
    private javax.swing.JMenuItem jMenuItemEditarCategoria;
    private javax.swing.JMenuItem jMenuItemEditarMovimentacoes;
    private javax.swing.JMenuItem jMenuItemEditarProduto;
    private javax.swing.JMenuItem jMenuItemMovimentacoes;
    private javax.swing.JMenuItem jMenuItemRelatoriosGerenciais;
    private javax.swing.JMenuItem jMenuItemSair;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    // End of variables declaration//GEN-END:variables
}
