<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="GBK"%>

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

<script type="text/javascript" src="./js/olsUtil.js"></script>

<script type="text/javascript" src="./js/selectDateTime.js"></script>


<script language="JavaScript">

	
	var dropUrl = 'projectReportSearchDetailAction.do';

	var currentPars = 'id';	
	
	
	function FindTarget(id)
	{
		open_close=document.getElementById("open_close_"+id);
		
		if(open_close.src.indexOf("open")==-1){
			open_close.src="././images/open0.gif";
		}
		else{
			open_close.src="././images/close0.gif";
		}
		dropContentArray(id);	

	}


</script>




<body>

	<table width="98%" cellpadding="0" cellspacing="0" align="center">

	<br>



		<tr>

			<td valign="top">
				<img src="././images/misc_arrow.gif">
				<strong><font color="#040466">&nbsp;&nbsp;项目报告列表</font></strong>&nbsp;&nbsp;&nbsp;&nbsp;
				<strong><font color="#040466">项目名称：</font></strong>
				<bean:write name="project" property="projectName" />&nbsp;&nbsp;&nbsp;&nbsp;
				<strong><font color="#040466">项目经理：</font></strong>
				<gdc:write name="project" property="pmId" labelvalue="Users"/>
				
				<hr noshade width="100%" size="1">


<table width="100%" border="1" id="results_table_1" align="center" cellpadding="2" cellspacing="0" borderColor="silver" class="datatable">


<tr bgcolor="E9EBEF">

	<td width="1%"><div align="center">序号</div></td>
	<td width="10%"><div align="center">报告名称</div></td>
	<td width="2%"><div align="center">报告时间</div></td>

</tr>


<logic:iterate id="item" name="result" indexId="index">

<tr onMouseOut="this.style.backgroundColor='#FFFFFF'" onMouseOver="this.style.backgroundColor='#DDDDDD'" >

	<td align="center">
		<img src="././images/close0.gif" style="cursor:hand" onclick="FindTarget('<bean:write name="item" property="id" />')"
			id="open_close_<bean:write name="item" property="id" />">
		<gdc:iteratorNO indexId="index" />
	</td>
	
	<td align="center"><bean:write name="item" property="reportName" /></td>
	<td align="center"><bean:write name="item" property="reportDate" formatKey="date.formkey"/></td>
</tr>

<tr style="display:none" id="tr2_<bean:write name="item" property="id" />"  >
	<td align="center">&nbsp;</td>
	<td align="left" colspan="8" id="tr2_td_<bean:write name="item" property="id" />" >&nbsp;
	</td>
</tr>
</logic:iterate>
				

</table>

<br>




<html:form styleId="formpage" action="/projectReportListAction">		

			<gdc:pages />

</html:form>


				<br>



			</td>

		</tr>

	</table>

</body>


</html:html>




