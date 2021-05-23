<%@page import="data.DataEstablecimiento"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Reserva"%>
<%@page import="entidades.Cliente"%>
<%@page import="entidades.ClienteReserva"%>
<%@page import="data.DataClienteReserva"%>
<%@page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp" />

<%
	DataClienteReserva dcr = new DataClienteReserva();
	Reserva rm = (Reserva) session.getAttribute("reservamodificar");
	Cliente c = (Cliente) session.getAttribute("usuario");
	ClienteReserva cr = (ClienteReserva) session.getAttribute("clientereserva");
	String strDateFormat = "dd-MM-yyyy";
	SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
%>
</head>
<body>
	<div class="container">
		<h3>Modificar cantidad de jugadores</h3>
		<form class="form-ModificarCompletarPartidoConfirmar"
			action="modificar_completar_partido" method="post">

			<div class="form-group">
				<label for="inputDni" class="control-label col-md-2">Establecimiento:</label>
				<div class="col-md-12">
					<input id="inputDni" name="dni" class="form-control" type="text"
						value="<%=rm.getEstablecimiento()%>" disabled>
				</div>
			</div>

			<div class="form-group">
				<label for="inputUsuario" class="control-label col-md-2">Fecha:</label>
				<div class="col-md-12">
					<input id="inputUsuario" name="usuario" class="form-control"
						type="text" value="<%=objSDF.format(rm.getFecha())%>" disabled>
				</div>
			</div>

			<div class="form-group">
				<label for="inputPassword" class="control-label col-md-2">Hora
					inicio:</label>
				<div class="col-md-12">
					<input id="inputPassword" name="contrasena" class="form-control"
						type="text" value="<%=rm.getHora_inicio()%>" disabled>
				</div>
			</div>

			<div class="form-group">
				<label for="inputNombre" class="control-label col-md-2">Numero
					de cancha:</label>
				<div class="col-md-12">
					<input id="inputNombre" name="nombre" class="form-control"
						type="number" value="<%=rm.getNumero_cancha()%>" disabled>
				</div>
			</div>

			<div class="form-group">
				<label for="inputNombre" class="control-label col-md-6">Cantidad
					de jugadores restantes por completar al partido:</label>
				<div class="col-md-12">
					<input id="inputNombre" name="nombre" class="form-control"
						type="number" value="<%=rm.getLugares_disponibles()%>" disabled>
				</div>
			</div>

			<div class="form-group">
				<label for="inputNombre" class="control-label col-md-6">Cantidad
					actual de jugadores aportados al partido</label>
				<div class="col-md-12">
					<input id="CantJugadoresAportados" name="CantJugadoresAportados"
						class="form-control" type="number"
						value="<%=cr.getCantidad_jugadores()%>" disabled> <input
						type="hidden" id="nrores" name="nrores" class="form-control"
						value="<%=rm.getNumero_reserva()%>">
				</div>
			</div>


			<div class="form-group">
				<label for="inputNombre" class="control-label col-md-6">Nueva
					cantidad de jugadores aportado al partido</label>
				<div class="col-md-12">
					<select class="form-control" id="cantidad" name="cantidad">
						<option>-</option>
						<%
							for (int i = 0; i <= rm.getLugares_disponibles() + cr.getCantidad_jugadores(); i++) {

								// lugares disponibles (de la reserva) = cantidad_jugadores (de cliente_reserva) - name="cantidad"
						%>
						<option class=form-control value="<%=i%>"><%=i%></option>

						<%
							}
						%>
					</select>
				</div>
			</div>

			<div class="form-group">
				<div class="col-md-2">
					<input type="submit" class="btn btn-primary" name="act"
						value="Aceptar">
				</div>
			</div>


		</form>
	</div>
	<jsp:include page="footer.jsp" />

</body>
</html>