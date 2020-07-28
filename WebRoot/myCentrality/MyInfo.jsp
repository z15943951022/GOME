<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>我的国美</title>
		<link rel="stylesheet" type="text/css" href="<%=path %>/myCentrality/css/reset.css"/>
		<link rel="stylesheet" type="text/css" href="<%=path %>/myCentrality/css/page_section.css"/>
		<link rel="stylesheet" type="text/css" href="<%=path %>/myCentrality/css/page_myInfo.css"/>
		<style type="text/css">
			#myInfo02 input[type='text'],
			#myInfo02 input[type='email']
			{
				outline: none;
				width: 150px;
				border: 1px solid red;
				border-radius: 5px;
				transition: 0.25s;
			}
			#myInfo02 input[type='text']:focus,
			#myInfo02 input[type='email']:focus
			{
				width: 170px;
				border: 1px solid #CF980E;
			}
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
				<ul class="dingdan">
					<li><a>基本资料</a></li>
					<li><a>更多个人资料</a></li>
					<li><a>邮件订阅</a></li>
				</ul>
				<form action="UserServlet?i=2" method="post" enctype="multipart/form-data">
				<input type="hidden" name="userId" id="userId" value="${user.userId }" />
				<input type="hidden" name="money" id="money" value="${user.money}"/>
				<input type="hidden" name="type" id="type" value="${user.type}"/>
				<input type="hidden" name="picPath" id="picPath" value="${user.picPath}"/>
				<table border="" cellspacing="" cellpadding="" id="myInfo02"  >
					<tr>
						<td>头像:</td>
						<td>
							<img src="<%=path %>/upload/${user.picPath}"  />
							<input type="file" name="picPath" id="picPath" value="" />
						</td>
					</tr>
					<tr>
						<td>用户名:</td>
						<td>${user.userPetName }</td>
					</tr>
					<tr>
						<td>*昵称:</td>
						<td><input type="text" name="userPetName" id="userPetName" value="${user.userPetName }" /><span></span></td>
					</tr>
					<tr>
						<td>性别:</td>
						<td>
							<input type="hidden" name="gender" id="gender" value="${user.sex}"/>
							<input type="radio" name="sex" id="nan" value="0" /><label for="nan">男</label>
							<input type="radio" name="sex" id="nv" value="1" /><label for="nv">女</label>
							<input type="radio" name="sex" id="baomi" value="-1" /><label for="baomi">保密</label>
						</td>
					</tr>
					<tr>
						<td>生日:</td>
						<td>
							<input type="text" name="" id="" value="" /><span></span>
						</td>
					</tr>
					<tr>
						<td>我的推荐码:</td>
						<td>12313asda</td>
					</tr>
					<tr>
						<td>推荐人</td>
						<td>无</td>
					</tr>
					<tr>
						<td>手机号码:</td>
						<td>
							<input type="text" name="phone" id="phone" value="${user.phone }" />
							<a href="#">修改</a>
							<span>已验证</span>
						</td>
					</tr>
					<tr>
						<td>邮箱:</td>
						<td>
							<input type="email" name="email" id="email" value="${user.email }" />
							<a href="#">修改</a>
							<span>已验证</span>
						</td>
					</tr>
					<tr>
						<td>家庭住址:</td>
						<td><input type="text" name="" style="width: 300px;" /></td>
					</tr>
					<tr>
						<td></td>
						<td>
							<input type="submit" name="" id="" value="保存" />
						</td>
					</tr>
				</table>
				</form>
			</div>
		</div>
		<!--底部  -->
		<jsp:include page="/common/footer.jsp"></jsp:include>
		<script src="<%=path %>/myCentrality/js/jquery-1.12.4.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			$(function(){
				gender();
			});
			function gender(){
				var sex=$("#gender").val();
				if(sex==0){
					$("#nan").attr("checked","true");
				}else if(sex==1){
					$("#nv").attr("checked","true");
				}else{
					$("#baomi").attr("checked","true");
				}
			}
			
		</script>
	</body>
</html>
