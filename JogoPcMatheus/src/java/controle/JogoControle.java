package controle;

import dao.JogoDAO;
import modelo.Jogo;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jogos")
public class JogoControle extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String categoriaIdParam = request.getParameter("categoriaId");
        JogoDAO jogoDAO = new JogoDAO();
        
        List<Jogo> jogos;
        if (categoriaIdParam != null) {
            int categoriaId = Integer.parseInt(categoriaIdParam);
            jogos = jogoDAO.listarJogosPorCategoria(categoriaId);  
        } else {
            jogos = jogoDAO.listarJogos();  
        }
        
        request.setAttribute("listagemJogos", jogos);
        request.getRequestDispatcher("jogos.jsp").forward(request, response);
    }
}