<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
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
  <form action="">
  
  </form>
	  <input type="text" id="userId" name="userId" value="1"/>
	  <input type="checkbox" name="buyCarId" value="1" checked="checked"/>
	  <input type="checkbox" name="buyCarId" value="3" checked="checked"/>
	  <input type="text" id="addressId" name="addressId" value="16"/>
	   <input type="button" id="subm" name="subm" value="提交"/>
  </body>
	<script src="<%=path %>/myCentrality/js/jquery-1.12.4.js" type="text/javascript" charset="utf-8"></script>
  <script type="text/javascript">
  	$("#subm").click(function(){
  		data="userId="+$("#userId").val();
  		data+="&addressId="+$("#addressId").val();
  		data+="&buyCarId=1";
  		data+="&buyCarId=3";
  		$.post("AddOrderServlet",data,function(rel){
  			alert(rel);
  		},"text");
  	});
  </script>
</html>
