<%@page import="com.xx.service.impl.SupplierServiceImpl"%>
<%@page import="com.xx.entity.Supplier"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	Integer id = Integer.parseInt(request.getParameter("id"));
	Supplier supplier=(new SupplierServiceImpl()).selectOne(id);
	request.setAttribute("supplier", supplier);
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
	<form method="get" action="">
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
	<form method="post" action="UpdateSupplierServlet">
	   <!-- type:hidden 隐藏域  ：可以提交到Servlet，但是页面不会显示 -->
	   <input type="hidden" id="s_id" name="s_id" value="${supplier.s_id}"/>
		<div class="content">
			<table class="box">
				<tr>
					<td class="field">供应商编号：</td>
					<td><input type="text" name="supplierCode" class="text" value="${supplier.supplierCode}"/></td>
					<!-- request.getParameter("supplierCode") -->
				</tr>
				<tr>
					<td class="field">供应商名字:</td>
					<td><input type="text" name="supplierName" class="text" value="${supplier.supplierName}"/></td>
				</tr>
				<tr>
					<td class="field">供应商描述：</td>
					<td><textarea name="supplierDexc">${supplier.supplierDexc}</textarea></td>
				</tr>
				<tr>
					<td class="field">联系人：</td>
					<td><input type="text" name="supplierPerson" class="text" value="${supplier.supplierPerson}"/></td>
				</tr>
				<tr>
					<td class="field">电话：</td>
					<td><input type="text" name="supplierTel" class="text" value="${supplier.supplierTel}"/></td>
				</tr>
				<tr>
					<td class="field">地址：</td>
					<td><input type="text" name="supplierAddr" class="text" value="${supplier.supplierAddr}"/></td>
				</tr>
			</table>
		</div>
		<div class="buttons">
			<input type="submit" name="submit" value="确认" class="input-button" />
			<input type="button" name="button" value="返回" class="input-button" onclick="history.back();" />
		</div>
	</form>
</div>
</body>
</html>
    