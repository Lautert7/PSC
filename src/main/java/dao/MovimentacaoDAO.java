package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; 
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import modelo.Movimentacao;

public class MovimentacaoDAO {

    // Lista para armazenar objetos Movimentacao
    public ArrayList<Movimentacao> minhaLista = new ArrayList<>();

    /**
     * Retorna a Lista de Movimentacoes
     */
    public ArrayList<Movimentacao> getMinhaLista() {
        minhaLista.clear();  // Limpa a lista antes de preencher

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM movimentacao");
            
            while (res.next()) {
                int id = res.getInt("id");
                String tipo = res.getString("tipo");
                Timestamp timestamp = res.getTimestamp("data_movimentacao");
                LocalDateTime dataMovimentacao = timestamp.toLocalDateTime();
                int quantidade = res.getInt("quantidade");
                int produtoId = res.getInt("produto_id");

                Movimentacao obj = new Movimentacao(id, tipo, dataMovimentacao, quantidade, produtoId);

                minhaLista.add(obj);
            }
            stmt.close();

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        return minhaLista;
    }

    public void setMinhaLista(ArrayList<Movimentacao> minhaLista) {
        this.minhaLista = minhaLista;
    }

    /**
     * Retorna o maior ID da tabela movimentacao
     */
    public int maiorID() {
        int maiorID = 0;
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id) AS id FROM movimentacao");
            if (res.next()) {
                maiorID = res.getInt("id");
            }
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        return maiorID;
    }

    /**
     * Retorna uma conexão com o banco de dados
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

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro de conexão: " + e.getMessage());
            return null;
        }
    }

    /**
     * Insere uma nova movimentacao no banco de dados
     */
    public boolean insertMovimentacaoBD(Movimentacao obj) {
        String sql = "INSERT INTO movimentacao (id, tipo, data_movimentacao, quantidade, produto_id) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setInt(1, obj.getId());
            stmt.setString(2, obj.getTipo());
            stmt.setTimestamp(3, Timestamp.valueOf(obj.getDataMovimentacao()));
            stmt.setInt(4, obj.getQuantidade());
            stmt.setInt(5, obj.getProdutoId());

            stmt.execute();
            stmt.close();

            return true;
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
            throw new RuntimeException(erro);
        }
    }

    /**
     * Deleta uma movimentacao pelo ID
     */
    public boolean deleteMovimentacaoBD(int id) {
        try {
            Statement stmt = this.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM movimentacao WHERE id = " + id);
            stmt.close();
            return true;
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
            return false;
        }
    }

    /**
     * Atualiza uma movimentacao existente
     */
    public boolean updateMovimentacaoBD(Movimentacao obj) {
        String sql = "UPDATE movimentacao SET tipo = ?, data_movimentacao = ?, quantidade = ?, produto_id = ? WHERE id = ?";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setString(1, obj.getTipo());
            stmt.setTimestamp(2, Timestamp.valueOf(obj.getDataMovimentacao()));
            stmt.setInt(3, obj.getQuantidade());
            stmt.setInt(4, obj.getProdutoId());
            stmt.setInt(5, obj.getId());

            stmt.execute();
            stmt.close();
            return true;

        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
            throw new RuntimeException(erro);
        }
    }

    /**
     * Carrega uma movimentacao pelo ID
     */
    public Movimentacao carregaMovimentacao(int id) {
        Movimentacao obj = new Movimentacao();
        obj.setId(id);

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM movimentacao WHERE id = " + id);

            if (res.next()) {
                obj.setTipo(res.getString("tipo"));
                obj.setDataMovimentacao(res.getTimestamp("data_movimentacao").toLocalDateTime());
                obj.setQuantidade(res.getInt("quantidade"));
                obj.setProdutoId(res.getInt("produto_id"));
            }
            stmt.close();

        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
        }
        return obj;
    }
}