<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<c:import url="header.jsp"/>
	<c:if test="${who == 'admin' }">
		<aside class="sidebar">
			<ul>
				<li>신청 내역</li>
					<ul>
						<li class="sidebarBtn"><a href="page" id="sidebarBtn">전입신고 관리</a></li>
					</ul>
			</ul>
			<ul>
				<li>회원 정보</li>
					<ul>
						<li class="sidebarBtn"><a href="memberList" id="sidebarBtn">회원 관리</a></li>
						<li class="sidebarBtn"><a href="adminList" id="sidebarBtn">관리자 관리</a></li>
						<li class="sidebarBtn"><a href="withdrawal_view" id="sidebarBtn">관리자 탈퇴</a></li>
					</ul>
			</ul>
		</aside>
	</c:if>
	<c:if test="${ who == 'member' }">
		<aside class="sidebar">
			<ul>
				<li>신청 내역</li>
					<ul>
						<li class="sidebarBtn"><a href="page" id="sidebarBtn">내 전입신고</a></li>
					</ul>
			</ul>
			<ul>
				<li>회원 정보</li>
					<ul>
						<li class="sidebarBtn"><a href="detailMember" id="sidebarBtn">회원정보 관리</a></li>
						<li class="sidebarBtn"><a href="withdrawal_view" id="sidebarBtn">회원 탈퇴</a></li>
					</ul>
			</ul>
		</aside>
	</c:if>
</body>
</html>