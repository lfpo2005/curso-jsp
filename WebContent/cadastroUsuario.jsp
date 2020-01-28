<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Usuário</title>
</head>
<body>

  <h2>Cadastro de Usuário</h2>
    <br>

    <form action="salvarUsuario" method="post">
        <table>
            <tr>
                <td>Login:</td>
                <td><input type="text" id="login" name="login"> </td>
            </tr>
            <tr>
                <td>Senha:</td>
                <td><input type="password" id="senha" name="senha"> </td>
            </tr>
        </table>
        <input type="submit" value="salvar">
    </form>

</body>
</html>