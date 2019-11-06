<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="entidades.Reserva"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Ocupada"%>
<%@page import="entidades.Establecimiento"%>
<%@page import="data.DataReserva"%>
<%@page import="data.DataCliente"%>
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
   Establecimiento e=(Establecimiento) session.getAttribute("establec");
   DataReserva dr = new DataReserva();
   ArrayList<Reserva> reservas = new ArrayList<Reserva>();
   reservas= dr.reservasDia(e.getNombre());	  
   DataCliente dc = new DataCliente();

    %>
    
    </head>
<body>
<nav class="site-header sticky-top py-1">
	  <div class="container d-flex flex-column flex-md-row justify-content-between">
	    <a class="py-2" href="menuDue�o.html">
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
		<br/>
		 <h3>Reservas del dia</h3>
  <form class="form-confirmarReserva" action="ConfirmarReserva" method="post">
   <div class="row">
		  <div class="col-12 col-sm-12 col-lg-12">
		   <div class="table-responsive">
		    <table class="table">
		     <thead>
		      <tr>
		       
		        
		        <th>Numero de reserva</th>
		        <th>Numero de cancha</th>
		        <th>Hora inicio</th>
		        <th>Hora fin</th>
		        <th>DNI del cliente</th>
		        <th>Nombre y apellido</th>
		        <th>Celular</th>
		        <th> </th>
		      </tr>
		    </thead>
		    <tbody>
		    
		    <% for (Reserva disp : reservas) {%>
		      <tr>
		        <td><%=disp.getNumero_reserva()%></td>
		        <td><%=disp.getNumero_cancha()%></td>
		        <td><%=disp.getHora_inicio()%></td>
		        <td><%=disp.getHora_inicio()+1%></td>
		 	    <td><%=disp.getDni()%></td>
		 	    <td><%=(dc.buscarDNI(disp.getDni())).getNombre()+" "+(dc.buscarDNI(disp.getDni())).getApellido()%></td>
		 	    <td><%=(dc.buscarDNI(disp.getDni())).getCelular()%></td>
		 	   </tr>
		 	   
		      <%} %>
		    
		     
		    </tbody>
		  </table>
		  </div>
	    </div><!-- end col-12 -->
	  </div><!-- end row -->

      
   </form>
 </div>
</body>
</html>