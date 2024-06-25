<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/findid.css">
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="script/mypage.js"></script>
</head>
<body>
<form action="twoving.do?command=findId" method="post" name="findId">
  <input type="button"	 class="logo" onclick="location.href='twoving.do?command=index'" value="TWOVING" style="cursor: pointer;" />
  <h1>아이디 찾기</h1>
  <div class="all">
	  <div class="text" style="width:600px;">
	  		<p>이메일로 찾기</p>
	  		<p style="color: gray;">가입 시 등록한 이메일을 입력해주세요</p>
	  </div>
	  
	  <input type="email" style="width:600px; font-size: 120%;" placeholder="이메일" class="box1" id="email" name="email" required />
	  <br>
	  <input type="button" class="box2" value="확인"  style="cursor: pointer;" onClick="go_idFind()"/>
  </div>
</form>
</body>
</html>