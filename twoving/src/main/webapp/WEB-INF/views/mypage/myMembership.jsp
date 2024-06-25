<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>

<script src="script/Tmain.js"></script>
<script src="script/payment.js"></script>
<link rel="stylesheet" href="css/mypage.css">
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/JavaScript">
$(function(){
   $('.mypage').hover(function(){
                $('.profileclick').slideToggle(300);
            $(this).toggleClass('active');
         });
         });  
</script>
</head>
<body>
   <section>
   <article>
   <form method="post" name="form">
   <div class="box">
   
   <div class="box1">
   <input type="button" class="logo" onclick="location.href='twoving.do?command=tMain'" style="cursor: pointer; color:red; "value="TWOVING" />
               <div class="box1-2"><a href="twoving.do?command=kind&kind=0" style="white;">시리즈</a></div>
               <div class="box1-3"><a href="twoving.do?command=kind&kind=1" style="white;">영화</a></div>
    </div>
    <div class="box2">
          <div class="box2-2"><input type="text" placeholder="검색"  name="key" value="${key}" ><img src="member/돋보기.png" width="40px" height="40px"  />&nbsp;&nbsp;</div>
          <div class="box2-1"><a href="#" onClick="go_search('searchList')"><img src="member/logo.png" width="40px" height="40px"  /></a>&nbsp;&nbsp;</div>
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
         <div class="box22-1"><img src="member/logo.png" width="120px" height="120px"  /></div>
         <div class="box22-2"><span>이름</span> ${loginUser.name}
         <p><img src="member/구름.png" width="30px" height="30px" />&nbsp; 나의 이용권&nbsp;&nbsp; ${paymentVO.productname}
         <input type="button" onClick="updateDefuseCheck('${paymentVO.productname}')" value="이용권 구독" style="background-color: #191919; border-radius: 3px; border:1px solid gray; color: white; cursor: pointer;"/></p></div>
         
         <div class="box22-3" onClick="location.href='twoving.do?command=updateMemberForm'"><a><img src="member/톱니바퀴.png" width="30px" height="30px" /></a>회원정보 수정</div>
         
      </div>
      <div class="box33">
      <div class="box33-1">
         이용권을 구독하고 <a>twoving</a> 등 인기 TV프로그램과 다양한 영화를 자유롭게 시청하세요!
      </div>
      </div>
      
      <div class="box44">
      
   
      <div class="box44-1">시청 내역 &nbsp;</div>
      <div class="box44-2">찜 &nbsp;</div>
      <div class="box44-3" onClick="location.href='twoving.do?command=passTicketList'">이용권/캐시 내역 &nbsp;</div>
      <div class="box44-4">문의 내역 &nbsp;</div>

      
      
      </div>
   </form>
   
   </article>
</section>
</body>
</html>

