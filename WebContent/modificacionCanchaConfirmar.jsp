<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="entidades.Cancha"%>
<%@page import="entidades.Precio"%>
<%@page import="entidades.Establecimiento"%>
<%@page import="data.DataEstablecimiento"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp" />

<%
	Cancha can = (Cancha) session.getAttribute("cancha");
	Precio pre = (Precio) session.getAttribute("precio");
	DataEstablecimiento de = new DataEstablecimiento();
	request.getSession().setAttribute("listaEstablecimientos", de.getAll());
	ArrayList<Establecimiento> es = (ArrayList<Establecimiento>) session.getAttribute("listaEstablecimientos");
%>
</head>
<body>
	<div class="container">
		<form class="form-ModificacionCanchaConfirmado"
			action="ModificacionCanchaConfirmado" method="post">
			<div class="form-group col-md-12">
				<h3>Modificar cancha</h3>
			</div>

			<div class="form-group">
				<label for="inputEstablecimiento" class="control-label col-md-4">Establecimiento:</label>
				<div class="col-md-12">
					<input id="inputEstablecimiento" name="establecimiento" class="form-control" type="text" value="<%=can.getEstablecimiento()%>" disabled>
				</div>
			</div>

			<div class="form-group">
				<label for="inputNumero" class="control-label col-md-4">Numero de cancha:</label>
				<div class="col-md-12">
					<input id="inputNumero" name="numero" class="form-control" type="number" value="<%=can.getNumero()%>">
				</div>
			</div>

			<div class="form-group">
				<label for="inputDescripcion" class="control-label col-md-4">Descripcion:</label>
				<div class="col-md-12">
					<input id="inputDescripcion" name="descripcion"
						class="form-control" type="text" value="<%=can.getDescripcion()%>">
				</div>
			</div>

			<div class="form-group">
				<label for="inputTipo" class="control-label col-md-4">Tipo:</label>
				<div class="col-md-12">
					<input id="inputTipo" name="tipo" class="form-control" type="text" value="<%=can.getTipo()%>">
				</div>
			</div>

			<div class="form-group">
				<label for="inputLuz" class="control-label col-md-4">Luz:</label>
				<div class="col-md-2">
					<input id="inputLuz" name="luz" class="form-control" type="checkbox" value="S">
				</div>
			</div>

			<div class="form-group">
				<label for="inputPrecio" class="control-label col-md-2">Precio:</label>
				<div class="col-md-2">
					<input id="inputPrecio" name="inputPrecio" class="form-control" type="number" step="0.01" value="<%=pre.getPrecio()%>">
				</div>
			</div>


			<div class="form-group">
				<div class="col-md-6">
					<input type="submit" class="btn btn-primary" name="action" value="Modificar"> 
					<input type="submit" class="btn btn-secondary" name="action" value="Cancelar">
				</div>

			</div>

			<%
				session.setAttribute("c", can);
			%>

		</form>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>