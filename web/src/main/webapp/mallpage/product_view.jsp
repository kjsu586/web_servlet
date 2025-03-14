<%@page import="mallpage.dto_product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSP -> Javascript -> html 순서로 작동 -->    
<Script>
function errmsg(){
	alert("해당 상품의 정보가 올바르지 않습니다.");
	location.href='./product_list.do';
}
</Script>
<%
	//DTO 모델을 컨트롤러에서 받을 값을 이관시켜서 해당 메소드로 값을 출력하기 위한 형식
	dto_product pd = (dto_product)request.getAttribute("dto");
	if(pd.getMidx() == 0){
		out.print("<script>errmsg();</script>");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세 페이지</title>
</head>
<body>
<img src=".<%=pd.getPimg()%>"><br>
상품명 : <%=pd.getPnm()%><br>
상품가격 : <%=pd.getPmoney()%><br>
할인율 :	<%=pd.getPsales()%><br>
할인금액 : <%=pd.getPsmoney()%><br>
<input type="button" value="상품 리스트" onclick="location.href='./product_list.do';">

</body>

</html>