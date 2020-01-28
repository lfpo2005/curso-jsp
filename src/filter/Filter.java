package filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import connection.SingleConnection;

@WebFilter(urlPatterns = {"/*"}) //Mapeamento do WebFilter com urlPatterns - Toda requisi��o e resposta ir� passar pelo Filter. 
public class Filter implements javax.servlet.Filter {

	private static Connection connection; //Ser� atribuido os valores no m�todo init.

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) //Esse m�todo filtra o clique de um bot�o que vem da tela (front-end).
			throws IOException, ServletException {

		try {

			chain.doFilter(request, response);
			connection.commit(); // Se ocorreu tudo bem o commit ser� realizado

		} catch (Exception e) {

			try {
				e.printStackTrace();//Mostra no console a pilha de exce��es 
				connection.rollback(); // Sen�o as altera��es ser�o descartadas

			} catch (SQLException e1) {
				
				e1.printStackTrace();

			}

		}

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException { // Este m�todo init � sempre invocado
		
		connection = SingleConnection.getConnection();// Para o filtro receber a conex�o que foi iniciada
		
	}
	
}
