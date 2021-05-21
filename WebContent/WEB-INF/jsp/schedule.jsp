<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" media="screen" href="style/styles.css"/>
<title>Schedule</title>
</head>
<body>
<h2>Schedule</h2>
	<div class = "gap"></div>
	<main class="main">
		<div class = "sorting-filtering-date">
			<form action="controller" method = "post">
				<input type="hidden" name="command" value="schedule"/>
				<label for="sorting">Sorting:</label>
				<select  id="sorting" name="sorting">
					<option <c:if test="${param.sorting == 'BY_DATE'}">selected="selected"</c:if> value="BY_DATE">By date</option>
					<option <c:if test="${param.sorting == 'BY_NAME'}">selected="selected"</c:if> value="BY_NAME">By name
					<%-- <option <c:if test="${param.sorting == 'BY_SEATS'}">selected="selected"</c:if> value="BY_SEATS">By free seats</option> --%>
				</select>
				
				<label for="filtering">Filtering</label>
				<select id="filtering" name="filtering">
					<option <c:if test="${param.filtering == 'AVAILABLE'}">selected="selected"</c:if> value="AVAILABLE">Show available</option>
					<option <c:if test="${param.filtering == 'ALL'}">selected="selected"</c:if> value="ALL">Show all</option>
				</select>
				
				<label for="date">Date</label>
				<select id="date" name="date">
					<c:forEach var="item" items="${dateItems}">
						<option <c:if test="${param.date == item}">selected="selected"</c:if> value="${item}">${item}</option>
						<br>
					</c:forEach>
				</select>
				
				<input type="submit" value="Apply"/>
			</form>
			<br>
			<c:forEach var="item" items="${scheduleItems}">
				<c:out value="${item.movieName}"></c:out>
				<c:out value="${item.movieDuration}"></c:out>
				<c:out value="${item.movieStartTime}"></c:out>
				<br>
			</c:forEach>
			
		</div>
	</main>
</body>
</html>