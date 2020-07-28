<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<base href="<%=basePath%>">
		<title>我的国美</title>
		<link rel="stylesheet" type="text/css" href="<%=path %>/myCentrality/css/reset.css"/>
		<link rel="stylesheet" type="text/css" href="<%=path %>/myCentrality/css/page_section.css"/>
		<link rel="stylesheet" type="text/css" href="<%=path %>/myCentrality/css/page_mid.css"/>
		<link rel="stylesheet" type="text/css" href="<%=path %>/myCentrality/css/page_right.css"/>
		<link rel="stylesheet" type="text/css" href="<%=path %>/myCentrality/css/page_myform .css"/>
		<style type="text/css">
			.orderFrom{
				position: relative;
				display: flex;
				justify-content: center;
				align-items: center;
				color: black;
				border: 1px solid red;
				background: #FFFFFF;
				transition:0.25s;
				flex-wrap: wrap;
				height: 6em;
				justify-content: space-around;
				overflow: hidden;
				border-radius: 5em;
				margin-bottom: 10px;
			}
			.orderFrom:hover{
				background: rgba(255,87,87,0.5);
				border: 1px solid rgb(255,87,87,0.5);
				box-shadow: 1px 1px 8px 4px gray ;
			}
			.orderFrom:hover .xuanxiang{
				transform: translateY(0px);
			}
			.orderFrom:hover img{
				transform: rotate(-360deg);
			}
			.orderFrom:hover a{
				transform: translateY(0px);
			}
			.xuanxiang{
				position: absolute;
				bottom: 0;
				right: 0;
				display: flex;
				height: 30px;
				flex-wrap: wrap;
				justify-content: space-around;
				width: 15em;
				background: rgba(0,0,0,0.5);
				transition: 0.25s;
				transform: translateY(30px);
				border-radius: 10px 0 0 0 ;
			}
			.orderFrom>a{
				bottom: 5px;
				right: 85px;
				position: absolute;
				text-decoration: none;
				color: white;
				transform: translateY(30px);
				transition: 0.8s;
			}
			.orderFrom img{
				vertical-align: middle;
				margin-right: 1em;
				transition: 0.25s;
			}
			.fontMoney{
				font-size: 14px;
				color: #444444;
			}
			.rderTitle{
				font-size: 11PX;
				color: #444444;
			}
			.fongtSome{
				font-size: 13px;
			}
			.fongtDate{
				font-size: 13px;
			}
			.bucharFrom{
				border-radius: 10px;
				padding: 5px;
				border: 1px solid rgb(255,87,87,0.5);
				width: 100%;
			}
			.rderTitle span{
				display: inline-block;
				width:100px;
			}
			.orderInfo{
				display: flex;
				justify-content: flex-start;
				margin: 10px;
			}
			.orderInfo p{
				padding: 0;
				margin: 0;
				margin-right: 20px;
			}
			.aaa{
				display: flex;
				
			}
			.aaa .test{
				border:1px solid rgb(255,87,87,0.5);
				display: flex;
				justify-content: center;
				align-items: center;
				width: 8em;
				}
				.ope {
					display:flex;
					justify-content: center;/* 左右居中 */
					align-items: center;/* 上下居中 */
					flex-direction: column;
					border:1px solid rgb(255,87,87,0.5);
				}
				
	
		</style>
	</head>
	<body>
		<!--隐藏固定浮动头部  -->
		<jsp:include page="Myutil/hidNav.jsp"></jsp:include>
		<!--顶部导航 -->
		<jsp:include page="/common/header.jsp"></jsp:include>
		<!--头部搜索  -->
		<jsp:include page="Myutil/headNav.jsp"></jsp:include>
		<!--中间内容  -->
	<div id="section">
		<!--左边导航  -->
		<jsp:include page="Myutil/leftNav.jsp"></jsp:include>
		<!--主要内容  -->
		<div class="main" >
			<input type="hidden" id="userId" name="userId" value="${user.userId }"/>
			<h5 style="color: black; font-weight: 300; margin-bottom: 10px;">我的订单</h5>
			<hr style="margin: 0px;" />
			<ul class="myformNav">
				<li>线上实物订单:</li>
				<li><a>全部</a></li>
				<li><a href="#">预售订单</a></li>
				<li><a href="#">淘实惠订单</a></li>
				<li><a href="#">海外购订单</a></li>
				<li><a href="#">3D订单</a></li>
				<li><a href="#">家装订单</a></li>
				<li><a href="#">定向卷订单</a></li>
			</ul>
			<ul class="myformNav">
				<li>其他订单:</li>
				<li><a href="#">门店</a></li>
				<li><a href="#">国美+</a></li>
				<li><a href="#">美通卡</a></li>
				<li><a href="#">白拿</a></li>
				<li><a href="#">充值话费</a></li>
				<li><a href="#">重置流量</a></li>
				<li><a href="#">游戏</a></li>
			</ul>
			<ul class="dingdan" style="border-bottom: none;">
				<li><a href="#">待付款</a><span class="formSapn">0</span></li>
				<li><a href="#">待收货</a><span class="formSapn">0</span></li>
				<li><a href="#">待评价晒单</a><span class="formSapn">0</span></li>
				<li><input type="text" id="formNumber" placeholder="订单编号"
					style="outline: none;" /> <input id="fangdj" type="image"
					src="<%=path %>/myCentrality/img/fangdajing.png"
					style="outline: none;" /></li>
			</ul>
			<ul class="dingdan">
				<li><select name="" style="outline: none;">
						<option value="">近三个月订单</option>
						<option value="">今年内的订单</option>
						<option value="">2018年的订单</option>
						<option value="">2017年的订单</option>
						<option value="">2016年的订单</option>
						<option value="">2016年以前的订单</option>
				</select></li>
				<li><a href="#">我的订单回收站</a></li>
			</ul>
			<ul class="dingdan2">
				<li>订单商品详情</li>
				<li>金额</li>
				<li><select name="state">
						<option value="">订单状态</option>
						<option value="">等待付款</option>
						<option value="">等待收获</option>
						<option value="">已完成</option>
						<option value="">已取消</option>
				</select></li>
				<li>收货人</li>
				<li>操作</li>
			</ul>
			<div id="noComm" style="width: 820px;">
					<%-- <ul>
						<li><img src="<%=path %>/myCentrality/img/myFrom.png"/></li>
						<li><h3>您好没有订单哦~<br/>给自己定一个小目标，先下一单！</h3></li>
					</ul>
					<a>去首页逛逛</a> --%>
				</div>
			</div>
		</div>
	<!--底部  -->
		<jsp:include page="/common/footer.jsp"></jsp:include>
			<script src="<%=basePath %>js/jquery-1.12.4.js" type="text/javascript" charset="utf-8"></script>
			<script type="text/javascript">
			jQuery(document).ready(function(){
				//alert($("#userId").val());
					findOrder();
					
				});
				function findOrder(){
					var data="";
					data+="userId="+$("#userId").val();
					$.post("OrderServlet?i=1",data,function(rel){
						var str="";
						for(var i=0;i<rel.length;i++){
							str+="<div style='border:1px solid rgb(255,87,87,0.5); margin-top: 20px;'>";
							str+="<div class='orderInfo' >";
							str+="<input type='checkbox' name='' id='' value='' />";
							str+="<p class='fongtDate'>"+rel[i].creatDate+"</p>";
							str+="<p class='fongtDate'>订单号："+rel[i].orderId+"</p>";
							str+="</div>";
							str+="<div class='aaa'>";
							str+="<div class='bucharFrom'>";
							for(var j=0;j<rel[i].list.length;j++){
								str+="<div class='orderFrom'>";
								str+="<div class='rderTitle'>";
								str+="<img src='upload/"+rel[i].list[j].picPath+"' style='width: 80px;'> <span>"+rel[i].list[j].title+"</span>";
								str+="</div>";
								str+="<div class='fontMoney'>￥"+rel[i].list[j].orderSum+"</div>";
								str+="<div class='fongtSome'>数量:"+rel[i].list[j].productCount+"</div>";
								str+="<div>"+rel[i].list[j].name+"</div>";
								str+="<div class='xuanxiang'></div>";
								str+="<a href='#'>再次购买😘</a>";
								str+="</div>";
							}
							str+="</div>";
							str+="<div class='test'>￥"+rel[i].total+"</div>";
							str+="<div class='test'>"+rel[i].consignee+"</div>";
							if(rel[i].list[0].name=="待付款"){
								str+="<div class='ope'style='width:150px;'><a href='#' return false>付款</a></br><a  href='#' return  onclick=cancel(\'"+rel[i].orderId+"\')>取消订单</a></br></div>";
							}else{
								str+="<div class='ope'style='width:150px;'><a href='#' id='"+rel[i].orderId+"' >确认收获</a></br></div>";
							}
							str+="</div>";
						}
						$("#noComm").append(str);
					},"json");
				};
				
				
				/*取消订单  */
				function cancel(obj){
					data="orderId="+obj;
					$.post("OrderServlet?i=3",data,function(rel){
						if(rel>0){
							alert("取消订单成功!");
						}else{
							alert("订单号不存在!");
						}
					},"text");
					return false;
				}
				/*付款  */
				
				/*收获  */
			</script>
	</body>
</html>
