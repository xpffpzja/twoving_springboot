<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="header.jsp" %>
<title>이용권 선택</title>

<div class="popup" style="display:flex; flex-direction: column; margin-top: 3200px;">
	<div class="popupheader">
		<h1 style="color: white; margin: 0 auto; margin-top: 100px; margin-bottom: 30px;">변경할 이용권을 선택하세요</h1>
	</div>
	<div style="display:flex; flex-direction: column;">
		<form method="post" name="passTicketForm">
			<div class="sub_contents" style="display:flex; flex-direction: column;">
			<section style="display:flex;">
			<div class="passTicketSelect" style="width: 100%; display:flex; justify-content: space-between;">
					<div class="advertiseStandard" onClick="colorRedOrGray('광고형 스탠다드', '5,500원', 1)" onMouseOver="" onMouseOut="" style="border: 1px solid #4d4d4d; width: 43%; color:white; border-radius:15px 15px 15px 15px; padding: 40px; margin-right: 10px; background-color:#ff153c; position: relative; cursor:pointer;">
							<p style="font-weight: bold; color:white; text-align:center;">광고형<br> 스탠다드</p>
						</div>
						<div class="standard" onClick="colorRedOrGray('스탠다드', '13,900원', 3)" onMouseOver="" onMouseOut="" style="border: 1px solid #4d4d4d; width: 30%; color:white; border-radius:15px 15px 15px 15px; padding: 40px; margin-right: 10px; background-color: #191919; cursor:pointer;">
							<p style="font-weight: bold; color:white; text-align:center;">스탠다드</p>
						</div>
						<div class="premium" onClick="colorRedOrGray('프리미엄', '17,000원', 4)" onMouseOver="" onMouseOut="" style="border: 1px solid #4d4d4d; width: 30%; color:white; border-radius:15px 15px 15px 15px; padding: 40px; background-color:#191919; cursor:pointer;">
							<p style="font-weight: bold; color:white; text-align:center;">프리미엄</p>
						</div>
						<input type="hidden" id="paymentprice" name="paymentprice" value=''/>
						<input type="hidden" id="productname" name="productname" value="">
						<input type="hidden" id="subscribeyn" name="subscribeyn" value="Y">
						<input type="hidden" id="ptseq" name="ptseq" value="">
			</div>
		</section>
	   </div>
		<div style="display:flex; flex-direction: column;">
			<table class="updateDefuseTable" style="display: flex; flex-direction: column;">
					<tr>
						<th>월간요금</th>
					</tr>
					<tr>
						<td style="">
							5,500원	
						</td>
						<td>
							13,500원
						</td>
						<td>
							17,000원
						</td>
					</tr>
					<tr>
						<th>동시시청</th>
					</tr>
					<tr>
						<td style="">2대</td>
						<td>2대</td>
						<td>4대</td>
					</tr>
					<tr>
						<th>프로필</th>
					</tr>
					<tr>
						<td style="">4개</td>
						<td>4개</td>
						<td>4개</td>
				</tr>
				<tr>
					<th>화질</th>
				</tr>
				<tr>
					<td style="">1080p</td>
					<td style="margin-left:60px;">1080p</td>
					<td>1080p(4K 일부)</td>
				</tr>
				<tr>
					<th>콘텐츠 다운로드</th>
				</tr>
				<tr>
					<td style="">15회</td>
					<td>300회</td>
					<td>400회</td>
				</tr>
				<tr>
					<th>모바일,태블릿,PC,TV지원</th>
				</tr>
				<tr>
					<td style=""><img src="images/checks.jpg" style="width:20px; border-radius:50%;"></td>
					<td><img src="images/checks.jpg" style="width:20px; border-radius:50%;"></td>
					<td><img src="images/checks.jpg" style="width:20px; border-radius:50%;"></td>
				</tr>
				<tr>
					<th>광고</th>
				</tr>
				<tr>
					<td style=""><img src="images/checks.jpg" style="width:20px; border-radius:50%;"></td>
					<td><img src="images/x.png" style="width:30px; border-radius:50%;"></td>
					<td><img src="images/x.png" style="width:30px; border-radius:50%;"></td>
				</tr>
				
					<tr>
						<th>월간요금</th>
					</tr>
					<tr>
						<td style="">
							5,500원	
						</td>
						<td>
							13,500원
						</td>
						<td>
							17,000원
						</td>
					</tr>
					<tr>
						<th>동시시청</th>
					</tr>
					<tr>
						<td style="">2대</td>
						<td>2대</td>
						<td>4대</td>
					</tr>
					<tr>
						<th>프로필</th>
					</tr>
					<tr>
						<td style="">4개</td>
						<td>4개</td>
						<td>4개</td>
				</tr>
				<tr>
					<th>화질</th>
				</tr>
				<tr>
					<td style="">1080p</td>
					<td style="margin-left:60px;">1080p</td>
					<td>1080p(4K 일부)</td>
				</tr>
				<tr>
					<th>콘텐츠 다운로드</th>
				</tr>
				<tr>
					<td style="">15회</td>
					<td>300회</td>
					<td>400회</td>
				</tr>
				<tr>
					<th>모바일,태블릿,PC,TV지원</th>
				</tr>
				<tr>
					<td style=""><img src="images/checks.jpg" style="width:20px; border-radius:50%;"></td>
					<td><img src="images/checks.jpg" style="width:20px; border-radius:50%;"></td>
					<td><img src="images/checks.jpg" style="width:20px; border-radius:50%;"></td>
				</tr>
				<tr>
					<th>광고</th>
				</tr>
				<tr>
					<td style=""><img src="images/checks.jpg" style="width:20px; border-radius:50%;"></td>
					<td><img src="images/x.png" style="width:30px; border-radius:50%;"></td>
					<td><img src="images/x.png" style="width:30px; border-radius:50%;"></td>
				</tr>
				
					<tr>
						<th>월간요금</th>
					</tr>
					<tr>
						<td>
							5,500원
						</td>
						<td style="">
							13,500원
						</td>
						<td>
							17,000원
						</td>
					</tr>
					<tr>
						<th>동시시청</th>
					</tr>
					<tr>
						<td>2대</td>
						<td style="">2대</td>
						<td>4대</td>
					</tr>
					<tr>
						<th>프로필</th>
					</tr>
					<tr>
						<td>4개</td>
						<td style="">4개</td>
						<td>4개</td>
				</tr>
				<tr>
					<th>화질</th>
				</tr>
				<tr>
					<td>1080p</td>
					<td style="margin-left:60px;">1080p</td>
					<td>1080p(4K 일부)</td>
				</tr>
				<tr>
					<th>콘텐츠 다운로드</th>
				</tr>
				<tr>
					<td>15회</td>
					<td style="">300회</td>
					<td>400회</td>
				</tr>
				<tr>
					<th>모바일,태블릿,PC,TV지원</th>
				</tr>
				<tr>
					<td><img src="images/checks.jpg" style="width:20px; border-radius:50%;"></td>
					<td style=""><img src="images/checks.jpg" style="width:20px; border-radius:50%;"></td>
					<td><img src="images/checks.jpg" style="width:20px; border-radius:50%;"></td>
				</tr>
				<tr>
					<th>광고</th>
				</tr>
				<tr>
					<td><img src="images/checks.jpg" style="width:20px; border-radius:50%;"></td>
					<td style=""><img src="images/x.png" style="width:30px; border-radius:50%;"></td>
					<td><img src="images/x.png" style="width:30px; border-radius:50%;"></td>
				</tr>
				<tr>
						<th>월간요금</th>
					</tr>
					<tr>
						<td>
							5,500원
						</td>
						<td>
							13,500원
						</td>
						<td style="">
							17,000원
						</td>
					</tr>
					<tr>
						<th>동시시청</th>
					</tr>
					<tr>
						<td>2대</td>
						<td>2대</td>
						<td style="">4대</td>
					</tr>
					<tr>
						<th>프로필</th>
					</tr>
					<tr>
						<td>4개</td>
						<td>4개</td>
						<td style="">4개</td>
				</tr>
				<tr>
					<th>화질</th>
				</tr>
				<tr>
					<td>1080p</td>
					<td style="margin-left:60px;">1080p</td>
					<td style="">1080p(4K 일부)</td>
				</tr>
				<tr>
					<th>콘텐츠 다운로드</th>
				</tr>
				<tr>
					<td>15회</td>
					<td>300회</td>
					<td style="">400회</td>
				</tr>
				<tr>
					<th>모바일,태블릿,PC,TV지원</th>
				</tr>
				<tr>
					<td><img src="images/checks.jpg" style="width:20px; border-radius:50%;"></td>
					<td><img src="images/checks.jpg" style="width:20px; border-radius:50%;"></td>
					<td style=""><img src="images/checks.jpg" style="width:20px; border-radius:50%;"></td>
				</tr>
				<tr>
					<th>광고</th>
				</tr>
				<tr>
					<td><img src="images/checks.jpg" style="width:20px; border-radius:50%;"></td>
					<td><img src="images/x.png" style="width:30px; border-radius:50%;"></td>
					<td style=""><img src="images/x.png" style="width:30px; border-radius:50%;"></td>
				</tr>
			</table>
		</div>
		<div class="updatePassTicketBtn" style="margin-top: 15px;">
			<input type="button" onClick="insertAndUpdatePassTicket2();" value="선택하기" style="width:100%; height: 50px; background-color:red; color:white; font-weight:bold; border-radius: 15px 15px 15px 15px; cursor:pointer;">
		</div>
		</form>
	</div>
</div>