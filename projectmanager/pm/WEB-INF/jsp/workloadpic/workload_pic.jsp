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

	function Search() {

		document.forms[0].action = 'workloadPicAction.do?isReturn=NO';	
		document.forms[0].submit();

	}
	
</script>

<body>



	<table width="98%" cellpadding="0" cellspacing="0" align="center">

	<br>



		<tr>

			<td valign="top">
				<img src="././images/misc_arrow.gif">
				<strong><font color="#040466">人员工作量分布</font></strong>&nbsp;&nbsp;&nbsp;&nbsp;
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
	<logic:notEmpty name="filename">			
				
 <table>		
 		<tr><td align=middle width=100%>               
          
		<img src="/pm/DisplayChart?filename=<bean:write name="filename" />" width=600 height=360 border=0/>
		<br>
		<br>	
		</td></tr>
</table>
	</logic:notEmpty>	

<table width="98%" border="1" id="results_table_1" align="right" cellpadding="2" cellspacing="0" borderColor="silver" class="datatable">


<tr bgcolor="E9EBEF">

	<td width="2%"><div align="center">序号</div></td>
	<td width="5%"><div align="center">工作人员</div></td>
	<td width="5%"><div align="center">开始日期</div></td>
	<td width="5%"><div align="center">结束日期</div></td>
	<td width="5%"><div align="center">满荷工作量</div></td>
	<td width="5%"><div align="center">已分配工作量</div></td>
	<td width="5%"><div align="center">已完成工作量</div></td>		
	
</tr>

<logic:notEmpty name="result">
<logic:iterate id="item" name="result" indexId="index">
<tr onMouseOut="this.style.backgroundColor='#FFFFFF'" onMouseOver="this.style.backgroundColor='#DDDDDD'" >
	
	<td align="center">
				<gdc:iteratorNO indexId="index" />
			</td>
	<td align="center"><gdc:write name="item" property="userId" labelvalue="Users"/></td>
	<td align="center"><bean:write name="item" property="startDate" formatKey="date.formkey"/></td>
	<td align="center"><bean:write name="item" property="endDate" formatKey="date.formkey"/></td>
	<td align="center"><bean:write name="item" property="workloadAll" /></td>
	<td align="center"><bean:write name="item" property="workloadAssign" /></td>
	<td align="center"><bean:write name="item" property="workloadOver" /></td>		
	
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




