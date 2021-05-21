<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create new movie</title>
</head>
<body>
<h1>Create new movie</h1>

<form action="controller" method="post">
	<input type="hidden" name="command" value="createNewMovie">
	Name:<input type="text" name="name">
	Duration:<input type="text" name="duration">
	<input type="submit" value = "Create">
</form>
</body>
</html>