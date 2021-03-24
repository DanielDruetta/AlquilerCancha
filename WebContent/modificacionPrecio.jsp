<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="entidades.Establecimiento"%>
<%@page import="data.DataEstablecimiento"%>
<%@page import="data.DataPrecio"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Cliente"%>
<%@page import="entidades.Precio"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="header.jsp" />

<%
	Establecimiento e = (Establecimiento) session.getAttribute("establec");
	if (e == null) {
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	DataEstablecimiento de = new DataEstablecimiento();
	ArrayList<Integer> canchas = new ArrayList<Integer>();
	canchas = de.canchas(e.getNombre());
	DataPrecio dp = new DataPrecio();
	ArrayList<Precio> precios = new ArrayList<Precio>();
%>

</head>


<body>
	<div class="container">
		<form class="form-modificacionprecio" action="ModificacionPrecio"
			method="post">
			<div class="form-group col-md-12">
				<h3>Modificacion precio</h3>
			</div>

			<div class="form-group">
				<label for="inputEstablecimiento" class="control-label col-md-4">Numero
					de cancha:</label>
				<div class="col-md-7">
					<select class="form-control col-md-4" id="inputEstablecimiento"
						name="inputEstablecimiento" onchange="get_precio(this)">
						<option class=form-control value="">Seleccione una cancha</option>
						<%
							for (Integer nro : canchas) {
						%>

						<option class=form-control value="<%=nro%>"><%=nro%></option>

						<%
							}
						%>
					</select>
				</div>
				
				<div class="form-group">
				<label id="precio_anterior" class="control-label col-md-4"></label> </div>
				
			</div>
			
			


			<div class="form-group">
				<label for="inputPrecio" class="control-label col-md-4">Nuevo
					precio:</label>
				<div class="col-md-3">
					<input id="inputPrecio" name="inputPrecio" class="form-control"
						type="number" step="0.01">
				</div>
			</div>
			<div class="form-group">
				<div class="col-md-2">
					<input type="submit" class="btn btn-primary" name="act"
						value="Aceptar">
				</div>
			</div>
		</form>
	</div>
	<jsp:include page="footer.jsp" />
</body>

<script>

	function get_precio(elemento) {
		var nro_cancha = elemento.value;

		$.ajax({
			type : 'POST',
			url : '/AlquilerCancha/CargarPrecio',
			data : {
				'nro_cancha' : nro_cancha
			}
		}).done(
				function(respuesta) {
					 precio = respuesta.match(/\d+/)[0]
					$('#precio_anterior').html('<a> El precio actual de la cancha es: $ ' + precio + '</a>')
				}).fail(function() {
					$('#precio_anterior').html("<a>Error al cargar el precio de la cancha.</a>")
		})

	}
</script>
</html>
