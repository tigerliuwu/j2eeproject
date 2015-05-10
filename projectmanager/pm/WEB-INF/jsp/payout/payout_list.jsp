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
			location.href('payoutDeleteAction.do?id='+id);	
		}
	}
	
</script>




<body>




	<table width="98%" cellpadding="0" cellspacing="0" align="center">

	<br>



		<tr>

			<td valign="top">
				
				<img src="././images/misc_arrow.gif">
				<strong><font color="#040466">成本数据列表</font></strong>
				
				<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<strong><font color="#040466">项目名称：</font></strong>
				<bean:write name="project" property="projectName" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<strong><font color="#040466">开始时间：</font></strong>
				<bean:write name="project" property="startDate" formatKey="date.formkey"/>&nbsp;&nbsp;&nbsp;&nbsp;
				<strong><font color="#040466">结束时间：</font></strong>
				<bean:write name="project" property="closeDate" formatKey="date.formkey"/>
				
				<gdc:Permission  permissionId="10201" >
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="payoutCreatePreAction.do">新增成本信息</a>
				</gdc:Permission>
				<hr noshade width="100%" size="1">
				
					

<table width="100%" border="1" id="results_table_1" align="center" cellpadding="2" cellspacing="0" borderColor="silver" class="datatable">


<tr bgcolor="E9EBEF">

	<td width="2%"><div align="center">序号</div></td>
	<td width="5%"><div align="center">开始日期</div></td>
	<td width="5%"><div align="center">结束日期</div></td>
	<td width="5%"><div align="center">计划支出（元）</div></td>
	<td width="5%"><div align="center">实际支出（元）</div></td>
	<td width="5%"><div align="center">支出说明</div></td>
	<td width="5%"><div align="center">操作</div></td>
	
</tr>




<logic:iterate id="item" name="result" indexId="index">

<tr onMouseOut="this.style.backgroundColor='#FFFFFF'" onMouseOver="this.style.backgroundColor='#DDDDDD'" >
	
	<td align="center"><gdc:iteratorNO indexId="index" /></td>
	
	<td align="center"><bean:write name="item" property="startDate" formatKey="date.formkey"/></td>
	<td align="center"><bean:write name="item" property="endDate" formatKey="date.formkey"/></td>
	<td align="center"><bean:write name="item" property="payPlan" formatKey="currency.2.formkey"/></td>
	<td align="center"><bean:write name="item" property="payFact" formatKey="currency.2.formkey"/></td>
	<td align="center"><bean:write name="item" property="remark" /></td>
	<td align="center">
		<gdc:Permission  permissionId="10202" >
			<img src="././images/edit.gif" style="cursor:hand" alt="修改"
			onClick="location.href('payoutModifyPreAction.do?id=<bean:write name="item" property="id"/>');" >
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


<br>
  <html:form styleId="formpage" action="/payoutListAction">
			<gdc:pages />
  </html:form>
<br>



			</td>

		</tr>

	</table>

 </body>

</html>




