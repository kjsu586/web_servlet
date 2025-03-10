<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

ArrayList<String> movie = (ArrayList)request.getAttribute("movie");

String mname = (String)request.getAttribute("mname");
String mnumber = (String)request.getAttribute("mnumber");
String mcheck = (String)request.getAttribute("mcheck");
String mdate = (String)request.getAttribute("mdate");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="f">
<p>영화 예매 확인</p>
고객명 : <%=movie.get(0) %><br>
연락처 : <%=movie.get(1) %><br>
영화선택 : <%=movie.get(2) %><br>
예매일자 : <%=movie.get(3) %><br>
<input type="button" value="확인" onclick="ok()">
</form>
</body>
<script>
function ok(){
	alert("예약이 완료되었습니다.");
	f.submit();
}
</script>
</html>