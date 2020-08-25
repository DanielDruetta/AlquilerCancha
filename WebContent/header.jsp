<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="entidades.Establecimiento"%>
<!DOCTYPE html>
<html>
<head>
<title>Futbol 5</title>
<link rel="icon"
	href="https://http2.mlstatic.com/pelota-futbol-adidas-epp-2-b-D_NQ_NP_662338-MLA29510542741_022019-F.jpg">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<%
	Establecimiento e = (Establecimiento) session.getAttribute("establec");
%>

</head>


<body>

	<!-- 	<nav class="site-header sticky-top py-1"> -->
	<!-- 		<div -->
	<!-- 			class="container d-flex flex-column flex-md-row justify-content-between"> -->
	<!-- 			<a class="py-2" href="menuDueño.html"> <svg -->
	<!-- 					xmlns="http://www.w3.org/2000/svg" width="24" height="24" -->
	<!-- 					fill="none" stroke="currentColor" stroke-linecap="round" -->
	<!-- 					stroke-linejoin="round" stroke-width="2" class="d-block mx-auto" -->
	<!-- 					role="img" viewBox="0 0 24 24" focusable="false"> -->
	<!-- 					<title>Inicio</title><circle cx="12" cy="12" r="10" /> -->
	<!-- 					<path -->
	<!-- 						d="M14.31 8l5.74 9.94M9.69 8h11.48M7.38 12l5.74-9.94M9.69 16L3.95 6.06M14.31 16H2.83m13.79-4l-5.74 9.94" /></svg> -->
	<!-- 			</a> <a class="py-2 d-none d-md-inline-block" href="cancelarReserva.html">Cancelar -->
	<!-- 				reserva</a> <a class="py-2 d-none d-md-inline-block" href="#">Modificar -->
	<!-- 				datos del establecimiento</a> <a class="py-2 d-none d-md-inline-block" -->
	<!-- 				href="reservasMes.jsp">Reservas del mes</a> <a -->
	<!-- 				class="py-2 d-none d-md-inline-block" href="reservasDia.jsp">Reservas -->
	<!-- 				del dia</a> <a class="py-2 d-none d-md-inline-block" href="#">Pricing</a> -->
	<%-- 			<a class="py-2 d-none d-md-inline-block" href="#"><%=e.getNombre()%></a> --%>
	<!-- 		</div> -->
	<!-- 	</nav> -->

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="../Logic/index.php"><img
			src="../Imagenes/UtnLogo.gif" alt="UTN Logo" width="30" height="40"></img></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="../WebContent/index.jsp">Home<span class="sr-only">(current)</span></a>
				</li>
				<li class="nav-item"><a class="nav-link"
					href="../Logic/vacantes.php">Listado Canchas</a></li>



				<li><a href="../Logic/cerrar_sesion.php" class="nav-link">
						<svg width="1em" height="1em" viewBox="0 0 16 16"
							class="bi bi-door-closed-fill" fill="currentColor"
							xmlns="http://www.w3.org/2000/svg">
                <path fill-rule="evenodd"
								d="M4 1a1 1 0 0 0-1 1v13H1.5a.5.5 0 0 0 0 1h13a.5.5 0 0 0 0-1H13V2a1 1 0 0 0-1-1H4zm2 9a1 1 0 1 0 0-2 1 1 0 0 0 0 2z" />
              </svg> Logout
				</a></li>
			</ul>

			<ul class="navbar-nav mr-right">
				<li><a href="iniciar_sesion.php" class="nav-link"> <svg
							width="1em" height="1em" viewBox="0 0 16 16"
							class="bi bi-file-person" fill="currentColor"
							xmlns="http://www.w3.org/2000/svg">
                <path fill-rule="evenodd"
								d="M4 1h8a2 2 0 0 1 2 2v10a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2zm0 1a1 1 0 0 0-1 1v10a1 1 0 0 0 1 1h8a1 1 0 0 0 1-1V3a1 1 0 0 0-1-1H4z" />
                <path
								d="M13.784 14c-.497-1.27-1.988-3-5.784-3s-5.287 1.73-5.784 3h11.568z" />
                <path fill-rule="evenodd"
								d="M8 10a3 3 0 1 0 0-6 3 3 0 0 0 0 6z" />
              </svg> Login
				</a></li>

				<li><a href="registrarse.php" class="nav-link"> <svg
							width="1em" height="1em" viewBox="0 0 16 16"
							class="bi bi-file-person" fill="currentColor"
							xmlns="http://www.w3.org/2000/svg">
                <path fill-rule="evenodd"
								d="M4 1h8a2 2 0 0 1 2 2v10a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2zm0 1a1 1 0 0 0-1 1v10a1 1 0 0 0 1 1h8a1 1 0 0 0 1-1V3a1 1 0 0 0-1-1H4z" />
                <path
								d="M13.784 14c-.497-1.27-1.988-3-5.784-3s-5.287 1.73-5.784 3h11.568z" />
                <path fill-rule="evenodd"
								d="M8 10a3 3 0 1 0 0-6 3 3 0 0 0 0 6z" />
              </svg> Registrarse
				</a></li>
			</ul>

		</div>
	</nav>






</body>
</html>