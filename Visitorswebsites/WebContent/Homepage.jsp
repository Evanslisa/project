<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="resources/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="resources/js/validation.js"></script>
</head>
<body>
<jsp:include page="Menu.jsp" />
<jsp:include page="Veiwnames.jsp" />
<a href="DeleteAdmin.jsp">DELETE ADMIN BY ID </a><br>
<a href="Edit.jsp">EDIT BY ID</a><br>
<a href="Deletevisitor.jsp">DELETE VISITOR BY ID</a><br>
<a href="./ViewallVisitorsServlet">VIEW ALL VISITORS</a>
<form action="./VisitorsServlet" method="post"  name="regform" >
<h1 align="center">REGISTER WITH VISITORS WEBSITE</h1>
<table border="0" cellpadding="5" cellspacing="2" align="center">
<tr><td>FULL NAME:</td><td><input  type="text" name="name" id="name" size="35"></td></tr>
<tr><td>DISCRIPTION:</td><td><input  type="text" name="dis"  id="dis" size="35"></td></tr>
<tr><td>PHONE NUMBER:</td><td><input  type="text" name="telephone" id="telephone" size="35"></td></tr>
<tr><td>ID NUMBER:</td><td><input  type="text" name="idnumber" id="idnumber" size="35"></td></tr>
<tr><td>GENDER:</td> <td><select name="gender"  id="gender" size="1"><option>MALE</option><option>FEMALE</option></select></td></tr>
<tr><td>ADDRESS:</td><td><input  type="text" name="address" id="address" size="35"></td></tr>
<tr><td>EMAILADDRESS:</td><td><input  type="text" name="emailAddress" id="emailAddress" size="35"></td></tr>
<tr><td colspan="7" align="center"><input type="submit"  value="Submit" onclick="return Visitors_Check();"><input type="reset" value="Refresh"></td></tr>
</table>
</form>
</body>
</html>