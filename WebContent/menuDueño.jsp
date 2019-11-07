<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="entidades.Establecimiento"%>
<!DOCTYPE html>
<html>
	<head>
    	<title>Futbol 5</title>
    	<link rel="icon" href="https://http2.mlstatic.com/pelota-futbol-adidas-epp-2-b-D_NQ_NP_662338-MLA29510542741_022019-F.jpg">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    
    <% 
    	Establecimiento e= (Establecimiento)session.getAttribute("establec");
    %>
    
    </head>


<body>

	<nav class="site-header sticky-top py-1">
	  <div class="container d-flex flex-column flex-md-row justify-content-between">
	    <a class="py-2" href="menuDueño.html">
	      <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="d-block mx-auto" role="img" viewBox="0 0 24 24" focusable="false"><title>Inicio</title><circle cx="12" cy="12" r="10"/><path d="M14.31 8l5.74 9.94M9.69 8h11.48M7.38 12l5.74-9.94M9.69 16L3.95 6.06M14.31 16H2.83m13.79-4l-5.74 9.94"/></svg>
	    </a>
	    <a class="py-2 d-none d-md-inline-block" href="cancelarReserva.html">Cancelar reserva</a>
	    <a class="py-2 d-none d-md-inline-block" href="#">Modificar datos del establecimiento</a>
	    <a class="py-2 d-none d-md-inline-block" href="reservasMes.jsp">Reservas del mes</a>
	    <a class="py-2 d-none d-md-inline-block" href="reservasDia.jsp">Reservas del dia</a>
	    <a class="py-2 d-none d-md-inline-block" href="#">Pricing</a>
	    <a class="py-2 d-none d-md-inline-block" href="#"><%=e.getNombre()%></a>
	  </div>
	</nav>


	<div class="container">
	    <div class="row">
	      
	      <div class="col-md-4">
			<br> 
	        <h2>Cancha</h2>
	        <p><a class="btn btn-primary" href="altaCancha.jsp" role="button">Alta cancha</a></p>
	        <p><a class="btn btn-primary" href="bajaCancha.jsp" role="button">Baja cancha</a></p>
	        <p><a class="btn btn-primary" href="modificacionCancha.jsp" role="button">Modificacion cancha</a></p>
	      </div>
	      
	     
	      
	      <div class="col-md-4">
	      	<br> 
	        <h2>Precio</h2>
	       
	        <p><a class="btn btn-primary" href="modificacionPrecio.jsp" role="button">Modificacion precio</a></p>
	      </div>
	      
	      <div class="col-md-4">
	      	<br> 
	        <h2>Reserva</h2>
	        <p><a class="btn btn-primary" href="altaPrecio.html" role="button">Alta reserva</a></p>
	        <p><a class="btn btn-primary" href="bajaPrecio.html" role="button">Baja reserva</a></p>
	        <p><a class="btn btn-primary" href="#" role="button">Modificacion reserva</a></p>
	      </div>
	      
	      <div class="col-md-4">
			<br> 
	        <h2>Mantenimiento</h2>
	        <p><a class="btn btn-primary" href="altaMantenimiento.html" role="button">Alta mantenimiento</a></p>
	        <p><a class="btn btn-primary" href="bajaMantenimiento.html" role="button">Baja mantenimiento</a></p>
	        <p><a class="btn btn-primary" href="#" role="button">Modificacion mantenimiento</a></p>
	      </div>
	      
	
	  </div> 
	</div> 



</body>
</html>