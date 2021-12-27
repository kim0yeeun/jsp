<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    		String edu = request.getParameter("edu");
			String nation = request.getParameter("nation");
			String like [] = request.getParameterValues("like");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selectform.jsp</title>
</head>
<body>
		학력 : <%= edu %><br/>
		소속국가 : <%= nation %><br/>
		관심분야 :
		<%
			for (String s : like){
				out.print(s+", ");
			}
			
		%><br/>
</body>
</html>