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
 * Servlet implementation class CompletarPartido
 */
@WebServlet("/CompletarPartido")
public class CompletarPartido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompletarPartido() {
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

		String numeroreserva = request.getParameter("nroreserva");
		
		int reserva = Integer.parseInt(numeroreserva);
		
		if (numeroreserva != null) {
			
			DataReserva dr = new DataReserva();
			
			Reserva r = dr.search(reserva);
			
			request.getSession().setAttribute("reserva", r);
			
			request.getRequestDispatcher("ingresarCantJugadores.jsp").forward(request, response);
		}
		
		
	
		
		
	}

}
