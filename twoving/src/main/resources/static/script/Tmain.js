	var num = 0;	
 		window.onload = function(){changeCss(num+1);};

 	var ing = window.setInterval(function(){
			for( var i=1; i<=6; i++){ 
			
             document.getElementById('btn' + i).style.background = 'skyblue';
             
            }          
          	document.getElementById('btn' + (num+1)).style.background = 'white';  
            
            num++;
            if(num>5) num = 0;
                  
            var dist =  - 1890*num;
            document.getElementById("mainmain").style.left = dist + 'px' ;
            
        }, 1000 );



function moveLeft() {
           
            if(num == 0 ) return; 
                       
            num--;
            
            var dist =  - 1890 * num;
            document.getElementById("mainmain").style.left = dist + 'px';
            changeCss(num);          
        }
        
        
function moveRight() {
           
            if(num==5) return;
           
           
          	num++ ;
          	
          	var dist = -1890* num;
           document.getElementById("mainmain").style.left = dist + 'px';
           changeCss(num);
           
           clearInterval(ing);
           
           ing = window.setInterval(function() {
        	for (var i = 1; i <= 6; i++) {
            document.getElementById('btn' + i).style.background = 'skyblue';
        	}
        	document.getElementById('btn' + (num + 1)).style.background = 'white';
				num++;
				
	        if (num > 5) num = 0;
	        
	        var dist = -1890*num;
	         document.getElementById("mainmain").style.left= dist+'px' ;
			}, 1000);
	   }
        
        
function changeCss(num) {
            for( var i=1; i<=6; i++){
            document.getElementById('btn' + i).style.background = 'skyblue';
                
            }
            document.getElementById('btn' + (num+1)).style.background = 'white';           
        }
        


function go_search(searchList){
	var url = "/searchList";
	document.form.action = url;
	document.form.submit(); 	
}

  
function count(){
	window.alert("시청횟수가 1증가하였습니다.");	
}


$(function(){
   $('.mypage').click(function(){
                $('.profileclick').slideToggle(300);
            $(this).toggleClass('active');
         });
         });  		
		
		
        
$(function(){
   $('#d').click(function(){
                $('.share').slideToggle(0);
            $(this).toggleClass('active');
         });
         });
         
         
$(function(){
	$(".kjy").hover(
                function(){
                    $(this).css({
                        "background" : "red",
                        "color" : "white",
                        
                    });
                }, 
                function(){
                    $(this).css({
                        "background" : "#282828",
                        "color" : "white",
                        
                    });
                }
             )            
         });
         
         
         
         
         
            


        
        