<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
		function send(){
			location.href="http://www.duam.net";	
		}
</script>
</head>
<body>
			<!--  Response  : 흐름 제어를 할 때 많이 사용하는 기본객체-->
			<!-- 네이버랑 다음은 이벤트가 발생해야 실행되지만 response는 무조건 실행되는 흐름제어-->
			
			<!--  1 html 흐름제어 : a태그 
					 2 javascript : function
					 3 jsp 흐름제어 : response.sendRedirect
			 -->
			<a href ="http://www.naver.com">1. 네이버</a> 
			<button type="button" onclick="send()">2. 다음</button>
			<%
					response.sendRedirect("http://www.nate.com");
			%>
</body>
</html>