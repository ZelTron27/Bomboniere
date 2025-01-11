package controle;

import dao.CategoriaDAO;
import modelo.Categoria;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/categorias")
public class CategoriaControle extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        List<Categoria> categorias = categoriaDAO.listarCategorias();
        
        
        System.out.println("Categorias recuperadas: " + categorias.size());
        
        
        request.setAttribute("listagemCategorias", categorias);
        
        
        request.getRequestDispatcher("/categorias.jsp").forward(request, response);
    }
}