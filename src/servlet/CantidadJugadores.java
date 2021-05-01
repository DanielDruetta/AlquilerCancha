package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.DataClienteReserva;
import entidades.Administrador;
import entidades.Cliente;
import entidades.ClienteReserva;
import entidades.Establecimiento;
import entidades.Reserva;

@WebServlet("/CantidadJugadores")
public class CantidadJugadores extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CantidadJugadores() {
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
		String act = request.getParameter("act");

		if (act == null) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

		else if (act.equals("Aceptar")) {
			String cant = request.getParameter("cantidad");
			
			if (cant.equals("-")) {
				request.setAttribute("mensajeError", "Ingrese una cantidad de jugadores valida");
				request.getRequestDispatcher("ingresarCantJugadores.jsp").forward(request, response);
			}
			int cantidad = Integer.parseInt(cant);

			if (cantidad != 0) {
				Reserva r = (Reserva) session.getAttribute("reserva");
				Cliente c = (Cliente) session.getAttribute("usuario");

				ClienteReserva cr = new ClienteReserva(c.getDni(), r.getNumero_reserva(), cantidad);

				DataClienteReserva dcr = new DataClienteReserva();

				try {
					dcr.add(cr);
					request.setAttribute("mensajeOk", "Jugadores registrados exitosamente");
					request.getRequestDispatcher("index.jsp").forward(request, response);		
				} catch (SQLException e) {
					request.setAttribute("mensajeError", "Error interno del servidor");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
				
			}
		}
	}
}
