<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Administration page</title>
</head>
<body>

	<form action="controller">
		<input type="hidden" name="command" value="adminCommand">
		<input type = "submit" name="showMovies" value = "Show all movies">
		<input type = "submit" name="showAttendance" value = "Show cinema hall attendance">
	</form>
	
</body>
</html>