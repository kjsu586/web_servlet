<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.n {
width: 500px;
height: 300px;
border: 1px solid black;
overflow-y: auto;
}
</style>
</head>
<body>
제목 : <%=request.getAttribute("subject") %><br>
글쓴이 : <%=request.getAttribute("writer") %><br>
내용 : <div calss="n"> <%=request.getAttribute("wtext") %></div><br>
</body>
</html>