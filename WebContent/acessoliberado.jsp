<jsp:useBean id="calcula" class="beans.BeanCursoJsp" type="beans.BeanCursoJsp" scope="page" ></jsp:useBean>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Projeto Java JSP</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="jumbotron">
  <h1 class="display-4">Bem vindo ao Projeto Java JSP!</h1>
  <p class="lead">Este � um projeto feio com as tecnologias Java(JSP) e Bootstrap 4.</p>
  <hr class="my-4">
  <p>Projeto adaptado do Curso Java JSP do site javaavancado.com
  desenvolvido por Fernando Oliveira para o portf�lio fernandooliveira.com</p> 
  <p class="lead">
    <a href="salvarUsuario?acao=listartodos" class="btn btn-primary btn-lg"  role="button">Cadastro de Usu�rio</a>
  </p>
</div>

	
</body>
</html>