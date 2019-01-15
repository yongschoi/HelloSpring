<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>File Download List</title>
</head>
<body><jsp:include page="../_menu.jsp" />
	<form action="${pageContext.request.contextPath}/file/delete" method="post">
		<div align="center">
			<h1>File List</h1>
			<table>
				<tr bgcolor="#AEB6BF">
					<th>Name</th>
					<th>File Size(byte)</th>
					<th>Count</th>
					<th>게시자</th>
					<th>Date</th>
					<th>선택</th>
				</tr>
				<c:forEach var="fileInfo" items="${fileList}" varStatus="status">
					<tr bgcolor="#EAEDED">
						<td><a
							href="${pageContext.request.contextPath}/file/download/${fileInfo.seq}">${fileInfo.name}</a></td>
						<td align=right>${fileInfo.size}</td>
						<td align=center>${fileInfo.count}</td>
						<td align=center>${fileInfo.uploader}</td>
						<td>${fileInfo.date}</td>
						<td><input type="checkbox" name="delete" value="${fileInfo.seq}"></td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="6" align="right"><button type="submit">삭제</button></td>
				</tr>
			</table>	
		</div>
	</form>
</body>
</html>