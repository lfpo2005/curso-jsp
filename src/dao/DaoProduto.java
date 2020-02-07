package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.SingleConnection;

import beans.BeanProduto;

public class DaoProduto {

	private Connection connection;
	
	public DaoProduto() {
		connection = SingleConnection.getConnection();		
	}
	  void salvar(BeanProduto produto) {
		
		try {
			
		String sql = "insert into produto(nome, quantidade, valor) values(?, ?, ?)";
		
		PreparedStatement insert = connection.prepareStatement(sql);
		insert.setString(1, produto.getNome());
		insert.setDouble(2, produto.getQuantidade());
		insert.setDouble(3, produto.getQuantidade());
		 
		insert.execute();
		
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
