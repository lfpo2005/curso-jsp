<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Telefones</title>




<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>



</head>
<body>
	<div class="btn-group">

		<a href="acessoliberado.jsp" class="btn btn-primary col-md-6"
			role="button">Inicio</a> <a href="index.jsp"
			class="btn btn-primary col-md-6" role="button">Sair</a>

	</div>

	<div class="container">
		<div class="form-group">
			<div class="col-md-10 offset-md-3">

				<h1>Cadastro de Telefones</h1>
				<form action="salvarTelefones" method="post"
					onsubmit="return validarCampos()? true : false;">
					<table class="col-md-6 offset-md-1">
						<h3 class="alert-danger">${msg}</h3>
						<tr>
							<td>User</td>
							<td><input type="text" class="form-control"
								readonly="readonly" id="id" name="id" value="${userEscolhido}" /></td>

							
						
					</table>
					<br>
					<button type="submit" class="btn btn-primary col-md-3 offset-md-1">Salvar</button>
					<button type="reset" class="btn btn-primary col-md-3 offset-md-0">Cancelar</button>
				</form>
				<br>

			</div>
		</div>
	</div>
	<br>

	<div class="form-group">
		<h1 class=" offset-md-3">Usuários Cadastrados</h1>
		<div class="col-md-6 offset-md-1">

			<table class="table">

				<tr>
					<th>Id</th>
					<th>Numero</th>
					<th>Tipo</th>
					<th>Excluir</th>
					
				</tr>
				<c:forEach items="${telefones}" var="fone">
					<tbody>
						<td><c:out value="${fone.id}"></c:out></td>
						<td><c:out value="${fone.numero}"></c:out></td>
						<td><c:out value="${fone.tipo}"></c:out></td>
					
						

						<td><a href="Usuario?acao=delete&user=${user.id}"><img
								alt="Excluir" title="Excluir"
								src="resources/img/delete-icon.png" width="20px" height="20px"></a></td>
								
						
						</tr>
				</c:forEach>
			</table>
		</div>
	</div>

	<script type="text/javascript">
		function validarCampos() {

			if (document.getElementById('login').value == '') {
				alert('Informe o Login');
				return false;
	
			return true;
		}

	

</body>
</html>