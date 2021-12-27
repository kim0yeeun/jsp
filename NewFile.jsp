<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script>
for (var i=0; i<=9; i++){
	document.write(i);
}
</script>
</head>
<body>
<%  // jsp에서 java코드를 사용할 떄 % 사용
	for (int i=0; i<=9; i++){
		out.print(i + "<br/>");
		// System.out.print(""); 와같다
	}
	out.print("안녕하세요<br/>");
%>
	out.print('/r');
	out.print('/n');
	<%--  밖에 java코드가 있으면 html로 출력된다. --%>
<%	/// 스프리트릿을 여러번 사용이 가능하므로 한줄씩 사용할 수 있다.
	/// 이 안에 있는 코드는 html이 아니다.
	for (int i = 0; i<=9 ; i++){
	out.print(i + "<br/>");
// 스프리트릿으로 만들면 자바코드임을 알려주는것 servlet으로 바뀔때! 
%>
<%   } %> 

<% for (int i = 0; i<=9 ; i++){ %>
<%= i + "<br/>" %> <!-- 표현식 -->
<% // out.print()와 같은 뜻 
} %>

<%-- jsp주석 --%>
 

</body>
</html>
