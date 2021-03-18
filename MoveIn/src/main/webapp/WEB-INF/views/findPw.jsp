<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:if test="${ who != null}">
    	<c:redirect url="main"/>
    </c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>findInfo</title>
</head>
<body>
<c:import url="header.jsp"/>

<div>
	<form action="findPw" method="post" name="findF">
		<fieldset>
			<legend class="title">비밀번호 찾기</legend>
			<table id="findInfo">
				<tbody>
					<tr>
						<td><label for="id" class="lb">아이디</label></td>
						<td colspan="2"><input type="text" name="id" id="id" placeholder="아이디를 입력하세요."></td>
					</tr>
					<tr>
						<td><label for="name" class="lb">이름</label></td>
						<td colspan="2"><input type="text" name="name" id="name" placeholder="이름을 입력하세요."></td>
					</tr>
					<tr>
						<td><label for="rrn01" class="lb">주민번호</label></td>
						<td colspan="2"><input type="text" name="rrn01" id="rrn01" >-<input type="password" name="rrn02" ></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="button" id="findbtn" value="비밀번호 찾기" onclick="confirmPw()"></td>
						<td><input type="button" id="cancle" value="취소" onclick="history.go(-1)"></td>
					</tr>
				</tbody>
			</table>
		</fieldset>
	</form>
</div>
</body>
</html>