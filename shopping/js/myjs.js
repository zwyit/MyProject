//��������Ƿ�Ϊ��
function checkName(){
	//��ȡ���������
	var name=document.getElementById("name");
	var phone_reg=/^1(3|4|5|6|7|8)[0-9]{9}$/;
	var email_reg=/^[A-Za-zd]+([-_.][A-Za-zd]+)*@([A-Za-zd]+[-.])+[A-Za-zd]{2,5}$/;
	var alertMessage=document.getElementById("s");
	//��ȡֵ
	var name_value=name.value;
	if(name_value=="" || name_value.length==0){
		name.style.border = "1px solid red";
		alertMessage.style.color="red";
		alertMessage.innerHTML="����Ϊ��";
	}else{
		//�Ƿ����ֻ��Ż�������
		if((email_reg.test(name_value))||(phone_reg.test(name_value))){
			name.style.border = "1px solid ";
			alertMessage.innerHTML = "";
		}else {
			name.style.border = "1px solid red";
			alertMessage.style.color="red";
			alertMessage.innerHTML="��ʽ����";
			
		}
	}
}
//��������Ƿ�Ϊ��
function checkPwd(){
	var pwd=document.getElementById("pwd");
	var pwd_value=pwd.value;
	if(pwd_value==""||pwd_value.length==0){
		pwd.style.border="2px solid red";
		var alertMessage=document.getElementById("s1");
		alertMessage.style.color="red";
		alertMessage.innerHTML="���벻��Ϊ��"
	}else{
		pwd.style.border="1px solid ";
		var alertMessage=document.getElementById("s1");
		s1.innerHTML="";
	}
}
//��ʵ����
function confirmPwd(){
	  var confirmPwd = document.getElementById("cpwd");
	  var confirmPwd_value = confirmPwd.value;
	  //�ж�ȷ�������Ƿ�Ϊ��
	  if (confirmPwd_value=="" || confirmPwd_value.length==0) {
		confirmPwd.style.border = "2px solid red";
		//�޸���ʾ��Ϣ
		var cpwd = document.getElementById("s2");
		cpwd.innerHTML = "���벻��Ϊ��";
		cpwd.style.color = "red";
		return;
	}
	   var password = document.getElementById("pwd");
	   var password_value = password.value;
	  //4.�ж������ȷ�������Ƿ�һ�£������һ������ʾ��Ϣ�޸�Ϊ"ȷ�����������벻һ��"
	  if (confirmPwd_value!=password_value) {
		  confirmPwd.style.border = "2px solid red";
		  var cpwd = document.getElementById("s2");
		  cpwd.innerHTML = "�������벻һ��";
		  cpwd.style.color="red";
	  }else{
		  password.style.border="1px solid";
		  confirmPwd.style.border = "1px solid";
		  var cpwd = document.getElementById("s2");
		  cpwd.innerHTML = "";
	  }

}
