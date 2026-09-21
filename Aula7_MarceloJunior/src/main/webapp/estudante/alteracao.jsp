<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Alteração de Estudante</title>
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
    <h4>Alteração de Estudante</h4>
  </div>
  <div class="px-4">
    <form action="../EstudanteController?op=alteracao" method="post">
      <%
        out.println("<p>Id <input type='text' name='txId' size='10' value='" + request.getParameter("tdId") + "' readonly></p>");
        out.println("<p>Nome <input type='text' name='txNome' size='50' value='" + request.getParameter("tdNome") + "'></p>");
        out.println("<p>Sexo");
        out.println("<input type='radio' name='rbSexo' value='M' " + ("M".equals("tdSexo") ? "checked" : "") + "> Masculino");
        out.println("<input type='radio' name='rbSexo' value='F' " + ("F".equals("tdSexo") ? "checked" : "") + "> Feminino");
        out.println("</p>");
        if (request.getParameter("tdPcd").equals("Sim"))
          out.println("<input type='checkbox' name='ckPcd' checked>");
        else
          out.println("<input type='checkbox' name='ckPcd'>");
        out.println("<label>Pcd</label>");
        out.println("<p>Ira <input type='text' name='txIra' size='20' value='" + request.getParameter("tdIra").replace(".", ",") + "'></p>");
      %>
      <div class="pt-3">
        <input type="submit" name="btAlterar" value="Alterar" class="btn btn-success">
        <a href="../EstudanteController" class="btn btn-danger">Cancelar</a>
      </div>
    </form>
  </div>
</body>
</html>
