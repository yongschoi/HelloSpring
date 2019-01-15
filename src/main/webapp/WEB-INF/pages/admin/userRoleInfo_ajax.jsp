<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<form name="userRoleForm">
		<input type="hidden" name="username" value="${user.userName}">
		<table border="1">
			<tr>
				<th>Index</th>
				<th>Role</th>
				<th>Grant</th>
			</tr>
			<tr>
				<td>1</td>
				<td>user</td>
				<td><input type="checkbox" name="roles" value="USER"
					<c:forEach var="role" items="${user.userRoles}">
						<c:if test="${role=='USER'}">checked</c:if>
					</c:forEach> />
				</td>
			</tr>
			<tr>
				<td>2</td>
				<td>developer</td>
				<td><input type="checkbox" name="roles" value="DEVELOPER"
					<c:forEach var="role" items="${user.userRoles}">
						<c:if test="${role=='DEVELOPER'}">checked</c:if>
					</c:forEach> />
				</td>
			</tr>
			<tr>
				<td>3</td>
				<td>dba</td>
				<td><input type="checkbox" name="roles" value="DBA"
					<c:forEach var="role" items="${user.userRoles}">
						<c:if test="${role=='DBA'}">checked</c:if>
					</c:forEach> />
				</td>
			</tr>
			<tr>
				<td>4</td>
				<td>admin</td>
				<td><input type="checkbox" name="roles" value="ADMIN"
					<c:forEach var="role" items="${user.userRoles}">
						<c:if test="${role=='ADMIN'}">checked</c:if>
					</c:forEach> />
				</td>
			</tr>
			<tr>
				<td>5</td>
				<td>root</td>
				<td><input type="checkbox" name="roles" value="ROOT"
					<c:forEach var="role" items="${user.userRoles}">
						<c:if test="${role=='ROOT'}">checked</c:if>
					</c:forEach> />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>