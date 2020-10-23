<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registered</title>
<style type="text/css">
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #f2f2f2
}

th {
	background-color: #0080ff;
	color: black;
}
</style>
</head>
<body>
	<h1>Users Registered</h1>
	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
		</tr>
		<c:forEach items="${userList}" var="user">
			<tr>
				<td><c:out value="${user.id}" /></td>
				<td><c:out value="${user.name}" /></td>
				<td><c:out value="${user.email}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>