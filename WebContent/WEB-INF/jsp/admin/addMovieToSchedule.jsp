<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="/WEB-INF/jstllib.tld" prefix="m" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add movie to schedule</title>
</head>
<body>
<h1>Add movie to schedule</h1>
<script type="text/javascript">
	function hideAddSubmit() {
		let elem = document.getElementById("hideble");
		elem.setAttribute("hidden", "true");
		elem = document.getElementById("warnText");
		elem.removeAttribute("hidden");
	}
</script>
<form action="controller">
	<input type="hidden" name="command" value="gotoAddMovieToSchedule"> 
	<input type="hidden" name="movieId" value="${movie.movieId}">
	<c:out value="${movie.name}"></c:out>
	<m:duration value="${movie.duration }"/>
	<label for="date">Date:</label>
	<select name = "date" onchange=hideAddSubmit()>
		<c:forEach var="item" items="${dateItems}">
			<option <c:if test="${param.date == item}">selected="selected"</c:if> value="${item}">${item}</option>
		</c:forEach>
	</select>
	<input type="submit" value="Apply">
	<br>
	<label for="time">Time:</label>
	<select name = "time" >
		<c:forEach var="item" items="${timePoints}">
			<option value="${item}">${item}</option>
		</c:forEach>
	</select>
	<p id ="warnText" hidden="true">Apply date changes!</p>
	<input id="hideble" type="submit" name="commit" value= "Add"> 
</form>
</body>
</html>