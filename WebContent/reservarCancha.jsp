<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="entidades.Cancha"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Cliente"%>
<%@page import="entidades.Establecimiento"%>
<%@page import="data.DataEstablecimiento"%>
<!DOCTYPE html>
<html>
<head>
<style>
.map-container {
	overflow: hidden;
	padding-bottom: 56.25%;
	position: relative;
	height: 0;
}

.map-container iframe {
	left: 0;
	top: 0;
	height: 100%;
	width: 100%;
	position: absolute;
}
</style>
<jsp:include page="header.jsp" />

<%
	DataEstablecimiento de = new DataEstablecimiento();
request.getSession().setAttribute("listaEstablecimientos", de.getAll()); //esto es correcto
ArrayList<Establecimiento> es = (ArrayList<Establecimiento>) session.getAttribute("listaEstablecimientos");
%>

</head>
<body>

	<div class="container">
		<form class="form-reservar" action="reservar" method="post">

			<div class="col-md-12">
				<h3>Buscar un turno</h3>
			</div>

			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
					
					<div class="col-xs-14 col-sm-14 col-md-14 col-lg-14">
						
						<div class="col-xs-14 col-sm-14 col-md-14 col-lg-14">
							<label for="inputEstablecimiento" class="control-label col-md-2">Establecimiento:</label>
							<div class="col-md-7">
								<select class="form-control" id="inputEstablecimiento"
									name="inputEstablecimiento">
									<option class=form-control value="">-</option>

									<%
										for (Establecimiento c : es) {
									%>

									<option class=form-control value="<%=c.getNombre()%>"><%=c.getNombre()%></option>

									<%
										}
									%>
								</select>
							</div>
						</div>






						<div class="col-xs-14 col-sm-14 col-md-14 col-lg-14">
							<label for="inputTipo" class="control-label col-md-2">Tipo:</label>
							<div class="col-md-7">
								<select class="form-control" id="inputTipo" name="inputTipo">

								</select>
							</div>
						</div>





						<div class="col-xs-14 col-sm-14 col-md-14 col-lg-14"
							id="solicitar_jugadores"></div>




						<div class="col-xs-14 col-sm-14 col-md-14 col-lg-14">
							<label for="inputFecha" class="control-label col-md-2">Fecha</label>
							<div class="col-md-7">
								<input id="inputFecha" name="inputFecha" class="form-control"
									placeholder="" required="" autofocus="" type="date">
							</div>
						</div>




						<div class="col-xs-14 col-sm-14 col-md-14 col-lg-14">
							<div class="col-md-2">
								<input type="submit" class="btn btn-primary" id="act" name="act"
									value="Aceptar">
							</div>
						</div>

					</div>
				</div>
				<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
				<div id="titulo_ubicacion"></div>
					<div id="ubicacion" class="z-depth-1-half map-container"
						style="height: 500px;margin-top:20px"></div>
				</div>
			</div>
		</form>
	</div>
	<jsp:include page="footer.jsp" />
</body>

<script>
	document.getElementById('inputTipo').addEventListener('change',
			seleccionar_tipo);
	function seleccionar_tipo(event) {
		elemento = event.target;
		selecthtml = ''

		selecthtml += '<label for="inputNroJugadores" class="control-label col-md-6">Le faltan jugadores? Ingrese la cantidad abajo:</label>'
		selecthtml += '<div class="col-md-7">'
		selecthtml += '<select class="form-control" id="inputNroJugadores" name="inputNroJugadores">'
		for (i = 0; i < elemento.value * 2; i++) {

			selecthtml += '<option class=form-control value='+i+'>' + i
					+ '</option>'

		}
		selecthtml += '</select>'
		selecthtml += '</div>'
		document.getElementById('solicitar_jugadores').innerHTML = selecthtml

	}
</script>


<script>
	$('#inputEstablecimiento').on(
			'change',
			function() {

				var establecimiento = $(
						document.getElementById('inputEstablecimiento')).find(
						'option:selected').val();
				$.ajax({
					type : 'POST',
					url : '/AlquilerCancha/cargar_tipos',
					data : {
						'id' : establecimiento
					}
				}).done(function(tipos) {
					data_tipos = tipos.split('!!??')
					console.log("Data tipo 1=" + data_tipos[1])
					console.log("Data tipo 0=" + data_tipos[0])
					$('#titulo_ubicacion').html('<b>Ubicacion del establecimiento:</b> '+ establecimiento )
					$('#ubicacion').html(data_tipos[1])
					$('#inputTipo').html(data_tipos[0])
				}).fail(function() {
					alert('Hubo un error al cargar los tipos de cancha')
				})
			})
</script>
</html>