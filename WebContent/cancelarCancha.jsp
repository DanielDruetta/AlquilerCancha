<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="entidades.Cancha"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Cliente"%>
<%@page import="entidades.Establecimiento"%>
<%@page import="entidades.Reserva"%>
<%@page import="data.DataReserva"%>
<%@page import="data.DataCancha"%>
<%@page import="data.DataClienteReserva"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp" />
<%
	Cliente c = (Cliente) session.getAttribute("usuario");
	DataReserva dr = new DataReserva();
	ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	reservas = dr.reservasCliente(c.getDni());
	DataClienteReserva dcr = new DataClienteReserva();
	DataCancha dc = new DataCancha();
%>

</head>
<body>
	<div class="container">
		<%
			if (request.getAttribute("mensajeError") != null) {
		%>
		<div class="alert alert-danger" role="alert">
			<%=request.getAttribute("mensajeError")%>
		</div>
		<%
			}
		%>
		<h3>Reservas vigentes</h3>
		<p>Recuerde que no podra cancelar una reserva donde se hayan unido
			otros jugadores</p>
		<form class="form-cancelarReserva" action="CancelarReserva"
			method="post">
			<div class="row" style="width: 1200px">
				<div class="col-12 col-sm-12 col-lg-12">
					<div class="table-responsive">
						<table class="table">
							<thead>
								<tr>
									<th>Fecha del partido</th>
									<th>Hora del partido</th>
									<th>Establecimiento</th>
									<th>Numero de cancha</th>
									<th></th>
									<th></th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<%
									for (Reserva disp : reservas) {
								%>
								<tr>
									<td><%=disp.getFecha()%></td>
									<td><%=disp.getHora_inicio()%></td>
									<td><%=disp.getEstablecimiento()%></td>
									<td><%=disp.getNumero_cancha()%></td>

									<%
										if (dcr.tiene_jugadores_unidos(disp.getNumero_reserva())) {
									%>
									<td>
										<button type="submit" class="btn btn-danger" name="seleccion"
											value=<%=String.valueOf(disp.getNumero_reserva())%>>Cancelar
											reserva</button>
									</td>
									<%
										} else {
									%>
									<td></td>
									<%
										}
									%>
									<td id="boton_solicitar_<%=disp.getNumero_reserva()%>"
										style="display: block"><a
										id="botonsolicitar_<%=disp.getNumero_reserva()%>"
										class="btn btn-secondary" style="color: white"
										onclick="solicitar_jugadores('<%=disp.getNumero_reserva()%>')">Solicitar
											jugadores</a> <a
										id="respuesta_solicitar_<%=disp.getNumero_reserva()%>"
										style="font-size: 13px"></a></td>

									<td style="display: none"
										id="solicitar_jugadores_<%=disp.getNumero_reserva()%>">
										<div style="display: flex; margin-left: 31px">
											<div style="float: left">
												<select class="form-control"
													id="inputLugares_<%=disp.getNumero_reserva()%>"
													name="inputLugares">
													<%
														for (int i = 1; i <= (dc.tipoSegunNroCancha(disp.getNumero_cancha(), disp.getEstablecimiento())) * 2 - 1
																	- dcr.cantidad_jugadores_unidos(disp.getNumero_reserva()); i++) {
													%>
													<option class=form-control value=<%=i%>><%=i%></option>
													<%
														}
													%>
												</select>
											</div>
											<div style="float: left; margin-left: 7px; margin-top: 4px"
												id="botones_<%=disp.getNumero_reserva()%>">
												<a class="btn btn-success btn-sm"
													onclick="ingresar_cantidad('<%=disp.getNumero_reserva()%>')">
													OK</a> <a id="boton_cerrar_<%=disp.getNumero_reserva()%>"
													class="btn btn-danger btn-sm" style="width: 35px"
													onclick="cancelar('<%=disp.getNumero_reserva()%>')"> X</a>
											</div>
										</div>
									</td>
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
<script>
	function cancelar(reserva) {
		document.getElementById('solicitar_jugadores_' + reserva).style.display = 'none';
		document.getElementById('boton_solicitar_' + reserva).style.display = 'block';
		document.getElementById('boton_solicitar_' + reserva).style.display = 'block';
		document.getElementById('boton_solicitar_' + reserva).style.display = 'block';
		document.getElementById('botones_' + reserva).style.display = 'block';

	}

	function solicitar_jugadores(reserva) {
		document.getElementById('solicitar_jugadores_' + reserva).style.display = 'block';
		document.getElementById('boton_solicitar_' + reserva).style.display = 'none';

		//if (document.getElementById('solicitar_jugadores_'+reserva).style.display == 'block') {
		//	document.getElementById('solicitar_jugadores_'+reserva).style.display = 'none';

		//} else {
		//	document.getElementById('solicitar_jugadores_'+reserva).style.display = 'block';
		//}

	}
	function ingresar_cantidad(reserva) {
		var cantidad = document.getElementById('inputLugares_' + reserva).value;
		console.log(reserva)
		console.log(cantidad)
		$
				.post('/AlquilerCancha/ingresar_jugadores', {
					reserva : reserva,
					cantidad : cantidad
				})
				.done(
						function() {
							console.log("Se ejecuto correctamente");
							document.getElementById('boton_cerrar_' + reserva)
									.click();
							document
									.getElementById('botonsolicitar_' + reserva).style.display = 'none';
							document.getElementById('respuesta_solicitar_'
									+ reserva).style.color = "green";
							document.getElementById('respuesta_solicitar_'
									+ reserva).innerHTML = "Se solicitaron correctamente los jugadores";
							setTimeout(function() {
								document.getElementById('respuesta_solicitar_'
										+ reserva).innerHTML = "";
								document.getElementById('botonsolicitar_'
										+ reserva).style.display = 'inline';
							}, 2500);
						})
				.fail(
						function() {
							console.log("No se ejecuto correctamente");
							document.getElementById('boton_cerrar_' + reserva)
									.click();
							document
									.getElementById('botonsolicitar_' + reserva).style.display = 'none';
							document.getElementById('respuesta_solicitar_'
									+ reserva).style.color = "red";
							document.getElementById('respuesta_solicitar_'
									+ reserva).innerHTML = "No se solicitaron correctamente los jugadores";
							setTimeout(function() {
								document.getElementById('respuesta_solicitar_'
										+ reserva).innerHTML = "";
								document.getElementById('botonsolicitar_'
										+ reserva).style.display = 'inline';
							}, 2500);
						});

	}
</script>
</html>