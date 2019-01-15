<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Upload Result</title>
</head>
<body>
	<jsp:include page="../_menu.jsp" />
	<h3>Uploaded Files:</h3>

	Description: ${description}
	<br />
	<c:forEach items="${uploadedFiles}" var="file">
           - ${file} <br>
	</c:forEach>
</body>
</html>