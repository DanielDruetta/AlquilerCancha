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
		<h3 align="center">Modificar Establecimiento</h3>
		<form class="form-ModificacionEstablecimientoConfirmado"
			action="ModificacionEstablecimientoConfirmado" method="post">
			<div class="row">
				<div class="col-md-6">
					<div class="form-group col-md-12">
						<br />
						<h3>Datos actuales</h3>
					</div>

					<div class="form-group">
						<label for="inputNombre" class="control-label col-md-6">Nombre
							del establecimiento:</label>
						<div class="col-md-12">
							<input id="inputNombre" name="nombre" class="form-control"
								type="text" value=<%=est.getNombre()%> disabled>
						</div>
					</div>

					<div class="form-group">
						<label for="inputDireccion" class="control-label col-md-6">Direccion
							del establecimiento:</label>
						<div class="col-md-12">
							<input id="inputDireccion" name="direccion" class="form-control"
								type="text" value=<%=est.getDireccion()%> disabled>
						</div>
					</div>

					<div class="form-group">
						<label for="inputUsuario" class="control-label col-md-6">Usuario:</label>
						<div class="col-md-12">
							<input id="inputUsuario" name="usuario" class="form-control"
								type="text" value=<%=est.getUsuario()%> disabled>
						</div>
					</div>

					<div class="form-group">
						<label for="inputContraseña" class="control-label col-md-6">Contraseña:</label>
						<div class="col-md-12">
							<input id="inputContraseña" name="contraseña"
								class="form-control" type="password"
								value=<%=est.getContraseña()%> disabled>
						</div>
					</div>

					<div class="form-group">
						<label for="inputHoraInicio" class="control-label col-md-6">Hora
							inicio:</label>
						<div class="col-md-12">
							<input id="inputHoraInicio" name="horaInicio"
								class="form-control" type="number"
								value=<%=est.getHora_inicio()%> disabled>
						</div>
					</div>


					<div class="form-group">
						<label for="inputHoraFin" class="control-label col-md-6">Hora
							fin:</label>
						<div class="col-md-12">
							<input id="inputHoraFin" name="horaFin" class="form-control"
								type="number" value=<%=est.getHora_fin()%> disabled>
						</div>
					</div>



				</div>

				<div class="col-md-6">
					<div class="form-group col-md-12">
						<br />
						<h3>Datos Nuevos</h3>
					</div>

					<div class="form-group">
						<label for="inputNombre" class="control-label col-md-6">Nombre
							del establecimiento:</label>
						<div class="col-md-12">
							<input id="inputNombre" name="nombre" class="form-control"
								type="text">
						</div>
					</div>

					<div class="form-group">
						<label for="inputDireccion" class="control-label col-md-6">Direccion
							del establecimiento:</label>
						<div class="col-md-12">
							<input id="inputDireccion" name="direccion" class="form-control"
								type="text">
						</div>
					</div>

					<div class="form-group">
						<label for="inputUsuario" class="control-label col-md-6">Usuario:</label>
						<div class="col-md-12">
							<input id="inputUsuario" name="usuario" class="form-control"
								type="text">
						</div>
					</div>

					<div class="form-group">
						<label for="inputContraseña" class="control-label col-md-6">Contraseña:</label>
						<div class="col-md-12">
							<input id="inputContraseña" name="contraseña"
								class="form-control" type="text">
						</div>
					</div>

					<div class="form-group">
						<label for="inputHoraInicio" class="control-label col-md-6">Hora
							inicio:</label>
						<div class="col-md-12">

							<select id="inputHoraInicio" name="inputHoraInicio">
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
				</div>
			</div>
		</form>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>