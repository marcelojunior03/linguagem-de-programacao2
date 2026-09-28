<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.math.BigDecimal"%>
<!DOCTYPE html>
<html>
<head>
<title>Exclusão de Curso</title>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="../webjars/bootstrap/5.0.2/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
  <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <ul class="navbar-nav align-items-center">
      <li><a href="../index.html" class="h4 px-4 text-decoration-none text-white">Livraria</a></li>
      <li><a href="../EstudanteController" class="h5 pt-3 nav-link active">Estudantes</a></li>
      <li><a href="../CursoController" class="h5 pt-3 nav-link active">Cursos</a></li>
    </ul>
  </nav>
  <div class="py-3 px-4">
    <h4>Exclusão de Curso</h4>
  </div>
  <div class="px-4">
    <h5>Deseja realmente excluir esta curso?</h5>
    <%
    out.println("<p class='my-0'><b>Id:</b> " + request.getParameter("tdId") + "</p>");
    out.println("<p class='my-0'><b>Descricao:</b> " + request.getParameter("tdDescricao") + "</p>");
    out.println("<p class='my-0'><b>CargaHoraria:</b> " + request.getParameter("tdCargaHoraria") + "</p>");
    %>
    <form action="../CursoController?op=exclusao" method="post">
      <%
      out.println("<input type='hidden' name='txId' value='" + request.getParameter("tdId") + "'>");
      %>
      <div class="pt-3">
        <input type="submit" name="btExcluir" value="Excluir" class="btn btn-success">
        <a href="../CursoController" class="btn btn-danger">Cancelar</a>
      </div>
    </form>
  </div>
</body>
</html>