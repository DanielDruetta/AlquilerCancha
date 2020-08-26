<!DOCTYPE html>
<html>
<head>
	<jsp:include page="header.jsp" />
</head>

<body>
	<div class="container">
		<form class="form-bajacliente" action="BajaCliente" method="post">
			<div class="form-group col-md-12">
				<h3>Baja cliente</h3>
			</div>
			<div class="form-group">
				<label for="inputUsuario" class="control-label col-md-2">Nombre:</label>
				<div class="col-md-10">
					<input id="inputUsuario" name="nombre" class="form-control"
						type="text" placeholder="">
				</div>
			</div>

			<div class="form-group">
				<label for="inputPassword" class="control-label col-md-2">Apellido:</label>
				<div class="col-md-10">
					<input id="inputPassword" name="apellido" class="form-control"
						type="text">
				</div>
			</div>

			<div class="form-group">
				<div class="col-md-2">
					<input type="submit" class="btn btn-primary" name="act"
						value="Eliminar usuario">
				</div>
			</div>
		</form>


	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>