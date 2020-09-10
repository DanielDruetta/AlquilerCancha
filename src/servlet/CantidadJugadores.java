package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.DataClienteReserva;
import entidades.Cliente;
import entidades.ClienteReserva;
import entidades.Reserva;

@WebServlet("/CantidadJugadores")
public class CantidadJugadores extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CantidadJugadores() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
