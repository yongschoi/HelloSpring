<%@page import="yongs.temp.vo.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Spring MVC ::: HelloWorld</title>
</head>
<body>
	<jsp:include page="_menu.jsp"/>
	<h1>${greeting}</h1>
	::: <%=  ((User) request.getSession(false).getAttribute("SESSION_USER")).getUserName() %>  :::
	<br>
	| <%=  request.getSession(false).getId() %> |
</body>
</html>