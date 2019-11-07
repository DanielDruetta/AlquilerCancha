<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="entidades.Establecimiento"%>
<%@page import="data.DataEstablecimiento"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Cliente"%>
<!DOCTYPE html>
<html>
<head>

 <% 
 		Establecimiento e= (Establecimiento)session.getAttribute("establec");
 		DataEstablecimiento de=new DataEstablecimiento();
 		ArrayList<Integer> canchas = new ArrayList<Integer>();
 		canchas= de.canchas(e.getNombre());	
 
    %>
<title>Futbol 5</title>
    	<link rel="icon" href="https://http2.mlstatic.com/pelota-futbol-adidas-epp-2-b-D_NQ_NP_662338-MLA29510542741_022019-F.jpg">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </head>
  
  
  <body>
     <div class="container">
	    <form class="form-modificacionprecio" action="ModificacionPrecio" method="post">
		    <div class="form-group col-md-12">
			    <br/>
			    <h3>Alta precio</h3>
		    </div>
		    
		    <div class="form-group">
			    <label for="inputEstablecimiento" class="control-label col-md-2">Numero de cancha:</label>
			    <div class="col-md-7">
			    	<select class="col-md-12" id="inputEstablecimiento" name="inputEstablecimiento">
						<% for (Integer nro:canchas) {%>

						<option class=form-control value="<%=nro%>"><%=nro%></option>

					<%} %>
					</select>
			    </div>
		 </div>
		    
		    <div class="form-group">
			    <label for="inputPrecio" class="control-label col-md-2">Nuevo precio:</label>
			    <div class="col-md-10">
			    	<input id="inputPrecio" name="inputPrecio" class="form-control" type="number" step="0.01">
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