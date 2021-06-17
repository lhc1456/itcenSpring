<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"%>
<%
	response.setStatus(200);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error</title>
</head>
<body>
	<h2>
		요청 처리 과정에서 문제가 발생하였습니다. <br /> 빠른시간 내에 문제를 해결하도록 하겠습니다.
	</h2>
	<p>
		오류타입 :
		<%=exception.getClass().getName()%>
		<br /> 오류메시지 : <b><%=exception.getMessage()%></b>
	</p>
	<hr>
	<a href="${pageContext.request.contextPath}/main"> Main </a>
</body>
</html>