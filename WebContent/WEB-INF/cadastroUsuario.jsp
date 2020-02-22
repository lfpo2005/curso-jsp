<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Usuário</title>




<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<!-- Adicionando JQuery -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
	crossorigin="anonymous"></script>

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

				<h1>Cadastro de Usuário</h1>
				<form action="Usuario" method="post"
					onsubmit="return validarCampos()? true : false;">
					<table class="col-md-6 offset-md-1">
						<h3 class="alert-danger">${msg}</h3>
						<tr>
							<td>Id:</td>
							<td><input type="text" class="form-control"
								readonly="readonly" id="id" name="id" value="${user.id}" /></td>

							<td>Cep:</td>
							<td><input type="text" class="form-control" id="cep"
								name="cep" value="${user.cep}" onblur="consultaCep();"></td>
						</tr>
						<tr>
							<td>Login:</td>
							<td><input type="text" class="form-control" id="login"
								name="login" value="${user.login}"></td>

							<td>Rua:</td>
							<td><input type="text" class="form-control" id="rua"
								name="rua" value="${user.rua}"></td>
						</tr>
						<tr>
							<td>Senha:</td>
							<td><input type="password" class="form-control" id="senha"
								name="senha" value="${user.senha}"></td>

							<td>Bairro:</td>
							<td><input type="text" class="form-control" id="bairro"
								name="bairro" value="${user.bairro}"></td>
						</tr>
						<tr>
							<td>Nome:</td>
							<td><input type="text" class="form-control" id="nome"
								name="nome" value="${user.nome}"></td>
							<td>Cidade:</td>
							<td><input type="text" class="form-control" id="cidade"
								name="cidade" value="${user.cidade}"></td>
						</tr>
						<tr>
							<td>Fone:</td>
							<td><input type="text" class="form-control" id="fone"
								name="fone" value="${user.fone}"></td>

							<td>Estado:</td>
							<td><input type="text" class="form-control" id="estado"
								name="estado" value="${user.estado}"></td>
						</tr>
						<tr>
							<td>Email:</td>
							<td><input type="text" class="form-control" id="email"
								name="email" value="${user.email}"></td>

							<td>IBGE:</td>
							<td><input type="text" class="form-control" id="ibge"
								name="ibge" value="${user.ibge}"></td>
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
					<th>Login</th>
					<th>Nome</th>
					<th>Fone</th>
					<th>E-mail</th>
					<th>CEP</th>
					<th>Rua</th>
					<th>Bairro</th>
					<th>Cidade</th>
					<th>Estado</th>
					<th>IBGE</th>
					<th>Delete</th>
					<th>Editar</th>
					<th>Fones</th>
				</tr>
				<c:forEach items="${usuarios}" var="user">
					<tbody>
						<td><c:out value="${user.id}"></c:out></td>
						<td><c:out value="${user.login}"></c:out></td>
						<td><c:out value="${user.nome}"></c:out></td>
						<td><c:out value="${user.fone}"></c:out></td>
						<td><c:out value="${user.email}"></c:out></td>
						<td><c:out value="${user.cep}"></c:out></td>
						<td><c:out value="${user.rua}"></c:out></td>
						<td><c:out value="${user.bairro}"></c:out></td>
						<td><c:out value="${user.cidade}"></c:out></td>
						<td><c:out value="${user.estado}"></c:out></td>
						<td><c:out value="${user.ibge}"></c:out></td>

						<td><a href="Usuario?acao=delete&user=${user.id}"><img
								alt="Excluir" title="Excluir"
								src="resources/img/delete-icon.png" width="20px" height="20px"></a></td>
								
						<td><a href="Usuario?acao=editar&user=${user.id}"><img
								alt="Editar" title="Editar" src="resources/img/edit-icon.png"
								width="20px" height="20px"></a></td>
								
						<td><a href="telefones?user=${user.id}"><img
								alt="telefones" title="telefones" src="resources/img/phone.png"
								width="23px" height="23px"></a></td>	
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
			} else if (document.getElementById('nome').value == '') {
				alert('Informe o Nome');
				return false;
			} else if (document.getElementById('senha').value == '') {
				alert('Informe o Senha');
				return false;
			} else if (document.getElementById('fone').value == '') {
				alert('Informe o Fone');
				return false;
			} else if (document.getElementById('email').value == '') {
				alert('Informe o Email');
				return false;
			}
			return true;
		}

		function consultaCep() {

			var cep = $("#cep").val();

			//Consulta o webservice viacep.com.br/
			$.getJSON("https://viacep.com.br/ws/" + cep + "/json/?callback=?",
					function(dados) {

						if (!("erro" in dados)) {
							$("#rua").val(dados.logradouro);
							$("#bairro").val(dados.bairro);
							$("#cidade").val(dados.localidade);
							$("#estado").val(dados.uf);
							$("#ibge").val(dados.ibge);

						} else {

							limpa_formulário_cep();
							alert("CEP não encontrado.");
						}
					});
		}
	</script>

</body>
</html>