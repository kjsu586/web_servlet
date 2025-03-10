//회원가입
function memberok(){
	if(frm.sid.value == ""){
		alert("아이디를 입력 후 중복체크를 하세요")
	}
	else if(frm.spw.value == ""){
		alert("패스워드를 입력하세요");
	}
	else if(frm.snm.value == ""){
		alert("이름 및 회사명을 입력하세요");
	}
	else if(frm.stel.value == ""){
		alert("휴대폰 및 연락처를 입력하세요");
	}
	else if(frm.semail.value == ""){
		alert("이메일을 입력하세요");
	}
	else{
		if(frm.spart[0].checked == true){ //일반회원
			if(document.getElementById("idck").value == ""){
				alert("아이디 중복체크를 하셔야만 회원가입이 진행됩니다.");
			}else{
				frm.submit();
			}
		}
		else{ //사업자회원
			if(frm.sno.value == ""){
				alert("사업자 번호를 입력하셔야 합니다.");
			}
			else if(frm.sno.value.length < 10){
				alert("올바른 사업자 번호를 입력하세요");
			}
			else{
				frm.submit();
			}
		}
	}
}


function frm_view(part){
	var sp = document.getElementById("corp");
	//style.display : 해당 오브젝트를 웹에 출력 또는 미출력
	if(part=="C"){
		sp.style.display = "block";
	}
	else{
		sp.style.display = "none";
	}
	
}
//아이디 중복체크 사항
function idcheck(){
	if(frm.sid.value==""){
		alert("아이디를 입력하셔야 합니다.");
	}
	else{
		//Ajax 역할(Back-end와 통신)
		ajaxpost(frm.sid.value);
	}
} 

//Ajax 함수를 이용하여 중복체크
var ok = "";	//Back-end에게 통신을 보내는 역할을 하는 변수
function ajaxpost(data){
	//console.log(data);
	function wck(){
		//window.XMLHttpRequest : 현재 웹페이지에서 XHR 통신을 사용함
		if(window.XMLHttpRequest){	//(XHR통신)
			return new XMLHttpRequest();
		}
	}
	
	function getdata(){
		/*
		new XMLHttpRequest.UNSENT(0) = 객체를 생성(new XMLHttpRequest())
		XMLHttpRequest.OPENED(1) = XHR 통신 연결(open())
		XMLHttpRequest.HEADERS_RECEIVED(2) = Back-end URL 및 통신규격(POST,GET)
		XMLHttpRequest.LOADING(3) = Back-end 경로 응답 대기 시간
		XMLHttpRequest.DONE(4) = 백엔드가 요청된 데이터 처리 완료 결과값을 보낸 경우
		
		status : 통신에 대한 결과 코드 번호 (200: 성공), 405: 백엔드쪽 문제, 404: URL 경로 오류
		*/
		if(ok.readyState==XMLHttpRequest.DONE && ok.status==200){	
			//console.log(this.response); //Back-end 결과값을 받음
			if(this.response == "ok"){
				alert("사용가능한 아이디 입니다.");
				document.getElementById("idck").value = "ok";
				frm.sid.readOnly = true; //아이디를 더이상 수정하지 못하도록 읽기 전용으로 변경
			}
			else if(this.response == "no"){
				alert("해당 아이디는 이미 사용중입니다.");
				frm.sid.value = "";
			}
		}	
	}
	
	ok = wck(); // 신규 XHR 생성
	//Ajax통신규약 : POST, GET, PUT, DELETE
	//ok.open("통신규약","백엔드 경로",true:비동기통신, false:동기통신)
	//async:비동기통신, sync:동기통신
	//비동기통신 : 여러 데이터를 지속적으로 전송할 수 있으며, 결과값을 따로 받을 수 있음
	//동기통신 : 순차적으로 처리하는 방식 1:1 -> from 통신
	ok.onreadystatechange = getdata;	//해당 함수 결과를 받는 설명
	ok.open("GET","./idcheck.do?sid="+data,true); //값을 이관(백엔드)
	ok.send(); //Ajax통신 실행
}









