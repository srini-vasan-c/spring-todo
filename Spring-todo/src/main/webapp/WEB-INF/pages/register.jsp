<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
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
		<div class="container">
			<div class="card">
				<div class="card-header">Register New User</div>
				<div class="card-body">
					<form action='<c:url value="/save-register"></c:url>' method="post">
						<div class="form-group">
							<label for="input-name">Password</label> <input type="text"
								class="form-control" id="input-name" name="input-name"
								placeholder="Enter Name">
						</div>
						<div class="form-group">
							<label for="input-email">Email address</label> <input
								type="email" class="form-control" id="input-email"
								name="input-email" aria-describedby="emailHelp"
								placeholder="Enter email"> <small id="emailHelp"
								class="form-text text-muted">We'll never share your
								email with anyone else.</small>
						</div>
						<div class="form-group">
							<label for="input-password">Password</label> <input
								type="password" class="form-control" id="input-password"
								name="input-password" placeholder="Password">
						</div>
						<div class="form-group form-check">
							<input type="checkbox" class="form-check-input"
								id="input-check-in" name="input-check-in" checked> <label
								class="form-check-label" for="exampleCheck1">Check me in</label>
						</div>
						<button type="submit" class="btn btn-primary">Submit</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>