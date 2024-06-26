function loginCheck(){
	if(document.loginForm.userid.value==""){
		alert("아이디를 입력하세요");
		document.loginForm.userid.focus();
		return false;
	}else if (document.loginForm.pwd.value==""){
		alert("패스워드를 입력하세요");
		document.loginForm.pwd.focus();
		return false;
	}else{
		return true;
	}
}

function login(){
	window.location.href = "joinForm.jsp"; 
}

function go_next(){
	//자바 스크립트에서 Html 태그에 접근할때, 둘의 name 값이 같으면, 그 둘은 배열로 처리합니다.
	// document.contractForm.okon 이 두개이므로
	// 하나는  document.contractForm.okon[0]
	// 다른 하나는  document.contractForm.okon[1]으로 인식합니다 
	
	if(document.contractForm.okon[1].checked==true){
		alert("회원 약관에 동의 하셔야 회원가입이 가능합니다.");
	}else{
		document.contractForm.submit();
	}
}

function idcheck(){
	if(document.joinForm.userid.value==""){
		alert("아이디를 입력하고 중복체크를 진행하세요");
		document.joinForm.userid.focus();
		return;
	}
	var url = "idcheckForm?userid=" + document.joinForm.userid.value;
	var opt ="toolbar=no, menubar=no, resizable=no, width=500, height=250, scrollbars=no";
	
	window.open(url,"idcheck",opt);
}

function pwdcheck(){
	if(document.joinForm.userpwd.value!="/^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,15}$/"){
		alert("영문 숫자 특수기호 조합 8자리 이상 입력하세요");
		document.joinForm.userpwd.focus();
		alert("확인");
		return false;
	}
	//var url = "tv.do?command=idcheckForm&pwd=" + document.joinForm.pwd.value;
	//var opt ="toolbar=no, menubar=no, resizable=no, width=500, height=250, scrollbars=no";

	//window.open(url,"pwdcheck",opt);
}


function pwCheck(){
    if($('#pwd').val() == $('#passwordConfirm').val()){
        $('#passwordConfirmMsg2').text('비밀번호 일치').css('color', 'yellow')
    }else{
        $('#passwordConfirmMsg2').text('비밀번호 불일치').css('color', 'red')
    }
}


function idok(userid){
	opener.joinForm.userid.value = userid;
	opener.joinForm.reid.value = userid;
	opener.joinForm.userid.focus();
	self.close();
}

//아이디 정규식
	var idJ = /^[a-z0-9]{4,12}$/;
// 비밀번호 정규식
	var pwJ = /^[A-Za-z0-9]{6,12}$/; 
// 이메일 검사 정규식
	var mailJ = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	
$(document).ready(function() {
	$("#userid").blur(function() {
		if (idJ.test($(this).val())) {
				$("#userIdMsg").text('아이디 사용 가능합니다.');
				$('#userIdMsg').css('color', 'yellow');
		} else {
			$('#userIdMsg').text('아이디를 확인해주세요(아이디 : 영문 소문자, 숫자 조합 4~12 자리)');
			$('#userIdMsg').css('color', 'red');
		}
	});
});
	
$(document).ready(function() {	
	$('#pwd').blur(function(){
		if(pwJ.test($('#pwd').val())){
			$('#passwordConfirmMsg1').text('비밀번호 사용 가능합니다.');
			$('#passwordConfirmMsg1').css('color', 'yellow');
		} else{
			$('#passwordConfirmMsg1').text('비밀번호를 확인해주세요(비밀번호 : 영문 소/대문자, 숫자 조합 6~12 자리)');
			$('#passwordConfirmMsg1').css('color','red');
		}
	});
});

$(document).ready(function() {	
	$('#email').blur(function(){
		if(mailJ.test($('#email').val())){
			$('#emailMsg').text('이메일 사용 가능합니다.');
			$('#emailMsg').css('color', 'yellow');
		} else{
			$('#emailMsg').text('이메일 형식을 확인해주세요.');
			$('#emailMsg').css('color','red');
		}
	});
});
	
function go_save(){
	var checkBox = document.getElementById("agree10");
    if (checkBox.checked == true) {
        // 체크박스가 체크되어 있으면 회원가입 처리
        if(document.joinForm.userid.value ==""){
			alert("아이디를 입력하여 주세요.");
			document.joinForm.userid.focus();
		}else if(document.joinForm.reid.value!=document.joinForm.userid.value){
			alert("아이디 중복확인을 하지 않았습니다");
			document.joinForm.userid.focus();
		}else if(!/^[a-z0-9]{4,12}$/.test(document.joinForm.userid.value)){
			alert("아이디 : 영문 소문자, 숫자 조합 4~12 자리로 입력해주세요.");
			document.joinForm.userid.focus();
		}else if(document.joinForm.pwd.value ==""){
			alert("비밀번호를 입력해 주세요.");
			document.joinForm.pwd.focus();
		}else if(document.joinForm.pwd.value != document.joinForm.pwdCheck.value){
			alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
			document.joinForm.pwd.focus();	
		}else if(!/^[A-Za-z0-9]{6,12}$/.test(document.joinForm.pwd.value)){
			alert("비밀번호 : 영문 소/대문자, 숫자 조합 6~12 자리로 입력해주세요.");
			document.joinForm.pwd.focus();
		}else if(document.joinForm.name.value ==""){
			alert("이름을 입력하여 주세요.");
			document.joinForm.name.focus();
		}else if(document.joinForm.email.value ==""){
			alert("이메일을 입력해 주세요.");
			document.joinForm.email.focus();
		}else if(!/^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i.test(document.joinForm.email.value)){
			alert("이메일 형식에 맞게 입력해주세요.");
			document.joinForm.email.focus();
		}else {
			document.joinForm.submit();	
			//alert("회원가입이 완료되었습니다.");
		}
    } 
  else {
        alert("약관에 동의해주세요.");
    }
}


/*function go_save(){
	if(document.joinForm.userid.value==""){
		alert("아이디를 입력해 주세요");
		document.joinForm.userid.focus();
	} else if(document.joinForm.reid.value!=document.joinForm.userid.value){
		alert("아이디 중복확인을 하지 않았습니다");
		document.joinForm.userid.focus();
	} else if(document.joinForm.pwd.value==""){
		alert("비밀번호를 입력해주세요.");
		document.joinForm.pwd.focus();
	} else if(document.joinForm.pwd.value!=document.joinForm.pwdCheck.value){
		alert("비밀번호와 비밀번호 확인이 일치하지 않습니다");
		document.joinForm.pwd.focus();
	} else if(document.joinForm.name.value==""){
		alert("이름을 입력해주세요.");
		document.joinForm.name.focus();
	} else if(document.joinForm.email.value==""){
		alert("이메일을 입력해주세요.");
		document.joinForm.email.focus();
	} else{
		document.joinForm.submit();
	}
}*/


$(function(){
	$('.hmenu').click(function(){
		$('.hmenu div').toggleClass('active');
		$('.gnb').toggle(300, function(){});
	});
});



   
     
		
function withdrawal(){
	var checkBox = document.getElementById("agree");
	if (checkBox.checked == true) {
		var ans = window.confirm("정말로 탈퇴하시겠습니까?");
		if(ans){
			location.href="deleteMember";
		}else{
			return;
		}
    }
  	else {
		alert("약관에 동의해주세요.");
	}
}
