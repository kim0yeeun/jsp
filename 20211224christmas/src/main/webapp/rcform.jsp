<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    		String  cp[] =request.getParameterValues("cp");
			String  emailCk =request.getParameter("emailCk");
    %>
    <%-- getParameterValues는 배열 request.getParameter 는 값 하나--%>
    <%-- 날라오는 값들이 스트링이라 쿼리스트링 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>refrom.jsp</title>
</head>
<body>
<% 
		for (String s : cp){
			out.print(s+", ");
		}
%><br/>
이메일 수신 여부<br/>
<%
		switch(emailCk){
		case "Y" : out.print("이메일을 받습니다."); break;
		case "N" : out.print("이메일을 받지않습니다."); break;
		}
%>
</body>
</html>