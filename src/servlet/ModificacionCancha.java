package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.DataCancha;
import entidades.Cancha;

/**
 * Servlet implementation class BajaCliente
 */

@WebServlet("/ModificacionCancha")
public class ModificacionCancha extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificacionCancha() {
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
		String act = request.getParameter("act");
		 if (act == null) {
			    System.out.println("No se presiono nada");
			} else if (act.equals("Modificar cancha")) {
				    System.out.println("Servlet modificacion cancha");
					DataCancha dc = new DataCancha();
					
			        String establecimiento=request.getParameter("establecimiento");
			        String num=request.getParameter("numero");
			        int numero=Integer.parseInt(num);
			        
			        Cancha can = new Cancha(establecimiento,numero);
			        Cancha c= dc.search(can);

			        request.getSession().setAttribute("cancha", c);
			        request.getRequestDispatcher("modificacionCanchaConfirmar.jsp").forward(request, response);
					 
						}
					
		 	
  
		 doGet(request, response);
	
	
	}
}				
