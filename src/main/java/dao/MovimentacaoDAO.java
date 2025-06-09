package dao;

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
     * @return 
     */
    public ArrayList<Movimentacao> getMinhaLista() {
        minhaLista.clear();  // Limpa a lista antes de preencher

        try {
            Statement stmt = ConexaoDB.getConexao().createStatement();
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
     * @return 
     */
    public int maiorID() {
        int maiorID = 0;
        try {
            Statement stmt = ConexaoDB.getConexao().createStatement();
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
     * Insere uma nova movimentacao no banco de dados
     * @param obj
     * @return 
     */
    public boolean insertMovimentacaoBD(Movimentacao obj) {
        String sql = "INSERT INTO movimentacao (id, tipo, data_movimentacao, quantidade, produto_id) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = ConexaoDB.getConexao().prepareStatement(sql);

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
     * @param id
     * @return 
     */
    public boolean deleteMovimentacaoBD(int id) {
        try {
            Statement stmt = ConexaoDB.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM movimentacao WHERE id = " + id);
            stmt.close();
            return true;
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
            return false;
        }
    }
    
    public boolean deleteMovimentacoesProdutoBD(int idProduto) {
        try (PreparedStatement stmt = ConexaoDB.getConexao()
                .prepareStatement("DELETE FROM movimentacao WHERE produto_id = ?")) {
            stmt.setInt(1, idProduto);
            stmt.executeUpdate();
            return true;
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
            return false;
        }
    }

    /**
     * Atualiza uma movimentacao existente
     * @param obj
     * @return 
     */
    public boolean updateMovimentacaoBD(Movimentacao obj) {
        String sql = "UPDATE movimentacao SET tipo = ?, data_movimentacao = ?, quantidade = ?, produto_id = ? WHERE id = ?";

        try {
            PreparedStatement stmt = ConexaoDB.getConexao().prepareStatement(sql);

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
     * @param id
     * @return 
     */
    public Movimentacao carregaMovimentacao(int id) {
        Movimentacao obj = new Movimentacao();
        obj.setId(id);

        try {
            Statement stmt = ConexaoDB.getConexao().createStatement();
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
    
    public boolean possuiMovimentacoes(int idProduto) {
        String sql = "SELECT COUNT(*) FROM movimentacao WHERE produto_id = ?";
        try (PreparedStatement stmt = ConexaoDB.getConexao().prepareStatement(sql)) {
            stmt.setInt(1, idProduto);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException erro) {
            System.out.println("Erro ao verificar movimentações: " + erro);
        }
        return false;
    }
}