<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<c:if test="${ who == null}">
    	<c:redirect url="/main"/>
    </c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 탈퇴</title>
</head>
<body>

<div>
	<c:import url="../frame/sidebar.jsp"/>
	<c:if test="${who == 'admin' }">
		<fieldset id="page">
			<legend class="title">관리자 탈퇴</legend>
			<form action="/member/withdrawalAdmin" name="withdrawalF">	
				<input type="button" class="withdrawalBtn" onclick="withdrawalAdmin()" value="관리자 탈퇴" />
			</form>
		</fieldset>
	</c:if>
	<c:if test="${ who == 'member' }">
		<fieldset id="page">
			<legend class="title">회원 탈퇴</legend>
			<form action="/member/withdrawalMember" name="withdrawalF">
				<input type="button" class="withdrawalBtn" onclick="withdrawalMember()" value="회원 탈퇴" />
			</form>
		</fieldset>
	</c:if>
</div>

</body>
</html>