<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../product/Theader.jsp" %>

<section>
	<article>
		<div class="costitle">
			<%@ include file="../customercenter/customercenter.jsp" %>
		</div>
		
		<div class="cosmenu_wrapper">
			<%@ include file="../customercenter/cosmenu_wrapper.jsp" %>
		</div>
		
		<br>
		
		<div class="search" style="background-color: rgba(255, 255, 255, 0.2); margin-left: 40px; width: 89%;">
			<!-- <div class="qes1">
				<input type="text"  name="searchingname" placeholder="검색어를 입력해주세요">
				<a href="twoving.do?command=loadingError&inquirylist=재생/오류" onClick=""><img src="images/search.png" width="60"></a>
			</div>
			<br><br> -->
			<div class="qes2" style="">
				<span style="font-weight:bold;">자주 묻는 질문</span>&nbsp;&nbsp;
				<a href="memberCustomerLogin?inquirylist=회원/로그인"><span>로그인이 안돼요</span></a> &nbsp;&nbsp; |  &nbsp;&nbsp;
				<a href="passTicket?inquirylist=이용권/결제"><span>이용권이 있는 계정이 무엇인지 찾고 싶어요</span></a> &nbsp;&nbsp; |  &nbsp;&nbsp;
				<a href="passTicket?inquirylist=재생/오류"><span>시리즈와 영화 콘텐츠 다운로드는 어떻게 하나요?</span></a>
			</div>
		</div>
		
		<div class="inquiryCategory">
			<a href="faq">전체</a> | &nbsp;&nbsp;&nbsp;&nbsp;
			<a href="memberCustomerLogin?inquirylist=회원/로그인">회원/로그인</a> | &nbsp;&nbsp;&nbsp;
			<a href="passTicket?inquirylist=이용권/결제">이용권/결제</a> | &nbsp;&nbsp;&nbsp;
			<a href="loadingError?inquirylist=재생/오류">재생/오류</a> | &nbsp;&nbsp;&nbsp;
			<a href="nonpay?inquirylist=해지/환불">해지/환불</a> | &nbsp;&nbsp;&nbsp;
			<a href="servicerun?inquirylist=서비스/이용">서비스 이용</a>
		</div>
		
		<table style="display: flex; flex-direction:column;">
			<c:forEach items="${memberCustomer}" var="mc" varStatus="loop">
				<tr class="fnq-trow" onClick="slideToggleFuc(${loop.index});" id="toggleClass" style="cursor:pointer;">
					<td class="fnq-tcol" style="color:gray; font-weight:bold; padding: 10px;">${mc.inquirylist}</td>
					<td class="fnq-tcol" style="color:gray; font-weight:bold; padding: 10px;">${mc.subject}</td>
					<td class="fnq-tcol"><img src="/images/down4.png" width="35" style="border-radius:50%;"></td>
					<%-- <td class="fnq-tcol">${faq.content}</td> --%>
				</tr>
				<tr class="faq-content" style="display:none;">
				 	<td class="faq-tcol" style="display:block; text-align:center;">${mc.subject}</td>
            		<td class="faq-content-tcol" colspan="3" style="display:block; text-align:center;"><pre>${mc.content}</pre></td>
       			 </tr>
			</c:forEach>
		</table>
		
		<jsp:include page="../paging/memberCustomerLoginPaging.jsp">
			<jsp:param value="memberCustomerLogin?inquirylist=회원/로그인" name="address"/>
		</jsp:include>
		
	</article>
</section>

<%@ include file="../product/Tfooter.jsp" %>