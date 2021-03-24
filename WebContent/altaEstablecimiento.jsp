<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="entidades.Establecimiento"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Cliente"%>
<%@page import="entidades.Administrador"%>
<!DOCTYPE html>
<html>
<head>

<jsp:include page="header.jsp" />
<%
	if (session.getAttribute("administrador") == null) {
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
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
		<form class="form-altaestablecimiento" action="AltaEstablecimiento"
			method="post">
			<div class="form-group col-md-12">
				<h3>Alta establecimiento</h3>
			</div>

			<div class="form-group">
				<label for="inputNombre" class="control-label col-md-4">Nombre
					del establecimiento:</label>
				<div class="col-md-10">
					<input id="inputNombre" name="nombre" class="form-control"
						type="text">
				</div>
			</div>

			<div class="form-group">
				<label for="inputDireccion" class="control-label col-md-4">Direccion
					del establecimiento:</label>
				<div class="col-md-10">
					<input id="inputDireccion" name="direccion" class="form-control"
						type="text">
				</div>
			</div>

			<div class="form-group">
				<label for="inputUsuario" class="control-label col-md-4">Usuario:</label>
				<div class="col-md-10">
					<input id="inputUsuario" name="usuario" class="form-control"
						type="text">
				</div>
			</div>

			<div class="form-group">
				<label for="inputContraseña" class="control-label col-md-4">Contraseña:</label>
				<div class="col-md-10">
					<input id="inputContraseña" name="contraseña" class="form-control"
						type="text">
				</div>
			</div>

			<div class="form-group">
				<label href="#" data-toggle="tooltip" data-html="true"
					title="<img src='imagenes/gif_tutorial.gif' alt='En caso de dudas comunicarse con Daniel.'>"
					for="inputHoraInicio" class="control-label col-md-4"> URL
					de Google Maps: </label>
				<div class="col-md-10">
					<input id="inputUrlMapa" name="urlMapa" class="form-control"
						type="text">
				</div>
			</div>

			<div class="form-group">
				<label for="inputHoraInicio" class="control-label col-md-4">Hora
					inicio:</label>
				<div class="col-md-10">
					<select class="form-control" id="inputHoraInicio"
						name="inputHoraInicio">
						<%
							for (int hi = 0; hi <= 23; hi++) {
						%>

						<option class=form-control value="<%=Integer.toString(hi)%>"><%=Integer.toString(hi)%></option>

						<%
							}
						%>
					</select>
				</div>
			</div>

			<div class="form-group">
				<label for="inputHoraFin" class="control-label col-md-2">Hora
					fin:</label>
				<div class="col-md-10">
					<select class="form-control" id="inputHoraFin" name="inputHoraFin">
						<%
							for (int hf = 0; hf <= 23; hf++) {
						%>

						<option class=form-control value="<%=Integer.toString(hf)%>"><%=Integer.toString(hf)%></option>

						<%
							}
						%>
					</select>
				</div>
			</div>

			<div class="form-group">
				<div class="col-md-2">
					<input type="submit" class="btn btn-primary" name="act"
						value="Aceptar" onclick="verificacion()">
				</div>
			</div>
		</form>
	</div>
	<jsp:include page="footer.jsp" />
</body>

<script>
	$(document).ready(function() {
		$('[data-toggle="tooltip"]').tooltip();
	});

	function verificacion() {
		var nombre = document.getElementById('inputNombre');
		var direccion = document.getElementById('inputDireccion');
		var urlMapa = document.getElementById('inputUrlMapa');
		var usuario = document.getElementById('inputUsuario');
		var contraseña = document.getElementById('inputContraseña');
		var horaInicio = document.getElementById('inputHoraInicio');
		var horaFin = document.getElementById('inputHoraFin');

		if ((nombre.value == "") || (direccion.value == "")
				|| (urlMapa.value == "") || (usuario.value == "")
				|| (contraseña.value == "") || (horaInicio.value == "")
				|| (horaFin.value == "")) {
			alert("Existen campos vacios");
			return false;
		}
	}
</script>
</html>