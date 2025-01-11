<%@page import="modelo.Detalhe" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Detalhes do Jogo</title>
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/estilos.css">
    <link rel="stylesheet" type="text/css" href="css/tema.css">
    
</head>
<body class="pagina-detalhes">
    <div class="background-blur"></div>
    <div class="content">
        <h1>Detalhes do Jogo</h1>
        <table border="1">
            <tr>                
                <th>Nome</th>
                <th>Plataforma</th>
                <th>Ano de Lançamento</th>
                <th>Modo de Jogo</th>
            </tr>
            <%                 
                Detalhe detalhe = (Detalhe) request.getAttribute("detalhe");          
                if (detalhe != null) {
            %>
                <tr>
                    <td><%= detalhe.getNome() %></td> 
                    <td><%= detalhe.getPlataforma() %></td> 
                    <td><%= detalhe.getAnoLancamento() %></td> 
                    <td><%= detalhe.getModoJogo() %></td> 
                </tr>
            <% 
                } else {
            %>
                <tr><td colspan="5">Detalhes não encontrados.</td></tr> 
            <% } %>
        </table>
    </div>
</body>
</html>