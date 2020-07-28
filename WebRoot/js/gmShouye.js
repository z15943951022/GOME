$(function(){
	//轮播指定时对应图片
	$("#midNav>ul>li").mouseover(function(){
		$(this).css("background-color","red");
		$(this).siblings().css("background-color","rgba(0,0,0,0.3)");
		$("#midNav>div").css("background-image","url(img/top0"+$(this).val()+".jpg)");
	});
	//购物车隐藏
	$("#searchNav td:last-of-type").mouseover(function(){
		$(this).children("div").show();
		$("#searchNav td:last-of-type div").css("box-shadow","0px 0px 10px gainsboro");
		$("#searchNav td:last-of-type div:first-of-type").css("background-color","white");
		$("#buySanjiao").html("▲");
	});
	$("#searchNav td:last-of-type").mouseout(function(){
		$(this).children("div").hide();
		$("#searchNav td:last-of-type div").css("box-shadow","none");
		$("#buySanjiao").html("▼");
	});
});
//图片轮播
var count=0;
function lunbo(){
	count++;
	var urls="url(img/top0"+count+".jpg)";
	$("#midNav>ul>li:nth-of-type("+count+")").css("background-color","red");
	$("#midNav>ul>li:nth-of-type("+count+")").siblings().css("background-color","rgba(0,0,0,0.3)");
	$("#midNav>div").css("background-image",urls);
	if(count==8){
		count=0;
	}
}
//页面加载时启动
setInterval("lunbo();",5000);
