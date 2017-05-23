function checkName(){
		var reg=/^1(3|4|5|6|7|8)[0-9]{9}$/;
		var reg2=/^[A-Za-zd\]+([-_.][A-Za-zd]+)*@([A-Za-zd]+[-.])+[A-Za-zd]{2,5}$/;
		var name=document.getElementById("name");;
		var name_value=name.value;
		var ti=document.getElementById("nameAlert");
		if(name_value==""||name_value.length==0){
			ti.innerHTML="不能为空     ";
			ti.style.color="red";
			ti.style.size="1px";
			name.style.border="1px solid red";
		}else{
			if((!reg.test(name_value))||(!reg2.test(name_value))){
				name.style.border="1px solid red";
				ti.innerHTML="格式错误";
				ti.style.color="red";
			}else{
					name.style.border="1px solid";
			}
		}
	}