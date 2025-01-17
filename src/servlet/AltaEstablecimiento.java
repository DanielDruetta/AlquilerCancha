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

@WebServlet("/AltaEstablecimiento")
public class AltaEstablecimiento extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AltaEstablecimiento() {
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
			System.out.println("Se presiono aceptar");

			DataEstablecimiento de = new DataEstablecimiento();

			String nombre = request.getParameter("nombre");
			String direccion = request.getParameter("direccion");
			String usuario = request.getParameter("usuario");
			String contraseņa = request.getParameter("contraseņa");
			String hora_inicio = request.getParameter("inputHoraInicio");
			String hora_fin = request.getParameter("inputHoraFin");
			String url_mapa = request.getParameter("urlMapa");
			System.out.println("El url del mapa es:" + url_mapa);

			int horainicio = Integer.parseInt(hora_inicio);
			int horafin = Integer.parseInt(hora_fin);

			if ((usuario == "") || (contraseņa == "") || (nombre == "") || (direccion == "") || (hora_inicio == "")
					|| (hora_fin == "") || (url_mapa == "")) {
				request.getRequestDispatcher("altaEstablecimiento.jsp").forward(request, response);
			} else {

				try {
					Establecimiento es = new Establecimiento(nombre, direccion, horainicio, horafin, usuario,
							contraseņa, url_mapa);
					System.out.println(es.toString());
					de.add(es);
					request.setAttribute("mensajeOk", "Establecimiento registrado exitosamente");
					request.getRequestDispatcher("index.jsp").forward(request, response);

				} catch (SQLException e) {
					request.setAttribute("mensajeError", "Error interno del servidor");
					request.getRequestDispatcher("altaEstablecimiento.jsp").forward(request, response);
				}
			}
		}
	}
}
