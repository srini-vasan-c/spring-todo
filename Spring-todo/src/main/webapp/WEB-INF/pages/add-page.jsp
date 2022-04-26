<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<div class="container">
	<form name="addForm" id="addForm"
		action="<c:url value='/save-todo'></c:url>" method="post">
		<div class="form-group row">
			<label for="form-title" class="col-sm-2 col-form-label">Title</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="form-title" name="form-title"
					placeholder="Title">
			</div>
		</div>
		<div class="form-group row">
			<label for="form-description" class="col-sm-2 col-form-label">Password</label>
			<div class="col-sm-10">
				<textarea class="form-control" id="form-description" name="form-description"
					placeholder="Description .."></textarea>
			</div>
		</div>
		<div class="form-group row">
			<div class=" text-center">
				<button class="btn btn-outline-success">Add</button>
			</div>
		</div>
	</form>
</div>