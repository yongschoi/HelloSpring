<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Spring MVC ::: 권한관리</title>
</head>
<body>
	<!-- menu.jsp에 jquery-3.2.1.min.js 선언-->
	<jsp:include page="../_menu.jsp" />
	<script type="text/javascript">
		$(function() {
			$('.retrieveUsername').click(function() {
				var username = $('input[name=username]').val();
				$.ajax({
					type : "GET",
					url : "${pageContext.request.contextPath}/admin/retrieveUser?userNameParam="+ username,
					dataType : "text",
					error : function() {
						alert('통신실패!!');
					},
					success : function(data) {
						$("#dataArea").html(data);
					}
				});
			});
			
			$('.commitUserRoles').click(function() {
				$.ajax({
					type : "POST",
					url : "${pageContext.request.contextPath}/admin/updateUserRole",
					data : $("form").serialize(),
					error : function() {
						alert('통신실패!!');
					},
					success : function(data) {
						$("#dataArea").html(data);
					}
				});
			});
		});
	</script>

	<div class="container">
		<label><b>Username</b></label> 
		<input type="text" placeholder="Enter User Name" name="username">
		<button class="retrieveUsername">조회</button>
		<button class="commitUserRoles">저장</button>
	</div>

	<div id="dataArea"></div>
</body>
</html>