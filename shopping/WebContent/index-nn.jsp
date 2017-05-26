<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<meta name="description" content="" />
<title>商品信息</title>
<link type="text/css" href="css/reset.css" />
<link type="text/css" href="css/index.css" />

<style type="text/css">
* {
	padding: 0;
	margin: 0;
}

body {
	font-family: microsoft yahei;
	font-size: 14px;
	background: #f7f7f7;
}

img {
	border: none;
}

ul {
	list-style: none;
}

a {
	color: #343434;
	text-decoration: none;
}

a:hover {
	color: #ba1814;
	text-decoration: none;
}
/*Example for a Menu Style*/
.menu {
	background-color: #fff;
	border: 1px solid #EEEDED;
	height: 34px;
	width: 355px;
	line-height: 34px;
	margin-bototm: 20px;
}

.menu ul {
	margin: 0px;
	padding: 0px;
	list-style: none;
}

.menu li {
	display: inline;
	line-height: 34px;
	width: 100px;
}

.menu li a {
	color: #727272;
	text-decoration: none;
	display: inline-block;
	width: 85px;
	text-align: center;
}

.menu li a.tabactive {
	border-left: 1px solid #EEEDED;
	color: #000000;
	background-color: #ffffff;
	font-weight: bold;
	position: relative;
}

#tabcontent1, #tabcontent2, #tabcontent3, #tabcontent4, #anothercontent1,
	#anothercontent2, #anothercontent3, #anothercontent4, #anothercontent5,
	#anothercontent6 {
	border: 1px solid #ececec;
	width: 980px;
	font-size: 12px;
	margin-bottom: 5px;
	margin: 0 auto;
	background: #FFF;
	height: 100%;
	padding-left: 10px;
	padding-right: 10px;
}

.menu li.on a {
	color: #000;
}

.div-list {
	width: 245px;
	height: 440px;
	background: #FFF;
	float: left;
	margin-top: 10px;
}

p.price {
	font-size: 18px;
	color: #ba1814;
	padding-left: 15px;
}

.list-img a {
	display: block;
	text-decoration: none;
	overflow: hidden;
	width: 245px;
}

.div-list a:hover {
	display: block;
	border: 3px solid #d9d9d9;
	height: 400px;
}

.div-list img {
	display: block;
	margin: 0 auto;
	width: 202px;
	margin-top: 20px;
}

.p-left {
	padding-left: 15px;
	width: 215px;
	font-size: 14px;
	color: #333;
	line-height: 24px;
}

.jwc-btn {
	color: #FFF;
	border: none;
	font-family: microsoft yahei;
	font-size: 14px;
	display: block;
	float: left;
	line-height: 35px;
}

.jrgwc {
	background: #ba1814;
	width: 160px;
	height: 35px;
	margin: 0 auto;
	display: block;
	border-radius: 5px;
	margin-top: 20px;
}

.jrgwc img.gwc {
	display: block;
	width: 22px;
	height: 18px;
	float: left;
	margin: 0;
	margin-top: 8px;
	margin-left: 30px;
	margin-right: 5px;
}

.fenye {
	float: right;
	background: #FFF;
	width: 990px;
	text-align: right;
	border-left: 1px solid #EEEDED;
	margin-bottom: 20px;
}

.fenye ul li {
	color: #333;
	float: left;
	margin-right: 10px;
}

.fenye ul li a {
	text-decoration: none;
	border: 1px solid #d9d9d9;
	display: inline-block;
	padding: 5px 10px;
	color: #333;
}

.fenye ul {
	float: right;
}

.fenye ul li a:hover {
	border: 1px solid #ba1814;
	display: inline-block;
}

.fenye ul li.sel a {
	background: #333;
	border: 1px solid #333;
	color: #FFF;
}

.font-color {
	color: #ba1814
}

.link {
	width: 100%;
	margin-top: 20px;
	background: #FFF;
	border-top: 1px solid #ccc;
}

.link ul {
	width: 1000px;
	margin: 0 auto;
	margin-top: 10px;
}

.link ul li {
	float: left;
	margin-right: 15px;
	line-height: 24px;
}

.footer {
	background: url(images/footer_dy.jpg) center top no-repeat;
	width: 100%;
	background-size: cover;
	height: 95px;
}

.footer p {
	text-align: center;
	padding-top: 60px;
}
</style>


<script type="text/javascript">
	/*
	 EASY TABS 1.2 Produced and Copyright by Koller Juergen
	 www.kollermedia.at | www.austria-media.at
	 Need Help? http:/www.kollermedia.at/archive/2007/07/10/easy-tabs-12-now-with-autochange
	 You can use this Script for private and commercial Projects, but just leave the two credit lines, thank you.
	 */

	//EASY TABS 1.2 - MENU SETTINGS
	//Set the id names of your tablinks (without a number at the end)
	var tablink_idname = new Array("tablink", "anotherlink")
	//Set the id names of your tabcontentareas (without a number at the end)
	var tabcontent_idname = new Array("tabcontent", "anothercontent")
	//Set the number of your tabs in each menu
	var tabcount = new Array("4", "6")
	//Set the Tabs wich should load at start (In this Example:Menu 1 -> Tab 2 visible on load, Menu 2 -> Tab 5 visible on load)
	var loadtabs = new Array("2", "5")
	//Set the Number of the Menu which should autochange (if you dont't want to have a change menu set it to 0)
	var autochangemenu = 2;
	//the speed in seconds when the tabs should change
	var changespeed = 3;
	//should the autochange stop if the user hover over a tab from the autochangemenu? 0=no 1=yes
	var stoponhover = 0;
	//END MENU SETTINGS

	/*Swich EasyTabs Functions - no need to edit something here*/
	function easytabs(menunr, active) {
		if (menunr == autochangemenu) {
			currenttab = active;
		}
		if ((menunr == autochangemenu) && (stoponhover == 1)) {
			stop_autochange()
		} else if ((menunr == autochangemenu) && (stoponhover == 0)) {
			counter = 0;
		}
		menunr = menunr - 1;
		for (i = 1; i <= tabcount[menunr]; i++) {
			document.getElementById(tablink_idname[menunr] + i).className = 'tab'
					+ i;
			document.getElementById(tabcontent_idname[menunr] + i).style.display = 'none';
		}
		document.getElementById(tablink_idname[menunr] + active).className = 'tab'
				+ active + ' tabactive';
		document.getElementById(tabcontent_idname[menunr] + active).style.display = 'block';
	}
	var timer;
	counter = 0;
	var totaltabs = tabcount[autochangemenu - 1];
	var currenttab = loadtabs[autochangemenu - 1];
	function start_autochange() {
		counter = counter + 1;
		timer = setTimeout("start_autochange()", 1000);
		if (counter == changespeed + 1) {
			currenttab++;
			if (currenttab > totaltabs) {
				currenttab = 1
			}
			easytabs(autochangemenu, currenttab);
			restart_autochange();
		}
	}
	function restart_autochange() {
		clearTimeout(timer);
		counter = 0;
		start_autochange();
	}
	function stop_autochange() {
		clearTimeout(timer);
		counter = 0;
	}

	window.onload = function() {
		var menucount = loadtabs.length;
		var a = 0;
		var b = 1;
		do {
			easytabs(b, loadtabs[a]);
			a++;
			b++;
		} while (b <= menucount);
		if (autochangemenu != 0) {
			start_autochange();
		}
	}
</script>
<link href="css/reset.css" type="text/css" rel="stylesheet" />
<link href="css/login.css" type="text/css" rel="stylesheet" />
</head>


<body>
	<span style="right: 480px; top: 10px; position: absolute;"><a
		href="ExitServlet">退出</a></span>
		
	<span style="right: 400px; top: 10px; position: absolute;">
		<c:if test="${username!=null}">
		<a style="color: green;" href="#">${username}</a>
		</c:if>
		<c:if test="${username==null}">
			<a href="login.jsp">登录</a>
		</c:if>
	<%-- 	<a href="login.jsp">${username}</a> --%>
	</span>
	<span style="right:360px; top: 10px; position: absolute;"><a
		href="zhuce.jsp">|&nbsp;注册&nbsp;</a></span>
	<span style="right: 310px; top: 10px; position: absolute;"><a
		href="QueryCartServlet">购物车</a></span>
	<span style="right: 245px; top: 10px; position: absolute;"><a
		href="QueryOrderListServlet">我的订单</a></span>
	<span style="right: 180px; top: 10px; position: absolute;"><a
		href="sc.html">收藏夹</a></span>

	<div class="login-header">
		<div class="logo-img">
			<a href="#"><img src="images/logo.png" /></a>
		</div>
		<div class="logo-wz">
			<a href="#">暖暖魔力官方网站<br />
			<span style="font-size: 13px; line-height: 24px; display: block;">官方唯一授权旗舰店
					100%正品保证</span></a>
		</div>
		<div class="DivClear"></div>
	</div>

	<div style="width: 1000px; margin: 0 auto;">
		<div class="menu">
			<ul>
				<li class="on"><a href="#" onmouseover="easytabs('1', '1');"
					onfocus="easytabs('1', '1');" onclick="return false;" title=""
					id="tablink1">综合</a></li>
				<li><a href="#" onmouseover="easytabs('1', '2');"
					onfocus="easytabs('1', '2');" onclick="return false;" title=""
					id="tablink2">人气</a></li>
				<li><a href="#" onmouseover="easytabs('1', '3');"
					onfocus="easytabs('1', '3');" onclick="return false;" title=""
					id="tablink3">新品</a></li>
				<li><a href="#" onmouseover="easytabs('1', '4');"
					onfocus="easytabs('1', '4');" onclick="return false;" title=""
					id="tablink4">T销量</a></li>
			</ul>
		</div>
		<!--End of the Tabmenu 1 -->
		<div style="clear: both; padding-bottom: 10px;"></div>

		<!--Start Tabcontent 1 -->
		<div id="tabcontent1">	
			<div>
				<c:forEach items="${products}" var="product">
				
					<div style="width: 245px;" class="div-list">
						<a href="QueryProductOneServlet?id=${product.id}" style="display: block; text-decoration: none;"> <img
						src="images/img060201.jpg" width="202" height="183" />
						<p class="price">${product.price}</p>
						<p class="p-left">
						<span class="font-color">${product.name}</span><span
						class="font-color">${product.product_des}</span>
						<br />
						<span class="font-color" style="color: black;font-weight: bold;">数量:${product.count}</span>
						</p>
						<div class="jrgwc">
						<img src="images/gwc-bg.png" class="gwc" /> <span class="jwc-btn">加入购物车</span>
						</div>
						</a>
					</div>
				</c:forEach>
				
			</div>
			
			<div class="fenye" style="font-size: 18px;" align="center">	
			总共[${totalCount}]记录,总共[${totalPage}]页，当前第[${page}]页&nbsp;&nbsp;
			<a href="QueryProductServlet?page=1">首页</a>&nbsp;&nbsp;
			   <c:if test="${page!=1}">
			   <a href="QueryProductServlet?page=${page-1}">上一页</a>
			  </c:if>
			&nbsp;&nbsp;
			<c:if test="${page!=totalPage}">
			<a href="QueryProductServlet?page=${page+1}">下一页</a>
			</c:if>
			&nbsp;&nbsp;<a href="QueryProductServlet?page=${totalPage}">尾页</a>
			</div>
			
			<div style="clear: both;">
			</div>
			
		</div>
		<!--End Tabcontent 1-->

		<!--Start Tabcontent 2-->
		<!-- 人气 -->
		<div id="tabcontent2">
			<div>
				<c:forEach items="${products}" var="product">
				
					<div style="width: 245px;" class="div-list">
						<a href="QueryProductOneServlet?id=${product.id}" style="display: block; text-decoration: none;"> <img
						src="images/img060201.jpg" width="202" height="183" />
						<p class="price">${product.price}</p>
						<p class="p-left">
						<span class="font-color">${product.name}</span>
						<span style="color: black;font-weight: bold;"
						class="font-color">${product.product_des}</span><br />
						<span class="font-color" >数量:${product.count}</span>
						</p>
						<div class="jrgwc">
						<img src="images/gwc-bg.png" class="gwc" /> <span class="jwc-btn">加入购物车</span>
						</div>
						</a>
					</div>
				</c:forEach>
				
			</div>
			
			<div class="fenye" style="font-size: 18px;" align="center">	
			总共[${totalCount}]记录,总共[${totalPage}]页，当前第[${page}]页&nbsp;&nbsp;
			<a href="QueryProductServlet?page=1">首页</a>&nbsp;&nbsp;
			   <c:if test="${page!=1}">
			   <a href="QueryProductServlet?page=${page-1}">上一页</a>
			  </c:if>
			&nbsp;&nbsp;
			<c:if test="${page!=totalPage}">
			<a href="QueryProductServlet?page=${page+1}">下一页</a>
			</c:if>
			&nbsp;&nbsp;<a href="QueryProductServlet?page=${totalPage}">尾页</a>
			</div>
			
			<div style="clear: both;">
			</div>

		</div>
		<!--End Tabcontent 2 -->

		<!--Start Tabcontent 3-->
		<div id="tabcontent3">12233</div>
		<!--End Tabcontent 3-->

		<!--Start Tabcontent 4-->
		<div id="tabcontent4">1224</div>
		<!--End Tabcontent 4-->
	</div>
	<div class="link">
		<ul>
			<li><a href="#">暖暖魔力防晒</a></li>
			<li><a href="#">暖暖魔力防晒</a></li>
			<li><a href="#">暖暖魔力防晒</a></li>
			<li><a href="#">暖暖魔力防晒</a></li>
		</ul>
		<div style="clear: both;"></div>
	</div>
	<div class="footer">
		<p>版权声明版权声明版权声明版权声明版权声明版权声明版权声明版权声明版权声明</p>
	</div>
</body>
</html>