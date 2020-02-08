<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Produtos</title>
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

	<div class="container">
		<div class="form-group">
			<div class="col-md-6 offset-md-4">
			
				<h1>Cadastro de Podutos</h1>
				<form action="Produto" method="post">
					<table class="col-md-6 offset-md-1">
						<tr>
							<td>Id:</td>
							<td><input type="text" class="form-control"
								readonly="readonly" id="id" name="id" value="${pdt.id}" /></td>
						</tr>
						<tr>
							<td>Nome:</td>
							<td><input type="text" class="form-control" id="nome"
								name="nome" value="${pdt.nome}"></td>
								<h3 class="alert-danger">${msg}</h3>
						</tr>
						<tr>
							<td>Quantidade:</td>
							<td><input type="text" class="form-control" id="quantidade"
								name="quantidade" value="${pdt.quantidade}"></td>
						</tr>
						<tr>
							<td>Valor:</td>
							<td><input type="text" class="form-control" id="valor"
								name="valor" value="${pdt.valor}"></td>
						</tr>
						
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
		<div class="col-md-6 offset-md-3">

			<table class="table">
				<h1 class=" offset-md-3">Usuários Cadastrados</h1>
				<tr>
					<th>Id</th>
					<th>Nome</th>
					<th>Quantidade</th>
					<th>Valor</th>
					<th>Delete</th>
					<th>Editar</th>
				</tr>
				<c:forEach items="${produtos}" var="pdt">
					<tbody>
						<td><c:out value="${pdt.id}"></c:out></td>
						<td><c:out value="${pdt.nome}"></c:out></td>
						<td><c:out value="${pdt.quantidade}"></c:out></td>
						<td><c:out value="${pdt.valor}"></c:out></td>

						<td><a href="Produto?acao=delete&pdt=${pdt.id}"><img
								alt="Excluir" title="Excluir"
								src="resources/img/delete-icon.png" width="20px" height="20px"></a></td>
						<td><a href="Produto?acao=editar&pdt=${pdt.id}"><img
								alt="Editar" title="Editar" src="resources/img/edit-icon.png"
								width="20px" height="20px"></a></td>
						</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>