<%@page import="data.DataEstablecimiento"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Reserva"%>
<%@page import="data.DataReserva"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp" />

<%
	Reserva r = (Reserva) session.getAttribute("reserva");
	DataReserva dr = new DataReserva();
	ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	reservas = dr.reservasAcompletar();
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
		<h3>Ingresar cantidad de jugadores</h3>
		<form class="form-CantidadJugadores" action="CantidadJugadores"
			method="post">

			<div class="form-group">
				<label for="inputDni" class="control-label col-md-2">Establecimiento:</label>
				<div class="col-md-12">
					<input id="inputDni" name="dni" class="form-control" type="text"
						value="<%=r.getEstablecimiento()%>" disabled>
				</div>
			</div>

			<div class="form-group">
				<label for="inputUsuario" class="control-label col-md-2">Fecha:</label>
				<div class="col-md-12">
					<input id="inputUsuario" name="usuario" class="form-control"
						type="text" value="<%=r.getFecha()%>" disabled>
				</div>
			</div>

			<div class="form-group">
				<label for="inputPassword" class="control-label col-md-2">Hora
					inicio:</label>
				<div class="col-md-12">
					<input id="inputPassword" name="contrasena" class="form-control"
						type="text" value="<%=r.getHora_inicio()%>" disabled>
				</div>
			</div>

			<div class="form-group">
				<label for="inputNombre" class="control-label col-md-2">Numero
					de cancha:</label>
				<div class="col-md-12">
					<input id="inputNombre" name="nombre" class="form-control"
						type="text" value="<%=r.getNumero_cancha()%>" disabled>
				</div>
			</div>

			<div class="form-group">
				<label for="inputNombre" class="control-label col-md-4">Cantidad
					de jugadores:</label>
				<div class="col-md-12">
					<select class="form-control" id="cantidad" name="cantidad">
						<option value="-">-</option>
						<%
							for (int i = 1; i <= r.getLugares_disponibles(); i++) {
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