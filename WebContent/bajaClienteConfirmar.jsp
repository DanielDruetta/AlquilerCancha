<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="entidades.Cliente"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp" />

<%
	Cliente cli = (Cliente) session.getAttribute("usuario");
%>

</head>
<body>
	<div class="container">
		<form class="form-bajaclienteconfirmado"
			action="BajaClienteConfirmado" method="post">

			<div class="form-group col-md-12">
				<br />
				<h3>Cliente</h3>
			</div>

			<div class="form-group">
				<label for="inputDni" class="control-label col-md-2">DNI:</label>
				<div class="col-md-10">
					<label id="inputDni" name="dni" class="form-control" type="number"
						placeholder=""><%=cli.getDni()%></label>
				</div>
			</div>

			<div class="form-group">
				<label for="inputNombre" class="control-label col-md-2">Nombre</label>
				<div class="col-md-10">
					<label id="inputNombre" name="nombre" class="form-control"
						type="text" placeholder=""><%=cli.getNombre()%></label>
				</div>
			</div>

			<div class="form-group">
				<label for="inputApellido" class="control-label col-md-2">Apellido:</label>
				<div class="col-md-10">
					<label id="inputApellido" name="apellido" class="form-control"
						type="text" placeholder=""><%=cli.getApellido()%></label>
				</div>
			</div>

			<div class="form-group">
				<label for="inputUsuario" class="control-label col-md-2">Usuario:</label>
				<div class="col-md-10">
					<label id="inputUsuario" name="usuario" class="form-control"
						type="text" placeholder=""><%=cli.getUsuario()%></label>
				</div>
			</div>

			<div class="form-group">
				<label for="inputEmail" class="control-label col-md-2">Email:</label>
				<div class="col-md-10">
					<label id="inputEmail" name="email" class="form-control"
						type="email" placeholder=""><%=cli.getEmail()%></label>
				</div>
			</div>

			<div class="form-group">
				<label for="inputCelular" class="control-label col-md-2">Celular:</label>
				<div class="col-md-10">
					<label id="inputCelular" name="celular" class="form-control"
						type="number" placeholder=""><%=cli.getCelular()%></label>
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
				session.setAttribute("c", cli);
			%>
		</form>
	</div>
<jsp:include page="footer.jsp" />
</body>
</html>