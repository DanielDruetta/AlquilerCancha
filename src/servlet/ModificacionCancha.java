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
import entidades.Administrador;
import entidades.Cancha;
import entidades.Cliente;
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
		} else if (act.equals("Modificar cancha")) {
			DataCancha dc = new DataCancha();

			Establecimiento e = (Establecimiento) session.getAttribute("establec");
			String establecimiento = e.getNombre();
			String num = request.getParameter("numero");
			int numero = Integer.parseInt(num);

			Cancha can = new Cancha(establecimiento, numero);
			Cancha c = dc.search(can);

			try {
				DataPrecio dp = new DataPrecio();
				Precio p = dp.obtenerPrecio(establecimiento, numero);

				request.getSession().setAttribute("cancha", c);
				request.getSession().setAttribute("precio", p);
				request.getRequestDispatcher("modificacionCanchaConfirmar.jsp").forward(request, response);

			} catch (Exception e1) {
				request.setAttribute("mensajeError", "Error interno del servidor");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}

		}

		doGet(request, response);

	}
}
