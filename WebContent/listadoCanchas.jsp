<%@page import="data.DataEstablecimiento"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Ocupada"%>
<%@page import="entidades.Establecimiento"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp" />

<%
	DataEstablecimiento de = new DataEstablecimiento();
ArrayList<Establecimiento> establecimientos = new ArrayList<Establecimiento>();
establecimientos = de.getAll();
ArrayList<Integer> tipos = new ArrayList<Integer>();
%>
</head>

<body>
	<div class="container">
		<h3>Listado de canchas</h3>

		<table class="table">
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Tipos de cancha</th>
					<th>Dirección</th>
					<th>Hora inicio</th>
					<th>Hora fin</th>
					<th></th>
				</tr>
			</thead>

			<tbody>
				<%
					for (Establecimiento est : establecimientos) {
					tipos = de.tipos(est.getNombre());
				%>
				<tr>
					<td><%=est.getNombre()%></td>
					<td>
						<%
							for (Integer t : tipos) {
						%> <a> <%=t%>
					</a> <%
 	}
 %>
					</td>
					<td><%=est.getDireccion()%></td>
					<td><%=est.getHora_inicio()%></td>
					<td><%=est.getHora_fin()%></td>
					<td><button class="btn btn-link btn-sm"
							onclick="obtener_ubicacion('<%=est.getUrl_mapa()%>')">
							<a style="font-size: 15px">Ver ubicación</a>
						</button></td>
				</tr>

				<%
					}
				%>

			</tbody>
		</table>

	</div>

	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<iframe id="frame_ubicacion" class="iframe" height="600"
					frameborder="0" style="border: 0" allowfullscreen></iframe>
			</div>
		</div>
	</div>


	<jsp:include page="footer.jsp" />
</body>
<script>
	function obtener_ubicacion(url) {

		if (url == "null") {
			alert('No esta la ubicacion del establecimiento cargada');
		} else {
			frame = document.getElementById('frame_ubicacion');
			frame.setAttribute("src", url);
			$('#exampleModal').modal('show');
		}

	}
</script>

</html>