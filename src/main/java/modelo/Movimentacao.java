package modelo;

import dao.MovimentacaoDAO;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Classe que representa uma Movimentação de Produto.
 */
public class Movimentacao {

    private int id;
    private String tipo;
    private LocalDateTime dataMovimentacao;
    private int quantidade;
    private int id_produto;

    private MovimentacaoDAO dao;

    /**
     * Construtor vazio.
     */
    public Movimentacao() {
        this(0, "", LocalDateTime.now(), 0, 0);
    }

    public Movimentacao(int id, String tipo, LocalDateTime dataMovimentacao, int quantidade, int id_produto) {
        this.id = id;
        this.tipo = tipo;
        this.dataMovimentacao = dataMovimentacao;
        this.quantidade = quantidade;
        this.id_produto = id_produto;
        this.dao = new MovimentacaoDAO();
    }

    // Métodos GET e SET

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getDataMovimentacao() {
        return dataMovimentacao;
    }

    public void setDataMovimentacao(LocalDateTime dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    /**
     * Retorna os dados da movimentação em uma string.
     *
     * @return Uma string com os dados da movimentação.
     */
    @Override
    public String toString() {
        return "Movimentacao{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", dataMovimentacao=" + dataMovimentacao +
                ", quantidade=" + quantidade +
                ", id_produto=" + id_produto +
                '}';
    }

    /* Métodos para interação com o DAO */

    /**
     * Retorna a lista de movimentações.
     *
     * @return Um ArrayList com todas as movimentações.
     */
    public ArrayList<Movimentacao> getMinhaLista() {
        return dao.getMinhaLista();
    }

    /**
     * Insere uma nova movimentação no banco de dados.
     *
     * @param tipo Tipo da movimentação.
     * @param dataMovimentacao Data e hora da movimentação.
     * @param quantidade Quantidade movimentada.
     * @param id_produto ID do produto.
     * @return Verdadeiro se inseriu com sucesso.
     */
    public boolean insertMovimentacaoBD(String tipo, LocalDateTime dataMovimentacao, int quantidade, int id_produto) {
        int id = this.maiorID() + 1;
        Movimentacao obj = new Movimentacao(id, tipo, dataMovimentacao, quantidade, id_produto);
        dao.insertMovimentacaoBD(obj);
        return true;
    }

    /**
     * Deleta uma movimentação pelo ID.
     *
     * @param id ID da movimentação.
     * @return Verdadeiro se deletou com sucesso.
     */
    public boolean deleteMovimentacaoBD(int id) {
        return dao.deleteMovimentacaoBD(id);
    }

    /**
     * Atualiza uma movimentação.
     *
     * @param id ID da movimentação.
     * @param tipo Tipo da movimentação.
     * @param dataMovimentacao Data e hora.
     * @param quantidade Quantidade.
     * @param id_produto ID do produto.
     * @return Verdadeiro se atualizou com sucesso.
     */
    public boolean updateMovimentacaoBD(int id, String tipo, LocalDateTime dataMovimentacao, int quantidade, int id_produto) {
        Movimentacao obj = new Movimentacao(id, tipo, dataMovimentacao, quantidade, id_produto);
        dao.updateMovimentacaoBD(obj);
        return true;
    }

    /**
     * Carrega uma movimentação pelo ID.
     *
     * @param id ID da movimentação.
     * @return Objeto Movimentacao preenchido.
     */
    public Movimentacao carregaMovimentacao(int id) {
        return dao.carregaMovimentacao(id);
    }

    /**
     * Retorna o maior ID da tabela.
     *
     * @return Maior valor de ID.
     */
    public int maiorID() {
        return dao.maiorID();
    }
}