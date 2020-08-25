<!DOCTYPE html>
<html>
<head>
	<jsp:include page="header.jsp" />
</head>
<body>
	<div class="container">
		<form class="form-alta" action="alta" method="post">
			<div class="form-group col-md-12">
				<h3>Alta cliente</h3>
			</div>

			<div class="form-group">
				<label for="inputUsuario" class="control-label col-md-2">Usuario:</label>
				<div class="col-md-10">
					<input id="inputUsuario" name="usuario" class="form-control"
						type="text" placeholder="">
				</div>
			</div>

			<div class="form-group">
				<label for="inputPassword" class="control-label col-md-2">Password:</label>
				<div class="col-md-10">
					<input id="inputPassword" name="contrasena" class="form-control"
						type="password">
				</div>
			</div>

			<div class="form-group">
				<label for="inputNombre" class="control-label col-md-2">Nombre:</label>
				<div class="col-md-10">
					<input id="inputNombre" name="nombre" class="form-control"
						type="text" placeholder="">
				</div>
			</div>

			<div class="form-group">
				<label for="inputApellido" class="control-label col-md-2">Apellido:</label>
				<div class="col-md-10">
					<input id="inputApellido" name="apellido" class="form-control"
						type="text" placeholder="">
				</div>
			</div>

			<div class="form-group">
				<label for="inputEmail" class="control-label col-md-2">Email:</label>
				<div class="col-md-10">
					<input id="inputEmail" name="email" class="form-control"
						type="email" placeholder="">
				</div>
			</div>

			<div class="form-group">
				<label for="inputCelular" class="control-label col-md-2">Celular:</label>
				<div class="col-md-10">
					<input id="inputCelular" name="celular" class="form-control"
						type="number" placeholder="">
				</div>
			</div>

			<div class="form-group">
				<label for="inputDni" class="control-label col-md-2">DNI:</label>
				<div class="col-md-10">
					<input id="inputDni" name="dni" class="form-control" type="number"
						placeholder="">
				</div>
			</div>

			<div class="form-group">
				<div class="col-md-2">
					<input type="submit" class="btn btn-primary" name="act"
						value="Registrarse">
				</div>
			</div>
		</form>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>