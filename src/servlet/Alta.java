package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.DataCancha;
import data.DataCliente;
import entidades.Cliente;

@WebServlet({ "/Alta", "/alta" })
public class Alta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Alta() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
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
			String contraseņa = request.getParameter("contrasena");
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String email = request.getParameter("email");
			String celular = request.getParameter("celular");
			String dni = request.getParameter("dni");
			Cliente cli = new Cliente((dc.ultimoid() + 1), dni, nombre, apellido, celular, email, usuario, contraseņa);
			dc.add(cli);
			request.getRequestDispatcher("ventanaCliente.html").forward(request, response);
		}

	}

}
