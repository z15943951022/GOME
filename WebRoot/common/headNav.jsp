<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'headNav.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
		<div id="searchNav">
				<table>
					<tr>
						<td>
							<div>
								<img height="50px" src="img/GMLOGO.png" />
								<a href="#"><img src="img/T1c4YXBgAv1RCvBVdK.gif" /></a>
							</div>
						</td>
						<td>
							<form>
								<div id="select">
									<select>
										<option value="1">商品</option>
										<option value="1">店铺</option>
										<option value="1">话题</option>
										<option value="1">圈子</option>
									</select>
								</div>
								<input  type="search" placeholder="香肠派对" /><input type="button" value="搜索" />
							</form>
							<p><a href="#">香肠派对 彩电返劵 空调减500元 低至5折 电脑1999元 低至49元 荣耀9X 冰箱1099元</a></p>
						</td>
						<td>
							<a href="myCentrality/BuyCar.jsp">
								<div>
									<img height="20px" src="img/buycar.png" />
									我的购物车<span id="buySanjiao">▼</span>
								</div>
							</a>
							<div id="yincangBuy">
								<a href="#">购物车</a><span>中还没有商品，赶紧选购吧！</span>
							</div>
						</td>
					</tr>
				</table>
				
				
				
			</div>
  </body>
</html>
