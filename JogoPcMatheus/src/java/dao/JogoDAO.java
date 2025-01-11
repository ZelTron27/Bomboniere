package dao;

import modelo.Jogo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.ConectaBanco;

public class JogoDAO {

    public List<Jogo> listarJogos() {
        List<Jogo> jogos = new ArrayList<>();
        String sql = "SELECT * FROM jogos";  
        try (Connection con = ConectaBanco.getConexao(); 
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String descricao = rs.getString("descricao");

                Jogo jogo = new Jogo(id, nome, descricao);
                jogos.add(jogo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jogos;
    }

    
    public List<Jogo> listarJogosPorCategoria(int categoriaId) {
        List<Jogo> jogos = new ArrayList<>();
        String sql = "SELECT * FROM jogos WHERE categoria_id = ?";
        try (Connection con = ConectaBanco.getConexao(); 
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, categoriaId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    String descricao = rs.getString("descricao");

                    Jogo jogo = new Jogo(id, nome, descricao);
                    jogos.add(jogo);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jogos;
    }
}