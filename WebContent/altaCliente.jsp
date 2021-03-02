<!DOCTYPE html>
<html>
<head>
	<jsp:include page="header.jsp" />
</head>
<body>
	<div class="container">
		<form class="form-alta" action="alta" method="post">
			<div class="form-group col-md-12">
				<h3>Registrarse</h3>
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
						value="Registrarse" onclick="verificacion()">
				</div>
			</div>
		</form>
	</div>
	<jsp:include page="footer.jsp" />
</body>
<script>

var inputdni = document.getElementById('inputDni');
var celular = document.getElementById('inputCelular');
var nombre = document.getElementById('inputNombre');
var apellido = document.getElementById('inputApellido');

function onkeyPress(event){
    if ((inputdni.value.length > 8) || (celular.value.length > 10)) {
  	  	inputdni.value = inputdni.value.slice(0, 8);
  	  	celular.value = celular.value.slice(0, 10);
    }
    inputdni.value = inputdni.value.replace(/[^0-9]+/gi, '').replace(/ $/, '');
    nombre.value = nombre.value.replace(/[^a-z]+/gi, '').replace(/ $/, '');
    apellido.value = apellido.value.replace(/[^a-z]+/gi, '').replace(/ $/, '');
}

inputdni.addEventListener('keypress',onkeyPress);
inputdni.addEventListener('keydown',onkeyPress);
inputdni.addEventListener('keyup',onkeyPress);
celular.addEventListener('keypress',onkeyPress);
celular.addEventListener('keydown',onkeyPress);
celular.addEventListener('keyup',onkeyPress);
nombre.addEventListener('keypress',onkeyPress);
nombre.addEventListener('keydown',onkeyPress);
nombre.addEventListener('keyup',onkeyPress);
apellido.addEventListener('keypress',onkeyPress);
apellido.addEventListener('keydown',onkeyPress);
apellido.addEventListener('keyup',onkeyPress);

function verificacion(){
	var inputdni = document.getElementById('inputDni');
	var celular = document.getElementById('inputCelular');
	var nombre = document.getElementById('inputNombre');
	var usuario = document.getElementById('inputUsuario');
	var password = document.getElementById('inputPassword');
	var email = document.getElementById('inputEmail');
	var apellido = document.getElementById('inputApellido');

	if ((inputdni.value == "") || (celular.value == "")|| (nombre.value == "")|| (usuario.value == "") || (password.value == "")|| (email.value == "")|| (apellido.value == "")){
		alert("Existen campos vacios");
		return false;
	}

}	

</script>
</html>

