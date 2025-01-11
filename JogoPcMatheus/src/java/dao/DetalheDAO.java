package dao;

import modelo.Detalhe;
import java.sql.*;
import util.ConectaBanco;

public class DetalheDAO {

    
    public Detalhe buscarDetalhePorId(int id) {
        Detalhe detalhe = null;
        String sql = "SELECT * FROM detalhe_jogos WHERE id = ?";
        
        try (Connection con = ConectaBanco.getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);  
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) { 
                    
                    String nome = rs.getString("nome");
                    String plataforma = rs.getString("plataforma");
                    int anoLancamento = rs.getInt("ano_lancamento"); 
                    String modoJogo = rs.getString("modo_jogo");
                    
                    
                    detalhe = new Detalhe(nome, plataforma, anoLancamento, modoJogo);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return detalhe;  
    }
}