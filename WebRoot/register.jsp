<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		
		<link rel="stylesheet" type="text/css" href="css/register.css"/>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
		<style type="text/css">
				#mian_form input[type='text'],
			#mian_form input[type='passWord']
			{
				
				display: block;
				margin: 20px auto;
				outline: none;
				width: 350px;
				border: 2px solid red;
				border-radius: 5px;
				transition: 0.25s;
				text-align:center;
			}
			#mian_form input[type='text']:focus,
			#mian_form input[type='passWord']:focus
			{
				width: 400px;
				border: 2px solid #CF980E;
			}
		</style>
		<script type="text/javascript">
			$(function(){
				$("#mian_input04").click(function(){
					var phone = $("#mian_input01").val();
					var regPhone=/^1\d{10}$/;
					if(regPhone.test(phone)){
						$("#main_div_span02").css("color","#FF4C4C");
						$("#mian_input01").hide();
						$("#mian_input02").show();
						$("#mian_input03").show();
						
						var name = $("#mian_input02").val();
						var regName=/^[0-9a-zA-Z]{4,16}$/;						
						var password = $("#mian_input03").val();
						var regPassword=/^[a-zA-Z]\w{5,17}$/;
						if(regName.test(name)&&regPassword.test(password)){
							$("#main_div_span03").css("color","#FF4C4C");		
							$("#mian_input02").hide();
							$("#mian_input03").hide();
							$("#s1").show();
							$("#mian_form").submit();
						}
					}
				});
			});
				
			
			$(document).ready(function(){
				$("#mian_input01").blur(function(){
					var phone = $(this).val();
					var newPhone = $("#mian_input01_h2");
					var regPhone=/^1\d{10}$/;
					if(regPhone.test(phone)==false){
						newPhone.html("手机号码格式错误，请重新输入！");
						return false;
					}else{
						var data="phone="+phone;
						$.get("RegisterServlet?i=3",data,function(rel){
							if(rel>"0"){
							newPhone.html("该手机号已被注册");
							}else{
							newPhone.html("");
							}
						},"text");
					}
					newPhone.html("");
					return true;
				});
				
				$("#mian_input02").blur(function(){
					var name = $(this).val();
					var newName = $("#mian_input02_h2");
					var regName=/^[0-9a-zA-Z]{4,16}$/;
					if(regName.test(name)==false){
						newName.html("用户名格式错误，请重新输入！");
						return false;
					}else{
						var data="userName="+name;
						$.get("RegisterServlet?i=2",data,function(rel){
							if(rel>"0"){
								newName.html("该用户名已存在");
							}else{
								newPhone.html("");
							}
						},"text");
					}
					newName.html("");
					return true;
				});
				
				$("#mian_input03").blur(function(){
					var password = $(this).val();
					var newPassword = $("#mian_input03_h2");
					var regPassword =/^[a-zA-Z]\w{5,17}$/;
					if(regPassword.test(password)==false){
						newPassword.html("密码格式错误，请重新输入！");
						return false;
					}
					newPassword.html("");
					return true;
				});
				
				
			});
			
			
		</script>
	</head>
	<body>
		<!--头部-->
		<div id="header_bottom">
			<div id="header">
				<img src="img/register_01.png"/>
				<p>我已经注册，现在就<a href="login.jsp">登录</a></p>
			</div>
		</div>
		
		
		<!--主体-->
		<div id="main">
			<div id="main_div">
				<div id="main_div_span">
					<span id="main_div_span01">①</span> <span id="main_div_span02"
					<c:if test="${info!=null }">
						style="color:red;"
					</c:if>
					>———②</span> <span id="main_div_span03"
					<c:if test="${info!=null }">
						style="color:red;"
					</c:if>
					>———③</span>
				</div>
				
				<form id="mian_form" action="RegisterServlet?i=1" method="post">
					<input id="mian_input01" type="text" name="phone" value="" placeholder="请输入手机号码"
					<c:if test="${info!=null }">
						style="display: none;"
					</c:if>
					/><p id="mian_input01_h2" style="text-align: center;color: red;"></p>
					<input id="mian_input02" style="display: none;" type="text" name="userName" value="" placeholder="请输入用户名"/><p id="mian_input02_h2" style="text-align: center;color: red;"></p>
					<input id="mian_input03" style="display: none;" type="password" name="userPassword" value="" placeholder="请输入密码"/><p id="mian_input03_h2" style="text-align: center;color: red;"></p>
					<input id="mian_input04" type="button"  value="下 一 步"
					<c:if test="${info!=null }">
						style="display: none;"
					</c:if>
					/>
				</form>		
				<h1 id="s1" style=" text-align: center; padding-top: 100px;" >${info}${err}${nameErr}${phoneErr}</h1>
			</div>
		</div>
		
		
		<!--尾部-->
		<div id="footer">
			<ul id="footer_top">
				<li><a href="#">国美集团</a></li>
				<li><a href="#">国美管家</a></li>
				<li><a href="#">关于国美</a></li>
				<li><a href="#">加入我们</a></li>
				<li><a href="#">品牌大全</a></li>
				<li>|</li>
				<li><a href="#">商品专题</a></li>
				<li><a href="#">商品词</a></li>
				<li><a href="#">热词搜索</a></li>
				<li><a href="#">友情链接</a></li>
				<li><a href="#">风险监测</a></li>
				<li>|</li>
				<li><a href="#">销售联盟</a></li>
				<li><a href="#">商家入驻</a></li>
				<li><a href="#">广告营销</a></li>
			</ul>
			
			<p>本公司游戏产品适合18岁以上成年人使用  违法和不良信息举报电话：021-39900132  互联网药品信息服务资格证编号（沪）-经营性-2019-0006</p>
			<p>网络食品销售第三方平台提供者备案：沪网食备A0015号  网络文化经营许可证沪网文[2017]5537-436号  增值电信业务经营许可证</p>
			<p>客服电话:4008113333  沪ICP备11009419号/京ICP备 19011786号  京B2-20191290  经营执照  营业执照  出版物经营许可证</p>
			<p>©2000-2019  国美在线电子商务有限公司版权所有  京公网安备 11010502038379号</p>
			
			<ul id="footer_bottom">
				<li><img src="img/login_07.png"/>经营性网站<br/>备案信息</li>
				<li><img src="img/login_08.png"/>可信网站<br/>信用评价</li>
				<li><img src="img/login_09.png"/>诚信网站</li>
				<li><img src="img/login_10.png"/>朝阳网络<br/>警察</li>
				<li><img src="img/login_11.png"/>网购大家评</li>
				<li><img src="img/login_12.png"/>上海市互联网违法和<br/>不良信息举报中心</li>
			</ul>
		</div>
	</body>
</html>
