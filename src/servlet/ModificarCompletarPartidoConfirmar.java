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
import data.DataReserva;
import entidades.Administrador;
import entidades.Cliente;
import entidades.ClienteReserva;
import entidades.Establecimiento;
import entidades.Reserva;

@WebServlet({ "/modificar_completar_partido", "/modificar_reserva_completar_partido" })
public class ModificarCompletarPartidoConfirmar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ModificarCompletarPartidoConfirmar() {
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
		HttpSession session = request.getSession();
		Cliente c = (Cliente) session.getAttribute("usuario");

		String numeroreserva = request.getParameter("nrores");

		int reserva = Integer.parseInt(numeroreserva);
		DataClienteReserva dcr = new DataClienteReserva();
		ClienteReserva cr = dcr.search(reserva, c.getDni());
		DataReserva dr = new DataReserva();
		Reserva r = dr.search(cr.getNumero_reserva());

		String cant_jugadores_nueva = request.getParameter("cantidad");

		int cant_jugadores_nueva_int = Integer.parseInt(cant_jugadores_nueva);
		int cant_jugadores_aportados_int = cr.getCantidad_jugadores();
		
		int cant_jugadores_vieja_int = r.getLugares_disponibles();
		
		int nueva_cantidad_jugadores_necesitados = cant_jugadores_aportados_int + cant_jugadores_vieja_int
				- cant_jugadores_nueva_int;
		
		r.setLugares_disponibles(nueva_cantidad_jugadores_necesitados);

		try {
			dr.modificar_cantidad_jugadores(r);
			cr.setCantidad_jugadores(cant_jugadores_nueva_int);
			dcr.modificar_jugadores_aportados(cr);
			
			request.setAttribute("mensajeOk", "Reserva modificada exitosamente");
			request.getRequestDispatcher("index.jsp").forward(request, response);	
		} catch (SQLException e) {
			request.setAttribute("mensajeError", "Error interno del servidor");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		

	}

}
