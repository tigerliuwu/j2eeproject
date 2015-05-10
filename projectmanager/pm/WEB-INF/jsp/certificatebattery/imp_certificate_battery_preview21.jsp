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
		.STYLE16 {font-family: "����", Tahoma, verdana; font-size: 24px; font-weight: bold; }
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
<!-- ���Ŀ�ʼ ----------------------------------------------------------------------------------------------------->
<table width="90%" border="0" cellpadding="5">
 <tr align="right">
    <td colspan="2">&nbsp;</td>
    </tr>
  <tr align="right">
    <td colspan="2" align="center"><span class="STYLE16">�л����񹲺͹����������ල��������ܾ�</span></td>
    </tr>
  <tr align="right">
    <td colspan="2" align="center"><span class="STYLE16">�����ڵ�ز�Ʒ������</span></td>
    </tr>
  <tr align="right">
    <td colspan="2" align="center"><span class="STYLE16">����</span></td>
    </tr>
	<tr align="right">
    <td colspan="2">&nbsp;</td>
    </tr>
  <tr>
    <td align="right"><span class="STYLE14">��&nbsp;&nbsp;��&nbsp;&nbsp;�ţ�</span></td>
    <td><span class="STYLE14"><bean:write name="battery" property="certificateBatteryNo" /></span></td>
  </tr>
  <tr>
    <td align="right"><span class="STYLE14">��&nbsp;&nbsp;��&nbsp;&nbsp;�ˣ�</span></td>
    <td><span class="STYLE14"><bean:write name="battery" property="applicant" /></span></td>
  </tr>
  <tr>
    <td align="right"><span class="STYLE14">��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ַ��</span></td>
    <td><span class="STYLE14"><bean:write name="battery" property="applicantAddress" /></span></td>
  </tr>
  <tr>
    <td align="right"><span class="STYLE14">��&nbsp;&nbsp;��&nbsp;&nbsp;�̣�</span></td>
    <td><span class="STYLE14"><bean:write name="battery" property="manufacturer" /></span></td>
  </tr>
  <tr>
    <td align="right"><span class="STYLE14">��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ַ��</span></td>
    <td><span class="STYLE14"><bean:write name="battery" property="manufacturerAddress" /></span></td>
  </tr>
  <tr>
    <td align="right"><span class="STYLE14">��Ʒ���ƣ�</span></td>
    <td><span class="STYLE14"><bean:write name="battery" property="productDescription" /></span></td>
  </tr>
  <tr>
    <td align="right"><span class="STYLE14">Ʒ��/��ǣ�</span></td>
    <td><span class="STYLE14"><bean:write name="battery" property="brand" /></span></td>
  </tr>
  <tr>
    <td align="right"><span class="STYLE14">�ͺŹ��</span></td>
    <td><span class="STYLE14">(�����ҳ)</span></td>
  </tr>
  <tr>
    <td align="right"><span class="STYLE14">��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;�أ�</span></td>
    <td><span class="STYLE14"><gdc:write name="battery" property="origin" labelvalue="Country" /></span></td>
  </tr>
  <tr>
    <td align="right"><span class="STYLE14">��&nbsp;&nbsp;��&nbsp;&nbsp;����</span></td>
    <td><span class="STYLE14">���������������ز�Ʒ</span></td>
  </tr>
  <tr>
    <td align="right">&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td colspan="2" align="center"><table width="90%" border="0">
      <tr>
        <td width="10%">&nbsp;</td>
        <td width="40%"><span class="STYLE14">������Ʒ�Ѿ��Ҿֱ�����</span></td>
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
    <td align="right"><span class="STYLE14">��&nbsp;&nbsp;Ч&nbsp;&nbsp;�ڣ�</span></td>
    <td><span class="STYLE14"><bean:write name="battery" property="startDate" format="yyyy��MM��dd��"/> &nbsp;��&nbsp; 
    						  <bean:write name="battery" property="expiredDate" format="yyyy��MM��dd��"/></span></td>
  </tr>
  <tr>
    <td align="right">&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td align="right">&nbsp;</td>
    <td align="center"><span class="STYLE14">�����£�</span></td>
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



<!-- ���Ľ��� ----------------------------------------------------------------------------------------------------->
</td>
</tr>
</table>

		

		<html:errors />
		<gdc:errors />
		</html:form>
	</body>


		</html>