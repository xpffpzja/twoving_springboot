<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="../sub_menu.jsp" %>

<link rel="stylesheet" href="/admin/css/notice.css" />

<article>
	<form name="inquiryViewFrm" method="post"  enctype="multipart/form-data">
	<input type="hidden" name="ciseq" value="${cvo.ciseq}" />
			<h1 style="border-bottom: 2px solid black;"> 고객문의 상세 보기 </h1>
			<div class="field" style="border-bottom: 1px dotted black;">
					<label>이름</label><div>${cvo.name}</div>
			</div>
			<div class="field" style="border-bottom: 1px dotted black;">
					<%-- <label>이메일</label><div>${cvo.emailid}@${cvo.emailid2}</div> --%>
					<label>이메일</label><div>${cvo.email}</div>
			</div>
			<div class="field" style="border-bottom: 1px dotted black;">
					<%-- <label>연락처</label><div>${cvo.phone}-${cvo.phone1}-${cvo.phone2}</div> --%>
					<label>연락처</label><div>${cvo.phone}</div>
			</div>
			<div class="field" style="border-bottom: 1px dotted black;">
					<label>문의종류</label><div>${cvo.inquirylist}</div>
			</div>
			<div class="field" style="border-bottom: 1px dotted black;">
					<label>디바이스</label><div>${cvo.devicephone} / ${cvo.devicemodelname}</div>
			</div>
			<div class="field" style="border-bottom: 1px dotted black;">
					<label>통신환경</label><div>${cvo.runenvironment}</div>
			</div>
			<div class="field" style="border-bottom: 1px dotted black;">
					<label>이용장소</label><div>${cvo.runplace}</div>
			</div>
			<div class="field" style="border-bottom: 1px dotted black;">
					<label>이용시간</label><div>${cvo.runtime1}~${cvo.runtime2}</div>
			</div>
			<div class="field" style="border-bottom: 1px dotted black;">
					<label>이용컨텐츠</label><div>${cvo.runcontent}</div>
			</div>
			<div class="field" style="border-bottom: 1px dotted black;">
					<label>문의제목</label><div>${cvo.inquirytitle}</div>
			</div>
			<div class="field" style="border-bottom: 1px dotted black;">
					<label>문의내용</label><div><pre>${cvo.inquirycontent}</pre></div>
			</div>
			
			<div class="field" style="border-top:1px solid black; border-bottom:2px solid black;">
			<label style="line-height: 130px;">답변내용</label>
			<div style="padding:30px; align-items: center; justify-content: flex-start;">
				<c:choose>
					<c:when test="${empty cvo.reply }"> <!-- 관리자 답변 전 표시 -->
						<!-- <img src="admin/images/opinionimg01.gif" width="200px"; style="flex:1"> -->
						<textarea name="reply" rows="7" cols="100"></textarea>&nbsp;&nbsp;
						<input type="button" style="flex:1; background-color: black; color:white; border:none; font-size: 120%;" value="저장" onclick="go_rep()">						
					</c:when>
					<c:otherwise>	<!-- 관리자 답변 후 표시 -->
						<label style="font-size: 130%;"><pre>${cvo.reply}</pre></label>	
					</c:otherwise>
				</c:choose>
			</div>
			</div>
			
			<div class="btn" >
					<input type="button" value="목록으로" 
							onClick="location.href='adminCustomerInquiryList'">
			</div>
	</form>
</article>

<%@ include file="../footer.jsp"%>