<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="entidades.Establecimiento"%>
<%@page import="entidades.Cliente"%>
<%@page import="entidades.Administrador"%>
<!DOCTYPE html>
<html>
<head>
<title>Futbol 5</title>
<link rel="icon" href="https://http2.mlstatic.com/pelota-futbol-adidas-epp-2-b-D_NQ_NP_662338-MLA29510542741_022019-F.jpg">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
 <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
 

<%
	Establecimiento e = (Establecimiento) session.getAttribute("establec");
	Cliente c = (Cliente) session.getAttribute("usuario");
	Administrador a = (Administrador) session.getAttribute("administrador");
%>

</head>


<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="../AlquilerCancha/index.jsp"><img src="https://http2.mlstatic.com/pelota-futbol-adidas-epp-2-b-D_NQ_NP_662338-MLA29510542741_022019-F.jpg" alt="UTN Logo" width="40"></img></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"> <span class="navbar-toggler-icon"></span> </button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="../AlquilerCancha/index.jsp">Home<span class="sr-only">(current)</span></a></li>
				
				<li class="nav-item"><a class="nav-link" href="">Listado Canchas</a></li>
				
				<li class="nav-item"><a class="nav-link" href="reservarCancha.jsp">Reservar Cancha</a></li>
				
				<li class="nav-item"><a class="nav-link" href="../AlquilerCancha/cancelarCancha.jsp">Cancelar Reserva</a></li>
				
				<li class="nav-item"><a class="nav-link" href="reservasDia.jsp">Reservas Día</a></li>
				
				<li class="nav-item"><a class="nav-link" href="reservasMes.jsp">Reservas Mes</a></li>

				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="clienteDropdown" role="button" data-toggle="dropdown" aria-expanded="false"> Clientes </a>
					<div class="dropdown-menu" aria-labelledby="vacanteDropdown">
						<a class="dropdown-item" href="altaCliente.jsp">Alta Cliente</a> 
						<a class="dropdown-item" href="bajaCliente.jsp">Eliminar Cliente</a> 
						<a class="dropdown-item" href="modificacionCliente.jsp">Modificar Cliente</a>
					</div>
				</li>

				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Canchas </a>
					<div class="dropdown-menu" aria-labelledby="vacanteDropdown">
						<a class="dropdown-item" href="altaCancha.jsp">Alta Cancha</a> 
						<a class="dropdown-item" href="bajaCancha.jsp">Eliminar Cancha</a> 
						<a class="dropdown-item" href="modificacionCancha.jsp">Modificar Cancha</a>
					</div>
				</li>
				
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Establecimientos </a>
					<div class="dropdown-menu" aria-labelledby="vacanteDropdown">
						<a class="dropdown-item" href="altaEstablecimiento.jsp">Alta Establecimiento</a> 
						<a class="dropdown-item" href="bajaEstablecimiento.jsp">Eliminar Establecimiento</a> 
						<a class="dropdown-item" href="modificacionEstablecimiento.jsp">Modificar Establecimiento</a>
					</div>
				</li>
				
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Precio </a>
					<div class="dropdown-menu" aria-labelledby="vacanteDropdown">
						<a class="dropdown-item" href="modificacionPrecio.jsp">Modificar Precio</a> 
					</div>
				</li>


			</ul>

			<ul class="navbar-nav mr-right">
			<%
				if (c != null) {
			%>
			
				<li><a href="#" class="nav-link"><%=c.getNombre()%></a></li>
				
				<li>
					<a href="cerrarSesion.jsp" class="nav-link"><svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-door-closed-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M4 1a1 1 0 0 0-1 1v13H1.5a.5.5 0 0 0 0 1h13a.5.5 0 0 0 0-1H13V2a1 1 0 0 0-1-1H4zm2 9a1 1 0 1 0 0-2 1 1 0 0 0 0 2z" /> 
						</svg> Logout
					</a>
				</li>
				
			<% } else if  (e != null){ %>

				<li><a href="#" class="nav-link"><%=e.getNombre()%></a></li>

				<li><a href="cerrarSesion.jsp" class="nav-link"><svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-door-closed-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg"> <path fill-rule="evenodd" d="M4 1a1 1 0 0 0-1 1v13H1.5a.5.5 0 0 0 0 1h13a.5.5 0 0 0 0-1H13V2a1 1 0 0 0-1-1H4zm2 9a1 1 0 1 0 0-2 1 1 0 0 0 0 2z" /> 
						</svg> Logout </a></li>
						
			<% } else if  (a != null){ %>

				<li><a href="#" class="nav-link"><%=a.getNombre_usuario()%></a></li>

				<li><a href="cerrarSesion.jsp" class="nav-link"><svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-door-closed-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg"> <path fill-rule="evenodd" d="M4 1a1 1 0 0 0-1 1v13H1.5a.5.5 0 0 0 0 1h13a.5.5 0 0 0 0-1H13V2a1 1 0 0 0-1-1H4zm2 9a1 1 0 1 0 0-2 1 1 0 0 0 0 2z" /> 
						</svg> Logout </a></li>

			<% } else { %>
			
				<li>
					<a href="iniciarSesion.jsp" class="nav-link"> <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-file-person" fill="currentColor" xmlns="http://www.w3.org/2000/svg"> <path fill-rule="evenodd" d="M4 1h8a2 2 0 0 1 2 2v10a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2zm0 1a1 1 0 0 0-1 1v10a1 1 0 0 0 1 1h8a1 1 0 0 0 1-1V3a1 1 0 0 0-1-1H4z" /> <path d="M13.784 14c-.497-1.27-1.988-3-5.784-3s-5.287 1.73-5.784 3h11.568z" /> <path fill-rule="evenodd" d="M8 10a3 3 0 1 0 0-6 3 3 0 0 0 0 6z" />
              			</svg> Login
					</a>
				</li>

				<li>
					<a href="altaCliente.jsp" class="nav-link"> <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-file-person" fill="currentColor" xmlns="http://www.w3.org/2000/svg"> <path fill-rule="evenodd" d="M4 1h8a2 2 0 0 1 2 2v10a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2zm0 1a1 1 0 0 0-1 1v10a1 1 0 0 0 1 1h8a1 1 0 0 0 1-1V3a1 1 0 0 0-1-1H4z" /> <path d="M13.784 14c-.497-1.27-1.988-3-5.784-3s-5.287 1.73-5.784 3h11.568z" /> <path fill-rule="evenodd" d="M8 10a3 3 0 1 0 0-6 3 3 0 0 0 0 6z" />
              			</svg> Registrarse
					</a>
				</li>
			<% }%>
			

			</ul>
		</div>
	</nav>
	<br>
</body>
</html>