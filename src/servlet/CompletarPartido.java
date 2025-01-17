package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.DataReserva;
import entidades.Reserva;
import entidades.Administrador;
import entidades.Cliente;
import entidades.Establecimiento;

@WebServlet("/CompletarPartido")
public class CompletarPartido extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CompletarPartido() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Establecimiento e = (Establecimiento) session.getAttribute("establec");
		Cliente c = (Cliente) session.getAttribute("usuario");
		Administrador a = (Administrador) session.getAttribute("administrador");

		if ((c == null) || (e == null) || (a == null)) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String numeroreserva = request.getParameter("nroreserva");

		int reserva = Integer.parseInt(numeroreserva);

		if (numeroreserva != null) {

			DataReserva dr = new DataReserva();

			Reserva r = dr.search(reserva);

			request.getSession().setAttribute("reserva", r);

			request.getRequestDispatcher("ingresarCantJugadores.jsp").forward(request, response);
		}
	}
}
