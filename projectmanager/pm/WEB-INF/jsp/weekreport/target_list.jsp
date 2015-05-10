<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="GBK"%>

<%@ page import="edu.pm.constants.PMConstants" %>

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

	var dropUrl = 'weekReportDetailAction.do';

	var currentPars = 'weekTargetId';	

	function Search() {

		document.forms[0].action = 'targetListAction.do?isReturn=NO';	
		document.forms[0].submit();

	}
	
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
				<strong><font color="#040466">填写个人周报</font></strong>&nbsp;&nbsp;&nbsp;&nbsp;
				<strong><font color="#040466">项目名称：</font></strong>
				<bean:write name="project" property="projectName" />&nbsp;&nbsp;&nbsp;&nbsp;
				<strong><font color="#040466">项目经理：</font></strong>
				<gdc:write name="project" property="pmId" labelvalue="Users"/>
				
				<hr noshade width="98%" size="1" align="right">
				
				<html:form action="/workloadPicAction">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<B>选择工作周：</B>
					
					<html:select name="workloadPicForm" property="weekId">
						<html:optionsCollection name="weeks" label="label" value="value" />
					</html:select>
					
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input  type="button" class="button" value="  确 定  " onClick="Search();">
					&nbsp;&nbsp;&nbsp;&nbsp;
				</html:form>

<table width="98%" border="1" id="results_table_1" align="right" cellpadding="2" cellspacing="0" borderColor="silver" class="datatable">


<tr bgcolor="E9EBEF">

	<td width="2%"><div align="center">序号</div></td>
	<td width="5%"><div align="center">任务名称</div></td>
	<td width="5%"><div align="center">负责人</div></td>
	<td width="5%"><div align="center">计划开始时间</div></td>
	<td width="5%"><div align="center">计划结束时间</div></td>
	<td width="5%"><div align="center">个人任务描述</div></td>
	<td width="5%"><div align="center">个人计划工作量</div></td>
	<td width="5%"><div align="center">状态</div></td>
</tr>

<logic:notEmpty name="result">
<logic:iterate id="item" name="result" indexId="index">
<tr onMouseOut="this.style.backgroundColor='#FFFFFF'" onMouseOver="this.style.backgroundColor='#DDDDDD'" >
	
	<td align="center">
		<img src="././images/close0.gif" style="cursor:hand" onclick="FindTarget('<bean:write name="weekId" />_<bean:write name="item" property="id" />')"
			id="open_close_<bean:write name="weekId" />_<bean:write name="item" property="id" />">
		<gdc:iteratorNO indexId="index" />
	</td>
	
	<td align="center">
	
		<logic:equal name="item" property="hasReport" value="true">
			<bean:write name="item" property="targetName" />
		</logic:equal>
		<logic:equal name="item" property="hasReport" value="false">
			<font color="red"><bean:write name="item" property="targetName" /></font>
		</logic:equal>
	
	
	</td>
	<td align="center"><gdc:write name="item" property="userSEId" labelvalue="Users"/></td>
	<td align="center"><bean:write name="item" property="startDatePlan" formatKey="date.formkey"/></td>
	<td align="center"><bean:write name="item" property="endDatePlan" formatKey="date.formkey"/></td>
	<td align="center"><bean:write name="item" property="remark" /></td>
	<td align="center">
		<bean:write name="item" property="workloadPlan" />
		(已完成：
		<bean:write name="item" property="workloadFact" />
		)
	</td>
	<td align="center"><gdc:write name="item" property="status" labelvalue="TargetStatus"/></td>	
	
</tr>

<tr style="display:none" id="tr2_<bean:write name="weekId" />_<bean:write name="item" property="id" />"  >
	<td align="center">&nbsp;</td>
	<td align="left" colspan="8" id="tr2_td_<bean:write name="weekId" />_<bean:write name="item" property="id" />" >&nbsp;
	</td>
</tr>

</logic:iterate>		
</logic:notEmpty>

</table>

<table>
<tr height=60><td>&nbsp;<td></tr>
<table>


<br>
<br>



			</td>

		</tr>

	</table>

 </body>


</html:html>




