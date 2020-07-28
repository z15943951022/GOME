$(window).scroll(function(){
					if($(this).scrollTop()>100){
						$("#hidenav").fadeIn();
					}else{
						$("#hidenav").fadeOut();
					}
				});