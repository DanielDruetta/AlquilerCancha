package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.DataReserva;
import entidades.Administrador;
import entidades.Cliente;
import entidades.Establecimiento;
import entidades.Reserva;

@WebServlet({ "/IngresarJugadores", "/ingresar_jugadores" })
public class IngresarJugadores extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public IngresarJugadores() {
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
		doGet(request, response);

		String reserva = request.getParameter("reserva");
		String cantidad = request.getParameter("cantidad");
		int numero_reserva = Integer.parseInt(reserva);
		int cantidad_jugadores = Integer.parseInt(cantidad);
		
		try {
			DataReserva dr = new DataReserva();
			Reserva r = new Reserva(numero_reserva, cantidad_jugadores);

			dr.modificar_cantidad_jugadores(r);
		} catch (Exception e) {
			request.setAttribute("mensajeError", "Error interno del servidor");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		
	}
}
