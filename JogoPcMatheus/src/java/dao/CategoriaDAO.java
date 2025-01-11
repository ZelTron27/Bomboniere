package dao;

import modelo.Categoria;
import util.ConectaBanco;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {


    public List<Categoria> listarCategorias() {
        List<Categoria> categorias = new ArrayList<>();
        
        
        String sql = "SELECT id, nome FROM categorias";  
        
        try (Connection con = ConectaBanco.getConexao();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            
            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("id"));
                categoria.setNome(rs.getString("nome"));
                
                
                categorias.add(categoria);
            }
        } catch (SQLException e) {
            e.printStackTrace();  
        }
        
        return categorias;
    }
}