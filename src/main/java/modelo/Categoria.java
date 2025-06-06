package modelo;

import dao.CategoriaDAO;
import java.util.ArrayList;


public class Categoria {

    private int idCategoria;
    private String nome;
    private String tamanho;
    private String embalagem;
    private CategoriaDAO dao;

    public Categoria() {
        this(0, "", "", "");
    }

    public Categoria(int idCategoria, String nome, String tamanho, String embalagem) {
        this.idCategoria = idCategoria;
        this.nome = nome;
        this.tamanho = tamanho;
        this.embalagem = embalagem;
        this.dao = new CategoriaDAO();
    }

    // Métodos GET e SET
    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int IdCategoria) {
        this.idCategoria = IdCategoria;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }
    
    public String getEmbalagem() {
        return embalagem;
    }

    public void setEmbalagem(String embalagem) {
        this.embalagem = embalagem;
    }

    /**
     * Retorna os dados da categoria em uma string.
     *
     * @return Uma string com os dados da categoria.
     */
    @Override
    public String toString() {
        return "Categoria{" + 
               "idCategoria=" + idCategoria + 
               ", nome=" + nome + 
               ", tamanho=" + tamanho + 
               ", embalagem=" + embalagem + 
               '}';
    }

    /* Métodos para uso junto com o DAO */
    
    /**
     * Retorna a lista de categorias.
     *
     * @return Um ArrayList com todas as categorias.
     */
    public ArrayList<Categoria> getMinhaLista() {
        return dao.getMinhaLista();
    }

    /**
     * Insere uma nova categoria.
     *
     * @param nome Nome da categoria.
     * @param tamanho Tamanho da categoria.
     * @param embalagem Embalagem da categoria.
     * @return Verdadeiro ou falso se conseguiu fazer a inclusão.
     */
    public boolean insertCategoriaBD( String nome, String tamanho, String embalagem) {
        int idCategoria = this.maiorID() + 1;
        Categoria objeto = new Categoria(idCategoria, nome, tamanho, embalagem);
        dao.insertCategoriaBD(objeto);
        return true;
    }

    /**
     * Deleta uma categoria específica pelo seu ID.
     *
     * @param IdCategoria ID da categoria a ser excluída.
     * @return Verdadeiro ou falso se conseguiu fazer a exclusão.
     */
    public boolean deleteCategoriaBD(int idCategoria) {
        dao.deleteCategoriaBD(idCategoria);
        return true;
    }

    /**
     * Edita uma categoria específica pelo seu ID.
     *
     * @param idCategoria ID da categoria.
     * @param nome Nome da categoria.
     * @param tamanho Tamanho da categoria.
     * @param embalagem Embalagem da categoria.
     * @return Verdadeiro ou falso se conseguiu fazer a alteração.
     */
    public boolean updateCategoriaBD(int idCategoria, String nome, String tamanho, String embalagem) {
        Categoria objeto = new Categoria(idCategoria, nome, tamanho, embalagem);
        dao.updateCategoriaBD(objeto);
        return true;
    }

    /**
     * Carrega os dados de uma categoria específica pelo seu ID.
     *
     * @param IdCategoria ID da categoria a ser carregada.
     * @return Um objeto Categoria preenchido.
     */
    public Categoria carregaCategoria(int idCategoria) {
        return dao.carregaCategoria(idCategoria);
    }

    /**
     * Retorna o maior ID da base de dados.
     *
     * @return Um inteiro com o maior valor de ID.
     */
    public int maiorID() {
        return dao.maiorID();
    }
}