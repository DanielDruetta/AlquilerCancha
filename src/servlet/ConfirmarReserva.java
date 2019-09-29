package servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.DataReserva;
import entidades.Cliente;
import entidades.Establecimiento;
import entidades.Reserva;

/**
 * Servlet implementation class ConfirmarReserva
 */
@WebServlet("/ConfirmarReserva")
public class ConfirmarReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmarReserva() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		String seleccion = request.getParameter("seleccion");
		System.out.println(seleccion);
		
			
			
			String[] datos = seleccion.split("r");
			int numero_cancha= Integer.parseInt(datos[0]);
			int hora_inicio= Integer.parseInt(datos[1]);
			
			Establecimiento es=(Establecimiento) session.getAttribute("establecimiento");
			Cliente cli=(Cliente) session.getAttribute("usuario");
			Date fecha=(Date) session.getAttribute("fecha");
			
			
			
			DataReserva dr= new DataReserva();
			System.out.println(dr.ultimoid());
			System.out.println(es.getNombre());
			System.out.println(cli.getDni());
			
			Reserva r= new Reserva((dr.ultimoid()+1),fecha,hora_inicio,es.getNombre(),numero_cancha,cli.getDni());
			
			dr.add(r);
			
			
		doGet(request, response);
	}

}
