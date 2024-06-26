<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="Theader.jsp" %>

      <div class="box22">
         <div class="box22-1"><img src="images/logo.png" width="120px" height="120px"  /></div>
         <div class="box22-2"><span>이름</span>&nbsp;&nbsp; ${loginUser.name}
         <p><a><img src="images/구름.png" width="30px" height="30px" /></a>&nbsp; 나의 이용권
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
         
         <a>
         	<c:choose>
         		<c:when test="${empty memberVO.userid}">
         			<input type="button" onClick="updateDefuseCheck2()" value="이용권 구독"   style="background-color: #191919; border-radius: 3px; border:1px solid gray; color: white; cursor: pointer;"/>
         		</c:when>
         		<c:otherwise>
         		     <input type="button" onClick="updateDefuseCheck('${paymentVO.productname}')" value="이용권 구독"   style="background-color: #191919; border-radius: 3px; border:1px solid gray; color: white; cursor: pointer;"/>
         		</c:otherwise>
         	</c:choose>
         </a></p></div>
         
         <div class="box22-3" onClick="location.href='updateMemberForm'"><a><img src="images/톱니바퀴.png" width="30px" height="30px" /></a>회원정보 수정</div>
         
      </div>
      <div class="box33">
      <div class="box33-1">
         이용권을 구독하고 <a>twoving</a> 등 인기 TV프로그램과 다양한 영화를 자유롭게 시청하세요!
      </div>
      </div>
      
      <div class="box44">
      <div class="box44-2" onClick="location.href='steamedList?kind=0'">찜 &nbsp;</div><div class="box44-3" onClick="location.href='twoving.do?command=passTicketList'">이용권 &nbsp;</div>
      <div class="box44-4" onclick="location.href='customerInquiryListMypage'">문의 내역 &nbsp;</div>
      </div>
      <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
      <div class="poiu" ><!-- style="margin-left: -940px;" -->
      		<br>	
			<div class="fdsa">
				<a href="steamedlist?kind=0"><span style="color:gray; margin-left: 15px;">시리즈</span></a> &nbsp;&nbsp; | &nbsp;&nbsp;
				<a href="steamedlist?kind=1"><span style="color:gray;">영화</span></a>
			</div>
			<br>
			<div id="hahaha">
			<c:forEach var = "ssteamed" items="${steamedList1}">
						<div id="ssteamed"><a href="Tdetail?pseq=${ssteamed.pseq}"><img src="images/image2/${ssteamed.savefilename}"></a></div>
					</c:forEach>
			</div>					
	 </div>


<%@ include file="Tfooter.jsp" %>