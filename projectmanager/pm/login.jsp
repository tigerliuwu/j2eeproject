<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="GBK"%>


<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<%@ taglib uri="/WEB-INF/struts-gdc.tld" prefix="gdc"%>

<script type="text/javascript" src="./js/prototype-1.4.0.js"></script>

<script type="text/javascript" src="./js/scriptaculous.js"></script>

<script type="text/javascript" src="./js/overlibmws.js"></script>

<script type="text/javascript" src="./js/ajaxtags.js"></script>

<script type="text/javascript" src="./js/olsUtil.js"></script><head>

	<title>用户登录</title> 

	<link rel="stylesheet" href="././css/public.css">

	

</head>



<script type="text/javascript" src="./js/prototype-1.4.0.js"></script>

<script type="text/javascript" src="./js/scriptaculous.js"></script>

<script type="text/javascript" src="./js/overlibmws.js"></script>

<script type="text/javascript" src="./js/ajaxtags.js"></script>

<script type="text/javascript" src="./js/olsUtil.js"></script>

<script language="JavaScript">

window.onload=function(){

var ele=document.getElementById("username");
ele.focus();

}

function mySubmit() {

		document.forms[0].submit();
}
	
function myReset() {

		document.forms[0].reset();

}

	
</script>





<html:html>

<body > 

<style type="text/css">
<!--
body {
	background-color: #091F5B;
}
.STYLE1 {color: #FFFFFF}
-->

    <style type="text/css">

    </style>
</style>
<img src="./images/main.jpg" width="863" height="300">
<html:form action="/validateAction0">

	<table width="803" height="203" border="0">
		<tr>
			<th width="54" height="30" scope="row">&nbsp;			</th>
			<td width="198">&nbsp;			</td>
			<td width="58">
				<span class="STYLE1">用户名：</span>			</td>
			<td width="80">
				<html:text property="username"  size="15"  tabindex="1"/>		  </td>
			<td width="94" align="right">
				<span class="STYLE1">验证码：</span>			</td>
			<td width="100">
				<html:text property="rand"  size="15"  tabindex="3" />			</td>
			<td width="40" align="right">
				<!--<img alt="code..." name="randImage" id="randImage" src="image.jsp" align="left">			-->
				<img src="/pm/ShowImage">
				</td>
			<td width="59" align="left"><!--<a href="javascript:loadimage();"><input name="image2" type="image"  src="./images/reload.gif"/></a></td>-->
			<td width="82" align="left">
				<!--<a href="javascript:loadimage();"></a>			--></td>
		</tr>
		<tr>
			<th height="25" scope="row">&nbsp;		  </th>
			<td>&nbsp;		  </td>
			<td>
				<span class="STYLE1">密码：</span>			</td>
			<td>
				<html:password property="password"  size="15" tabindex="2" />			</td>
			<td>&nbsp;</td>
			<td colspan="3"></td>
		  <td>&nbsp;		  </td>
		</tr>
		<tr>
			<th scope="row">&nbsp;			</th>
			<td>&nbsp;			</td>
			<td>&nbsp;			</td>
			<td>&nbsp;			</td>
			<td>&nbsp;			</td>
			<td align="right" valign="bottom">
				&nbsp;
				<input name="image2" type="image" onclick="mySubmit();" src="./images/loginbutton.jpg" onMouseover="this.style.cursor='hand'" tabindex="4" />			</td>
			<td colspan="2" valign="bottom">
				&nbsp;
				<input name="image1" type="image" onclick="myReset();" src="./images/resetbutton.jpg" onMouseover="this.style.cursor='hand'"/>			</td>
			<td>&nbsp;			</td>
		</tr>
		<tr>
			<th scope="row">&nbsp;			</th>
			<td>&nbsp;			</td>
			<td>&nbsp;			</td>
			<td>&nbsp;			</td>
			<td>&nbsp;			</td>
			<td>&nbsp;			</td>
			<td colspan="2">&nbsp;			</td>
			<td>&nbsp;			</td>
		</tr>
		<tr>
			<th scope="row">&nbsp;			</th>
			<td>&nbsp;			</td>
			<td>&nbsp;			</td>
			<td>&nbsp;			</td>
			<td>&nbsp;			</td>
			<td>&nbsp;			</td>
			<td colspan="2">&nbsp;			</td>
			<td>&nbsp;			</td>
		</tr>
		<tr>
			<th scope="row">&nbsp;			</th>
			<td>&nbsp;			</td>
			<td>&nbsp;			</td>
			<td>&nbsp;			</td>
			<td>&nbsp;			</td>
			<td>&nbsp;			</td>
			<td colspan="2">&nbsp;			</td>
			<td>&nbsp;			</td>
		</tr>
		<tr>
			<th scope="row">&nbsp;			</th>
			<td>&nbsp;			</td>
			<td>&nbsp;			</td>
			<td>&nbsp;			</td>
			<td>&nbsp;			</td>
			<td>&nbsp;			</td>
			<td colspan="2">&nbsp;			</td>
			<td>&nbsp;			</td>
		</tr>
	</table>
	<html:errors/>
	<logic:notEmpty name="err">
		<Font color="#FFFFFF">&nbsp;&nbsp;<bean:write name="err" /></Font>
	</logic:notEmpty>
	
</html:form>
</body>
</html:html>
