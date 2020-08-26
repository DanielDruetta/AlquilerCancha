<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="entidades.Establecimiento"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp" />
<%
	Establecimiento est = (Establecimiento) session.getAttribute("establecim");
%>

</head>

<body>
	<div class="container">
		<form class="form-BajaEstablecimientoConfirmado"
			action="BajaEstablecimientoConfirmado" method="post">
			<div class="form-group col-md-12">
				<h3>Baja Establecimiento</h3>
			</div>

			<div class="form-group">
				<label for="inputNombre" class="control-label col-md-4">Nombre del establecimiento:</label>
				<div class="col-md-10">
					<input id="inputNombre" name="nombre" class="form-control"
						type="text" value=<%=est.getNombre()%> disabled>
				</div>
			</div>

			<div class="form-group">
				<label for="inputDireccion" class="control-label col-md-4">Direccion del establecimiento:</label>
				<div class="col-md-10">
					<input id="inputNombre" name="nombre" class="form-control"
						type="text" value=<%=est.getDireccion()%> disabled>
				</div>
			</div>

			<div class="form-group">
				<label for="inputHoraInicio" class="control-label col-md-4">Hora inicio:</label>
				<div class="col-md-10">
					<input id="inputNombre" name="nombre" class="form-control"
						type="number" value=<%=est.getHora_inicio()%> disabled>
				</div>
			</div>

			<div class="form-group">
				<label for="inputHoraFin" class="control-label col-md-4">Hora fin:</label>
				<div class="col-md-10">
					<input id="inputNombre" name="nombre" class="form-control"
						type="number" value=<%=est.getHora_fin()%> disabled>
				</div>
			</div>

			<div class="form-group">
				<div class="col-md-2">
					<input type="submit" class="btn btn-primary" name="act"
						value="Eliminar">
				</div>
			</div>

		</form>
	</div>
<jsp:include page="footer.jsp" />
</body>
</html>