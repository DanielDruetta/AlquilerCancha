package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.DataPrecio;
import entidades.Establecimiento;
import entidades.Precio;

/**
 * Servlet implementation class AltaPrecio
 */
@WebServlet("/ModificacionPrecio")
public class ModificacionPrecio extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModificacionPrecio() {
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

		String numerocanch = request.getParameter("inputEstablecimiento");
		int numerocancha = Integer.parseInt(numerocanch);
		String nuevopreci = request.getParameter("inputPrecio");
		double nuevoprecio = Double.parseDouble(nuevopreci);
		System.out.println(numerocanch);
		System.out.println(nuevoprecio);

		Establecimiento e = (Establecimiento) session.getAttribute("establec");

		Precio precio = new Precio(e.getNombre(), numerocancha, nuevoprecio);
		DataPrecio dr = new DataPrecio();
		dr.add(precio);
		request.getRequestDispatcher("ventanaDueño.html").forward(request, response);
		doGet(request, response);
	}

}
