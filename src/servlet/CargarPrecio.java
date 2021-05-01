package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
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

/**
 * Servlet implementation class CargarPrecio
 */
@WebServlet("/CargarPrecio")
public class CargarPrecio extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CargarPrecio() {
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
		Establecimiento e = (Establecimiento) session.getAttribute("establec");
		DataPrecio dp = new DataPrecio();

		String nro = request.getParameter("nro_cancha");
		int nro_cancha = Integer.parseInt(nro);
		
		try {
			Precio pre = dp.obtenerPrecio(e.getNombre(), nro_cancha);

			String respuesta = String.valueOf(pre.getPrecio());

			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(respuesta);
			
		} catch (Exception e1) {
			request.setAttribute("mensajeError", "Error interno del servidor");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

		
	}

}
