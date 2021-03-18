<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>아이디 찾기</title>
</head>
<body>
<div style="text-align: center">
	<p>${findName} 님의 아이디는 '${ findId }' 입니다.</p>
	<input type="button" value="확인" onclick="javascript:window.close();" style="width:400px" />
</div>
</body>
</html>