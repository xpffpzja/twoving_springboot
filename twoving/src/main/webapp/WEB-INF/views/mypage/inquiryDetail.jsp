<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<link rel="stylesheet" href="admin/css/adminList2.css" />
<script src="admin/script/admin.js"></script>
<script src="admin/script/mypage.js"></script>
<link rel="stylesheet" type="text/css" href="css/mypage.css">
<article>

		  <div class="box">
   
   <div class="box1">
   <input type="button" class="logo" onclick="location.href='twoving.do?command=tMain'" style="cursor: pointer; color:red;" value="TWOVING" />
               <div class="box1-2"><a href="twoving.do?command=kind&kind=0"  style="color:white;">시리즈</a></div>
               <div class="box1-3"><a href="twoving.do?command=kind&kind=1" style="color:white;">영화</a></div>
    </div>
    <div class="box2">
          <div class="box2-2" id="input"><input type="text" placeholder="검색"  name="key" value="${key}" ><a href="#" onClick="go_search('searchList')"><img src="member/돋보기.png" width="40px" height="40px"  /></a>&nbsp;&nbsp;</div>
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
      
      <div class="box44" >
      
   
      
      <div class="box44-2" onClick="location.href='twoving.do?command=steamedList&kind=0'">찜 &nbsp;</div>
      <div class="box44-3" onClick="location.href='twoving.do?command=passTicketList'">이용권 &nbsp;</div>
      <div class="box44-4" onclick="location.href='twoving.do?command=customerInquiryListMypage'">문의 내역 &nbsp;</div>

      
      
      </div>
      
      
      
      
      <!-- 여기부터 -->
	<form name="inquiryViewFrm" method="post"  enctype="multipart/form-data" style=" color:white; ">
	<div style="margin-top: 1150px;">
	<input type="hidden" name="ciseq" value="${cvo.ciseq}"/>
		   <div style="float: right;"> <!-- Container for positioning -->
        <input type="button" style="color:white; border:none; font-size: 90%; cursor: pointer; background-color: #353535; text-align: right;" value="문의하기" onclick="location.href='twoving.do?command=customerinquiry'">
    </div>
				<!-- 고객문의로 가기 -->
			<div class="field" style="height: 50px; ">
					<label style=" font-size: 180%;  padding-top: 5px;text-align: left"> ${cvo.inquirytitle}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;
					${cvo.indate}</label>
			</div>
			<div class="field" style="padding : 10px; text-align: left; color:gray;">
					<c:choose>
					<c:when test="${empty cvo.reply }"> 
						<label style="font-size: 115%;">처리중&nbsp;
							<c:out value="|" />&nbsp;
							${cvo.inquiryList}	
						</label> 
					</c:when>
					<c:otherwise>	<!-- 관리자 답변 후 표시 -->
						<label style="font-size: 115%;">답변완료&nbsp;
							<c:out value="|" />&nbsp;
							${cvo.inquiryList}	
						</label> 
					</c:otherwise>
				</c:choose>
			</div>

			<div class="field" style="text-align: left; color:gray;">
					<label></label>
			</div>
			<div class="field" style="text-align: left; color:gray;">
					<label>1.디바이스 :  ${cvo.devicephone} / 디바이스명 : ${cvo.devicemodelname}</label>
			</div>
			<div class="field" style="text-align: left; color:gray;">
					<label>2.통신 환경 : ${cvo.runenvironment}</label>
			</div>
			<div class="field" style="text-align: left; color:gray;">
					<label>3.이용장소 :  ${cvo.runplace}</label>
			</div>
			<div class="field" style="text-align: left; color:gray;">
					<label>4.이용시간 :  ${cvo.runtime1}~${cvo.runtime2}</label>
			</div>
			<div class="field" style="text-align: left; color:gray;">
					<label>5.이용 콘텐츠 :  ${cvo.runcontent}</label>
			</div>
			<div class="field" style="text-align: left; color:gray;">
					<label>6.상세내용 :  ${cvo.inquirycontent}</label>
			</div>
			<p>
			
			<label style="font-size: 140%; color: gray">-------------------------------------------------------------------------------------------------------------</label>
			<p>
			<c:choose>
					<c:when test="${empty cvo.reply }" > <!-- 관리자 답변 전 표시 -->
					</c:when>
					<c:otherwise>	<!-- 관리자 답변 후 표시 -->
						<div class="field" style="text-align: left" >
								<label style="font-weight: bold; font-size: 180%; text-align: left;">
								답변드립니다.
								</label>
						</div>
						<div class="field" style="text-align: left">
								<label style="font-size: 130%;  color:gray;"><pre>${cvo.reply}</pre></label>
						</div>	
					</c:otherwise>
				</c:choose>
				<div style="text-align: right;">
			<input type="button" style="margin-left: auto;  background-color: #353535; color:white; border:none; font-size: 90%; cursor: pointer;" 
				value="목록으로" onclick="location.href='twoving.do?command=customerInquiryListMypage'"></div>
						<jsp:include page="../paging/passTicketPaging2.jsp">
			<jsp:param value="twoving.do?command=customerInquiryListMypage" name="address" />
		</jsp:include>
		</div>
	</form>
</article>

