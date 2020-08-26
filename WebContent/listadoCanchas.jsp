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
		<form class="" action="" method="post">
			<table class="table">
				<thead>
					<tr>
						<th>Nombre</th>
						<th>Tipos de cancha</th>
						<th>Dirección</th>
						<th>Hora inicio</th>
						<th>Hora fin</th>
					</tr>
				</thead>

				<tbody>
					<%
						for (Establecimiento est : establecimientos) {
							tipos = de.tipos(est.getNombre());
					%>
					<tr>
						<td><%=est.getNombre()%></td>
						<td><% for (Integer t : tipos) { %> <a> <%=t%> </a> <% } %> </td>
						<td><%=est.getDireccion()%></td>
						<td><%=est.getHora_inicio()%></td>
						<td><%=est.getHora_fin()%></td>
					</tr>

					<%
						}
					%>

				</tbody>
			</table>
		</form>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>