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

    <title>Cadastro do Pedido</title>

</head>

<body>

<h1>Cadastro do Pedido</h1>

<h2>Produtos selecionados</h2>

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
             width="100">

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

<h3>
    Total:
    R$ <%= String.format("%.2f", total) %>
</h3>


<hr>


<form action="pedido" method="post">

    <h2>Dados do cliente</h2>

    <label>Nome completo:</label>

    <input type="text"
           name="nome"
           required>

    <br><br>


    <label>CPF:</label>

    <input type="text"
           name="cpf"
           required>

    <br><br>


    <label>Sexo:</label>

    <input type="radio"
           name="sexo"
           value="Masculino"
           required>
    Masculino

    <input type="radio"
           name="sexo"
           value="Feminino">
    Feminino

    <br><br>


    <label>Endereço:</label>

    <input type="text"
           name="endereco"
           required>

    <br><br>


    <label>Cidade:</label>

    <input type="text"
           name="cidade"
           required>

    <br><br>


    <label>Estado:</label>

    <select name="estado" required>

        <option value="SP">SP</option>
        <option value="RJ">RJ</option>
        <option value="MG">MG</option>
        <option value="ES">ES</option>

    </select>

    <br><br>


    <label>Forma de pagamento:</label>

    <br>

    <input type="radio"
           name="pagamento"
           value="Cartão de Crédito"
           required>
    Cartão de Crédito

    <br>

    <input type="radio"
           name="pagamento"
           value="Pix">
    Pix

    <br>

    <input type="radio"
           name="pagamento"
           value="Boleto Bancário">
    Boleto Bancário

    <br><br>


    <label>Parcelamento:</label>

    <select name="parcelamento">

        <option value="1">
            1 x R$ <%= String.format("%.2f", total) %>
        </option>

        <option value="2">
            2 x R$ <%= String.format("%.2f", total / 2) %>
        </option>

        <option value="3">
            3 x R$ <%= String.format("%.2f", total / 3) %>
        </option>

    </select>

    <br><br>


    <button type="submit">
        Finalizar Compra
    </button>

</form>


<br>

<a href="logout">
    Sair
</a>

</body>

</html>