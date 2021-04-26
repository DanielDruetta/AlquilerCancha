package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.DataReserva;
import entidades.Reserva;
import entidades.Cliente;

@WebServlet("/CompletarPartido")
public class CompletarPartido extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CompletarPartido() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String act = request.getParameter("act");
		if (act == null) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Cliente c = (Cliente) session.getAttribute("usuario");
		if (c == null) {
			request.getRequestDispatcher("iniciarSesion.jsp").forward(request, response);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
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
