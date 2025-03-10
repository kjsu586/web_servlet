

function mnext(){
	//console.log(frm.mdate.value);
	//var today = Date().toString.split("T")[0];
	var mckeck = document.getElementsByName("mcheck");
	var ck = mckeck.length;
	var w = 0;
	var count = 0;
	while(w < ck){
		if(mckeck[w].checked==true){
			count++;
		}
		w++;
	}

	if(frm.mname.value == ""){
		alert("이름을 입력하세요");
	}
	else if(frm.mnumber.value == ""){
		alert("전화번호를 입력하세요");
	}
	else if(count == 0){
		alert("영화를 선택해주세요");
	}
	else if(frm.mdate.value == ""){
		alert("날짜를 선택해주세요")
	}
	else if(frm.mdate.value > 2025-02-21){
		alert("오늘 이후의 날짜만 선택 가능합니다.")
	}
	else{
		
	
	frm.method = "get";
	frm.action = "./movie.do";
	frm.submit();
	}
	
	
}