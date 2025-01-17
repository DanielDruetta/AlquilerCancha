<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Reserva"%>
<%@page import="entidades.Establecimiento"%>
<%@page import="data.DataCliente"%>
<%@page import= "java.text.SimpleDateFormat" %>

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
	String strDateFormat = "dd-MM-yyyy";
	SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
%>
</head>

<body>
	<div class="container">
		<h3>Listado de reservas dentro del rango de fechas del
			mantenimiento</h3>
		<p>Se descargará automáticamente un pdf con la información de las
			reservas. Informe a los clientes la situación, porque sus reservas
			podrían estar comprometidas.</p>
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
					<td style="padding-top: 20px"><%=res.getNumero_reserva()%></td>
					<td style="padding-top: 20px"><%=objSDF.format(res.getFecha())%></td>
					<td style="padding-top: 20px"><%=res.getHora_inicio()%></td>
					<td style="padding-top: 20px"><%=dc.buscarDNI(res.getDni()).getNombre() + " " + dc.buscarDNI(res.getDni()).getApellido()%></td>
					<td style="padding-top: 20px"><%=dc.buscarDNI(res.getDni()).getCelular()%></td>
				</tr>

				<%
					}
				%>

			</tbody>
		</table>
		<form action="descargar_lista" method="post">
			<button style="display: none" id="boton_descargar"
				class="btn btn-light">Descargar lista</button>
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