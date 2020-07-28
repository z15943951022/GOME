<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
	  <base href="<%=path%>">
		<meta charset="UTF-8">
		<title></title>
		
		<link rel="stylesheet" type="text/css" href="<%=path %>/css/page_footer.css"/>
	</head>
	<body>
		<footer>
			<div id="fot_mid">
				<div id="fot_left">
					<div id="fot_top">
					<div id="fot_rt">
						<ul>
							<li>
								<img src="img/lou.png"/>
								<p>
									<span>门店服务</span>
									<span>国美门店全国共计2000余家</span>
								</p>
							</li>
							<li>
								<img src="img/shou.png"/>
								<p>
									<span>用户体验</span>
									<span>参与用户体验改进计划 用户反馈</span>
								</p>
							</li>
						</ul>
					</div>
					<div id="fot_rm">
						<ul>
							<li>国美集团</li>
							<li>国美管家</li>
							<li>关于国美</li>
							<li>加入我们</li>
							<li>品牌大全</li>
							<li>商品专题</li>
							<li>商品词</li>
							<li>热词搜索</li>
							<li>友情链接</li>
							<li>风险监测</li>
							<li>销售联盟</li>
							<li>商家入驻</li>
							<li>广告营销</li>
						</ul>
						<p>
							本公司游戏产品适合18岁以上成年人使用  违法和不良信息举报电话：021-39900132  互联网药品信息服务资格证编号（沪）-经营性-2019-0006
							网络食品销售第三方平台提供者备案：沪网食备A0015号  网络文化经营许可证沪网文[2017]5537-436号  增值电信业务经营许可证
							客服电话:4008113333  沪ICP备11009419号/京ICP备 19011786号  京B2-20191290  经营执照  营业执照  出版物经营许可证
							©2000-2019  国美在线电子商务有限公司版权所有  京公网安备 11010502038379号
						</p>
					</div>
				</div>
					
				</div>
				<div id="fot_right">
					<ul>
						<li><img src="img/weixin.png"/><span>公众号</span></li>
						<li><img src="img/wifi.png"/><span>手机站点</span></li>
						<li><img src="img/phoneerwei.png"/></li>
					</ul>
				</div>
			</div>
			<div id="fot_bot">
						<ul>
							<li><img src="img/jinghui.png"/><p>经营性网站备案信息</p></li>
							<li><img src="img/hua.png"/><p>可信网站信用评价</p></li>
							<li><img src="img/xin.png"/><p>诚信网站</p></li>
							<li><img src="img/jingcha.png"/><p>朝阳网络警察</p></li>
							<li><img src="img/wanggou.png"/><p>网购大家评</p></li>
							<li><img src="img/youjian.png"/><p>上海市互联网违法和不良信息举报中心</p></li>
						</ul>
					</div>
		</footer>
	</body>
</html>

