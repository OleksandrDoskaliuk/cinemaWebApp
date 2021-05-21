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
		<input type = "hidden" name = "command" value = "showAllMovies">
		<input type = "submit" value = "Show all movies">
 	</form>
 	
 	<form action="controller">
		<input type = "hidden" name = "command" value = "gotoCreateNewMovie">
		<input type = "submit" value = "Create new movie">
 	</form>
 	
 	<form action="controller">
		<input type = "hidden" name = "command" value = "gotoAddMovieToSchedule">
		<input type = "submit" value = "Add movie to schedule">
 	</form>
 	
 	<form action="controller">
		<input type = "hidden" name = "command" value = "gotoRemoveMovieFromSchedule">
		<input type = "submit" value = "Remove movie from schedule">
 	</form>
 	
 	<form action="controller">
		<input type = "hidden" name = "command" value = "showCinemaHallAttendance">
		<input type = "submit" value = "Show cinema hall attendance">
 	</form>
</body>
</html>