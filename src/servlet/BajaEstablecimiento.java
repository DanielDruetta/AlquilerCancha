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
import entidades.Administrador;
import entidades.Cliente;
import entidades.Establecimiento;

@WebServlet("/BajaEstablecimiento")
public class BajaEstablecimiento extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BajaEstablecimiento() {
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
		String act = request.getParameter("act");
		if (act == null) {
			System.out.println("No se presiono nada");
			request.getRequestDispatcher("index.jsp").forward(request, response);
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
				request.setAttribute("mensajeError", "Error interno del servidor");
				request.getRequestDispatcher("modificacionEstablecimiento.jsp").forward(request, response);
			}

		}

	}
}
