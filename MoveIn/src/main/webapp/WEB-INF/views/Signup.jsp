<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:if test="${ who != null}">
    	<c:redirect url="main"/>
    </c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign-Up</title>
</head>

<body>

<c:import url="header.jsp"/>

<div>
	<form action="signup" method="post" name="reg_frm">
		<fieldset>
			<legend class="title">회원가입</legend>
			<table id="signupF">
				<tbody>
					<tr>
						<td><label class="req lb" for="mId" >아이디</label></td>
						<td colspan="2"><input type="text" name="mId" id="mId" class="inArea" required="required" placeholder="아이디" ></td>
						<td></td>
					</tr>
					<tr>
						<td><label class="req lb" for="mPw" >비밀번호</label></td>
						<td colspan="2"><input type="password" name="mPw" id="mPw" class="inArea" required="required" placeholder="비밀번호" onkeyup="keyupPw()" ></td>
						<td></td>
					</tr>
					<tr>
						<td><label class="req lb" for="chkPw">비밀번호확인</label></td>
						<td colspan="2"><input type="password" name="chkPw" id="chkPw" class="inArea" required="required" placeholder="비밀번호 확인" onkeyup="checkPw()"></td>
						<td></td>
					</tr>
					<tr>
						<td colspan="4"><span id="checkPw" class="inArea"></span></td>
					</tr>
					<tr>
						<td><label class="req lb" for="mName">이름</label></td>
						<td colspan="2"><input type="text" name="mName" id="mName" class="inArea" required="required" placeholder="이름"></td>
						<td></td>
					</tr>
					<tr>
						<td><label class="req lb" for="rrn01">주민등록번호</label></td>
						<td colspan="2"><input type="text" name="rrn01" id="rrn01" class="inAreaHalf" required="required">-<input type="password" name="rrn02" class="inAreaHalf" required="required"></td>
						<td></td>
					</tr>
					<tr>
						<td><label class="req lb" for="addr">주소</label></td>
						<td colspan="2"><input type="text" name="addr" id="addr" class="inArea" required="required" onclick="execDaumPostcode()"><input type="hidden" name="sigunguCode" id="sigunguCode"></td>
						<td><input type="button" class="inAreaHalf" value="주소검색" onclick="execDaumPostcode()"></td>
					</tr>
					<tr>
						<td><label for="dAddr" class="lb">상세주소</label></td>
						<td colspan="2"><input type="text" name="dAddr" id="dAddr" class="inArea"></td>
						<td></td>
					</tr>
					<tr>
						<td><label class="req lb" for="email01">이메일</label></td>
						<td colspan="2"><input type="text" name="email01" id="email01" class="inAreaHalf" required="required">@<input type="text" name="email02" id="email02" class="inAreaHalf" disabled="disabled" value="" required="required"></td>
						<td>
							<select name="selectEmail" id="selectEmail" class="inArea" onchange="setEmail()" >
								<option value="0" selected="selected">선택하세요</option>
								<option value="1">직접입력</option>
								<option value="naver.com" >naver.com</option>
								<option value="hanmail.net">hanmail.net</option> 
								<option value="nate.com">nate.com</option> 
								<option value="gmail.com">gmail.com</option> 
							</select>
						</td>
					</tr>
					<tr>
						<td><label for="tel01" class="lb">연락처</label></td>
						<td colspan="2">
							<select name="tel01" id="tel01" class="inAreaOther">
								<option value="02" selected="selected">02</option>
								<option value="031">031</option>
								<option value="032">032</option>
								<option value="033">033</option>
								<option value="041">041</option>
								<option value="042">042</option>
								<option value="043">043</option>
								<option value="044">044</option>
								<option value="051">051</option>
								<option value="052">052</option>
								<option value="053">053</option>
								<option value="054">054</option>
								<option value="055">055</option>
								<option value="061">061</option>
								<option value="062">062</option>
								<option value="063">063</option>
								<option value="064">064</option>
							</select>-<input type="text" name="tel02" class="inAreaOther">-<input type="text" name="tel03" class="inAreaOther">
						</td>
						<td></td>
					</tr>
					<tr>
						<td><label class="req lb" for="phone01">핸드폰</label></td>
						<td colspan="2">
							<select name="phone01" id="phone01" class="inAreaOther">
								<option value="010" selected="selected">010</option>
								<option value="011">011</option>
								<option value="016">016</option>
								<option value="017">017</option>
								<option value="018">018</option>
								<option value="019">019</option>
							</select>-<input type="text" name="phone02" class="inAreaOther" required="required">-<input type=text name="phone03" class="inAreaOther" required="required">
						</td>
						<td></td>
					</tr>
					<tr>
						<td colspan="2"><input type="button" value="회원가입" onclick="infoConfirm()"></td>
						<td colspan="2"><input type="button" value="취소" onclick="javascript:window.location='main'" ></td>
					</tr>
				</tbody>
			</table>
		</fieldset> 
	</form>
	
</div>


</body>
</html>