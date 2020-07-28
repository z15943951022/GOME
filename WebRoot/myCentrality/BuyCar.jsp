<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/reset.css"/>
	<link rel="stylesheet" type="text/css" href="myCentrality/css/page_buycar.css"/>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
			<script type="text/javascript" src="js/jquery-1.12.4.js" ></script>
		<script>
			$(function(){
				find();
			/* //Ajax */
			$("#aaa").click(function deletea(){
					var data="opt=delNews&buycarid=3";
					$.post("BuyCarServlet",data,function(rel){
						if(rel>0){
							alert("删除成功");
						}else{
							alert("删除失败");
						}
						
					},"text");
					return false;
				});
			});
			
			/* //加 */
			function addCount(buyCarId){
				var data="opt=addCount";
				data+="&buyCarId="+buyCarId;
				$.post("BuyCarServlet",data,function(dataRel){
					//alert(dataRel);
					if(dataRel){
						
						find();
					}else{
						return;
					}
				},"text");
			};
			/* //减 */
			function  minusCount(buyCarId,count){
				var data="opt=minusCount";
				data+="&buyCarId="+buyCarId;
				if(count>1){
					$.post("BuyCarServlet",data,function(dataRel){
						//alert(dataRel);
					if(dataRel){
						find();
					}else{
						return;
					}
					},"text");
				}
			};
			 /* 获得总计 */
			 function getTotal(){
			 	var data="opt=getTotal";
			 	/* 被选中的数组对象 */
			 	var checked=$("input[name='buyCarId']:checked");
			 	for(var i=0;i<checked.length;i++){
			 		data+="&buyCarId="+checked[i].value;
			 	}
			 	$.post("BuyCarServlet",data,function(dataRel){
			 		var count=new Number(dataRel[0]);
			 		var num=new Number(dataRel[1]);
			 		//alert(dataRel);
			 		$("#countSum").html("");
			 		$("#countSum").html(count);
			 		$("#priceSum").html("");
			 		$("#priceSum").html(num.toFixed(2));
			 	},"json");
			 	
			 	
			 }
			 /* 获得页面 */
			 function find(){
				var data="opt=find&userid="+${user.userId};
				$.post("BuyCarServlet",data,function(relDate){
					 var str="";
					 var sumCount=0;
					 var rel=relDate.buyCar;
					 var sumPrice=relDate.total;
					 //alert(sumPrice);
					 //alert(rel);
					for(var i=0;i<rel.length;i++){
						str+="<div><a href='#'>SuperClass旗舰店</a><a href='#'><img src='img/3.jpg'></a>  </div>";
						str+="<div class='div2'>";
						str+="<ul>";
						str+="<li id='ll1'><input id='check1' class='buyCarId'  type='checkbox' checked='checked' name='buyCarId' value='"+rel[i].id+"' onclick='getTotal();' /></li>";
						str+="<li><img style='width: 103px;height: 103px;' src='upload/"+rel[i].picPath+"' /></li>";
						str+="<li id='ll2' style='width: 218px;'>"+rel[i].title+"</li>";
						str+="<li id='ll3'><img src='img/1.jpg' /> </li>";
						str+="<li>";
						str+="<ul id='dd2'>";
						str+="<li>"+rel[i].productAttr+"</li>";
						str+="<li><a href='#'>修改</a></li>";
						str+="</ul>";
						str+="</li>";
						str+="<li class='cc2 c2' style='width:60px;'  >￥<span id='price'>"+rel[i].sellingPrice+"</span></li>";
						str+="<li class='c2'><input class='min' type='button' value='-' onclick='minusCount("+rel[i].id+","+rel[i].productCount+");'/>";
						str+="<input class='text_box' readonly='readonly' style='text-align: center;' type='text' name='btn' size='5' value='"+rel[i].productCount+"' />";
						str+="<input class='add' type='button' value='+' onclick='addCount("+rel[i].id+");'/></li>";
						str+="<li class='c2' style='width:30px;'>￥<span class='price'>"+rel[i].buyCarSum+"</span></li>";
						str+="<li class='c2'>";
						str+="<a href='1'>删除</a><br />";
						str+="<a href='#'>移入收藏夹</a>";
						str+="</li>";
						str+="</li>";
						str+="</ul>";
						str+="</div>"; 
						str+="<div>";
						sumCount+=rel[i].productCount;
					}
					
				$("#gome-head2").html("");
				$("#gome-head2").html(str);
				
				var stt="";
				
				stt+="<div id='gome-foot1'>";
				stt+="已选<span class='ccc1' id='countSum'>"+sumCount+"</span>件商品  总计（不含运费）：￥<span class='ccc1' id='priceSum'>"+sumPrice.toFixed(2)+"</span>";
				stt+="&nbsp;&nbsp;&nbsp;&nbsp; <input type='button' class='cc1' value='去结算' onclick='btnSubmit()'  />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
				stt+="</div>";
				$("#gome-foot").html("");
				$("#gome-foot").html(stt);
 			},"json");
				return false;
			};
			
			
			function btnSubmit(){
				var data="userId="+$("#userid").val();
				data+="&addressId=16";
			 	/* 被选中的数组对象 */
			 	var checked=$("input[name='buyCarId']:checked");
			 	for(var i=0;i<checked.length;i++){
			 		data+="&buyCarId="+checked[i].value;
			 	}
				 $.post("AddOrderServlet",data,function(rel){
		 			alert(rel);
		 		},"text");
			}
			
		</script>
		<style>
		
		</style>
  </head>
  
  <body>
	<!--头部-->
  <jsp:include page="/common/header.jsp"></jsp:include>
	<!--top-->
    <div id="div1">
	<input type="hidden" id="userid" name="userid" value="${user.userId}"/>
	<div id="gome-top">
	    <div id="gome-top1" style="clear:both;">
		<img src="img/pic.jpg"   />
	    </div>
	    <div id="dd1">
	    	您还没有登录！登录后购物车的商品将保存到您账号中。 <a href="#" class="span1">立即登录</a><span class="p1">配送至：<input type="text" name="city"/></span>
	    </div>
	</div>
	<!--主体-->
	<div id="gome-head">
	    <div id="gome-head1">
			<ul id="ul1">
				<li><input id="checkall" type="checkbox" name="choose" value="全选"/></li>
				<li>全选</li>
				<li>商品信息</li>
				<li class="c1">单价</li>
				<li class="c1">数量</li>
				<li class="c1">小计</li>
				<li class="c1">操作</li>
			</ul>
	    </div>
	    <div id="gome-head2"></div>
	    </div>
	</div>
	<!--尾部foot-->
	<div id="gome-foot">
	    <div id="gome-foot1">
	    	已选<span class='ccc1' id='countSum'>0</span>件商品  总计（不含运费）：￥<span class='ccc1' id='priceSum'>0.00</span>
	    	&nbsp;&nbsp;&nbsp;&nbsp; <input type='button' class='cc1' value='去结算' />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    </div>
	    
	</div>
</div>
	<!--foot-->
<jsp:include page="/common/footer.jsp"></jsp:include>
  </body>
</html>
