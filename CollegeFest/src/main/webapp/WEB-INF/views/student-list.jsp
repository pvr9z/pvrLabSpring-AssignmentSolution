<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>STUDENT MANAGEMENT</title>
</head>
<body>
	<div class="container">
		<h3>STUDENT MANAGEMENT</h3>
		<hr>

		<!-- Add a button -->
		<a href="/CollegeFest/students/showFormForAdd"
			class="btn btn-primary btn-sm mb-3"> Add student </a>

		<table class="table table-bordered table-striped">
			<thead>

				<tr>
					<th>Name</th>
					<th>Department</th>
					<th>Country</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${students}" var="tempstudent">
					<tr>
						<td><c:out value="${tempstudent.name}" /></td>
						<td><c:out value="${tempstudent.department}" /></td>
						<td><c:out value="${tempstudent.country}" /></td>
						<td>
							<!-- Add "update" button/link --> 
							<a
							href="/CollegeFest/students/showFormForUpdate?studentId=${tempstudent.id}"
							class="btn btn-info btn-sm"> Update </a> 
							<!-- Add "delete" button/link -->
							<a
							href="/CollegeFest/students/delete?studentId=${tempstudent.id}"
							class="btn btn-danger btn-sm"
							onclick="if (!(confirm('Are you sure you want to delete this student?'))) return false">
								Delete </a>

						</td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
</body>
</html>