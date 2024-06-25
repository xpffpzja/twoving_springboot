<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="../sub_menu.jsp" %>

<link rel="stylesheet" href="/admin/css/notice.css" />

<article>
	<form name="noticeWriteFrm" method="post"  enctype="multipart/form-data">
			<h1 style="border-bottom: 2px solid black;"> FAQ 상세 보기 </h1>
			<div class="field" style="border-bottom: 1px dotted black;">
					<label>분류</label><div>${faqVO.inquirylist}</div>
			</div>
			<div class="field"style="border-bottom: 1px dotted black;" >
					<label>제목</label><div>${faqVO.subject}</div>
			</div>
			<div class="field" style="border-bottom: 1px dotted black;">
					<label>내용</label><div><pre>${faqVO.content}</pre></div>
			</div>
			<div class="btn" >
					<input type="button" value="수정하기" onClick="go_mod3('${faqVO.qseq}')">
					<input type="button" value="삭제하기" onClick="deleteFaq('${faqVO.qseq}')">       
					<input type="button" value="목록으로" 
							onClick="location.href='adminFaqList'">
			</div>
	</form>
</article>

<%@ include file="../footer.jsp" %>