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
     */
    public ArrayList<Categoria> getMinhaLista() {
        minhaLista.clear();
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM categoria");
            while (res.next()) {
                int id = res.getInt("id");
                String nome = res.getString("nome");
                String tamanho = res.getString("tamanho");
                String embalagem = res.getString("embalagem");

                Categoria objeto = new Categoria(id, nome, tamanho, embalagem);
                minhaLista.add(objeto);
            }
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        return minhaLista;
    }

    /**
     * Retorna o maior ID da tabela categoria
     */
    public int maiorID() {
        int maiorID = 0;
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id) as id FROM categoria");
            res.next();
            maiorID = res.getInt("id");
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        return maiorID;
    }

    /**
     * Estabelece a conexão com o banco de dados
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
     */
    public boolean insertCategoriaBD(Categoria objeto) {
        String sql = "INSERT INTO categoria(id, nome, tamanho, embalagem) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);
            stmt.setInt(1, objeto.getId());
            stmt.setString(2, objeto.getNome());
            stmt.setString(3, objeto.getTamanho());
            stmt.setString(4, objeto.getEmbalagem());

            stmt.execute();
            stmt.close();

            return true;
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
            throw new RuntimeException(erro);
        }
    }

    /**
     * Deleta uma Categoria específica pelo seu campo ID
     */
    public boolean deleteCategoriaBD(int id) {
        try {
            Statement stmt = this.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM categoria WHERE id = " + id);
            stmt.close();
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
        }
        return true;
    }

    /**
     * Edita uma Categoria específica pelo seu campo ID
     */
    public boolean updateCategoriaBD(Categoria objeto) {
        String sql = "UPDATE categoria SET nome = ?, tamanho = ?, embalagem = ? WHERE id = ?";
        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);
            stmt.setString(1, objeto.getNome());
            stmt.setString(2, objeto.getTamanho());
            stmt.setString(3, objeto.getEmbalagem());
            stmt.setInt(4, objeto.getId());

            stmt.execute();
            stmt.close();

            return true;
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
            throw new RuntimeException(erro);
        }
    }

    /**
     * Carrega uma Categoria específica pelo seu campo ID
     */
    public Categoria carregaCategoria(int id) {
        Categoria objeto = new Categoria();
        objeto.setId(id);
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM categoria WHERE id = " + id);
            res.next();

            objeto.setNome(res.getString("nome"));
            objeto.setTamanho(res.getString("tamanho"));
            objeto.setEmbalagem(res.getString("embalagem"));

            stmt.close();
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
        }
        return objeto;
    }
}