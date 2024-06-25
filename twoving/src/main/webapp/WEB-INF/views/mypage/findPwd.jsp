<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/findpwd.css">
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="script/mypage.js"></script>
</head>
<body>
<form action="SendEmailServlet" method="post" name="findPwd">
	  <input type="button"	 class="logo" onclick="location.href='twoving.do?command=index'" value="TWOVING" style="cursor: pointer;" />
	  <h1>비밀번호 찾기</h1>
	  <div class="all">
		  <div class="text">
			  아이디 확인 후 등록된 이메일 주소로 비밀번호 재설정을 위한 인증 메일이 발송됩니다. 
			  이메일을 확인하여 인증 코드를 입력해주세요. <!-- 12시간 이내에 비밀번호 재설정을 완료해주세요. --><br>
			  (현재는 비밀번호 찾기는 이메일 naver.com만 가능합니다.)
		  </div>
		  
		  <div>
			  <input type="text" style="width:400px; font-size: 120%;" placeholder="아이디" class="box1" name="userid" size="45"/>
			  <input type="button" style="width:200px; background: black; color:white; cursor: pointer; font-size: 120%;" 
			  class="box1"  name="idcheck" value="아이디체크" onClick="idcheck2()" />
			  <input type="hidden" name="reid"/>
		  </div>
		  <br>
		  <input type="button" class="box2" value="확인" style="cursor: pointer;" onClick="go_pwFind()"/>
	  </div>
</form>
</body>
</html>