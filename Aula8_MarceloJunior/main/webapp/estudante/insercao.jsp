<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="br.edu.ifsp.cadastro.servlets.CursoController"%>
<%@page import="br.edu.ifsp.cadastro.entities.Curso"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<title>Cadastro de Estudante</title>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="../webjars/bootstrap/5.0.2/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
  <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <ul class="navbar-nav align-items-center">
      <li><a href="../index.html" class="h4 px-4 text-decoration-none text-white">Universidade</a></li>
      <li><a href="../EstudanteController" class="h5 pt-3 nav-link active">Estudantes</a></li>
      <li><a href="../CursoController" class="h5 pt-3 nav-link active">Cursos</a></li>
    </ul>
  </nav>
  <div class="py-3 px-4">
    <h4>Cadastro de Estudante</h4>
  </div>
  <div class="px-4">
    <form action="../EstudanteController?op=insercao" method="post">
      <p>Nome <input type="text" name="txTitulo" size="50"></p>
      <p>Curso <select name="slCurso">
      <%
      List<Curso> cursos = new CursoController().consultaCursos();
      
      out.println("<option value=''></option>");
      for(Curso curso : cursos)
    	  out.println("<option value=" + curso.getId() + ">" + curso.toString() + "</option>");
      %>
      </select></p> 
      <p>Sexo
      	<input type="radio" name="rbSexo" value="M" id="sexoM"> 
      	<label for="sexoM">Masculino</label>
      	<input type="radio" name="rbSexo" value="F" id="sexoF"> 
      	<label for="sexoF">Feminino</label>
      </p>
      <input type="checkbox" name="ckPcd">
	  <label>Pcd</label>
	  <p>Ira <input type="text" name="txIra" size="20"></p>
      <div class="pt-3">
        <input type="submit" name="btInserir" value="Inserir" class="btn btn-success">
        <a href="../EstudanteController" class="btn btn-danger">Cancelar</a>
      </div>
    </form>
  </div>
</body>
</html>