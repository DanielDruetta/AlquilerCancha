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

@WebServlet("/CancelarReserva")
public class CancelarReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CancelarReserva() {
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

		String seleccion = request.getParameter("seleccion");

		try {
			DataReserva dr = new DataReserva();
			dr.eliminarReserva(seleccion);

			request.setAttribute("mensajeOk", "Reserva cancelada exitosamente");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (SQLException e) {
			request.setAttribute("mensajeError", "Error interno del servidor");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
