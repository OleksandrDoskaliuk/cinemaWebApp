<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Schedule</title>
</head>
<body>
<h2>Schedule</h2>
	<table id="list_menu_table">
					<thead>
						<tr>
							<td>N</td>
							<td>Name</td>
							<td>Duration</td>
							<td>StartTime</td>
							<td>SeatsReserved</td>
						</tr>
					</thead>
	
					<c:set var="k" value="0"/>
					<c:forEach var="item" items="${scheduleItems}">
						<c:set var="k" value="${k+1}"/> 
						<tr>
							<td><c:out value="${k}"/></td>
							<td>${item.movieName}</td>
							<td>${item.movieDuration}</td>
							<td>${item.startTime}</td>
							<td>${item.reservedSeats}</td>
						</tr>
					</c:forEach>
				</table>
</body>
</html>