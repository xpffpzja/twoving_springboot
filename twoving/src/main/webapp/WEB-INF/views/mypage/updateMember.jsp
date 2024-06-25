<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <script src="script/mypage.js"></script>

<link rel="stylesheet" href="css/update.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="twoving.do?command=updateMember" name="updateForm">
	<button class="logo" onclick="location.href='twoving.do?command=index'" style="cursor: pointer;">TWOVING</button>
					<h2 style="margin-top: 50px;">회원정보 수정</h2>
					<div class="field">
						<label style="font-size: 130%; text-align: left;">아이디</label>
						<input style="font-size: 130%; height: 85px;" name="userid" type="text" value="${loginUser.userid}" readonly/>
					</div>
					<div class="field">
						<label style="font-size: 130%; text-align: left;">비밀번호</label>
						<input style="font-size: 130%; height: 85px;" name="pwd" type="password"/>
					</div>
					<div class="field">
						<label style="font-size: 130%; text-align: left;">비밀번호확인</label>
						<input style="font-size: 130%; height: 85px;" name="pwdCheck" type="password"/>
					</div>
					<div class="field">
						<label style="font-size: 130%; text-align: left;">이름</label>
						<input style="font-size: 130%; height: 85px;" name="name" type="text" value="${loginUser.name}"/>
					</div>
					<div class="field">
						<label style="font-size: 130%; text-align: left;">이메일</label>
						<input style="font-size: 130%; height: 85px;" name="email" type="text" value="${loginUser.email}"/>
					</div>
					<div class="field">
						<label style="font-size: 130%; text-align: left;">휴대폰 번호</label>
						<input style="font-size: 130%; height: 85px;" name="phone" type="text" value="${loginUser.phone}" maxlength='13' placeholder="010-1111-2222"/>
					</div>
				<input type="button" class="secession" onclick="location.href='twoving.do?command=deleteMemberForm'" value="회원탈퇴" />
	<div class="btn">
		<input type="button"  class="btn1" value="확인" onClick="go_updateMember()" />
  		<input type="button"  class="btn2" value="취소" onClick="location.href='twoving.do?command=passTicketList'"/>
	</div>
</form>
	
		
</body>
</html>