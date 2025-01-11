/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaBanco {
    
    public static Connection getConexao() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/catalogo_jogo", "root", ""); 
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro: Driver JDBC do MySQL não encontrado.");
            throw new RuntimeException("Erro de classe não encontrada: " + ex.getMessage(), ex);
        } catch (SQLException ex) {
            System.out.println("Erro: Falha ao conectar ao banco de dados.");
            throw new RuntimeException("Erro de SQL: " + ex.getMessage(), ex);
        }
        return con;
    }
}