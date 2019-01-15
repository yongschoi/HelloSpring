<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Spring MVC ::: Idle Test</title>
</head>
<body><jsp:include page="../_menu.jsp" />
	<form action="${pageContext.request.contextPath}/admin/sessionTimeoutTestTest"
		method="post">
		<div class="container">
			<label><b>Session Timeout</b></label> 
			<input type="text" placeholder="Session Timeout" name="secTime" required> <b>(sec)</b>
			<button type="submit">Apply</button>
		</div>
	</form>
	<br>
	${out}
</body>
</html>