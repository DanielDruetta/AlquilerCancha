package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.DataCliente;
import entidades.Cliente;

/**
 * Servlet implementation class ModificacionCliente
 */
@WebServlet({"/ModificacionCliente", "/mcliente"})
public class ModificacionCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificacionCliente() {
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
		String act=request.getParameter("act");
        if (act == null) {
		    System.out.println("No se presiono nada");
		} else if (act.equals("Modificar")) {
			System.out.println("Se presiono modificar");
	        String usuario=request.getParameter("usuario");
	        String contraseña=request.getParameter("contrasena");
	        String nombre=request.getParameter("nombre");
	        String apellido=request.getParameter("apellido");
	        String email=request.getParameter("email");
	        String celular=request.getParameter("celular");
	        String dni=request.getParameter("dni");
	
	        DataCliente dc=new DataCliente();
	
	        Cliente clinuevo = new Cliente(dni,nombre,apellido,celular,email,usuario,contraseña);
	        System.out.println(clinuevo.toString());
			
			Cliente cliviejo= (Cliente)session.getAttribute("usuario");
			System.out.println(cliviejo.toString());
	        
			dc.modificarCliente(clinuevo,cliviejo);
			request.getRequestDispatcher("ventanaCliente.html").forward(request, response);
	
	        doGet(request, response);
    }

}
}
