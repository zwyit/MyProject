<%@page import="com.xx.service.impl.UserServiceImpl"%>
<%@page import="com.xx.entity.Users"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<script type="text/javascript">
function doit(flag,id)
{
	if(flag=="del")
	{
		if(confirm("确认删除吗？")!=true)
			return;
	}
}
</script>
</head><body>
<div class="menu">
<table>
<tbody><tr><td><form method="post" action="user.do">
<input name="flag" value="search" class="input-text" type="hidden">
用户名称：<input name="userName" class="input-text" type="text">&nbsp;&nbsp;&nbsp;&nbsp; <input value="查 询" type="submit">
</form></td></tr>
</tbody></table>
</div>
<div class="main">

<div class="optitle clearfix">
<em><input value="添加数据" class="input-button" onclick="window.location='userAdd.html'" type="button"></em>
		<div class="title">用户管理&gt;&gt;</div>
	</div>
	<div class="content">
<table class="list">
  <tbody>
  <tr>
    <td width="70" height="29"><div class="STYLE1" align="center">编号</div></td>
    <td width="100"><div class="STYLE1" align="center">用户名称</div></td>
    <td width="100"><div class="STYLE1" align="center">性别</div></td>
    <td width="100"><div class="STYLE1" align="center">年龄</div></td>

    <td width="150"><div class="STYLE1" align="center">电话 </div></td>
    <td width="200"><div class="STYLE1" align="center">地址 </div></td>
    <td width="150"><div class="STYLE1" align="center">权限 </div></td>
    <td width="150"><div class="STYLE1" align="center">操作</div></td>
  </tr>
  
  <c:forEach items="${users}" var="user">
  
  	<tr>
  		<td>${user.userCode}</td>
  		<td>${user.userName}</td>
  		<td>
			<c:if test="${user.userSex==1}">
			男
			</c:if>
			<c:if test="${user.userSex==0}">
			女
			</c:if>
  		</td>
  		<td>${user.userAge}</td>
  		<td>${user.userTel}</td>
  		<td>${user.userAddr}</td>
  		<td>
  			<c:if test="${user.userRight==1}">
  			经理
  			</c:if>
  			<c:if test="${user.userRight==0}">
  			普通用户
  			</c:if>
  		</td>
  		<td>
			<a href="DeleteUsersServlet?u_id=${user.u_id}">删除</a>&nbsp;
			<a href="modify_user.jsp?u_id=${user.u_id}">修改</a>
		</td>
  	</tr>
  </c:forEach>
  
  
</tbody>
</table>
</div>
</div>
</body>
</html>