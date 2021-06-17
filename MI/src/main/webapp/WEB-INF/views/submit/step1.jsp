<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<c:if test="${ who != 'member'}">
    	<c:redirect url="/"/>
    </c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>전입신고 1단계</title>
</head>
<body>
<div>
	<c:import url="../frame/header.jsp"/>
	<form action="/submit/step2" method="post" name="step1F">
		<fieldset id="contents">
			<legend class="title">전입신고</legend>
			<div>
				<div class="topBtn">
					<input type="button" class="nowBtn" name="proBtn" value="1단계 : 신청인정보" /><input type="button" class="btn" name="proBtn" value="2단계 : 이사전에 살던 곳" /><input type="button" class="btn" name="proBtn" value="3단계 : 이사온 곳" />
				</div>
				<br />
				<div>
					<details open>
						<summary>이사 전에 살던 곳 주소를 조회해 주세요.</summary>
						<p>휴대폰 번호를 남겨주시면 전입신고 신청 후, 진행사항을 SMS로 알려드립니다.</p>
						<table id="info">
							<tbody>
								<tr>
									<td id="head"><label>신청인</label></td>
									<td>${ name }</td>
								</tr>
								<tr>
									<td id="head"><label class="req">휴대전화번호</label></td>
									<td>
										<select name="phone01" id="phone01" class="inAreaOther">
											<option value="010" <c:if test="${ dMember.phone01 == \"010\" }">selected="selected"</c:if>>010</option>
											<option value="011" <c:if test="${ dMember.phone01 == \"011\" }">selected="selected"</c:if>>011</option>
											<option value="016" <c:if test="${ dMember.phone01 == \"016\" }">selected="selected"</c:if>>016</option>
											<option value="017" <c:if test="${ dMember.phone01 == \"017\" }">selected="selected"</c:if>>017</option>
											<option value="018" <c:if test="${ dMember.phone01 == \"018\" }">selected="selected"</c:if>>018</option>
											<option value="019" <c:if test="${ dMember.phone01 == \"019\" }">selected="selected"</c:if>>019</option>
										</select>-<input type="text" name="phone02" class="inAreaOther" value="${ dMember.phone02 }" >-<input type=text name="phone03" class="inAreaOther" value="${ dMember.phone03 }" >
									</td>
								</tr>
							</tbody>
						</table>
					</details>
					<br/><br/>
					<details open>
						<summary>전입하는 사유를 선택해 주세요.</summary>
						<br/>
						<label class="req"></label>
						<select name="reason" >
							<option value="0" selected="selected">선택</option>
							<option value="job">직업 : 취업, 사업, 직장이전 등</option>
							<option value="family">가족 : 가족과 함께 거주, 결혼, 분가 등</option>
							<option value="house">주택 : 주택 구입, 계약 만료, 집세, 재개발 등</option>
							<option value="edu">교육 : 진학, 학업, 자녀, 교육 등</option>
							<option value="resEnv">주거환경 : 교통, 문화, 편의시설 등</option>
							<option value="natEnv">자연환경 : 건강, 공해, 전원생활 등</option>
							<option value="etc">기타</option>
						</select>
					</details>
					<br />
				</div>
				<table class="bottomBtn">
					<tbody>
						<tr>
							<td></td>
							<td><input type="button" value="확인" onclick="checkStep1()" /></td>
							<td><input type="button" value="취소" onclick="javascript:window.location.href='/main'" /></td>
						</tr>
					</tbody>
				</table>
			</div>
		</fieldset>
	</form>
</div>
</body>
</html>