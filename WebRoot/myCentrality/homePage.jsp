<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>我的国美</title>
		<link rel="stylesheet" type="text/css" href="css/reset.css"/>
		<link rel="stylesheet" type="text/css" href="css/page_section.css"/>
		<link rel="stylesheet" type="text/css" href="css/page_mid.css"/>
		<link rel="stylesheet" type="text/css" href="css/page_right.css"/>
		<style type="text/css">
		</style>
	</head>
	<body style="background-color: #F6F6F6;" >
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
			<div id="mid">
					<div id="top">
						<div id="rt"></div>
						<div id="rb"></div>
						<div id="m_left">
							<div id="photo"><img src="<%=path %>/upload/${user.picPath}"/></div>
							<ul>
								<li><a href=""></a>${user.userPetName }</li>
								<li><a href=""></a>G15大会员</li>
								<li><a href="">申请达人</a></li>
							</ul>
							<p>资料完成度<a href="myCentrality/MyInfo.jsp"><img src="<%=path %>/myCentrality/img/tiao.png"/>&nbsp;完善</a><br />账户安全<a href="myCentrality/MySafe.jsp"><img src="<%=path %>/myCentrality/img/a2.png"/> 提升</a></p>
						</div>
						<div id="m_right"> 
							<div id="mymoney"><hr /><p><img id="a" src="<%=path %>/myCentrality/img/ass.png"/>我的资产</p><hr /> </div>
							<div id="tit">为保障您的资金安全，在开通资产后，请 <a href="">设置支付密码</a></div>
							<table border="0" cellspacing="0" cellpadding="" id="tab">
								<tr><td colspan="2">美国币余额:${user.money }</td></tr>
								<tr>
									<td>返利</td>
									<td>优惠卷</td>
								</tr>
								<tr>
									<td>待入账</td>
									<td>美豆</td>
								</tr>
								<tr>
									<td>已失效</td>
									<td>美通卡</td>
								</tr>
							</table>
						</div>
					</div>
					<div id="mid_mid">
						<ul>
							<li>近三个月订单</li>
							<li><a href="">待付款 0</a></li>
							<li><a href="">待收货 0</a></li>
							<li><a href="">待评价晒单 0</a></li>
							<li><a href="">查看更多订单</a></li>
						</ul>
						<hr />
						<p>您还又有订单记录, 快<a href="">去逛逛</a>吧</p>
					</div>
					<div id="mid_mb">
						<ul class="titl">
							<li>热门圈子</li>
							<li>我创建的圈子</li>
							<li>我加入的圈子</li>
						</ul>
						<ul id="nav">
							<li><a href="">
								<img src="<%=path %>/myCentrality/img/T1cGLTBvAT1RXrhCrK.jpg.100x100cTzq80(2).jpg"/><br />
								<span>家具设计馆</span>
							</a>
							</li>
							<li><a href="">
								<img src="<%=path %>/myCentrality/img/T1LECsBbAT1RCvBVdK.jpg.100x100cTzq80.jpg"/><br />
								<span>数码家</span>
							</a>
							</li>
							<li><a href="">
								<img src="<%=path %>/myCentrality/img/T1RSCjBjZv1RCvBVdK.jpg.100x100cTzq80(2).jpg"/><br />
								<span>时尚家</span>
								</a>
							</li>
							<li><a href="">
								<img src="<%=path %>/myCentrality/img/T17T_QBsEv1RCvBVdK.jpg.100x100cTzq80.jpg"/><br />
								<span>智享家</span>
								</a>
							</li>
							<li><a href="">
								<img src="<%=path %>/myCentrality/img/T1uTYQBbYT1RCvBVdK.jpg.100x100cTzq80.jpg"/><br />
								<span>美食家</span>
							</a>
							</li>
							<li><a href="">
								<img src="<%=path %>/myCentrality/img/T1RkAjBTxv1RCvBVdK.jpg.100x100cTzq80(2).jpg"/><br />
								<span>育儿家</span>
							</a>
							</li>
						</ul>
					</div>
					<div id="mid_bot">
						<ul class="titl">
							<li>热门话题</li>
							<li>我发布的话题</li>
							<li>我收藏的话题</li>
						</ul>
						<div class="news">
							<img class="nimg" src="<%=path %>/myCentrality/img/T1S4_XBmEv1RCvBVdK.jpg.230zq80(2).jpg"/>
							<a href="">给心情一份洁净，摩飞吸尘器随时随地赶走灰尘</a>
							<p class="love" ><img src="<%=path %>/myCentrality/img/love.png"/>135</p>
							<p class="love"><img src="<%=path %>/myCentrality/img/discuss.png"  />0</p>
							<p>整洁干净的环境会给我们带来好心情，心情好让工作和学习的效...</p>
						</div>
						<div class="news">
							<img class="nimg" src="<%=path %>/myCentrality/img/T1OiJsBsZT1RCvBVdK.jpg.230zq80(4).jpg"/>
							<a href="">给心情一份洁净，摩飞吸尘器随时随地赶走灰尘</a>
							<p class="love" ><img src="<%=path %>/myCentrality/img/love.png"/>135</p>
							<p class="love"><img src="<%=path %>/myCentrality/img/discuss.png"  />0</p>
							<p>整洁干净的环境会给我们带来好心情，心情好让工作和学习的效...</p>
						</div>
						<div class="news">
							<img class="nimg" src="<%=path %>/myCentrality/img/T1OiJsBsZT1RCvBVdK.jpg.230zq80(4).jpg"/>
							<a href="">给心情一份洁净，摩飞吸尘器随时随地赶走灰尘</a>
							<p class="love" ><img src="<%=path %>/myCentrality/img/love.png"/>135</p>
							<p class="love"><img src="<%=path %>/myCentrality/img/discuss.png"  />0</p>
							<p>整洁干净的环境会给我们带来好心情，心情好让工作和学习的效...</p>
						</div>
						<div class="news">
							<img class="nimg" src="<%=path %>/myCentrality/img/T1S4_XBmEv1RCvBVdK.jpg.230zq80(2).jpg"/>
							<a href="">给心情一份洁净，摩飞吸尘器随时随地赶走灰尘</a>
							<p class="love" ><img src="<%=path %>/myCentrality/img/love.png"/>135</p>
							<p class="love"><img src="<%=path %>/myCentrality/img/discuss.png"  />0</p>
							<p>整洁干净的环境会给我们带来好心情，心情好让工作和学习的效...</p>
						</div>
						<div class="news">
							<img class="nimg" src="<%=path %>/myCentrality/img/T1OiJsBsZT1RCvBVdK.jpg.230zq80(4).jpg"/>
							<a href="">给心情一份洁净，摩飞吸尘器随时随地赶走灰尘</a>
							<p class="love" ><img src="<%=path %>/myCentrality/img/love.png"/>135</p>
							<p class="love"><img src="<%=path %>/myCentrality/img/discuss.png"  />0</p>
							<p>整洁干净的环境会给我们带来好心情，心情好让工作和学习的效...</p>
						</div>
						<div class="news">
							<img class="nimg" src="<%=path %>/myCentrality/img/T1OiJsBsZT1RCvBVdK.jpg.230zq80(4).jpg"/>
							<a href="">给心情一份洁净，摩飞吸尘器随时随地赶走灰尘</a>
							<p class="love" ><img src="<%=path %>/myCentrality/img/love.png"/>135</p>
							<p class="love"><img src="<%=path %>/myCentrality/img/discuss.png"  />0</p>
							<p>整洁干净的环境会给我们带来好心情，心情好让工作和学习的效...</p>
						</div>
						<div class="news">
							<img class="nimg" src="<%=path %>/myCentrality/img/T1S4_XBmEv1RCvBVdK.jpg.230zq80(2).jpg"/>
							<a href="">给心情一份洁净，摩飞吸尘器随时随地赶走灰尘</a>
							<p class="love" ><img src="<%=path %>/myCentrality/img/love.png"/>135</p>
							<p class="love"><img src="<%=path %>/myCentrality/img/discuss.png"  />0</p>
							<p>整洁干净的环境会给我们带来好心情，心情好让工作和学习的效...</p>
						</div>
						<div class="news">
							<img class="nimg" src="<%=path %>/myCentrality/img/T1S4_XBmEv1RCvBVdK.jpg.230zq80(2).jpg"/>
							<a href="">给心情一份洁净，摩飞吸尘器随时随地赶走灰尘</a>
							<p class="love" ><img src="<%=path %>/myCentrality/img/love.png"/>135</p>
							<p class="love"><img src="<%=path %>/myCentrality/img/discuss.png"  />0</p>
							<p>整洁干净的环境会给我们带来好心情，心情好让工作和学习的效...</p>
						</div>
					</div>
				</div>
				<div id="right">
					<div id="right_top">
					<p>我的优惠卷 查看全部</p>
					<div class="bulejuan">
						<div class="by1"></div>
						<div class="by2"></div>
						<div class="by3"></div>
						<div class="by4"></div>
						<div class="by5"></div>
						<div class="by6"></div>
						<p><span>￥</span>50.00</p>
						<p>———.———</p>
						<p>蓝卷</p>
						<div class="lj">立即使用</div>
					</div>
					<div class="bulejuan">
						<div class="by1"></div>
						<div class="by2"></div>
						<div class="by3"></div>
						<div class="by4"></div>
						<div class="by5"></div>
						<div class="by6"></div>
						<p><span>￥</span>30.00</p>
						<p>———.———</p>
						<p>蓝卷</p>
						<div class="lj">立即使用</div>
					</div>
					<div class="bulejuan">
						<div class="by1"></div>
						<div class="by2"></div>
						<div class="by3"></div>
						<div class="by4"></div>
						<div class="by5"></div>
						<div class="by6"></div>
						<p><span>￥</span>50.00</p>
						<p>———.———</p>
						<p>蓝卷</p>
						<div class="lj">立即使用</div>
					</div>
					<div class="bulejuan">
						<div class="by1"></div>
						<div class="by2"></div>
						<div class="by3"></div>
						<div class="by4"></div>
						<div class="by5"></div>
						<div class="by6"></div>
						<p><span>￥</span>100.00</p>
						<p>———.———</p>
						<p>蓝卷</p>
						<div class="lj">立即使用</div>
					</div>
					<div class="bulejuan">
						<div class="by1"></div>
						<div class="by2"></div>
						<div class="by3"></div>
						<div class="by4"></div>
						<div class="by5"></div>
						<div class="by6"></div>
						<p><span>￥</span>10.00</p>
						<p>———.———</p>
						<p>蓝卷</p>
						<div class="lj">立即使用</div>
					</div>
					<div class="bulejuan">
						<div class="by1"></div>
						<div class="by2"></div>
						<div class="by3"></div>
						<div class="by4"></div>
						<div class="by5"></div>
						<div class="by6"></div>
						<p><span>￥</span>20.00</p>
						<p>———.———</p>
						<p>蓝卷</p>
						<div class="lj">立即使用</div>
					</div>
				</div>
					<div id="right_mid">
						<p>会员推荐 会员俱乐部 </p>
						<img src="<%=path %>/myCentrality/img/T1Y7DbBvKT1RCvBVdK.jpg"/>
					</div>
					<div id="right_bot">
						<p>便民服务</p>
						<hr />
						<a href=""><img src="<%=path %>/myCentrality/img/shouji.png"/> <span>充值</span> </a>
						<a href=""><img src="<%=path %>/myCentrality/img/youxi.png"/> <span>游戏</span> </a>
						<hr />
						<table>
							<tr>
								<td colspan="2">
									<span id="bo1" style="padding-bottom: 7px;">花费充值</span>
									<span id="bo2" style="padding-bottom: 7px;">流量充值</span>
								 </td>
							</tr>
							<tr>
								<td colspan="2" style="display: flex;">
									<span class="titl" >号码 </span><input type="text" name="" id="" value="" />
								</td>
							</tr>
							<tr>
								
								<td colspan="2" style="display: flex;" >
							<span class="titl">面值 </span><select name="" >
										<option >请选择</option>
										<option >10元</option>
										<option >20元</option>
										<option >30元</option>
										<option >100元</option>
										<option >200元</option>
										<option >300元</option>
										<option >500元</option>
									</select>
								</td>
							</tr>
							<tr>
								<td colspan="2" id="tit3">
									<p>售价 <span>￥99.8-100</span></p>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<input type="button" name="" id="" value="立即充值" />
									<a href="">充话费,充流量天天低价</a>
								</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		<!--底部  -->
		<jsp:include page="/common/footer.jsp"></jsp:include>
			<script src="<%=basePath %>js/jquery-1.12.4.js" type="text/javascript" charset="utf-8"></script>
			<script src="<%=basePath %>js/js_header.js" type="text/javascript" charset="utf-8"></script>
			<script src="<%=basePath %>js/hidnav.js" type="text/javascript" charset="utf-8"></script>
	</body>
			
</html>
