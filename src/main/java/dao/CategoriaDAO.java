package dao;

import java.sql.Connection;
import java.sql.DriverManager;
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
            try (Statement stmt = this.getConexao().createStatement()) {
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
            try (Statement stmt = this.getConexao().createStatement()) {
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
     * Estabelece a conexão com o banco de dados
     * @return 
     */
    public Connection getConexao() {
        Connection connection = null;
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);

            String server = "localhost";
            String database = "controle_estoque";
            String url = "jdbc:mysql://" + server + ":3306/" + database + "?useTimezone=true&serverTimezone=UTC";
            String user = "root";
            String password = "root";

            connection = DriverManager.getConnection(url, user, password);

            if (connection != null) {
                System.out.println("Status: Conectado!");
            } else {
                System.out.println("Status: NÃO CONECTADO!");
            }

            return connection;
        } catch (ClassNotFoundException e) {
            System.out.println("O driver não foi encontrado: " + e.getMessage());
            return null;
        } catch (SQLException e) {
            System.out.println("Não foi possível conectar: " + e.getMessage());
            return null;
        }
    }

    /**
     * Insere uma nova Categoria no banco de dados
     * @param objeto
     * @return 
     */
    public boolean insertCategoriaBD(Categoria objeto) {
        String sql = "INSERT INTO categoria(id, nome, tamanho, embalagem) VALUES (?, ?, ?, ?)";
        try {
            try (PreparedStatement stmt = this.getConexao().prepareStatement(sql)) {
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
            try (Statement stmt = this.getConexao().createStatement()) {
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
            try (PreparedStatement stmt = this.getConexao().prepareStatement(sql)) {
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
            try (Statement stmt = this.getConexao().createStatement()) {
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
}