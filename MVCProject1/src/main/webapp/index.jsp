<%@page import="model.DAO.LoginDAO"%>
<%@page import="model.DTO.AuthInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="javax.servlet.http.Cookie" %>
    <%@ page import="model.DAO.*, model.DTO.*" %>
    <%
    			Cookie [] cookies = request.getCookies(); // 모든 쿠키를 담아서 배열로 전달 
    			
    			if(cookies != null && cookies.length > 0){ // 쿠키가 null이 아니고 존재한다면 반복문을돌리자 (여러개의 쿠키중 storeId 를 찾자 getName)
    				for (Cookie cookie: cookies){
    					if (cookie.getName().equals("storeId")) { // 쿠키값이 아디저장이냐?
    						request.setAttribute("isId", cookie.getValue());  //jsp 에서 출력할 수 있는건 request박에 업스미가 isId에 request로 줌 
    						out.print (cookie.getValue());
    					}
    					if (cookie.getName().equals("autoLogin")) { // 쿠키값이 자동로그인이냐?
    							// 로그인 다오르 ㄹ이용해서 어스인포 갖고왕
    							LoginDAO dao = new LoginDAO();
    					// 다오를 이용해서 갖고오려면 id를 갖고와야함 
    							AuthInfo authInfo = dao.loginCk(cookie.getValue(), "abcd") ; // null만 아님녀 되니까 임의의 값 abcd주겟움 
    							session.setAttribute("authInfo", authInfo);
    					}
    				}
    			}
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
메인페이지입니다. <br/>

<!--  로그인이 되지 않은 상태 -->
<c:if test="${empty authInfo }"> <!--  아이디가 비어있다면  -->
<form action="loginPro.login" method="post" name="frm" id="frm">
<table border=1>
<tr><td colspan=2>
				<input type = "checkbox" value = "autoLogin" name="autoLogin"/>로그인 유지 
				<input type = "checkbox" value = "store" name="storeId"
				<c:if test="${!empty isId }">checked</c:if>  />아이디 저장 <!--  아이디가 비어있지 않으면 checked -->
		</td>
</tr>
<tr><td><input type ="text" name = "id" placeholder="아이디" value="${isId }"/> <!--  여기서 출력하려고 request로 받음 -->
		</td>
		<td rowspan=2>
		<input type="image"  src="images/img1.jpg" width ="50px" height="50px"/>
		</td>
</tr> 
<tr><td><input type="password" name="pw" placeholder="비밀번호"/></td></tr>
<tr><td colspan=2>
				아이디/비밀번호 찾기 | <a href ="memberAgree.mem">회원가입</a>
		</td>
</tr>
</table>
</form>
</c:if>

<!--  로그인 된 상태 -->
<c:if test="${!empty authInfo }"> <!--  아이디가 비어있지 않다면  -->
${authInfo.userId }님 방문을 환영합니다. <br/>
<a href="boardList.kosa">게시글 목록</a>

<c:if test="${authInfo.grade == 'emp' }"> <!--  직원일 때만 보여줌  -->
<a href="employeeList.emp">직원 리스트</a>
<a href="memberList.mem">회원 리스트</a>
<a href="goodsList.gd">상품 리스트</a>
</c:if>

<c:if test="${authInfo.grade == 'mem' }">
<a href="mypage.html">마이페이지</a>
</c:if>
<a href="logout.login">로그아웃</a>


</c:if>
</body>
</html>