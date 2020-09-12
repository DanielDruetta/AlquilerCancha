package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.DataCancha;
import data.DataPrecio;
import entidades.Cancha;
import entidades.Establecimiento;
import entidades.Precio;

@WebServlet("/ModificacionCancha")
public class ModificacionCancha extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ModificacionCancha() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String act = request.getParameter("act");
		if (act == null) {
			System.out.println("No se presiono nada");
		} else if (act.equals("Modificar cancha")) {
			//System.out.println("Servlet modificacion cancha");
			DataCancha dc = new DataCancha();

			Establecimiento e = (Establecimiento) session.getAttribute("establec");
			String establecimiento = e.getNombre();
			String num = request.getParameter("numero");
			int numero = Integer.parseInt(num);

			Cancha can = new Cancha(establecimiento, numero);
			Cancha c = dc.search(can);

			DataPrecio dp = new DataPrecio();
			Precio p = dp.obtenerPrecio(establecimiento, numero);

			request.getSession().setAttribute("cancha", c);
			request.getSession().setAttribute("precio", p);
			request.getRequestDispatcher("modificacionCanchaConfirmar.jsp").forward(request, response);

		}

		doGet(request, response);

	}
}
