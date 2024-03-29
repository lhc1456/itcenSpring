<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>header</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- 합쳐지고 최소화된 최신 CSS 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
-->
<!-- 부가적인 테마 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
-->
<!-- 합쳐지고 최소화된 최신 자바스크립트 
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
-->
<link rel="stylesheet" href="<c:url value="/resources/css/normalize.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/css/main.css"/>" />
<script type="text/javascript" src="<c:url value="/resources/js/members.js?v1.1" />" charset="UTF-8"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>

<body>
	<div id="header">
		<div id = "logo">
			<a href="/"><img src="<c:url value="/resources/img/logo.png" />" alt="logo" class="logo"/></a>
		</div>&nbsp;
		<div id = "title">
			<b>전입신고</b>
		</div>
		<div id = "btn">
			<c:choose>
				<c:when test="${ id == null }">
					<a href = "/" class="header">메인화면</a><a href = "/member/login_view" class="header">로그인</a><a href = "/member/signup_view" class="header">회원가입</a>
				</c:when>
				<c:when test="${id != null }">
					
					<a href = "/" class="header">메인화면</a><a href = "/member/logout" class="header">로그아웃</a><a href = "/member/page" class="header">
						<c:choose>
							<c:when test="${who == 'admin'}">
								관리페이지
							</c:when>
							<c:when test="${who == 'member'  }">
								마이페이지
							</c:when>
						</c:choose>
					</a><br>
					<label id="welcome">${ name }님 안녕하세요.</label>
				</c:when>
			</c:choose>
		</div>
	</div>
</body>
</html>