package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BeanUsuario;
import dao.DaoUsuario;

@WebServlet("/Usuario")
public class Usuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DaoUsuario daoUsuario = new DaoUsuario();

	public Usuario() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		try {

			String acao = request.getParameter("acao");
			String user = request.getParameter("user");

			if (acao.equalsIgnoreCase("delete")) {

				daoUsuario.delete(user);
				RequestDispatcher view = request.getRequestDispatcher("cadastroUsuario.jsp");
				request.setAttribute("usuarios", daoUsuario.listar());
				view.forward(request, response);
			} else if (acao.equalsIgnoreCase("editar")) {

				BeanUsuario beanCursoJsp = daoUsuario.consutar(user);
				RequestDispatcher view = request.getRequestDispatcher("cadastroUsuario.jsp");
				request.setAttribute("user", beanCursoJsp);
				view.forward(request, response);

			} else if (acao.equalsIgnoreCase("listartodos")) {

				RequestDispatcher view = request.getRequestDispatcher("cadastroUsuario.jsp");
				request.setAttribute("usuarios", daoUsuario.listar());
				view.forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String nome = request.getParameter("nome");
		String fone = request.getParameter("fone");
		String email = request.getParameter("email");

		BeanUsuario usuario = new BeanUsuario();
		usuario.setId(!id.isEmpty() ? Long.parseLong(id) : null);
		usuario.setLogin(login);
		usuario.setSenha(senha);
		usuario.setNome(nome);
		usuario.setFone(Long.parseLong(fone));
		usuario.setEmail(email);

		try {

			String msg = null;
			boolean podeInserir = true;

			if (id == null || id.isEmpty()
					&& !daoUsuario.validarLogin(login)) {//QUANDO DOR USUÁRIO NOVO
				msg = "Usuário já existe com o mesmo login!";
				podeInserir = false;

			} else if (id == null || id.isEmpty()
					&& !daoUsuario.validarEmail(email)) {// QUANDO FOR USUÁRIO NOVO
				msg = " A senha já existe para outro usuário!";
				podeInserir = false;
			}

			if (msg != null) {
				request.setAttribute("msg", msg);
			}

			if (id == null || id.isEmpty()
					&& daoUsuario.validarLogin(login) && podeInserir) {

				daoUsuario.salvar(usuario);

			} else if (id != null && !id.isEmpty() && podeInserir) {
				daoUsuario.atualizar(usuario);
			}
			
			if (!podeInserir) {
				request.setAttribute("user", usuario);//mantem os dados do usuario no formulario 
													  //caso o login e  senha  já estiverem cadastados por outro usuário
			}

			RequestDispatcher view = request
					.getRequestDispatcher("/cadastroUsuario.jsp");
			request.setAttribute("usuarios", daoUsuario.listar());
			view.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
