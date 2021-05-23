<%@page import="data.DataEstablecimiento"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Reserva"%>
<%@page import="entidades.Cliente"%>
<%@page import="data.DataClienteReserva"%>
<%@page import= "java.text.SimpleDateFormat" %>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp" />

<%
	if (session.getAttribute("usuario") == null) {
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	DataClienteReserva dcr = new DataClienteReserva();
	ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	Cliente c = (Cliente) session.getAttribute("usuario");
	reservas = dcr.reservas(c.getDni());
	String strDateFormat = "dd-MM-yyyy";
	SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
%>
</head>

<body>
	<div class="container">
		<h3>Listado de partidos en los cuales se encuentra unido</h3>
		<form class="form-ModificarCompletarPartido"
			action="ModificarCompletarPartido" method="post">
			<br>
			<table class="table">
				<thead>
					<tr>
						<th>Establecimiento</th>
						<th>Numero de cancha</th>
						<th>Fecha</th>
						<th>Hora de inicio</th>
						<th>Lugares disponibles</th>
						<th>Jugadores aportados al partido</th>
						<th></th>
					</tr>
				</thead>

				<tbody>
					<%
						for (Reserva res : reservas) {
						String seleccion = res.getEstablecimiento();
						String[] datos = seleccion.split("xyz");
						String establecimiento = String.valueOf(datos[0]);
						int cantidad_jugadores = Integer.parseInt(datos[1]);
						if (cantidad_jugadores > 0) {
					%>
					<tr>
						<td style="padding-top: 20px"><%=establecimiento%></td>
						<td style="padding-top: 20px"><%=res.getNumero_cancha()%></td>
						<td style="padding-top: 20px"><%=objSDF.format(res.getFecha())%></td>
						<td style="padding-top: 20px"><%=res.getHora_inicio()%></td>
						<td style="padding-top: 20px"><%=res.getLugares_disponibles()%></td>
						<td style="padding-top: 20px"><%=cantidad_jugadores%></td>
						<td><button type="submit" class="btn btn-light" name="nrores"
								value="<%=String.valueOf(res.getNumero_reserva())%>">Modificar</button></td>
					</tr>

					<%
						}

					}
					
					%>


				</tbody>
			</table>
		</form>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>