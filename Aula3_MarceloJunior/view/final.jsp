<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.nio.charset.StandardCharsets" %>

<%

    if (session.getAttribute("usuario") == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    List<String> produtos =
        (List<String>) session.getAttribute("produtos");

    double total = 0;

%>

<!DOCTYPE html>

<html>

<head>

    <meta charset="UTF-8">

    <title>Compra realizada</title>

</head>

<body>

<h1>Compra realizada com sucesso!</h1>

<hr>

<h2>Produtos comprados</h2>

<%

if (produtos != null) {

    for (String produto : produtos) {

        String dados = URLDecoder.decode(
                produto,
                StandardCharsets.UTF_8
        );

        String[] partes = dados.split("\\|");

        String imagem = partes[0];
        String descricao = partes[1];
        double preco = Double.parseDouble(partes[2]);

        total += preco;

%>

<div>

    <img src="<%= imagem %>"
         width="120">

    <p>
        <strong><%= descricao %></strong>
    </p>

    <p>
        R$ <%= String.format("%.2f", preco) %>
    </p>

</div>

<%

    }
}

%>


<h2>
    Valor total:
    R$ <%= String.format("%.2f", total) %>
</h2>


<h2>Forma de pagamento</h2>

<p>
    <%= session.getAttribute("pagamento") %>
</p>


<h2>Parcelamento</h2>

<p>
    <%= session.getAttribute("parcelamento") %>x
</p>


<br>

<a href="logout">
    Sair
</a>

</body>

</html>