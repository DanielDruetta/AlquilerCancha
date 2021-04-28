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
import entidades.Administrador;
import entidades.Cliente;
import entidades.Establecimiento;
import entidades.Mantenimiento;

@WebServlet({ "/AltaMantenimiento", "/altamantenimiento" })
public class AltaMantenimiento extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AltaMantenimiento() {
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
		
		HttpSession session = request.getSession();

		String cancha = request.getParameter("inputCancha");
		String fechaInicio = request.getParameter("inputFechaInicio");
		String fechaFin = request.getParameter("inputFechaFin");
		
		String descripcion = request.getParameter("inputDescripcion");
		String observaciones = request.getParameter("inputObservaciones");
		
		Date fechaFinMan = Date.valueOf(fechaFin);
		Date fechaIniMan = Date.valueOf(fechaInicio);
		
		int numeroCancha = Integer.parseInt(cancha);

		System.out.println(cancha);
		System.out.println(fechaIniMan);
		System.out.println(fechaFinMan);
		
		System.out.println(descripcion);
		System.out.println(observaciones);
		
		Establecimiento e = (Establecimiento) session.getAttribute("establec");
		DataMantenimiento dm = new DataMantenimiento();
		
		Mantenimiento man = new Mantenimiento(e.getNombre(),numeroCancha,fechaIniMan,fechaFinMan,descripcion,observaciones);
		
		dm.add(man);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);

		doGet(request, response);
	}

}
