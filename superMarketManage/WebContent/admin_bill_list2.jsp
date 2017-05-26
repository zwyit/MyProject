<%@page import="com.xx.entity.Bill"%>
<%@page import="com.xx.service.impl.BillServiceImpl"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	List<Bill> bills=(new BillServiceImpl()).selectAll();
	request.setAttribute("bills", bills);
%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
<div class="menu">
	<form method="post" action="">
		商品名称：<input type="text" name="productName" class="input-text" />&nbsp;&nbsp;&nbsp;&nbsp;
		是否付款：<select name="payStatus">
			<option value="">请选择</option>
			<option value="1">已付款</option>
			<option value="0">未付款</option>
		</select>&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" name="submit" value="组合查询" class="button" />
	</form>
</div>
<div class="main">
	<div class="optitle clearfix">
		<em><input type="button" name="button" value="添加数据" class="input-button" onclick="location.href='modify.html'" /></em>
		<div class="title">账单管理&gt;&gt;</div>
	</div>
	<div class="content">
		<table class="list">
			<tr>
				<td>账单编号</td>
				<td>商品名称</td>
				<td>商品数量</td>
				<td>交易金额</td>
				<td>是否付款</td>
				<td>供应商名称</td>
				<td>商品描述</td>
				<td>账单时间</td>
				<td>操作</td>
			</tr>
			<c:forEach begin="0" end="${bills.size()-1}" var="i">
				<tr>
					<td>
						${bills[i].code}
					</td>
					<td>
						${bills[i].productName}
					</td>
					<td>
						${bills[i].productCount}
					</td>
					<td>
						${bills[i].money}
					</td>
					<td>
						${bills[i].payStatus}
					</td>
					<td>
						${bills[i].supplierName}
					</td>
					<td>
						${bills[i].productDesc}
					</td>
					<td>
						${bills[i].createDate}
					</td>
					<td>
						<a href="DeleteBillServlet?id=2">删除</a>&nbsp;<a href="#">修改</a>
					</td>
				</tr>
			
			</c:forEach>
		</table>
	</div>
</div>
</body>
</html>
