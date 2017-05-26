<%@page import="com.xx.service.impl.UserServiceImpl"%>
<%@page import="com.xx.entity.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%
	Integer u_id = Integer.parseInt(request.getParameter("u_id"));
	Users users=(new UserServiceImpl()).selectOne(u_id);
	request.setAttribute("users", users);
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
	<form method="post" action="UpdateUsersServlet">
	<!-- type:hidden 隐藏域  ：可以提交到Servlet，但是页面不会显示 -->
	   <input type="hidden" id="u_id" name="u_id" value="${users.u_id}"/>
		<div class="content">
			<table class="box">
				<tr>
					<td class="field">用户名称：</td>
					<td><input type="text" name="userName" value="${users.userName}" class="text"/></td>
				</tr>
				<tr>
					<td class="field">用户密码：</td>
					<td><input type="text" name="userPassword" value="${users.userPassword}" class="text"/></td>
				</tr>
				<tr>
					<td class="field">用户电话：</td>
					<td><input type="text" name="userTel" value="${users.userTel}" class="text"/></td>
				</tr>
				<tr>
					<td class="field">用户地址：</td>
					<td><input type="text" name="userAddr" value="${users.userAddr}" class="text"/></td>
				</tr>
				<tr>
					<td class="field">权&nbsp;&nbsp;限：</td>
					<td>
						<c:if test="${users.userRight==1}">
						<input style="width: 20px;" type="radio" name="userRight" value="1" class="text" checked="checked"/> 经理
						<input style="width: 20px;" type="radio" name="userRight" value="0" class="text"/>普通员工
						</c:if>
						<c:if test="${users.userRight==0}">
						<input style="width: 20px;" type="radio" name="userRight" value="1" class="text"/> 经理
						<input style="width: 20px;" type="radio" name="userRight" value="0"  checked="checked" class="text"/>普通员工
						</c:if>
					</td>
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
