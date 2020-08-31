<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="entidades.Cliente"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp" />
<%
	Cliente c = (Cliente) session.getAttribute("usuario");
%>
</head>

<body>
	<div class="container">
		<h3 align="center">Modificar datos personales</h3>
		<form class="form-mcliente" action="mcliente" method="post">
			<div class="form-group col-md-12">
				<h5>Datos actuales</h5>
			</div>

			<div class="form-group">
				<label for="inputDni" class="control-label col-md-2">DNI:</label>
				<div class="col-md-12">
					<input id="inputDni" name="dni" class="form-control" type="number"
						value="<%=c.getDni()%>">
				</div>
			</div>

			<div class="form-group">
				<label for="inputUsuario" class="control-label col-md-2">Usuario:</label>
				<div class="col-md-12">
					<input id="inputUsuario" name="usuario" class="form-control"
						type="text" value="<%=c.getUsuario()%>">
				</div>
			</div>

			<div class="form-group">
				<label for="inputPassword" class="control-label col-md-2">Password:</label>
				<div class="col-md-12">
					<input id="inputPassword" name="contrasena" class="form-control"
						type="password" value="<%=c.getPassword()%>">
				</div>
			</div>

			<div class="form-group">
				<label for="inputNombre" class="control-label col-md-2">Nombre:</label>
				<div class="col-md-12">
					<input id="inputNombre" name="nombre" class="form-control"
						type="text" value="<%=c.getNombre()%>">
				</div>
			</div>

			<div class="form-group">
				<label for="inputApellido" class="control-label col-md-2">Apellido:</label>
				<div class="col-md-12">
					<input id="inputApellido" name="apellido" class="form-control"
						type="text" value="<%=c.getApellido()%>">
				</div>
			</div>

			<div class="form-group">
				<label for="inputEmail" class="control-label col-md-2">Email:</label>
				<div class="col-md-12">
					<input id="inputEmail" name="email" class="form-control"
						type="email" value="<%=c.getEmail()%>">
				</div>
			</div>

			<div class="form-group">
				<label for="inputCelular" class="control-label col-md-2">Celular:</label>
				<div class="col-md-12">
					<input id="inputCelular" name="celular" class="form-control"
						type="number" value="<%=c.getCelular()%>">
				</div>
			</div>

			<div class="form-group">
				<div class="col-md-2">
					<input type="submit" class="btn btn-primary" name="act" value="Modificar">
				</div>
			</div>
		</form>
	</div>

	<jsp:include page="footer.jsp" />
</body>

</html>