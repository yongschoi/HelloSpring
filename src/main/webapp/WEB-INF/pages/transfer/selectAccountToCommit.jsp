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
	<form action="${pageContext.request.contextPath}/commit.transfer" method="post" >
		<table>
			<tr>
				<td>
					<table border=1>
						<tr>
							<td colspan="2" align=center><b>Bank ::: 우리은행</b></td>
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
							<td><b>이체금액</b></td>
							<td><input type="text" name="tmoney"></td>
						</tr>
						<tr>
							<td><b>예금주명</b></td>
							<td align=center>${account.name}</td>
						</tr>
					</table> 
				</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td  width="30%" align="center">
					<button type="submit">>>>&nbsp;&nbsp;이체실행&nbsp;&nbsp;>>></button>
				</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>
					<table border=1>
						<tr>
							<td colspan="2" align=center><b>Bank ::: 너네은행</b></td>
						</tr>
						<tr>
							<td><b>Account Number</b></td>
							<td><input type="text" name="targetNo"></td>
						</tr>
					</table>
				</td>		
			<tr>		
		</table>		
	</form>
</body>
</html>