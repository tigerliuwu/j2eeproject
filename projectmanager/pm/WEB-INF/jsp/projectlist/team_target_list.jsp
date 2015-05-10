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



<body>



	<table width="98%" cellpadding="0" cellspacing="0" align="center">

	<br>



		<tr>

			<td valign="top">
				<img src="././images/misc_arrow.gif">
				<strong><font color="#040466">个人工作列表：</font></strong>
				<br>
				<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<strong><font color="#040466">项目名称：</font></strong>
				<bean:write name="project" property="projectName" />&nbsp;&nbsp;&nbsp;&nbsp;
				<strong><font color="#040466">项目经理：</font></strong>
				<gdc:write name="project" property="pmId" labelvalue="Users"/>&nbsp;&nbsp;&nbsp;&nbsp;
				<strong><font color="#040466">项目成员：</font></strong>
				<gdc:write name="userId" labelvalue="Users"/>
				



<table width="98%" border="1" id="results_table_1" align="right" cellpadding="2" cellspacing="0" borderColor="silver" class="datatable">

<hr noshade width="100%" size="1">

<tr bgcolor="E9EBEF">

	<td width="2%"><div align="center">序号</div></td>
	<td width="5%"><div align="center">任务名称</div></td>
	<td width="5%"><div align="center">负责人</div></td>
	<td width="5%"><div align="center">计划开始时间</div></td>
	<td width="5%"><div align="center">计划结束时间</div></td>
	<td width="5%"><div align="center">个人任务描述</div></td>
	<td width="5%"><div align="center">个人计划工作量</div></td>
	
</tr>



<%--<logic:notEmpty name="targets">

--%>
<logic:iterate id="item" name="targets" indexId="index">

<tr onMouseOut="this.style.backgroundColor='#FFFFFF'" onMouseOver="this.style.backgroundColor='#DDDDDD'" >
	
	<td align="center">
		<gdc:iteratorNO indexId="index" />
	</td>
	<td align="center"><bean:write name="item" property="targetName" /></td>
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
	
</tr>

</logic:iterate>		

</table>


<%--</logic:notEmpty>


--%>
<br><br>


			</td>

		</tr>
		
		<tr height="20"><td></td></tr>
		<!-- 个人工作量汇总 begin ------------------------------------------------------------------------- -->

		<tr>

			<td valign="top">
				<img src="././images/misc_arrow.gif">
				<strong><font color="#040466">个人工作量汇总：</font></strong>
				<br>
				
				




<table width="98%" border="1" id="results_table_1" align="right" cellpadding="2" cellspacing="0" borderColor="silver" class="datatable">

<hr noshade width="100%" size="1">
<tr bgcolor="E9EBEF">

	<td width="3%"><div align="center">工作周序号</div></td>
	<td width="5%"><div align="center">开始日期</div></td>
	<td width="5%"><div align="center">结束日期</div></td>
	<td width="5%"><div align="center">满荷工作量</div></td>
	<td width="5%"><div align="center">已分配工作量</div></td>
	<td width="5%"><div align="center">已完成工作量</div></td>
	
</tr>



<%--<logic:notEmpty name="weekWorkloads">

--%>
<logic:iterate id="item2" name="weekWorkloads" indexId="index2">

<tr onMouseOut="this.style.backgroundColor='#FFFFFF'" onMouseOver="this.style.backgroundColor='#DDDDDD'" >
	
	<td align="center">
		<gdc:iteratorNO indexId="index2" />
	</td>
	<td align="center"><bean:write name="item2" property="startDate" formatKey="date.formkey"/></td>
	<td align="center"><bean:write name="item2" property="endDate" formatKey="date.formkey"/></td>
	<td align="center"><bean:write name="item2" property="workloadAll" /></td>
	<td align="center"><bean:write name="item2" property="workloadAssign" /></td>
	<td align="center"><bean:write name="item2" property="workloadOver" /></td>
	
</tr>

</logic:iterate>		

</table>


<%--</logic:notEmpty>


--%>



			</td>

		</tr>
		
		
		
		
	<!-- 个人工作量汇总 over  ------------------------------------------------------------------------- -->
		
		
		<tr><td align="center">
		<br>

			<input  type="button" class="button" value="  返 回  " onClick="location.href('userListAction.do');">
		</td><tr>
		
		
		
		
		


	</table>

 </body>


</html:html>




