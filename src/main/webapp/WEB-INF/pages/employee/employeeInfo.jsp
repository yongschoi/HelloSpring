<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Spring MVC ::: 사원조회</title>
</head>
<body><jsp:include page="../_menu.jsp" />
	<form action="${pageContext.request.contextPath}/employee/search"
		method="post">
		<div class="container">
			<label><b>Employee Name</b></label> 
			<input type="text" placeholder="Enter Employee Name" name="name" required>
			<button type="submit">조회</button>
		</div>
	</form>
	<br>
	<table border="1">
		<tr>
			<th>Seq</th>
			<th>Name</th>
			<th>Birthdate</th>
			<th>Sex</th>
			<th>Telephone</th>
			<th>Address</th>
			<th>Postal</th>
			<th>Job level</th>
			<th>Department</th>
			<th>Skill</th>
		</tr>
		<tr>
			<td>${employee.seq}</td>
			<td>${employee.name}</td>
			<td>${employee.birthdate}</td>
			<td>${employee.sex}</td>
			<td>${employee.telephone}</td>
			<td>${employee.address}</td>
			<td>${employee.postal}</td>
			<td>${employee.joblevelCode}</td>
			<td>${employee.departmentCode}</td>
			<td>${employee.skillCode}</td>
		</tr>
	</table>
	<br>
	${elapse}
</body>
</html>