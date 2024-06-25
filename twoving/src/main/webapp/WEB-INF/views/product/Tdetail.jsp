<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="Theader.jsp" %>
<br>
<br>
<br>
<section>
	<div class="sub_page">		
		<article>
			<form  name="form" id="form">
				<div id="background" 
				style="background-color : #282828;"></div>
				<div id="container">
					<div id="containerA">
						<div id="title">${productVO.title}</div>
						<div id="tagtag" style="margin:0px; padding:0px;">
							<div id="tag" >${productVO.age} &nbsp; ${productVO.year} &nbsp;${productVO.genre} &nbsp;${productVO.time}</div>
							<div class="share">
								<div class="shareclick"><img src="images/snsicons.png" ></div>
							</div>					
						</div>
						<br><br>
						<div id="linkicon">
							<div class="a" id="b"><a href="Tdetail?pseq=${productVO.pseq}&action=view"  onClick="count();" >시청하기</a></div>
							<c:choose>
							<c:when test="${ccc.isEmpty()}">
							<div class="a" id="c"><a href="steamedInsert?pseq=${productVO.pseq}&result=Y"><img src = images/emptyheart.png style="width:55px; height:55px;" id="heart"></a><br>찜</div>
							</c:when>
							<c:otherwise>
							<div class="a" id="c"><a href="steamedDelete?pseq=${productVO.pseq}&result=N"><img src = images/redheart.png style="width:55px; height:55px;" id="heart"></a><br>찜</div>
							</c:otherwise>
							</c:choose>
							<%-- <input type="hidden" name="pseq" value="${productVO.pseq}"/> --%>
							
							<div class="a" id="d"><a href="#" ><img src = images/공유.png style="width:55px; height:55px;"></a><br>공유</div>
						</div>
						<br>
						
								
						<div id="content" >${productVO.content}</div>
					</div>
						
					<div id="containerB">							
						<div ><img src="images/image2/${productVO.savefilename}"></div>
					</div>								
				</div>														
			</form>	
		</article>
	</div>	
</section>
<%@ include file="Tfooter.jsp" %>