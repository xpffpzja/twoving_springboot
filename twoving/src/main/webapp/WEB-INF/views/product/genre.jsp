<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="Theader.jsp" %>
<br>
<br>
<section>
	<div class="sub_page">
		<article style="flex-direction: column;">		
			<div style="display:flex; margin-left:55px;"><h2 style="color:white;">${kind}</h2> <h2 style="color:white;">&nbsp;-&nbsp;${genre}</h2></div>
			<div class="genreproducts">
				<c:choose>
					<c:when test="${kind == '시리즈' }">
						<c:forEach items="${sProduct}" var="sProduct">
							<div class="genreitem"><a href="Tdetail?pseq=${sProduct.pseq}">
								<img src="images/image2/${sProduct.savefilename}"></a>
							</div>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<c:forEach items="${mProduct}" var="mProduct">
							<div class="genreitem"><a href="Tdetail?pseq=${mProduct.pseq}">
								<img src="images/image2/${mProduct.savefilename}"></a>
							</div>
						</c:forEach>	
					</c:otherwise>
			</c:choose>
			</div>
		</article>
	</div>
</section>
<%@ include file="Tfooter.jsp" %>