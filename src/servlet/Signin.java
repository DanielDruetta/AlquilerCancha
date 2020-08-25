package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.DataCancha;
import data.DataCliente;
import data.DataEstablecimiento;
import entidades.Cancha;
import entidades.Cliente;

/**
 * Servlet implementation class signin
 */
@WebServlet({ "/Signin", "/signin", "/signIn", "/SignIn", "/SIGNIN" })
public class Signin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public Signin() {
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
			Cliente cli = new Cliente();

			cli.setUsuario(usuario);
			cli.setPassword(contraseña);

			DataCliente dc = new DataCliente();
			// DataCancha dtc = new DataCancha();
			// DataEstablecimiento de = new DataEstablecimiento();
			Cliente c = dc.getByUser(cli);
			request.getSession().setAttribute("usuario", c);

			if (c == null) {

				System.out.println("Usuario o contraseña incorrectos");
				request.getRequestDispatcher("loginFalla.html").forward(request, response);

			} else {
				request.getSession().setAttribute("usuario", c); // esto es correcto

				request.getRequestDispatcher("index.jsp").forward(request, response);

			}
		} else if (act.equals("Registrarse")) {
			System.out.println("Se presiono registrarse");
			request.getRequestDispatcher("altaCliente.html").forward(request, response);
		} else {
			// someone has altered the HTML and sent a different value!
		}

	}

}
