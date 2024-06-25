function resetPassword2(){
	if(document.resetPassword.pwd.value ==""){
		alert("비밀번호를 입력해 주세요.");
		document.resetPassword.pwd.focus();
	}else if(document.resetPassword.pwd.value != document.resetPassword.pwdCheck.value){
		alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
		document.resetPassword.pwd.focus();	
	}else if(!/^[A-Za-z0-9]{6,12}$/.test(document.resetPassword.pwd.value)){
		alert("비밀번호 : 영문 소/대문자, 숫자 조합 6~12 자리로 입력해주세요.");
		document.resetPassword.pwd.focus();
	}else{
		alert("패스워드 재설정이 완료되었습니다.");
		document.resetPassword.submit();
	}
}	

function idcheck2(){
	if(document.findPwd.userid.value==""){
		alert("아이디를 입력하고 중복체크를 진행하세요");
		document.findPwd.userid.focus();
		return;
	}
	var url = "twoving.do?command=pwdIdcheckForm&userid=" + document.findPwd.userid.value;
	var opt ="toolbar=no, menubar=no, resizable=no, width=500, height=250, scrollbars=no";
	
	window.open(url,"idcheck",opt);
}

function idok2(userid){
	opener.findPwd.userid.value = userid;
	opener.findPwd.reid.value = userid;
	opener.findPwd.userid.focus();
	self.close();
}

function go_pwFind(){
	if(document.findPwd.userid.value ==""){
		alert("아이디를 입력하여 주세요.");
		document.findPwd.userid.focus();
	}else if(!/^[a-z0-9]{4,12}$/.test(document.findPwd.userid.value)){
		alert("아이디 : 영문 소문자, 숫자 조합 4~12 자리로 입력해주세요.");
		document.findPwd.userid.focus();
	}else if(document.findPwd.reid.value!=document.findPwd.userid.value){
		alert("아이디 체크 확인을 하지 않았습니다");
		document.findPwd.userid.focus();
	}else{
		alert("이메일 인증 메일이 전송 완료되었습니다.");
		document.findPwd.submit();
	}
}

function go_idFind(){
	if(document.findId.email.value == ""){
		alert("이메일을 입력하여 주세요.");
		document.findId.email.focus();
	}else if(!/^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i.test(document.findId.email.value)){
		alert("이메일 형식에 맞게 입력해주세요.");
		document.findId.email.focus();
	}else{
		document.findId.submit();
	}
}


function go_updateMember(){
	if(document.updateForm.pwd.value ==""){
		alert("비밀번호를 입력해 주세요.");
		document.updateForm.pwd.focus();
	}else if(document.updateForm.pwd.value != document.updateForm.pwdCheck.value){
		alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
		document.updateForm.pwd.focus();	
	}else if(!/^[A-Za-z0-9]{6,12}$/.test(document.updateForm.pwd.value)){
		alert("비밀번호 : 영문 소/대문자, 숫자 조합 6~12 자리로 입력해주세요.");
		document.updateForm.pwd.focus();
	}else if(document.updateForm.name.value ==""){
		alert("이름을 입력해 주세요.");
		document.updateForm.name.focus();	
	}else if(document.updateForm.email.value ==""){
		alert("이메일을 입력해 주세요.");
		document.updateForm.email.focus();	
	}else if(!/^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i.test(document.updateForm.email.value)){
		alert("이메일 형식에 맞게 입력해주세요.");
		document.updateForm.email.focus();
	}else if(document.updateForm.phone.value ==""){
		alert("전화번호를 입력해 주세요.");
		document.updateForm.phone.focus();	
	}else {
		document.updateForm.submit();	
	}
}

/*function withdraw(){
   var ans = confirm("정말로 탈퇴하시겠습니까?");
   if(ans){
      location.href="shop.do?command=deleteMember"
   }
}*/



$(function(){
   $('.box2-1').click(function(){
                $('.profileclick').slideToggle(300);
            $(this).toggleClass('active');
         });
         });
         
/*$(function(){
	$(".kjy").hover(
                function(){
                    $(this).css({
                        "background" : "red",
                        "color" : "white",
                        
                    });
                }, 
                function(){
                    $(this).css({
                        "background" : "#282828",
                        "color" : "white",
                        
                    });
                }
             )            
         });        */ 


/*function go_cart(){
	if(document.formm.quantity.value==""){
		alert("수량을 입력하세요");
		document.formm.quantity.focus();
	}else{
		document.formm.action = 'shop.do?command=cartInsert';
		document.formm.submit();
	}

}

function go_cart_delete(){
	// 자바스크립트에서 form 태그 내의 입력란들에게 접근할때 name 이 같은 것들은 배열로 인식된다.
	// document.cartFrm.cseq 들이 갯수만큼 배열로 인식됩니다 document.cartFrm.cseq[0] ~
	// 만약 해당이름의 태그가 한개라면 배열이 아니라 그냥 변수 처럼 인식
	// 배열이라면 .length 라는 속성을 쓸수가 있고, 배열이 아니라면 length 속성은 undefined 가 됩니다
	
	var count=0;
	// 혹시라도 체크박스에 체크를 하나도 안넣고 삭제버튼을 눌렀는지 검사합니다.
	if(document.cartFrm.cseq.length == undefined){
		// 체크박스가 한개라면, 체크박스가 단일 변수로 인식
		if(document.cartFrm.cseq.checked == true){
		count++;
	}
	}else{ 
		// 체크박스가 두개 이상이라면, 체크박스들이 배열이라면
		for(var i = 0; i<document.cartFrm.cseq.length; i++){
			if(document.cartFrm.cseq[i].checked == true ){
			count++;
			}
		}
	}
	
	if(count == 0){
		alert("삭제할 항목을 선택하세요");
	}else{
		var ans =confirm("선택한 항목을 삭제할까요?");
		if(ans){
			document.cartFrm.action = "shop.do?command=cartDelete";
			document.cartFrm.submit();
		}
		
	}
}*/


/*function go_order_insert(){
	
	var count=0;
	
	if(document.cartFrm.cseq.length == undefined){
	
		if(document.cartFrm.cseq.checked == true){
		count++;
	}
	}else{ 
		for(var i = 0; i<document.cartFrm.cseq.length; i++){
			if(document.cartFrm.cseq[i].checked == true ){
			count++;
			}
		}
	}
	
	if(count == 0){
		alert("주문할 항목을 선택하세요");
	}else{
		var ans =confirm("선택한 항목을 주문할까요?");
		if(ans){
			document.cartFrm.action = "shop.do?command=orderInsert";
			document.cartFrm.submit();
		}
		
	}
}

function go_order(){
	var ans =confirm("현재 상품을 주문할까요?");
	if(ans){
		document.formm.action ="shop.do?command=orderInsertOne";
		document.formm.submit();
	}
}*/





