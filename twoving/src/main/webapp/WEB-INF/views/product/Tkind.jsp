<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="Theader.jsp" %>
<br>
<br>
<section>
<div class="sub_page">
		<article style="flex-direction: column;">		
			<h2 style="color:white; margin-left:55px;">${kind}</h2>
			<c:choose>
				<c:when test="${kind == '시리즈' }">
					<div id="genre" style="display:flex;">
					<c:forEach items="${Sgenre}" var="genre">
							<div class="genretag"><a href="genre?kind=${kind}&genre=${genre}">
							${genre}</a></div>					
					</c:forEach>
					</div>
					<h2 style="color:white; margin-left:55px;">이번주 TOP7</h2>  
					<div id="productproduct">
						<c:forEach items="${bestList}" var="bestList" varStatus="status">
							<div class="productproduct"><a href="Tdetail?pseq=${bestList.pseq}">
								${status.index+1}<img src="images/image2/${bestList.savefilename}"></a>
							</div>					
					</c:forEach>
					
					</div>
				</c:when>	
				<c:otherwise>
					<div id="genre" style="display:flex;">
					<c:forEach items="${Mgenre}" var="genre">
							<div class="genretag"><a href="genre?kind=${kind}&genre=${genre}">
							${genre}</a></div>					
					</c:forEach>
					</div>
					<h2 style="color:white; margin-left:55px;">이번주 TOP7</h2>
					<div id="productproduct">
						<c:forEach items="${newList2}" var="newList" varStatus="status">
							<div class="productproduct"><a href="Tdetail?pseq=${newList.pseq}">
								${status.index+1}<img src="images/image2/${newList.savefilename}"></a>
							</div>					
					</c:forEach>					
					</div>
				</c:otherwise>
			</c:choose>
			<br>
			<br>
			<br>
			<br>
			<br>	
			<div class="kindproducts">
				<c:forEach items="${kindProduct}" var="productVO">
					<div class="kinditem"><a href="Tdetail?pseq=${productVO.pseq}">
						<img src="images/image2/${productVO.savefilename}"></a>
					</div>
				</c:forEach>
			</div>
		</article>
	</div>
</section>
<%@ include file="Tfooter.jsp" %>