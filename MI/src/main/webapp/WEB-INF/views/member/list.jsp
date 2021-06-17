<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<c:if test="${ who != 'admin'}">
    	<c:redirect url="/main"/>
    </c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List</title>
</head>
<body>
<div>
	
	<c:import url="../frame/sidebar.jsp"/>
	<c:if test="${list == 'admin' }">
		<form action="/member/deleteAdminList" method="post" name="delF">
			<fieldset id="page">
				<legend class="title">관리자 리스트 </legend>
				<div>
					<table class="list">
						<thead>
							<tr>
								<th id="select"><input type="checkbox" class="chk" id="allList" onclick="allCheck()"><label for="allList">선택</label> </th>
								<th id="name" colspan="2">이름</th>
								<th id="id" colspan="2">아이디</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${ adminList }" var="dto">
							<tr>
								<td>
									<c:choose>
										<c:when test="${ dto.AId == id }"><input type="checkbox" class="chk" id="selList" name="selectList" disabled="disabled" /></c:when>
										<c:otherwise><input type="checkbox" class="chk" name="selectList" onclick="listCheck()" value="${dto.AId }" /></c:otherwise>
									</c:choose> 
								</td>
								<td colspan="2">${ dto.AName }</td>
								<td colspan="2">${ dto.AId }</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
					<table class="bottomBtn">
						<tbody>
							<tr>
								<td><input type="button" value="확인" onclick="javascript:window.location='/main'" /></td>
								<td><input type="button" value="추가" onclick="javascript:window.location='/member/addAdmin_view'" /></td>
								<td><input type="button" value="삭제" onclick="checkDel()" /></td>
							</tr>
						</tbody>
					</table>
				</div>
			</fieldset>
		</form>
	</c:if>
	<c:if test="${ list == 'member' }">
		<form action="/member/deleteMemberList" method="post" name="delF">
			<fieldset id="page">
				<legend class="title">회원 리스트</legend>
				<div>
					<table class="list">
						<thead>
							<tr>
								<th id="select"><input type="checkbox" id="allList" name="allList" onclick="allCheck()"><label for="allList">선택</label> </th>
								<th id="name" colspan="2">이름</th>
								<th id="id" colspan="2">아이디</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${ memberList }" var="dto">
							<tr>
							
								<td><input type="checkbox" name="selectList" onclick="listCheck()" value="${dto.MId }" /></td>
								<td colspan="2">${ dto.MName }</td>
								<td colspan="2">${ dto.MId }</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
					<table class="bottomBtn">
						<tbody>
							<tr>
								<td></td>
								<td><input type="button" value="확인" onclick="javascript:window.location='/main'" /></td>
								<td><input type="button" value="삭제" onclick="checkDel()"/></td>
							</tr>
						</tbody>
					</table>
				</div>
			</fieldset>
		</form>
	</c:if>
</div>

</body>
</html>