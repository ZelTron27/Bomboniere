<%@page import="modelo.Categoria" %>
<%@page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Categorias</title>
        <link rel="stylesheet" type="text/css" href="css/reset.css">
        <link rel="stylesheet" type="text/css" href="css/estilos.css">
        <link rel="stylesheet" type="text/css" href="css/tema.css">
    </head>
    <body class="pagina-categorias">
        <div class="background-blur"></div>
        <div class="content">
        <h1>Categorias de Jogos</h1>
            <% 
               List<Categoria> listaCategorias = (List<Categoria>) request.getAttribute("listagemCategorias");
               if (listaCategorias != null && !listaCategorias.isEmpty()) {
                   for (Categoria cat : listaCategorias){
            %>
                <div class="categorias">
                    <div class="caixaCategoria">
                        <!-- Transformando o link em botão -->
                        <a href="jogos?categoriaId=<%= cat.getId() %>&categoriaNome=<%= cat.getNome() %>" class="categoria-button">
                            <button class="categoria-btn"><%= cat.getNome() %></button>
                        </a>
                    </div>
                </div> 
            <% 
               }
             } else {
            %>
                <p>Nenhuma categoria encontrada.</p>
            <% 
             }
            %>
        </div>
    </body>
</html>
