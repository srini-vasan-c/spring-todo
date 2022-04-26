<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Upload File</title>
</head>
<body>

	<div class=" make-center">
		<div class="container">
			<br>
			<div class="card">
				<div class="card-header">Upload Doc</div>
				<div class="card-body">
					<c:if test="${not empty message }">
						<div>
							<c:out value="${message }"></c:out>
						</div>
					</c:if>
					<form action='<c:url value="/upload-save"></c:url>' method="post"
						enctype="multipart/form-data">
						<div class="form-group">
							<label for="input-file">Upload File</label> <input type="hidden"
								name="test" id="test" value="test"> <input type="file"
								class="form-control" id="input-file" name="input-file">
						</div>
						<button type="submit" class="btn btn-primary">Submit</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>