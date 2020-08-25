<<<<<<< HEAD
package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import data.DataEstablecimiento;
import data.DataReserva;
import data.DataPrecio;
import entidades.Establecimiento;
import entidades.Ocupada;
import entidades.Reserva;
import entidades.Precio;

/**
 * Servlet implementation class signin
 */
@WebServlet({"/SigninEstablecimiento", "/signinEstablecimiento"} )
public class SigninEstablecimiento extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SigninEstablecimiento() {
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
		String usuario=request.getParameter("usuario");
        String contraseña=request.getParameter("contrasena");
        System.out.println(usuario+"|"+contraseña);
        String act = request.getParameter("act");
        DataPrecio dp = new DataPrecio();
        
        if (act == null) {
		    System.out.println("No se presiono nada");
		} else if (act.equals("Ingresar")) {
			 System.out.println("Se presiono ingresar");
			 Establecimiento est = new Establecimiento();
		        
		        est.setUsuario(usuario);
		        est.setContraseña(contraseña);
		        
		        DataEstablecimiento de= new DataEstablecimiento();
		        Establecimiento e= de.getByUser(est);
		        request.getSession().setAttribute("establec", e);
		        
		   /*     ArrayList<Precio> preciosCancha = new ArrayList<Precio>();
		        
		        for (int i=1; i<=de.cantidadCanchas(e.getNombre());i++)
		       
		        {
		        	 Precio prec = new Precio(e.getNombre(),i,dp.obtenerPrecio(e.getNombre(), i));
		        }*/
		        
		        	
		        
		        if (e == null) {
		        	
		        	System.out.println("Usuario o contraseña incorrectos");
		        	request.getRequestDispatcher("loginFalla.html").forward(request, response);
		        	
		        }else 
		        	{    request.getSession().setAttribute("establec", e); // esto es correcto
		        	
		        	
				    request.getRequestDispatcher("menuDueño.jsp").forward(request, response);
		       
				   }
		} else if (act.equals("Registrarse")) {
			 System.out.println("Se presiono registrarse");
			 request.getRequestDispatcher("altaEstablecimiento.html").forward(request, response);
		} else {
		    //someone has altered the HTML and sent a different value!
		}
       
	}

}
=======
package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.DataEstablecimiento;
import data.DataReserva;
import entidades.Establecimiento;
import entidades.Reserva;

/**
 * Servlet implementation class signin
 */
@WebServlet({ "/SigninEstablecimiento", "/signinEstablecimiento" })
public class SigninEstablecimiento extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public SigninEstablecimiento() {
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
		String usuario = request.getParameter("usuario");
		String contraseña = request.getParameter("contrasena");
		System.out.println(usuario + "|" + contraseña);
		String act = request.getParameter("act");

		if (act == null) {
			System.out.println("No se presiono nada");
		} else if (act.equals("Ingresar")) {
			System.out.println("Se presiono ingresar");
			Establecimiento est = new Establecimiento();

			est.setUsuario(usuario);
			est.setContraseña(contraseña);

			DataEstablecimiento de = new DataEstablecimiento();
			Establecimiento e = de.getByUser(est);
			request.getSession().setAttribute("establec", e);

			if (e == null) {

				System.out.println("Usuario o contraseña incorrectos");
				request.getRequestDispatcher("loginFalla.html").forward(request, response);

			} else {
				request.getSession().setAttribute("establec", e); // esto es correcto

				request.getRequestDispatcher("menuDueño.jsp").forward(request, response);

			}
		} else if (act.equals("Registrarse")) {
			System.out.println("Se presiono registrarse");
			request.getRequestDispatcher("altaEstablecimiento.html").forward(request, response);
		} else {
			// someone has altered the HTML and sent a different value!
		}

	}

}
>>>>>>> branch 'master' of https://github.com/DanielDruetta/AlquilerCancha.git
