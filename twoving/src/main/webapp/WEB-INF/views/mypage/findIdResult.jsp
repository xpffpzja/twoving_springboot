<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
body {
   background-color: black;
}

.logo {
   position: absolute;
   top: 20px;
   left: 20px;
   color: red;
   font-size: 40px;
   font-weight: bold;
   background: black;
   border: 1px solid black;
   font-family: "Noto Sans KR", -apple-system, BlinkMacSystemFont, "Roboto",
      Segoe UI, Oxygen, Ubuntu, Cantarell, Open Sans, Helvetica Neue,
      sans-serif;
}

.id {
   color: white;
   text-align: center;
   font-weight: bold;
   font-size: 220%;
}

.id1 {
   color: darkgray;
   text-align: center;
   margin-top: 15px;
   font-size: 140%;
}

.id2 {
   justify-content: center;
   align-items: center;
   text-align: center;
   margin-top: 100px;
}

.id3 {
   justify-content: center;
   align-items: center;
   text-align: center;
   margin-top: 150px;
   color: gray;
}

.btn1 {
   position: absolute;
   left: 49.5%;
   transform: translateX(-50%); 

   width: 600px;
   margin: 10px;
   padding: 20px;
   border: none;
   border-radius: 5px;
   box-sizing: border-box;
   font-size: 20px;
   background-color: white;
   color: black;
   cursor: pointer;
   font-weight: bold;
}

.id4 {
   width: 600px;
   height: 80px;
   border: none;
   border-radius: 5px;
   background-color: 232323;
   display: flex;
   justify-content: center;
   align-items: center;
   justify-content: flex-start;
   align-items: center;
   padding-left: 20px;
   position: absolute;
   margin-top: -100px;
   left: 50%;
   transform: translate(-50%, -50%);
}

.id4 img {
   max-width: 40px;
   max-height: 40px;
}

.id5 {
   color: gray;
   margin-left: 20px;
}

.id6 {
   color: white;
   margin-left: 20px;
}
</style>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

   <input type="button" class="logo"
      onclick="location.href='twoving.do?command=tMain'"
      style="cursor: pointer; color: red;" value="TWOVING" />
   <div class="id2">
      <img src="member/체크.png" width="150px" height="150px" />
   </div>
   <div class="id">입력하신 정보와 일치하는 결과입니다.</div>
   <div class="id1">
   <c:if test="${!empty memberId}">
		해당 아이디로 로그인 하시길 바랍니다.	 
   </c:if>   
   </div>
   <div class="id3">※SNS 회원은 해당 SNS 아이디가 아닌 티빙 가입 시 등록한 이메일을 알려드립니다.</div>
   <div class="id4">
      <a href="#"><img src="member/logo.png" alt="로고" /></a>
      <div class="id5" style="font-size: 125%;">TWOVING ID : </div>
      <div class="id6" style="font-size: 125%; color:white;">
	      	<c:if test="${empty memberId}">
			    해당 이메일로 조회되는 회원은 없습니다.
			</c:if>    	
	      	${memberId}
      </div>
   </div>
   <input type="button" onClick="location.href='twoving.do?command=login'"
      class="btn1" value="로그인 하러 가기" />
</body>
</html>