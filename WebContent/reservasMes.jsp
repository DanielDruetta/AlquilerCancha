<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="entidades.Reserva"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Ocupada"%>
<%@page import="entidades.Establecimiento"%>
<%@page import="data.DataReserva"%>
<%@page import="data.DataCliente"%>
<%@page import="java.sql.Time"%>
<%@page import= "java.text.SimpleDateFormat" %>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp" />

<%
	Establecimiento e = (Establecimiento) session.getAttribute("establec");
	if (e == null) {
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	DataReserva dr = new DataReserva();
	ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	reservas = dr.reservasMes(e.getNombre());
	DataCliente dc = new DataCliente();
	String strDateFormat = "dd-MM-yyyy";
	SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
%>

</head>
<body>


	<div class="container">
		<h3>Reservas de los próximos 30 días</h3>
		<form class="form-confirmarReserva" action="ConfirmarReserva"
			method="post">
			<div class="row">
				<div class="col-12 col-sm-12 col-lg-12">
					<div class="table-responsive">
						<table class="table">
							<thead>
								<tr>
									<th>Numero de reserva</th>
									<th>Numero de cancha</th>
									<th>Fecha</th>
									<th>Hora inicio</th>
									<th>Hora fin</th>
									<th>DNI del cliente</th>
									<th>Nombre y apellido</th>
									<th>Celular</th>
									<th></th>
								</tr>
							</thead>
							<tbody>

								<%
									for (Reserva disp : reservas) {
								%>
								<tr>
									<td><%=disp.getNumero_reserva()%></td>
									<td><%=disp.getNumero_cancha()%></td>
									<td><%=objSDF.format(disp.getFecha())%></td>
									<td><%=disp.getHora_inicio()%></td>
									<td><%=disp.getHora_inicio() + 1%></td>
									<td><%=disp.getDni()%></td>
									<td><%=(dc.buscarDNI(disp.getDni())).getNombre() + " " + (dc.buscarDNI(disp.getDni())).getApellido()%></td>
									<td><%=(dc.buscarDNI(disp.getDni())).getCelular()%></td>
								</tr>

								<%
									}
								%>

							</tbody>
						</table>
					</div>
				</div>
			</div>
		</form>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>