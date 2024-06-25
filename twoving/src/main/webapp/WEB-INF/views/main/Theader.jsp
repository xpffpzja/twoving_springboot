<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/Theader.css">
<link rel="stylesheet" href="css/Tmain.css">
<link rel="stylesheet" href="/css/Tfooter.css">
<link rel="stylesheet" href="css/Tdetail.css">
<link rel="stylesheet" href="css/kind.css">
<link rel="stylesheet" href="css/genre.css">
    <link rel = "stylesheet" type =  "text/css" href = "/css/section.css"/>
<!-- <link rel = "stylesheet" type =  "text/css" href = "css/header_footer.css"/> -->
<script src="script/jquery-3.7.1.min.js"></script>
<script src="script/faqForm.js"></script>
<script src="script/jqueryAction.js"></script>
<script src="script/customerinquiry.js"></script>
<script src="script/cosmenuWrapper.js"></script>
<script src="script/slideToggleFuc.js"></script>
<script src="script/mypage.js"></script>
<script src="script/Tmain.js"></script>

<script>

</script>


</head>
<body>
<div id="full">
   <header style="margin-bottom: 10px;">
      <nav id="rightlink">
         <div id="logo">         
            <a href="twoving.do?command=tMain">TWOVING</a>
         </div>&nbsp;&nbsp;&nbsp;&nbsp;
         <div id="Category">
            <c:forEach var="kind" items="${kindList}">
                <a href="twoving.do?command=kind&kind=${kind}">${kind == 0 ? '시리즈' : '영화'}</a>&nbsp;&nbsp;&nbsp;&nbsp;
            </c:forEach>
		</div>
      </nav>
      <nav id ="search">                     
         <form method="post" name="form">                     
         <div id = "dbg">
            <div id="input"><input type="text" placeholder="검색"  name="key" value="${key}" ></div>
            <div><a href="#" onClick="go_search('searchList')"><img src="images/돋보기.png" style="width:35px; height:35px;" ></a></div>                     
         </div>
         </form>   
          &nbsp;&nbsp;&nbsp;&nbsp;
         <div class="mypage"><a href="#"><img src="images/logo.png"  style="width:40px; height:40px; "></a>
            <div class="profileclick" >
                  <br>
                  <div class ="kjy"><a href="twoving.do?command=passTicketList" >My페이지</a></div>
                  <!-- <div class ="kjy"><a href="twoving.do?command=steamedList&kind=0" >My페이지</a></div> -->
                  <br>
                  <div class ="kjy"><a href="twoving.do?command=notice">고객센터</a></div>
                  <br>
                  <div class ="kjy"><a href="twoving.do?command=logout">로그아웃</a></div>
            </div>
         </div>      
      </nav>   
   </header>
	