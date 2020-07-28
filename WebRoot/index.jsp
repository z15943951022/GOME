<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
	<base href="<%=basePath%>">
		<meta charset="utf-8" />
		<title>首页</title>
		<link rel="stylesheet" type="text/css" href="css/gmShouyeStyle.css"/>
		<script type="text/javascript" src="js/jquery-1.12.4.js" ></script>
		<script type="text/javascript" src="js/gmShouye.js"></script>
		
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
			<div id="rightNav">
				<div>
					快讯
					<a href="#">更多 </a>
					<ul>
						<li><a href="#">公告</a> <a href="#">争做上海好网民 上海网民在行动</a></li>
						<li><a href="#">公告</a> <a href="#">美豆有效期变更</a></li>
						<li><a href="#">特惠</a> <a href="#">会员礼包 送皮肤再给无门槛券</a></li>
						<li><a href="#">特惠</a> <a href="#">海尔专场 美豆兑券满千减百</a></li>
						<li><a href="#">特惠</a> <a href="#">会员礼包 送皮肤再给无门槛券</a></li>
						<li><a href="#">特惠</a> <a href="#">海尔专场 美豆兑券满千减百</a></li>
						<li><a href="#">特惠</a> <a href="#">会员礼包 送皮肤再给无门槛券</a></li>
						<li><a href="#">特惠</a> <a href="#">海尔专场 美豆兑券满千减百</a></li>
						<li><a href="#">特惠</a> <a href="#">会员礼包 送皮肤再给无门槛券</a></li>
						<li><a href="#">特惠</a> <a href="#">海尔专场 美豆兑券满千减百</a></li>
					</ul>
				</div>
				
				<div id="ritNavMid">
					
				</div>
				<div>
					<img src="img/T1FFWXBQKv1RCvBVdK.jpg" />
				</div>
			</div>
			<div id="midNav">
				<div ></div>
				<ul>
					<li value="1"></li>
					<li value="2"></li>
					<li value="3"></li>
					<li value="4"></li>
					<li value="5"></li>
					<li value="6"></li>
					<li value="7"></li>
					<li value="8"></li>
				</ul>
			</div>
			
		</nav>
		<section >
			
			<div id="meiri">
				<input type="hidden" id="curPage" value="0" />
				<div id="biqiang">
					<h3 ><img src="img/T1ovZvBTbb1RCvBVdK.jpeg" /> 每日必抢<input type="button" value="刷新" onclick="getProducts();" /></h3>
					<div>
						<a href="ProductDetailServlet?productId=12">
							<img height="120px" width="120px" src="img/T1NyZsBsWv1RCvBVdK_120.jpg"  />
							<p>￥36.00 <span>￥45.90</span></p>
							<p>双庆 免打孔卫生间洗漱台储物架 壁</p>
						</a>
					</div>
					<div>
						<a href="#">
							<img src="img/T1NyZsBsWv1RCvBVdK_120.jpg"  />
							<p>￥36.00 <span>￥45.90</span></p>
							<p>双庆 免打孔卫生间洗漱台储物架 壁</p>
						</a>
					</div>
					<div>
						<a href="#">
							<img src="img/T1NyZsBsWv1RCvBVdK_120.jpg"  />
							<p>￥36.00 <span>￥45.90</span></p>
							<p>双庆 免打孔卫生间洗漱台储物架 壁</p>
						</a>
					</div>
					<div>
						<a href="#">
							<img src="img/T1NyZsBsWv1RCvBVdK_120.jpg"  />
							<p>￥36.00 <span>￥45.90</span></p>
							<p>双庆 免打孔卫生间洗漱台储物架 壁</p>
						</a>
					</div>
				</div>
				<div align="right">
					<a href="#"><img src="img/T1rzxXBXJ_1RCvBVdK.jpg" /></a>
				</div>
			</div>
		</section>
		<article style=" width:1210px;">
			<div class="sanfentu">
				<h3>淘·实惠 <span>BARGAINS</span></h3>
				<div >
					<table>
						<tr>
							<td rowspan="2"><a href="#"><img src="img/T11FbXB7hv1RCvBVdK.jpg" /></a></td>
							<td ><a href="#"><img src="img/T1rMLsBbxT1RCvBVdK.jpg"  /></a></td>
						</tr>
						<tr>
							<td ><a href="#"><img src="img/T1aYYsB_Wv1RCvBVdK.jpg" /></a></td>
						</tr>
					</table>
				</div>
			</div>
		
			<div class="sanfentu">
				<h3>购·新潮 <span>FASHION</span></h3>
				<div>
					<table >
						<tr>
							<td rowspan="2"><a href="#"><img src="img/T1XXLXBvWv1RCvBVdK.jpg" /></a></td>
							<td><a href="#"><img src="img/T164KXB4ZT1RCvBVdK.jpg" /></a></td>
						</tr>
						<tr>
							<td><a href="#"><img src="img/T1uHJXBsxT1RCvBVdK.jpg" /></a></td>
						</tr>
					</table>
				</div>
			</div>
		
			<div id="ninePic">
				<h3>购·新潮<span>FASHION</span></h3>
				<div>
					<div id="erPic">
						<table>
							<tr><td class="bottomDashed"><a href="#"><img  src="img/T184YXB7hv1RCvBVdK.png"/></a></td></tr>
							<tr><td><a href="#"><img src="img/T1RPEsBCEv1RCvBVdK.jpg"/></a></td></tr>
						</table>
					</div>
					<div id="qiPic">
						<ul>
							<li><a href="#"><img src="img/T1IBWQB7_T1RCvBVdK.jpg"/></a></li>
							<li><a href="#"><img src="img/T1JLEjBTxv1RCvBVdK.jpg"/></a></li>
							<li><a href="#"><img src="img/T1BlbjB7V_1RCvBVdK.png"/></a></li>
							<li><a href="#"><img src="img/T1lVJQBXYT1RCvBVdK.jpg"/></a></li>
							<li><a href="#"><img src="img/T1UfV_BXDT1RCvBVdK.jpg"/></a></li>
							<li><a href="#"><img src="img/T1qKEQBmJv1RCvBVdK.jpg"/></a></li>
							<li><a href="#"><img src="img/T1cZJsBXDT1RCvBVdK.jpg"/></a></li>
						</ul>
					</div>
					
				</div>
			</div>
		</article>
		<div id="quan">
			<ul>
				<li><a href="#"><img src="img/T1K9ZvB5Kj1RCvBVdK.jpg" /></a></li>
				<li><a href="#"><img src="img/T1iFbXBXLT1RCvBVdK.jpg" width="207px" class="youhui" /></a></li>
				<li><a href="#"><img src="img/T13pbXBQZT1RCvBVdK.jpg" width="207px" class="youhui" /></a></li>
				<li><a href="#"><img src="img/T1JrxsByhv1RCvBVdK.jpg" width="207px" class="youhui" /></a></li>
				<li><a href="#"><img src="img/T1WNhbBQEv1RCvBVdK.jpg" width="207px" class="youhui" /></a></li>
				<li><a href="#"><img src="img/T1lNbXBybT1RCvBVdK.jpg" width="207px" /></a></li>
				<li><a href="#"><img src="img/T13MDvBjC_1RCvBVdK.jpg" /></a></li>
			</ul>
		</div>
		
		</div>
		<jsp:include page="common/footer.jsp"></jsp:include>
		<script type="text/javascript">
			
			function getProducts(){
				var data="opt=getProducts";
				//先清空
				$("#biqiang").html("");
				//保存头部
				var strH3="<h3 ><img src='img/T1ovZvBTbb1RCvBVdK.jpeg' /> 每日必抢<input type='button' value='刷新' onclick='getProductsPaging();' /></h3>";
				
				var strDiv="";
				
				$.post("ProductDetailServlet",data,function(relData){
					 for(var i=0;i<relData.length;i++){
						//循环拼接div串
						strDiv+="<div><a href='ProductDetailServlet?opt=goProductDetail&productId="+relData[i].productId+"'>"+
						"<img height='120px' width='120px' src='upload/"+relData[i].picPath+"'  />"+
						"<p>￥"+relData[i].sellingPrice+" <span>￥"+relData[i].price+"</span></p><p>"+relData[i].title+"</p></a></div>";
						if(i==3){
							break;
						}  
					}
					//添加
					$("#biqiang").html(strH3+strDiv); 
				},"json");
			}
			$(function(){
				//getProducts();
				getProductsPaging()
			});
			function getProductsPaging(){
				
				var data="opt=getProductsPaging";
				data+="&curPage="+eval($("#curPage").val()+"+"+1);
				
				//先清空
				$("#biqiang").html("");
				//保存头部
				var strH3="<h3 ><img src='img/T1ovZvBTbb1RCvBVdK.jpeg' /> 每日必抢";
				strH3+="<input type='button' value='换一批' onclick='getProductsPaging();' /></h3>";
				
				var strDiv="";
				
				$.post("ProductDetailServlet",data,function(jsonStr){
					var relData=jsonStr.dataList;
					//页面记录
					$("#curPage").val(jsonStr.pageIndex);
					
					 for(var i=0;i<relData.length;i++){
					 
						//循环拼接div串
						strDiv+="<div><a href='ProductDetailServlet?opt=goProductDetail&productId="+relData[i].productId+"'>"+
						"<img height='120px' width='120px' src='upload/"+relData[i].picPath+"'  />"+
						"<p>￥"+relData[i].sellingPrice+" <span>￥"+relData[i].price+"</span></p><p>"+relData[i].title+"</p></a></div>";
						/* if(i==3){
							break;
						}  */ 
					}
					//添加
					$("#biqiang").html(strH3+strDiv); 
				},"json"); 
			}
		</script>
	</body>
</html>

