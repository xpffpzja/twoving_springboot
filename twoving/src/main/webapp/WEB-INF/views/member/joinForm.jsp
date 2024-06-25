<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="script/jquery-3.7.1.min.js"></script>

<script src="script/member.js"></script>
<link rel="stylesheet" href="css/join.css">
<link rel="stylesheet" href="css/header_footer.css">

<button class="logo" onclick="location.href='index'" style="cursor: pointer;">TWOVING</button>
<section class="login-agree-new login">
	<article>
		<form action="join" method="post" name="joinForm">
			<div class="content-wrap">
				<!--타이틀 시작-->
				<div class="wrap">
					<h3 class="title">투빙 회원가입</h3>
					<p class="new">아이디와 이메일로 간편하게 투빙을 시작하세요!</p>

				</div>
				<!--입력폼 시작-->
				<div class="id" style="margin-top: 10px">
					<label for="userid" class="userid" > 
						<input id="userid"  name="userid" class="in-icon-close" required="required"
							type="text" placeholder="아이디" tabindex="1" style="width:500px;" >
						<input type="hidden" name="reid"/>
						<input value="중복 체크" type="button" class="in-icon-close2"  onClick="idcheck()"/>
					</label>
					<p class="input-info1" id="userIdMsg" style="color: white; margin-left: 10px; opacity: 65%;">
					<!-- 아이디 : 영문 소문자, 숫자 조합 6~12 자리 -->
					아이디 : 영문 소문자, 숫자 조합 4~12 자리
					</p>
							<div class="field">
								<label class="label">ID</label>
							</div>
				</div>

				<div class="login__password">
					<label for="pwd" class="datainput-long layout__flex-left" >
						<input id="pwd" name="pwd" class="in-icon-close" required="required"
						type="password" maxlength="15" placeholder="비밀번호" tabindex="2" oninput="pwCheck()" >


						<!--active 삽입 활성화-->
					</label>
					<p class="input-info display-none" id="passwordMsg"></p>
				</div>

				<div class="login__password">
					<label for="passwordConfirm"
						class="datainput-long layout__flex-left" > 
						<input id="passwordConfirm" class="in-icon-close" name="pwdCheck" required="required"
						type="password" maxlength="15" placeholder="비밀번호 확인" tabindex="3" oninput="pwCheck()" >


						<!--active 삽입 활성화-->
					</label>
					<p class="input-info2" id="passwordConfirmMsg1" style="color: white; margin-left: 10px; opacity: 65%;">
					<!-- 영문, 숫자, 특수문자(~!@#$%^&*) 조합 8~15 자리 -->
					비밀번호 : 영문 소/대문자, 숫자 조합 6~12 자리
					</p>
					<p class="input-info2" id="passwordConfirmMsg2" style="color: white; margin-left: 10px; opacity: 65%;">
					비밀번호를 입력하세요</p>
				</div>

				<div class="name">
					<label for="name" class="name" > 
					<input id="name"  name="name" class="in-name" required="required"
						type="text" placeholder="이름" tabindex="4" >
					</label>
				</div>
				
				<div class="login__email">
					<label for="email" class="datainput-long layout__flex-left" >
						<input id="email" class="in-icon-close" type="text" name="email"
						required="required" maxlength="115" placeholder="이메일" tabindex="5">

					</label>
					<p class="input-info1" id="emailMsg" style="color: white; margin-left: 10px; opacity: 65%;">
						정확한 이메일을 입력해주세요. (비밀번호 찾기는 이메일 naver.com만 가능)
					</p>
				</div>

				<ul class="btn-checks-wrap btn-checks-noline" style="margin-top: 0;">

					<li class="btn-checks btn-checks-small  " id="agree-li-10">
					<input type="checkbox" id="agree10" name="termsCheck" class="agree-item required-agree ">
					<label for="agree10" class="agree"> [필수] 서비스 이용약관 동의 </label></li>
				</ul>

				<div class="btn-wrap">
					<input type="button" id="registBtn" class="join" onClick="go_save()" value="가입하기" style="color: white;" />
				</div>
			</div>
		</form>
	</article>
</section>