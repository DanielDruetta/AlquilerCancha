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

@WebServlet("/ConfirmarReserva")
public class ConfirmarReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ConfirmarReserva() {
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
		System.out.println(seleccion);

		String[] datos = seleccion.split("r");
		int numero_cancha = Integer.parseInt(datos[0]);
		int hora_inicio = Integer.parseInt(datos[1]);

		Establecimiento es = (Establecimiento) session.getAttribute("establecimiento");
		Cliente cli = (Cliente) session.getAttribute("usuario");
		Date fecha = (Date) session.getAttribute("fecha");

		DataReserva dr = new DataReserva();
		System.out.println(dr.ultimoid());

		System.out.println(cli.getDni());
		System.out.println(es.getNombre());

		Correo correo = new Correo();

		
		Reserva r = new Reserva((dr.ultimoid() + 1), fecha, hora_inicio, es.getNombre(), numero_cancha, cli.getDni());
		
		try {
			correo.enviar_mail_confirmacion(cli.getEmail(), r, es);
		} catch (IOException e) {
			e.printStackTrace();
		}

		dr.add(r);
		
		request.getSession().setAttribute("reserva", r);

		request.getRequestDispatcher("confirmacionDeLaReserva.jsp").forward(request, response);

		// doGet(request, response);
	}

}
