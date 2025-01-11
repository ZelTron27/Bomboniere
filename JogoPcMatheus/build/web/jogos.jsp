<%@page import="modelo.Jogo" %>
<%@page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Jogos</title>
        <link rel="stylesheet" type="text/css" href="css/reset.css">
        <link rel="stylesheet" type="text/css" href="css/estilos.css">
        <link rel="stylesheet" type="text/css" href="css/tema.css">
    </head>
    <body class="pagina-jogos">
        <div class="background-blur"></div>
        
        <div class="content">
        <h1>Jogos</h1>
            <% 
                List<Jogo> listaJogos = (List<Jogo>) request.getAttribute("listagemJogos");
                if (listaJogos != null && !listaJogos.isEmpty()) {
                    for (Jogo serv : listaJogos){
            %>
            <div class="jogos">
                <div class="CaixaJogos">

                    <!-- Link para detalhes do jogo -->
                    <a href="detalhe_jogo?id=<%= serv.getId() %>" class="jogo-link">
                        <button class="jogo-btn">
                        <h2><%= serv.getNome() %></h2>
                        <p><%= serv.getDescricao() %></p>
                        </button>
                    </a>

                </div>
            </div>   
            <% 
                }
              } else {
            %>
                <p>Nenhum jogo encontrado.</p>
            <% 
             }
            %>
        </div>
    </body>
</html>
