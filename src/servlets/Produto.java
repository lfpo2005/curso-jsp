package servlets;

import beans.BeanProduto;
import dao.DaoProduto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Produto")
public class Produto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DaoProduto daoProduto = new DaoProduto();
       
    public Produto() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try {

			String acao = request.getParameter("acao");
			String pdt = request.getParameter("pdt");

			if (acao.equalsIgnoreCase("delete")) {

				daoProduto.delete(pdt);
				RequestDispatcher view = request.getRequestDispatcher("cadastroProduto.jsp");
				request.setAttribute("produtos", daoProduto.listar());
				view.forward(request, response);
			} else if (acao.equalsIgnoreCase("editar")) {

				BeanUsuario beanCursoJsp = daoProduto.consutar(pdt);
				RequestDispatcher view = request.getRequestDispatcher("cadastroProduto.jsp");
				request.setAttribute("pdt", beanCursoJsp);
				view.forward(request, response);

			} else if (acao.equalsIgnoreCase("listartodos")) {

				RequestDispatcher view = request.getRequestDispatcher("cadastroProduto.jsp");
				request.setAttribute("produtos", daoProduto.listar());
				view.forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String quantidade = request.getParameter("quantidade");
		String valor = request.getParameter("valor");
		
		BeanProduto produto =  new BeanProduto();
		produto.setId(!id.isEmpty() ? Long.parseLong(id) : null);
		produto.setNome(nome);
		produto.setQuantidade(Double.parseDouble(quantidade));
		String valorParse = valor.replace("R$", "").replaceAll("\\.", "").replaceAll("\\,", ".");
		produto.setValor(Double.parseDouble(valorParse));
		
		
		
	}

}
