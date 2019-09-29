<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="entidades.Cancha"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Ocupada"%>
<%@page import="entidades.Establecimiento"%>
<%@page import="data.DataEstablecimiento"%>
<%@page import="entidades.Reserva"%>
<%@page import="java.sql.Time"%>
;
<!DOCTYPE html>
<html>
	<head>
    	<title>Futbol 5</title>
    	<link rel="icon" href="https://http2.mlstatic.com/pelota-futbol-adidas-epp-2-b-D_NQ_NP_662338-MLA29510542741_022019-F.jpg">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    	

  
    
   <% 	
        Establecimiento es=(Establecimiento) session.getAttribute("establecimiento");
  		Reserva r=(Reserva) session.getAttribute("reserva");

    %>
<body>

<div class="form-group">
    	<label for="inputFecha" class="control-label col-md-2">Numero de reserva</label>
    	<div class="col-md-7">
    		<input id="inputFecha" name="inputFecha" class="form-control" placeholder="" required="" autofocus="" type="text" value="<%=r.getNumero_reserva()%>" disabled>
    	</div>
    </div>

<div class="form-group">
    	<label for="inputFecha" class="control-label col-md-2">Establecimiento</label>
    	<div class="col-md-7">
    		<input id="inputFecha" name="inputFecha" class="form-control" placeholder="" required="" autofocus="" type="text" value="<%=r.getEstablecimiento()%>" disabled>
    	</div>
    </div>
    
    <div class="form-group">
    	<label for="inputFecha" class="control-label col-md-2">Fecha del partido</label>
    	<div class="col-md-7">
    		<input id="inputFecha" name="inputFecha" class="form-control" placeholder="" required="" autofocus="" type="text" value="<%=r.getFecha()%>" disabled>
    	</div>
    </div>
    
<div class="form-group">
    	<label for="inputFecha" class="control-label col-md-2">Hora inicio del partido</label>
    	<div class="col-md-7">
    		<input id="inputFecha" name="inputFecha" class="form-control" placeholder="" required="" autofocus="" type="text" value="<%=r.getHora_inicio()%>" disabled>
    	</div>
    </div>
    
    <div class="form-group">
    	<label for="inputFecha" class="control-label col-md-2">Hora fin del partido</label>
    	<div class="col-md-7">
    		<input id="inputFecha" name="inputFecha" class="form-control" placeholder="" required="" autofocus="" type="text" value="<%=r.getHora_inicio()+1%>" disabled>
    	</div>
    </div>

<div class="form-group">
    	<label for="inputFecha" class="control-label col-md-2">Numero de cancha</label>
    	<div class="col-md-7">
    		<input id="inputFecha" name="inputFecha" class="form-control" placeholder="" required="" autofocus="" type="text" value="<%=r.getNumero_cancha()%>" disabled>
    	</div>
    </div>    
    
<a class="btn btn-primary" href="menuCliente.html" role="button">Volver al menu</a>
    
</body>
</html>