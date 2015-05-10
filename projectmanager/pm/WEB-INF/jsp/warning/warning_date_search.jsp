<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="GBK"%>



<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<%@ taglib uri="/WEB-INF/struts-gdc.tld" prefix="gdc"%>




<html:html>

	<head>

		<title></title>
		
		<link rel="stylesheet" href="././css/public.css">
		
		
		<style type="text/css">
		<!--
						
		.tab {
		    padding:3px 8px 3px 8px;
		    border:1px solid #bcbcbc;
		    background: #f9f9f9;
		}
		
		.activeTab {
		    color:#ffffff;
		    border-width: 0 0 0 0;
			width:85;
			font-weight: bold;
			font-family:Tahoma,verdana;
			font-size: 11px;
			background-image:url(images/panel_001.jpg);
		}
		
		.otherTab {
		    color:#000066;
		    border-width: 0 0 0 0;
			width:85;
			font-family:Tahoma,verdana;
			font-size: 11px;
			background-image:url(images/panel_002.gif);
		}
				
		.tabBox {
		    border:0px solid #0783DF;
		    border-top-width:3px;
			border-bottom-width:0px;
			border-right-width:0px;
		    width:100%;
		    padding:7px;
			font-family:Arial, Helvetica, sans-serif;
		}
		-->
		</style>


	</head>

	
<script type="text/javascript" src="./js/prototype-1.4.0.js"></script>

<script type="text/javascript" src="./js/scriptaculous.js"></script>

<script type="text/javascript" src="./js/overlibmws.js"></script>

<script type="text/javascript" src="./js/ajaxtags.js"></script>

<script type="text/javascript" src="./js/selectDateTime.js"></script>

<script type="text/javascript" src="./js/olsUtil.js"></script>



<script language="JavaScript">

	
	var dropUrl = 'warnDateSearchDetailAction.do';

	var currentPars = 'warningid';	
	
	function before_delete(id)
	{
		if(confirm('Delete?')){
			location.href('warnDateDeleteAction.do?warningid='+id);	
		}
	}

</script>




<body>



	<table width="98%" cellpadding="0" cellspacing="0" align="center">

	<br>



		<tr>

			<td valign="top">

				<strong><font color="#040466">&nbsp;&nbsp;Welcome&nbsp;->&nbsp;Date Warn</font>	</strong>

				<hr noshade width="100%" size="1">


<br>

<table cellspacing="0" cellpadding="0">
		<tr> 
		<td class="tab otherTab"><a href="auditMainSearchPreAction.do"><div align="center">Audit List</div></a></td>
		<td class="tab activeTab"><div align="center">Date Warn</div></td>
		<td class="tab otherTab"><a href="warnOSearchPreAction.do"><div align="center">HSCode Warn</div></a></td>
		</tr>
	</table>
<div class="tabBox">


<table width="100%" border="1" id="results_table_1" align="center" cellpadding="2" cellspacing="0" borderColor="silver" class="datatable">


<tr bgcolor="E9EBEF" align="center">

	<td width="2%">NO</td>
	<td width="5%">Document No.</td>
	<td width="5%">Document Type</td>
	<td width="5%">Alarm Time Boundary</td> 
	<td width="5%">Over Alarm Time Days</td>
	<td width="2%">Delete</td>

</tr>


<logic:notEmpty name="result">

<logic:iterate id="item" name="result" indexId="index">



<tr onMouseOut="this.style.backgroundColor='#FFFFFF'" onMouseOver="this.style.backgroundColor='#DDDDDD'" >

	<td align="center"><gdc:iteratorNO indexId="index" /></td>
	
	<td align="left">&nbsp;&nbsp;
		<a href="#" onClick="javascript:dropContentArray('<bean:write name="item" property="warningid" />',
		'<bean:write name="index" />');">
		<bean:write name="item" property="documentCode" />
		</a>
	</td>
	
	<td align="left">&nbsp;&nbsp;<gdc:write name="item" property="documentType" labelvalue="WarnDocType" /></td>
	<td align="left">&nbsp;&nbsp;<bean:write name="item" property="alarmTimeBoundary" formatKey="date.formkey"/></td>
	<td align="left">&nbsp;&nbsp;<bean:write name="item" property="overDays" /></td>
	<td align="left">&nbsp;&nbsp;<a href='#' onclick="before_delete('<bean:write name="item" property="warningid" />');">
				Delete
			</a></td>
	
</tr>

<tr style="display:none" id="tr2_<bean:write name="item" property="warningid" />"  >
	<td align="center">&nbsp;</td>
	<td align="left" colspan="8" id="tr2_td_<bean:write name="item" property="warningid" />" >&nbsp;
	</td>
</tr>
</logic:iterate>


</table>

<br>
					

<html:form styleId="formpage" action="/warnDateSearchPreAction">		

			<gdc:pages />

</html:form>

</logic:notEmpty>




				<br>



			</td>

		</tr>

	</table>

</body>


</html:html>




