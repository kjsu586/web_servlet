function ajax_file(){
	var mfile = document.getElementById("mfile");
	if(mfile.value==""){
		alert("파일을 등록해주세요");
	}
	else{
		this.ajax_post(mfile);
	}	
}

//ajax로 I/O 파일을 전송하는 방식
function ajax_post(mfile){
	var http,result;
	var formdata = new FormData(); //form형태의 태그를 이용하는 방식과 동일
	formdata.append("mfile",mfile.files[0]); //배열기준으로 파일을 처리함
	
	http = new XMLHttpRequest();
	http.onreadystatechange = function(){
		if(http.readyState==4 && http.status==200){
		console.log(this.response);
		}
	}
	//POST전송
	http.open("POST","./ajax_fileok.do",true);
	//http.setRequestHeader("content-type","multipart/form-data"); 여기서는 이거 필요없음
	http.send(formdata); //FromData 함수의 값을 send 함수에 인자값으로 적용하여 전송
	
	
}