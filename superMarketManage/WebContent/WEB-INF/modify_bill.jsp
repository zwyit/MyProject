<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
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
	<form method="post" action="UpdateBillListServlet">
	   <!-- type:hidden 隐藏域  ：可以提交到Servlet，但是页面不会显示 -->
	   <input type="hidden" id="id" name="id" value="${bill.id}"/>
		<div class="content">
			<table class="box">
				<tr>
					<td class="field">账单编号：</td>
					<td><input type="text" name="billNum" class="text" value="${bill.code}"/></td>
					<!-- request.getParameter("billNum") -->
				</tr>
				<tr>
					<td class="field">交易金额：</td>
					<td><input type="text" name="money" class="text" value="${bill.money}"/></td>
				</tr>
				<tr>
					<td class="field">商品描述：</td>
					<td><textarea name="discription">${bill.productDesc}</textarea></td>
				</tr>
				<tr>
					<td class="field">是否付款：</td>
					<td><select name="isPay">
					  <c:if test="${bill.payStatus==0}">
						<option value="0" selected="selected">是</option>
						<option value="1">否</option>
					  </c:if>
					  <c:if test="${bill.payStatus==1}">
						<option value="0">是</option>
						<option value="1"  selected="selected">否</option>
					  </c:if>
					</select></td>
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
    