
package visao;

import javax.swing.JOptionPane;
import modelo.Categoria;
import dao.CategoriaDAO;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class FrmCategoria extends javax.swing.JFrame {

private Categoria objetoCategoria;

    public FrmCategoria() {
        initComponents();
        this.objetoCategoria = new Categoria();
        this.carregaTabela();
    }
public void carregaTabela() {
        DefaultTableModel modelo = (DefaultTableModel) this.JTableCategoria.getModel();
        modelo.setNumRows(0);

        ArrayList<Categoria> minhaLista = objetoCategoria.getMinhaLista();
        for (Categoria a : minhaLista) {
            modelo.addRow(new Object[]{
                a.getIdCategoria(),
                a.getNome(),          
                a.getTamanho(),
                a.getEmbalagem(),
            });
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        JTableCategoria = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        JTFid = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        JTFnome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        JTFembalagem = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        JTFtamanho = new javax.swing.JTextField();
        JBCancelar = new javax.swing.JButton();
        JBApagar = new javax.swing.JButton();
        JBCadastrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Categoria");

        JTableCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Produto", "Embalagem", "Tamanho"
            }
        ));
        jScrollPane1.setViewportView(JTableCategoria);

        jLabel1.setText("ID:");

        jLabel2.setText("Nome do Produto:");

        jLabel3.setText("Embalagem(papelao, metal..):");

        JTFembalagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFembalagemActionPerformed(evt);
            }
        });

        jLabel4.setText("Tamanho(grande, medio, pequeno):");

        JBCancelar.setText("Cancelar");
        JBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCancelarActionPerformed(evt);
            }
        });

        JBApagar.setText("Apagar");
        JBApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBApagarActionPerformed(evt);
            }
        });

        JBCadastrar.setText("Cadastrar");
        JBCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCadastrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(44, 44, 44)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTFnome, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                                .addComponent(JTFid)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                                .addComponent(JTFtamanho)
                                .addComponent(JTFembalagem))
                            .addGap(45, 45, 45)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(JBCancelar)
                        .addGap(67, 67, 67)
                        .addComponent(JBCadastrar)
                        .addGap(78, 78, 78)
                        .addComponent(JBApagar)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTFid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTFembalagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTFnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTFtamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBCancelar)
                    .addComponent(JBApagar)
                    .addComponent(JBCadastrar))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_JBCancelarActionPerformed

    private void JTFembalagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFembalagemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFembalagemActionPerformed

    private void JBApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBApagarActionPerformed
        try {
// validando dados da interface gráfica.
            int id = 0;
            if (this.JTableCategoria.getSelectedRow() == -1) {
                throw new Mensagem(
                        "Primeiro Selecione uma Categoria para APAGAR");
            } else {
                id = Integer.parseInt(this.JTableCategoria.
                        getValueAt(this.JTableCategoria.getSelectedRow(), 0).
                        toString());
            }
// retorna 0 -> primeiro botão | 1 -> segundo botão | 2 -> terceiro botão
            int respostaUsuario = JOptionPane.
                    showConfirmDialog(null,
                            "Tem certeza que deseja apagar esssa Categoria?");
            if (respostaUsuario == 0) {// clicou em SIM
// envia os dados para o Aluno processar
                if (this.objetoCategoria.deleteCategoriaBD(id)) {
// limpa os campos
                    this.JTFid.setText("");
                    this.JTFnome.setText("");
                    this.JTFembalagem.setText("");
                    this.JTFtamanho.setText("");
                    JOptionPane.showMessageDialog(rootPane, "Produto Apagado com Sucesso!");
                }
            }
// atualiza a tabela.
            System.out.println(this.objetoCategoria.getMinhaLista().toString());
        } catch (Mensagem erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } finally {
// atualiza a tabela.
            carregaTabela();
        }
    }//GEN-LAST:event_JBApagarActionPerformed

    private void JBCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCadastrarActionPerformed
        try {

            // recebendo e validando dados da interface gráfica.
            String nome= "";
            String embalagem = "";
            String tamanho = "";
            
            
            if (this.JTFnome.getText().length() < 2) {
                throw new Mensagem("Nome do produto deve conter ao menos 2 caracteres.");
            } else {
                nome = this.JTFnome.getText();
            }
            if (this.JTFembalagem.getText().length() < 2) {
                throw new Mensagem("Nome do produto deve conter ao menos 2 caracteres.");
            } else {
                embalagem = this.JTFembalagem.getText();
            }
            if (this.JTFtamanho.getText().length() < 2) {
                throw new Mensagem("Nome do produto deve conter ao menos 2 caracteres.");
            } else {
                tamanho = this.JTFtamanho.getText();
            }
            // envia os dados para o Controlador cadastrar
            if (this.objetoCategoria.insertCategoriaBD(nome, tamanho, embalagem)) {
                JOptionPane.showMessageDialog(null, "Produto Cadastrado com Sucesso!");
                // limpa campos da interface
                this.JTFnome.setText("");
                this.JTFid.setText("");
                this.JTFembalagem.setText("");
                this.JTFtamanho.setText("");

            }
            //Exibie no console o produto cadastrado
            System.out.println(this.objetoCategoria.getMinhaLista().toString());

        } catch (Mensagem erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } catch (NumberFormatException erro2) {
            JOptionPane.showMessageDialog(null, "Informe um número válido.");
        }
    }//GEN-LAST:event_JBCadastrarActionPerformed


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCategoria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBApagar;
    private javax.swing.JButton JBCadastrar;
    private javax.swing.JButton JBCancelar;
    private javax.swing.JTextField JTFembalagem;
    private javax.swing.JTextField JTFid;
    private javax.swing.JTextField JTFnome;
    private javax.swing.JTextField JTFtamanho;
    private javax.swing.JTable JTableCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
