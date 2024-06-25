<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<script src="script/mypage.js"></script>
<head>
	<meta charset="UTF-8">
    <title>비밀번호 재설정</title>
</head>
<body>
	<h1>이메일 인증 성공!</h1>
    <h1>비밀번호 재설정</h1>
<!-- <form action="../ResetPasswordServlet" method="post"> -->
	<form action="twoving.do?command=resetPassword" method="post" name="resetPassword">
		<input type="hidden" value="${userid}" name="userid">
        <label for="password">새로운 비밀번호 입력 : </label>
        <input type="password" id="password" name="pwd" required><br><br>
        <label for="confirmPassword">비밀번호 확인 : </label>
        <input type="password" id="confirmPassword" name="pwdCheck" required><br><br>
        <input type="button" value="비밀번호 재설정" style="cursor: pointer;" onClick="resetPassword2()">
        <p class="input-info2" id="passwordConfirmMsg1" style="color: red; margin-left: 10px; opacity: 65%;">
			비밀번호 : 영문 소/대문자, 숫자 조합 6~12 자리로 설정해주세요.
		</p>
    </form>
</body>
</html>