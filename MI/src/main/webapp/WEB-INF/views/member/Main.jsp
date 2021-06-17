<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main</title>

</head>
<body>
<div>
	<c:import url="../frame/header.jsp"/>
	<fieldset>
	<!-- 	<legend class="title blue">전입신고</legend> -->
		<legend class="title blue"></legend>
		<div id="main">
			<form action="/submit/notice" method="post" name="mainF">
				<input type="hidden" name="id" value="${id }">
				<p class="title">전입신고 및 공공요금감면 통합처리 신청(전입신고 +)</p>
				<input type="button" value="신청 >" onclick="isLogin()" /><br/>
				<p>전입신고와 동시에 요금감면대상자에게<span style="color:blue">전기요금, 텔레비전수신료, 지녁난방비, 도시가스요금 등의 감면을 한 번에 신청할 수 있는 서비스</span>입니다.
				<br/>※ 전입신고만 처리하실 수도 있습니다.</p>
			</form>
			<br/>
			<input type="button" value="요금감면 혜택 보기" onclick="popupRR()" />
		</div>
	</fieldset>
</div>
</body>
</html>