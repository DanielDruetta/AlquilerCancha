package servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidades.ExportadorPDF;
import entidades.Reserva;

import java.util.ArrayList;


@WebServlet({ "/DescargarLista", "/descargar_lista" })
public class DescargarLista extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DescargarLista() {
        super();   
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArrayList<Reserva> reservas = (ArrayList<Reserva>) session.getAttribute("reservas_dentro_rango");
		Date fecha_inicio = (Date) session.getAttribute("fecha_inicio_mantenimiento");
		Date fecha_fin = (Date) session.getAttribute("fecha_fin_mantenimiento");
		String fechas = fecha_inicio + "_" + fecha_fin;
		String nombre_archivo = "reservasExistentes_" + fechas + ".pdf";
		
		System.out.println("Entro");
		System.out.println(reservas);
	
		String content =  "Content-Disposition";
		String filename = "attachment; filename="+nombre_archivo+".pdf";
		response.setHeader(content, filename);
		ExportadorPDF exp = new ExportadorPDF(reservas,fechas);
		try {
			exp.export(response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
