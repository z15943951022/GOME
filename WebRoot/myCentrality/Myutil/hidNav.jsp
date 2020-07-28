<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'hidNac.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<%=path %>/myCentrality/css/page_hidnav.css"/>
  </head>
  
  <body>
    <div id="hidenav">
				<ul>
					<li>我的国美</li>
					<li><input type="search" name="" id="" value="" /></li>
					<li><input type="submit" name="" id="" value="搜索" /></li>
				</ul>
		</div>
  </body>
  <script type="text/javascript" src="<%=path %>/myCentrality/js/jquery-1.12.4.js"></script>
  <script type="text/javascript" src="<%=path %>/myCentrality/js/hidnav.js"></script>
</html>
