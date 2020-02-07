<jsp:useBean id="calcula" class="beans.BeanUsuario"
	type="beans.BeanUsuario" scope="page"></jsp:useBean>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Projeto JSP</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<!-- <link  rel="stylesheet"  href="resources/css/style.css"> -->

</head>
<body>

	<div class="container">
		<h2>Projeto Java JSP</h2>
		<form action="LoginServlet">
			<div class="form-group">
				<label for="email">Email:</label> <input type="text"
					class="form-control" id="login" placeholder="Login" name="login">
			</div>
			<div class="form-group">
				<label for="pwd">Password:</label> <input type="password"
					class="form-control" id="senha" placeholder="password" name="senha">
			</div>
			<button type="submit" class="btn btn-primary">Logar</button>

		</form>
	</div>
</body>
</html>