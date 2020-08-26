<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="entidades.Cancha"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp" />
<%
	Cancha can = (Cancha) session.getAttribute("cancha");
%>
</head>
<body>
	<div class="container">
		<form class="form-bajacanchaconfirmado" action="BajaCanchaConfirmado"
			method="post">
			<div class="form-group col-md-12">
				<h3>Cancha</h3>
			</div>

			<div class="form-group">
				<label for="inputEstablecimiento" class="control-label col-md-2">Establecimiento:</label>
				<div class="col-md-10">
					<input id="inputEstablecimiento" name="establecimiento"
						class="form-control" type="text"
						value=<%=can.getEstablecimiento()%> disabled>
				</div>
			</div>


			<div class="form-group">
				<label for="inputNumero" class="control-label col-md-2">Numero
					de cancha:</label>
				<div class="col-md-10">
					<input id="inputNumero" name="numero" class="form-control"
						type="number" value=<%=can.getNumero()%> disabled>
				</div>
			</div>

			<div class="form-group">
				<label for="inputDescripcion" class="control-label col-md-2">Descripcion:</label>
				<div class="col-md-10">
					<input id="inputDescripcion" name="descripcion"
						class="form-control" type="text" value=<%=can.getDescripcion()%>
						disabled>
				</div>
			</div>

			<div class="form-group">
				<label for="inputTipo" class="control-label col-md-2">Tipo:</label>
				<div class="col-md-10">
					<input id="inputTipo" name="tipo" class="form-control" type="text"
						value=<%=can.getTipo()%> disabled>
				</div>
			</div>

			<div class="form-group">
				<label for="inputLuz" class="control-label col-md-2">Luz:</label>
				<div class="col-md-10">
					<input id="inputLuz" name="luz" class="form-control" type="text"
						value=<%=can.isLuz()%> disabled>
				</div>
			</div>


			<div class="form-group">
				<div class="col-md-2">
					<input type="submit" class="btn btn-primary" name="action"
						value="Eliminar">
				</div>
			</div>

			<div class="form-group">
				<div class="col-md-2">
					<input type="submit" class="btn btn-secondary" name="action"
						value="Cancelar">
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