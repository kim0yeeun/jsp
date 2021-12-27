<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import= "point.Point" %>
 <%-- import 를 통해 패키지 가져와서 사용 --%>
 <%
	Point p1 = new Point();
	Point p2 = new Point(10,20);
	
	int [] ii = new int[3];
	ii[0] = 10;
	ii[1] = 20;
	ii[2] = 30;
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>반복문</title>
<script>
	//3단 출력 : while문 사용
	document.write("javascript1</br>");
	var gop = 1;
	while (gop<=9){
		document.write("3*" + gop + "=" + (3*gop) + "</br>");
		gop++;
	}
	// 원하는 단과 곱을 받아서 출력 
	document.write("</br>javascript2</br>");
	var startDan=3;
	var endDan=5;
	var startGop=5;
	var endGop=7;
	var dan = startDan;
	while (dan <= endDan){
		var gop = startGop;
		while (gop <= endGop){
		document.write(dan + "*" + gop + "=" + (dan*gop) + "</br>");
		gop++;
		}
	dan++;
	}
	document.write("</br>");
	
	// do-while
	document.write("</br>do-while javascript2</br>");
	dan = startDan;
    do{
      gop = startGop;
      do{
    	document.write(dan + "*" + gop + "=" + (dan*gop) + "</br>");      
		gop++;   
		}while(gop <= endGop);
     	dan++;
   	}while(dan <= endDan);
	
		
</script>
</head>
<body>


<hr/>

<% out.print("while jsp"); %> <br/>
<%
	int gop = 1;
	
	while (gop<=9){ %>
		3 * <%= gop %> = <%= (3*gop) %> <br/>
		<% gop++; 
} %>

<hr/>


<% out.print("while jsp"); %> <br/>
<%
	int startDan=3;
	int endDan=5;
	int startGop=5;
	int endGop=7;
	int dan = startDan;
	while (dan<=endDan){
		gop= startGop;
		while(gop <= endGop){
%>
		<%= dan%> * <%= gop %> = <%= dan*gop %> <br/>
<% 		gop++;
		;}
		dan++;
		};
%>



<% out.print("do-while jsp"); %> <br/>
<%
//do-while
	out.print("");
    dan = startDan;
    do{
      gop = startGop;
      do{ %>
      <%=dan %> * <%=gop %> = <%=dan*gop %><br/>         
<%     
		gop++;   
	}while(gop <= endGop);
      dan++;
   }while(dan <= endDan);
%>

<%-- 1단부터 9단중 짝수단만 출력하세요. --%>
<% out.print("짝수단만 출력 jsp"); %> <br/>
<%
	for (dan=1; dan<=9; dan++){
		if (dan%2!=0) continue;
		for(gop=1; gop<=9; gop++){
%>
	<%= dan%> * <%=gop%> = <%=dan * gop%> <br/>
<%		}
	}
%>


<!-- break문 -->
<!-- 1부터 9까지 구구단을 출력할 때 임의의 값 j를 만나면 구구단을 중지하세요. -->
<% out.print("5를 만나면 구구단 중지 jsp"); %> <br/>
<%
	int j=5;
	for (dan=1; dan<=9; dan++){
		if (dan==j) break;
		for(gop=1; gop<=9; gop++){
%>	
	<%= dan%> * <%=gop%> = <%=dan * gop%> <br/>
<%
		}
	}
%>






p1's x = <%= p1.getX() %> <br/>
p1's y = <%= p1.getY() %> <br/>
p2's x = <%= p2.getX() %> <br/>
p2's y = <%= p2.getY() %> <br/>

ii[0] = <%= ii[0] %> <br/>
ii[1] = <%= ii[1] %> <br/>
ii[2] = <%= ii[2] %> <br/>

ii[0] + ii[1] = <%= ii[0] + ii[1]%> <br/>
<table border = 1 width = "640">
<colgroup>
	<col width = 20% >
	<col width = 50% >
	<col width = 30% >
</colgroup>
<tbody>
<tr><th>이름</th><th>주소</th><th>전화번호</th></tr>
<% for (int i=1; i<=5; i++){%>
	<tr><td>기맹</td><td>서울시 영등포구</td><td>010-6876-9495</td></tr>
<% } %>
<%-- 아래와 같은건데 %% 안에 한번에 다 쓰면 out.print해야함  --%>
<% for (int i=1; i<=5; i++){
	out.print("<tr><td>기맹</td><td>서울시 영등포구</td><td>010-6876-9495</td></tr>");
} %>
</tbody>
</table>

<% for (int i=0; i<ii.length; i++) { %>
 i[<%= i %>] = <%= ii[i] %> <br/>
<% } %> 

<%
	String location="서울";
	switch(location){
	case "서울" : out.print("02<br/>"); break;
	case "경기도" : out.print("031<br/>"); break;
	case "인천" : out.print("032<br/>"); break;
	default : out.print("경인지역이 아닙니다.");
	}
%>

</body>
</html>
