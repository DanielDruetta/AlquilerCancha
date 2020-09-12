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
import entidades.Precio;

@WebServlet("/ModificacionCanchaConfirmado")
public class ModificacionCanchaConfirmado extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ModificacionCanchaConfirmado() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String actio = request.getParameter("action");
		if (actio == null) {
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

			DataCancha dc = new DataCancha();
			DataPrecio dp = new DataPrecio();

			Cancha cannuevo = new Cancha(numero, descripcion, tipo, luz, establecimiento);
			System.out.println("Cancha nueva" + cannuevo.toString());

			Cancha canviejo = (Cancha) session.getAttribute("cancha");
			System.out.println("Cancha vieja" + canviejo.toString());

			dc.modificarCancha(cannuevo, canviejo);
			
			Precio precio = new Precio(establecimiento, numero, nuevoprecio);
			dp.add(precio);
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
			doGet(request, response);
		}

	}
}