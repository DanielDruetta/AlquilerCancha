<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="entidades.Cancha"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Cliente"%>
<%@page import="entidades.Establecimiento"%>
<%@page import="entidades.Reserva"%>
<%@page import="data.DataReserva"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp" />
<%
	Cliente c = (Cliente) session.getAttribute("usuario");
	DataReserva dr = new DataReserva();
	ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	reservas = dr.reservasCliente(c.getDni());
%>

</head>
<body>
	<div class="container">
		<h3>Reservas vigentes</h3>
		<form class="form-cancelarReserva" action="CancelarReserva"
			method="post">
			<div class="row">
				<div class="col-12 col-sm-12 col-lg-12">
					<div class="table-responsive">
						<table class="table">
							<thead>
								<tr>
									<th>Fecha del partido</th>
									<th>Hora del partido</th>
									<th>Establecimiento</th>
									<th>Numero de cancha</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<%
									for (Reserva disp : reservas) {
								%>
								<tr>
									<td><%=disp.getFecha()%></td>
									<td><%=disp.getHora_inicio()%></td>
									<td><%=disp.getEstablecimiento()%></td>
									<td><%=disp.getNumero_cancha()%></td>

									<td>
										<button type="submit" class="btn btn-primary" name="seleccion"
											value=<%=String.valueOf(disp.getNumero_reserva())%>>Cancelar
											reserva</button>
									</td>

								</tr>

								<%
									}
								%>
							</tbody>
						</table>
					</div>
				</div>
			</div>


		</form>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>