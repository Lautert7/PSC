package modelo;

import dao.ProdutoDAO;
import java.util.ArrayList;

/**
 * Classe que representa um Produto.
 */
public class Produto {

    private int id;
    private String nome;
    private double precoUnitario;
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

    public Produto(int id, String nome, double precoUnitario, String unidade,
                   int quantidadeEstoque, int quantidadeMin, int quantidadeMax, int categoriaId) {
        this.id = id;
        this.nome = nome;
        this.precoUnitario = precoUnitario;
        this.unidade = unidade;
        this.quantidadeEstoque = quantidadeEstoque;
        this.quantidadeMin = quantidadeMin;
        this.quantidadeMax = quantidadeMax;
        this.categoriaId = categoriaId;
        this.dao = new ProdutoDAO();
    }

    // Métodos GET e SET

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
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
                "id=" + id + 
                ", nome='" + nome + '\'' +
                ", precoUnitario=" + precoUnitario + 
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
     * @param precoUnitario Preço unitário.
     * @param unidade Unidade de medida.
     * @param quantidadeEstoque Quantidade atual.
     * @param quantidadeMin Quantidade mínima.
     * @param quantidadeMax Quantidade máxima.
     * @param categoriaId ID da categoria.
     * @return Verdadeiro se inseriu com sucesso.
     */
    public boolean insertProdutoBD(String nome, double precoUnitario, String unidade,
                                   int quantidadeEstoque, int quantidadeMin, int quantidadeMax, int categoriaId) {
        int id = this.maiorID() + 1;
        Produto objeto = new Produto(id, nome, precoUnitario, unidade, quantidadeEstoque, quantidadeMin, quantidadeMax, categoriaId);
        dao.insertProdutoBD(objeto);
        return true;
    }

    /**
     * Deleta um produto pelo ID.
     *
     * @param id ID do produto a ser deletado.
     * @return Verdadeiro se deletou com sucesso.
     */
    public boolean deleteProdutoBD(int id) {
        dao.deleteProdutoBD(id);
        return true;
    }

    /**
     * Atualiza os dados de um produto.
     *
     * @param id ID do produto.
     * @param nome Nome do produto.
     * @param precoUnitario Preço unitário.
     * @param unidade Unidade.
     * @param quantidadeEstoque Estoque atual.
     * @param quantidadeMin Estoque mínimo.
     * @param quantidadeMax Estoque máximo.
     * @param categoriaId Categoria relacionada.
     * @return Verdadeiro se atualizou com sucesso.
     */
    public boolean updateProdutoBD(int id, String nome, double precoUnitario, String unidade,
                                   int quantidadeEstoque, int quantidadeMin, int quantidadeMax, int categoriaId) {
        Produto objeto = new Produto(id, nome, precoUnitario, unidade, quantidadeEstoque, quantidadeMin, quantidadeMax, categoriaId);
        dao.updateProdutoBD(objeto);
        return true;
    }

    /**
     * Carrega os dados de um produto específico.
     *
     * @param id ID do produto.
     * @return Um objeto Produto preenchido.
     */
    public Produto carregaProduto(int id) {
        return dao.carregaProduto(id);
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