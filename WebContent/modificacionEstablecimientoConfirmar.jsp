<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="entidades.Establecimiento"%>
<%@page import="data.DataEstablecimiento"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp" />

<%
	Establecimiento est = (Establecimiento) session.getAttribute("establec");
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
				<label for="inputUsuario" class="control-label col-md-6">Usuario:</label>
				<div class="col-md-12">
					<input id="inputUsuario" name="usuario" class="form-control"
						type="text" value="<%=est.getUsuario()%>">
				</div>
			</div>

			<div class="form-group">
				<label for="inputContrase�a" class="control-label col-md-6">Contrase�a:</label>
				<div class="col-md-12">
					<input id="inputContrase�a" name="contrase�a" class="form-control"
						type="password" value="<%=est.getContrase�a()%>">
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
						value="Modificar">
				</div>
			</div>
		</form>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>