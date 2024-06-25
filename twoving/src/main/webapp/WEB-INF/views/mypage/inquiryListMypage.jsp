<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<link rel="stylesheet" href="admin/css/adminList.css" />
<script src="admin/script/admin.js"></script>
<script src="admin/script/mypage.js"></script>
<link rel="stylesheet" type="text/css" href="css/mypage.css">
<link rel="stylesheet" type="text/css" href="css/inquiry.css">
<article>

		  <div class="box">
   
   <div class="box1">
   <input type="button" class="logo" onclick="location.href='twoving.do?command=tMain'" style="cursor: pointer; color:red;" value="TWOVING" />
               <div class="box1-2"><a href="twoving.do?command=kind&kind=0"  style="color:white;">시리즈</a></div>
               <div class="box1-3"><a href="twoving.do?command=kind&kind=1" style="color:white;">영화</a></div>
    </div>
    <div class="box2">
          <%-- <div class="box2-2" id="input"><input type="text" placeholder="검색"  name="key" value="${key}" ><a href="#" onClick="go_search('searchList')"><img src="member/돋보기.png" width="40px" height="40px"  /></a>&nbsp;&nbsp;</div> --%>
          <div class="box2-1" ><a href="#"><img src="member/logo.png" width="40px" height="40px"  /></a>&nbsp;&nbsp;
          	<div class="profileclick" >
                  <br><br>
                  <div><a href="twoving.do?command=mypage">My페이지</a></div>
                  <br>
                  <div><a href="twoving.do?command=notice">고객센터</a></div>
                  <br>
                  <div><a href="twoving.do?command=logout">로그아웃</a></div>
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
         <div class="box22-1"><img src="member/logo.png" width="120px" height="120px"  /></div>
         <div class="box22-2"><span>이름</span>&nbsp;&nbsp; ${loginUser.name} <br>
         <a><img src="member/구름.png" width="30px" height="30px" /></a>&nbsp; 나의 이용권
  
         <a> <input type="button" onClick="updateDefuseCheck('${paymentVO.productname}')" value="이용권 구독"   style="background-color: #191919; border-radius: 3px; border:1px solid gray; color: white; cursor: pointer;"/></a></p></div>
         
         <div class="box22-3" onClick="location.href='twoving.do?command=updateMemberForm'"><a><img src="member/톱니바퀴.png" width="30px" height="30px" /></a>회원정보 수정</div>
         
      </div>
      <div class="box33">
      <div class="box33-1">
         이용권을 구독하고 <a>twoving</a> 등 인기 TV프로그램과 다양한 영화를 자유롭게 시청하세요!
      </div>
      </div>
      
      <div class="box44">
      
   
      
      <div class="box44-2" onClick="location.href='twoving.do?command=steamedList&kind=0'">찜 &nbsp;</div>
      <div class="box44-3" onClick="location.href='twoving.do?command=passTicketList'">이용권 &nbsp;</div>
      <div class="box44-4" onclick="location.href='twoving.do?command=customerInquiryListMypage'">문의 내역 &nbsp;</div>

      
      
      </div>
		
	<form method = "post" name="frm" style="width: 1900px;">
	<div class="tb" style="margin-top: 1000px; " >
		<div class="row" style="margin-top: 220px;">
			<div class="col" style="display:flex; align-items : center; border:3px solid black; background-color: #353535; height: 50px; ">
				<div class="search">제목 검색  :   &nbsp;</div> &nbsp;
				<input type="text" style="border:1px solid white; background-color:#353535; width: 200px; height: 30px; color:white;"  name="key" value="${key}">
				&nbsp;&nbsp;&nbsp;
				<div>
				<!-- <img src="admin/images/search.png" style="width:30px; cursor: pointer;" onClick="go_search( 'adminCustomerInquiryList' )"> -->
				<img src="member/돋보기.png" style="width:30px; cursor: pointer;" onClick="go_search( 'customerInquiryListMypage' )">
				</div>
				&nbsp;&nbsp;&nbsp;
			</div>
		</div>
		<!-- <br> -->
<div class="row" style="display: flex; flex-direction: row; background-color: #353535; height: 50px;border: 1px solid gray;">
    <div class="coltitle" style="flex: 1	;">상태</div>
    <div class="coltitle" style="flex: 1.5;">구분</div>
    <div class="coltitle" style="flex: 6;">제목</div>
    <div class="coltitle" style="flex: 1;">등록일</div>
</div>

<c:forEach items="${inquiryList}" var="inquiryVO" >
    <div class="row" style="border: 1px solid gray;">
        <div class="col" style="flex: 1; border-right: 1px solid gray;" >
            <c:choose>
                <c:when test='${empty inquiryVO.reply}'>
                    <span style="color: red;">처리중</span> 
                </c:when>
                <c:otherwise>
                    <!-- <span style="font-weight: bold;">답변완료</span> -->
                    답변완료
                </c:otherwise>
            </c:choose>
        </div>
        <div class="col" style="flex: 1.5; border-right: 1px solid gray;">${inquiryVO.inquiryList}</div> <!-- Adjust this to display the correct category -->
        
        <div class="col" style="flex: 6; color:white;">
            <a href="#" onClick="go_detailInquiryMypage('${inquiryVO.ciseq}')" style="color:white;">
                ${inquiryVO.inquirytitle}
            </a>
        </div>
        
        <div class="col" style="flex: 1;border-left: 1px solid gray;">
            <fmt:formatDate value="${inquiryVO.indate}" />
        </div>
    </div>
</c:forEach>
		<jsp:include page="../paging/passTicketPaging2.jsp">
			<jsp:param value="twoving.do?command=customerInquiryListMypage" name="address" />
		</jsp:include>
	</div>
	</form>
</article>

