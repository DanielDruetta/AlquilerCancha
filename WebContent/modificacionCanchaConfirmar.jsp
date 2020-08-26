<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="entidades.Cancha"%>
<%@page import="entidades.Establecimiento"%>
<%@page import="data.DataEstablecimiento"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp" />

<%
	Cancha can = (Cancha) session.getAttribute("cancha");
	DataEstablecimiento de = new DataEstablecimiento();
	request.getSession().setAttribute("listaEstablecimientos", de.getAll());
	ArrayList<Establecimiento> es = (ArrayList<Establecimiento>) session.getAttribute("listaEstablecimientos");
%>
</head>
<body>
	<div class="container">
		<h3 align="center">Modificar cancha</h3>
		<form class="form-ModificacionCanchaConfirmado"
			action="ModificacionCanchaConfirmado" method="post">
			<div class="row">
				<div class="col-md-6">
					<div class="form-group col-md-12">
						<br />
						<h3>Datos actuales</h3>
					</div>

					<div class="form-group">
						<label for="inputEstablecimiento" class="control-label col-md-4">Establecimiento:</label>
						<div class="col-md-12">
							<input id="inputEstablecimiento" name="establecimiento"
								class="form-control" type="text"
								value=<%=can.getEstablecimiento()%> disabled>
						</div>
					</div>


					<div class="form-group">
						<label for="inputNumero" class="control-label col-md-4">Numero
							de cancha:</label>
						<div class="col-md-12">
							<input id="inputNumero" name="numero" class="form-control"
								type="number" value=<%=can.getNumero()%> disabled>
						</div>
					</div>

					<div class="form-group">
						<label for="inputDescripcion" class="control-label col-md-4">Descripcion:</label>
						<div class="col-md-12">
							<input id="inputDescripcion" name="descripcion"
								class="form-control" type="text" value=<%=can.getDescripcion()%>
								disabled>
						</div>
					</div>

					<div class="form-group">
						<label for="inputTipo" class="control-label col-md-4">Tipo:</label>
						<div class="col-md-12">
							<input id="inputTipo" name="tipo" class="form-control"
								type="text" value=<%=can.getTipo()%> disabled>
						</div>
					</div>

					<div class="form-group">
						<label for="inputLuz" class="control-label col-md-4">Luz:</label>
						<div class="col-md-12">
							<input id="inputLuz" name="luz" class="form-control" type="text"
								value=<%=can.isLuz()%> disabled>
						</div>
					</div>
				</div>

				<div class="col-md-6">
					<div class="form-group col-md-12">
						<br />
						<h3>Datos Nuevos</h3>
					</div>

					<div class="form-group">
						<label for="inputEstablecimiento" class="control-label col-md-4">Establecimiento:</label>
						<div class="col-md-12">
							<input id="inputEstablecimiento" name="establecimiento"
								class="form-control" type="text"
								value=<%=can.getEstablecimiento()%> disabled>
						</div>
					</div>

					<div class="form-group">
						<label for="inputNumero" class="control-label col-md-4">Numero
							de cancha:</label>
						<div class="col-md-12">
							<input id="inputNumero" name="numero" class="form-control"
								type="number">
						</div>
					</div>

					<div class="form-group">
						<label for="inputDescripcion" class="control-label col-md-4">Descripcion:</label>
						<div class="col-md-12">
							<input id="inputDescripcion" name="descripcion"
								class="form-control" type="text" placeholder="">
						</div>
					</div>

					<div class="form-group">
						<label for="inputTipo" class="control-label col-md-4">Tipo:</label>
						<div class="col-md-12">
							<input id="inputTipo" name="tipo" class="form-control"
								type="text" placeholder="">
						</div>
					</div>

					<div class="form-group">
						<label for="inputLuz" class="control-label col-md-4">Luz:</label>
						<div class="col-md-2">
							<input id="inputLuz" name="luz" class="form-control"
								type="checkbox" value="S" placeholder="">
						</div>
					</div>

					<div class="form-group">
						<div class="col-md-6">
							<input type="submit" class="btn btn-primary" name="action" value="Modificar">
							<input type="submit" class="btn btn-secondary" name="action" value="Cancelar">
						</div>
						
					</div>
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