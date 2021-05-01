package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.DataClienteReserva;
import data.DataReserva;
import entidades.Administrador;
import entidades.Cliente;
import entidades.ClienteReserva;
import entidades.Establecimiento;
import entidades.Reserva;

@WebServlet("/ModificarCompletarPartido")
public class ModificarCompletarPartido extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ModificarCompletarPartido() {
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

		HttpSession session = request.getSession();

		Cliente c = (Cliente) session.getAttribute("usuario");
		if (c == null) {
			request.getRequestDispatcher("iniciarSesion.jsp").forward(request, response);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		String numeroreserva = request.getParameter("nrores");

		int reserva = Integer.parseInt(numeroreserva);

		if (numeroreserva != null) {

			DataClienteReserva dcr = new DataClienteReserva();
			ClienteReserva cr = dcr.search(reserva, c.getDni());

			DataReserva dr = new DataReserva();
			Reserva r = dr.search(cr.getNumero_reserva());

			request.getSession().setAttribute("reservamodificar", r);
			request.getSession().setAttribute("clientereserva", cr);

			request.getRequestDispatcher("modificarCompletarPartido.jsp").forward(request, response);
		}
	}

}
