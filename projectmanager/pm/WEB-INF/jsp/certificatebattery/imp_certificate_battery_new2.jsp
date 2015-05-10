<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="gbk"%>



<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<%@ taglib uri="/WEB-INF/struts-gdc.tld" prefix="gdc"%>



<html:html>

	<head>

		<title></title>

		<link rel="stylesheet" href="././css/public.css">
		

	</head>

	
<script type="text/javascript" src="./js/prototype-1.4.0.js"></script>
<script type="text/javascript" src="./js/scriptaculous.js"></script>
<script type="text/javascript" src="./js/overlibmws.js"></script>
<script type="text/javascript" src="./js/ajaxtags.js"></script>

<script type="text/javascript" src="./js/olsUtil_guo.js"></script>


<script type="text/javascript">

	var currentPars = 'certificateBatteryLineId';		

	var dropUrl     = 'impCertificateBatterySearchLineAction.do';	

	var addUrl      = 'impCertificateBatteryAddDetailAction.do';

	var deleteUrl   = 'impCertificateBatteryDeleteDetailAction.do';

    var	modifyUrl   = 'impCertificateBatterySaveDetailAction.do';

	

	function setCellStyle(cell,name) {

		if ( name == 'special')

			cell.align = 'left';

		

		cell.align = 'center';		

		return cell;	

	}   
	
	function Finish()

	{
		
		document.addLineForm.action = 'impCertificateBatterySearchAction.do';

		document.addLineForm.submit();	

	}

	

	function Back()

	{

		document.addLineForm.action = 'impCertificateBatteryNew1PreAction.do';

		document.addLineForm.submit();		

	}

	 function after_add()

	{
		document.addLineForm.partNo.value="";
		document.addLineForm.productModel.value="";
		document.addLineForm.voltage.value="";
		document.addLineForm.capacity.value="";
	}


</script>



<body>

<table width="98%" cellpadding="0" cellspacing="0" align="center">

<br>

<tr>

	<td valign="top"><strong><font color="#040466">&nbsp;&nbsp;Certificate Battery&nbsp;->&nbsp;New</font></strong>

	<hr noshade width="100%" size="1">

		<table width="100%" border="1" align="center" cellpadding="2" cellspacing="0" borderColor="#FFFFFF" 
			class="datatable" id="MAIN_TABLE" style="display:block" >
		<tr>
		<td colspan="4" background="./images/back_aaa.jpg"  align="center"><strong><font color="#000000">Basic Information</font></strong></td>
		</tr>
		<tr >
		<td bgcolor="#E9EBEF" align="right" width="15%">Registration No.:</td>
		<td bgcolor="#FFFFFF" width="35%">&nbsp;&nbsp;&nbsp;&nbsp;<bean:write name="battery" property="certificateBatteryNo" /></td>
		
		<td align="right" bgcolor="#E9EBEF">Certificate Status:</td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;<gdc:write name="battery" property="currentStatus" labelvalue="CertificateStatus"/>
		</td>
		</tr>
		
		<tr>
		  <td align="right"  bgcolor="#E9EBEF">Applicant:</td>
		  <td >&nbsp;&nbsp;&nbsp;&nbsp;<bean:write name="battery" property="applicant" /></td>
		<td align="right" bgcolor="#E9EBEF">Applicant Address:</td>
		<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;<bean:write name="battery" property="applicantAddress" /></td>
		</tr>
		
		<tr>
		  <td align="right" bgcolor="#E9EBEF">Manufacturer:</td>
		  <td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;<bean:write name="battery" property="manufacturer" /></td>
		<td align="right" bgcolor="#E9EBEF">Manufacturer Address:</td>
		<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;<bean:write name="battery" property="manufacturerAddress" /></td>
		</tr>
		<tr>
		  <td align="right" bgcolor="#E9EBEF">Product Name:</td>
		  <td>&nbsp;&nbsp;&nbsp;&nbsp;<bean:write name="battery" property="productDescription" /></td>
		  <td align="right" bgcolor="#E9EBEF">Brand:</td>
		  <td>&nbsp;&nbsp;&nbsp;&nbsp;<bean:write name="battery" property="brand" /></td>
		</tr>
		<tr>
		  <td align="right" bgcolor="#E9EBEF">Start Date:</td>
		  <td>&nbsp;&nbsp;&nbsp;&nbsp;<bean:write name="battery" property="startDate" formatKey="date.formkey"/></td>
		  <td align="right" bgcolor="#E9EBEF">Origin:</td>
		  <td>&nbsp;&nbsp;&nbsp;&nbsp;<bean:write name="battery" property="origin" /></td>
		</tr>
		<tr>
		  <td align="right" bgcolor="#E9EBEF">Expired Date:</td>
		  <td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;<bean:write name="battery" property="expiredDate" formatKey="date.formkey"/></td>
		  <td align="right" bgcolor="#FFFFFF"></td>
		<td bgcolor="#FFFFFF"></td>
		</tr>
		</table>

		<br>
		
		<table width="100%" border="1" align="center" cellpadding="2" cellspacing="0" borderColor="silver" class="datatable" id="displayTable">
		
		<tr>
			<td colspan="15" background="./images/back_aaa.jpg" align="center">
			<strong><font color="#000000">Affix Information</font></strong>
			</td>
		</tr>
		
		<tr bgcolor="#F3F3F3" align="center">
		<td width="2%">NO</td>
		<td width="5%" id="td00">PartNo</td>
		<td width="5%">Type</td>
		<td width="5%">Voltage(V)</td>
		<td width="5%">Capacity(mAh)</td>
		</tr>
		
		
		<logic:iterate id="item" name="battery" property="impCertificateBatteryLines" indexId="index">
		
		<tr height="" id="tr1_<bean:write name="item" property="certificateBatteryLineId" />"  onMouseOut="this.style.backgroundColor='#FFFFFF'" onMouseOver="this.style.backgroundColor='#DDDDDD'" >
		<td align="center"><gdc:iteratorNO indexId="index" /></td>
		<td  align="center"><a href="#" onclick="javascript:dropContent('<bean:write name="item" property="certificateBatteryLineId" />');">
			<bean:write name="item" property="partNo" /></a>
		</td>
		<td  align="center"><bean:write name="item" property="productModel" /></td>
		<td  align="center"><bean:write name="item" property="voltage" /></td>
		<td  align="center"><bean:write name="item" property="capacity" /></td>
		</tr>
		
		<tr style="display:none" id="tr2_<bean:write name="item" property="certificateBatteryLineId" />"  >
			<td align="center">&nbsp;</td>
			<td align="left" colspan="8" id="tr2_td_<bean:write name="item" property="certificateBatteryLineId" />" >&nbsp;
			</td>
		</tr>
		
		
		
		</logic:iterate>
		
		
		</table>
		
		<br>

		<html:form action="/impCertificateBatteryAddDetailAction" styleId="addLineForm">
		<html:hidden name="battery" property="certificateBatteryId" />
		
		<table width="100%" border="1" align="center" cellpadding="2" cellspacing="0" borderColor="silver" class="datatable" id="add_view_table_2">
		
		<!-- add line  -->
		<tr bgcolor="#FFFFFF" align="center">
		
		<td width="2%" align="center"><a href="#" onClick="add();">Add</a></td>
		<td width="5%" align="center">
		<html:text name="impCertificateBatteryDetailForm" property="partNo" size="15" styleClass="inputline"  />
		</td>
		<td width="5%" align="center">
		<html:text name="impCertificateBatteryDetailForm" property="productModel" size="15" styleClass="inputline" />
		</td>
		<td width="5%" align="center">
		<html:text name="impCertificateBatteryDetailForm" property="voltage" size="15" styleClass="inputline" />
		</td>
		<td width="5%" align="center">
		<html:text name="impCertificateBatteryDetailForm" property="capacity" size="15" styleClass="inputline" />
		</td>
		
		</tr>
		   
		</table>
		<br>
		<div id="addLine_errors" color="red">
		</div>
	
		
		</html:form>

		<br>

		<div align="center">

		<input type="button" value=" Back " class="button" onClick="Back();">
		&nbsp;&nbsp;
		<input type="button" value=" Finish " class="button" onClick="Finish();">
		
		</div>

	</td>

	</tr>

	</table>

</body>

</html:html>

