<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All movies</title>
</head>
<body>
<h1>All movies</h1>
<br>
	<c:forEach var="item" items="${movies}">
		<c:out value = "${item.name }"/>
		<c:out value = "${item.duration }"/>
		<br>
	</c:forEach>
</body>
</html>