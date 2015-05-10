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


	<script language="JavaScript">


	
	function Next1(id)

	{

		document.forms[0].action = 'impCertificateBatteryPreview2PreAction.do?certificateBatteryId='+id;

		document.forms[0].submit();		

	}

	

	function Back1()

	{

		document.forms[0].action = 'impCertificateBatterySearchAction.do';

		document.forms[0].submit();		

	}

	

	</script>



	<body>
	<html:form action="/impCertificateBatterySearchPreAction">

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
    <td colspan="2" align="center"><span class="STYLE16">中华人民共和国国家质量监督检验检疫总局</span></td>
    </tr>
  <tr align="right">
    <td colspan="2" align="center"><span class="STYLE16">进出口电池产品备案书</span></td>
    </tr>
  <tr align="right">
    <td colspan="2" align="center"><span class="STYLE16">正本</span></td>
    </tr>
	<tr align="right">
    <td colspan="2">&nbsp;</td>
    </tr>
  <tr>
    <td align="right"><span class="STYLE14">备&nbsp;&nbsp;案&nbsp;&nbsp;号：</span></td>
    <td><span class="STYLE14"><bean:write name="battery" property="certificateBatteryNo" /></span></td>
  </tr>
  <tr>
    <td align="right"><span class="STYLE14">申&nbsp;&nbsp;请&nbsp;&nbsp;人：</span></td>
    <td><span class="STYLE14"><bean:write name="battery" property="applicant" /></span></td>
  </tr>
  <tr>
    <td align="right"><span class="STYLE14">地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址：</span></td>
    <td><span class="STYLE14"><bean:write name="battery" property="applicantAddress" /></span></td>
  </tr>
  <tr>
    <td align="right"><span class="STYLE14">制&nbsp;&nbsp;造&nbsp;&nbsp;商：</span></td>
    <td><span class="STYLE14"><bean:write name="battery" property="manufacturer" /></span></td>
  </tr>
  <tr>
    <td align="right"><span class="STYLE14">地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址：</span></td>
    <td><span class="STYLE14"><bean:write name="battery" property="manufacturerAddress" /></span></td>
  </tr>
  <tr>
    <td align="right"><span class="STYLE14">产品名称：</span></td>
    <td><span class="STYLE14"><bean:write name="battery" property="productDescription" /></span></td>
  </tr>
  <tr>
    <td align="right"><span class="STYLE14">品牌/标记：</span></td>
    <td><span class="STYLE14"><bean:write name="battery" property="brand" /></span></td>
  </tr>
  <tr>
    <td align="right"><span class="STYLE14">型号规格：</span></td>
    <td><span class="STYLE14">(详见附页)</span></td>
  </tr>
  <tr>
    <td align="right"><span class="STYLE14">产&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;地：</span></td>
    <td><span class="STYLE14"><gdc:write name="battery" property="origin" labelvalue="Country" /></span></td>
  </tr>
  <tr>
    <td align="right"><span class="STYLE14">含&nbsp;&nbsp;汞&nbsp;&nbsp;量：</span></td>
    <td><span class="STYLE14">经审核属不含汞电池产品</span></td>
  </tr>
  <tr>
    <td align="right">&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td colspan="2" align="center"><table width="90%" border="0">
      <tr>
        <td width="10%">&nbsp;</td>
        <td width="40%"><span class="STYLE14">上述产品已经我局备案。</span></td>
        <td width="25%">&nbsp;</td>
        <td width="25%">&nbsp;</td>
      </tr>
    </table>      </td>
    </tr>
  <tr>
    <td align="right">&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td align="right"><span class="STYLE14">有&nbsp;&nbsp;效&nbsp;&nbsp;期：</span></td>
    <td><span class="STYLE14"><bean:write name="battery" property="startDate" format="yyyy年MM月dd日"/> &nbsp;至&nbsp; 
    						  <bean:write name="battery" property="expiredDate" format="yyyy年MM月dd日"/></span></td>
  </tr>
  <tr>
    <td align="right">&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td align="right">&nbsp;</td>
    <td align="center"><span class="STYLE14">（盖章）</span></td>
  </tr>
  <tr>
    <td align="right">&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td align="right">&nbsp;</td>
    <td align="center">
	<input name="Back" type="button" class="button" value="  Back  " onClick="Back1()">
	&nbsp;&nbsp;&nbsp;
	<input name="Next" type="button" class="button" value="  Next  " onClick="Next1('<bean:write name="battery" property="certificateBatteryId" />')">
	</td>
  </tr>
</table>



<!-- 正文结束 ----------------------------------------------------------------------------------------------------->
</td>
</tr>
</table>

		

		<html:errors />
		<gdc:errors />
		</html:form>
	</body>


		</html>