<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta charset="UTF-8">
		<title>我的国美</title>
		<link rel="stylesheet" type="text/css" href="<%=path %>/myCentrality/css/reset.css"/>
		<link rel="stylesheet" type="text/css" href="<%=path %>/myCentrality/css/page_section.css"/>
		<link rel="stylesheet" type="text/css" href="<%=path %>/myCentrality/css/page_mid.css"/>
		<link rel="stylesheet" type="text/css" href="<%=path %>/myCentrality/css/page_mySafe.css"/>
		<style type="text/css">
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
			<div class="main">
				<h3 style="color: black; font-weight: 300; margin-bottom: 10px;">账户安全</h3>
				<hr >
				<ul class="safeNav">
					<li>强度：中</li>
					<li>登陆密码</li>
					<li>
						<img src="<%=path %>/myCentrality/img/mimaqiangdu.png" ><br />
						<span>为了账户更加安全，建议您定期更换密码。</span>
					</li>
					<li><a href="#">修改</a></li>
				</ul>
				<ul class="safeNav">
					<li>
						<img src="<%=path %>/myCentrality/img/zhengque.png" >
						已验证	
					</li>
					<li>邮箱验证</li>
					<li>您验证的邮箱：17***704@qq.com</li>
					<li><a href="#">修改</a></li>
				</ul>
				<ul class="safeNav">
					<li>
						<img src="<%=path %>/myCentrality/img/zhengque.png" >
						已验证	
					</li>
					<li>手机验证</li>
					<li>您验证的手机：159****1022</li>
					<li><a href="#">修改</a></li>
				</ul>
				<ul class="safeNav">
					<li>
						<img src="<%=path %>/myCentrality/img/zhengque.png" >
						已验证	
					</li>
					<li>支付密码</li>
					<li>设置支付密码能有效的保障账户的安全，在使用美豆、红券、美通卡时和国美币充值、提现等操作时需要输入支付密码。</li>
					<li><a href="#">修改</a></li>
				</ul>
				<ul class="safeNav">
					<li>
						<img src="<%=path %>/myCentrality/img/zhengque.png" >
						已验证	
					</li>
					<li>实名认证</li>
					<li>完成实名认证，可享受更多权益，保障账户安全</li>
					<li><a href="#">修改</a></li>
				</ul>
			</div>
		</div>
		<!--底部  -->
		<jsp:include page="/common/footer.jsp"></jsp:include>
			<script src="<%=path %>/myCentrality/js/jquery-1.12.4.js" type="text/javascript" charset="utf-8"></script>
			<script src="<%=path %>/myCentrality/js/js_header.js" type="text/javascript" charset="utf-8"></script>
	</body>
			
</html>
