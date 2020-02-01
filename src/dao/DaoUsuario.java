package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.BeanCursoJsp;
import connection.SingleConnection;

public class DaoUsuario {
	
	private Connection connection; // importa o java.sql.Connection
	
	public DaoUsuario() {  //chama o construtor default da classe
		connection = SingleConnection.getConnection();
	}
	
	
	// metodo salva os dados
	
	public void salvar(BeanCursoJsp usuario) { 
		try {
			
		String sql ="insert into usuario(login, senha) values (?, ?)";
		
		PreparedStatement insert = connection.prepareStatement(sql);
		insert.setString(1, usuario.getLogin());
		insert.setString(2, usuario.getSenha());
		
		insert.execute(); // faz o insert no db
		
		
		connection.commit(); // se estiver tudo ok faz o commit e salva no db
		
		} catch (Exception e) {
			e.printStackTrace(); //imprime o erro no console
			try {
				
				connection.rollback(); //anula todas as alterações que seriam realizadas em
				// caso de algum erro.
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	// Metodo para listar cadastros no banco de dados na tabela usuario
	public java.util.List<BeanCursoJsp> listar() throws Exception {
		
		java.util.List<BeanCursoJsp> listar = new ArrayList<BeanCursoJsp>(); //criando a lista
		
		String sql = "select * from usuario";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		
		while (resultSet.next()) {
			
			BeanCursoJsp beanCursoJsp = new BeanCursoJsp();
			
			beanCursoJsp.setId(resultSet.getLong("id"));
			beanCursoJsp.setLogin(resultSet.getString("login"));
			beanCursoJsp.setSenha(resultSet.getString("senha"));
			
			listar.add(beanCursoJsp);
		}
		
		return listar;
		}
		
	
		public void delete (String login) {
			
			try {
			String sql = "delete from usuario where login = '" + login + "'";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.execute();			
			connection.commit();
				
			}catch(Exception e){
				e.printStackTrace();
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		}
		}

		public BeanCursoJsp consutar(String login)  throws Exception{
			
			String sql= "select * from where login= '" + login + "'";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {		
				
				BeanCursoJsp beanCursoJsp = new BeanCursoJsp();
				
				beanCursoJsp.setId(resultSet.getLong("id"));
				beanCursoJsp.setLogin(resultSet.getString("login"));
				beanCursoJsp.setSenha(resultSet.getString("senha"));
				
				return beanCursoJsp;
				
			}
			
			return null;
		}

		public void atualizar(BeanCursoJsp usuario) {
			
			try {
			String sql = "update usuario set login = ?, senha = ? where id = " + usuario.getId();
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, usuario.getLogin());
			preparedStatement.setString(2, usuario.getSenha());
			
			preparedStatement.executeUpdate();
			
			connection.commit();
			
			}catch (Exception e) {
				e.printStackTrace();
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		}
		
	}
	
	
