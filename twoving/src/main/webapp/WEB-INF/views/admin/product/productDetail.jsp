<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@ include file="/admin/header.jsp" %>
<%@ include file="/admin/sub_menu.jsp" %>
<article>
	<form>
		<h1> 시리즈/영화 상세 보기 </h1>
		<div class="field" style="border-top:2px solid black;">
			<label>상품분류</label>
			<div>
				<c:if test="${productVO.kind eq '0'}">시리즈</c:if>
				<c:if test="${productVO.kind eq '1'}">영화</c:if>
			</div>
		</div>
		
		<div class="field" style="border-top:1px dotted black;">
			<label>장르</label><div>${productVO.genre}</div>
		</div>
		<div class="field" style="border-top:1px dotted black;">
			<label>사용유무</label>
			<div>
				<c:if test="${productVO.useyn eq 'Y'}"><span style="font-weight: bold; color:blue;">서비스 사용중</span></c:if>
				<c:if test="${productVO.useyn eq 'N'}"><span style="font-weight: bold; color:red;">서비스 사용안함</span></c:if>
			</div>
		</div>
		<div class="field" style="border-top:1px dotted black;">
			<label>New 유무</label>
			<div>
				<c:if test="${productVO.newyn eq 'Y'}"><span style="font-weight: bold; color:green;">New</span></c:if>
				<c:if test="${productVO.newyn eq 'N'}"><span style="font-weight: bold; color:black;">일반</span></c:if>
			</div>
		</div>
		<div class="field" style="border-top:1px dotted black;">
			<label>조회수</label>
			<div>
				<%-- <c:if test="${productVO.bestyn eq 'Y'}"><span style="font-weight: bold; color:magenta;">Best</span></c:if>
				<c:if test="${productVO.bestyn eq 'N'}"><span style="font-weight: bold; color:black;">일반</span></c:if> --%>
			${productVO.count}
			</div>
		</div>
		<div class="field" style="border-top:1px dotted black;">
			<label>관람 나이 제한</label><div>${productVO.age}</div>
		</div>
		<div class="field" style="border-top:1px dotted black;">
			<label>년도</label><div>${productVO.year}</div>
		</div>
		<div class="field" style="border-top:1px dotted black;">
			<label>영상시간</label><div>${productVO.time}</div>
		</div>
		<div class="field" style="border-top:1px dotted black;">
			<label>시리즈/영화명</label><div>${productVO.title}</div>
		</div>
		<div class="field" style="border-top:1px dotted black;">
			<label>상세설명</label>
			<div style="height:200px;">
				<!-- 상세설명 부분에 pre 태그를 사용하여 줄바꿈 및 공백 유지 -->
				<pre style="white-space: pre-wrap;">${productVO.content}</pre>
			</div>
		</div>
		
		<!-- C:\Users\hi\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\SmallProject\product_images -->
		<div class="field" style="border-top:1px dotted black;">
			<label>상품이미지</label>
			<div>
				<img src="image2/${productVO.savefilename}" width="300">
			</div>
		</div>
		<div class="field" style="border-top:1px dotted black; border-bottom:2px solid black;">
			<label>상품이미지(디테일)</label>
			<div>
				<img src="image2/${productVO.savefilename2}" width="300">
			</div>
		</div>
		<div class="btn">
			<input type="button" value="수정" onClick="go_mod('${productVO.pseq}')">
			<input type="button" value="삭제" onClick="deleteProduct('${productVO.pseq}')">
			<input type="button" value="목록" 
			onClick="location.href='twoving.do?command=adminProductList'">
		</div>
	</form>
</article>

<%@ include file="/admin/footer.jsp" %>