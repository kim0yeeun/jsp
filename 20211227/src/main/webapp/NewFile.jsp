<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!--  공통으로 사용할 수 있도록 만들어주는 게 include지시문 -->
 <!--  %include file=어저꿍% -->
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	document.write("스크립트입니다.");
</script>
</head>
<body>
<!-- 10 + 5 = %= 10+5  %><br/>  펴현식 --> 
<!-- 10 * 5 = %= out.print(10*5) %> <!--  스크립트릿 -->
<form action ="NewFile1.jsp" method="post" enctype="multipart/form-data">

성 : <input type="text" name="userName"/><br/>
이름 : <input type="text" name="userName"/><br/>
아이디 : <input type="text" name="userId"/><br/>
비밀번호 : <input type="password" name="userPw"/><br/>
이메일수신 : <input type = "radio" name="ra" value="Y"/> 예
<input type = "radio" name="cp" value="N"/> 아니요 <br/>
취미 : <input type = "checkbox" name="cp" value="야구"/> 야구
			<input type = "checkbox" name="cp" value="축구"/> 축구
			<input type = "checkbox" name="cp" value="배구"/> 배구
			<input type = "checkbox" name="cp" value="농구"/> 농구<br/>
관심 분야 : <select name="like" multiple size=3>
			<option>html</option>
			<option>css</option>
			<option>java</option>
			<option>javascript</option>
			<option>database</option>
</select>
<br/>
파일 : <input type="file" name="upFile"/><br/>
<input type="submit" value="전송">
<br/><br/><br/><hr/>
enctype은 jsp가 아니라 html 이다. <br/>
jsp는 %% 안에 있는 표현식이나 스크립트릿이다. 
 
</form>
</body>
</html>