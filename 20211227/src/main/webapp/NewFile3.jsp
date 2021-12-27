<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 			request.setCharacterEncoding("utf-8");
 			String search = request.getParameter("search"); 
 			request.setAttribute("subject", "jsp는 서버프로그램입니다.");
 			// <-> parameter  : 사용자로부터 날라온 값을 서버로 전달 
 			// html 실행 (서버로 넘어감)
 			// 서버쪽에 있는 값을 클라이언트로 전달하기 위해서는 attribute로 저장(set)해서
 			// body에서 그 값을 get으로 갖고와서 사용자에게 보여주기 위해 출력한다. 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
검색페이지입니다. <br/>
<form action ="NewFile3.jsp" method = "post" name="frm">
			검색 : <input type="search" name="search" value = "<%=search %>"/><br/>
			검색 결과 : <%= request.getAttribute("subject") %>
			<input type="submit" value="검색"/>

</form>

</body>
</html>