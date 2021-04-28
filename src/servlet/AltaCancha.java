package servlet;

import java.io.IOException;
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
import data.DataPrecio;
import entidades.Administrador;
import entidades.Cancha;
import entidades.Cliente;
import entidades.Establecimiento;
import entidades.Precio;

@WebServlet("/AltaCancha")
public class AltaCancha extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AltaCancha() {
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
		System.out.println("JUAN CARLOS");
		HttpSession session = request.getSession();
		String act = request.getParameter("act");
		if (act == null) {
			System.out.println("No se presiono nada");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else if (act.equals("Aceptar")) {
			System.out.println("Se presiono aceptar");
			DataCancha dc = new DataCancha();
			DataEstablecimiento de = new DataEstablecimiento();
			Establecimiento es = (Establecimiento) session.getAttribute("establec");
			String establecimiento = es.getNombre();
			String luz = request.getParameter("luz");
			String descripcion = request.getParameter("descripcion");
			String preci = request.getParameter("precio");
			String tip = request.getParameter("tipo");

			System.out.println(establecimiento);

			ArrayList<Integer> canchas = new ArrayList<Integer>();
			canchas = de.canchas(es.getNombre());

			int tipo = Integer.parseInt(tip);
			double preciocancha = Double.parseDouble(preci);

			if (luz == null)
				luz = "N";

			try {
				Cancha can = new Cancha(canchas.size() + 1, descripcion, tipo, luz, establecimiento);
				dc.add(can);

				Precio precio = new Precio(es.getNombre(), canchas.size() + 1, preciocancha);
				DataPrecio dr = new DataPrecio();
				dr.add(precio);

				request.setAttribute("mensajeOk", "Cancha registrada exitosamente");
				request.getRequestDispatcher("index.jsp").forward(request, response);

			} catch (SQLException e) {
				request.setAttribute("mensajeError", "Error interno del servidor");
				request.getRequestDispatcher("altaCancha.jsp").forward(request, response);

			}

		}

		doGet(request, response);
	}

}
