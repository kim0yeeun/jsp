<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberForm.jsp</title>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.1.min.js"></script>
<script>
//form 태그가 submit할 때 검사하새요
$(function() {
	$("#frm").submit(function(){
		if ($("#memPw").val() != $("#memPwCon").val()) {
			alert("비밀번호가 일치하지 않습니다.");
			$("#memPw").val("");
			$("#memPwCon").val("");
			$("#memPw").focus();
			return false;
		}
	});
});
</script>
</head>
<body>
<form action="memberWrite.mem" method="get" name="frm" id="frm">
고객 번호 : <input type="text" name="memNum" value="kosa${memberNum}" readonly ="readonly" required="required"/><br/>
고객 이름 :  <input type="text" name="memName"/><br/>
고객 생년월일 :  <input type="datetime-Local" name="memBirth"/><br/>
고객 성별 : <input type="radio" name="memGender" value="F" checked /> 여자
<input type="radio" name="memGender" value="M"  /> 남자<br/>
고객 가입일 :  <input type="date" name="memRegidate"/><br/>
고객 아이디 :  <input type="text" name="memId"/><br/>
고객 비밀번호 :  <input type="password" name="memPw" id="memPw" required="required" /><br/>
고객 비밀번호 확인 :  <input type="password" name="memPwCon" id="memPwCon" required="required" /><br/>
고객 연락처1 :  <input type="tel" name="memPhone1" placeholder="031-1234-1234"/><br/>
고객 연락처2 :  <input type="tel" name="memPhone2"/><br/>
고객 주소 :  <input type="text" name="memAddr"/><br/>
고객 이메일 :  <input type="email" name="memEmail"/><br/>
<input type="submit" value="회원등록"/>
</form>
</body>
</html>