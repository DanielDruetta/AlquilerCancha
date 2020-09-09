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
		<form class="form-BajaMantenimiento" action="bajamantenimiento" method="post">
			<table class="table">
				<thead>
					<tr>
						<th>Cancha</th>
						<th>Fecha desde</th>
						<th>Fecha hasta</th>
						<th>Descripcion</th>
						<th>Observaciones</th>
						<th></th>
					</tr>
				</thead>

				<tbody>
					<%
						for (Mantenimiento man : mantenimientos) {
							
					%>
					<tr>
						<td style="padding-top:20px"><%=man.getNumeroCancha()%></td>
						<td style="padding-top:20px"><%=man.getFechaInicio()%> </td>
						<td style="padding-top:20px"><%=man.getFechaFin()%></td>
						<td style="padding-top:20px"><%=man.getDescripcion()%></td>
						<td style="padding-top:20px"><%=man.getObservaciones()%></td>
						<td><button type="submit" class="btn btn-outline-danger" style="color: red;" name="seleccion" value="<%=String.valueOf(man.getNumeroCancha()) + "r" + String.valueOf(man.getFechaInicio())%>">Eliminar</button></td>
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