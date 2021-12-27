<%@ page language="java" contentType="application/vnd.ms-hwp; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <!-- 
						word 로 열겠다.! 
     -->
     <%
     		response.setHeader("Content-Disposition", "attachment;filename=member.hwp"); 
     		response.setHeader("Content-Description", "JSP Generated Date"); 
     %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border = 1 width ="500">
		<tr><th>이름 </th><th>주소</th><th>연락처</th></tr>
		<tr><th>기맹 </th><th>서울</th><th>01068769495</th></tr>
		<tr><th>김앤 </th><th>영등포구</th><th>1111</th></tr>
</table>

</body>
</html>