<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script src="script/mypage.js"></script>
<script src="script/member.js"></script>
<script src="script/Tmain.js"></script>
<script src="script/payment.js"></script>
<script src="script/jquery-3.7.1.min.js"></script>
<script src="script/payment.js"></script>

<link rel="stylesheet" href="css/mypage.css">
<link rel="stylesheet" href="css/header_footer.css">
<link rel="stylesheet" type="text/css" href="css/mypage.css">



<title>Insert title here</title>
<!-- <script type="text/JavaScript">
$(function(){
   $('.box2-1').hover(function(){
                $('.profileclick').slideToggle(300);
            $(this).toggleClass('active');
         });
         });  
</script> -->
</head>
<body>
   <section>
   <article>
   <form method="post" name="form">
   <div class="box">
   
   <div class="box1">
   <input type="button" class="logo" onclick="location.href='tMain'" style="cursor: pointer; color:red;" value="TWOVING" />
        <div id="Category" style="color:white;">&nbsp;&nbsp;&nbsp;&nbsp;
            <c:forEach var="kind" items="${kindList}">
                <a href="kind?kind=${kind}">${kind == 0 ? '시리즈' : '영화'}</a>&nbsp;&nbsp;&nbsp;&nbsp;
            </c:forEach>
		</div>
    </div>
    <div class="box2">
          <div class="box2-2" id="input"><input type="text" placeholder="검색"  name="key" value="${key}" ><a href="#" onClick="go_search('searchList')"><img src="/images/돋보기.png" width="40px" height="40px"  /></a>&nbsp;&nbsp;</div>
          <div class="box2-1" ><a href="#"><img src="/images/logo.png" width="40px" height="40px"  /></a>&nbsp;&nbsp;
          	<div class="profileclick">
                  <br><br><br><br><br><br>
                  <div class ="kjy"><a href="mypage">My페이지</a></div>
                  <br>
                  <div class ="kjy"><a href="notice">고객센터</a></div>
                  <br>
                  <div class ="kjy"><a href="logout">로그아웃</a></div>
            </div>
          
          </div>
	 </div>
    
<!--     <div class="box1">
   <input type="button" class="logo" onclick="location.href='twoving.do?command=tMain'" style="cursor: pointer;"value="TWOVING" />
               <div class="box1-2">시리즈</div>
               <div class="box1-3">영화</div>
       </div>
      <div class="box2">
          <div class="box2-2"><img src="member/돋보기.png" width="40px" height="40px"  />&nbsp;&nbsp;</div>
          <div class="box2-1"><img src="member/logo.png" width="40px" height="40px"  />&nbsp;&nbsp;</div>
	 </div>  -->
	 
      </div>
      <div class="box22">
         <div class="box22-1"><img src="/images/logo.png" width="120px" height="120px"  /></div>
         <div class="box22-2"><span>이름</span>&nbsp;&nbsp; ${loginUser.name}<br>
         <a><img src="/images/구름.png" width="30px" height="30px" /></a>&nbsp; 나의 이용권
         	<c:choose>
         		<c:when test="${passTicketVO.ptseq == 1}">
         			&nbsp;광고형 스탠다드
         		</c:when>
         		<c:when test="${passTicketVO.ptseq == 2}">
         			&nbsp;베이직
         		</c:when>
         		<c:when test="${passTicketVO.ptseq == 3}">
         			&nbsp;스탠다드
         		</c:when>
         		<c:when test="${passTicketVO.ptseq == 4}">
         			&nbsp;프리미엄
         		</c:when>
         	</c:choose>
         
         	<c:choose>
         		<c:when test="${empty memberVO.userid}">
         			<input type="button" onClick="updateDefuseCheck2()" value="이용권 구독"   style="background-color: #191919; border-radius: 3px; border:1px solid gray; color: white; cursor: pointer;"/>
         		</c:when>
         		<c:otherwise>
         		     <input type="button" onClick="updateDefuseCheck('${paymentVO.productname}')" value="이용권 구독"   style="background-color: #191919; border-radius: 3px; border:1px solid gray; color: white; cursor: pointer;"/>
         		</c:otherwise>
         	</c:choose>
	      </div>
         
         <div class="box22-3" onClick="location.href='updateMemberForm'"><a><img src="/images/톱니바퀴.png" width="30px" height="30px" /></a>회원정보 수정</div>

      </div>
      <div class="box33">
      <div class="box33-1">
         이용권을 구독하고 <a>twoving</a> 등 인기 TV프로그램과 다양한 영화를 자유롭게 시청하세요!
      </div>
          <div style="color: white">${message}</div>
      </div>
      
      <div class="box44">
           
      <div class="box44-2" onClick="location.href='steamedList?kind=0'">찜 &nbsp;</div>
      <div class="box44-3" onClick="location.href='passTicketList'">이용권/캐시 내역 &nbsp;</div>
      <div class="box44-4" onclick="location.href='customerInquiryListMypage'">문의 내역 &nbsp;</div>
    
      </div>
   </form>
   
   </article>
</section>
</body>
</html>



