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

@WebServlet("/BajaEstablecimiento")
public class BajaEstablecimiento extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BajaEstablecimiento() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String act = request.getParameter("act");
		if (act == null) {
			System.out.println("No se presiono nada");
		} else if (act.equals("Aceptar")) {
			String establecimiento = request.getParameter("inputEstablecimiento");
			System.out.println(establecimiento);

			DataEstablecimiento de = new DataEstablecimiento();
			try {
				Establecimiento e = de.buscarEst(establecimiento);
				System.out.println("ENCONTRO");
				request.getSession().setAttribute("establecim_elimiar", e);
				request.getRequestDispatcher("bajaEstablecimientoConfirmar.jsp").forward(request, response);
				
			} catch (SQLException e) {
				request.setAttribute("mensajeError", e.getMessage());
				request.getRequestDispatcher("modificacionEstablecimiento.jsp").forward(request, response);
			}
			

		}

	}
}
