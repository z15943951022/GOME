<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'pay.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<link rel="stylesheet" type="text/css" href="myCentrality/css/new_file.css"/>
		<script type="text/javascript" src="myCentrality/js/jquery-1.12.4.js">
		</script>
		<script type="text/javascript" src="myCentrality/js/new_file.js">
			
		</script>
	
	
  </head>
  
  <body>
    <!--头部-->
			<div id="title">
				<div id="title_img"><img src="myCentrality/img/shouyintai.png"/> </div>
			</div>
			
			<div id="ddv">
				<!--主体<-->
				<div id="header">
					<div  id="h1">订单提交成功，请您尽快付款。 支付单号：<span id="sp1">应付金额：元</span></div>
					<div id="h2">订单详情</div>
					<div id="h3">
						<p>收货地址： 收货人:</p>
						<p>订单号：</p>
					</div>
					<div id="header_img"><img src="myCentrality/img/yinhang.png" /> </div>
				</div>
				
				<!--尾部-->
				<div id="fooder">
					<span id="sp2">立即支付</span>
				</div>
				<div id="ddd">
					©2000-2018 国美在线电子商务有限公司 版权所有
				</div>
			</div>
  </body>
</html>
