package servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.DataMantenimiento;
import entidades.Establecimiento;
import entidades.Mantenimiento;

@WebServlet({ "/BajaMantenimiento", "/bajamantenimiento" })
public class BajaMantenimiento extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BajaMantenimiento() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		String seleccion = request.getParameter("seleccion");

		String[] datos = seleccion.split("r");
		int numero_cancha = Integer.parseInt(datos[0]);
		Date fecha_desde = Date.valueOf(datos[1]);

		Establecimiento e = (Establecimiento) session.getAttribute("establec");
		String nombre = e.getNombre();

		// System.out.println(seleccion);
		// System.out.println(nombre);
		// System.out.println(numero_cancha);
		// System.out.println(fecha_desde);

		DataMantenimiento dm = new DataMantenimiento();
		Mantenimiento man = new Mantenimiento(nombre, numero_cancha, fecha_desde);
		dm.delete(man);

		request.getRequestDispatcher("index.jsp").forward(request, response);

		doGet(request, response);
	}

}
