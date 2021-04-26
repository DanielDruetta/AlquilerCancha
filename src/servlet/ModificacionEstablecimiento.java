package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.DataEstablecimiento;
import entidades.Establecimiento;

@WebServlet("/ModificacionEstablecimiento")
public class ModificacionEstablecimiento extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ModificacionEstablecimiento() {
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
		String act = request.getParameter("act");
		if (act == null) {
			System.out.println("No se presiono nada");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else if (act.equals("Aceptar")) {
			System.out.println("Servlet modificacion establecimiento");
			DataEstablecimiento de = new DataEstablecimiento();

			String establecimiento = request.getParameter("inputEstablecimiento");
			System.out.println(establecimiento);

			try {
				Establecimiento e = de.buscarEst(establecimiento);
				request.getSession().setAttribute("establec_modificar", e); // Esto lo hace cuando modifica el admin
				request.getRequestDispatcher("modificacionEstablecimientoConfirmar.jsp").forward(request, response);

			} catch (SQLException e) {
				request.setAttribute("mensajeError", "Error interno del servidor");
				request.getRequestDispatcher("modificacionEstablecimiento.jsp").forward(request, response);
			}
		}
		doGet(request, response);
	}
}