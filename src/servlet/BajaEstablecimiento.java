package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.DataEstablecimiento;
import entidades.Establecimiento;

@WebServlet("/BajaEstablecimiento")
public class BajaEstablecimiento extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BajaEstablecimiento() {
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
		} else if (act.equals("Aceptar")) {
			System.out.println("Servlet baja establecimiento");
			String establecimiento = request.getParameter("inputEstablecimiento");
			System.out.println(establecimiento);

			DataEstablecimiento de = new DataEstablecimiento();
			Establecimiento e = de.buscarEst(establecimiento);
			System.out.println(e.toString());

			request.getSession().setAttribute("establecim", e);
			request.getRequestDispatcher("bajaEstablecimientoConfirmar.jsp").forward(request, response);

		}

		doGet(request, response);

	}
}
