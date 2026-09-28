<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Alteração de Curso</title>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="webjars/bootstrap/5.0.2/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
  <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <ul class="navbar-nav align-items-center">
      <li><a href="index.html" class="h4 px-4 text-decoration-none text-white">Livraria</a></li>
      <li><a href="EstudanteController" class="h5 pt-3 nav-link active">Estudantes</a></li>
      <li><a href="CursoController" class="h5 pt-3 nav-link active">Cursos</a></li>
    </ul>
  </nav>
  <div class="py-3 px-4">
    <h4>Alteração de Curso</h4>
  </div>
  <div class="px-4">
    <%
    Boolean sucesso = Boolean.parseBoolean(request.getAttribute("resultado").toString());
    
    if (sucesso)
    	out.println("<p>Curso alterada com sucesso.</p>");
    else
    	out.println("<p>Erro ao alterar curso.</p>");
    %>
  </div>
  <div class="pt-3 px-4">
    <a href="CursoController" class="btn btn-success">Voltar</a>
  </div>
</body>
</html>