<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:if test="${ who != null}">
    	<c:redirect url="/main"/>
    </c:if>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Log-In</title>
</head>
<body>
<c:import url="../frame/header.jsp"/>

<div>
	<form action="/member/login" method="post" name="loginF">
		<fieldset>
			<legend class="title">로그인</legend>
			<table id="loginF">
				<thead>
					<tr>
						<th colspan="3">
							<input type="radio" name="who" id="member" value="member" checked="checked"><label for="member">사용자</label>
							<input type="radio" name="who" id="admin" value="admin"><label for="admin">관리자</label>
						</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><label for="id" class="lb">아이디</label></td>
						<td colspan="2"><input type="text" name="id" id="id" placeholder="아이디를 입력하세요."></td>
					</tr>
					<tr>
						<td><label for="pw" class="lb">비밀번호</label></td>
						<td colspan="2"><input type="password" name="pw" id="pw" placeholder="비밀번호를 입력하세요."></td>
					</tr>
					<tr>
						<td colspan="3"><input type="button" id="loginbtn" value="아이디 로그인" onclick="loginConfirm()"></td>
					</tr>
					<tr>
						<td><a href="/member/signup_view">회원가입 ></a></td>
						<td style="border-right: 1px solid black"><a href="/member/findId_view">아이디 찾기</a></td>
						<td><a href="/member/findPw_view">비밀번호 찾기</a></td>
					</tr>
				</tbody>
			</table>
		</fieldset>
	</form>
</div>

</body>
</html>