package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Categoria;

public class CategoriaDAO {

    public ArrayList<Categoria> minhaLista = new ArrayList<>();

    /**
     * Retorna a Lista de Categorias (objetos)
     * @return 
     */
    public ArrayList<Categoria> getMinhaLista() {
        minhaLista.clear();
        try {
            try (Statement stmt = ConexaoDB.getConexao().createStatement()) {
                ResultSet res = stmt.executeQuery("SELECT * FROM categoria");
                while (res.next()) {
                    int id = res.getInt("id");
                    String nome = res.getString("nome");
                    String tamanho = res.getString("tamanho");
                    String embalagem = res.getString("embalagem");
                    
                    Categoria objeto = new Categoria(id, nome, tamanho, embalagem);
                    minhaLista.add(objeto);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        return minhaLista;
    }

    /**
     * Retorna o maior ID da tabela categoria
     * @return 
     */
    public int maiorID() {
        int maiorID = 0;
        try {
            try (Statement stmt = ConexaoDB.getConexao().createStatement()) {
                ResultSet res = stmt.executeQuery("SELECT MAX(id) as id FROM categoria");
                res.next();
                maiorID = res.getInt("id");
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        return maiorID;
    }

    /**
     * Insere uma nova Categoria no banco de dados
     * @param objeto
     * @return 
     */
    public boolean insertCategoriaBD(Categoria objeto) {
        String sql = "INSERT INTO categoria(id, nome, tamanho, embalagem) VALUES (?, ?, ?, ?)";
        try {
            try (PreparedStatement stmt = ConexaoDB.getConexao().prepareStatement(sql)) {
                stmt.setInt(1, objeto.getIdCategoria());
                stmt.setString(2, objeto.getNome());
                stmt.setString(3, objeto.getTamanho());
                stmt.setString(4, objeto.getEmbalagem());
                
                stmt.execute();
            }

            return true;
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
            throw new RuntimeException(erro);
        }
    }

    /**
     * Deleta uma Categoria específica pelo seu campo ID
     * @param id
     * @return 
     */
    public boolean deleteCategoriaBD(int id) {
        try {
            try (Statement stmt = ConexaoDB.getConexao().createStatement()) {
                stmt.executeUpdate("DELETE FROM categoria WHERE id = " + id);
            }
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
        }
        return true;
    }

    /**
     * Edita uma Categoria específica pelo seu campo ID
     * @param objeto
     * @return 
     */
    public boolean updateCategoriaBD(Categoria objeto) {
        String sql = "UPDATE categoria SET nome = ?, tamanho = ?, embalagem = ? WHERE id = ?";
        try {
            try (PreparedStatement stmt = ConexaoDB.getConexao().prepareStatement(sql)) {
                stmt.setString(1, objeto.getNome());
                stmt.setString(2, objeto.getTamanho());
                stmt.setString(3, objeto.getEmbalagem());
                stmt.setInt(4, objeto.getIdCategoria());
                
                stmt.execute();
            }

            return true;
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
            throw new RuntimeException(erro);
        }
    }

    /**
     * Carrega uma Categoria específica pelo seu campo ID
     * @param id
     * @return 
     */
    public Categoria carregaCategoria(int id) {
        Categoria objeto = new Categoria();
        objeto.setIdCategoria(id);
        try {
            try (Statement stmt = ConexaoDB.getConexao().createStatement()) {
                ResultSet res = stmt.executeQuery("SELECT * FROM categoria WHERE id = " + id);
                res.next();
                
                objeto.setNome(res.getString("nome"));
                objeto.setTamanho(res.getString("tamanho"));
                objeto.setEmbalagem(res.getString("embalagem"));
            }
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
        }
        return objeto;
    }
    
    public int getOuCriaCategoriaPadrao() throws SQLException {
    String nome = "Sem Categoria";
    String tamanho = "Pequeno";
    String embalagem = "Lata";

    String sqlBusca = "SELECT id FROM categoria WHERE nome = ? LIMIT 1";

    try (Connection conn = ConexaoDB.getConexao();
         PreparedStatement stmt = conn.prepareStatement(sqlBusca)) {

        stmt.setString(1, nome);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return rs.getInt("id");
        }
    }

    // Se não existir, cria
    String sqlInsere = "INSERT INTO categoria (nome, tamanho, embalagem) VALUES (?, ?, ?)";

    try (Connection conn = ConexaoDB.getConexao();
         PreparedStatement stmt = conn.prepareStatement(sqlInsere, Statement.RETURN_GENERATED_KEYS)) {

        stmt.setString(1, nome);
        stmt.setString(2, tamanho);
        stmt.setString(3, embalagem);
        stmt.executeUpdate();

        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1); // retorna o novo id
        } else {
            throw new SQLException("Erro ao criar categoria padrão.");
        }
    }
}


    public void atualizarProdutosParaNovaCategoria(int categoriaAntigaId, int novaCategoriaId) throws SQLException {
        String sql = "UPDATE produto SET categoria_id = ? WHERE categoria_id = ?";

        try (Connection conn = ConexaoDB.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, novaCategoriaId);
            stmt.setInt(2, categoriaAntigaId);
            stmt.executeUpdate();
        }
    }
    
    public int getIdPorNome(String nomeCategoria) {
        int id = -1;
        try {
            Connection conn = ConexaoDB.getConexao();
            String sql = "SELECT id FROM categoria WHERE nome = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nomeCategoria);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                id = rs.getInt("id");
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar ID da categoria: " + e.getMessage());
        }
        return id;
    }
}