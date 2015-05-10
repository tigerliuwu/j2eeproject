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
				<strong><font color="#040466">项目成员维护</font></strong>          
				<br><br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>项目名称：</strong>
				<bean:write name="project" property="projectName" />&nbsp;&nbsp;&nbsp;&nbsp;
				<strong>项目经理：</strong>
				<gdc:write name="project" property="pmId" labelvalue="Users"/>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="backCreateTeamUserPreAction.do?projectId=<bean:write name="project" property="id" />">添加新用户</a>
				<hr noshade width="100%" size="1">

				
					<br>



<table width="100%" border="1" id="results_table_1" align="center" cellpadding="2" cellspacing="0" borderColor="silver" class="datatable">


<tr bgcolor="E9EBEF">

	<td width="2%"><div align="center">序号</div></td>
	<td width="3%"><div align="center">用户名</div></td>
	<td width="2%"><div align="center">性别</div></td>
	<td width="7%"><div align="center">E-Mail地址</div></td>
	<td width="5%"><div align="center">办公电话</div></td>
	<td width="10%"><div align="center">角色</div></td>
	
</tr>



<logic:iterate id="item" name="result" indexId="index">

<tr onMouseOut="this.style.backgroundColor='#FFFFFF'" onMouseOver="this.style.backgroundColor='#DDDDDD'" >
	
	<td align="center">
		<gdc:iteratorNO indexId="index" />
	</td>
	<td align="center">
		<a href="backModifyTeamUserPreAction.do?projectId=<bean:write name="project" property="id" />&userId=<bean:write name="item" property="user.id" />" >
		<bean:write name="item" property="user.userName" />
		</a>	
	</td>
	<td align="center"><gdc:write name="item" property="user.sex" labelvalue="Sex"/></td>
	<td align="center"><bean:write name="item" property="user.email" /></td>
	<td align="center"><bean:write name="item" property="user.phone" /></td>
	<td align="center">
		<logic:iterate id="role" name="item" property="roleSet" indexId="index2">
			<gdc:write name="role" labelvalue="Roles"/>&nbsp;
		</logic:iterate>
	</td>
	
</tr>

</logic:iterate>		

</table>


<br>



			</td>

		</tr>

	</table>

 </body>


</html:html>




