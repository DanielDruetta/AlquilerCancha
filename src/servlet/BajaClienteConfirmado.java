package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.DataCliente;
import entidades.Cliente;

@WebServlet("/BajaClienteConfirmado")
public class BajaClienteConfirmado extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BajaClienteConfirmado() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String act = request.getParameter("act");
		if (act == null) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String actio = request.getParameter("action");
		if (actio == null) {
			System.out.println("No se presiono nada");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else if (actio.equals("Eliminar")) {
			System.out.println("Se presiono eliminarrrrrr");
			Cliente cli = (Cliente) session.getAttribute("usuario");
			DataCliente dc = new DataCliente();
			System.out.println(cli.toString());
			dc.delete(cli);
			doGet(request, response);
		}

	}
}
