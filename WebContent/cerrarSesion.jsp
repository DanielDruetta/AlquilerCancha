<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp" />
</head>

<body>

	<%
		request.getSession().setAttribute("establec", null);
		request.getSession().setAttribute("usuario", null);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	%>

	<jsp:include page="footer.jsp" />


</body>
</html>