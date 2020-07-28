<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	    <base href="<%=basePath%>">
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="<%=path %>/myCentrality/css/page_myleft.css"/>
	</head>
	<body>
		<div id="left">
					<ul>
						<li>订单中心</li>
						<li><a href="myCentrality/MyFrom.jsp">我的订单</a></li>
						<li><a href="myCentrality/#">退货货单</a></li>
						<li><a href="myCentrality/#">评价晒单</a></li>
						<li><a href="myCentrality/#">服务单</a></li>
						<li><a href="myCentrality/#">以旧换新</a></li>
						<li><a href="myCentrality/#">延保服务</a></li>
					</ul>
					<ul>
						<li>资产中心</li>
						<li><a href="myCentrality/#">美国币余额</a></li>
						<li><a href="myCentrality/#">美通卡</a></li>
						<li><a href="myCentrality/#">我的美豆</a></li>
						<li><a href="myCentrality/#">优惠卷</a></li>
						<li><a href="myCentrality/#">我的礼包</a></li>
					</ul>
					<ul>
						<li>管理中心</li>
						<li><a href="myCentrality/#">我的收藏</a></li>
						<li><a href="myCentrality/#">我的预约</a></li>
						<li><a href="myCentrality/#">我的足迹</a></li>
						<li><a href="myCentrality/#">我的咨询</a></li>
						<li><a href="myCentrality/#">投诉管理</a></li>
						<li></li>
					</ul>
					<ul>
						<li>账户设置</li>
						<li><a href="myCentrality/MySafe.jsp">账户安全</a></li>
						<li><a href="myCentrality/MyInfo.jsp">基本资料</a></li>
						<li><a href="myCentrality/MyAddress.jsp">收获地址</a></li>
						<li><a href="myCentrality/#">增票认证</a></li>
						<li><a href="myCentrality/#">我的会员卡</a></li>
						<li><a href="myCentrality/#">账户绑定</a></li>
					</ul>
				</div>
	</body>
</html>
