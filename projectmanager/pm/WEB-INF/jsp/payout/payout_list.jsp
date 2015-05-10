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
		if(confirm('ȷ��ɾ��?')){
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
				<strong><font color="#040466">�ɱ������б�</font></strong>
				
				<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<strong><font color="#040466">��Ŀ���ƣ�</font></strong>
				<bean:write name="project" property="projectName" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<strong><font color="#040466">��ʼʱ�䣺</font></strong>
				<bean:write name="project" property="startDate" formatKey="date.formkey"/>&nbsp;&nbsp;&nbsp;&nbsp;
				<strong><font color="#040466">����ʱ�䣺</font></strong>
				<bean:write name="project" property="closeDate" formatKey="date.formkey"/>
				
				<gdc:Permission  permissionId="10201" >
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="payoutCreatePreAction.do">�����ɱ���Ϣ</a>
				</gdc:Permission>
				<hr noshade width="100%" size="1">
				
					

<table width="100%" border="1" id="results_table_1" align="center" cellpadding="2" cellspacing="0" borderColor="silver" class="datatable">


<tr bgcolor="E9EBEF">

	<td width="2%"><div align="center">���</div></td>
	<td width="5%"><div align="center">��ʼ����</div></td>
	<td width="5%"><div align="center">��������</div></td>
	<td width="5%"><div align="center">�ƻ�֧����Ԫ��</div></td>
	<td width="5%"><div align="center">ʵ��֧����Ԫ��</div></td>
	<td width="5%"><div align="center">֧��˵��</div></td>
	<td width="5%"><div align="center">����</div></td>
	
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
			<img src="././images/edit.gif" style="cursor:hand" alt="�޸�"
			onClick="location.href('payoutModifyPreAction.do?id=<bean:write name="item" property="id"/>');" >
		</gdc:Permission>
		&nbsp;&nbsp;
		<gdc:Permission  permissionId="10203" >
			<img src="././images/delete.gif" style="cursor:hand" alt="ɾ��"
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




