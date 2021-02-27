<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<c:if test="${ who == null}">
	    	<c:redirect url="main"/>
	</c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Notice</title>
</head>
<body>
<div>
	<c:import url="header.jsp"/>
	<form action="step1" method="post" name="noticeF">
		<fieldset id="contents">
			<legend class="title">전입신고</legend>
			<label class="title blue">온라인 전입신고 유의사항</label>
			<div>
				<details open>
					<summary>신청·결과 확인</summary>
					<ul>
						<li class="square">이사한 사람이 신청해야 하며 공동인증서가 필요합니다.</li>
						<li class="red square">전입신고 신청 후 처리상태(반려, 취소, 시스템 장애 등)를 반드시 확인하시기 바랍니다.</li>
						<li class="square">신청이 잘못되었거나, 세대주 확인을 기한 내에 처리하지 않을 경우 취소될 수 있습니다.</li>
					</ul>
				</details>
				<br />
				<details open>
					<summary>세대주 확인이 필요한 경우</summary>
					<ul>
						<li class="square">세대주가 아닌 세대원이 신청하면서 세대주(또는 미성년자)를 포함하여 이사하는 경우<strong>(전출자 전 세대주가 확인)</strong></li>
						<li class="square">세대주 변경이 있는 경우<strong>(새로운 세대주가 확인)</strong></li>
						<li class="square">이사온 곳에 기존에 살고 있는 세대주가 있는 경우<strong>(전입자 세대주가 확인)</strong></li>
					</ul>
				</details>
				<br />
				<details open>
					<summary>온라인 전입신고가 불가능한 경우</summary>
					<ul>
						<li class="square">신청인이 미성년자(만 17세 미만)인 경우</li>
						<li class="square">기존 세대가 살고 있는 곳에 별도로 세대를 구성(2세대)하는 경우</li>
						<li class="red square">미성년자가 포함된 전입신고의 경우 전출지 세대주가 공동인증서를 통해 온라인으로 세대주 확인을 할 수 있는 경우를 제외하고는 온라인으로 전입신고 불가</li>
					</ul>
				</details>
				<br />
				<div class="bottom">
					<table id="check">
						<tbody>
							<tr>
								<td><span>전입신고 유의사항을 확인하셨습니까?</span></td>
								<td class="right"><input type="checkbox" id="yes" value="yes" /><label for="yes">예</label></td>
							</tr>
						</tbody>
					</table>
				</div>
				<table class="bottomBtn">
					<tbody>
						<tr>
							<td></td>
							<td><input type="button" value="확인" onclick="checkYes()" /></td>
							<td><input type="button" value="취소" onclick="javascript:window.location='/main'" /></td>
						</tr>
					</tbody>
				</table>
			</div>
		</fieldset>
	</form>
</div>
</body>
</html>