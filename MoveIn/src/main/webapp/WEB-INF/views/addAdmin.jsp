<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<c:if test="${ who == null}">
    	<c:redirect url="main"/>
    </c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>관리자 추가</title>
</head>
<body>
<div>
	<c:import url="sidebar.jsp"/>
	<form action="addAdmin" method="post" name="regF">
		<fieldset id="page">
			<legend class="title">관리자 추가</legend>
			<div>
				<table class="info">
					<tbody>
						<tr>
							<td><label class="req lb" for="aId" >아이디</label></td>
							<td><input type="text" name="aId" id="aId" /></td>
						</tr>
						<tr>
							<td><label class="req lb" for="aPw" >비밀번호</label></td>
							<td><input type="password" name="aPw" id="aPw" /></td>
						</tr>
						<tr>
							<td><label class="req lb" for="aName" >이름</label></td>
							<td><input type="text" name="aName" id="aName" /></td>
						</tr>
					</tbody>
				</table>
				<div class="bottomBtn">
					<input type="button" value="확인" onclick="adminInfoConfirm()" />
					<input type="button" value="취소" onclick="javascript:window.location='adminList'" />
				</div>
			</div>
		</fieldset>
	</form>
</div>
</body>
</html>