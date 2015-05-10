<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="GBK"%>
<link rel="stylesheet" href="././css/public.css">
<style type="text/css">
<!--
.STYLE1 {color: #040466 }
-->
</style>

<%
String userName = (String)session.getAttribute("userName");
%>
<script language="JavaScript">
<!--

window.status = "当前用户：<%=userName%>";

function CloseWin()
{
var ua=navigator.userAgent
var ie=navigator.appName=="Microsoft Internet Explorer"?true:false
if(ie){
var IEversion=parseFloat(ua.substring(ua.indexOf("MSIE ")+5,ua.indexOf(";",ua.indexOf("MSIE "))))
if(IEversion< 5.5){
var str = '<object id=noTipClose classid="clsid:ADB880A6-D8FF-11CF-9377-00AA003B7A11">'
str += '<param name="Command" value="Close"></object>';
document.body.insertAdjacentHTML("beforeEnd", str);
document.all.noTipClose.Click();
}
else{
parent.opener =null;
parent.close();
}
}
else{
parent.close()
}
}
//-->
</script>



<body>
<table width="100%"  border="0" cellspacing="0" cellpadding="0">

  <tr>
    <td width="30%" background="././images/logo-bg.gif" align='center'>
	<img src="././images/title.png"  height="47"></td>
    <td width="11%"><img src="././images/top-1.gif"  height="47"></td>
    <td width="59%"><img src="././images/top-2.gif"  height="47"></td>
  </tr>
 
  <tr>
    <td height="25" width="100%" colspan="3" background="././images/menu-bg.gif" >
	
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr> 
		<td width="800" height="18" align="center"></td>
		<td> <img src="././images/icon_mark7.gif"> 
		  <a href="projectListAction.do" target="contentFrame"><span class="STYLE1">项目列表</span></a>
		  </td>                
		<td><img src="././images/icon_mark2.gif"> 
		  <a href="/portaljapan/" target="_parent"><span class="STYLE1">门户首页</span></a></td>
		<td> <img src="././images/icon_mark6.gif"> 
		  <a href="" onclick="CloseWin();"  ><span class="STYLE1">关闭</span></a></td>
		</tr>
		</table>
		
    </td>
  </tr>
  
</table>
</body>
