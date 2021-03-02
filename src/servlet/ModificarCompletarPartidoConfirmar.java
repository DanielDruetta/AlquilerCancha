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


@WebServlet({"/modificar_completar_partido", "/modificar_reserva_completar_partido"})
public class ModificarCompletarPartidoConfirmar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ModificarCompletarPartidoConfirmar() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		HttpSession session = request.getSession();
		Cliente c = (Cliente) session.getAttribute("usuario");
		System.out.println(c);
		
		String numeroreserva = request.getParameter("nrores");
		
		System.out.println(numeroreserva);
		int reserva = Integer.parseInt(numeroreserva);
		System.out.println(reserva);
		DataClienteReserva dcr = new DataClienteReserva();
		ClienteReserva cr = dcr.search(reserva,c.getDni());
		System.out.println(cr);
		DataReserva dr = new DataReserva();
		Reserva r = dr.search(cr.getNumero_reserva());
		System.out.println(r);
		
		String cant_jugadores_nueva = request.getParameter("cantidad");
	
		
		System.out.println("La cantidad de jugadores nuevas a aportar es: "+cant_jugadores_nueva);
		int cant_jugadores_nueva_int = Integer.parseInt(cant_jugadores_nueva);
		int cant_jugadores_aportados_int = cr.getCantidad_jugadores();
		System.out.println("La cantidad de jugadores que habia aportado antes: "+cant_jugadores_aportados_int);
		int cant_jugadores_vieja_int = r.getLugares_disponibles();
		System.out.println("La cantidad jugadores actuales que esta necesitando la reserva: "+cant_jugadores_vieja_int);
		int nueva_cantidad_jugadores_necesitados = cant_jugadores_aportados_int + cant_jugadores_vieja_int - cant_jugadores_nueva_int;
		System.out.println("La nueva cantidad de jugadores necesitados de la reserva es: " + nueva_cantidad_jugadores_necesitados);
		r.setLugares_disponibles(nueva_cantidad_jugadores_necesitados);
		
		dr.modificar_cantidad_jugadores(r);
		cr.setCantidad_jugadores(cant_jugadores_nueva_int);
		dcr.modificar_jugadores_aportados(cr);
		
		
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

}
