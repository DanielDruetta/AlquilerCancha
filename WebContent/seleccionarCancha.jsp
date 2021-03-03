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
	ArrayList<Ocupada> disponibles = (ArrayList<Ocupada>) request.getAttribute("listaDisponibles");

	Establecimiento es = (Establecimiento) session.getAttribute("establecimiento");

	DataPrecio dp = new DataPrecio();

%>

</head>
<body>
	<div class="container">
		<h3 style="text-align: center">Canchas disponibles</h3>
		<form class="form-confirmarReserva" action="ConfirmarReserva"
			method="post">
			<div class="row">
				<div class="col-12 col-sm-12 col-lg-12">
					<div class="table-responsive">
						<table class="table" style="text-align: center">
							<thead>
								<tr>

									<th>Numero</th>
									<th>Hora</th>
									<th>Estado</th>
									<th>Descripcion</th>
									<th>Precio</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<%
									for (Ocupada disp : disponibles) {
									if (disp.getEstado().equals("Disponible")) {
										Precio precio = new Precio();
										precio = dp.obtenerPrecio(es.getNombre(), disp.getNumero());
										int precioint = (int) Math.round(precio.getPrecio());
										%>
								<tr>
									<td><%=disp.getNumero()%></td>
									<td><%=disp.getHora_inicio()%></td>
									<td><%=disp.getEstado()%></td>
									<td><%=disp.getDescripcion()%></td>
									<td><%=precioint%></td>
									<td>
										<button type="submit" class="btn btn-primary" name="seleccion"
											value=<%=String.valueOf(disp.getNumero()) + "r" + String.valueOf(disp.getHora_inicio())%>>Seleccionar</button>
									</td>
									<%
										}
					
										if (disp.getEstado().equals("Ocupada")) {
									%>
								
								<tr>
									<td bgcolor="#ffcdd2"><%=disp.getNumero()%></td>
									<td bgcolor="#ffcdd2"><%=disp.getHora_inicio()%></td>
									<td bgcolor="#ffcdd2"><%=disp.getEstado()%></td>
									<td bgcolor="#ffcdd2"><%=disp.getDescripcion()%></td>
									<td bgcolor="#ffcdd2"><%=dp.obtenerPrecio(es.getNombre(), disp.getNumero()).getPrecio()%></td>
									<td bgcolor="#ffcdd2">Ocupada</td>
									<%
										}
									%>

								</tr>

								<%
									}
								%>
							</tbody>
						</table>
					</div>
				</div>
				<!-- end col-12 -->
			</div>
			<!-- end row -->


		</form>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>