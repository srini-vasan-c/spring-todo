<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
</head>
<body class="container">
	<nav id="navbar-example2" class="navbar navbar-light bg-light">
		<a class="navbar-brand" href="<c:url value='/dashboard'></c:url>">Daily
			App</a>
		<ul class="nav nav-pills">
			<li class="nav-item"><a class="nav-link"
				href="<c:url value='/add'></c:url>">Add</a></li>
			<li class="nav-item"><a class="nav-link"
				href="<c:url value='/view'></c:url>">View</a></li>
			<li class="nav-item"><a class="nav-link"
				href="<c:url value='/upload'></c:url>">Upload</a></li>
			<li class="nav-item"><a class="nav-link"
				href="<c:url value='/'></c:url>">Logout</a></li>
			<!-- 			<li class="nav-item dropdown"><a -->
			<!-- 				class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" -->
			<!-- 				role="button" aria-haspopup="true" aria-expanded="false">Dropdown</a> -->
			<!-- 				<div class="dropdown-menu"> -->
			<!-- 					<a class="dropdown-item" href="#one">one</a> <a -->
			<!-- 						class="dropdown-item" href="#two">two</a> -->
			<!-- 					<div role="separator" class="dropdown-divider"></div> -->
			<!-- 					<a class="dropdown-item" href="#three">three</a> -->
			<!-- 				</div></li> -->
		</ul>
	</nav>
	<br>
	<div class="container" id="display-content">
		<c:if test="${page=='add'}">
			<jsp:include page="add-page.jsp"></jsp:include>
		</c:if>
		<c:if test="${page=='view'}">
			<jsp:include page="view-page.jsp"></jsp:include>
		</c:if>
		<c:if test="${page=='upload'}">
			<jsp:include page="upload-page.jsp"></jsp:include>
		</c:if>
	</div>
</body>
</html>