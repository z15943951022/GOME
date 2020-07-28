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
		<link rel="stylesheet" type="text/css" href="<%=path %>/myCentrality/css/page_right.css"/>
		<link rel="stylesheet" type="text/css" href="<%=path %>/myCentrality/css/page_address.css"/>
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
				<ul class="dingdan">
					<li><a href="#">收货人</a></li>
					<li><a href="#">收获地址</a></li>
					<li><a href="#">电话</a></li>
					<li><a href="#">邮箱</a></li>
					<li><a href="#">操作</a></li>
				</ul>
				<div id="myaddressInfo">
				</div>
				<h3 id="addAddr" onclick="hid()">添加地址</h3>
				<h3 id="addAddr2" style="display: none;">修改地址</h3>
				<input type="hidden" name="userId" id="userId" value="${user.userId }" />
				<form action="#" method="post" id="addrFrom" style="display: none;">
					<p id="addTitle">配送上门</p>
				<table border="" cellspacing="" cellpadding="" id="address">
					<tr>
						<td>*收货人:</td>
						<td>
							<input type="text" name="consignee" id="consignee" value="" maxlength="5"  /><span></span>
						</td>
					</tr>
					<tr>
						<td>*所在地区:</td>
						<td>
							<input type="text" name="" id="" value="" style="width: 350px; height: 30px;" readonly="readonly" /><span>暂不可用</span>
						</td>
					</tr>
					<tr>
						<td>*详细地址:</td>
						<td>
							<input type="text" name="addressDetail" id="addressDetail" value="" /><span></span>
						</td>
					</tr>
					<tr>
						<td>手机号码:</td>
						<td>
							<input type="text" name="phone" id="phone" value=""   /><span></span>
							固定电话：<input type="text" name="sex" id="nv" value="" readonly="readonly" /><span>暂不可用</span>
						</td>
					</tr>
					<tr>
						<td>邮箱:</td>
						<td>
							<input type="email" name="" id="" value="" readonly="readonly" /><span>暂不可用</span>
						</td>
					</tr>
					<tr>
						<td></td>
						<td>
							<input type="checkbox" name="defaultBoolean" id="default" value=""  /><label for="default">设置默认地址</label>
							<input type="checkbox" name="" id="kuaisu" value=""  /><label for="kuaisu">设置快速购</label>
						</td>
					</tr>
					<tr>
						<td></td>
						<td>
							<input type="button" name="" id="butSubmit" value="保存收货人地址" /><a href="#" onclick="return hid()">取消</a>
						</td>
					</tr>
				</table>
				</form>
				
				<form action="#" method="post" id="updaterFrom" style="display: none;">
					<p id="addTitle">配送上门</p>
					<input type="hidden" name="userId" id="userId" value="2" />
					<input type="hidden" name="addressId" id="addressId" value="-1"  />
				<table border="" cellspacing="" cellpadding="" id="address">
					<tr>
						<td>*收货人:</td>
						<td>
							<input type="text" name="consignee" id="consignee2" value="" maxlength="5"  /><span></span>
						</td>
					</tr>
					<tr>
						<td>*所在地区:</td>
						<td>
							<input type="text" name="" id="" value="" style="width: 350px; height: 30px;" readonly="readonly" /><span>暂不可用</span>
						</td>
					</tr>
					<tr>
						<td>*详细地址:</td>
						<td>
							<input type="text" name="addressDetail" id="addressDetail2" value="" /><span></span>
						</td>
					</tr>
					<tr>
						<td>手机号码:</td>
						<td>
							<input type="text" name="phone" id="phone2" value=""   /><span></span>
							固定电话：<input type="text" name="sex" id="nv" value="" readonly="readonly" /><span>暂不可用</span>
						</td>
					</tr>
					<tr>
						<td>邮箱:</td>
						<td>
							<input type="email" name="" id="" value="" readonly="readonly" /><span>暂不可用</span>
						</td>
					</tr>
					<tr>
						<td></td>
						<td>
							<input type="checkbox" name="defaultBoolean" id="default2" value=""   /><label for="default2">设置默认地址</label>
							<input type="checkbox" name="" id="kuaisu2" value=""  /><label for="kuaisu2">设置快速购</label>
						</td>
					</tr>
					<tr>
						<td></td>
						<td>
							<input type="button" name="" id="butSubmit2" value="保存收货人地址" /><a href="#" onclick=" return end()" >取消</a>
						</td>
					</tr>
				</table>
				</form>
			</div>
		</div>
		<!--底部  -->
		<jsp:include page="/common/footer.jsp"></jsp:include>
			<script src="<%=basePath %>js/jquery-1.12.4.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
		/*加载开始  */
			jQuery(document).ready(function(){
					getAddress();
					
				/*验证提交添加  */
				$("#butSubmit").click(function(){
					var name=$("#consignee");
					var address=$("#addressDetail");
					var phone=$("#phone");
					if(testName(name)&testAddress(address)&testPhone(phone)){
						add();
					}
				});
				
				/*验证提交修改  */
				$("#butSubmit2").click(function(){
					var name=$("#consignee2");
					var address=$("#addressDetail2");
					var phone=$("#phone2");
					if(testName(name)&testAddress(address)&testPhone(phone)){
						update();
					}
				});
					
				/*收货人判断  */
				$("#consignee").blur(function(){
					testName($(this));
				});
				/*收获地址判断  */
				$("#addressDetail").blur(function(){
					testAddress($(this));
				});
				/*手机号判断  */
				$("#phone").blur(function(){
					testPhone($(this));
				});
					
			});
			/*加载结束  */
				
					
		
			
			/*判断用户名 */
			function testName(obj){
				if(obj.val()==""){
					obj.next().text("用户名不能为空");
					return false;
				}else{
					obj.next().text("");
				}
				return true;
			}
			
			/*判断收货地址 */
			function testAddress(obj){
				if(obj.val()==""){
					obj.next().text("收获地址不能为空");
					return false;
				}else{
					obj.next().text("");
				}
				return true;
			}
			/*判断手机号 */
			function testPhone(obj){
				var t=/^[0-9]{11}$/;
				if(obj.val()==""){
					obj.next().text("手机号不能为空");
					return false;
				}else if(!t.test(obj.val())){
					obj.next().text("手机号不正确");
					return false;
				}else{
					obj.next().text("");
				}
				return true;
			}
			
			/*添加地址  */
			function add(){
				var data="";
				data+="consignee="+$("#consignee").val();
				data+="&addressDetail="+$("#addressDetail").val();
				data+="&phone="+$("#phone").val();
				data+="&userId="+$("#userId").val();
				var defaultBoolean=$("#defaultBoolean")
				.attr("checked")==true?0:1;
				data+="&defaultBoolean="+defaultBoolean;
				$.post("UserAddressServlet?i=1",data,function(rel){
					if(rel>"0"){
						alert("添加成功！");
						getAddress();
					}else{
						alert("添加失败");
					}
				},"text");
			}
			
			
			/*修改地址 */
			function update(){
				var data="";
				data+="addressId="+$("#addressId").val();
				data+="&consignee="+$("#consignee2").val();
				data+="&addressDetail="+$("#addressDetail2").val();
				data+="&phone="+$("#phone2").val();
				data+="&userId="+$("#userId").val();
				var defaultBoolean=$("#defaultBoolean2")
				.attr("checked")==true?0:1;
				data+="&defaultBoolean="+defaultBoolean;
				$.post("UserAddressServlet?i=5",data,function(rel){
					if(rel>0){
						alert("修改成功！");
						getAddress();
					}else{
						alert("修改失败");
					}
				},"text");
			}
			
			/*获取用户所有地址  */
			function getAddress(){
				var data="";
				data+="userId="+$("#userId").val();
				$.get("UserAddressServlet?i=2",data,function(rel){
					$("#myaddressInfo").html("");
					if(rel!=""){
						for(var i=0;i<rel.length;i++){
							var str="<ul class='address' id='a"+rel[i].addressId+"' onmouseenter='mover(this)' onmouseleave='mout(this)' >";
							str+="<li style='width: 50px;overflow: hidden;'>✔<span>"+rel[i].consignee+"</span></li>";
							str+="<li>"+rel[i].addressDetail+"</li>";
							str+="<li>"+rel[i].phone+"</li>";
							str+="<li>暂无邮箱</li>";
							str+="<li><a href='#'>使用快速购</a><a href='javascript:onclick="+"findAddress("+rel[i].addressId+");"+"'>修改</a><a href='javascript:onclick="+"delAddress("+rel[i].addressId+");"+"'>删除</a></li>";
							str+="</ul>";
							$("#myaddressInfo").append(str);
						}
					}                     
				},"json");
			}
			
			/*删除地址  */
			function delAddress(obj){
			if(confirm("是否删除此条地址")){
				var data="addressId="+obj;
					 $.get("UserAddressServlet?i=3",data,function(rel){
						if(rel>"0"){
							alert("删除成功！");
							getAddress();
						}else{
							alert("删除失败");
						}
					},"text"); 
					return false;
				}
				return false;
			}
			
			/*查询一个地址 */
			function findAddress(obj){
				data="addressId="+obj;
				$.post("UserAddressServlet?i=4",data,function(rel){
					$("#addressId").val(rel.addressId);
					$("#consignee2").val(rel.consignee);
					$("#addressDetail2").val(rel.addressDetail);
					$("#phone2").val(rel.phone);
					$("#addAddr").hide();
					$("#addAddr2").show();
					if(rel.defaultBoolean=="1"){
						$("#default2").attr("checked","true");
					}
					$("#addrFrom").hide();
					$("#updaterFrom").show();
				},"json");
			}
			
			/*取消修改地址  */
			function end(){
				$("#addAddr").show();
				$("#addAddr2").hide();
				$("#updaterFrom").hide();
				return false;
			}
			/*表单隐藏动画  */
			function hid(){
				$("#addrFrom").slideToggle("slow");
				return false;
			}
			
			
			/*鼠标悬浮事件  */
			function mover(obj){
				$(obj).css("background-color","#F6F6F6");
			}
			function mout(obj){
				$(obj).css("background-color","#FFF5D1");
			}
		</script>
	</body>
</html>
