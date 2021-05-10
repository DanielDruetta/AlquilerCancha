<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="entidades.Administrador"%>
<%@page import="data.DataCliente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Cliente"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp" />
<%
	Administrador a = (Administrador) session.getAttribute("administrador");
	if (a == null) {
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	DataCliente dc = new DataCliente();
	ArrayList<Cliente> cl = dc.getAll();
%>
</head>

<body>
	<div class="container">
		<form class="form-bajacliente" action="BajaCliente" method="post">
			<div class="form-group col-md-12">
				<h3>Baja cliente</h3>
			</div>

			<div class="form-group">
				<label for="inputCliente" class="control-label col-md-8">Nombre y apellido del cliente:</label>
				<div class="col-md-10">
					<select class="form-control" id="inputCliente"
						name="inputCliente">
						<%
							for (Cliente c : cl) {
						%>

						<option class=form-control value="<%=c.getDni()%>"><%=c.getNombre() + " " + c.getApellido() %></option>

						<%
							}
						%>
					</select>
				</div>
			</div>


			<div class="form-group">
				<div class="col-md-2">
					<input type="submit" class="btn btn-primary" name="act"
						value="Eliminar usuario">
				</div>
			</div>
		</form>


	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>