<%@page import="data.DataEstablecimiento"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Reserva"%>
<%@page import="data.DataReserva"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp" />

<%
	DataReserva dr = new DataReserva();
	ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	reservas = dr.reservasAcompletar();
%>
</head>

<body>
	<div class="container">
		<h3>Listado de partidos a completar</h3>
		<form class="form-CompletarPartido" action="CompletarPartido"
			method="post">
			<table class="table">
				<thead>
					<tr>
						<th>Establecimiento</th>
						<th>Numero de cancha</th>
						<th>Fecha</th>
						<th>Hora de inicio</th>
						<th>Lugares disponibles</th>
						<th></th>
					</tr>
				</thead>

				<tbody>
					<%
						for (Reserva res : reservas) {
					%>
					<tr>
						<td style="padding-top: 20px"><%=res.getEstablecimiento()%></td>
						<td style="padding-top: 20px"><%=res.getNumero_cancha()%></td>
						<td style="padding-top: 20px"><%=res.getFecha()%></td>
						<td style="padding-top: 20px"><%=res.getHora_inicio()%></td>
						<td style="padding-top: 20px"><%=res.getLugares_disponibles()%></td>
						<td style="padding-top: 20px"><button type="submit"
								class="btn btn-light" name="nroreserva"
								value="<%=String.valueOf(res.getNumero_reserva())%>">Seleccionar</button></td>
					</tr>

					<%
						}
					%>


				</tbody>
			</table>
		</form>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>