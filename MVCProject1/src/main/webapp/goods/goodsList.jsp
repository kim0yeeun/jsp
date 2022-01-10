<%@page import="model.DTO.GoodsDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>goodsList.jsp</title>
</head>
<body>
상품 페이지입니다.<br/>

<table border =1 width ="600px" >	
	<tr><td>그림</td><td>이름</td><td>가격</td></tr>
	<c:forEach items="${list }" var = "dto" >
   <tr><td>
      <!--  구분자 (delims)  `  로 fortoken에 의해서 3개로 나눠진다. 
      각각 반복할대마다 변수 img에 저장 해라  
      begin 부터end까지  출력  0부터 0이니까 1개만 출력해라   -->
      
      <!--  for token : 스플릿과 반복문이 포함된 것 -->
      <c:forTokens items="${dto.goodsImages }" delims="`" var="img" begin ="0" end="0">
      <!--  업로드 밑에 있는 이미지 파일을 출력해라  -->
            <a href ="goodsInfo.gd?num=${dto.goodsNum }"><img src="goods/upload/${ img} " height="30px"/> </a>
            <!--  이미지 파일을 클릭하면  넘어가고 -->
      </c:forTokens>
    
   </td><td>
   			 <a href ="goodsInfo.gd?num=${dto.goodsNum }">${dto.goodsName }</a>
   			 <!-- 이름을 클릭해도 상세페이지 열림 -->
   </td><td>${dto.goodsPrice }</td></tr>
</c:forEach>
</table>

<a href="goodsEnter.gd">제품등록</a>

<!--  c커스텀태그를 사용하지 않으면 이렇게 받아와야한다.  
page import 자바 유틸 머더라~! 

		List<GoodsDTO> list = (List<GoodsDTO>)request.getAttribute("list");
		for (GoodsDTO dto : list){              **********************      var=dto 끝남
			out.print(dto.getGoodsImages()+ " <br/>" ); 
			// 가져온 이미지를 ` 로 스플릿해준다    **********************    c:fortoken 
			String [] images = dto.getGoodsImages().split("`");  **********************   
			i
			for (String img : images){      ********************** vat = "img"
			  out.print(img+ " <br/>");         
			
				// 여기까지가 fortoken 
			}	
		}
		
		
		<c:set var="image" value="${img }" />
		
-->

</body>
</html>