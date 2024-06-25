<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="Theader.jsp" %>
<br>
<br>
<section>
<div class="sub_page">
		<article style="flex-direction: column;">		
			<h2 style="color:white;">검색결과</h2>
			<br>
			<c:choose>					
					<c:when test="${searchList.isEmpty()}">
						<div id="boxbox">					
							<div id="asdf"><img src ="images/느낌표1.png"></div>
							<br>
							<div id="result">"${key}" 검색 결과가 없습니다.</div>
							<br>
							<div id="result1">요즘 인기있는 검색어를 추천해 드릴께요.</div>
							<br><br>
							<div class="qwer"><a href="Tdetail?pseq=34">유퀴즈 온더 블럭!</a></div>
							<br>
							<div class="qwer"><a href="Tdetail?pseq=44">여고추리반</a></div>
							<br>
							<div class="qwer"><a href="Tdetail?pseq=32">놀라운토요일</a></div>
							<br>
							<div class="qwer"><a href="Tdetail?pseq=33">선재업고튀어</a></div>
							<br>
							<div class="qwer"><a href="Tdetail?pseq=36">Player2</a></div>
							<br>
							<div class="qwer"><a href="Tdetail?pseq=45">지락이의 뛰뛰빵빵</a></div>
							<br>
						</div>
					</c:when>
					<c:otherwise>	
						<div class="kindproducts">
							<c:forEach items="${searchList}" var="productVO">
								<div class="kinditem"><a href="Tdetail?pseq=${productVO.pseq}">
									<img src="images/image2/${productVO.savefilename}"></a>
								</div>
							</c:forEach>
						</div>
					</c:otherwise>
				</c:choose>		
		</article>
	</div>
</section>





<%@ include file="Tfooter.jsp" %>