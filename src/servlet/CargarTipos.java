package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.DataEstablecimiento;
import entidades.Establecimiento;


@WebServlet({ "/CargarTipos", "/cargar_tipos" })
public class CargarTipos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CargarTipos() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		DataEstablecimiento de = new DataEstablecimiento();

		String establecimiento = request.getParameter("id");
		System.out.println("El estableciminto ingresado es:" + establecimiento);
		Establecimiento es = de.buscarEst(establecimiento);
		
		ArrayList<Integer> tipos = de.tipos(establecimiento);
		String respuesta = "<option value='vacio'>Ingrese un tipo de cancha</option>";
		 for (int num : tipos) 
	        {
			 String num_s = Integer.toString(num);
			 respuesta = respuesta + "<option value="+num_s+">"+num_s+"</option>";
	        }
		
		respuesta = respuesta + "!!??" + "<iframe src="+ es.getUrl_mapa() + "frameborder='0' allowfullscreen='' style='border:0' allowfullscreen></iframe>";
		
		
		
		response.setContentType("text/plain");  
	    response.setCharacterEncoding("UTF-8"); 
	    response.getWriter().write(respuesta);
	    

	}

}
