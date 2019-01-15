<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Spring MVC ::: 거래내역</title>
</head>
<body><jsp:include page="../_menu.jsp" />
	<div align="center">
		<h1>거래 내역</h1>
		<table border="1">
			<tr>
				<th>출금계좌</th>
				<th>이체금액</th>
				<th>이체일시</th>
				<th>입금계좌</th>
			</tr>
			<c:forEach var="account" items="${accountHistory}" varStatus="status">
				<tr>
					<td>${account.no}</td>
					<td align=right>${account.tmoney}</td>
					<td>${account.date}</td>
					<td>${account.target}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>