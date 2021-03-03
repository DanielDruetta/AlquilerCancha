<%@page import="data.DataEstablecimiento"%>
<%@page import="data.DataClienteReserva"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Reserva"%>
<%@page import="data.DataReserva"%>
<%@page import="entidades.Cliente"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp" />

<%
	DataReserva dr = new DataReserva();
	DataClienteReserva dcr = new DataClienteReserva();
	ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	reservas = dr.reservasAcompletar();
	Cliente c = (Cliente) session.getAttribute("usuario");
	ArrayList<Integer> reservas_ya_completadas_por_el_cliente = new ArrayList<Integer>();
	reservas_ya_completadas_por_el_cliente = dcr.reservasYaCompletadas(c);	
%>
</head>

<body>
	<div class="container">
		<h3>Listado de partidos a completar</h3>
		<form class="form-CompletarPartido" action="CompletarPartido"
			method="post">
			<br>
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
						<% if (reservas_ya_completadas_por_el_cliente.contains(res.getNumero_reserva())) { %> 
							<td style="padding-top: 20px">Ya se encuentra unido a este partido</td> 
						<% } else { %> 
							 
							<td style="padding-top: 20px"><button type="submit"
								class="btn btn-light" name="nroreserva"
								value="<%=String.valueOf(res.getNumero_reserva())%>">Seleccionar</button></td>
								
						<% } %>
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