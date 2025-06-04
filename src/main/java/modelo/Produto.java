package modelo;

import dao.ProdutoDAO;
import java.util.ArrayList;

/**
 * Classe que representa um Produto.
 */
public class Produto {

    private int idProduto;
    private String nome;
    private double preco;
    private String unidade;
    private int quantidadeEstoque;
    private int quantidadeMin;
    private int quantidadeMax;
    private int categoriaId;

    private ProdutoDAO dao;

    /**
     * Construtor vazio.
     */
    public Produto() {
        this(0, "", 0.0, "", 0, 0, 0, 0);
    }

    public Produto(int idProduto, String nome, double preco, String unidade,
                   int quantidadeEstoque, int quantidadeMin, int quantidadeMax, int categoriaId) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.preco = preco;
        this.unidade = unidade;
        this.quantidadeEstoque = quantidadeEstoque;
        this.quantidadeMin = quantidadeMin;
        this.quantidadeMax = quantidadeMax;
        this.categoriaId = categoriaId;
        this.dao = new ProdutoDAO();
    }

    // Métodos GET e SET

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
    
    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
    
    public int getQuantidadeMin() {
        return quantidadeMin;
    }

    public void setQuantidadeMin(int quantidadeMin) {
        this.quantidadeMin = quantidadeMin;
    }
    
    public int getQuantidadeMax() {
        return quantidadeMax;
    }

    public void setQuantidadeMax(int quantidadeMax) {
        this.quantidadeMax = quantidadeMax;
    }
    
    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    /**
     * Retorna os dados do produto em uma string.
     *
     * @return Uma string com os dados do produto.
     */
    @Override
    public String toString() {
        return "Produto{" + 
                "idProduto=" + idProduto + 
                ", nome='" + nome + '\'' +
                ", preco=" + preco + 
                ", unidade='" + unidade + '\'' +
                ", quantidadeEstoque=" + quantidadeEstoque + 
                ", quantidadeMin=" + quantidadeMin + 
                ", quantidadeMax=" + quantidadeMax + 
                ", categoriaId=" + categoriaId + 
                '}';
    }

    /* Métodos para interação com o DAO */

    /**
     * Retorna a lista de produtos.
     *
     * @return Um ArrayList com todos os produtos.
     */
    public ArrayList<Produto> getMinhaLista() {
        return dao.getMinhaLista();
    }

    /**
     * Insere um novo produto no banco de dados.
     *
     * @param nome Nome do produto.
     * @param preco Preço unitário.
     * @param unidade Unidade de medida.
     * @param quantidadeEstoque Quantidade atual.
     * @param quantidadeMin Quantidade mínima.
     * @param quantidadeMax Quantidade máxima.
     * @param categoriaId ID da categoria.
     * @return Verdadeiro se inseriu com sucesso.
     */
    public boolean insertProdutoBD(String nome, double preco, String unidade,
                                   int quantidadeEstoque, int quantidadeMin, int quantidadeMax, int categoriaId) {
        int idProduto = this.maiorID() + 1;
        Produto objeto = new Produto(idProduto, nome, preco, unidade, quantidadeEstoque, quantidadeMin, quantidadeMax, categoriaId);
        dao.insertProdutoBD(objeto);
        return true;
    }

    /**
     * Deleta um produto pelo ID.
     *
     * @param idProduto ID do produto a ser deletado.
     * @return Verdadeiro se deletou com sucesso.
     */
    public boolean deleteProdutoBD(int idProduto) {
        dao.deleteProdutoBD(idProduto);
        return true;
    }

    /**
     * Atualiza os dados de um produto.
     *
     * @param idProduto ID do produto.
     * @param nome Nome do produto.
     * @param preco Preço unitário.
     * @param unidade Unidade.
     * @param quantidadeEstoque Estoque atual.
     * @param quantidadeMin Estoque mínimo.
     * @param quantidadeMax Estoque máximo.
     * @param categoriaId Categoria relacionada.
     * @return Verdadeiro se atualizou com sucesso.
     */
    public boolean updateProdutoBD(int idProduto, String nome, double preco, String unidade,
                                   int quantidadeEstoque, int quantidadeMin, int quantidadeMax, int categoriaId) {
        Produto objeto = new Produto(idProduto, nome, preco, unidade, quantidadeEstoque, quantidadeMin, quantidadeMax, categoriaId);
        dao.updateProdutoBD(objeto);
        return true;
    }

    /**
     * Carrega os dados de um produto específico.
     *
     * @param idProduto ID do produto.
     * @return Um objeto Produto preenchido.
     */
    public Produto carregaProduto(int idProduto) {
        return dao.carregaProduto(idProduto);
    }

    /**
     * Retorna o maior ID da base de dados.
     *
     * @return Maior valor de ID.
     */
    public int maiorID() {
        return dao.maiorID();
    }
}