package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.DataCancha;
import entidades.Cancha;

@WebServlet("/BajaCanchaConfirmado")
public class BajaCanchaConfirmado extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BajaCanchaConfirmado() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String actio = request.getParameter("action");
		if (actio == null) {
			System.out.println("No se presiono nada");
		} else if (actio.equals("Eliminar")) {
			System.out.println("Se presiono eliminar");
			Cancha can = (Cancha) session.getAttribute("cancha");
			DataCancha dc = new DataCancha();
			System.out.println(can.toString());
			dc.delete(can);
			request.getRequestDispatcher("ventanaDueño.html").forward(request, response);
			doGet(request, response);
		}

	}
}