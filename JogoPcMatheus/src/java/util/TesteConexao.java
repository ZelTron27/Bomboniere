package util;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {
    
    public static void main(String[] args) {
        try {
            
            Connection con = ConectaBanco.getConexao();

            if (con != null) {
                System.out.println("Conexão bem-sucedida ao banco de dados!");
                con.close(); 
            } else {
                System.out.println("Falha ao conectar ao banco de dados.");
            }
        } catch (SQLException e) {
            
            System.out.println("Erro de conexão: " + e.getMessage());
        }
    }
}