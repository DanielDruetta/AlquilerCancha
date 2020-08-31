<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="entidades.Establecimiento"%>
<%@page import="data.DataEstablecimiento"%>
<%@page import="java.util.ArrayList"%>

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
%>

</head>

<body>
	<div class="container">
		<form class="form-ModificacionCancha" action="ModificacionCancha"
			method="post">
			<div class="form-group col-md-12">
				<h3>Modificar cancha</h3>
			</div>

			<div class="form-group">
				<label for="inputEstablecimiento" class="control-label col-md-4">Establecimiento:</label>
				<div class="col-md-10">
					<input id="inputEstablecimiento" name="establecimiento"
						class="form-control" type="text" value=<%=e.getNombre()%> disabled>
				</div>
			</div>


			<div class="form-group">
				<label for="inputNumero" class="control-label col-md-2">Numero
					de cancha:</label>
				<div class="col-md-4">
					<select class="col-md-12" id="inputNumero" name="numero">
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
				<div class="col-md-2">
					<input type="submit" class="btn btn-primary" name="act"
						value="Modificar cancha">
				</div>
			</div>
		</form>
	</div>
<jsp:include page="footer.jsp" />
</body>
</html>