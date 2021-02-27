<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<c:if test="${ who == null}">
    	<c:redirect url="main"/>
    </c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modify</title>
</head>
<body>
<div>
	<c:import url="sidebar.jsp"/>
	<form action="modifyMember" method="post" name="modF">
		<fieldset id="page">
			<legend class="title">회원 정보 수정</legend>
			<div>
				<table id="modify">
					<tbody>
						<tr>
							<td><label class="req lb" for="name" >이름</label></td>
							<td><input type="text" name="name" id="name" class="inArea" value="${ dMember.mName }" /></td>
							<td></td>
						</tr>
						<tr>
							<td><label class="req lb" for="rrn01" >주민등록번호</label></td>
							<td><input type="text" name="rrn01" id="rrn01" class="inAreaHalf" value="${ dMember.rrn01 }" />&#09;-&#09;<input type="password" name="rrn02" id="rrn02" class="inAreaHalf" value="${ dMember.rrn02 }" /></td>
							<td></td>
						</tr>
						<tr>
							<td><label class="req lb" for="id" >아이디</label></td>
							<td><label class="inAreaHalf" ><input type="hidden" name="id" id="id" value="${ dMember.mId }">${ dMember.mId }</label></td>
							<td></td>
						</tr>
						<tr>
							<td><label class="req lb" for="pw" >비밀번호</label></td>
							<td><input type="button" id="modPw" value="비밀번호 변경" onclick="modifyPw()"><input type="hidden" name="pw" id="pw" class="inArea" onkeyup="keyupPw()" value="${ dMember.mPw }"/></td>
							<td></td>
						</tr>
						<tr>
							<td><label class="req lb" for="chkPw" >비밀번호 확인</label></td>
							<td><input type="hidden" name="chkPw" id="chkPw" class="inArea" onkeyup="checkPw()" value="${ dMember.mPw }" /></td>
							<td><span id="checkPw" class="inArea"></span></td>
						</tr>
						<tr>
							<td><label class="req lb" for="addr" >주소</label></td>
							<td><input type="text" name="addr" id="addr" class="inArea" value="${ dMember.addr }" /><input type="hidden" name="sigunguCode" id="sigunguCode" value="${dMember.sigunguCode }"></td>
							<td class="btn"><input type="button" id="addrBtn" value="주소검색" onclick="execDaumPostcode()"></td>
						</tr>
						<tr>
							<td><label class=" lb" for="dAddr" >상세 주소</label></td>
							<td><input type="text" name="dAddr" id="dAddr" class="inArea" value="${ dMember.dAddr }" /></td>
						</tr>
						<tr>
							<td><label class="req lb" for="email01" >이메일</label></td>
							<td><input type="text" name="email01" id="email01" class="inAreaHalf" value="${ dMember.email01 }" />@<input type="text" name="email02" id="email02" class="inAreaHalf" disabled="disabled" value="${ dMember.email02 }" /></td>
							<td>
								<select name="selectEmail" id="selectEmail" class="inArea" onchange="setEmail()" >
									<option value="0" >선택하세요</option>
									<option value="1" >직접입력</option>
									<option value="naver.com" <c:if test="${ dMember.email02 == \"naver.com\" }">selected="selected"</c:if> >naver.com</option>
									<option value="hanmail.net" <c:if test="${ dMember.email02 == \"hanmail.net\" }">selected="selected"</c:if>>hanmail.net</option> 
									<option value="nate.com" <c:if test="${ dMember.email02 == \"nate.com\" }">selected="selected"</c:if>>nate.com</option> 
									<option value="gmail.com" <c:if test="${ dMember.email02 == \"gmail.com\" }">selected="selected"</c:if>>gmail.com</option> 
								</select>
							</td>
						</tr>
						<tr>
							<td><label class="lb" for="tel01" >연락처</label></td>
							<td>
								<select name="tel01" id="tel01" class="inAreaOther">
									<option value="02" <c:if test="${ dMember.tel01 == \"02\" }">selected="selected"</c:if>>02</option>
									<option value="031" <c:if test="${ dMember.tel01 == \"031\" }">selected="selected"</c:if>>031</option>
									<option value="032" <c:if test="${ dMember.tel01 == \"032\" }">selected="selected"</c:if>>032</option>
									<option value="033" <c:if test="${ dMember.tel01 == \"033\" }">selected="selected"</c:if>>033</option>
									<option value="041" <c:if test="${ dMember.tel01 == \"041\" }">selected="selected"</c:if>>041</option>
									<option value="042" <c:if test="${ dMember.tel01 == \"042\" }">selected="selected"</c:if>>042</option>
									<option value="043" <c:if test="${ dMember.tel01 == \"043\" }">selected="selected"</c:if>>043</option>
									<option value="044" <c:if test="${ dMember.tel01 == \"044\" }">selected="selected"</c:if>>044</option>
									<option value="051" <c:if test="${ dMember.tel01 == \"051\" }">selected="selected"</c:if>>051</option>
									<option value="052" <c:if test="${ dMember.tel01 == \"052\" }">selected="selected"</c:if>>052</option>
									<option value="053" <c:if test="${ dMember.tel01 == \"053\" }">selected="selected"</c:if>>053</option>
									<option value="054" <c:if test="${ dMember.tel01 == \"054\" }">selected="selected"</c:if>>054</option>
									<option value="055" <c:if test="${ dMember.tel01 == \"055\" }">selected="selected"</c:if>>055</option>
									<option value="061" <c:if test="${ dMember.tel01 == \"061\" }">selected="selected"</c:if>>061</option>
									<option value="062" <c:if test="${ dMember.tel01 == \"062\" }">selected="selected"</c:if>>062</option>
									<option value="063" <c:if test="${ dMember.tel01 == \"063\" }">selected="selected"</c:if>>063</option>
									<option value="064" <c:if test="${ dMember.tel01 == \"064\" }">selected="selected"</c:if>>064</option>
								</select>-<input type="text" name="tel02" class="inAreaOther" value="${ dMember.tel02 }">-<input type="text" name="tel03" class="inAreaOther" value="${ dMember.tel03 }">
							</td>
						</tr>
						<tr>
							<td><label class="req lb" for="phone01">핸드폰</label></td>
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
							<td></td>
						</tr>
					</tbody>
				</table>
				<div class="bottomBtn">
					<input type="button" value="확인" onclick="updateInfoConfirm()" />
					<input type="button" value="취소" onclick="javascript:history.go(-1);return false;" />
				</div>
			</div>
		</fieldset>
	</form>
</div>
</body>
</html>