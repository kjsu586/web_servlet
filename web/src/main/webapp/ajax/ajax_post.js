function ajaxs(){ //전송 버튼 클릭 시 발동하는 이벤트 함수
	var mid = document.getElementById("mid");
	var memail = document.getElementById("memail");
	if(mid.value == ""){
		alert("아이디를 입력하세요");
	}
	else{
		//ajax post통신을 위한 함수 호출
		this.ajax_post(mid.value,memail.value);
	}
}

//Ajax POST로 전송하는 함수
function ajax_post(mid,memail){
	var http, result; //http : 백엔드와 통신용, result : 백엔드에서 제공한 데이터
	http = new XMLHttpRequest();
	http.onreadystatechange = function(){
		if(http.readyState==4 && http.status==200){
			console.log(this.response);
		}
		else if(http.status==404){
			console.log("통신 오류 발생");
		}
		else if(http.status==405){
			console.log("통신 오류 발생");
		}	
	}
	
	/*
	//get 방식
	http.open("post","./ajax_postok.do?userid="+mid,true);
	http.send();
	*/
	
	//post 방식
	http.open("post","./ajax_postok.do",true);
	//http.open("post","http://localhost:8080/web/ajax_postok.do",true);
	//ajax post 전송 시 content-type 적용하여 urlencoed 적용해야만 정상적으로 백엔드에게 값 전송
	http.setRequestHeader("content-type","application/x-www-form-urlencoded");
	//http.send("userid="+mid); //데이터 값을 한개 전송할 때
	http.send("userid="+mid+"&usermail="+memail); //한개 이상 부터 & 사용
	
	
}