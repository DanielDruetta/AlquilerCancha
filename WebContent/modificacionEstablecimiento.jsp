<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="entidades.Establecimiento"%>
<%@page import="data.DataEstablecimiento"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Cliente"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp" />

<%
	DataEstablecimiento de = new DataEstablecimiento();
	request.getSession().setAttribute("listaEstablecimientos", de.getAll());
	ArrayList<Establecimiento> es = (ArrayList<Establecimiento>) session.getAttribute("listaEstablecimientos");
%>

</head>
<body>

	<div class="container">
		<form class="form-ModificacionEstablecimiento" action="ModificacionEstablecimiento" method="post">
			<div class="form-group col-md-12">
				<h3>Modificar Establecimiento</h3>
			</div>

			<div class="form-group">
				<label for="inputEstablecimiento" class="control-label col-md-2">Establecimiento:</label>
				<div class="col-md-10">
					<select class="col-md-12" id="inputEstablecimiento" name="inputEstablecimiento">
						<%
							for (Establecimiento e : es) {
						%>

						<option class=form-control value="<%=e.getNombre()%>"><%=e.getNombre()%></option>

						<%
							}
						%>
					</select>
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