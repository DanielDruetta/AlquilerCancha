package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.DataEstablecimiento;
import entidades.Establecimiento;

/**
 * Servlet implementation class BajaClienteConfirmado
 */
@WebServlet("/BajaEstablecimientoConfirmado")
public class BajaEstablecimientoConfirmado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BajaEstablecimientoConfirmado() {
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
		String actio = request.getParameter("act");
		if (actio == null) {
			    System.out.println("No se presiono nada");
			} else if (actio.equals("Eliminar")) {
				 System.out.println("Se presiono eliminar");
				 Establecimiento est= (Establecimiento)session.getAttribute("establecim");
				 DataEstablecimiento de = new DataEstablecimiento();
				 System.out.println(est.toString());
				 de.delete(est);
				 request.getRequestDispatcher("ventanaAdmin.html").forward(request, response);
		doGet(request, response);
	}

}
	}