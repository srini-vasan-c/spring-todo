<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Page</title>
</head>
<body>
	<h2>Application Error, please contact support.</h2>

	<h3>Debug Information:</h3>

	Requested URL= ${url}
	<br>
	<br> Exception= ${exception.message}
	<br>
	<br>

	<strong>Exception Stack Trace</strong>
	<br>
	<c:forEach items="${exception.stackTrace}" var="ste">
	${ste}
</c:forEach>

</body>
</html>