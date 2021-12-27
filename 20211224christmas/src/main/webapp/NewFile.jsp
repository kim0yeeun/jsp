<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ page import = "java.util.ArrayList, java.util.List" %>
  <%@ page import = "java.io.*, java.util.Calendar" %>
  <%
  		Calendar cal = Calendar.getInstance();
  		List<String> list = new ArrayList<String>();
  		list.add("기맹");
  		list.add("기맨");
  		list.add("김앤");
  		list.add("앤");
  		list.add("Ann");
  %>
  <%-- 페이지 지시문에서 기억할 것  ↑ --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>지시문</title>
</head>
<body>
<%= cal.get(Calendar.YEAR) %>년
<%= cal.get(Calendar.MONTH) %>월
<%= cal.get(Calendar.DATE) %>일
<%
		for (String s : list) {
			out.print( s +"<br/>");
		}
%>
</body>
</html>