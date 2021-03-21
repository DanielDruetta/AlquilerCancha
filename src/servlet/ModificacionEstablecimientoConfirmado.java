package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.DataEstablecimiento;
import entidades.Establecimiento;

@WebServlet("/ModificacionEstablecimientoConfirmado")
public class ModificacionEstablecimientoConfirmado extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ModificacionEstablecimientoConfirmado() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String actio = request.getParameter("act");
		if (actio == null) {
			System.out.println("No se presiono nada");
		} else if (actio.equals("Modificar")) {
			System.out.println("Servlet modificacion establecimiento confirmado");
			DataEstablecimiento de = new DataEstablecimiento();

			String nombre = request.getParameter("nombre");
			String direccion = request.getParameter("direccion");
			String usuario = request.getParameter("usuario");
			String contraseña = request.getParameter("contraseña");

			String hora_inicio = request.getParameter("inputHoraInicio");
			String hora_fin = request.getParameter("inputHoraFin");
			String url_mapa = request.getParameter("urlMapa");
			int horainicio = Integer.parseInt(hora_inicio);
			int horafin = Integer.parseInt(hora_fin);

			System.out.println(horainicio);
			System.out.println(horafin);

			Establecimiento estnuevo = new Establecimiento(nombre, direccion, horainicio, horafin, usuario, contraseña, url_mapa);
			System.out.println("Establecimiento nuevo " + estnuevo.toString());

			Establecimiento estviejo = (Establecimiento) session.getAttribute("establec");
			System.out.println("Establecimiento viejo " + estviejo.toString());

			de.modificarEstablecimiento(estnuevo, estviejo);
			request.getSession().setAttribute("establec", estnuevo);
			request.getRequestDispatcher("index.jsp").forward(request, response);

			doGet(request, response);
		}

	}
}