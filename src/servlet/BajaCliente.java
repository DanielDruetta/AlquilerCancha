package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.DataCliente;
import entidades.Cliente;

/**
 * Servlet implementation class BajaCliente
 */
@WebServlet("/BajaCliente")
public class BajaCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BajaCliente() {
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
		String act = request.getParameter("act");
		if (act == null) {
			System.out.println("No se presiono nada");
		} else if (act.equals("Eliminar usuario")) {
			System.out.println("Se presiono eliminar");
			DataCliente dc = new DataCliente();

			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");

			Cliente cli = new Cliente(nombre, apellido);
			Cliente c = dc.search(cli);
			System.out.println(c.toString());
			request.getSession().setAttribute("usuario", c);
			request.getRequestDispatcher("bajaClienteConfirmar.jsp").forward(request, response);

		}

		doGet(request, response);

	}
}
