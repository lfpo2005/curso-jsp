package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.BeanUsuario;
import connection.SingleConnection;

public class DaoUsuario {

	private Connection connection; // importa o java.sql.Connection

	public DaoUsuario() { // chama o construtor default da classe
		connection = SingleConnection.getConnection();
	}

	// metodo salva os dados

	public void salvar(BeanUsuario usuario) {
		try {

			String sql = "insert into usuario(login, senha, nome, fone, email, cep, rua, bairro, cidade, estado, ibge) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, usuario.getLogin());
			insert.setString(2, usuario.getSenha());
			insert.setString(3, usuario.getNome());
			insert.setLong(4, usuario.getFone());
			insert.setString(5, usuario.getEmail());
			insert.setString(6, usuario.getCep());
			insert.setString(7, usuario.getRua());
			insert.setString(8, usuario.getBairro());
			insert.setString(9, usuario.getCidade());
			insert.setString(10, usuario.getEstado());
			insert.setString(11, usuario.getIbge());

			insert.execute(); // faz o insert no db

			connection.commit(); // se estiver tudo ok faz o commit e salva no db

		} catch (Exception e) {
			e.printStackTrace(); // imprime o erro no console
			try {

				connection.rollback(); // anula todas as altera��es que seriam realizadas em
				// caso de algum erro.

			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	// Metodo para listar cadastros no banco de dados na tabela usuario
	public java.util.List<BeanUsuario> listar() throws Exception {

		java.util.List<BeanUsuario> listar = new ArrayList<BeanUsuario>(); // criando a lista

		String sql = "select * from usuario";

		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();

		while (resultSet.next()) {

			BeanUsuario daoUsuario = new BeanUsuario();
			daoUsuario.setId(resultSet.getLong("id"));
			daoUsuario.setLogin(resultSet.getString("login"));
			daoUsuario.setSenha(resultSet.getString("senha"));
			daoUsuario.setNome(resultSet.getString("nome"));
			daoUsuario.setFone(resultSet.getLong("fone"));
			daoUsuario.setEmail(resultSet.getString("email"));
			daoUsuario.setCep(resultSet.getString("cep"));
			daoUsuario.setRua(resultSet.getString("rua"));
			daoUsuario.setBairro(resultSet.getString("bairro"));
			daoUsuario.setCidade(resultSet.getString("cidade"));
			daoUsuario.setEstado(resultSet.getString("estado"));
			daoUsuario.setIbge(resultSet.getString("ibge"));

			listar.add(daoUsuario);
		}

		return listar;
	}

	// Metodo para deletar cadastros de usuario
	public void delete(String id) {

		try {
			String sql = "delete from usuario where id = '" + id + "'";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.execute();
			connection.commit();

		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	// Metodo para consutar usuario no banco de dados

	public BeanUsuario consutar(String id) throws Exception {

		String sql = "select * from usuario where id= '" + id + "'";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {

			BeanUsuario daoUsuario = new BeanUsuario();

			daoUsuario.setId(resultSet.getLong("id"));
			daoUsuario.setLogin(resultSet.getString("login"));
			daoUsuario.setSenha(resultSet.getString("senha"));
			daoUsuario.setNome(resultSet.getString("nome"));
			daoUsuario.setFone(resultSet.getLong("fone"));
			daoUsuario.setEmail(resultSet.getString("email"));
			daoUsuario.setCep(resultSet.getString("cep"));
			daoUsuario.setRua(resultSet.getString("rua"));
			daoUsuario.setBairro(resultSet.getString("bairro"));
			daoUsuario.setCidade(resultSet.getString("cidade"));
			daoUsuario.setEstado(resultSet.getString("estado"));
			daoUsuario.setIbge(resultSet.getString("ibge"));

			return daoUsuario;

		}

		return null;
	}

	public boolean validarLogin(String login) throws Exception {

		String sql = "select count(1) as qtd from usuario where login= '" + login + "'";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {

			return resultSet.getInt("qtd") <= 0; // return true

		}

		return false;
	}

	public void atualizar(BeanUsuario usuario) {

		try {
			String sql = "update usuario set login = ?, senha = ?, nome = ?, fone = ?, email = ?, cep = ?, rua = ?, bairro = ?, cidade = ?, estado = ?, ibge = ? where id = "
					+ usuario.getId();

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, usuario.getLogin());
			preparedStatement.setString(2, usuario.getSenha());
			preparedStatement.setString(3, usuario.getNome());
			preparedStatement.setLong(4, usuario.getFone());
			preparedStatement.setString(5, usuario.getEmail());
			preparedStatement.setString(6, usuario.getCep());
			preparedStatement.setString(7, usuario.getRua());
			preparedStatement.setString(8, usuario.getBairro());
			preparedStatement.setString(9, usuario.getCidade());
			preparedStatement.setString(10, usuario.getEstado());
			preparedStatement.setString(11, usuario.getIbge());

			preparedStatement.executeUpdate();
			connection.commit();

		} catch (Exception e) {
			e.printStackTrace();

			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	public boolean validarEmail(String email) throws Exception {
		String sql = "select count(1) as qtd from usuario where email='" + email + "'";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {

			return resultSet.getInt("qtd") <= 0;/* Return true */
		}
		return false;
	}
}