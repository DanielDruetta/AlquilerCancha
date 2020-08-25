<!DOCTYPE html>
<html>
<head>
	<jsp:include page="header.jsp" />
</head>

<body>
	<div class="container">
		<form class="form-signin" action="signin" method="post">
			<div class="form-group col-md-12">
				<h3>Iniciar sesion</h3>
			</div>
			<div class="form-group">
				<label for="inputUsuario" class="control-label col-md-2">Usuario:</label>
				<div class="col-md-10">
					<input id="inputUsuario" name="usuario" class="form-control"
						type="text" placeholder="">
				</div>
			</div>

			<div class="form-group">
				<label for="inputPassword" class="control-label col-md-2">Contraseña:</label>
				<div class="col-md-10">
					<input id="inputPassword" name="contrasena" class="form-control"
						type="password">
				</div>
			</div>

			<div class="form-group">
				<div class="col-md-2">
					<input type="submit" class="btn btn-primary" name="act"
						value="Ingresar">
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