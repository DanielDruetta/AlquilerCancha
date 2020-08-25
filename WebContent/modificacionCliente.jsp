<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="entidades.Cliente"%>
<!DOCTYPE html>
<html>
<head>
<title>Futbol 5</title>
<link rel="icon"
	href="https://http2.mlstatic.com/pelota-futbol-adidas-epp-2-b-D_NQ_NP_662338-MLA29510542741_022019-F.jpg">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>

<%
	Cliente c = (Cliente) session.getAttribute("usuario");
%>

</head>

<body>

	<div class="container">
		<br />
		<h3 align="center">Modificar datos personales</h3>
		<form class="form-mcliente" action="mcliente" method="post">
			<div class="row">
				<div class="col-md-6">
					<div class="form-group col-md-12">
						<br />
						<h5>Datos actuales</h5>
					</div>

					<div class="form-group">
						<label for="inputUsuario" class="control-label col-md-2">Usuario:</label>
						<div class="col-md-12">
							<input id="inputUsuario" name="usuario" class="form-control"
								type="text" value=<%=c.getUsuario()%> disabled>
						</div>
					</div>

					<div class="form-group">
						<label for="inputPassword" class="control-label col-md-2">Password:</label>
						<div class="col-md-12">
							<input id="inputPassword" name="contrasena" class="form-control"
								type="password" value=<%=c.getPassword()%> disabled>
						</div>
					</div>

					<div class="form-group">
						<label for="inputNombre" class="control-label col-md-2">Nombre:</label>
						<div class="col-md-12">
							<input id="inputNombre" name="nombre" class="form-control"
								type="text" value=<%=c.getNombre()%> disabled>
						</div>
					</div>

					<div class="form-group">
						<label for="inputApellido" class="control-label col-md-2">Apellido:</label>
						<div class="col-md-12">
							<input id="inputApellido" name="apellido" class="form-control"
								type="text" value=<%=c.getApellido()%> disabled>
						</div>
					</div>

					<div class="form-group">
						<label for="inputEmail" class="control-label col-md-2">Email:</label>
						<div class="col-md-12">
							<input id="inputEmail" name="email" class="form-control"
								type="email" value=<%=c.getEmail()%> disabled>
						</div>
					</div>

					<div class="form-group">
						<label for="inputCelular" class="control-label col-md-2">Celular:</label>
						<div class="col-md-12">
							<input id="inputCelular" name="celular" class="form-control"
								type="number" value=<%=c.getCelular()%> disabled>
						</div>
					</div>

					<div class="form-group">
						<label for="inputDni" class="control-label col-md-2">DNI:</label>
						<div class="col-md-12">
							<input id="inputDni" name="dni" class="form-control"
								type="number" value=<%=c.getDni()%> disabled>
						</div>
					</div>

				</div>


				<div class="col-md-6">
					<div class="form-group col-md-12">
						<br />
						<h5>Datos nuevos</h5>
					</div>

					<div class="form-group">
						<label for="inputUsuario" class="control-label col-md-2">Usuario:</label>
						<div class="col-md-12">
							<input id="inputUsuario" name="usuario" class="form-control"
								type="text" placeholder="">
						</div>
					</div>

					<div class="form-group">
						<label for="inputPassword" class="control-label col-md-2">Password:</label>
						<div class="col-md-12">
							<input id="inputPassword" name="contrasena" class="form-control"
								type="password">
						</div>
					</div>

					<div class="form-group">
						<label for="inputNombre" class="control-label col-md-2">Nombre:</label>
						<div class="col-md-12">
							<input id="inputNombre" name="nombre" class="form-control"
								type="text" placeholder="">
						</div>
					</div>

					<div class="form-group">
						<label for="inputApellido" class="control-label col-md-2">Apellido:</label>
						<div class="col-md-12">
							<input id="inputApellido" name="apellido" class="form-control"
								type="text" placeholder="">
						</div>
					</div>

					<div class="form-group">
						<label for="inputEmail" class="control-label col-md-2">Email:</label>
						<div class="col-md-12">
							<input id="inputEmail" name="email" class="form-control"
								type="email" placeholder="">
						</div>
					</div>

					<div class="form-group">
						<label for="inputCelular" class="control-label col-md-2">Celular:</label>
						<div class="col-md-12">
							<input id="inputCelular" name="celular" class="form-control"
								type="number" placeholder="">
						</div>
					</div>

					<div class="form-group">
						<label for="inputDni" class="control-label col-md-2">DNI:</label>
						<div class="col-md-12">
							<input id="inputDni" name="dni" class="form-control"
								type="number" placeholder="">
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


</body>

</html>