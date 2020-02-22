package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/salvarTelefones")
public class Telefones extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Telefones() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String user = request.getParameter("user");
		request.getSession().setAttribute("user", user);
		
		
		RequestDispatcher view = request
				.getRequestDispatcher("/telefones.jsp");
		//request.setAttribute("telefones", daoUsuario.listar());
		request.setAttribute("msg", "Salvo com Sucesso!");
		request.setAttribute("userEscolhido", user);
		view.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
