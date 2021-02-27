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
<title>전입신고 3단계</title>
</head>
<body>
<div>
	<c:import url="header.jsp"/>
	<form action="submit" method="post" name="step3F">
		<fieldset id="contents">
			<legend class="title">전입신고</legend>
			<div>
				<div class="topBtn">
					<input type="button" class="btn" name="proBtn" value="1단계 : 신청인정보" /><input type="button" class="btn" name="proBtn" value="2단계 : 이사전에 살던 곳" /><input type="button" class="nowBtn" name="proBtn" value="3단계 : 이사온 곳" />
				</div>
				<br/>
				<div>
					<input type="hidden" id="mId" name="mId" value="${ dMember.mId }" /><input type="hidden" id="beforeAddr" name="beforeAddr" value="${ dMember.addr }" /><input type="hidden" id="beforedAddr" name="beforedAddr" value="${ dMember.dAddr }" />
					<details open>
						<summary>이사온 곳의 주소를 입력해 주세요.</summary>
						<br />
						<table id="info">
							<tbody class="left">
								<tr>
									<td id="head"><label class="req">기본주소</label></td>
									<td><span><input type="text" name="afterAddr" id="addr"><input type="button" class="inAreaHalf" value="주소검색" onclick="execDaumPostcode()"></span><br/><input type="button" value="건물번호란?" onclick="popupBN()"></td>
								</tr>
								<tr>
									<td id="head"><label>상세주소</label></td>
									<td><span><input type="text" name="afterdAddr" id="dAddr"></span><br><span>상세주소를 반드시 확인하시기 바랍니다.</span></td>
								</tr>
								<tr>
									<td id="head"><label>다가구 주택여부</label></td>
									<td>
									<select id="mfSelect" onchange="setMF()">
										<option value="아니요">아니요</option>
										<option value="모름" selected="selected">모름</option>
										<option value="예">예</option>
									</select><input type="text" id="mfInput" disabled="disabled" /><input type="button" value="다가구 주택이란?" onclick="popupMF()"><br /><span>다가구 주택인 경우, 반드시 *상세주소 부여신청을 하시기 바랍니다.</span></td>
								</tr>
							</tbody>
						</table>
					</details>
					<br />
					<details open>
						<summary>다음 중에서 해당하는 것을 선택해 주세요.</summary>
						<br />
						<table id="info">
							<tbody class="left">
								<tr>
									<td><input type="radio" id="new" name="howMI" value="new" /><label for="new">이사온 사람끼리 세대 구성(빈집으로 이사)</label><br /><input type="radio" id="exist" name="howMI" value="exist" /><label for="exist">이사온 곳에 기존에 살고 있는 세대주가 있는 경우</label></td>
								</tr>
							</tbody>
						</table>
					</details>
				</div>
				<br />
				<table class="bottomBtn">
					<tbody>
						<tr>
							<td><input type="button" value="이전 단계" onclick="javascript:window.location='step2'" /></td>
							<td><input type="button" value="민원신청하기" onclick="checkStep3()" /></td>
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