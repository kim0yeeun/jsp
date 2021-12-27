<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
					// 현재 접속자수 확인
					Integer newCount=0;
					Integer count=(Integer)application.getAttribute("count") ;
					if (count==null) {
						newCount=1;
						application.setAttribute("count", 1);
					}else{
						newCount=count;
						if (session.isNew()){
							// 새로 접속 할때 
							newCount += 1;
							application.setAttribute("count",newCount);
						}
					}
							
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>counter</title>
</head>
<body>
현재 접속자수 : <%= newCount %>
</body>
</html>