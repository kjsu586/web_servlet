<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String mid = request.getParameter("mid");
String cnumber = request.getParameter("cnumber");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠폰 등록 완료 페이지</title>
</head>
<body>
아이디 : <%=mid %> <br>
쿠폰번호 : <%=cnumber %><br>
광고 수신 동의함
</body>
</html>