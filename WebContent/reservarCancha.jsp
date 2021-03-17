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
			<div class="form-group col-md-12">
				<h3>Buscar un turno</h3>
			</div>
			<div class="form-group">
				<label for="inputEstablecimiento" class="control-label col-md-2">Establecimiento:</label>
				<div class="col-md-7">
					<select class="form-control" id="inputEstablecimiento"
						name="inputEstablecimiento" onchange="set_tipos(this)">
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

			


			<%
				for (Establecimiento c : es) {
			%>
			<div style="display: none" class="form-group"
				id="seleccion_<%=c.getNombre()%>">
				<label for="inputTipo" class="control-label col-md-2">Tipo:</label>
				<div class="col-md-7">
					<select class="form-control" id="inputTipo_<%=c.getNombre()%>"
						name="<%=c.getNombre()%>" onchange="seleccionar_tipo(this)">
						<option class=form-control value="">-</option>
						<%
							ArrayList<Integer> tipos = de.tipos(c.getNombre());
						for (int i = 0; i < tipos.size(); i++) {
						%>
						<option class=form-control value=<%=tipos.get(i)%>><%=tipos.get(i)%></option>
						<%
							}
						%>
					</select>
				</div>
			</div>

			<%
				}
			%>
			<br>
			<div class="form-group">
				<label for="inputFecha" class="control-label col-md-2">Fecha</label>
				<div class="col-md-7">
					<input id="inputFecha" name="inputFecha" class="form-control"
						placeholder="" required="" autofocus="" type="date">
				</div>
			</div>
			
			<div class="form-group" id="solicitar_jugadores"></div>

			<div class="form-group">
				<div class="col-md-2">
					<input type="submit" class="btn btn-primary" id="act" name="act"
						value="Aceptar">
				</div>
			</div>
		</form>
	</div>
	<jsp:include page="footer.jsp" />
</body>

<script>
	function seleccionar_tipo(elemento) {
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
	function set_tipos(elemento) {
		var seleccionado = $(elemento).find('option:selected').val();
		var seleccion = document.getElementById('seleccion_' + seleccionado).style.display = "inline"
		var canchas = document.querySelectorAll('[id^="seleccion_"]');
		console.clear();
		canchas.forEach(function(cancha) {
			canchita = cancha.id.split("_")
			if (canchita[1] == seleccionado) {
				cancha.style.display = "inline"
			} else {
				cancha.style.display = "none"
			}
		});
		
	}
</script>
</html>