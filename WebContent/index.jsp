<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="entidades.Establecimiento"%>
<!DOCTYPE html>
<html>
<head>
<style>
#cancha {
	border: 1px solid #ddd;
	border-radius: 4px;
	padding: 5px;
	width: 500px;
}
</style>

<jsp:include page="header.jsp" />
</head>


<body>
	<div align="center">

		<%
			if (request.getAttribute("mensajeError") != null) {
		%>
		<div class="alert alert-danger" role="alert"> <%=request.getAttribute("mensajeError")%> </div>
		<%
			}
		%>

		<%
			if (request.getAttribute("mensajeOk") != null) {
		%>
		<div class="alert alert-success" role="alert"> <%=request.getAttribute("mensajeOk")%> </div>
		<%
			}
		%>

		<div id="carouselExampleSlidesOnly" class="carousel slide"
			data-ride="carousel" data-interval="4000">
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img class="d-block w-50"
						style="border: 1px solid #ddd; border-radius: 4px; padding: 5px; width: 700px;"
						width=700px
						src="https://as.com/futbol/imagenes/2019/05/09/primera/1557392347_052135_1557392561_noticia_normal.jpg">
				</div>
				<div class="carousel-item">
					<img class="d-block w-50"
						style="border: 1px solid #ddd; border-radius: 4px; padding: 5px; width: 700px;"
						class="cancha" width=700px
						src="https://resources.premierleague.com/premierleague/photo/2016/09/22/c9c78d39-60fb-47c6-9e20-837efb242ac5/Stamford_Bridge.jpg">
				</div>
				<div class="carousel-item">
					<img class="d-block w-50"
						style="border: 1px solid #ddd; border-radius: 4px; padding: 5px; width: 700px;"
						width=700px
						src="https://www.rosario3.com/__export/1586269670545/sites/rosario3/img/2020/04/07/bayer.jpg_1756841869.jpg">

				</div>
				<div class="carousel-item">
					<img class="d-block w-50"
						style="border: 1px solid #ddd; border-radius: 4px; padding: 5px; width: 700px;"
						width=700px
						src="https://www.insidermedia.com/uploads/news/resized/AnfieldRoadStand_01-18957-1592919621.jpg">

				</div>
			</div>
		</div>

	</div>

	<jsp:include page="footer.jsp" />
</body>
</html>

