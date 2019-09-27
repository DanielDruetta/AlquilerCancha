<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="entidades.Cancha"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Cliente"%>
<%@page import="entidades.Establecimiento"%>
<%@page import="data.DataEstablecimiento"%>
<!DOCTYPE html>
<html>
	<head>
    	<title>Futbol 5</title>
    	<link rel="icon" href="https://http2.mlstatic.com/pelota-futbol-adidas-epp-2-b-D_NQ_NP_662338-MLA29510542741_022019-F.jpg">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    	  
    
   <% 	DataEstablecimiento de = new DataEstablecimiento();
        request.getSession().setAttribute("listaEstablecimientos", de.getAll()); //esto es correcto
 		ArrayList<Establecimiento> es=(ArrayList<Establecimiento>)session.getAttribute("listaEstablecimientos");
    %>
    
    </head>
<body>
 <nav class="site-header sticky-top py-1">
  <div class="container d-flex flex-column flex-md-row justify-content-between">
    <a class="py-2" href="menuCliente.html">
      <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="d-block mx-auto" role="img" viewBox="0 0 24 24" focusable="false"><title>Inicio</title><circle cx="12" cy="12" r="10"/><path d="M14.31 8l5.74 9.94M9.69 8h11.48M7.38 12l5.74-9.94M9.69 16L3.95 6.06M14.31 16H2.83m13.79-4l-5.74 9.94"/></svg>
    </a>
    <a class="py-2 d-none d-md-inline-block" href="reservarCancha.html">Reservar cancha</a>
    <a class="py-2 d-none d-md-inline-block" href="cancelarReserva.html">Cancelar reserva</a>
    <a class="py-2 d-none d-md-inline-block" href="#">Features</a>
    <a class="py-2 d-none d-md-inline-block" href="#">Enterprise</a>
    <a class="py-2 d-none d-md-inline-block" href="#">Support</a>
    <a class="py-2 d-none d-md-inline-block" href="#">Pricing</a>
    <a class="py-2 d-none d-md-inline-block" href="#">Cart</a>
  </div>
</nav>
  
<div class="container">
	<br/>
	<h3>Buscar un turno</h3>
    <form class="form-reservar" action="reservar" method="post">
   		<div class="form-group">
			    <label for="inputEstablecimiento" class="control-label col-md-2">Establecimiento:</label>
			    <div class="col-md-7">
			    	<select class="col-md-12" id="inputEstablecimiento" name="inputEstablecimiento">
						<% for (Establecimiento c:es) {%>

						<option class=form-control value="<%=c.getNombre()%>"><%=c.getNombre()%></option>

					<%} %>
					</select>
			    </div>
		 </div>



	<div class="form-group">
    	<label for="inputFecha" class="control-label col-md-2">Fecha</label>
    	<div class="col-md-7">
    		<input id="inputFecha" name="inputFecha" class="form-control" placeholder="" required="" autofocus="" type="date">
    	</div>
    </div>
    
    <div class="form-group">
    	<label for="inputTipo" class="control-label col-md-2">Tipo:</label>
    	<div class="col-md-7">
    		<input for="inputTipo" name="inputTipo" class="form-control" placeholder="5/7/9/11" required="" autofocus="" type="text">
    	</div>
    </div>
    
		
    	<div class="form-group">
           <div class="col-md-2">
                 <input type="submit" class="btn btn-primary" id="act" name="act" value="Aceptar">   
            </div>
     </div>

      
      </form>
 </div>
</body>
</html>