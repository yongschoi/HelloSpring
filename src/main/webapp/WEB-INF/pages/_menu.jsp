<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<style>
a:link {
    text-decoration: none;
}

a:visited {
    text-decoration: none;
}

a:hover {
    text-decoration: underline;
}

a:active {
    text-decoration: underline;
}
	</style>
</head>
<body>
<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','https://www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-102300600-1', 'auto');
  ga('send', 'pageview');

</script>

<div style="border: 1px solid #f1f1f1;padding:5px;margin-bottom:20px;background-color:#4CAF50;">
   <a href="${pageContext.request.contextPath}/loginPage">Login</a>
  | &nbsp;
   <a href="${pageContext.request.contextPath}/logout">Logout</a>
  | &nbsp;
  <a href="${pageContext.request.contextPath}/hello">Hello</a>
  | &nbsp;
   <a href="${pageContext.request.contextPath}/user/retrieve?userNameParam=${sessionScope.SESSION_USER.userName}">본인정보확인</a>
  | &nbsp;
   <a href="${pageContext.request.contextPath}/employee/searchForm">Employee Search</a>
  | &nbsp;
   <a href="${pageContext.request.contextPath}/selectAccount.transfer">이체업무</a>
  | &nbsp;
   <a href="${pageContext.request.contextPath}/account/history">거래내역조회</a>
  | &nbsp;
   <a href="${pageContext.request.contextPath}/file/uploadOneFile">Upload One File</a>
  | &nbsp;
   <a href="${pageContext.request.contextPath}/file/list">File Download</a>
  | &nbsp;  
   <a href="${pageContext.request.contextPath}/mail/mailForm">메일보내기</a>
  | &nbsp;
   <a href="${pageContext.request.contextPath}/ws/UserSoap?wsdl">User 웹서비스(WSDL)</a>
  | &nbsp;
   <a href="${pageContext.request.contextPath}/ws/user/${sessionScope.SESSION_USER.userName}">User 웹서비스(REST)</a>  
  | &nbsp;
   <a href="${pageContext.request.contextPath}/cache">EhCache 테스트</a>   
  | &nbsp;
   <a href="${pageContext.request.contextPath}/admin/updateAuthPage">권한관리</a>
  | &nbsp;
   <a href="${pageContext.request.contextPath}/employee/list">Employee List</a>
  | &nbsp;
   <a href="${pageContext.request.contextPath}/admin/stuck">Stuck Test</a>
  | &nbsp;
   <a href="${pageContext.request.contextPath}/admin/idleForm">idle Test</a>
  | &nbsp;
   <a href="${pageContext.request.contextPath}/admin/sessionTimeoutForm">Session Timeout 설정</a>
	&nbsp;
</div>     
</body>
</html>
