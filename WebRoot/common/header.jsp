<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	    <base href="<%=path%>">
		<title></title>
		<link rel="stylesheet" type="text/css" href="<%=path %>/css/page_header.css"/>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		<script src="js/jquery-1.12.4.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/js_header.js" type="text/javascript"></script>
		<style>
			input[type=search]{
				outline: none;
				width: 140px;
				transition: 0.25s;
			}
			input[type=search]:focus{
				width: 200px;
				border: 1px solid yellow;
			}
		</style>
	</head>
	<body>
		<header style="font-size: 13px;">
			<div id="head_nav">
			<input type="hidden" id="userId" name="userId" value="${user.userId }" />
				<ul>
					<li><a href=""><span><img src="img/fangzi.png"/>国美首页</span></a></li>
					<c:if test="${user==null }">
							<a href="<%=path %>/login.jsp" style="color: blue;text-decoration: none;">去登陆</a>
					</c:if>
					<li>
					<c:if test="${user!=null }">
							<span>Hi,</span><a href="">${user.userPetName }<img src="img/xia.png" />
							</a>
						<li><a href="UserOut">退出</a></li>
					</c:if>
						<div id="myinfo">
							<div>
								<img src="<%=path %>/upload/${user.picPath}" style="height: 80px; width: 80px;" />
							</div>
							<ul>
								<li>${user.userPetName }<span>G15</span></li>
								<li><img src="img/jingyan.png"  /></li>
								<li>升级到G16还需要1个购物天数</li>
							</ul>
							<hr />
							<ul>
								<li>我的三项特权</li>
								<li>会员俱乐部</li>
							</ul>
							<img id="what" src="img/what.png"/>
						</div>
					</li>
				</ul>
				<ul>
					<li><a href="">我的订单</a></li>
					<li>
						<a href="myCentrality/homePage.jsp">我的国美<img src="img/xia.png" /></a>
						<div id="copyinfo">
						<c:if test="${user==null}">
							<div>
								<a href="<%=path %>login.jsp">请先登录</a>
							</div>
						</c:if>
						<c:if test="${user!=null}">
							<div>
								<img src="<%=path %>/upload/${user.picPath}" style="height: 80px; width: 80px;" />
							</div>
							<ul>
								<li>${user.userPetName }<span>G15</span></li>
								<li><img src="img/jingyan.png"/></li>
								<li>升级到G16还需要1个购物天数</li>
							</ul>
						</c:if>
							<hr />
							<ul>
								<li>我的三项特权</li>
								<li>会员俱乐部</li>
							</ul>
							<img id="what" src="<%=path %>/img/what.png"/>
						</div>
					</li>
					<li id="qiye">
						<a href="" >企业采购<img src="<%=path %>/img/xia.png" /></a>
						<div id="nav_caigou">
							<img src="<%=path %>/img/erweima.png"/>
						</div>
					</li >
					<li><a href="">服务中心<img src="<%=path %>/img/xia.png" /></a></li>
					<li id="daohang">
						<a href="">网站导航<img src="<%=path %>/img/xia.png" /></a>
						<div id="navv">
							<div>
								<h4>主题促销</h4>
								<ul>
									<li><a href="">真划算</a></li>
									<li><a href="">家电城</a></li>
									<li><a href="">智能</a></li>
									<li><a href="">抢购</a></li>
									<li><a href="">服饰城</a></li>
									<li><a href="">今日特卖</a></li>
									<li><a href="">美家致选</a></li>
									<li><a href="">美国超市</a></li>
									<li><a href="">新品抢先</a></li>
									<li><a href="">品牌街</a></li>
									<li><a href="a">家具家装</a></li>
								</ul>
							</div>
							<div>
								<h4>特色分类</h4>
								<ul>
									<li><a href="">电视影音</a></li>
									<li><a href="">手机</a></li>
									<li><a href="">住宅家具</a></li>
									<li><a href="">服饰鞋帽</a></li>
									<li><a href="">食品酒水</a></li>
									<li><a href="">冰洗</a></li>
									<li><a href="">数码</a></li>
									<li><a href="">家装建材</a></li>
									<li><a href="">运动户外</a></li>
									<li><a href="">母婴玩具</a></li>
									<li><a href="">洗衣机</a></li>
									<li><a href="">电脑办公</a></li>
									<li><a href="">家具日用</a></li>
									<li><a href="">箱包奢侈</a></li>
									<li><a href="">美妆个护</a></li>
									<li><a href="">空调</a></li>
									<li><a href="">精品配件</a></li>
									<li><a href="">床品家纺</a></li>
									<li><a href="">钟表首饰</a></li>
								</ul>
							</div>
							<div>
								<h4>便捷服务</h4>
								<ul>
									<li><a href="">花费充值</a></li>
									<li><a href="">流量充值</a></li>
									<li><a href="">每店</a></li>
									<li><a href="">上门服务</a></li>
								</ul>
							</div>
							<div>
								<h4>更多热点</h4>
								<ul>
									<li><a href="">商家入驻</a></li>
									<li><a href="">企业采购</a></li>
								</ul>
							</div>
							<div>
								<h4>国美旗下</h4>
								<ul>
									<li><a href="">国美管家</a></li>
								</ul>
							</div>
						</div>
					</li>
					<li id="bug">
						<a href="">手机国美<img src="<%=path %>/img/xia.png" /></a>
						<div id="phoneerwei" >
							<img src="<%=path %>/img/phoneerwei.png"/>
						</div>
					</li>
				</ul>
			</div>
		</header>
	</body>
</html>
