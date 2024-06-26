$(function(){
	$('.fnq-tcol').click(function(){
		$('.fnq-tcol2').slideToggle(200);
	});
});

$(document).ready(function(){
        $('.advertiseStandard, .standard, .premium').click(function(){
            var $this = $(this);
            if($this.hasClass('active')) {
                $this.css({'background-color': '#191919', 'color': 'white'}).removeClass('active');
            } else {
                $this.css({'background-color': '#ff153c', 'color': 'white'}).addClass('active').siblings().removeClass('active').css({'background-color': '#191919', 'color': 'white'});
            }
        });
});