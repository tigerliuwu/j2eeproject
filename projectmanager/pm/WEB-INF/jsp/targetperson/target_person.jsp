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

	
	function Search() {

		document.forms[0].action = 'targetPersonAction.do?isReturn=NO';	
		document.forms[0].submit();

	}


</script>




<body>



	<html:form action="/targetPersonAction">

	<table width="98%" cellpadding="0" cellspacing="0" align="center">

	<br>



		<tr>

			<td valign="top">
				<img src="././images/misc_arrow.gif">
				<strong><font color="#040466">&nbsp;&nbsp;个人任务信息</font></strong>&nbsp;&nbsp;&nbsp;&nbsp;
				<strong><font color="#040466">项目名称：</font></strong>
				<bean:write name="project" property="projectName" />&nbsp;&nbsp;&nbsp;&nbsp;
				<strong><font color="#040466">项目经理：</font></strong>
				<gdc:write name="project" property="pmId" labelvalue="Users"/>

				<hr noshade width="100%" size="1">

					<table id="conditions_table" style="display: block" width="100%"

						border="1" align="center" cellpadding="2" cellspacing="0"

						bgcolor="#FFFFFF" bordercolor="#FFFFFF">
												
						<tr>
							<td width="20%" bgcolor="#E9EBEF" align="right">开始日期 从:</td>        
							<td width="30%">&nbsp;
								<html:text name="targetSearchForm" property="condition.startDatePlanFrom" size="30" 
								styleClass="inputline" onfocus="selectDate(this);"/>
							</td>
							<td width="20%" bgcolor="#E9EBEF" align="right">开始日期 到:</td>        
							<td width="30%">&nbsp;
								<html:text name="targetSearchForm" property="condition.startDatePlanTo" size="30" 
								styleClass="inputline" onfocus="selectDate(this);"/>
							</td>
						</tr>
						<tr>
							<td  bgcolor="#E9EBEF" align="right">结束日期 从:</td>        
							<td >&nbsp;
								<html:text name="targetSearchForm" property="condition.endDatePlanFrom" size="30" 
								styleClass="inputline" onfocus="selectDate(this);"/>
							</td>
							<td  bgcolor="#E9EBEF" align="right">结束日期 到:</td>        
							<td >&nbsp;
								<html:text name="targetSearchForm" property="condition.endDatePlanTo" size="30" 
								styleClass="inputline" onfocus="selectDate(this);"/>
							</td>
						</tr>
						<tr>
							<td bgcolor="#E9EBEF" align="right">任务名称:</td>
						    <td >&nbsp;
								<html:text name="targetSearchForm" property="condition.targetName" size="30" 
								styleClass="inputline" />
							</td>
							<td  bgcolor="#E9EBEF" align="right">任务状态:</td>        
							<td >&nbsp;
							<gdc:defineCollection id="status0" labelvalue="TargetStatus"/>
								<html:select name="targetSearchForm" property="condition.status">
								<option value="">--所有--</option>	
								<html:optionsCollection name="status0" label="label" value="value" />
								</html:select>
							</td>
						</tr>
						<tr height ="30">
						    <td  align="left">
						    	<input type="button" class="button" value="  查 询  " onClick="Search();">
							</td>
						    <td >&nbsp;</td>
						    <td>&nbsp;</td> 
						    <td>&nbsp;</td>
						</tr>
						

					</table>

					
					<html:errors />
					<gdc:errors />
					
					<table width="100%">

						<tr>
							<td colspan="8" align="center"background="././images/splitter_bg_2.gif">&nbsp;</td>

						</tr>

					</table>

	
<br>

<table width="100%" border="1" id="results_table_1" align="center" cellpadding="2" cellspacing="0" borderColor="silver" class="datatable">


<tr bgcolor="E9EBEF">

	<td width="2%"><div align="center">序号</div></td>
	<td width="5%"><div align="center">任务名称</div></td>
	<td width="5%"><div align="center">负责人</div></td>
	<td width="5%"><div align="center">计划开始时间</div></td>
	<td width="5%"><div align="center">计划结束时间</div></td>
	<td width="5%"><div align="center">个人任务描述</div></td>
	<td width="5%"><div align="center">个人计划工作量</div></td>
	<td width="5%"><div align="center">状态</div></td>
	<td width="5%"><div align="center">操作</div></td>

</tr>


<logic:notEmpty name="result">
<logic:iterate id="item" name="result" indexId="index">



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
	<td align="center"><gdc:write name="item" property="status" labelvalue="TargetStatus"/></td>
	<td  align="center"><img src="././images/edit.gif" style="cursor:hand" alt="修改"
			onClick="location.href('targetPersonModifyPreAction.do?id=<bean:write name="item" property="id"/>');" >
	</td>
</tr>

</logic:iterate>

	
</logic:notEmpty>					

</table>

<br>

</html:form>

<html:form styleId="formpage" action="/targetPersonAction">		

			<gdc:pages />

</html:form>


				<br>



			</td>

		</tr>

	</table>

</body>


</html:html>




