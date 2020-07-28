<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>商品列表</title>
    <meta charset="utf-8" />
	
	<script type="text/javascript" src="js/jquery-1.12.4.js" ></script>
	<link rel="stylesheet" type="text/css" href="css/gmShouyeStyle.css"/>
	<script type="text/javascript" src="js/gmShouye.js"></script>
	

  </head>
  
  <body>
  	<jsp:include page="common/header.jsp"></jsp:include>
	<jsp:include page="common/headNav.jsp"></jsp:include>
	<section >
			<div id="meiri">
	<input type="hidden" id="curPage" value="0" />
	<div id="biqiang" >
		主题
	</div>
		</div>
	</section>
	
	<jsp:include page="common/footer.jsp"></jsp:include>
    <script type="text/javascript">
    	$(function(){
    		getProductsPaging();
    	});
    	function getProductsPaging(){
				
				var data="opt=getProductsPaging";
				data+="&curPage="+eval($("#curPage").val()+"+"+1);
				 if($("#title").val()!=null){
					data+="&title="+$("#title").val();
				} 
				//先清空
				$("#biqiang").html("");
				//保存头部
				var strH3="<h3 ><img src='img/T1ovZvBTbb1RCvBVdK.jpeg' /> 每日必抢";
				strH3+="<input type='button' value='换一批' onclick='getProductsPaging();' /></h3>";
				
				var strDiv="";
				
				$.post("ProductDetailServlet",data,function(jsonStr){
					//alert(jsonStr);
					var relData=jsonStr.dataList;
					//alert(relData);
					//页面记录
					$("#curPage").val(jsonStr.pageIndex);
					
					 for(var i=0;i<relData.length;i++){
					 
						//循环拼接div串
						strDiv+="<div><a href='ProductDetailServlet?opt=goProductDetail&productId="+relData[i].productId+"'>"+
						"<img height='120px' width='120px' src='upload/"+relData[i].picPath+"'  />"+
						"<p>￥"+relData[i].sellingPrice+" <span>￥"+relData[i].price+"</span></p><p>"+relData[i].title+"</p></a></div>";
						/* if(i==3){
							break;
						}  */ 
					}
					//alert(strDiv);
					//添加
					$("#biqiang").html(strH3+strDiv); 
				},"json"); 
			}
    </script>
  </body>
</html>
