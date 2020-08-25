<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp" />
</head>

<body>

	<%
		session.invalidate();
		response.sendRedirect("index.jsp");

	%>

	<jsp:include page="footer.jsp" />


</body>
</html>