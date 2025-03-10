function wordck(){
	//var w = "010123-45678";
	var w = "01012345678";
	
	//let ck = /[0-9]/;	//0~9까지 검사
	//let ck = /[a-zA-Z]/;	//a~z(소문자)
	//console.log(ck.test(w));
		
	//let ck = /[^0-9]/;	//0~9숫자 외 단어
	//console.log(w.match(ck));	//배열형태의 값을 출력
	
	//$ : 해당 패턴에 문자열을 대입하여 체크하는 방식
	let ck = /^[0-9]/g;
	let ck2 = /^\d{2,3}-\d{3,4}-\d{4}$/;	//true(010-1234-s5678), false(01012345678)
	console.log(ck.test(w));
	console.log(ck2.test(w));
}

function eventok(){
	if(f.ename.value==""){
		alert("고객명을 입력하세요");
	}
	else if(f.etel.value==""){
		alert("연락처를 입력하세요");
	}
	else if(f.email.value==""){
		alert("이메일을 입력하세요");
	}
	else if(f.ememo.value==""){
		alert("이벤트 참여이유를 입력하세요");
	}
	else if(f.info1.checked == false){
		alert("개인정보활용에 동의해야 이벤트 참여가 가능합니다.");
	}
	else if(f.info2.checked == false){
		alert("제3자의 정보제공에 동의해야 이벤트 참여가 가능합니다.");
	}
	else{
		//정규식 코드 사용 (연락처 확인)
		let ck = /^\d{2,3}\d{3,4}\d{4}$/;	//숫자 외에 다른 문자일 경우 false 
		if(ck.test(f.etel.value) == false){
			alert("전화번호를 정삭적으로 입력하세요");
		}
		else{	//정규식코드가 true일 경우			
			f.submit();
		}
	}
}