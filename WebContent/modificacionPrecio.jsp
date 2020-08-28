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
				<label for="inputEstablecimiento" class="control-label col-md-2">Numero
					de cancha:</label>
				<div class="col-md-7">
					<select class="col-md-3" id="inputEstablecimiento"
						name="inputEstablecimiento">
						<%
							for (Integer nro : canchas) {
						%>

						<option class=form-control value="<%=nro%>"><%=nro%></option>

						<%
							}
						%>
					</select>
				</div>
			</div>


			<div class="form-group">
				<label for="inputPrecio" class="control-label col-md-2">Nuevo
					precio:</label>
				<div class="col-md-2">
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
</html>
