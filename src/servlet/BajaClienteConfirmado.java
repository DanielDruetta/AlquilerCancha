package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.DataCliente;
import entidades.Cliente;

/**
 * Servlet implementation class BajaClienteConfirmado
 */
@WebServlet("/BajaClienteConfirmado")
public class BajaClienteConfirmado extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BajaClienteConfirmado() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String actio = request.getParameter("action");
		if (actio == null) {
			System.out.println("No se presiono nadasdfsdf");
		} else if (actio.equals("Eliminar")) {
			System.out.println("Se presiono eliminarrrrrr");
			Cliente cli = (Cliente) session.getAttribute("usuario");
			DataCliente dc = new DataCliente();
			System.out.println(cli.toString());
			dc.delete(cli);
			doGet(request, response);
		}

	}
}
