<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/reset.css" type="text/css" />
<link href="css/index.css" type="text/css" />
<style>
*{padding:0;margin:0;}
ol, ul {list-style: none;}
body{ font-family:microsoft yahei; font-size:14px; background:#f7f7f7;}
a { color:#343434; text-decoration:none;}
a:hover { color:#ba1814; text-decoration:none;}
.clear{ clear:both;}
.xq-main{ width:998px; margin:0 auto; border:1px solid #EEEDED; background:#FFF;}
.xq-main-left{ width:440px; float:left; padding-left:70px; margin:70px 0;}
.xq-main-right{ width:460px; float:right;}
.xq-main-right .main-left-tit h3{ font-size:24px; font-weight: normal; margin-top:60px; line-height:42px;}
.xq-main-left img{ border:1px solid #eee; display:inline-block; padding:0 20px;}
.xq-main-right .main-left-tit p{ color:#3c3a3a; font-size:14px; line-height:36px;}
.main-left-price{ margin:10px 0; border:1px solid #eee; margin-right:60px; background:#fbfbfb; padding:15px;}
.main-left-price p{ color:#9d9d9d; font-size:20px;}
.main-left-price p span{ color:#ba1814; font-size:24px;}
.main-left-num{ border:1px solid #eee; margin-right:60px; background:#fbfbfb; padding:15px;}
.he-col{ color:#838282;}
ul.num-jia{ border-left:1px solid #e0e0e0; width:300px;}
ul.num-jia li{ float:left; border-right:1px solid #e0e0e0;border-top:1px solid #e0e0e0;border-bottom:1px solid #e0e0e0;} 
ul.num-jia li.no-border{ border:0; padding-left:15px; line-height:36px; font-size:16px;}
ul.num-jia li.minus{ padding:0px 13px; font-size:26px; }
ul.num-jia li.minus a{color:#cfcfcf;}
ul.num-jia li.plus{ padding:0px 13px; font-size:26px; }
ul.num-jia li.plus a{color:#cfcfcf;}
ul.num-jia li.num{ padding:6.5px 25px; font-size:16px; }
ul.num-jia li.no-border a{ color:#cfcfcf;}
.xq-gwc{ width:210px; height:43px; margin-top:30px; background:#ba1814; margin-left:90px; border-radius:5px; cursor:pointer;}
.xq-gwc img{ display:block; float:left; padding-left:50px; margin-top:13px;}
.xq-gwc span{ display:block; float:left; color:#FFF; font-size:16px; line-height:43px; padding-left:10px;}

.menu { height:35px;width:998px;}
.menu ul {margin:0px; padding:0px; list-style:none; text-align:center;}
.menu li {display:inline; line-height:35px;}
.menu li a {color:#333; text-decoration:none; display:block; float:left; width:120px;}
.menu li a.tabactive {border-left:1px solid #eee; border-right:1px solid #eee; color:#ba1814; background-color:#ffffff; font-weight:bold;  position:relative; border-top:2px solid #ba1814;}
#tabcontent1,#tabcontent2,#tabcontent3,#tabcontent4,#anothercontent1,#anothercontent2, #anothercontent3, #anothercontent4,#anothercontent5, #anothercontent6 { width:998px;padding:6px 0px; font-size:12px; margin-bottom:5px;}
.xq-cont{width:998px; margin:0 auto; border:1px solid #EEEDED; background:#FFF; margin-top:20px;}
.menu li a:hover{ color:#ba1814; border-top:2px solid #ba1814;}
.tab-cont01{ margin:30px; margin-top:0px;}
.tab-cont01-tit h3{ float:left; font-size:18px; font-weight:normal; line-height:42px;}
.tab-cont01-tit .tit-line{ float:left; background:url(images/list_line.png) repeat-x; height:2px;}
h3.h3-tit{ padding-left:50px; line-height:40px; font-weight:normal; font-size:20px;}
ul.cpsm{ margin-top:10px; padding-left:50px;}
ul.cpsm li{ line-height:36px; color:#7d7d7d; font-size:14px;}
.tab-cont02{ margin:30px; margin-top:0px; padding-left:50px; padding-right:40px;}
.cont02-table{ margin-top:10px; border:1px solid #EEEDED; }
.td-left{ text-align:right; padding-right:15px;  border-right:1px solid #EEEDED; background:#fbfcfb;}
.td-right{ text-align:left; padding-left:15px;}
.cont02-table tr td{ border-bottom:1px solid #EEEDED;color:#7d7d7d; }
#td-no{ border-bottom:0;}
.tb-bg{ background:#fbfcfb;}
.link{ width:100%; margin-top:20px; background:#FFF; border-top:1px solid #ccc;}
.link ul{width:1000px; margin:0 auto; margin-top:10px; }
.link ul li{ float:left; margin-right:15px; line-height:24px;}
.footer{  background:url(images/footer_dy.jpg) center top no-repeat; width:100%; background-size:cover; height:95px;}
.footer p{ text-align:center; padding-top:60px;}

</style>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/jqzoom.css" />
<script src="js/jQuery-1.3.2.js" language="javascript" type="text/javascript"></script>
<script src="js/newegg.jqzoom.js" language="javascript" type="text/javascript"></script>
<script src="js/WebApplication.js" language="javascript" type="text/javascript"></script>
<script src="js/BizProduct090713.js" language="javascript" type="text/javascript"></script>
<script src="js/BizCommon090801.js" language="javascript" type="text/javascript"></script>
<script type="text/javascript">
/*
EASY TABS 1.2 Produced and Copyright by Koller Juergen
www.kollermedia.at | www.austria-media.at
Need Help? http:/www.kollermedia.at/archive/2007/07/10/easy-tabs-12-now-with-autochange
You can use this Script for private and commercial Projects, but just leave the two credit lines, thank you.
*/

//EASY TABS 1.2 - MENU SETTINGS
//Set the id names of your tablinks (without a number at the end)
var tablink_idname = new Array("tablink","anotherlink")
//Set the id names of your tabcontentareas (without a number at the end)
var tabcontent_idname = new Array("tabcontent","anothercontent") 
//Set the number of your tabs in each menu
var tabcount = new Array("4","6")
//Set the Tabs wich should load at start (In this Example:Menu 1 -> Tab 2 visible on load, Menu 2 -> Tab 5 visible on load)
var loadtabs = new Array("2","5")  
//Set the Number of the Menu which should autochange (if you dont't want to have a change menu set it to 0)
var autochangemenu = 2;
//the speed in seconds when the tabs should change
var changespeed = 3;
//should the autochange stop if the user hover over a tab from the autochangemenu? 0=no 1=yes
var stoponhover = 0;
//END MENU SETTINGS


/*Swich EasyTabs Functions - no need to edit something here*/
function easytabs(menunr, active) {if (menunr == autochangemenu){currenttab=active;}if ((menunr == autochangemenu)&&(stoponhover==1)) {stop_autochange()} else if ((menunr == autochangemenu)&&(stoponhover==0))  {counter=0;} menunr = menunr-1;for (i=1; i <= tabcount[menunr]; i++){document.getElementById(tablink_idname[menunr]+i).className='tab'+i;document.getElementById(tabcontent_idname[menunr]+i).style.display = 'none';}document.getElementById(tablink_idname[menunr]+active).className='tab'+active+' tabactive';document.getElementById(tabcontent_idname[menunr]+active).style.display = 'block';}var timer; counter=0; var totaltabs=tabcount[autochangemenu-1];var currenttab=loadtabs[autochangemenu-1];function start_autochange(){counter=counter+1;timer=setTimeout("start_autochange()",1000);if (counter == changespeed+1) {currenttab++;if (currenttab>totaltabs) {currenttab=1}easytabs(autochangemenu,currenttab);restart_autochange();}}function restart_autochange(){clearTimeout(timer);counter=0;start_autochange();}function stop_autochange(){clearTimeout(timer);counter=0;}

window.onload=function(){
var menucount=loadtabs.length; var a = 0; var b = 1; do {easytabs(b, loadtabs[a]);  a++; b++;}while (b<=menucount);
if (autochangemenu!=0){start_autochange();}
}
</script>
<link href="css/reset.css" type="text/css" rel="stylesheet"/>
<link href="css/login.css" type="text/css" rel="stylesheet" />
</head>
<body>
<span style="right:400px; top:10px; position:absolute;"><a href="index-nn.html">暖暖魔力</a></span>
<span style="right:320px; top:10px; position:absolute;">
	<c:if test="${username!=null}">
		<a style="color: green;" href="#">${username}</a>
	</c:if>
	<c:if test="${username==null}">
			<a href="login.jsp">登录</a>
	</c:if>
</span>
<span style="right:260px; top:10px; position:absolute;">
<a href="zhuce.html">|&nbsp;&nbsp;注册&nbsp;&nbsp;|&nbsp;</a></span><span style="right:210px; top:10px; position:absolute;"><a href="cart.html">购物车</a></span><span style="right:145px; top:10px; position:absolute;"><a href="order.html">我的订单</a></span>
<span style="right:100px; top:10px; position:absolute;"><a href="sc.html">收藏夹</a></span>
<div class="login-header">
	<div class="logo-img"><a href="#"><img src="images/logo.png" /></a></div>
        <div class="logo-wz"><a href="#">暖暖魔力官方网站<br /><span style="font-size:13px; line-height:24px; display:block;">官方唯一授权旗舰店  100%正品保证</span></a></div>
        <div class="DivClear"></div>
</div>
<div class="xq-main">
	<div class="introShow" style="width:440px; float:left; padding-left:70px; margin:70px 0;">
  <div class="mainShow"><a id="bigImg" href="images/01.jpg" class="jqzoom" onclick="Biz.Common.OpenWindow.ShowPicture2('http://www.bluebirdsky.cn')"><img id="midImg" src="images/01.jpg" class="Picture220"/></a></div>
  <div class="scroll" id="scroll"><a href="#prev" class="prevView prevStop" ><span>显示上一幅图片</span></a>
    <ul id="thumList">
      <li class="moveUnit"><a href="javascript:void(0)" title="" class="currentItem"><img src="images/01.jpg" alt="" ref1="images/01.jpg" ref2="images/01.jpg" onmouseover="Biz.Product.Product.ChangePic(this);" class="Picture40"/></a></li>
      <li class="moveUnit"><a href="javascript:void(0)" title="" class="currentItem"><img src="images/02.jpg" alt="" ref1="images/02.jpg" ref2="images/02.jpg" onmouseover="Biz.Product.Product.ChangePic(this);" class="Picture42"/></a></li>
      <li class="moveUnit"><a href="javascript:void(0)" title="" class="currentItem"><img src="images/03.jpg" alt="" ref1="images/03.jpg" ref2="images/03.jpg" onmouseover="Biz.Product.Product.ChangePic(this);" class="Picture40"/></a></li>
      <li class="moveUnit"><a href="javascript:void(0)" title="" class="currentItem"><img src="images/04.jpg" alt="" ref1="images/04.jpg" ref2="images/04.jpg" onmouseover="Biz.Product.Product.ChangePic(this);" class="Picture40"/></a></li>
     
    </ul>
    <a href="#next" class="nextView nextStop" ><span>显示下一幅图片</span></a></div>
</div>
<script type="text/javascript" language="jscript">
var productUrl='http://www.newegg.com.cn/Product/paramForProductID.htm';

jQuery(function($) {
    Biz.Product.Product.turn();
    Biz.Product.Product.turn2();
    Biz.Common.TabCtrl.tabs("tab");
	Biz.Common.TabCtrl.tabs("tempTab");
	Biz.Common.MoveCtrl.iniUnit('scroll', 'thumList', 4, 1);
	Biz.Common.MoveCtrl.iniUnit('gift', 'gift_1', 3, 1);
    Biz.Common.MoveCtrl.iniUnit('congener', 'congener_1', 3, 1);
    Biz.Common.TableCtrl.odd();	
    Biz.Product.Product.InitSpecialTable();
    Biz.Product.Product.InitAlsoBuy();

	//Click out event!
	$("#backgroundPopup").click(function(){
		Biz.Common.PopCtrl.disablePopup();
		});
		
	//Press Escape event!
	$(document).keypress(function(e){
		if(e.keyCode==27 && popupStatus==1){
			Biz.Common.PopCtrl.disablePopup();
		}
	});
	
    var options = {
    zoomWidth: 300,
    zoomHeight: 250,
        xOffset: 20,
        yOffset: -15,
        title : false,
		showEffect:"fadein",
		hideEffect:"fadeout",
        position: "right" 
	}
	$(".jqzoom").jqzoom(options);
	Biz.Product.ProductDetail.Delay('44891','健康休闲');
}); 
//价格
function totalPrice(){
	//用innerHTML 或者innerText获取标签之间的文字
	var number = parsInt(document.getElementById("number").innerHTML);
	/* 跟表单相关的是value */
	var price = parseFloat(document.getElementById("price").innerHTML);
	price +=(price/number);
	number += 1;
	document.getElementById("number").innerHTML = number;
	document.getElementById("price").innerHTML = price;
}
//数量加一
function addNum(){	
	var number =  parseInt(document.getElementById("number").innerHTML);//获取number
	var count =  parseInt(document.getElementById("count").innerHTML);//获取总数
	if(number<count){
		document.getElementById("number").innerHTML = number+1;
		var price = parseInt(document.getElementById("price").innerHTML.replace("￥",""));//用空字符替换￥
		var p = price*(number+1);
		document.getElementById("tootalPrice").innerHTML ="￥"+ p.toFixed(2);//toFixed(2)保留两位小数
	}
}

//数量减一
function reduceNum(){
	var number = parseInt(document.getElementById("number").innerHTML);
	var price = parseInt(document.getElementById("price").innerHTML.replace("￥",""));
	if(number>1){
		number =number-1;
		price = price*(number);
		document.getElementById("number").innerHTML = number;
		document.getElementById("tootalPrice").innerHTML ="￥"+price;
	}
}


</script>
	<!--<div class="xq-main-left"><img src="images/1416570_350_350.jpg" /></div>-->
    <div class="xq-main-right">
    	<div class="main-left-tit">
        	<h3>${product.name}</h3>
            <p>${product.product_des}</p>
            <h2>品牌：${brand.name}</h2>
        </div>
        <div class="main-left-price"><p>价格：<span id="price" class="col-span">${product.price}￥</span>/盒</p></div>
        <div class="main-left-num">
        	<div style="color:#333; font-size:16px; margin-bottom:15px;">数量：<span id="count" class="he-col">${product.count}盒</span></div>
            <ul class="num-jia">
            	<li class="minus"><a onclick="reduceNum()" href="#">-</a></li>
                <li class="num"><a id="number" href="#">1</a></li>
                <li class="plus"><a onclick="addNum()" href="javascript:void(0)">+</a></li>
                <!-- href="javascript:void(0)"防止出现滚动条转动的发生 -->
                <li class="no-border"><p id="tootalPrice">￥${product.price}</p></li>
                <div class="clear"></div>        
            </ul>
            
        </div>
        <div class="xq-gwc">
        	<img src="images/gwc-bg.png" />
            <span>加入购物车</span>
        </div>
    </div>
    <div class="clear"></div>
</div>
<div class="xq-cont">
	<div class="menu">
<ul>
<li class="on"><a href="#" onmouseover="easytabs('1', '1');"  onfocus="easytabs('1', '1');" onclick="return false;"  title="" id="tablink1">商品信息</a></li>
<li><a href="#" onmouseover="easytabs('1', '2');"  onfocus="easytabs('1', '2');" onclick="return false;"  title="" id="tablink2">商品详情</a></li>
<li><a href="#" onmouseover="easytabs('1', '3');"  onfocus="easytabs('1', '3');" onclick="return false;"  title="" id="tablink3">使用方法</a></li>
<li><a href="#" onmouseover="easytabs('1', '4');" onfocus="easytabs('1', '4');" onclick="return false;"  title="" id="tablink4">商品实拍</a>
</li>
</ul>
</div>
<!--End of the Tabmenu 1 -->
<div style="clear:both; "></div>

<!--Start Tabcontent 1 -->
<div id="tabcontent1">
  <div class="tab-cont01">
  	<div class="tab-cont01-tit">
    	<h3>产品信息</h3>
        <div class="tit-line"></div>
        <div class="clear"></div>
    </div>
  	<h3 class="h3-tit">${product.name}</h3>
    <ul class="cpsm">
    	<li>品牌：${brand.name}</li>
        <li>分类：${category.name}</li>
        <li>功效：补水、保湿、滋润、活化肌肤</li>
        <li>产品容量：保湿柔肤水 130ml，保湿精华乳 110ml，保湿精华液 45ml，卸妆喷雾 10ml</li>
        <li>适用人群：需要补水保湿人群</li>
        <li>产地：广东省广州市</li>
        <li>特别说明：无</li>
    </ul>
  </div>
  <div class="tab-cont02">
  	<div class="tab-cont01-tit">
    	<h3>规格参数</h3>
        <div class="tit-line"></div>
        <div class="clear"></div>
    </div>
  	<table cellpadding="0" cellspacing="0" border="0" width="100%" class="cont02-table">
    	<tr height="34">
        	<td  class="tb-bg">主体</td>
            <td  class="tb-bg">&nbsp;</td>
        </tr>
        <tr height="34">
        	<td class="td-left" width="50%">类别</td>
            <td class="td-right" width="50%">礼盒</td>
        </tr>
        <tr height="34">
        	<td class="td-left">品牌</td>
            <td class="td-right">植美村</td>
        </tr>
        <tr height="34">
        	<td class="td-left">适用人群</td>
            <td class="td-right">所有人</td>
        </tr>
        <tr height="34">
        	<td class="td-left">保质期</td>
            <td class="td-right">自生产之日起3年</td>
        </tr>
        <tr height="34">
        	<td class="tb-bg">功效</td>
            <td class="tb-bg">&nbsp;</td>
        </tr>
        <tr height="34">
        	<td class="td-left">保湿补水</td>
            <td class="td-right">是</td>
        </tr>
        <tr height="34">
        	<td class="td-left">亮肤</td>
            <td class="td-right">是</td>
        </tr>
        <tr height="34">
        	<td class="tb-bg">适用肤质</td>
            <td class="tb-bg">&nbsp;</td>
        </tr>
        <tr height="34">
        	<td class="td-left" id="td-no">所有肤质</td>
            <td class="td-right" id="td-no">是</td>
        </tr>
    </table>
  </div>       
</div>

<!--End Tabcontent 1-->

<!--Start Tabcontent 2-->
<div id="tabcontent2">

152
</div>
<!--End Tabcontent 2 -->

<!--Start Tabcontent 3-->
<div id="tabcontent3">
	12233
</div>
<!--End Tabcontent 3-->

<!--Start Tabcontent 4-->
<div id="tabcontent4">

     1224
</div>
<!--End Tabcontent 4-->
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
