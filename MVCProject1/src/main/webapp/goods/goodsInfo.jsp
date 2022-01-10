<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
    <%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
    <%
    		// 공백문자 에러 방지  \n, <br/> 대신에 cn, br을 사용하겠다. 
    		pageContext.setAttribute("cn", "\n") ;
			pageContext.setAttribute("br", "<br/>") ;
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
상세페이지입니다.<br/>
<a href ="goosdModify.gd?goodsNum=${dto.goodsNum }">수정</a> | 
<a href ="goodsDelete.gd?goodsNum=${dto.goodsNum }">상품 삭제</a><br/> 

관리자 번호 : ${dto.empNum  }  |  ip : ${dto.ipAddr  }<br/>
제품번호 : ${dto.goodsNum  } <br/>
제품이름 : ${dto.goodsName  } <br/>
제품가격 : <fmt:formatNumber value ="${dto.goodsPrice  }" type="currency"/> <br/>
<%--  taglib prefix="fmt " --%>
제조일 : <fmt:formatDate value ="${dto.goodsDate  }" pattern ="yyyy-MM-dd"/> <br/>

제품설명 : ${fn:replace(dto.goodsContent, cn, br)  } <br/>
수량 : ${dto.goodsQty  } <br/>
제조사 : ${dto.goodsCompany } <br/>
<%--  이미지는 출력하려면 스플릿 해야함 --%>
<c:forTokens items="${dto.goodsImages }" delims="`" var = "img">
	<c:if test="${ img!='null'}" >
	<img src="goods/upload/${img }" /><br/>
	</c:if>
</c:forTokens>
</body>
</html>