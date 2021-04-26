package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.DataEstablecimiento;
import entidades.Establecimiento;

@WebServlet("/BajaEstablecimientoConfirmado")
public class BajaEstablecimientoConfirmado extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BajaEstablecimientoConfirmado() {
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
		String actio = request.getParameter("act");
		if (actio == null) {
			System.out.println("No se presiono nada");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else if (actio.equals("Eliminar")) {
			System.out.println("Se presiono eliminar");
			Establecimiento est = (Establecimiento) session.getAttribute("establecim_elimiar");
			DataEstablecimiento de = new DataEstablecimiento();

			try {
				de.delete(est);
				request.setAttribute("mensajeOk", "Establecimiento eliminado exitosamente");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} catch (SQLException e) {
				request.setAttribute("mensajeError", "Error interno del servidor");
				request.getRequestDispatcher("bajaEstablecimiento.jsp").forward(request, response);
			}

		}

	}
}