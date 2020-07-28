		
		$(function() {
			find();
			$("#aaa").click(function deletea() {
				var data = "opt=delNews&buycarid=3";
				$.post("BuyCarServlet", data, function(rel) {
					if (rel > 0) {
						alert("删除成功");
					} else {
						alert("删除失败");
					}
		
				}, "text");
				return false;
			});
		
		});
		
		/* //加 */
		function addCount(obj) {
			var t = $(obj).siblings(".text_box").val();// prev
			t++;
			$(obj).siblings(".text_box").val(t);
			getASum($(obj).parent());
		
			getSum();
		};
		/* //减 */
		function minus(obj) {
			var t = $(obj).siblings(".text_box").val();
			if (t == 1) {
				return false;
			}
			t--;
			$(obj).siblings(".text_box").val(t);
			getASum($(obj).parent());
			getSum();
		};
		/* //小计 */
		function getASum(obj) {
			obj.next().children().text(
					"￥"
							+ ($(obj).prev().find("span").text() * obj
									.find(".text_box").val()).toFixed(2));
		}
		
		/* //计算总计和总额 */
		function getSum() {
			var count = 0;
			var money = 0;
			$(".text_box").each(function(i, ele) {
				count += parseInt($(ele).val());
			});
			$("#gome-foot1 span:nth-child(1)").text(count);
		
			$(".price").each(function(i, ele) {
				money += parseFloat($(ele).text().substr(1));
				$("#priceSum").text("￥" + money);
			});
			$("#gome-foot1 span:nth-child(2)").text(money.toFixed(2));
		}
		
		function find() {
			var data = "opt=find&userid="+${user.userId };
			$.post("BuyCarServlet",data,function(rel) {
								var str = "";
								var sumCount = 0;
								var sumPrice = 0;
								for (var i = 0; i < rel.length; i++) {
									str += "<div><input id='check1' type='checkbox' name='productId' value='"
											+ rel[i].productId
											+ "'/><a href='#'>SuperClass旗舰店</a><a href='#'><img src='img/3.jpg'></a>  </div>";
									str += "<div class='div2'>";
									str += "<ul>";
									str += "<li id='ll1'><input class='good1'  type='checkbox' name='choose2' value=''/></li>";
									str += "<li><img style='width: 103px;height: 103px;' src='img/"
											+ rel[i].picPath + "' /></li>";
									str += "<li id='ll2' style='width: 218px;'>"
											+ rel[i].title + "</li>";
									str += "<li id='ll3'><img src='img/1.jpg' /> </li>";
									str += "<li>";
									str += "<ul id='dd2'>";
									str += "<li>" + rel[i].productAttr + "</li>";
									str += "<li><a href='#'>修改</a></li>";
									str += "</ul>";
									str += "</li>";
									str += "<li class='cc2 c2' style='width:60px;'  >￥<span id='price'>"
											+ rel[i].sellingPrice + "</span></li>";
									str += "<li class='c2'><input class='min' type='button' value='-' onclick='minus(this);'/>";
									str += "<input class='text_box' readonly='readonly' style='text-align: center;' type='text' name='btn' size='5' value='"
											+ rel[i].productCount + "' />";
									str += "<input class='add' type='button' value='+' onclick='addCount(this);'/></li>";
									str += "<li class='c2' style='width:30px;'>￥<span class='price'>"
											+ rel[i].sellingPrice
											* rel[i].productCount
											+ "</span></li>";
									str += "<li class='c2'>";
									str += "<a href='1'>删除</a><br />";
									str += "<a href='#'>移入收藏夹</a>";
									str += "</li>";
									str += "</li>";
									str += "</ul>";
									str += "</div>";
									str += "<div>";
									sumCount += rel[i].productCount;
									sumPrice += rel[i].sellingPrice
											* rel[i].productCount;
								}
		
								$("#gome-head2").html("");
								$("#gome-head2").html(str);
		
								var stt = "";
		
								stt += "<div id='gome-foot1'>";
								stt += "已选<span class='ccc1' id='countSum'>"
										+ sumCount
										+ "</span>件商品  总计（不含运费）：￥<span class='ccc1' id='priceSum'>"
										+ sumPrice
										+ "</span> <span class='cc1'>去结算</span>";
								stt += "</div>";
		
								$("#gome-foot").html("");
								$("#gome-foot").html(stt);
							}, "json");
			return false;
		};
