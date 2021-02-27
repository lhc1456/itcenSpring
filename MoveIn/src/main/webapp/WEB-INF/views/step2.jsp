<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
	<c:if test="${ who == null}">
    	<c:redirect url="main"/>
    </c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>전입신고 2단계</title>
</head>
<body>
<div>
	<c:import url="header.jsp"/>
	<form action="step3" method="post" name="step2F">
		<fieldset id="contents">
			<legend class="title">전입신고</legend>
			<div>
				<div class="topBtn">
					<input type="button" class="btn" name="proBtn" value="1단계 : 신청인정보" /><input type="button" class="nowBtn" name="proBtn" value="2단계 : 이사전에 살던 곳" /><input type="button" class="btn" name="proBtn" value="3단계 : 이사온 곳" />
				</div>
				<br/>
				<div>
					<details open>
						<summary>신청인의 연락처를 확인해 주세요.</summary>
						&nbsp;&nbsp;&nbsp;&nbsp;<select name="sido" id="sido"></select>
						<select name="gugun" id="gugun"></select><input type="button" value="주소 조회" onclick="checkAddr()" />
						<br /><br />
						<table id="info">
							<tbody>
								<tr>
									<td id="head"><label>기본주소</label></td>
									<td><span class="addr"><input type="hidden" id="addr" value="${ dMember.addr }" /><label id="addr_lb"></label></span></td>
								</tr>
								<tr>
									<td id="head"><label>상세주소</label></td>
									<td><span class="dAddr"><input type="hidden" id="dAddr" value="${ dMember.dAddr }" /><label id="dAddr_lb"></label></span></td>
								</tr>
							</tbody>
						</table>
					</details>
					<br/>
				</div>
				<div id="movMem">
					<details open>
						<summary>이사 가는 사람을 선택하세요.</summary>
						<br />
						<table id="info">
							<thead>
								<tr>
									<th><input type="checkbox" class="chk" id="allList" onclick="allCheck()" /><label for="allList" class="req">선택</label></th>
									<th>성명</th>
									<th>생년월일</th>
									<th>성별</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><input type="checkbox" id="selectList" name="selectList" onclick="listCheck()" value="${dMember.mId }" /></td>
									<td>${ dMember.mName }</td>
									<td>${ dMember.rrn01 }</td>
									<td><c:if test="${ fn:indexOf( dMember.rrn02, '1') == 0 }">남</c:if><c:if test="${ fn:indexOf( dMember.rrn02, '2') == 0 }">여</c:if></td>
								</tr>
							</tbody>
						</table>
					</details>
				</div>
				<br />
				<table class="bottomBtn">
					<tbody>
						<tr>
							<td><input type="button" value="이전 단계" onclick="javascript:window.location='step1'" /></td>
							<td><input type="button" value="다음 단계" onclick="checkStep2()" /></td>
							<td><input type="button" value="취소" onclick="javascript:window.location='main'" /></td>
						</tr>
					</tbody>
				</table>
			</div>
		</fieldset>
	</form>
</div>
</body>
</html>