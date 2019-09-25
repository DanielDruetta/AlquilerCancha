<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="entidades.Cliente"%>
<!DOCTYPE html>
<html>
<head>

    <% 
   
    	Cliente cli= (Cliente)session.getAttribute("usuario");
    %>
		<title>Futbol 5</title>
    	<link rel="icon" href="https://http2.mlstatic.com/pelota-futbol-adidas-epp-2-b-D_NQ_NP_662338-MLA29510542741_022019-F.jpg">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>
     <div class="container">
	    <form class="form-bajaclienteconfirmado" action="BajaClienteConfirmado" method="post">
		    
		    <div class="form-group col-md-12">
			    <br/>
			    <h3>Cliente</h3>
		    </div>
		    
		    <div class="form-group">
			    <label for="inputDni" class="control-label col-md-2">DNI:</label>
			    <div class="col-md-10">
			    <label id="inputDni" name="dni" class="form-control" type="number" placeholder="" ><%=cli.getDni()%></label>
			    </div>
		    </div>
		    
		    <div class="form-group">
			    <label for="inputNombre" class="control-label col-md-2">Nombre</label>
			    <div class="col-md-10">
			    <label id="inputNombre" name="nombre" class="form-control" type="text" placeholder="" ><%=cli.getNombre()%></label>
			    </div>
		    </div>
		    
		   	<div class="form-group">
			    <label for="inputApellido" class="control-label col-md-2">Apellido:</label>
			    <div class="col-md-10">
			    <label id="inputApellido" name="apellido" class="form-control" type="text" placeholder="" ><%=cli.getApellido()%></label>
			    </div>
		    </div>
		    
		    <div class="form-group">
			    <label for="inputUsuario" class="control-label col-md-2">Usuario:</label>
			    <div class="col-md-10">
			    <label id="inputUsuario" name="usuario" class="form-control" type="text" placeholder="" ><%=cli.getUsuario()%></label>
			    </div>
		    </div>
		    
		    <div class="form-group">
			    <label for="inputEmail" class="control-label col-md-2">Email:</label>
			    <div class="col-md-10">
			    <label id="inputEmail" name="email" class="form-control" type="email" placeholder="" ><%=cli.getEmail()%></label>
			    </div>
		    </div>
		    
		    <div class="form-group">
			    <label for="inputCelular" class="control-label col-md-2">Celular:</label>
			    <div class="col-md-10">
			    <label id="inputCelular" name="celular" class="form-control" type="number" placeholder="" ><%=cli.getCelular()%></label>
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
        <% session.setAttribute("c", cli);
        %>
	</form>
	</div>

</body>
</html>