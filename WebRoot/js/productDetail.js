$(function(){
	$("#leftpNav h4").mouseover(function(){
	 	$("#leftpNav h4").css("cursor","pointer");	
		$("#leftpNav ul").show();
	});
	$("#leftpNav").mouseleave(function(){
		$("#leftpNav ul").hide();
	});
	$(".btnCount").click(function(){
		var count=$("#count").val();
		if($(this).val()=="+"){
			$("#count").val(eval(count+"+"+1));
		}
		if($(this).val()=="-"){
			$("#count").val(eval(count+"-"+1));
			if($("#count").val()<0){
				$("#count").val(0);
			}
		}
	});
});

