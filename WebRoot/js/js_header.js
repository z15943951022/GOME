				$(function(){
				$("#qiye").mouseover(function(){
					$("#nav_caigou").slideDown(100);
					$("#nav_caigou").addClass("hid");
					$(this).css("background-color","white")
					.css("border","1px solid grey")
					.css("border-bottom","1px solid white");
				});
				$("#qiye").mouseleave(function(){
					$("#nav_caigou").slideUp(100);
					$(this).css("background-color","#f8f8f8")
					.css("border","none");
				});
				
				$("#daohang").mouseover(function(){
					$("#navv").slideDown(100);
					$(this).css("background-color","white")
					.css("border","1px solid grey")
					.css("border-bottom","1px solid white");
				});
				$("#daohang").mouseleave(function(){
					$("#navv").slideUp(100);
					$(this).css("background-color","#f8f8f8")
					.css("border","none");
				});
				
				$("#bug").mouseover(function(){
					$("#phoneerwei").slideDown(100);
					$(this).css("background-color","white")
					.css("border","1px solid grey")
					.css("border-bottom","1px solid white");
				});
				$("#bug").mouseleave(function(){
					$("#phoneerwei").slideUp(100);
					$(this).css("background-color","#f8f8f8")
					.css("border","none");
				});
				$("#head_nav>ul:first>li:eq(1)").mouseover(function(){
					$("#myinfo").slideDown(100);
					$(this).css("background-color","white")
					.css("border","1px solid grey")
					.css("border-bottom","1px solid white");
				});
				$("#head_nav>ul:first>li:eq(1)").mouseleave(function(){
					$("#myinfo").slideUp(100);
					$(this).css("background-color","#f8f8f8")
					.css("border","none");	
				});
				$("#head_nav>ul:last>li:eq(1)").mouseover(function(){
					$("#copyinfo").slideDown(100);
					$(this).css("background-color","white")
					.css("border","1px solid grey")
					.css("border-bottom","1px solid white");
				});
				$("#head_nav>ul:last>li:eq(1)").mouseleave(function(){
					$("#copyinfo").slideUp(100);
					$(this).css("background-color","#f8f8f8")
					.css("border","none");
				});
				
			});