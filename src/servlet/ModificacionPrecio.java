package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.DataPrecio;
import entidades.Administrador;
import entidades.Cliente;
import entidades.Establecimiento;
import entidades.Precio;

@WebServlet("/ModificacionPrecio")
public class ModificacionPrecio extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ModificacionPrecio() {
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

		String numerocanch = request.getParameter("inputEstablecimiento");
		int numerocancha = Integer.parseInt(numerocanch);
		String nuevopreci = request.getParameter("inputPrecio");
		double nuevoprecio = Double.parseDouble(nuevopreci);
		System.out.println(numerocanch);
		System.out.println(nuevoprecio);

		Establecimiento es = (Establecimiento) session.getAttribute("establec");

		try {
			Precio precio = new Precio(es.getNombre(), numerocancha, nuevoprecio);
			DataPrecio dp = new DataPrecio();
			dp.add(precio);
			request.setAttribute("mensajeOk", "Precio modificado exitosamente");
			request.getRequestDispatcher("index.jsp").forward(request, response);

		} catch (SQLException e) {
			request.setAttribute("mensajeError", "Error interno del servidor");
			request.getRequestDispatcher("index.jsp").forward(request, response);

		}

	}

}
