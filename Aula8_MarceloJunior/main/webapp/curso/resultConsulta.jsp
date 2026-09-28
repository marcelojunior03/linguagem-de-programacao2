<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="br.edu.ifsp.cadastro.entities.Curso"%>
<%@page import="java.util.List"%>
<%@page import="java.text.DecimalFormat"%>
<!DOCTYPE html>
<html>
<head>
<title>Consulta de Cursos</title>
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
    <h4>Consulta de Cursos</h4>
  </div>
  <div class="px-4">
  <table class="table table-sm">
    <thead class="table-success">
      <tr>
        <th><div class="d-flex justify-content-center">Id</div></th>
        <th><div class="d-flex justify-content-center">Descricao</div></th>
        <th><div class="d-flex justify-content-center">CargaHoraria</div></th>
        <th colspan="2"><div class="d-flex justify-content-center">Operações</div></th>
      </tr>
    </thead>
    <tbody>
      <%
      @SuppressWarnings("unchecked")
      List<Curso> cursos = (List<Curso>) request.getAttribute("cursos");

      for (Curso curso : cursos) {
      	out.println("<tr>");
      	out.println("<td><div class='d-flex justify-content-center'>" + curso.getId() + "</div></td>");
      	out.println("<td>" + curso.getDescricao() + "</td>");
      	out.println("<td><div class='d-flex justify-content-center'>" + curso.getCargaHoraria() + "</div></td>");
        
        out.println("<td><div class='d-flex justify-content-center'><form action='curso/alteracao.jsp' method='post'>");
      	out.println("<input type='hidden' name='tdId' value='" + curso.getId() + "'>");
      	out.println("<input type='hidden' name='tdDescricao' value='" + curso.getDescricao() + "'>");
      	out.println("<input type='hidden' name='tdCargaHoraria' value='" + curso.getCargaHoraria() + "'>");
      	out.println("<input type='submit' name='btAlterar' value='Alterar' class='btn btn-success px-3 py-0'>");
      	out.println("</form></div></td>");
        
      	out.println("<td><div class='d-flex justify-content-center'><form action='curso/exclusao.jsp' method='post'>");
      	out.println("<input type='hidden' name='tdId' value='" + curso.getId() + "'>");
      	out.println("<input type='hidden' name='tdDescricao' value='" + curso.getDescricao() + "'>");
      	out.println("<input type='hidden' name='tdCargaHoraria' value='" + curso.getCargaHoraria() + "'>");
      	out.println("<input type='submit' name='btExcluir' value='Excluir' class='btn btn-success px-3 py-0'>");
      	out.println("</form></div></td>");
      	out.println("</tr>");
      }
      %>
    </tbody>
  </table>
  <a href="curso/insercao.jsp" class="btn btn-success">Inserir Curso</a>
  </div>
</body>
</html>