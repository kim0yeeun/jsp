<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>form</title>
</head>
<body>
<form action="receive.jsp" method ="get" name="frm">
	이름 : <input type="text" name ="userName"/><br/>
	아이디 : <input type="text" name ="userId"/><br/>
	비밀번호 : <input type="text" name ="userPw"/><br/>
	자기소개서 : <textarea  rows="5" cols="30" name = "desc"></textarea><br/>
    <input type="submit" value="전송"/>
</form>
</body>
</html>