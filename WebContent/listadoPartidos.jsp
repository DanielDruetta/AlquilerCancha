<%@page import="data.DataEstablecimiento"%>
<%@page import="data.DataClienteReserva"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Reserva"%>
<%@page import="data.DataReserva"%>
<%@page import="data.DataCliente"%>
<%@page import="entidades.Cliente"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp" />

<%
	if (session.getAttribute("usuario") == null) {
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	DataReserva dr = new DataReserva();
	DataClienteReserva dcr = new DataClienteReserva();
	ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	reservas = dr.reservasAcompletar();
	Cliente c = (Cliente) session.getAttribute("usuario");
	DataCliente dc = new DataCliente();
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
						
						<td  style="padding-top: 20px">
							<button type="button" class="btn btn-link btn-sm" 
								onclick="obtener_datos_jugador('<%= dc.buscarDNI(res.getDni()).getNombre() %>','<%= dc.buscarDNI(res.getDni()).getApellido() %>','<%= dc.buscarDNI(res.getDni()).getCelular() %>')">
									<a style="font-size: 15px">Ver datos del jugador</a>
							</button>
						</td>
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
	
	<div class="modal fade" id="modalInfoJugador" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content" style="border-collapse:separate;border:solid grey 2px;border-radius:6px;">
				<h5 style="text-align:center;margin:7px">Datos del jugador</h5>
				<p style="text-align:center;font-size:14px">Contactese con el jugador para obtener mas datos de la reserva</p>
				<table style="background-color:#f6f6f6;margin:15px;margin-top:-10px;border-collapse:separate;border:solid grey 1px;border-radius:6px;">
					<tr>
						<th>Nombre</th>
						<th>Apellido</th>
						<th>Telefono</th>
					</tr>
					<tr>
						<td id="datos_jugador_nombre"></td>
						<td id="datos_jugador_apellido"></td>
						<td id="datos_jugador_telefono"></td>
					</tr>
				</table>
				<p id="datos_jugador"></p>
			</div>
		</div>
	</div>
	
	
	<jsp:include page="footer.jsp" />
</body>

<script>
	function obtener_datos_jugador(nombre,apellido,telefono) {
		if ( (nombre == "null") || (apellido == "null" ) || (telefono == "null") ){
			alert('No existen datos para ese jugador');
		} else {
			console
			datos_jugador_nombre = document.getElementById('datos_jugador_nombre');
			datos_jugador_nombre.innerHTML = nombre;
			datos_jugador_apellido = document.getElementById('datos_jugador_apellido');
			datos_jugador_apellido.innerHTML = apellido;
			datos_jugador_telefono = document.getElementById('datos_jugador_telefono');
			datos_jugador_telefono.innerHTML = telefono;
			$('#modalInfoJugador').modal('show');
		}
	}
</script>


</html>