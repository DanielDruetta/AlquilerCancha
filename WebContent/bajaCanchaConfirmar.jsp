<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="entidades.Cancha"%>
<!DOCTYPE html>
<html>
<head>

    <%    
    	Cancha can= (Cancha)session.getAttribute("cancha");
    %>
		<title>Futbol 5</title>
    	<link rel="icon" href="https://http2.mlstatic.com/pelota-futbol-adidas-epp-2-b-D_NQ_NP_662338-MLA29510542741_022019-F.jpg">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
 <body>
     <div class="container">
	    <form class="form-bajacanchaconfirmado" action="BajaCanchaConfirmado" method="post">
		    <div class="form-group col-md-12">
			    <br/>
			    <h3>Cancha</h3>
		    </div>
		    
		    <div class="form-group">
			    <label for="inputEstablecimiento" class="control-label col-md-2">Establecimiento:</label>
			    <div class="col-md-10">	
			    	<input id="inputEstablecimiento" name="establecimiento" class="form-control" type="text" value=<%=can.getEstablecimiento()%> disabled>		    	
			    </div>
		    </div>
		    
		    
		    <div class="form-group">
			    <label for="inputNumero" class="control-label col-md-2">Numero de cancha:</label>
			    <div class="col-md-10">
			    	<input id="inputNumero" name="numero" class="form-control" type="number" value=<%=can.getNumero()%> disabled>
			    </div>
		    </div>
		    
		    <div class="form-group">
			    <label for="inputDescripcion" class="control-label col-md-2">Descripcion:</label>
			    <div class="col-md-10">
			    	<input id="inputDescripcion" name="descripcion" class="form-control" type="text" value=<%=can.getDescripcion()%> disabled>
			    </div>
		    </div>
		    
		   	<div class="form-group">
			    <label for="inputTipo" class="control-label col-md-2">Tipo:</label>
			    <div class="col-md-10">
			    	<input id="inputTipo" name="tipo" class="form-control" type="text" value=<%=can.getTipo()%> disabled>	
			    </div>
		    </div>
		    
		    <div class="form-group">
			    <label for="inputLuz" class="control-label col-md-2">Luz:</label>
			    <div class="col-md-10">
			    	<input id="inputLuz" name="luz" class="form-control" type="text" value=<%=can.isLuz()%> disabled>
			    </div>
		    </div>
		    
        	
			<div class="form-group">
            	<div class="col-md-2">
            		<input type="submit" class="btn btn-primary" name="action" value="Eliminar">
            	</div>
        	</div>
        
         	<div class="form-group">
            	<div class="col-md-2">
            		<input type="submit" class="btn btn-secondary" name="action" value="Cancelar">
            	</div>
        	</div>
        <% 
        	session.setAttribute("c", can);
        %>

        </form>

       

	</div>
</body>
</html>