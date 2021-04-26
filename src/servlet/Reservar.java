package servlet;

import java.io.IOException;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.DataCancha;
import data.DataEstablecimiento;
import entidades.Cliente;
import entidades.Establecimiento;
import entidades.Ocupada;

@WebServlet({ "/Reservar", "/reservar" })
public class Reservar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Reservar() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String act = request.getParameter("act");
		if (act == null) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String act = request.getParameter("act");

		if (act == null) {
			System.out.println("No se presiono nada");
			request.getRequestDispatcher("index.jsp").forward(request, response);

		} else if (act.equals("Aceptar")) {
			String fecha = request.getParameter("inputFecha");
			String jugadores = request.getParameter("inputNroJugadores");
			String establecimiento = request.getParameter("inputEstablecimiento");
			String tipoS = request.getParameter("inputTipo");

			if ( (fecha == null) || (jugadores == null) || (establecimiento == null) || ( (tipoS == null)  || (tipoS.contentEquals("vacio"))) ) {
				request.setAttribute("mensajeError", "Complete todos los campos por favor");
				request.getRequestDispatcher("reservarCancha.jsp").forward(request, response);
			}
			
			Date date = Date.valueOf(fecha);
			request.getSession().setAttribute("fecha", date);

			int jugadores_int = Integer.parseInt(jugadores);
			System.out.println("Jugadores nescesarios:" + jugadores_int);
			request.getSession().setAttribute("lugares_disponibles", jugadores);

			int tipo = Integer.parseInt(tipoS);

			DataCancha dc = new DataCancha();
			DataEstablecimiento de = new DataEstablecimiento();

			Establecimiento es = null;
			ArrayList<Ocupada> ocupadas = new ArrayList<Ocupada>();
			
			

			try {
				es = de.buscarEst(establecimiento);
				System.out.println("El establecimiento es: " + es);
				ocupadas = dc.buscarFechaEstablecimiento(establecimiento, fecha, tipo);
				// Esta funcion lo que hace es, devuelve una lista de ocupadas (numero y hora)
				// de ese tipo, para esa fecha y ese establecimiento
			} catch (SQLException e) {
				request.setAttribute("mensajeError", "Error interno del servidor");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}

			Cliente cli = (Cliente) session.getAttribute("usuario");
			System.out.println(cli.getDni());

			ArrayList<Ocupada> disponibles = new ArrayList<Ocupada>();

			for (int j = es.getHora_inicio(); j <= es.getHora_fin(); j++) {
				for (int l = 1; l <= de.cantidadCanchas(establecimiento); l++) {
					if (tipo == dc.tipoSegunNroCancha(l, establecimiento)
							&& (dc.estaEnMantenimiento(l, establecimiento, date) == 0)) {
						Ocupada disp = new Ocupada();
						disp.setEstado("Disponible");
						disp.setHora_inicio(j);
						disp.setNumero(l);
						disp.setDescripcion(dc.descripcion(establecimiento, l));
						disponibles.add(disp);
					}
				}
			}

			for (Ocupada dispo : disponibles) {
				for (Ocupada oc : ocupadas) {
					if (oc.getHora_inicio() == dispo.getHora_inicio() && oc.getNumero() == dispo.getNumero()) {
						Ocupada disp = new Ocupada();
						disp.setEstado("Ocupada");
						disp.setHora_inicio(dispo.getHora_inicio());
						disp.setNumero(dispo.getNumero());
						disp.setDescripcion(dc.descripcion(establecimiento, dispo.getNumero()));

						int posicion = disponibles.indexOf(dispo);
						disponibles.set(posicion, disp);

					}
				}
			}

			request.setAttribute("listaDisponibles", disponibles);
			request.getSession().setAttribute("establecimiento", es);
			request.getRequestDispatcher("seleccionarCancha.jsp").forward(request, response);

		} else if (act.equals("cancelar")) {
			System.out.println("Se presiono cancelar");
		} else {
		}
		doGet(request, response);
	}
}
