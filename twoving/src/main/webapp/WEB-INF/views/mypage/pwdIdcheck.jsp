<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<script src="script/mypage.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/member.js"></script>
</head>
<body>
<h1>ID 체크 확인</h1>
<form method="post" name="idCheckForm" action="twoving.do?command=pwdIdcheckForm">
	사용자 아이디 : <input type="text" name="userid" value="${userid}">
	<input type="submit" value="검색"><br><br><br>
</form>
<div>
	<c:if test="${result==1}">
		${userid}는 존재하는 아이디입니다.
		<input type="button" value="확인" onclick="idok2('${userid}')">
	</c:if>
	<c:if test="${result == -1}">
		<script type="text/javascript">
			opener.document.findPwd.userid.value="";
			opener.document.findPwd.reid.value="";
		</script>
		${userid}는 존재하지 않는 아이디입니다. 다시 확인해주세요.
	</c:if>
</div>
</body>
</html>