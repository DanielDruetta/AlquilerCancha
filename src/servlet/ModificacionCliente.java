package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.DataCliente;
import entidades.Administrador;
import entidades.Cliente;
import entidades.Establecimiento;

@WebServlet({ "/ModificacionCliente", "/mcliente" })
public class ModificacionCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ModificacionCliente() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Establecimiento e = (Establecimiento) session.getAttribute("establec");
		Cliente c = (Cliente) session.getAttribute("usuario");
		Administrador a = (Administrador) session.getAttribute("administrador");

		if ((c == null) || (e == null) || (a == null)) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String act = request.getParameter("act");
		if (act == null) {
			System.out.println("No se presiono nada");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else if (act.equals("Modificar")) {
			System.out.println("Se presiono modificar");
			String usuario = request.getParameter("usuario");
			String contraseņa = request.getParameter("contrasena");
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String email = request.getParameter("email");
			String celular = request.getParameter("celular");
			String dni = request.getParameter("dni");

			DataCliente dc = new DataCliente();

			Cliente clinuevo = new Cliente(dni, nombre, apellido, celular, email, usuario, contraseņa);
			System.out.println(clinuevo.toString());

			Cliente cliviejo = (Cliente) session.getAttribute("usuario");
			System.out.println(cliviejo.toString());

			dc.modificarCliente(clinuevo, cliviejo);
			request.getRequestDispatcher("index.jsp").forward(request, response);

			request.getSession().setAttribute("usuario", clinuevo);

			doGet(request, response);
		}

	}
}
