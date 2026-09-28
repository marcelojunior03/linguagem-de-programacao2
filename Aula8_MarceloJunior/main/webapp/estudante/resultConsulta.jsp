<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="br.edu.ifsp.cadastro.entities.Estudante"%>
<%@page import="java.util.List"%>
<%@page import="java.text.DecimalFormat"%>
<!DOCTYPE html>
<html>
<head>
<title>Consulta de Estudantes</title>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="webjars/bootstrap/5.0.2/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
  <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <ul class="navbar-nav align-items-center">
      <li><a href="index.html" class="h4 px-4 text-decoration-none text-white">Universidade</a></li>
      <li><a href="EstudanteController" class="h5 pt-3 nav-link active">Estudantes</a></li>
      <li><a href="CursoController" class="h5 pt-3 nav-link active">Cursos</a></li>
    </ul>
  </nav>
  <div class="py-3 px-4">
    <h4>Consulta de Estudantes</h4>
  </div>
  <div class="px-4">
  <table class="table table-sm">
    <thead class="table-success">
      <tr>
        <th><div class="d-flex justify-content-center">Id</div></th>
        <th><div class="d-flex justify-content-center">Nome</div></th>
        <th><div class="d-flex justify-content-center">Sexo</div></th>
        <th><div class="d-flex justify-content-center">Pcd</div></th>
        <th><div class="d-flex justify-content-center">Ira</div></th>
        <th><div class="d-flex justify-content-center">Curso</div></th>
        <th colspan="2"><div class="d-flex justify-content-center">Operações</div></th>
      </tr>
    </thead>
    <tbody>
      <%
      @SuppressWarnings("unchecked")
      List<Estudante> estudantes = (List<Estudante>) request.getAttribute("estudantes");
      DecimalFormat df = new DecimalFormat("###,##0.00");

      for (Estudante estudante : estudantes) {
      	out.println("<tr>");
      	out.println("<td><div class='d-flex justify-content-center'>" + estudante.getId() + "</div></td>");
      	out.println("<td>" + estudante.getNome() + "</td>");
      	out.println("<td><div class='d-flex justify-content-center'>" + estudante.getSexo() + "</div></td>");
      	out.println("<td><div class='d-flex justify-content-center'>" + (estudante.getPcd() ? "Sim" : "Não") + "</div></td>");
      	out.println("<td><div class='d-flex justify-content-center'>" + df.format(estudante.getIra()) + "</div></td>");
      	out.println("<td><div class='d-flex justify-content-center'>" + (estudante.getCurso() != null ? estudante.getCurso().toString() : "") + "</div></td>");
        
        out.println("<td><div class='d-flex justify-content-center'><form action='estudante/alteracao.jsp' method='post'>");
      	out.println("<input type='hidden' name='tdId' value='" + estudante.getId() + "'>");
      	out.println("<input type='hidden' name='tdNome' value='" + estudante.getNome() + "'>");
      	out.println("<input type='hidden' name='tdSexo' value='" + estudante.getSexo() + "'>");
      	out.println("<input type='hidden' name='tdPcd' value='" + (estudante.getPcd() ? "Sim" : "Não") + "'>");
      	out.println("<input type='hidden' name='tdIra' value='" + estudante.getIra() + "'>");
      	out.println("<input type='hidden' name='tdCurso' value='" + (estudante.getCurso() != null ? estudante.getCurso().getId() : "") + "'>");
      	out.println("<input type='submit' name='btAlterar' value='Alterar' class='btn btn-success px-3 py-0'>");
      	out.println("</form></div></td>");
        
      	out.println("<td><div class='d-flex justify-content-center'><form action='estudante/exclusao.jsp' method='post'>");
      	out.println("<input type='hidden' name='tdId' value='" + estudante.getId() + "'>");
      	out.println("<input type='hidden' name='tdNome' value='" + estudante.getNome() + "'>");
      	out.println("<input type='hidden' name='tdSexo' value='" + estudante.getSexo() + "'>");
      	out.println("<input type='hidden' name='tdPcd' value='" + (estudante.getPcd() ? "Sim" : "Não") + "'>");
      	out.println("<input type='hidden' name='tdIra' value='" + estudante.getIra() + "'>");
      	out.println("<input type='hidden' name='tdCurso' value='" + (estudante.getCurso() != null ? estudante.getCurso().toString() : "") + "'>");
      	out.println("<input type='submit' name='btExcluir' value='Excluir' class='btn btn-success px-3 py-0'>");
      	out.println("</form></div></td>");
      	out.println("</tr>");
      }
      %>
    </tbody>
  </table>
  <a href="estudante/insercao.jsp" class="btn btn-success">Inserir Estudante</a>
  </div>
</body>
</html>