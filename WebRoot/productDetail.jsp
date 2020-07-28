<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<fmt:formatNumber type="number" value="${688.87 * 0.8 }" pattern="0.00" maxFractionDigits="2"/>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
	<base href="<%=basePath%>">
		<meta charset="UTF-8">
		<title>商品详情</title>
		<link rel="stylesheet" type="text/css" href="css/page_header.css"/>
		<link rel="stylesheet" type="text/css" href="css/gmShouyeStyle.css"/>
		<link rel="stylesheet" type="text/css" href="css/productDetail.css"/>
		<link rel="stylesheet" type="text/css" href="css/page_footer.css"/>
		<script src="js/jquery-1.12.4.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/js_header.js" type="text/javascript"></script>
		<script type="text/javascript" src="js/gmShouye.js" ></script>
		<script src="js/productDetail.js" type="text/javascript" ></script>
	</head>
	<body>
		<div id="rightDiv">
			<ul>
				<li>
					<div>
						<img src="img/youbian.png" />
					</div>
				</li>
				
			</ul>
		</div>
		<jsp:include page="common/header.jsp"></jsp:include>
		<div style="margin: 0px auto; width: 1300px;">
		<nav>
		<jsp:include page="common/headNav.jsp"></jsp:include>
		
		<div id="leftpNav">
			<h4>全部商品分类</h4>
			<ul>
				<li><a href="#">手机</a> <a href="#">充值</a></li>
				<li><a href="#">相机</a> <a href="#">智能数码</a></li>
				<li><a href="#">电脑</a> <a href="#"> 办公配件</a></li>
				<li><a href="#">电视</a> <a href="#">影音</a> <a>智能</a></li>
				<li><a href="#">空调</a> <a href="#">冰箱</a> <a>洗衣机</a></li>
				<li><a href="#">厨房卫浴</a> <a href="#">生活电器</a> <a>环境</a></li>
				<li><a href="#">家具</a> <a href="#">建材</a> <a>欧洲厨房</a></li>
				<li><a href="#">家居家纺</a> <a href="#"> 家居家装</a></li>
				<li><a href="#">食品酒水</a></li>
				<li><a href="#">母婴玩具</a></li>
				<li><a href="#">美妆个护</a></li>
				<li><a href="#">服饰鞋帽</a> <a href="#"> 箱包奢品</a></li>
				<li><a href="#">运动户外 </a> <a href="#">钟表首饰</a></li>
				<li><a href="#">汽车整车</a> <a href="#"> 汽车用品</a></li>
				<li><a href="#">国美管家</a></li>
			</ul>
		</div>
		
		<div id="topNav">
			<ul>
				<li><a href="#">发现</a></li>
				<li><a href="#">真划算</a><span></span></li>
				<li><a href="#">超市</a></li>
				<li><a href="#">电器城</a></li>
				<li><a href="#">汽车</a></li>
				<li><a href="#">家居家装</a><span></span></li>
				<li><a href="#">智能</a></li>
				<li><a href="#">管家</a></li>
			</ul>
		</div>
		<div id="proTopNav">
			<ul>
				
				<c:forEach items="${typeList }"  var="productType" varStatus="status" >
					<li><a href="#">${productType.typeName }</a><span>＞</span></li>
				</c:forEach>
				
				<li ><a href="#">${product.title }</a></li>
			</ul>
		</div>
		<section>
			<table>
				<tr>
					<td>
						<div class="proPic">
							<img height="400px" width="400px" src="upload/${product.picPath }" />
						</div>
						<div  class="formDiv proId">
							商品编号：&nbsp;&nbsp;<span>${product.productId }</span>
						</div>
					</td>
					<td>
						<div id="proBuy">
							<h4>${product.title }</h4>
							<form method="post" action="#" id="buyForm" >
								<div id="priceDiv" >
									抢 购 价 &nbsp;&nbsp;¥<span id="buyPrice" >${product.sellingPrice }</span> &nbsp;&nbsp;<span id="originalPrice">¥${product.price }</span>
									&nbsp;&nbsp; <a href="#">降价通知</a>
								</div>
								<div id="tese" class="formDiv">
									特 &nbsp;&nbsp;&nbsp;&nbsp;色 &nbsp;&nbsp;&nbsp;&nbsp;<a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
								</div>
								<div id="addressChoseDiv" class="formDiv">
									送 &nbsp;&nbsp;&nbsp;&nbsp;至 &nbsp;&nbsp;<span id="defaultAddress">山东省济南市历下区趵突泉街道</span>
									&nbsp;&nbsp; <a href="#">修改</a>&nbsp;&nbsp;<span class="PCS">有货</span>&nbsp;&nbsp; 
									支持&nbsp;&nbsp; <a href="#">免运费</a>
								</div>
								<div id="server" class="formDiv">
									服 &nbsp;&nbsp;&nbsp;&nbsp;务 &nbsp;&nbsp;由&nbsp;<span id="selUser">由金信个护专营店 </span>&nbsp;发货并负责售后服务。
								</div>
								<div class="buyDiv">
									数 &nbsp;&nbsp;&nbsp;&nbsp;量 &nbsp;
									<input type="button" value="-" class="btnCount" /><input type="text" id="count" class="formInput" value="1" /><input type="button" value="+" class="btnCount" />
									 &nbsp;&nbsp;
									<input type="button" value="加入购物车" class="btnSub" onclick="addBuyCar()" />
									
								</div>
								<div  class="formDiv">
									温馨提示 &nbsp;&nbsp;1. 正品保障； 支持7天无理由退货
								</div>
							</form>
						</div>
					</td>
				</tr>
			</table>
		</section>
		<section class="proDetail">
			<nav class="proNav">
				<ul>
					<li class="li1"><a href="#">商品详情</a></li>
					<li><a href="#">规格与包装</a></li>
					<li><a href="#">商品评价（76）</a></li>
					<li><a href="#">售后保障</a></li>
					<li><a href="#">小助手</a></li>
					<li><a href="#">本店好评商品</a></li>
				</ul>
			</nav>
			<div class="proDetailDiv" id="proNav1">
				<img alt="介绍" src="img/jieshao.jpg">
				<c:if test="${(product.productDetail.lastIndexOf('.')+4)==product.productDetail.length() }">
					<img width="750px"  src="upload/${product.productDetail }" alt="${product.productDetail }" />
				</c:if>
				<c:if test="${(product.productDetail.lastIndexOf('.')+4)!=product.productDetail.length() }">
					${product.productDetail }
				</c:if>
				
			</div>
			<div class="proDetailDiv" id="proNav3">
				<div style="height: 100px;">
				<ul>
					<li class="li1"><a href="#">全部评价(76)</a></li>
					<li><a href="#">晒图(5)</a></li>
					<li><a href="#">好评(75)</a></li>
					<li><a href="#">中评(1)</a></li>
					<li><a href="#">差评(0)</a></li>
					<li><a href="#">本店好评商品</a></li>
				</ul>
				</div>
				<div class="pinglun">
					<div class="userPic">
						<img src="img/touxiang(1).jpg" />
					</div>
					<div class="userName">顽皮的小松鼠</div>
					<div class="userComment">
						使用心得：宝贝收到、还有一套小礼品、非常值得的一次购物、满意！好评!<br />
						<span>收货后56天评价 2019-08-08 14:57</span>
					</div>
					<div class="score">10分</div>
				</div>
				<div class="pinglun">
					<div class="userPic">
						<img src="img/touxiang(1).jpg" />
					</div>
					<div class="userName">顽皮的小松鼠</div>
					<div class="userComment">
						使用心得：宝贝收到、还有一套小礼品、非常值得的一次购物、满意！好评!<br />
						<span>收货后56天评价 2019-08-08 14:57</span>
					</div>
					<div class="score">10分</div>
				</div>
				<div class="pinglun">
					<div class="userPic">
						<img src="img/touxiang(1).jpg" />
					</div>
					<div class="userName">顽皮的小松鼠</div>
					<div class="userComment">
						使用心得：宝贝收到、还有一套小礼品、非常值得的一次购物、满意！好评!<br />
						<span>收货后56天评价 2019-08-08 14:57</span>
					</div>
					<div class="score">10分</div>
				</div>
				<div class="pinglun">
					<div class="userPic">
						<img src="img/touxiang(1).jpg" />
					</div>
					<div class="userName">顽皮的小松鼠</div>
					<div class="userComment">
						使用心得：宝贝收到、还有一套小礼品、非常值得的一次购物、满意！好评!<br />
						<span>收货后56天评价 2019-08-08 14:57</span>
					</div>
					<div class="score">10分</div>
				</div>
				<div class="pinglun">
					<div class="userPic">
						<img src="img/touxiang(1).jpg" />
					</div>
					<div class="userName">顽皮的小松鼠</div>
					<div class="userComment">
						使用心得：宝贝收到、还有一套小礼品、非常值得的一次购物、满意！好评!<br />
						<span>收货后56天评价 2019-08-08 14:57</span>
					</div>
					<div class="score">10分</div>
				</div>
				<div class="pinglun">
					<div class="userPic">
						<img src="img/touxiang(1).jpg" />
					</div>
					<div class="userName">顽皮的小松鼠</div>
					<div class="userComment">
						使用心得：宝贝收到、还有一套小礼品、非常值得的一次购物、满意！好评!<br />
						<span>收货后56天评价 2019-08-08 14:57</span>
					</div>
					<div class="score">10分</div>
				</div>
				<div class="pinglun">
					<div class="userPic">
						<img src="img/touxiang(1).jpg" />
					</div>
					<div class="userName">顽皮的小松鼠</div>
					<div class="userComment">
						使用心得：宝贝收到、还有一套小礼品、非常值得的一次购物、满意！好评!<br />
						<span>收货后56天评价 2019-08-08 14:57</span>
					</div>
					<div class="score">10分</div>
				</div>
				
			</div>
		</section>
		</div>
		<jsp:include page="common/footer.jsp"></jsp:include>
	<script type="text/javascript">
		//加入购物车
		function addBuyCar(){
			var data="opt=addProduct";
			data+="&productId="+$(".proId").find("span").text();
			//var reg=/\d|-|+|./;
			data+="&sellingPrice="+$("#buyPrice").text();
			
			data+="&productCount="+$("#count").val();
			alert(data);
			$.post("BuyCarServlet",data,function(relData){
				alert(relData);
			},"text");
		}
	</script>
	</body>
</html>
