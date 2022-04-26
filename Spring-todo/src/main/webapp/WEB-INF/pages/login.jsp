<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<jsp:include page="../includes/includes.jsp"></jsp:include>
<style>
.make-center {
	width: 100%;
	position: relative;
	z-index: 1;
}
</style>
</head>
<body>
	<div class=" make-center">
		<div class="container"><br>
			<div class="card">
				<div class="card-header">Login<span style="float:right"><c:out value="${date} "></c:out></span></div>
				<div class="card-body">
					<form action='<c:url value="/login-validate"></c:url>'
						method="post">
						<div class="form-group">
							<label for="input-email">Email address</label> <input
								type="email" class="form-control" id="input-email"
								name="input-email" aria-describedby="emailHelp"
								placeholder="Enter email">
						</div>
						<div class="form-group">
							<label for="input-password">Password</label> <input
								type="password" class="form-control" id="input-password"
								name="input-password" placeholder="Password">
						</div>
						<button type="submit" class="btn btn-primary">Submit</button>
						<div>
							New User? Click <a href='<c:url value="/register" />'>here
							</a> to Register
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>