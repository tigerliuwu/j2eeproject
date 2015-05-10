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
	
	function before_delete(id)
	{
		if(confirm('确认删除?')){
			location.href('weekDeleteAction.do?id='+id);	
		}
	}
	
</script>




<body>




	<table width="98%" cellpadding="0" cellspacing="0" align="center">

	<br>



		<tr>

			<td valign="top">
				
				<html:form action="/weekCreateAction">
				
				<img src="././images/misc_arrow.gif">
				<strong><font color="#040466">工作周设置</font></strong>
				
				<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<strong><font color="#040466">项目名称：</font></strong>
				<bean:write name="project" property="projectName" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<strong><font color="#040466">开始时间：</font></strong>
				<bean:write name="project" property="startDate" formatKey="date.formkey"/>&nbsp;&nbsp;&nbsp;&nbsp;
				<strong><font color="#040466">结束时间：</font></strong>
				<bean:write name="project" property="closeDate" formatKey="date.formkey"/>
				<hr noshade width="100%" size="1">
				
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;<B>开始日期：</B>&nbsp;&nbsp;<html:text name="weekForm" property="startDate" size="15" styleClass="inputline" onfocus="selectDate(this);"/>
					
					&nbsp;&nbsp;<B>结束日期：</B>&nbsp;&nbsp;<html:text name="weekForm" property="endDate" size="15" styleClass="inputline" onfocus="selectDate(this);"/>
					
					&nbsp;&nbsp;<B>单日工作量：</B>&nbsp;&nbsp;<html:text name="weekForm" property="workloadPerDay" size="5" styleClass="inputline" />
					&nbsp;&nbsp;人时
					
					&nbsp;&nbsp;&nbsp;&nbsp;<input  type="submit" class="button" value="  添 加  " >
					
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="weekDefaultPreAction.do">设置缺省工作周</a>
					
				
				<br>
				<html:errors />
				<gdc:errors />
				<br>



<table width="100%" border="1" id="results_table_1" align="center" cellpadding="2" cellspacing="0" borderColor="silver" class="datatable">


<tr bgcolor="E9EBEF">

	<td width="2%"><div align="center">序号</div></td>
	<td width="5%"><div align="center">开始日期</div></td>
	<td width="5%"><div align="center">结束日期</div></td>
	<td width="5%"><div align="center">满荷工作量</div></td>
	<td width="5%"><div align="center">操作</div></td>
	
</tr>




<logic:iterate id="item" name="result" indexId="index">

<tr onMouseOut="this.style.backgroundColor='#FFFFFF'" onMouseOver="this.style.backgroundColor='#DDDDDD'" >
	
	<td align="center"><gdc:iteratorNO indexId="index" /></td>
	
	<td align="center"><bean:write name="item" property="startDate" formatKey="date.formkey"/></td>
	<td align="center"><bean:write name="item" property="endDate" formatKey="date.formkey"/></td>
	<td align="center"><bean:write name="item" property="workloadAll" /></td>
	<td align="center">
		<gdc:Permission  permissionId="10202" >
			<img src="././images/edit.gif" style="cursor:hand" alt="修改"
			onClick="location.href('weekModifyPreAction.do?id=<bean:write name="item" property="id"/>');" >
		</gdc:Permission>
		&nbsp;&nbsp;
		<gdc:Permission  permissionId="10203" >
			<img src="././images/delete.gif" style="cursor:hand" alt="删除"
			onClick="before_delete('<bean:write name="item" property="id"/>')" >
		</gdc:Permission>
	</td>
	
</tr>


</logic:iterate>		

</table>

</html:form>


<br>
  <html:form styleId="formpage" action="/weekListAction">
			<gdc:pages />
  </html:form>
<br>



			</td>

		</tr>

	</table>

 </body>


</html:html>




