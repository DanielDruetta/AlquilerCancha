package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.DataCancha;
import data.DataCliente;
import entidades.Cancha;
import entidades.Cliente;

/**
 * Servlet implementation class AltaCancha
 */
@WebServlet("/AltaCancha")
public class AltaCancha extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaCancha() {
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
			} else if (act.equals("Aceptar")) {
				 System.out.println("Se presiono aceptar");
					DataCancha dc = new DataCancha();
					String establecimiento=request.getParameter("inputEstablecimiento");
			        String luz=request.getParameter("luz");
			        String descripcion=request.getParameter("descripcion");
			        String num=request.getParameter("numero");
			        String tip=request.getParameter("tipo");
			       
			        System.out.println(establecimiento);
			      
			        int numero=Integer.parseInt(num);
			        int tipo=Integer.parseInt(tip);
			       
			       
			        if (luz == null) 
			        	luz= "N";
			     
			        Cancha can = new Cancha(numero,descripcion,tipo,luz,establecimiento);
		        	dc.add(can);
			       
			}
	
      
		doGet(request, response);
	}

}
