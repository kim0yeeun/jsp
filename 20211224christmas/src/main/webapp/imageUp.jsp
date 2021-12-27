<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page import=" com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@ page import="java.io.*"%>

<%
// upload 라는 폴더의 절대 경로를 가져온다
String savePath = application.getRealPath("upload");
int sizeLimit = 1024 * 1024 * 5;
//( request가 갖고온 데이터 )전송 받은 파일을 multi 에 저장
// 그래서 body 에서 request로 받아올 수 없음. null값이 뜬다.
MultipartRequest multi = new MultipartRequest(request, savePath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());

File file = multi.getFile("imgFile");
String imgFile = file.getName();
long fileSize = file.length();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>imageUp.jsp</title>
</head>
<body>
	전송한 사람의 ip주소 :
	<%=request.getRemoteAddr()%>
	<!--  주소를 가져올때는 multi가 아니라 request사용  -->
	제목 :
	<%=multi.getParameter("subject")%><br /> 파일명 :
	<%=multi.getOriginalFileName("imgFile")%>
	파일크기:
	<%=file.length()%>
	이미지 :
	<br />
	<img src="upload/<%=multi.getFilesystemName("imgFile")%>" />

</body>
</html>