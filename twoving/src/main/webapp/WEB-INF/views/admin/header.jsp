<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <link rel="stylesheet" href="admin/css/adminLogin.css" /> -->
<link rel="stylesheet" href="/admin/css/adminList.css" />
<script src="/admin/script/admin.js"></script>
<script src="/admin/script/mypage.js"></script>

<!-- Ajax -->

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('#myButton').click(function (){
			var formselect = $("#fileupForm")[0];  // 지목된 폼을 변수에 저장
			var formdata = new FormData(formselect); //전송용 폼객체에 폼과 안의 데이터(이미지)를 저장
			$.ajax({ //
				url : "<%=request.getContextPath()%>/fileup",
				type : "POST",
				enctype : "multipart/form-data",
				async : false,
				data : formdata,
				timeout : 10000,
				contentType : false,
				processData : false,

				success : function(data){ // controller 에서 리턴된 해시맵이 data로 전달됩니다.
					if( data.STATUS == 1 ){
						//화면출력
						$("#filename").append("<div>"+data.SAVEFILENAME+"</div>")
						//전송
						$("#image").val(data.IMAGE);
						$("#savefilename").val(data.SAVEFILENAME);
						$("#filename").append("<img src='images/" + data.SAVEFILENAME + "'height='150' /> ");
					}
				},
				error: function(xhr, status, error) {
					console.error(xhr.responseText);
					console.error("AJAX 오류 발생: ", status, error);
					alert("파일 업로드에 실패했습니다. 관리자에게 문의하세요.");
				}
			});
		});
	});
</script>

<!-- Ajax -->

</head>
<body>

<div id="wrap">
	<header>	
			<div id="logo">
					<a href="adminLogout">
						<img src="admin/images/logout.png" style="width:50px;">
					</a>
					<a  href="admin" style="color:black; margin-right: 410px; margin-top: 10px;font-size: 150%;" >TWOVING admin</a>
					<!-- <input class="btn" type="button" value="로그아웃"  style="font-size: 120%;" 
							onClick="location.href='twoving.do?command=adminLogout'">	 -->
			</div>
				
	</header>
	
	
	
	
	