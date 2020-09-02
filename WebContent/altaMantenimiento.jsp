<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="entidades.Cancha"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Ocupada"%>
<%@page import="entidades.Establecimiento"%>
<%@page import="entidades.Precio"%>
<%@page import="data.DataEstablecimiento"%>
<%@page import="data.DataPrecio"%>
<%@page import="java.sql.Time"%>
<!DOCTYPE html>
<html>
<head>

<jsp:include page="header.jsp" />

<%
	Establecimiento es = (Establecimiento) session.getAttribute("establec");
if (es == null) {
	request.getRequestDispatcher("index.jsp").forward(request, response);
}
DataEstablecimiento de = new DataEstablecimiento();
ArrayList<Integer> canchas = new ArrayList<Integer>();
canchas = de.canchas(es.getNombre());
%>

</head>
<body>
	<div class="container">
		<h3 style="text-align: center">Mantenimiento</h3>
		<form class="form-altaMantenimiento" action="altamantenimiento" method="post">
			<div class="row">
				<div class="col-12 col-sm-12 col-lg-12">
					<div class="table-responsive">
						<div class="form-group">

							<label for="inputCancha" class="control-label col-md-2">Numero
								de cancha:</label>
							<div class="col-md-7">
								<select class="col-md-3" id="inputCancha" name="inputCancha">
									<%
										for (Integer nro : canchas) {
									%>

									<option class=form-control value="<%=nro%>"><%=nro%></option>

									<%
										}
									%>
								</select>
							</div>

							<label for="inputFechaInicio" class="control-label col-md-2">Fecha
								inicio</label>
							<div class="col-md-7">
								<input id="inputFechaInicio" name="inputFechaInicio"
									class="form-control" placeholder="" required="" autofocus=""
									type="date">
							</div>

							<label for="inputFechaFin" class="control-label col-md-2">Fecha
								fin</label>
							<div class="col-md-7">
								<input id="inputFechaFin" name="inputFechaFin"
									class="form-control" placeholder="" required="" autofocus=""
									type="date">
							</div>
							
							<label for="inputDescripcion" class="control-label col-md-2">Descripcion</label>
							<div class="col-md-7">
								<input id="inputDescripcion" name="inputDescripcion"
									class="form-control" placeholder="" required="" autofocus=""
									type="text">
							</div>
							
							<label for="inputObservaciones" class="control-label col-md-2">Observaciones</label>
							<div class="col-md-7">
								<input id="inputObservaciones" name="inputObservaciones"
									class="form-control" placeholder="" required="" autofocus=""
									type="text">
							</div>


						</div>


					</div>
				</div>

				<div class="form-group">
					<div class="col-md-2">
						<input type="submit" class="btn btn-primary" id="act" name="act"
							value="Aceptar">
					</div>
				</div>
			</div>

		</form>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>