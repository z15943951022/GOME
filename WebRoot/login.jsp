<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<base href="<%=basePath%>">
		<link rel="stylesheet" type="text/css" href="<%=path %>/css/login.css"/>
		
	</head>
	<body>
		<!--头部-->
		<div id="header">
			<img src="img/login_01.jpg"/>
		</div>
		
		<!--主体-->
		<div id="main_periphery">
			<div id="main">
				<div id="main_top">
					依据《网络安全法》，为保障您的账户安全和正常使用，请尽快完成手机号验证！新版<a href="#">《国美隐私政策》</a>已上线，将更有利于保护您的个人隐私。
				</div>	
				<div><img src="img/login_02.jpg"/></div>
				
				<div id="main_form">
					<form action="UserServlet?i=1" method="post">
						<div id="main_form_div01">账 户 登 录</div>
						<div id="main_form_div02"><input class="s1" type="text" name="userName"  value="" placeholder=" 手机号码/用户名/邮箱/门店会员卡号"/><br/><span id="main_form_div02_span" style="color: red;"></span></div>
						<div id="main_form_div03"><input class="s1" type="password" name="passWord" value="" placeholder="密码"/><br/><span id="main_form_div03_span" style="color: red"></div>
						<div id="main_form_div04"><input type="checkbox" />自动登录&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;<a href="#">忘记密码</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;<a href="register.jsp">免费注册</a></div>						
						<div id="main_form_div05"><input type="submit"  value="登 录"  /></div>
						<div id="main_form_div06"><a href="">手机号快速登录（支持门店预留电话）</a></div>
						<div id="main_form_div07">
							<a href="#"><img src="img/login_03.jpg"/></a>
							<a href="#"><img src="img/login_04.jpg"/></a>
							<a href="#"><img src="img/login_05.jpg"/></a>
							<a href="#"><img src="img/login_06.jpg"/></a>
						</div>			
					</form>
				</div>
			</div>
		</div>
		
		
		<!--尾部-->
		<div id="footer" style="font-size:12px;">
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
		<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
		<script type="text/javascript">
		/*文档加载开始  */
		$(document).ready(function(){
			/* 用户名失去焦点判断 */
			$("#main_form_div02>input").blur(function(){
				testName($(this));
			});
			/*密码失去焦点判断  */
			$("#main_form_div03>input").blur(function(){
				testPassWord($(this));
			});
			/*登陆验证  */
			$("#main_form_div05").click(function(){
			if(testName($("#main_form_div02>input"))&testPassWord($("#main_form_div03>input"))){
				return true;
			}else{
				return false;
			}
			});
		});
		/*文档加载结束  */
		/*判断用户名  */
		function testName(obj){
			var name = obj.val();
			var newName = $("#main_form_div02_span");
			var regName =/^[0-9a-zA-Z]{4,16}$/;
			var regPhone=/^1\d{10}$/;
			if((regName.test(name)==false) & (regPhone.test(name)==false)){
				newName.html("用户名错误，请重新输入！");
				return false;
			}
			newName.html("");
			return true;
		}
		
		/*判断密码  */
		function testPassWord(obj){
		var pwd = obj.val();
			var newPwd = $("#main_form_div03_span");
			var regPwd =/^[a-zA-Z]\w{5,17}$/;	
			if(regPwd.test(pwd)==false){
				newPwd.html("密码错误，请重新输入！");
				return false;
			}
			newPwd.html("");
			return true;
		}
		</script>
	</body>
</html>

