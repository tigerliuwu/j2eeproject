<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="GBK"%>

<%@ page import="edu.pm.constants.PMConstants" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<%@ taglib uri="/WEB-INF/struts-gdc.tld" prefix="gdc"%>


<html>

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
	
	function before_delete(id)
	{
		if(confirm('确认删除?')){
			location.href('problemDeleteAction.do?id='+id);	
		}
	}
	
	function Sum0()
	{
	
		var form0=document.waitForm;
		
		var waitWork=form0.waitWork;
		
		if(waitWork.checked)
		{
			form0.action="problemSumAction.do";
			form0.submit();
			return;
		}
		
		var checkCount=0;
		for(i=0;i<waitWork.length;i++)
		{
			if(waitWork[i].checked)
			{
				checkCount++;
				break;
			}
		}
		if(checkCount==0)
		{
			alert("请先选择待汇总问题");
		}
		else
		{
			form0.action="problemSumAction.do";
			form0.submit();
		}
		
	}
	
	function Delete0()
	{
		var form0=document.waitForm;
		
		var waitWork=form0.waitWork;
		
		if(waitWork.checked)
		{
			if(confirm('确认删除?')){
				form0.action="problemDeleteAction.do";
				form0.submit();
			}
			
			return;
		}
		
		
		var checkCount=0;
		for(i=0;i<waitWork.length;i++)
		{
			if(waitWork[i].checked)
			{
				checkCount++;
				break;
			}
		}
		if(checkCount==0)
		{
			alert("请先选择待删除问题");
		}
		else
		{
			if(confirm('确认删除?')){
				form0.action="problemDeleteAction.do";
				form0.submit();
			}
		}
	}
	
</script>




<body>




	<table width="98%" cellpadding="0" cellspacing="0" align="center">

	<br>



		<tr>

			<td valign="top">
				
				<img src="././images/misc_arrow.gif">
				<strong><font color="#040466">问题列表</font></strong>
				
				<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<strong><font color="#040466">项目名称：</font></strong>
				<bean:write name="project" property="projectName" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<strong><font color="#040466">项目经理：</font></strong>
				<gdc:write name="project" property="pmId" labelvalue="Users"/>
				
				<gdc:Permission  permissionId="40201" >
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="problemCreatePreAction.do">添加新问题</a>
				</gdc:Permission>
				
				<hr noshade width="100%" size="1">
				
				

<table width="100%" border="1" id="results_table_1" align="center" cellpadding="2" cellspacing="0" borderColor="silver" class="datatable">


<tr bgcolor="E9EBEF">

	<td width="2%"><div align="center">序号</div></td>
	<td width="10%"><div align="center">问题描述</div></td>
	<td width="5%"><div align="center">纠正措施</div></td>
	<td width="5%"><div align="center">提出人</div></td>
	<td width="5%"><div align="center">提交日期</div></td>
	<td width="5%"><div align="center">严重程度</div></td>
	<td width="5%"><div align="center">解决人</div></td>
	<td width="5%"><div align="center">验证人</div></td>
	<td width="5%"><div align="center">问题状态</div></td>
	<td width="5%"><div align="center">操作</div></td>
	
</tr>




<logic:iterate id="item1" name="result1" indexId="index1">

<tr onMouseOut="this.style.backgroundColor='#FFFFFF'" onMouseOver="this.style.backgroundColor='#DDDDDD'" >
	
	<td align="center"><gdc:iteratorNO indexId="index1" /></td>
	
	<td align="center"><bean:write name="item1" property="problemDescription" /></td>
	<td align="center"><bean:write name="item1" property="correctMeasure" /></td>
	<td align="center"><gdc:write name="item1" property="submitById" labelvalue="Users"/></td>
	<td align="center"><bean:write name="item1" property="submitDate" formatKey="date.formkey"/></td>
	<td align="center"><font color='red'><gdc:write name="item1" property="problemLevel" labelvalue="ProblemLevel"/></font></td>
	<td align="center"><gdc:write name="item1" property="solveById" labelvalue="Users"/></td>
	<td align="center"><gdc:write name="item1" property="validateById" labelvalue="Users"/></td>
	<td align="center"><gdc:write name="item1" property="status" labelvalue="ProblemStatus"/></td>
	<td align="center">
		<gdc:Permission  permissionId="40202" >
			<img src="././images/edit.gif" style="cursor:hand" alt="修改"
			onClick="location.href('problemModifyPreAction.do?id=<bean:write name="item1" property="id"/>');" >
		</gdc:Permission>
		&nbsp;&nbsp;
		<gdc:Permission  permissionId="40203" >
			<img src="././images/delete.gif" style="cursor:hand" alt="删除"
			onClick="before_delete('<bean:write name="item1" property="id"/>')" >
		</gdc:Permission>
	</td>
	
</tr>


</logic:iterate>		

</table>

<form name="waitForm" action="">

				<img src="././images/misc_arrow.gif">
				<strong><font color="#040466">待汇总问题</font></strong>
				
				
				<hr noshade width="100%" size="1">
				
				

<table width="100%" border="1" id="results_table_2" align="center" cellpadding="2" cellspacing="0" borderColor="silver" class="datatable">


<tr bgcolor="E9EBEF">

	<td width="2%"><div align="center">序号</div></td>
	<td width="35%"><div align="center">问题描述</div></td>
	<td width="5%"><div align="center">提出人</div></td>
	<td width="5%"><div align="center">提交日期</div></td>
	<td width="5%"><div align="center">选择</div></td>
	
</tr>




<logic:iterate id="item2" name="result2" indexId="index2">

<tr onMouseOut="this.style.backgroundColor='#FFFFFF'" onMouseOver="this.style.backgroundColor='#DDDDDD'" >
	
	<td align="center"><gdc:iteratorNO indexId="index2" /></td>
	
	<td align="center"><bean:write name="item2" property="problemDescription" /></td>
	<td align="center"><gdc:write name="item2" property="submitById" labelvalue="Users"/></td>
	<td align="center"><bean:write name="item2" property="submitDate" formatKey="date.formkey"/></td>
	<td align="center"><input type=checkbox name="waitWork"  value='<bean:write name="item2" property="id"/>' /></td>
	
</tr>


</logic:iterate>	



</table>


			</td>

		</tr>
		
		
		<tr height="50"><td align="center">
			<gdc:Permission  permissionId="40204" >
				<input  type="button" class="button" value="  汇 总  " onClick="Sum0()"/>
			</gdc:Permission>
			<gdc:Permission  permissionId="40205" >
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input  type="button" class="button" value="  删 除  " onClick="Delete0()"/>
			</gdc:Permission>
			
		</td><tr>

	</table>
	
	
</form>	

 </body>

</html>




