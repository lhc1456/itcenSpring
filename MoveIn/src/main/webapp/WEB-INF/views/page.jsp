<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<c:if test="${ who == null}">
    	<c:redirect url="main"/>
    </c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Page</title>
</head>
<body>
<div>
	<c:import url="sidebar.jsp"/>
	<c:if test="${who == 'admin' }">
		<form action="updateState" method="post" name="stateF">
		<fieldset id="page">
			<legend class="title">전입신고 관리</legend>
			<div>
				<table class="movein">
					<thead>
						<tr>
							<th id="ren">접수번호</th>
							<th>아이디</th>
							<th>이전 주소</th>
							<th>이후 주소</th>
							<th id="state">처리 상태</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ moveIn }" var="dto">
						<tr>
							<td id="ren">${ dto.ren }</td>
							<td>${ dto.mId }</td>
							<td>${ dto.beforeAddr }<br />${ dto.beforedAddr }</td>
							<td>${ dto.afterAddr }<br />${ dto.afterdAddr }</td>
							<td id="state">
								<c:choose>
									<c:when test="${ dto.state == '처리중'}">
										<input type="hidden" name="hidRen" value="" /><input type="hidden" name="hidState" value="" />
										<input type="button" name="accept" value="승인" onclick="acceptState(${dto.ren})" /><input type="button" name="deny" value="반려" onclick="denyState(${dto.ren})" />
									</c:when>
									<c:otherwise>${ dto.state }</c:otherwise>
								</c:choose> 
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</fieldset>
		</form>
	</c:if>
	<c:if test="${ who == 'member' }">
		<fieldset id="page">
			<legend class="title">내 전입신고</legend>
			<div>
				<table class="movein">
					<thead>
						<tr>
							<th id="ren">접수번호</th>
							<th id="state">처리 상태</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ moveIn }" var="dto">
						<tr>
							<td>${ dto.ren }</td>
							<td>${ dto.state }</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</fieldset>
	</c:if>
</div>
</body>
</html>