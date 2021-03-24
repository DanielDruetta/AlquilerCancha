<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="entidades.Establecimiento"%>
<%@page import="data.DataEstablecimiento"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp" />

<%
	if ((session.getAttribute("administrador") == null) && (session.getAttribute("establec") == null)) {
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	Establecimiento est;
	if (session.getAttribute("establec") != null) {
		est = (Establecimiento) session.getAttribute("establec");
	} else {
		est = (Establecimiento) session.getAttribute("establec_modificar");
	}
%>

</head>
<body>

	<div class="container">
		<form class="form-ModificacionEstablecimientoConfirmado"
			action="ModificacionEstablecimientoConfirmado" method="post">
			<div class="form-group col-md-12">
				<h3>Modificar Establecimiento</h3>
			</div>

			<div class="form-group">
				<label for="inputNombre" class="control-label col-md-6">Nombre
					del establecimiento:</label>
				<div class="col-md-12">
					<input id="inputNombre" name="nombre" class="form-control"
						type="text" value="<%=est.getNombre()%>">
				</div>
			</div>

			<div class="form-group">
				<label for="inputDireccion" class="control-label col-md-6">Direccion
					del establecimiento:</label>
				<div class="col-md-12">
					<input id="inputDireccion" name="direccion" class="form-control"
						type="text" value="<%=est.getDireccion()%>">
				</div>
			</div>

			<div class="form-group">
				<label for="inputUrlMapa" class="control-label col-md-6">URL
					del mapa en google maps:</label>
				<div class="col-md-12">
					<input id="inputUrlMapa" name="urlMapa" class="form-control"
						type="text" value="<%=est.getUrl_mapa()%>">
				</div>
			</div>

			<div class="form-group">
				<label for="inputUsuario" class="control-label col-md-6">Usuario:</label>
				<div class="col-md-12">
					<input id="inputUsuario" name="usuario" class="form-control"
						type="text" value="<%=est.getUsuario()%>">
				</div>
			</div>

			<div class="form-group">
				<label for="inputContraseña" class="control-label col-md-6">Contraseña:</label>
				<div class="col-md-12">
					<input id="inputContraseña" name="contraseña" class="form-control"
						type="password" value="<%=est.getContraseña()%>">
				</div>
			</div>

			<div class="form-group">
				<label for="inputHoraInicio" class="control-label col-md-6">Hora
					inicio:</label>
				<div class="col-md-12">
					<select id="inputHoraInicio" name="inputHoraInicio">
						<option class=form-control
							value="<%=Integer.toString(est.getHora_inicio())%>"
							selected="selected"><%=est.getHora_inicio()%></option>
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
				<label for="inputHoraFin" class="control-label col-md-6">Hora
					fin:</label>
				<div class="col-md-12">
					<select id="inputHoraFin" name="inputHoraFin">
						<option class=form-control
							value="<%=Integer.toString(est.getHora_fin())%>"
							selected="selected"><%=est.getHora_fin()%></option>
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
						value="Modificar" onclick="verificacion()">
				</div>
			</div>
		</form>
	</div>
	<jsp:include page="footer.jsp" />
</body>
<script>
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