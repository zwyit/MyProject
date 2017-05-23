<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>注册</title>
<link href="css/reset.css" type="text/css" rel="stylesheet"/>
<link href="css/login.css" type="text/css" rel="stylesheet" />
<script type="text/javascript">
//检查名字是否为空
function checkName(){
	//获取输入的姓名
	var name=document.getElementById("name");
	var phone_reg=/^1(3|4|5|6|7|8)[0-9]{9}$/;
	var email_reg=/^[A-Za-zd]+([-_.][A-Za-zd]+)*@([A-Za-zd]+[-.])+[A-Za-zd]{2,5}$/;
	var alertMessage=document.getElementById("s");
	//获取值
	var name_value=name.value;
	if(name_value=="" || name_value.length==0){
		name.style.border = "1px solid red";
		alertMessage.style.color="red";
		alertMessage.innerHTML="不能为空";
	}else{
		//是否是手机号或者邮箱
		if((email_reg.test(name_value))||(phone_reg.test(name_value))){
			name.style.border = "1px solid ";
			alertMessage.innerHTML = "";
		}else {
			name.style.border = "1px solid red";
			alertMessage.style.color="red";
			alertMessage.innerHTML="格式错误";
			
		}
	}
}
//检查密码是否为空
function checkPwd(){
	var pwd=document.getElementById("pwd");
	var pwd_value=pwd.value;
	if(pwd_value==""||pwd_value.length==0){
		pwd.style.border="1px solid red";
		var alertMessage=document.getElementById("s1");
		alertMessage.style.color="red";
		alertMessage.innerHTML="密码不能为空"
	}else{
		pwd.style.border="1px solid ";
		var alertMessage=document.getElementById("s1");
		s1.innerHTML="";
	}
}
//核实密码
function confirmPwd(){
	  var confirmPwd = document.getElementById("cpwd");
	  var confirmPwd_value = confirmPwd.value;
	  //判断确认密码是否为空
	  if (confirmPwd_value=="" || confirmPwd_value.length==0) {
		confirmPwd.style.border = "1px solid red";
		//修改提示信息
		var cpwd = document.getElementById("s2");
		cpwd.innerHTML = "密码不能为空";
		cpwd.style.color = "red";
		return;
	}
	   var password = document.getElementById("pwd");
	   var password_value = password.value;
	  //4.判断密码和确认密码是否一致，如果不一致则提示信息修改为"确认密码与密码不一致"
	  if (confirmPwd_value!=password_value) {
		  confirmPwd.style.border = "1px solid red";
		  var cpwd = document.getElementById("s2");
		  cpwd.innerHTML = "两次密码不一致";
		  cpwd.style.color="red";
	  }else{
		  password.style.border="1px solid";
		  confirmPwd.style.border = "1px solid";
		  var cpwd = document.getElementById("s2");
		  cpwd.innerHTML = "";
	  }

}
</script>
</head>
<body>
<span style="right:350px; top:10px; position:absolute;"><a href="index-nn.html">暖暖魔力</a></span>
<span style="right:320px; top:10px; position:absolute;"><a href="login.jsp">登录</a></span><span style="right:260px; top:10px; position:absolute;"><a href="zhuce.jsp">|&nbsp;&nbsp;注册&nbsp;&nbsp;|&nbsp;</a></span><span style="right:210px; top:10px; position:absolute;"><a href="cart.html">购物车</a></span><span style="right:145px; top:10px; position:absolute;"><a href="order.html">我的订单</a></span>
<span style="right:100px; top:10px; position:absolute;"><a href="sc.html">收藏夹</a></span>
<div class="login-header">
	<div class="logo-img"><a href="#"><img src="images/logo.png" /></a></div>
        <div class="logo-wz"><a href="#">暖暖魔力官方网站<br /><span style="font-size:13px; line-height:24px; display:block;">官方唯一授权旗舰店  100%正品保证</span></a></div>
        <div class="DivClear"></div>
</div>
<div class="login-main">
	<div class="login-main-right">
    	<div class="login-tips">
            <span class="tips-left">没有账号？请注册</span>
            <span class="tips-right">已注册？<a href="login.jsp">登录</a></span><br/>
            <span style="color: red;font-weight: bold;" class="tips-left">${message}</span>
            <div class="DivClear"></div>
    	</div>
        <div class="DivClear">
        	<form action="AddUsersServlet" method="post">
            <p class="inputs">
            	<input type="text" placeholder="邮箱/手机号" class="ipt-text01" size="15px" id="name" name="name" onblur="checkName()"/>
				<span style="font-size: 2px;" id="s"></span>
            </p>
            <p class="text-none"></p>
            <p class="inputs">
               	<input type="password" id="pwd" name="pwd" class="ipt-text01" placeholder="密码" size="15px" onblur="checkPwd()"/>
				<span style="font-size: 2px;" id="s1" ></span>
            </p>
            <p class="text-none"></p>
            <p class="inputs">
                <input type="password" id="cpwd" name="cpwd" size="15px" class="ipt-text01" placeholder="确认密码" onblur="confirmPwd()"/>
				<span style="font-size: 2px;" id="s2" ></span>
            </p>
            <p class="text-none"></p>
            <p class="inputs">
                <input type="text" class="ipt-text02 ipt-block" value="验证码" onfocus="if(this.value==defaultValue)  {this.value='';} this.style.color = '#000000'" onblur="if(!value) {value=defaultValue;} this.style.color = '#000000'" / >
                <img src="images/getCaptcha.png" class="img-block" width="49" height="30"/>
                <span class="span-block"><a href="#">换一张</a></span>
                <div class="DivClear" style="padding-bottom:30px; *padding-bottom:0px;"></div>
            </p>
            <p class="text-none"></p>
            <p class="inputs" style="margin-bottom:20px;">
                <input type="submit" class="btn-login" value="注册" />
            </p>
            <p class="rules">
                <input type="checkbox" / style="display:block; float:left; margin-top:4px;*margin-top:0px; margin-right:5px;">
                <span style="display:block; float:left; line-height:20px;">我已阅读并接受<a href="#">唯品会服务条款</a>。</span>
                <div class="DivClear"></div>
            </p>
        </form>
        
        </div>
    </div>
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
