package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import data.DataEstablecimiento;
import entidades.Establecimiento;

@WebServlet("/AltaEstablecimiento")
public class AltaEstablecimiento extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AltaEstablecimiento() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String act = request.getParameter("act");
		if (act == null) {
			System.out.println("No se presiono nada");
		} else if (act.equals("Aceptar")) {
			System.out.println("Se presiono aceptar");

			DataEstablecimiento de = new DataEstablecimiento();

			String nombre = request.getParameter("nombre");
			String direccion = request.getParameter("direccion");
			String usuario = request.getParameter("usuario");
			String contraseña = request.getParameter("contraseña");

			String hora_inicio = request.getParameter("inputHoraInicio");

			String hora_fin = request.getParameter("inputHoraFin");
			String url_mapa = request.getParameter("urlMapa");
			System.out.println("El url del mapa es:" + url_mapa);

			int horainicio = Integer.parseInt(hora_inicio);
			int horafin = Integer.parseInt(hora_fin);

			System.out.println(horainicio);
			System.out.println(horafin);

			Establecimiento es = new Establecimiento(nombre, direccion, horainicio, horafin, usuario, contraseña, url_mapa);
			System.out.println(es.toString());
			de.add(es);
			request.getRequestDispatcher("index.jsp").forward(request, response);

		}

		doGet(request, response);
	}

}
