function updateDefuseCheck(productname){
	if(productname === '광고형 스탠다드'){
		var url="twoving.do?command=updateDefuseCheck&productname=" + productname;
		var opt="toolbar=no, menubar=no, resizable=no, width=600, height=800, scrollbars=yes";
		
		window.open(url, "updateDefuseCheck", opt);
	}else if(productname === '베이직'){
		var url="twoving.do?command=updateDefuseCheck&productname=" + productname;
		var opt="toolbar=no, menubar=no, resizable=no, width=600, height=800, scrollbars=yes";
		
		window.open(url, "updateDefuseCheck", opt);
	}else if(productname === '스탠다드'){
		var url="twoving.do?command=updateDefuseCheck&productname=" + productname;
		var opt="toolbar=no, menubar=no, resizable=no, width=600, height=800, scrollbars=yes";
		
		window.open(url, "updateDefuseCheck", opt);
	}else{
		var url="twoving.do?command=updateDefuseCheck&productname=" + productname;
		var opt="toolbar=no, menubar=no, resizable=no, width=600, height=800, scrollbars=yes";
		
		window.open(url, "updateDefuseCheck", opt);
	}
}

function updateDefuseCheck2(){
	   var url="twoving.do?command=insertPassTicketPopup";
		var opt="toolbar=no, menubar=no, resizable=no, width=600, height=800, scrollbars=yes";
		
		window.open(url, "updateDefuseCheck2", opt);
}

function allPassTicketView(productname){
	if(productname === '광고형 스탠다드'){
		var url="twoving.do?command=allPassTicketView&productname=" + productname;
		var opt="toolbar=no, menubar=no, resizable=no, width=600, height=800, scrollbars=yes";
		
		window.open(url, "allPassTicketView", opt);
	}else if(productname === '베이직'){
		var url="twoving.do?command=allPassTicketView&productname=" + productname;
		var opt="toolbar=no, menubar=no, resizable=no, width=600, height=800, scrollbars=yes";
		
		window.open(url, "allPassTicketView", opt);
	}else if(productname === '스탠다드'){
		var url="twoving.do?command=allPassTicketView&productname=" + productname;
		var opt="toolbar=no, menubar=no, resizable=no, width=600, height=800, scrollbars=yes";
		
		window.open(url, "allPassTicketView", opt);
	}else{
		var url="twoving.do?command=allPassTicketView&productname=" + productname;
		var opt="toolbar=no, menubar=no, resizable=no, width=600, height=800, scrollbars=yes";
		
		window.open(url, "allPassTicketView", opt);
	}
}

function hoverEffect(element) {
     element.style.backgroundColor = "red";
     element.style.color = "white";
     
}
    
function resetColor(element) {
     element.style.backgroundColor = "gray";
     element.style.color = "white";
     
}

function colorRedOrGray(productname, paymentprice, ptseq) {
	
	document.getElementById("productname").value = productname;
	document.getElementById("paymentprice").value = paymentprice;
	document.getElementById("ptseq").value = ptseq;
	
    // 현재 클릭된 div 요소의 배경색을 확인하여 색상을 변경합니다.
    var backgroundColor = element.style.backgroundColor;
    if (backgroundColor === "#ff153c") { // 배경색이 빨간색일 경우
        element.style.backgroundColor = "#191919"; // 회색으로 변경
        element.style.color = "white"; // 글자색을 흰색으로 변경
    } else { // 그 외의 경우 (회색일 경우)
        element.style.backgroundColor = "#ff153c"; // 빨간색으로 변경
        element.style.color = "white"; // 글자색을 흰색으로 변경
    }
}
 

function insertAndUpdatePassTicket(){
	var ans = window.confirm('정말로 이 이용권을 선택하시겠습니까?');
	
	if(ans == 1){
		var url = "twoving.do?command=UpdatePassTicket1";
		document.passTicketForm.action = url;
		document.passTicketForm.submit();
	}
}

function insertAndUpdatePassTicket2(){
	var ans = window.confirm('정말로 이 이용권을 선택하시겠습니까?');
	
	if(ans == 1){
		var url = "twoving.do?command=insertPassTicket2";
		document.passTicketForm.action = url;
		document.passTicketForm.submit();
	}
}



   