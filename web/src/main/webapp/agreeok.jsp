<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 String id = (String)request.getAttribute("id");
 String name = (String)request.getAttribute("name");
 String email = (String)request.getAttribute("email");
 String number = (String)request.getAttribute("number");
 
 String number2 = number.replaceAll("4444", "****");
 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개인정보</title>
</head>
<body>
<p>회원가입이 완료 되었습니다.</p>
아이디 : <%=id %><br>
고객명 : <%=name %><br>
이메일 : <%=email %><br>
휴대폰 번호 : <%=number2 %><br>
</body>
</html>