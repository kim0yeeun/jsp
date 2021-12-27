<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="com.oreilly.servlet.MultipartRequest,
                   com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
 <%@ page import = "java.io.*" %>
 <%-- 절대 경로 를 알려줌 getRealPath --%>
 <%-- 실제 서비스하는 데이터는  --%>
 <%
 		String savePath = application.getRealPath("upload"); // 저장 경로 
 		// out.print(savePath);
 		int sizeLimit=1024 * 1024  * 5; // 5MB                         // 1024 =1Gb 1024*1024=1Mb
 		//( request가 갖고온 데이터 )전송 받은 파일을 multi 에 저장
 		// 그래서 body 에서 request로 받아올 수 없음. null값이 뜬다.
 		MultipartRequest multi = new MultipartRequest(request, savePath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());
 		
 		// 저장된 파일명을 가져오기 위해 file객체를 하나 생성
 		File file = multi.getFile("upFile"); // html에서 가져온 파라메터 
 		String fileName = file.getName(); // 저장된 파일 이름을 가져옴 
 		long fileSize = file.length(); // 파일 크기
 	
 %>
 
<html>
<head>
<meta charset="UTF-8">
<title>upload.jsp</title>
</head>
<body>
이름 : <%= request.getParameter("userName") %>
이름 : <%= multi.getParameter("userName") %>
파일명 : <%=  fileName%>
파일사이즈 : <%=  fileSize%>
원본파일명 : <%= multi.getOriginalFileName("upFile")%>
</body>
</html>