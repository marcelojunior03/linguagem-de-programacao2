<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Erro de Entrada de Dados</title>
<meta charset="ISO-8859-1">
<link href="webjars/bootstrap/5.0.2/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
  <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <ul class="navbar-nav align-items-center">
      <li><a href="index.html" class="h4 px-4 text-decoration-none text-white">Universidade</a></li>
      <li><a href="LivroController" class="h5 pt-3 nav-link active">Estudantes</a></li>
      <li><a href="EditoraController" class="h5 pt-3 nav-link active">Cursos</a></li>
    </ul>
  </nav>
  <div class="py-3 px-4">
    <h4>Erro</h4>
  </div>
  <div class="px-4">
    <%
    	out.println("<p>Erro na entrada de dados.</p>");
    %>
  </div>
  <div class="pt-3 px-4">
    <a href="index.html" class="btn btn-success">Página Inicial</a>
  </div>
</body>
</html>