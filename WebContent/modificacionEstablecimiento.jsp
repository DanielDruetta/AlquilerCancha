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
 		DataEstablecimiento de = new DataEstablecimiento();
 		request.getSession().setAttribute("listaEstablecimientos", de.getAll());
 		ArrayList<Establecimiento> es=(ArrayList<Establecimiento>)session.getAttribute("listaEstablecimientos");
 
    %>
		<title>Futbol 5</title>
    	<link rel="icon" href="https://http2.mlstatic.com/pelota-futbol-adidas-epp-2-b-D_NQ_NP_662338-MLA29510542741_022019-F.jpg">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </head>
<body>

     <div class="container">
	    <form class="form-ModificacionEstablecimiento" action="ModificacionEstablecimiento" method="post">
		    <div class="form-group col-md-12">
			    <br/>
			    <h3>Modificar Establecimiento</h3>
		    </div>
		    
		    <div class="form-group">
			    <label for="inputEstablecimiento" class="control-label col-md-2">Establecimiento:</label>
			    <div class="col-md-10">
			    	<select class="col-md-12" id="inputEstablecimiento" name="inputEstablecimiento">
						<% for (Establecimiento c:es) {%>

						<option class=form-control value="<%=c.getNombre()%>"><%=c.getNombre()%></option>

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