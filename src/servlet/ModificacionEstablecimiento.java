package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.DataEstablecimiento;
import entidades.Establecimiento;

/**
 * Servlet implementation class BajaCliente
 */

@WebServlet("/ModificacionEstablecimiento")
public class ModificacionEstablecimiento extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModificacionEstablecimiento() {
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
		String act = request.getParameter("act");
		if (act == null) {
			System.out.println("No se presiono nada");
		} else if (act.equals("Aceptar")) {
			System.out.println("Servlet modificacion establecimiento");
			DataEstablecimiento de = new DataEstablecimiento();

			String establecimiento = request.getParameter("inputEstablecimiento");
			System.out.println(establecimiento);

			Establecimiento e = de.buscarEst(establecimiento);

			request.getSession().setAttribute("establec", e);
			request.getRequestDispatcher("modificacionEstablecimientoConfirmar.jsp").forward(request, response);

		}

		doGet(request, response);

	}
}