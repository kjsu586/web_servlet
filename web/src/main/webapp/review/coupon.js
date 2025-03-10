function ticket(){
	if(frm.mid.value==""){
		alert("아이디를 입력해주세요")
	}
	else if(frm.cnumber.value==""){
		alert("쿠폰번호를 입력해주세요")
	}
	else if(frm.ckok.checked==false){
		alert("광고 수신 동의는 필수입니다.");
	}
	else{
		frm.submit();
	}
}