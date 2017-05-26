<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<style>
*{padding:0; margin:0;}
ol, ul {list-style: none;}
img{border:0;}
body{ font-family:microsoft yahei; font-size:14px; background:#f7f7f7;}
a { color:#343434; text-decoration:none;}
a:hover { color:#ba1814; text-decoration:none;}
.clear{ clear:both;}
.postiton{ line-height:36px; width:1000px; margin:0 auto;}
.ddzf-cont02{width:998px; border:1px solid #dbd6d0; background:#FFF; margin:0 auto; margin-top:10px; }
.ddzf-cont02-left{ width:269px; border-right:1px solid #dbd6d0; float:left;padding-bottom:30px;}
.ddzf-cont02-right{ width:700px; float:right; padding-left:20px; padding-top:50px;}
.ddzf-cont02-left h3{ font-size:16px; padding-left:20px; height:35px; line-height:35px; font-weight:normal; border-bottom:1px solid #dbd6d0; background:#ede7e1;}
.ddzf-td-col{ color:#949494;}
.table-ddxx tr td{ line-height:20px;}
.ddzf-nr{color:#666666;}
.ddzf-cont02-right ul li{ float:left; margin-right:10px; line-height:32px;}
.ddzf-cont02-right ul li a{ color:#2652a5;padding:0 10px; display:inline-block;}
.ddzf-cont02-right ul li.pay a{background:#ebebeb; border:1px solid #d8d8d8; color:#333; font-weight:bold;}
.ddzf-cont02-right ul li a:hover{ display:inline-block; background:#ebebeb; border:1px solid #d8d8d8; padding:0px 10px; color:#333; font-weight:bold;}
.ddzf-cont03{width:998px; border:1px solid #dbd6d0; background:#FFF; margin:0 auto; margin-top:20px;}
.cont03-table tr td{ text-align:center; font-size:12px; color:#949494;}
.cont03-table tr td.td-left{ text-align:left;}
.link{ width:100%; margin-top:20px; background:#FFF; border-top:1px solid #ccc;}
.link ul{width:1000px; margin:0 auto; margin-top:10px; }
.link ul li{ float:left; margin-right:15px; line-height:24px;}
.footer{  background:url(images/footer_dy.jpg) center top no-repeat; width:100%; background-size:cover; height:95px;}
.footer p{ text-align:center; padding-top:60px;}





</style>

<link href="css/reset.css" type="text/css" rel="stylesheet"/>
<link href="css/login.css" type="text/css" rel="stylesheet" />
</head>
<body onLoad="DownCount()">
<span style="right: 450px; top: 10px; position: absolute;"><a
		href="ExitServlet">退出</a></span>

<span style="right:320px; top:10px; position:absolute;">
	<c:if test="${username!=null}">
		<a style="color: green;" href="#">${username}</a>
	</c:if>
	<c:if test="${username==null}">
			<a href="login.jsp">登录</a>
	</c:if>
</span>
<span style="right:260px; top:10px; position:absolute;"><a href="zhuce.html">|&nbsp;&nbsp;注册&nbsp;&nbsp;|&nbsp;</a></span><span style="right:210px; top:10px; position:absolute;"><a href="cart.html">购物车</a></span><span style="right:145px; top:10px; position:absolute;"><a href="QueryOrderListServlet">我的订单</a></span>
<span style="right:100px; top:10px; position:absolute;"><a href="sc.html">收藏夹</a></span>
<div class="login-header">
	<div class="logo-img"><a href="#"><img src="images/logo.png" /></a></div>
        <div class="logo-wz"><a href="#">暖暖魔力官方网站<br /><span style="font-size:13px; line-height:24px; display:block;">官方唯一授权旗舰店  100%正品保证</span></a></div>
        <div class="DivClear"></div>
</div>
<div class="postiton">您的位置：首页><span style="color:#ba1814;">您拍到的宝贝</span></div>
<div class="ddzf-cont01"></div>
<div class="ddzf-cont02">
	<div class="ddzf-cont02-left">
    	<h3>订单信息</h3>
        <div style="margin-left:20px; margin-right:15px; margin-top:10px;">
        	<table cellpadding="0" cellspacing="0" border="0" class="table-ddxx">
            	<tr height="35">
                	<td valign="top" class="ddzf-td-col">收货地址：</td>
                    <td colspan="2" class="ddzf-nr">陕西省西安市新城区民乐园710000</td>
                </tr>
                <tr height="35">
                	<td class="ddzf-td-col">买家留言：</td>
                    <td colspan="2" class="ddzf-nr">买家留言</td>
                </tr>
                <tr height="35">
                	<td width="35%" class="ddzf-td-col">订单编号：</td>
                    <td width="50%" class="ddzf-nr">1045667899223</td>
                    <td width="15%"><a href="#">更多</a></td>
                </tr>
                <tr height="35">
                	<td class="ddzf-td-col">订单编号：</td>
                    <td class="ddzf-nr">1045667899223</td>
                    <td><a href="#">更多</a></td>
                </tr>
            </table>
            
        </div>
    </div>
    <div class="ddzf-cont02-right">
    	<p style=" background: url(images/ddzt.png) left center no-repeat; height:32px; padding-left:40px; line-height:32px; font-size:16px; font-weight:bold; color:#333;">订单状态：商品已拍下，等待买家付款</p>
        <p style="padding-left:45px; padding-top:20px; margin-bottom:40px; color:#333;">还有<span style=" color:#ba1814; font-weight:bold;">15小时30分30秒</span>来付款，订单超时自动关闭</p>
        <ul style="padding-left:45px; margin-bototm:30px;">
            	<li>您可以</li>
                <li class="pay"><a href="#">付款</a></li>
                <li><a href="#">找人代付</a></li>
                <li><a href="#">取消订单</a></li>
                <li><a href="#">备忘</a></li>
            </ul>
            <div class="clear"></div>
    </div>
    <div class="clear"></div>
</div>
<div class="ddzf-cont03">
	<table cellpadding="0" cellspacing="0" border="0" class="cont03-table">
    	<tr height="35" >
            <td colspan="2" style="border-bottom:1px solid #dbd6d0;">商品</td>
            <td style="border-bottom:1px solid #dbd6d0;">单价（元）</td>
            <td style="border-bottom:1px solid #dbd6d0;">数量</td>
            <td style="border-bottom:1px solid #dbd6d0;">优惠（元）</td>
            <td style="border-bottom:1px solid #dbd6d0;">状态</td>
            <td style="border-bottom:1px solid #dbd6d0;">运费（元）</td>
        </tr>
        <c:set var="totalAllPrice" value="0" />
        <c:forEach items="${olist}" var="o">
        <%-- <c:set var="totalAllPrice" value="${ totalAllPrice + o.p_price * o.p_num }" /> --%>
	        <tr>
	        	<td width="15%" style="border-bottom:1px solid #dbd6d0;"><img src="images/818636_60_60.jpg" /></td>
	            <td width="20%" class="td-left" style="border-bottom:1px solid #dbd6d0;">${o.p_name }</td>
	            <td width="10%" style="border-bottom:1px solid #dbd6d0;">${o.p_price }</td>
	            <td width="10%" style="border-bottom:1px solid #dbd6d0;">${o.p_num }</td>
	            <td width="10%" style="border-bottom:1px solid #dbd6d0;">无</td>
	            <td width="13%" style="border-bottom:1px solid #dbd6d0;">
	            <c:if test="${order.status==1}">
	            	未付款
	            </c:if>
	            <c:if test="${order.status==0}">
	            	已付款
	            </c:if>
	            <c:if test="${order.status==3}">
	            	申请售后
	            </c:if>
	            <br/>
	            <span style="color:#ba1814; font-weight:bold;">
	        
	            <fmt:formatDate value="${order.order_date}" type="both"/>
	            
	            </span>
	            </td>
	            <td width="15%" align="center" style="border-bottom:1px solid #dbd6d0;">0.00（元）</td>
	        </tr>
        </c:forEach>
        <tr height="60">
        	<td colspan="7" style="text-align:right; padding-right:20px; background:#f3f3f3;">
            	实付款：<span style=" color:#ba1814; font-size:20px;">${order.total}元 </span>
            </td>
        </tr>
    </table>
</div>
<div class="link">
	<ul>
    	<li><a href="#">暖暖魔力防晒</a></li>
        <li><a href="#">暖暖魔力防晒</a></li>
        <li><a href="#">暖暖魔力防晒</a></li>
        <li><a href="#">暖暖魔力防晒</a></li>
    </ul>
    <div style="clear:both;"></div>
</div>
<div class="footer">
	<p>版权声明版权声明版权声明版权声明版权声明版权声明版权声明版权声明版权声明</p>
</div>
</body>
</html>
