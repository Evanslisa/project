<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="resources/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="resources/js/validation.js"></script>
<title>Insert title here</title>
<jsp:include page="Menu.jsp" />
</head>
<body>
<form action="./PrintServlet" method="post" >
<table border="0" cellpadding="0" cellspacing="0">
<tr>
<td>
<input type="text" name="id" size="40"/><input type="submit"  value="Print by ID" >
</td>
</tr>
</table>
</form>

</body>
</html>