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
import entidades.Establecimiento;


@WebServlet("/BajaCancha")
public class BajaCancha extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BajaCancha() {
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
		String act = request.getParameter("act");
		if (act == null) {
			System.out.println("No se presiono nada");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else if (act.equals("Eliminar cancha")) {
			System.out.println("Se presiono eliminar");
			DataCancha dc = new DataCancha();

			System.out.println("asd");
			Establecimiento e = (Establecimiento) session.getAttribute("establec");
			String establecimiento = e.getNombre();
			System.out.println(establecimiento);
			String num = request.getParameter("numero");
			int numero = Integer.parseInt(num);

			Cancha can = new Cancha(establecimiento, numero);
			Cancha c = dc.search(can);

			request.getSession().setAttribute("cancha", c);
			request.getRequestDispatcher("bajaCanchaConfirmar.jsp").forward(request, response);

		}

		doGet(request, response);

	}
}
