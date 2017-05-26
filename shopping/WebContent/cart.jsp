<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>暖暖魔力购物车</title>

			<link rel="stylesheet" type="text/css"
		href="css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="css/lrtk.css">
		<link rel="stylesheet" type="text/css" href="css/index.css">
	

	<style>
html,body,div,span,applet,object,iframe,h1,h2,h3,h4,h5,h6,p,blockquote,pre,a,abbr,acronym,address,big,cite,code,del,dfn,em,font,img,ins,kbd,q,s,samp,small,strike,strong,sub,sup,tt,var,b,u,i,center,dl,dt,dd,ol,ul,li,fieldset,form,label,legend,table,caption,tbody,tfoot,thead,tr,th,td,input,menu,section,article,aside,nav
	{
	margin: 0px;
	padding: 0px;
	border: none;
	outline: 0px;
	font-size: 100%;
	background: none;
}

ol,ul {
	list-style: none;
}

img {
	border: 0;
}

body {
	font-family: microsoft yahei;
	font-size: 14px;
	background: #f7f7f7;
}

a {
	color: #343434;
	text-decoration: none;
}

a:hover {
	color: #ba1814;
	text-decoration: none;
}

.clear {
	clear: both;
}

.shop-cont01 {
	width: 1000px;
	margin: 0 auto;
}

.shop-cont01 p {
	font-size: 16px;
	line-height: 36px;
}

.shop-cont01 span {
	color: #ba1814;
	padding: 0 5px;
}

.shop-cont02 {
	width: 998px;
	border: 998px;
	border-top: 1px solid #EEEDED;
	border-left: 1px solid #EEEDED;
	background: #FFF;
	margin: 0 auto;
	border-right: 1px solid #EEEDED;
	margin-top: 10px;
}

.shop-table tr td {
	text-align: center;
	border-bottom: 1px solid #EEEDED;
	color: #7d7d7d;
}

.shop-num ul li {
	float: left;
	border: 1px solid #ccc;
	padding: 3px 8px;
}

.shop-num ul {
	width: 98px;
	margin: 0 auto;
}

.shop-price {
	color: #7d7d7d;
}

.shop-num {
	color: #ba1814;
	font-weight: bold;
}

.shop-table tr td.col-bg {
	background: #FBFCFB;
}

.shop-cont03 {
	width: 998px;
	border: 998px;
	border: 1px solid #EEEDED;
	background: #FFF;
	margin: 0 auto;
	margin-top: 20px;
	height: 70px;
	line-height: 70px;

}

.shop-cont03 ul li {
	float: left;
}

.shop-cont04 {
	width: 998px;
	border: 998px;
	border: 1px solid #EEEDED;
	background: #FFF;
	margin: 0 auto;
	margin-top: 20px;
}

.shop-cont04 h3 {
	font-size: 18px;
	font-weight: normal;
	border-bottom: 2px solid #ccc;
	padding-bottom: 5px;
	line-height: 30px;
	margin-left: 20px;
	padding-top: 20px;
	margin-right: 20px;
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


.minus {
	cursor: pointer;
}

.plus {
	cursor: pointer;
}

.buyCount {
	width: 20px;
	height: 20px;
	text-align: center;
}
</style>
<style type="text/css">

.right-iconbg ul li{ width:30px; height:30px; }
.right-iconbg ul li.li-bg01{margin-bottom:10px;}
.right-iconbg ul li.li-bg02{margin-bottom:10px;}
.right-iconbg ul li.li-bg01 a{ display:block; background:url(image/netindex/index_right.png) no-repeat; width:30px;height:30px;}
.right-iconbg ul li.li-bg01 a:hover{display:block; background:url(image/netindex/index_right.png) 0 -30px no-repeat; width:30px;height:30px;}
.right-iconbg ul li.li-bg02 a{ display:block; background:url(image/netindex/index_right.png) -30px 0px no-repeat; width:30px;height:30px;}
.right-iconbg ul li.li-bg02 a:hover{display:block; background:url(image/netindex/index_right.png) -30px -30px no-repeat; width:30px;height:30px;}
.right-iconbg ul li.li-bg03 a{ display:block; background:url(image/netindex/index_right.png) -60px 0px no-repeat; width:30px;height:30px;}
.right-iconbg ul li.li-bg03 a:hover{display:block; background:url(image/netindex/index_right.png) -60px -30px no-repeat; width:30px;height:30px;}
.radius-icon{position:absolute; bottom:10px; left:50%;}
.radius-icon ul li{float:left; margin-right:10px;}
.radius-icon ul li a{display:block; width:10px;height:10px; border-radius:50%; background:#fff; }
.radius-icon ul li a:hover{background:#2bb2bc; display:block; width:10px;height:10px; border-radius:50%; }

</style>

<link href="css/reset.css" type="text/css" rel="stylesheet"/>
<link href="css/login.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" language="jscript">
</script>
</head>

<body>
<span style="right: 480px; top: 10px; position: absolute;"><a
		href="ExitServlet">退出</a></span>
<span style="right:320px; top:10px; position:absolute;">
	<c:if test="${username!=null}">
		<a style="color: green;" href="#">${username}</a>
	</c:if>
	<c:if test="${username==null}">
		<a href="login.jsp">登录</a>
	</c:if>
</span>
<span style="right:260px; top:10px; position:absolute;"><a href="zhuce.html">|&nbsp;&nbsp;注册&nbsp;&nbsp;|&nbsp;</a></span><span style="right:210px; top:10px; position:absolute;"><a href="QueryCartServlet">购物车</a></span><span style="right:145px; top:10px; position:absolute;"><a href="QueryOrderListServlet">我的订单</a></span>
<span style="right:100px; top:10px; position:absolute;"><a href="sc.html">收藏夹</a></span>
<div class="login-header">
	<div class="logo-img"><a href="#"><img src="images/logo.png" /></a></div>
        <div class="logo-wz" style="margin-left:60px;"><a href="#">暖暖魔力官方网站<br /><span style="font-size:13px; line-height:24px; display:block;">官方唯一授权旗舰店  100%正品保证</span></a></div>
        <div class="DivClear"></div>
</div>

       	<div class="shop-cont02">
		<table cellpadding="0" cellspacing="0" border="0" class="shop-table"
			width="100%" style="margin-bottom:210px;" >
			<tr height="34">


				<td width="37%" class="col-bg">商品名称</td>
				<td width="12%" class="col-bg">价格（元）</td>
				<td width="12%" class="col-bg">已选数量</td>
				<td width="12%" class="col-bg">库存</td>
				<td width="12%" class="col-bg">小计（元）</td>
				<td width="12%" class="col-bg">操作</td>
			</tr>
			<!-- 设置总价 -->
			<c:set var="totalAllPrice" value="0" />
			<c:forEach items="${carts}" var="cart">
			<c:set var="totalAllPrice" value="${ totalAllPrice + cart.product.price * cart.num }" />
				<tr height="50">
				<td>${cart.product.name}</td>
				<td><span id="price">${cart.product.price}</span>
				</td>
				<td class="shop-num">
					<ul>
						<li class="minus"><a style="font-size: 3px;" href="ModiCartServlet?lag=-1&id=${cart.id}">-</a></li>
						<li style="border-left: 0; border-right: 0; padding-top:4px 8px; *padding:2.5px 8px; ">
							<a id="number" href="javascript:void(0)">${cart.num}</a></li>
						<li class="plus"><a href="ModiCartServlet?lag=1&id=${cart.id}">+</a></li>
					</ul>
				</td>
				<td><span id="price">${cart.product.count}</span>
				</td>
				<td total0="total0">
				<p id="tootalPrice">${cart.xiaoji}</p>
				</td>
								
				<td><a href="DeleteCartServlet?id=${cart.id}">删除</a>
				</td>
				</tr>
			</c:forEach>
					
			<tr height="34">
				<td colspan="7"
					style="text-align: right; padding-right: 10px; background: #FBFCFB;">
					<span class="shop-price">商品总金额：</span> <span class="shop-num"
					id="totalAllPrice">${totalAllPrice}元 </span></td>
			</tr>
		</table>
	</div>
	<div class="shop-cont03"
		style=" width:1000px; margin:0 auto; margin-top:20px;">
		<ul style="float:right;">


			<li><a
				href="QueryProductServlet">继续购物</a><span
				class="li-line" style="padding: 0 10px; color: #999;"></span></li>


			<li style="padding-right:10px;"><a
				href="QueryPreparedOrderServlet"
				style=" margin-top:15px; width: 120px; height: 40px; text-align: center; font-size: 16px; font-family: microsoft yahei; color: #fff; background: #ba1814; border: 0; cursor: pointer; display:block; line-height:40px;">结算</a>
			</li>
		</ul>
		<div class="clear"></div>
	</div>




</body>
</html>
