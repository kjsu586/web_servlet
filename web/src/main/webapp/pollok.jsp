<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//밑에 차이?
	String word = (String)request.getAttribute("subject");	//null,"" 
	//String word = request.getAttribute("abc").toString(); //""
	//String word = String.valueOf(request.getAttribute("abc")) //null
	String etc[] = (String[])request.getAttribute("etc");
	out.print(etc);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>설문조사 결과값</title>
</head>
<body>
선택하신 과목 : <%=word%><br>
배우고 싶은 과목 : <%
int w = 0;
while(w < etc.length){	//Controller에서 원시 배열로 값을 이관받은 데이터를 반복문으로 view에서 처리
	out.print(etc[w]+ ", ");
	w++;
}
%>
</body>
</html>