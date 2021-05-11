<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Reserva"%>
<%@page import="entidades.Establecimiento"%>
<%@page import="data.DataCliente"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp" />

<%
Establecimiento es = (Establecimiento) session.getAttribute("establec");
if (es == null) {
	request.getRequestDispatcher("index.jsp").forward(request, response);
}
DataCliente dc = new DataCliente();
ArrayList<Reserva> reservas = (ArrayList<Reserva>) session.getAttribute("reservas_dentro_rango");
%>
</head>

<body>
	<div class="container">
		<h3>Listado de reservas dentro del rango de fechas del mantenimiento</h3>
		<p>Se descargar� autom�ticamente un pdf con la informaci�n de las reservas. Informe a los clientes la situaci�n, porque sus reservas podr�an estar comprometidas.</p>
		<table class="table">
			<thead>
				<tr>
					<th>Numero de reserva</th>
					<th>Fecha</th>
					<th>Hora</th>
					<th>Nombre y apellido</th>
					<th>Celular</th>
				</tr>
			</thead>

			<tbody>
				<%
					for (Reserva res : reservas) {
						
				%>
				<tr>
					<td style="padding-top:20px"><%=res.getNumero_reserva()%></td>
					<td style="padding-top:20px"><%=res.getFecha()%> </td>
					<td style="padding-top:20px"><%=res.getHora_inicio()%></td>
					<td style="padding-top:20px"><%=dc.buscarDNI(res.getDni()).getNombre() + " " + dc.buscarDNI(res.getDni()).getApellido() %></td>
					<td style="padding-top:20px"><%=dc.buscarDNI(res.getDni()).getCelular() %></td>
				</tr>

				<%
					}
				%>

			</tbody>
		</table>
		<form action="descargar_lista" method="post">
			<button style="display:none" id="boton_descargar" class="btn btn-light">Descargar lista</button>
		</form>
	</div>
	<jsp:include page="footer.jsp" />
</body>

<script>
	window.onload = function() {
	  document.getElementById("boton_descargar").click();
	};
</script>
</html>