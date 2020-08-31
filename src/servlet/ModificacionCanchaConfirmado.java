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

@WebServlet("/ModificacionCanchaConfirmado")
public class ModificacionCanchaConfirmado extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ModificacionCanchaConfirmado() {
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
		HttpSession session = request.getSession();
		String actio = request.getParameter("action");
		if (actio == null) {
			System.out.println("No se presiono nada");
		} else if (actio.equals("Modificar")) {
			System.out.println("Servlet modificacion cancha confirmado");

			Cancha c = (Cancha) session.getAttribute("cancha");
			String establecimiento = c.getEstablecimiento();
			String num = request.getParameter("numero");
			String descripcion = request.getParameter("descripcion");
			String tip = request.getParameter("tipo");
			String luz = request.getParameter("luz");
			int numero = Integer.parseInt(num);
			int tipo = Integer.parseInt(tip);

			DataCancha dc = new DataCancha();

			Cancha cannuevo = new Cancha(numero, descripcion, tipo, luz, establecimiento);
			System.out.println("Cancha nueva" + cannuevo.toString());

			Cancha canviejo = (Cancha) session.getAttribute("cancha");
			System.out.println("Cancha vieja" + canviejo.toString());

			dc.modificarCancha(cannuevo, canviejo);
			request.getRequestDispatcher("index.jsp").forward(request, response);

			doGet(request, response);
		}

	}
}