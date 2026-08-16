<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>

<body>

<h1>Autenticação</h1>

<form action="login" method="post">

    <label>Username:</label>
    <input type="text" name="username" required>

    <br><br>

    <label>Senha:</label>
    <input type="password" name="senha" required>

    <br><br>

    <button type="submit">
        Entrar
    </button>

</form>

<%
    String erro = request.getParameter("erro");

    if (erro != null) {
%>

    <p style="color:red;">
        Usuário ou senha incorretos!
    </p>

<%
    }
%>

</body>
</html>