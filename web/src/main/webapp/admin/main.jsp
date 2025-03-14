<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 메인 페이지</title>
</head>
<body>
<header>
<jsp:include page="./top.jsp" flush="true"></jsp:include> 
</header>
<section>
<%@include file="./product.jsp" %> <!-- do로 쓰면 안됨 jsp를 불러야 한다 -->
</section>
<footer>
<jsp:include page="./copyright.jsp"/>
<%--  <%@include file="./copyright.jsp" --%>
</footer>

</body>
</html>