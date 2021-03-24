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
import entidades.Establecimiento;
import entidades.Precio;

/**
 * Servlet implementation class CargarPrecio
 */
@WebServlet("/CargarPrecio")
public class CargarPrecio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CargarPrecio() {
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
		doGet(request, response);
		
		HttpSession session = request.getSession();
		System.out.println("HOLARDA");
		Establecimiento e = (Establecimiento) session.getAttribute("establec");
		System.out.println(e);
		DataPrecio dp = new DataPrecio();

		String nro = request.getParameter("nro_cancha");
		int nro_cancha = Integer.parseInt(nro);

		Precio pre = dp.obtenerPrecio(e.getNombre(),nro_cancha);

		String respuesta =String.valueOf(pre.getPrecio()) ;
		
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(respuesta);
	}

}
