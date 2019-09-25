package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Time;
import data.DataEstablecimiento;
import entidades.Establecimiento;

/**
 * Servlet implementation class AltaEstablecimiento
 */
@WebServlet("/AltaEstablecimiento")
public class AltaEstablecimiento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaEstablecimiento() {
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
	
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		String act = request.getParameter("act");
		 if (act == null) {
			    System.out.println("No se presiono nada");
			} else if (act.equals("Aceptar")) {
				 System.out.println("Se presiono aceptar");
					
				 	DataEstablecimiento de = new DataEstablecimiento();
					
				 	String nombre=request.getParameter("nombre");
			        String direccion=request.getParameter("direccion");
			        String usuario=request.getParameter("usuario");
			        String contraseņa=request.getParameter("contraseņa");
			        
			        String hora_inicio=request.getParameter("inputHoraInicio");
			      
			        String hora_fin=request.getParameter("inputHoraFin");
			        
			        int horainicio = Integer.parseInt(hora_inicio);
			        int horafin = Integer.parseInt(hora_fin);
					
			        System.out.println(horainicio);
			        System.out.println(horafin);
			        
			        Establecimiento es = new Establecimiento(nombre,direccion,horainicio,horafin,usuario,contraseņa);
			        System.out.println(es.toString());
			        de.add(es);
			        System.out.println("ggbrozqui");
			        
			}
	
		doGet(request, response);
	}

}
