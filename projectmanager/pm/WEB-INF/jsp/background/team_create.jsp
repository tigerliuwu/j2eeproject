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

<html:form action="/backCreateTeamUserAction">
	<input type="hidden" name="projectId" value='<bean:write name="project" property="id" />'/>
	<table width="98%" cellpadding="0" cellspacing="0" align="center">

	<br>

		<tr>

			<td valign="top">
				<img src="././images/misc_arrow.gif">
				<strong><font color="#040466">项目成员维护&nbsp;-->&nbsp;添加新成员</font></strong>          
				<br><br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>项目名称：</strong>
				<bean:write name="project" property="projectName" />&nbsp;&nbsp;&nbsp;&nbsp;
				<strong>项目经理：</strong>
				<gdc:write name="project" property="pmId" labelvalue="Users"/>
				<hr noshade width="100%" size="1">

				
				<br>

				<div align=center>
				成员姓名：
				<html:select property="userId" >
				<html:optionsCollection name="notTeam" label="label" value="value" />
				</html:select>
				</div>
				<br>
<table width="50%" border="1" id="results_table_1" align="center" cellpadding="2" cellspacing="0" borderColor="silver" class="datatable">


<tr bgcolor="E9EBEF">

	<td width="2%"><div align="center">选择</div></td>
	<td width="5%"><div align="center">角色</div></td>
	
</tr>


<gdc:defineCollection id="roles" labelvalue="Roles"/>

<logic:iterate id="role" name="roles" indexId="index">

<tr onMouseOut="this.style.backgroundColor='#FFFFFF'" onMouseOver="this.style.backgroundColor='#DDDDDD'" >
	
	
	<td align="center">
		<input type="checkbox" name="checkbox_<bean:write name="role" property="id" />"
			
	    	<logic:equal name="role" property="id" value="<%=PMConstants.ROLE_PM.toString()%>" >
					disabled='true'
			</logic:equal>
	    	
	    />
	</td>
	<td align="center"><bean:write name="role" property="remark" /></td>
	
</tr>

</logic:iterate>	

</table>


<br>

		<div align=center>
			<input type="submit" class="button" value="   提 交    ">
			<input type="button" class="button" value="   返 回    " onClick="location.href='backProjectTeamPreAction.do?id=<bean:write name="project" property="id" />'">
		</div>
</html:form>
			</td>

		</tr>

	</table>

 </body>


</html:html>




