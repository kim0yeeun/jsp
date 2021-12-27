<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>String</title>
</head>
<body>
<%
	String str1  = "jsp 웹 애플리케이션";
	String str2 = new String("jsp 웹 애플리케이션");
	String str3 = "jsp 웹 애플리케이션";
%>
str1 : <%= str1 %> <br/>
str2 : <%= str2 %> <br/>
str3 : <%= str3 %> <br/>
<%
	if (str1 == str2)out.print("같다<br/>");
	else out.print("다르다<br/>");
	if (str1 == str3)out.print("같다<br/>");
	else out.print("다르다<br/>");
	
	// 문자열을 비교하는 경우에는 equals를 사용해야 한다. 
	if (str1.equals(str2))out.print("같다<br/>");
	else out.print("다르다3<br/>");
	if (str1.equals(str3)) out.print("같다<br/>");
	else out.print("다르다4<br/>");
%>
<%
	String str4 = "first string";
	String str5 = "second string";
	String str6 = "JSP 프로그래밍!";	
	String str7 = "first string/second-string:JSP#프로그래밍!";
%>
str4 : <%= str4 %> <br/>
str5 : <%= str5 %> <br/>
str6 : <%= str6 %> <br/>

<!-- 바이트가 아니라 글자 수를 의미한다.  -->
str4의 길이 : <%= str3.length() %><br/>
str5의 길이 : <%= str4.length() %><br/>
str6의 길이 : <%= str5.length() %><br/>


1. str4에 4번째 index에 있는 문자 : <%= str4.charAt(4) %> <br/>
2. str4에서 "ing" 가 있는 index는 : <%= str4.indexOf("ing") %> <br/>
3. str4에서 index가 4이후에 있는 st는 몇 번째 인덱스인가 : <%= str4.indexOf("st",4) %>
4. str6에서 "프로그래밍" 의 index는 : <%= str6.indexOf("프로그래밍") %> <br/>
<!-- 첫번재 인덱스가 온다. -->
5. str4에서 6번째 index부터 출력 : <%= str4.substring(6) %><br/>
6. str5에서 index가 4부터 5글자만 가져오기 : <%= str5.substring(4,9)%><br/>
7. str6에서 4번재 index부터 출력 : <%= str6.substring(4) %><br/>
8. str4을 공백문자를 구분자로 문자열을 잘라 변수에 저장하고
자른 문자열을 저장한 변수를 이용하여 값을 출력 :
<%
	String [] s = str4.split(" ");
	for (int i=0; i<s.length; i++){
%>
    s[<%=i %>] = <%=s[i] %> <br/>
		
	<% } %>
9. str7에 있는 문자열을 각가의 단어별로 구분해서 저장한 뒤, 변수의 값을 출력 :<br/>
<%
	s = str7.split(" |/|-|:|#");
	for (int i=0; i<s.length; i++){
%>
	s[<%=i %>] = <%=s[i] %> <br/>
		
	<% } %>


<% 
	int arrayInt [] = {1,2,3,4,5};
	int intArray [];
	
	// intArray에 arrayInt 를 대입하자. 같은 1차원이므로 그냥 대입
	intArray = arrayInt;
	for (int i=0; i<intArray.length; i++){
%>
	intArray[<%= i %>] = <%= intArray[i] %> <br/>
<% } %>
	
<hr/>

<% 
	int	matrix[][] = {{1,2,3,4},{5,6,7,8}}; 
	// 					  0			1
	//				   0 1 2 3   0 1 2 3 

	// matrix에 있는 값을 출력해라.
	out.println(matrix.length + "<br/>");
	for (int i=0; i<matrix.length; i++){
		for (int j=0; j<matrix[i].length; j++){%>
			matrix[<%= i %>][ <%= j %>] = <%=matrix[i][j] %> <br />
<%		}
	}
%>

<%
	String strMatrix[][] = {{"기맹", "기맨", "김앤"}, {"앤", "엔", "Ann", "므애앵"}};
	String strMatrix1[][];
	// Stirng strMatrix1 에 String strMatrix를 저장하세요.
	strMatrix1 = strMatrix;
	for (int i=0; i<strMatrix1.length; i++){
		for (int j=0; j<strMatrix1[i].length; j++){
			out.print("strMatrix1[" +i+ "][" +j+ "]=" +strMatrix1[i][j] +"<br/>");
		}
	}
%>
	
	
	
	
	
</body>
</html>