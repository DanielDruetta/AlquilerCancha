package servlet;

import java.io.IOException;
import java.sql.SQLException;

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

@WebServlet("/ModificacionCanchaConfirmado")
public class ModificacionCanchaConfirmado extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ModificacionCanchaConfirmado() {
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
		String actio = request.getParameter("action");
		if (actio == null) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else if (actio.equals("Modificar")) {
			System.out.println("Servlet modificacion cancha confirmado");

			Cancha c = (Cancha) session.getAttribute("cancha");
			String establecimiento = c.getEstablecimiento();
			String num = request.getParameter("numero");
			String descripcion = request.getParameter("descripcion");
			String tip = request.getParameter("tipo");
			String luz = request.getParameter("luz");
			String nuevopreci = request.getParameter("inputPrecio");
			int numero = Integer.parseInt(num);
			int tipo = Integer.parseInt(tip);
			double nuevoprecio = Double.parseDouble(nuevopreci);

			if (luz == null)
				luz = "N";

			try {
				DataCancha dc = new DataCancha();
				DataPrecio dp = new DataPrecio();

				Cancha cannuevo = new Cancha(numero, descripcion, tipo, luz, establecimiento);
				System.out.println("Cancha nueva" + cannuevo.toString());

				Cancha canviejo = (Cancha) session.getAttribute("cancha");
				System.out.println("Cancha vieja" + canviejo.toString());

				dc.modificarCancha(cannuevo, canviejo);
				Precio precio = new Precio(establecimiento, numero, nuevoprecio);
				dp.add(precio);
				request.setAttribute("mensajeOk", "Cancha modificada exitosamente");
				request.getRequestDispatcher("index.jsp").forward(request, response);

			} catch (SQLException e) {
				request.setAttribute("mensajeError", "Error interno del servidor");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}

		} else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

	}
}