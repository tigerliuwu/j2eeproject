<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="GBK"%>



<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<%@ taglib uri="/WEB-INF/struts-gdc.tld" prefix="gdc"%>



<html>

	<head>

		<title></title>

		<link rel="stylesheet" href="././css/public.css">
		
		<style type="text/css">
		<!--
		.STYLE14 {font-size: 14px}
		.STYLE16 {font-family: "宋体", Tahoma, verdana; font-size: 24px; font-weight: bold; }
		-->
		</style>

	</head>

	
	
<script type="text/javascript" src="./js/prototype-1.4.0.js"></script>

<script type="text/javascript" src="./js/scriptaculous.js"></script>

<script type="text/javascript" src="./js/overlibmws.js"></script>

<script type="text/javascript" src="./js/ajaxtags.js"></script>



<script type="text/javascript" src="./js/olsUtil.js"></script>


	<script language="JavaScript">


	
	function Finish()

	{
		
		location.href('impCertificateBatterySearchAction.do');	
		

	}

	

	function Back1(id)

	{	
		
		location.href('impCertificateBatteryPreview1PreAction.do?certificateBatteryId='+id);	

	}

	

	</script>

	<body>

		<table width="98%" cellpadding="0" cellspacing="0" align="center">
<br>
<tr>
	<td valign="top"><strong><font color="#040466">&nbsp;&nbsp;Certificate Battery&nbsp;->&nbsp;Preview</font></strong></td>
</tr>
<tr>
	<td><hr noshade width="100%" size="1"></td>
</tr>
<tr>
<td>
<!-- 正文开始 ----------------------------------------------------------------------------------------------------->
<table width="90%" border="0" cellpadding="5">
 <tr align="right">
    <td colspan="2">&nbsp;</td>
    </tr>
  
  <tr align="right">
    <td colspan="2" align="center"><span class="STYLE16">进出口电池产品备案附页</span></td>
    </tr>
  <tr align="right">
    <td colspan="2" align="center">备案号：<bean:write name="battery" property="certificateBatteryNo" /></td>
    </tr>
  <tr>
    <td colspan="2" align="right">
	<table width="100%" border="1" cellspacing="2" cellpadding="2" align="center">
      <tr align="center">
        <td>序号</td>
        <td>名称</td>
        <td>品牌</td>
        <td>规格型号</td>
        <td>电压（V）</td>
        <td>容量（mAh）</td>
        <td>产地</td>
      </tr>
      
	<logic:iterate id="item" name="result"  indexId="index">
	
	<tr onMouseOut="this.style.backgroundColor='#FFFFFF'" onMouseOver="this.style.backgroundColor='#DDDDDD'" align="center">
	
		<td ><gdc:iteratorNO indexId="index" /></td>
		<td >&nbsp;&nbsp;<bean:write name="battery" property="productDescription" /></td>
		<td >&nbsp;&nbsp;<bean:write name="battery" property="brand" /></td>
		<td >&nbsp;&nbsp;<bean:write name="item" property="productModel" /></td>
		<td >&nbsp;&nbsp;<bean:write name="item" property="voltage" /></td>
		<td >&nbsp;&nbsp;<bean:write name="item" property="capacity"/></td>
		<td >&nbsp;&nbsp;<gdc:write name="battery" property="origin" labelvalue="Country"/></td>
		
	</tr>
	
	</logic:iterate>


<bean:define name="index" id="theindex"></bean:define>

<script language="JavaScript">
 myindex=<%=theindex%>+2;
 for(;myindex<=20;myindex++){
 	
 	document.write("<tr><td align='center'>"+myindex+"</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>");
	}
</script>

      
 
    </table></td>
    </tr>
  
  
  <tr><td></td><td>
  <html:form styleId="formpage" action="/impCertificateBatteryPreview2PreAction">		
			<html:hidden name="battery" property="certificateBatteryId" />
			<gdc:pages />
  </html:form>
  </td></tr>

  <tr>
    <td align="right">&nbsp;</td>
    <td align="center">
	<input name="Back" type="button" class="button" value="  Back  " onClick="Back1('<bean:write name="battery" property="certificateBatteryId" />')">
	&nbsp;&nbsp;&nbsp;&nbsp;
	<input name="Next" type="button" class="button" value="  Finish  " onClick="Finish()">	</td>
  </tr>
  
</table>



<!-- 正文结束 ----------------------------------------------------------------------------------------------------->
</td>
</tr>
</table>


		

	</body>


		</html>