package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.DataCliente;
import entidades.Cliente;

@WebServlet({ "/Alta", "/alta" })
public class Alta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Alta() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String act = request.getParameter("act");
		if (act == null) {
			System.out.println("No se presiono nada");
		} else if (act.equals("Registrarse")) {
			System.out.println("Se presiono registrarse");
			DataCliente dc = new DataCliente();
			String usuario = request.getParameter("usuario");
			String contraseña = request.getParameter("contrasena");
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String email = request.getParameter("email");
			String celular = request.getParameter("celular");
			String dni = request.getParameter("dni");
			if ((usuario == "") || (contraseña == "") || (nombre == "") || (apellido == "") || (email == "") || (celular == "") || (dni == "")) {
				request.getRequestDispatcher("altaCliente.jsp").forward(request, response);
			} else {
				Cliente cli = new Cliente((dc.ultimoid() + 1), dni, nombre, apellido, celular, email, usuario, contraseña);
				dc.add(cli);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			
		}

	}

}
