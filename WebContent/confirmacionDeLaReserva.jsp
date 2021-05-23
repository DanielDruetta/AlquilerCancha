<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="entidades.Cancha"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Ocupada"%>
<%@page import="entidades.Establecimiento"%>
<%@page import="data.DataEstablecimiento"%>
<%@page import="data.DataPrecio"%>
<%@page import="entidades.Reserva"%>
<%@page import="java.sql.Time"%>
<%@page import= "java.text.SimpleDateFormat" %>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp" />
<%
	Establecimiento es = (Establecimiento) session.getAttribute("establecimiento");
	Reserva r = (Reserva) session.getAttribute("reserva");

	DataPrecio dp = new DataPrecio();
	String strDateFormat = "dd-MM-yyyy";
	SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
%>

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

		<%
			if (request.getAttribute("mensajeOk") != null) {
		%>
		<div class="alert alert-success" role="alert">
			<%=request.getAttribute("mensajeOk")%>
		</div>
		<%
			}
		%>
		<div class="form-group col-md-12">
			<h3>Datos de la reserva</h3>
		</div>
		<div class="form-group">
			<label for="inputFecha" class="control-label col-md-4">Numero
				de reserva</label>
			<div class="col-md-7">
				<input id="inputFecha" name="inputFecha" class="form-control"
					placeholder="" required="" autofocus="" type="text"
					value="<%=r.getNumero_reserva()%>" disabled>
			</div>
		</div>

		<div class="form-group">
			<label for="inputFecha" class="control-label col-md-4">Establecimiento</label>
			<div class="col-md-7">
				<input id="inputFecha" name="inputFecha" class="form-control"
					placeholder="" required="" autofocus="" type="text"
					value="<%=r.getEstablecimiento()%>" disabled>
			</div>
		</div>

		<div class="form-group">
			<label for="inputFecha" class="control-label col-md-4">Fecha
				del partido</label>
			<div class="col-md-7">
				<input id="inputFecha" name="inputFecha" class="form-control"
					placeholder="" required="" autofocus="" type="text"
					value="<%=objSDF.format(r.getFecha())%>" disabled>
			</div>
		</div>

		<div class="form-group">
			<label for="inputFecha" class="control-label col-md-4">Hora
				inicio del partido</label>
			<div class="col-md-7">
				<input id="inputFecha" name="inputFecha" class="form-control"
					placeholder="" required="" autofocus="" type="text"
					value="<%=r.getHora_inicio()%>" disabled>
			</div>
		</div>

		<div class="form-group">
			<label for="inputFecha" class="control-label col-md-4">Hora
				fin del partido</label>
			<div class="col-md-7">
				<input id="inputFecha" name="inputFecha" class="form-control"
					placeholder="" required="" autofocus="" type="text"
					value="<%=r.getHora_inicio() + 1%>" disabled>
			</div>
		</div>

		<div class="form-group">
			<label for="inputFecha" class="control-label col-md-4">Numero
				de cancha</label>
			<div class="col-md-7">
				<input id="inputFecha" name="inputFecha" class="form-control"
					placeholder="" required="" autofocus="" type="text"
					value="<%=r.getNumero_cancha()%>" disabled>
			</div>
		</div>

		<div class="form-group">
			<label for="inputPrecio" class="control-label col-md-4">Precio
				de la reserva</label>
			<div class="col-md-7">
				<input id="inputPrecio" name="inputPrecio" class="form-control"
					placeholder="" required="" autofocus="" type="text"
					value="<%=dp.obtenerPrecio(es.getNombre(), r.getNumero_cancha()).getPrecio()%>"
					disabled>
			</div>
		</div>

		<div class="form-group">
			<label for="inputFecha" class="control-label col-md-4">Jugadores
				que necesita el partido</label>
			<div class="col-md-7">
				<input id="inputLugaresDisponibles" name="inputLugaresDisponibles"
					class="form-control" placeholder="" required="" autofocus=""
					type="text" value="<%=r.getLugares_disponibles()%>" disabled>
			</div>
		</div>

	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>