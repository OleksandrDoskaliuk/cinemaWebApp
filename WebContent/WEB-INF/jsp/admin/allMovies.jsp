<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="/WEB-INF/jstllib.tld" prefix="m" %>
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
			<c:out value="${item.name}"/>
			<m:duration value="${item.duration}"></m:duration>
		<form action="controller">
			<input type="hidden" name="command" value="gotoAddMovieToSchedule"> 
			<input type="hidden" name="movieId" value="${item.movieId}">
			<input type="submit" value="Add to schedule">
		</form>
		<form action="controller">
			<input type="hidden" name="command" value="gotoRemoveFromSchedule"> 
			<input type="hidden" name="movieId" value="${item.movieId}">
			<input type="submit" value="Remove from schedule">
		</form>
	</c:forEach>
</body>
</html>