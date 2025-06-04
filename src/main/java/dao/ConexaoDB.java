package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String SERVER = "localhost";
    private static final String DATABASE = "controle_estoque";
    private static final String URL = "jdbc:mysql://" + SERVER + ":3306/" + DATABASE + "?useTimezone=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "root";  // Ajuste conforme o necessário

    /**
     * Retorna uma conexão com o banco de dados.
     * @return 
     */
    public static Connection getConexao() {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
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
}