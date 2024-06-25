<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <title>인증 코드 확인</title>
</head>
<body>
<% 
	String userid = request.getParameter("userid");
%>
<script>
	console.log(userid)
</script>

    <h2>인증 코드 확인</h2>
    <form action="../VerifyCodeServlet" method="post">
    	<input type="hidden" value="<%= userid %>" name="userid" >
        <label for="code">인증 코드를 입력하세요 : </label>
        <input type="text" id="code" name="code" required>
        <input type="submit" value="확인" style="cursor: pointer;">
    </form>
</body>
</html>