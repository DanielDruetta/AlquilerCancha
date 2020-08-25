package servlet;

import java.io.IOException;

import java.sql.Date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.DataCancha;
import data.DataEstablecimiento;
import entidades.Cancha;
import entidades.Cliente;
import entidades.Establecimiento;
import entidades.Ocupada;

/**
 * Servlet implementation class Reservar
 */
@WebServlet({ "/Reservar", "/reservar" })
public class Reservar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Reservar() {
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

		String act = request.getParameter("act");

		if (act == null) {
			System.out.println("No se presiono nada");

		} else if (act.equals("Aceptar")) {

			String establecimiento = request.getParameter("inputEstablecimiento");
			String fecha = request.getParameter("inputFecha");
			System.out.println(fecha);
			String tipoS = request.getParameter("inputTipo");

			Date date = Date.valueOf(fecha);

			System.out.println(date);

			request.getSession().setAttribute("fecha", date);

			int tipo = Integer.parseInt(tipoS);
			DataCancha dc = new DataCancha();
			DataEstablecimiento de = new DataEstablecimiento();
			Establecimiento es = de.buscarEst(establecimiento);

			ArrayList<Ocupada> ocupadas = new ArrayList<Ocupada>();

			ocupadas = dc.buscarFechaEstablecimiento(establecimiento, fecha, tipo);// Esta funcion lo que hace es,
																					// devuelve una lista de ocupadas
																					// (numero y hora) de ese tipo, para
																					// esa fecha y ese establecimiento

			Cliente cli = (Cliente) session.getAttribute("usuario");
			System.out.println(cli.getDni());

			ArrayList<Ocupada> disponibles = new ArrayList<Ocupada>();

			for (int j = es.getHora_inicio(); j <= es.getHora_fin(); j++) {

				for (int l = 1; l <= de.cantidadCanchas(establecimiento); l++) {
					// Aca esta el problema. Porque en realidad hay que copiar en disponibles,
					// solamente las canchas que sean de ese tipo. Si por ejemplo, la cancha numero
					// 2 y la 4 son de tipo 11, como hacer?
					if (tipo == dc.tipoSegunNroCancha(l, establecimiento)) {
						Ocupada disp = new Ocupada();
						disp.setEstado("Disponible");
						disp.setHora_inicio(j);
						disp.setNumero(l);
						disp.setDescripcion(dc.descripcion(establecimiento, l));
						disponibles.add(disp);
					}
				}
			}

			for (Ocupada disp : disponibles) {
				System.out.println(disp.toString());
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
						System.out.println("Aca va");
						System.out.println(posicion);
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
			// someone has altered the HTML and sent a different value!
		}
		doGet(request, response);
	}
}
