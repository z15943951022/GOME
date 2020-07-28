<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	    <base href="<%=path%>">
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="<%=path %>/css/reset.css"/>
		<link rel="stylesheet" type="text/css" href="<%=path %>/myCentrality/css/page_myhead.css"/>
	</head>
	<body>
		<div id="header2">
			<div id="header">
				<div class="jiao_bottom"></div>
				<ul>
					<li><a href="myCentrality/homePage.jsp">我的国美</a></li>
					<li><a href="">首页</a></li>
					<li>
						<a href="myCentrality/#">账户设置<div class="jiao"></div></a>
						<ul id="user_set">
							<li><a href="myCentrality/MySafe.jsp">账户安全</a></li>
							<li><a href="myCentrality/MyInfo.jsp">基本资料</a></li>
							<li><a href="myCentrality/MyAddress.jsp">收获地址</a></li>
							<li><a href="">增票认证</a></li>
							<li><a href="">我的会员卡</a></li>
							<li><a href="">账户绑定</a></li>
						</ul>
					</li>
					<li>
						<a href="">会员俱乐部<div class="jiao"></div></a>
						<ul id="VIP">
							<li><a href="">会员俱乐部</a></li>
							<li><a href="">会员等级</a></li>
							<li><a href="">会员权益</a></li>
							<li><a href="">我的礼包</a></li>
						</ul>
					</li>
					<li>
						<a href="">社区</a><div class="jiao"></div>
						<ul id="com">
							<li><a href="">会员俱乐部</a></li>
							<li><a href="">会员等级</a></li>
							<li><a href="">会员权益</a></li>
							<li><a href="">我的礼包</a></li>
						</ul>
					</li>
					<li>
						<form id="fom" action="" method="post">
							<input type="search" name="" id="" value=""  />
							<input id="aa"  type="image" src="<%=path %>/myCentrality/img/search.png" />
						</form>
					</li>
					<li><a href="">购物车0件 <div class="right_jiao"></div></a></li>
				</ul>
			</div>
		</div>
	</body>
</html>
