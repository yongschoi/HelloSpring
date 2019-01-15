<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Upload One File</title>
</head>
<body>
	<jsp:include page="../_menu.jsp" />

	<h3>Upload One File:</h3>

	<!-- MyUploadForm -->
	<form:form modelAttribute="uploadForm" method="POST" action="" enctype="multipart/form-data">
        <br>             
        File to upload: <form:input path="fileDatas" type="file" />
		<br />
		<br />		
		<input type="submit" value="Upload">

	</form:form>

</body>
</html>