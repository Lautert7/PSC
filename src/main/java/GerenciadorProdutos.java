import java.sql.*;
import java.util.Scanner;

public class ListaPrecos {
    // Conexão com o banco de dados
    static final String URL = "jdbc:mysql://localhost:3306/controle_estoque";
    static final String USER = "root";
    static final String SENHA = "";
    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        while(true) {
            System.out.println("\n### Menu ###");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Ver lista de preços");
            System.out.println("3 - Sair");
            System.out.print("Digite sua opção: ");
            
            int opcao = teclado.nextInt();
            teclado.nextLine();
            
            if(opcao == 1) {
                cadastrarProduto(teclado);
            }
            else if(opcao == 2) {
                mostrarListaPrecos();
            }
            else if(opcao == 3) {
                System.out.println("Tchau!");
                break;
            }
            else {
                System.out.println("Opção inválida!");
            }
        }
    }
    
    public static void cadastrarProduto(Scanner teclado) {
        try {
            System.out.println("\n--- Cadastro de Produto ---");
            
            System.out.print("Nome do produto: ");
            String nome = teclado.nextLine();
            
            System.out.print("Preço (R$): ");
            double preco = teclado.nextDouble();
            
            // Conecta no banco
            Connection conexao = DriverManager.getConnection(URL, USER, SENHA);
            
            // Insere o produto
            String sql = "INSERT INTO produto (nome, preco_unitario) VALUES (?, ?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, nome);
            comando.setDouble(2, preco);
            
            comando.executeUpdate();
            System.out.println("Produto cadastrado!");
            
            conexao.close();
            
        } catch(Exception erro) {
            System.out.println("Erro: " + erro.getMessage());
        }
    }
    
    public static void mostrarListaPrecos() {
        try {
            // Conecta no banco
            Connection conexao = DriverManager.getConnection(URL, USER, SENHA);
            
            // Busca os produtos
            String sql = "SELECT nome, preco_unitario FROM produto ORDER BY nome";
            Statement comando = conexao.createStatement();
            ResultSet resultado = comando.executeQuery(sql);
            
            System.out.println("\n=== LISTA DE PREÇOS ===");
            System.out.println("----------------------");
            
            while(resultado.next()) {
                String nome = resultado.getString("nome");
                double preco = resultado.getDouble("preco_unitario");
                System.out.printf("%s - R$ %.2f\n", nome, preco);
            }
            
            conexao.close();
            
        } catch(Exception erro) {
            System.out.println("Erro: " + erro.getMessage());
        }
    }
}