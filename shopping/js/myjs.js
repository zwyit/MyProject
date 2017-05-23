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
		pwd.style.border="2px solid red";
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
		confirmPwd.style.border = "2px solid red";
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
		  confirmPwd.style.border = "2px solid red";
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
