<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/Theader.jsp" %>

<section>
	<article>
		<div class="costitle">
			<%@ include file="customercenter.jsp" %>
		</div>
		<div class="cosmenu_wrapper">
			<%@ include file="cosmenu_wrapper.jsp" %>
		</div>
		
		<div class="detail_size">
				<h4 style="color: white; font-weight: bold; font-size: 150%; margin-top: -5px;">${noticeVO.title}</h4>
				<pre style="font-size: 120%; color: gray; font-family: Noto Sans KR, -apple-system, BlinkMacSystemFont, Roboto, Segoe UI, Oxygen, Ubuntu, Cantarell, Open Sans, Helvetica Neue, sans-serif;">${noticeVO.content}</pre>
			
			
			<%-- <div class="detail_page">
				<table>
					<tr>
						<td style="color:gray; font-weight: bold;">다음</td>
						<td>
							${noticeVO.title}
							<c:forEach items="${noticeVO}" var="notice">
									${notice.title}
							</c:forEach>
						</td>
						<td><fmt:formatDate value="${noticeVO.indate}"/></td>
					</tr>
				</table>		
		     </div> --%>
		
			<div class="detail-button" style="margin-top: 30px;">
				<input type="button" value="목록으로" onClick="location.href='notice'" size="150">
			</div>
		</div>
		
		</article>
	</div>
</section>

<%@ include file="../main/Tfooter.jsp" %>