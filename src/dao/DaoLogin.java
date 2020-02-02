package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.SingleConnection;

public class DaoLogin {

	private Connection connection;

	
	public DaoLogin() {

	
		connection = SingleConnection.getConnection();

	}	
	public boolean validarLogin(String login, String senha) throws SQLException {
		System.out.println("Entrando no método validarLogin");
		
		String sql = "select * from usuario where login = '" +login+ "' and senha = '" +senha+ "'";		//Utilizado ' pois se trata de uma String
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		
		System.out.println("A conexão foi um sucesso!");
		
		//Se houver um resultSet é porque ele encontrou o usuário
		if (resultSet.next()) {
			
			System.out.println("Foi encontrado um usuário cadastrado com esse user e senha");
			
			return true;			//Possui usuário
			
		} else {
			
			System.out.println("Não foi encontrado um usuário cadastrado com esse user e senha");
			
			return false;         //Não possui usuário
		}
	}
}