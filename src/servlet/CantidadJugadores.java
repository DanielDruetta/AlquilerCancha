package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.DataClienteReserva;
import data.DataReserva;
import entidades.Cliente;
import entidades.ClienteReserva;
import entidades.Reserva;

/**
 * Servlet implementation class CantidadJugadores
 */
@WebServlet("/CantidadJugadores")
public class CantidadJugadores extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CantidadJugadores() {
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();

		String act = request.getParameter("act");

		if (act == null) {
			System.out.println("No se presiono nada");
		}

		else if (act.equals("Aceptar")) {

			String cant = request.getParameter("cantidad");
			
			int cantidad = Integer.parseInt(cant);
			
			if (cantidad != 0) {
				
				DataReserva dr = new DataReserva();
				
				Reserva r = (Reserva) session.getAttribute("reserva");
				
				Cliente c = (Cliente) session.getAttribute("usuario");
				
				System.out.println(c.toString());
				System.out.println(r.toString());
				System.out.println(cantidad);
				
				ClienteReserva cr = new ClienteReserva(c.getDni(),r.getNumero_reserva(),cantidad);
				
				DataClienteReserva dcr = new DataClienteReserva();
				
				dcr.add(cr);
				
				System.out.println("adsassadsaasddas");
				
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			
			
		}

	}

}
