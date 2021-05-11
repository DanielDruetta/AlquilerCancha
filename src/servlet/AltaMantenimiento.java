package servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.DataMantenimiento;
import data.DataReserva;
import entidades.Administrador;
import entidades.Cliente;
import entidades.Establecimiento;
import entidades.Mantenimiento;
import entidades.Reserva;

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
		
		DataReserva dr = new DataReserva();
		
		Establecimiento e = (Establecimiento) session.getAttribute("establec");
		DataMantenimiento dm = new DataMantenimiento();
		
		ArrayList<Reserva> reservas_rango_fechas = dr.getReservasRango(e.getNombre(),numeroCancha,fechaIniMan,fechaFinMan);
		Mantenimiento man = new Mantenimiento(e.getNombre(),numeroCancha,fechaIniMan,fechaFinMan,descripcion,observaciones);
		request.getSession().setAttribute("fecha_inicio_mantenimiento", fechaIniMan);
		request.getSession().setAttribute("fecha_fin_mantenimiento", fechaFinMan);
		dm.add(man);
		
		if (reservas_rango_fechas.size() > 0) {
			request.getSession().setAttribute("reservas_dentro_rango", reservas_rango_fechas);
			request.getRequestDispatcher("informarMantenimiento.jsp").forward(request, response);
			doGet(request, response);
		} 
		request.getRequestDispatcher("index.jsp").forward(request, response);
		doGet(request, response);
	}

}
