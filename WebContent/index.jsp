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
		<img
			style="border: 1px solid #ddd; border-radius: 4px; padding: 5px; width: 700px;"
			width=700px
			src="https://as.com/futbol/imagenes/2019/05/09/primera/1557392347_052135_1557392561_noticia_normal.jpg">
		<img
			style="border: 1px solid #ddd; border-radius: 4px; padding: 5px; width: 700px;"
			class="cancha" width=700px
			src="https://resources.premierleague.com/premierleague/photo/2016/09/22/c9c78d39-60fb-47c6-9e20-837efb242ac5/Stamford_Bridge.jpg">
	</div>


	<jsp:include page="footer.jsp" />



</body>
</html>