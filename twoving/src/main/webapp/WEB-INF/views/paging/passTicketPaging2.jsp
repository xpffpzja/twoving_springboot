<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css" href="/css/Theader.css">
<div class="rowpage" style="margin:0 auto;"> <!-- 페이지의 시작 -->
    <div class="colpage">
        <c:url var="action" value="${param.address}"></c:url> <!-- 파라미터는 el로 전달될때는 반드시 param 을 붙이고 적어야 한다!!!! -->
        <div style="font-size:120%; font-weight:bold; " >
            <c:if test="${paging.prev}">
                <a href = "${action}?page=${paging.beginPage-1}" >이전</a>&nbsp;
            </c:if>
            <c:forEach begin="${paging.beginPage}" end="${paging.endPage}" var="index">
                <c:if test="${paging.page == index}">
                    <span style = "background-color:gray; border-radius:5px; width:10; font-weight: bold;"></span>
                    <span style="color:red; font-size: 110%;">&nbsp;${index}&nbsp;</span>
                </c:if>
                <c:if test="${paging.page != index}">
                    <a href="${action}?page=${index}" style="color:white; font-size: 100%;">&nbsp;${index}&nbsp;</a>
                </c:if>
            </c:forEach>
            <c:if test="${paging.next}">
                <a href = "${action}?page=${paging.endPage+1}">다음</a>
            </c:if>
        </div>
    </div>

    <br><br><br><br><br>
    <div style="background-color: #353535; width: 90%; height: 230px;  border-radius: 5px; padding-top: 20px; margin: 0 auto; margin-top: 20px; margin-bottom: 20px;">
        <div style=" text-align: center;">알아두세요!<br>
            - 정기결제란? 1개월 또는 1년 단위로 자동 결제가 이루어지는 서비스를 말합니다.<br>
            - 정기결제는 언제든 해지 및 결제수단 변경이 가능하며, 결제수단 변경은 모든 결제수단으로 변경 가능합니다. (휴대폰 결제로는 변경 불가)<br>
            - 정기 결제수단을 변경하시면 다음 회차 결제일에 변경하신 결제수단으로 정기결제가 진행됩니다.<br>
            - 보조 결제수단을 등록하신 경우, 기본 결제수단에 문제가 있을 때 해당 월에 한해 보조 결제수단으로 정기결제가 진행될 수 있습니다.<br>
            - 구매한 캐시는 마지막 사용일로부터 5년간 유효합니다. (단, 이벤트 캐시는 지급시 별도 표기일까지 이용 가능합니다.)<br>
            - 결제 관련 문의는 1:1 게시판 문의 또는 대표메일 (tving@cj.net)로 문의하시기 바랍니다.<br>
        </div></div>

</div> <!-- 페이지의 끝 -->
