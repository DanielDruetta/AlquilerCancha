package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.DataCliente;
import data.DataEstablecimiento;
import data.DataAdministrador;
import entidades.Cliente;
import entidades.Establecimiento;
import entidades.Administrador;

@WebServlet({ "/Signin", "/signin", "/signIn", "/SignIn", "/SIGNIN" })
public class Signin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Signin() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		String contrase�a = request.getParameter("contrasena");
		String act = request.getParameter("act");

		if (act == null) {
			System.out.println("No se presiono nada");
		} else if (act.equals("Ingresar")) {
			Cliente cli = new Cliente();

			cli.setUsuario(usuario);
			cli.setPassword(contrase�a);

			DataCliente dc = new DataCliente();
			Cliente c = dc.getByUser(cli);

			if (c != null) {
				request.getSession().setAttribute("usuario", c);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}

			if (c == null) {
				Establecimiento est = new Establecimiento();

				est.setUsuario(usuario);
				est.setContrase�a(contrase�a);

				DataEstablecimiento de = new DataEstablecimiento();
				Establecimiento e = de.getByUser(est);

				if (e != null) {
					request.getSession().setAttribute("establec", e);
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}

				if (e == null) {
					Administrador adm = new Administrador();
					adm.setNombre_usuario(usuario);
					adm.setContrase�a(contrase�a);

					DataAdministrador da = new DataAdministrador();
					Administrador a = da.getByUser(adm);

					if (a != null) {
						request.getSession().setAttribute("administrador", a);
						request.getRequestDispatcher("index.jsp").forward(request, response);
					}

					if (a == null) {

						System.out.println("Usuario o contrase�a incorrectos");
						request.getRequestDispatcher("loginFalla.jsp").forward(request, response);

					}
				}
			}

		} else if (act.equals("Registrarse")) {
			System.out.println("Se presiono registrarse");
			request.getRequestDispatcher("altaCliente.html").forward(request, response);
		} else {
			// someone has altered the HTML and sent a different value!
		}

	}

}
