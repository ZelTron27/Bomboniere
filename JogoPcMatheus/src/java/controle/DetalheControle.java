package controle;

import dao.DetalheDAO;
import modelo.Detalhe;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/detalhe_jogo")
public class DetalheControle extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            
            int id = Integer.parseInt(request.getParameter("id"));                        
            DetalheDAO detalheDAO = new DetalheDAO();
            Detalhe detalhe = detalheDAO.buscarDetalhePorId(id);
                        
            if (detalhe != null) {
                request.setAttribute("detalhe", detalhe);
                RequestDispatcher dispatcher = request.getRequestDispatcher("detalhe.jsp");
                dispatcher.forward(request, response);
            } else {
                
                response.getWriter().write("Serviço não encontrado.");
            }
        } catch (NumberFormatException e) {
            
            response.getWriter().write("ID inválido.");
        }
    }
}