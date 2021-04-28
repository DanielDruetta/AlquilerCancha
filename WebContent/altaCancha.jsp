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
	Establecimiento e = (Establecimiento) session.getAttribute("establec");
	if (e == null) {
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	DataEstablecimiento de = new DataEstablecimiento();
	//request.getSession().setAttribute("listaEstablecimientos", de.getAll());
	//ArrayList<Establecimiento> es = (ArrayList<Establecimiento>) session.getAttribute("listaEstablecimientos");
	ArrayList<Integer> canchas = new ArrayList<Integer>();
	canchas = de.canchas(e.getNombre());
%>
</head>


<body>
	<div class="container">
		<form class="form-altacancha" action="AltaCancha" method="post">
			<div class="form-group col-md-12">
				<h3>Alta cancha</h3>
			</div>

			<div class="form-group">
				<label for="inputEstablecimiento" class="control-label col-md-2">Establecimiento:</label>
				<div class="col-md-10">
					<input id="inputEstablecimiento" name="establecimiento"
						class="form-control" type="text" value=<%=e.getNombre()%> disabled>
				</div>
			</div>


			<div class="form-group">
				<label for="inputNumero" class="control-label col-md-2">Numero
					de cancha:</label>
				<div class="col-md-10">
					<input id="inputNumero" name="numero" class="form-control"
						type="number" value=<%=canchas.size() + 1%> disabled>

				</div>
			</div>

			<div class="form-group">
				<label for="inputDescripcion" class="control-label col-md-2">Descripcion:</label>
				<div class="col-md-10">
					<input id="inputDescripcion" name="descripcion"
						class="form-control" type="text" placeholder="">
				</div>
			</div>

			<div class="form-group">
				<label for="inputTipo" class="control-label col-md-2">Tipo:</label>
				<div class="col-md-10">
					<select class="form-control" id="inputTipo" name="tipo"> 
						<option value="5">5</option> 
						<option value="7">7</option>
						<option value="9">9</option>
						<option value="11">11</option>
					</select>
				</div>
			</div>

			<div class="form-group">
				<label for="inputPrecio" class="control-label col-md-2">Precio:</label>
				<div class="col-md-10">
					<input id="inputPrecio" name="precio" class="form-control"
						type="number" placeholder="">
				</div>
			</div>

			<div class="form-group">
				<label for="inputLuz" class="control-label col-md-2">Luz:</label>
				<div class="col-md-2">
					<input id="inputLuz" name="luz" class="form-control"
						type="checkbox" value="S" placeholder="">
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