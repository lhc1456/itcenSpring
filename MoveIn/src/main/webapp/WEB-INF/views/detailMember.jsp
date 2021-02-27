<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<c:if test="${ who == null}">
    	<c:redirect url="main"/>
    </c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 상세 정보</title>
</head>
<body>
<div>
	<c:import url="sidebar.jsp"/>
	<fieldset id="page">
		<legend align="center">회원 상세 조회</legend>
		<div>
			<table class="detail">
				<tbody>
					<tr>
						<td id="head">이름</td>
						<td>${ dMember.mName }</td>
					</tr>
					<tr>
						<td id="head">아이디</td>
						<td>${ dMember.mId }</td>
					</tr>
					<tr>
						<td id="head">이메일</td>
						<td>${ dMember.email01 } @ ${ dMember.email02 } </td>
					</tr>
					<tr>
						<td id="head">자택전화번호</td>
						<td>
							<c:if test="${dMember.tel02 == null}">미입력</c:if>
							<c:if test="${dMember.tel02 != null}">${dMember.tel01} - ${dMember.tel02} - ${dMember.tel03}</c:if>
						</td>
					</tr>
					<tr>
						<td id="head">휴대전화번호</td>
						<td>${dMember.phone01} - ${dMember.phone02} - ${dMember.phone03}</td>
					</tr>
				</tbody>
			</table>
			<div class="bottomBtn">
				<input type="button" value="확인" onclick="javascript:window.location='main'" />
				<input type="button" value="수정" onclick="javascript:window.location='modifyMember_view'" />
			</div>
		</div>
	</fieldset>
</div>

</body>
</html>