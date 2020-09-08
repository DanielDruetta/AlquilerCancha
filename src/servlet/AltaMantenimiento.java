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

@WebServlet({ "/AltaMantenimiento", "/altamantenimiento" })
public class AltaMantenimiento extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AltaMantenimiento() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
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
