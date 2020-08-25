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
		<h3>Buscar un turno</h3>
		<form class="form-reservar" action="reservar" method="post">
			<div class="form-group">
				<label for="inputEstablecimiento" class="control-label col-md-2">Establecimiento:</label>
				<div class="col-md-7">
					<select class="col-md-12" id="inputEstablecimiento"
						name="inputEstablecimiento">
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

			<div class="form-group">
				<label for="inputFecha" class="control-label col-md-2">Fecha</label>
				<div class="col-md-7">
					<input id="inputFecha" name="inputFecha" class="form-control"
						placeholder="" required="" autofocus="" type="date">
				</div>
			</div>

			<div class="form-group">
				<label for="inputTipo" class="control-label col-md-2">Tipo:</label>
				<div class="col-md-7">
					<select class="col-md-12" id="inputTipo" name="inputTipo">

						<option class=form-control value=5>5</option>
						<option class=form-control value=7>7</option>
						<option class=form-control value=9>9</option>
						<option class=form-control value=11>11</option>

					</select>
				</div>
			</div>

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
</html>