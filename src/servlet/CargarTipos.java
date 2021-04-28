package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.DataEstablecimiento;
import entidades.Administrador;
import entidades.Cliente;
import entidades.Establecimiento;

@WebServlet({ "/CargarTipos", "/cargar_tipos" })
public class CargarTipos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CargarTipos() {
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
		DataEstablecimiento de = new DataEstablecimiento();

		String establecimiento = request.getParameter("id");
		System.out.println("El estableciminto ingresado es:" + establecimiento);
		Establecimiento es = null;
		try {
			es = de.buscarEst(establecimiento);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ArrayList<Integer> tipos = de.tipos(establecimiento);
		String respuesta = "<option value='vacio'>Ingrese un tipo de cancha</option>";
		for (int num : tipos) {
			String num_s = Integer.toString(num);
			respuesta = respuesta + "<option value=" + num_s + ">" + num_s + "</option>";
		}

		respuesta = respuesta + "!!??" + "<iframe src=" + es.getUrl_mapa()
				+ "frameborder='0' allowfullscreen='' style='border:0' allowfullscreen></iframe>";

		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(respuesta);

	}

}
