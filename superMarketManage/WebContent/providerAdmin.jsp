<%@page import="com.xx.entity.Supplier"%>
<%@page import="com.xx.service.impl.SupplierServiceImpl"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>供货商查询</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<script type="text/javascript">
function doit(flag,id)
{
	if(flag=="del")
	{
		if(confirm("确认删除吗？")!=true)
			return;
	}
	window.location = "provider.do?id="+id+"&flag="+flag;
}
</script>
</head>
<body>
<div class="menu">

<table>
<tbody><tr><td><form method="post" action="provider.do">
<input name="flag" value="search" type="hidden">
供应商名称：<input name="providerName" class="input-text" type="text"> &nbsp;&nbsp;&nbsp;&nbsp;供应商描述：<input name="providerDesc" class="input-text" type="text">&nbsp;&nbsp;&nbsp;&nbsp;<input value="组 合 查 询" type="submit">
</form></td></tr>
</tbody></table>
</div>
<div class="main">
<div class="optitle clearfix">
<em><input value="添加数据" class="input-button" onclick="window.location='providerAdd.html'" type="button"></em>
		<div class="title">供应商管理&gt;&gt;</div>
	</div>

	<div class="content">
<table class="list">
	  <tr>
	    <td width="70" height="29"><div class="STYLE1" align="center">编号</div></td>
	    <td width="80"><div class="STYLE1" align="center">供应商名称</div></td>
	    <td width="100"><div class="STYLE1" align="center">供应商描述</div></td>
	    <td width="100"><div class="STYLE1" align="center">联系人</div></td>
	    <td width="100"><div class="STYLE1" align="center">电话</div></td>
	    <td width="100"><div class="STYLE1" align="center">地址</div></td>
	    <td width="100"><div class="STYLE1" align="center">操作</div></td>
	  </tr>
	  <c:forEach items="${suppliers}" var="supplier">
	  	<tr>
	  		<td>
	  			${supplier.supplierCode}
	  		</td>
	  		<td>
	  			${supplier.supplierName}
	  		</td>
	  		<td>
	  			${supplier.supplierDexc}
	  		</td>
	  		<td>
	  			${supplier.supplierPerson}
	  		</td>
	  		<td>
	  			${supplier.supplierTel}
	  		</td>
	  		<td>
	  			${supplier.supplierAddr}
	  		</td>
	  		<td>
	  			<a href="DeleteSupplierServlet?id=${supplier.s_id}">删除</a>
	    		<a href="modify_supplier.jsp?id=${supplier.s_id}">修改</a>   
	  		</td>
	  	</tr>  
	  </c:forEach>
</table>
		总共[${totalCount}]记录,总共[${totalPage}]页，当前第[${page}]页&nbsp;&nbsp;
		<a href="QuerySupplierServlet?page=1">首页</a>&nbsp;&nbsp;
		   <c:if test="${page!=1}">
		   <a href="QuerySupplierServlet?page=${page-1}">上一页</a>
		  </c:if>
		&nbsp;&nbsp;
		<c:if test="${page!=totalPage}">
		<a href="QuerySupplierServlet?page=${page+1}">下一页</a>
		</c:if>
		&nbsp;&nbsp;<a href="QuerySupplierServlet?page=${totalPage}">尾页</a>
		
	</div>
</div>
</body></html>