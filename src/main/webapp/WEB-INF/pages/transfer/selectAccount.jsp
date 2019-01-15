<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Spring MVC ::: 계좌 정보</title>
</head>
<style>
button {
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
}
</style>
<body>
	<jsp:include page="../_menu.jsp" />
		<table>
			<tr>
				<td>
					<table border=1>
						<tr>
							<td colspan="2" align=center><b>이체결과(잔액)</b></td>
						</tr>
						<tr>
							<td><b>Account Number</b></td>
							<td align=center>${account.no}</td>
							<input type="hidden" name="sourceNo" value="${account.no}">
						</tr>
						<tr>
							<td><b>Balance</b></td>
							<td align=right>${account.balance}</td>
						</tr>
						<tr>
							<td><b>예금주명</b></td>
							<td align=center>${account.name}</td>
						</tr>
					</table> 
				</td>		
			<tr>		
		</table>		

</body>
</html>