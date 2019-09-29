<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="entidades.Establecimiento"%>
<!DOCTYPE html>
<html>
<head>

    <%    
    	Establecimiento est= (Establecimiento)session.getAttribute("establecim");
    %>
		<title>Futbol 5</title>
    	<link rel="icon" href="https://http2.mlstatic.com/pelota-futbol-adidas-epp-2-b-D_NQ_NP_662338-MLA29510542741_022019-F.jpg">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>

<body>

 <div class="container">
	    <form class="form-BajaEstablecimientoConfirmado" action="BajaEstablecimientoConfirmado" method="post">
		    <div class="form-group col-md-12">
			    <br/>
			    <h3>Baja Establecimiento</h3>
		    </div>
		    
		     <div class="form-group">
			    <label for="inputNombre" class="control-label col-md-4">Nombre del establecimiento:</label>
			    <div class="col-md-10">
			    	<input id="inputNombre" name="nombre" class="form-control" type="text" value=<%=est.getNombre()%> disabled>
			    </div>
		    </div>
		    
		     <div class="form-group">
			    <label for="inputDireccion" class="control-label col-md-4">Direccion del establecimiento:</label>
			    <div class="col-md-10">
			    	<input id="inputNombre" name="nombre" class="form-control" type="text" value=<%=est.getDireccion()%> disabled>
			    </div>
		    </div>
		    
		    <div class="form-group">
			    <label for="inputHoraInicio" class="control-label col-md-4">Hora inicio:</label>
			    <div class="col-md-10">
			    	<input id="inputNombre" name="nombre" class="form-control" type="number" value=<%=est.getHora_inicio()%> disabled>
			    </div>
			</div>
			    
		     <div class="form-group">
			    <label for="inputHoraFin" class="control-label col-md-4">Hora fin:</label>
			    <div class="col-md-10">
			    	<input id="inputNombre" name="nombre" class="form-control" type="number" value=<%=est.getHora_fin()%> disabled>
			    </div>
			    
			  
			  </div>
			    
		    
		    <div class="form-group">
            	<div class="col-md-2">
                 	<input type="submit" class="btn btn-primary" name="act" value="Eliminar">   
            	</div>
        	</div>

        </form>

       

	</div>

</body>
</html>