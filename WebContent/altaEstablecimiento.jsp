<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="entidades.Establecimiento"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Cliente"%>
<!DOCTYPE html>
<html>
<head>

<title>Futbol 5</title>
    	<link rel="icon" href="https://http2.mlstatic.com/pelota-futbol-adidas-epp-2-b-D_NQ_NP_662338-MLA29510542741_022019-F.jpg">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </head>
  <body>
     <div class="container">
	    <form class="form-altaestablecimiento" action="AltaEstablecimiento" method="post">
		    <div class="form-group col-md-12">
			    <br/>
			    <h3>Alta establecimiento</h3>
		    </div>
		    
		     <div class="form-group">
			    <label for="inputNombre" class="control-label col-md-4">Nombre del establecimiento:</label>
			    <div class="col-md-10">
			    <input id="inputNombre" name="nombre" class="form-control" type="text">
			    </div>
		    </div>
		    
		     <div class="form-group">
			    <label for="inputDireccion" class="control-label col-md-4">Direccion del establecimiento:</label>
			    <div class="col-md-10">
			    <input id="inputDireccion" name="direccion" class="form-control" type="text">
			    </div>
		    </div>
		    
		    <div class="form-group">
			    <label for="inputUsuario" class="control-label col-md-4">Usuario:</label>
			    <div class="col-md-10">
			    <input id="inputUsuario" name="usuario" class="form-control" type="text">
			    </div>
		    </div>
		    
		    <div class="form-group">
			    <label for="inputContraseña" class="control-label col-md-4">Contraseña:</label>
			    <div class="col-md-10">
			    <input id="inputContraseña" name="contraseña" class="form-control" type="text">
			    </div>
		    </div>
		    
		    <div class="form-group">
			    <label for="inputHoraInicio" class="control-label col-md-4">Hora inicio:</label>
			    <div class="col-md-10">
			   
			    <select id="inputHoraInicio" name="inputHoraInicio">
				<% for (int hi=0; hi<=23 ;hi++) {%>

				<option class=form-control value="<%=Integer.toString(hi)%>"><%=Integer.toString(hi)%></option>

				<%} %>
				</select>
			    </div>
			    
		    </div>
		    
		    
		       <div class="form-group">
			    <label for="inputHoraFin" class="control-label col-md-2">Hora fin:</label>
			    <div class="col-md-10">
			   
			    <select id="inputHoraFin" name="inputHoraFin">
				<% for (int hf=0; hf<=23 ;hf++) {%>

				<option class=form-control value="<%=Integer.toString(hf)%>"><%=Integer.toString(hf)%></option>

				<%} %>
				</select>
			    </div>
			    
			    
		    </div>
		    
		    <div class="form-group">
            <div class="col-md-2">
                 <input type="submit" class="btn btn-primary" name="act" value="Aceptar">   
            </div>
        </div>

        </form>

       

	</div>
</body>
</html>