<%@page import="data.DataEstablecimiento"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Mantenimiento"%>
<%@page import="entidades.Establecimiento"%>
<%@page import="data.DataMantenimiento"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp" />

<%
Establecimiento es = (Establecimiento) session.getAttribute("establec");
if (es == null) {
	request.getRequestDispatcher("index.jsp").forward(request, response);
}
DataMantenimiento dm = new DataMantenimiento();
ArrayList<Mantenimiento> mantenimientos = new ArrayList<Mantenimiento>();
mantenimientos = dm.mantenimientos(es.getNombre());
%>
</head>

<body>
	<div class="container">
		<h3>Listado de mantenimientos</h3>
		<form class="" action="" method="post">
			<table class="table">
				<thead>
					<tr>
						<th>Cancha</th>
						<th>Fecha desde</th>
						<th>Fecha hasta</th>
						<th>Descripcion</th>
						<th>Observaciones</th>
					</tr>
				</thead>

				<tbody>
					<%
						for (Mantenimiento man : mantenimientos) {
							
					%>
					<tr>
						<td><%=man.getNumeroCancha()%></td>
						<td><%=man.getFechaInicio()%> </td>
						<td><%=man.getFechaFin()%></td>
						<td><%=man.getDescripcion()%></td>
						<td><%=man.getObservaciones()%></td>
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