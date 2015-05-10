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

		document.forms[0].action = 'humanResSearchAction.do?isReturn=NO';	
		document.forms[0].submit();

	}
	
	function openTR0(object)
	{
		var rateinput = document.getElementById('tr2_'+object);
		var open_close=document.getElementById("open_close_"+object);

		if (rateinput.style.display == "none")  {
			rateinput.style.display = "block";	
			open_close.src="././images/open0.gif";
		}	
		else  {
			rateinput.style.display = "none";
			open_close.src="././images/close0.gif";
		}
		
	}
</script>

<body>



	<table width="98%" cellpadding="0" cellspacing="0" align="center">

	<br>



		<tr>

			<td valign="top">
				<img src="././images/misc_arrow.gif">
				<strong><font color="#040466">��֯��Դ״����ѯ</font></strong>&nbsp;&nbsp;&nbsp;&nbsp;
				<strong><font color="#040466">��Ŀ���ƣ�</font></strong>
				<bean:write name="project" property="projectName" />&nbsp;&nbsp;&nbsp;&nbsp;
				<strong><font color="#040466">��Ŀ����</font></strong>
				<gdc:write name="project" property="pmId" labelvalue="Users"/>
				
				<hr noshade width="98%" size="1" align="right">
				
				<html:form action="/humanResSearchAction">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<B>�������ڷ�Χ��</B>��&nbsp;&nbsp;<html:text name="humanResSearchForm" property="startDate" size="15" styleClass="inputline" onfocus="selectDate(this);"/>
					
					&nbsp;&nbsp;��&nbsp;&nbsp;<html:text name="humanResSearchForm" property="endDate" size="15" styleClass="inputline" onfocus="selectDate(this);"/>
					
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input  type="button" class="button" value="  ȷ ��  " onClick="Search();">
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input  type="button" class="button" value="  �� ��  " onClick="location.href('projectListAction.do');">
				</html:form>
				


<table width="98%" border="1" id="results_table_1" align="right" cellpadding="2" cellspacing="0" borderColor="silver" class="datatable">


<tr bgcolor="E9EBEF">

	<td width="2%"><div align="center">���</div></td>
	<td width="2%"><div align="center">�û���</div></td>
	<td width="2%"><div align="center">�Ա�</div></td>
	<td width="5%"><div align="center">E-Mail��ַ</div></td>
	<td width="5%"><div align="center">��ַ</div></td>
	<td width="5%"><div align="center">�칫�绰</div></td>
	
</tr>



<logic:notEmpty name="result">
<logic:iterate id="item" name="result" indexId="index">
<bean:define id="user" name="item" property="user" />
<bean:define id="weekWorkloads" name="item" property="weekWorkloadSet" />
<tr onMouseOut="this.style.backgroundColor='#FFFFFF'" onMouseOver="this.style.backgroundColor='#DDDDDD'" >
	
	<td align="center">
		<img src="././images/close0.gif" style="cursor:hand" onclick="openTR0('<bean:write name="user" property="id" />');"
		id="open_close_<bean:write name="user" property="id" />">
		<gdc:iteratorNO indexId="index" />
	</td>
	<td align="center"><bean:write name="user" property="userName" /></td>
	<td align="center"><gdc:write name="user" property="sex" labelvalue="Sex"/></td>
	<td align="center"><bean:write name="user" property="email" /></td>
	<td align="center"><bean:write name="user" property="address" /></td>
	<td align="center"><bean:write name="user" property="phone" /></td>
	
</tr>

<tr style="display:none" id="tr2_<bean:write name="user" property="id" />"  >
	<td align="center">&nbsp;</td>
	<td align="left" colspan="10" id="tr2_td_<bean:write name="user" property="id" />" >
		<br>
		<table width="98%" border="1" id="results_table_1" align="center" cellpadding="2" cellspacing="0" borderColor="silver" class="datatable">	
		<tr bgcolor="E9EBEF">	
			<td width="3%"><div align="center">���������</div></td>
			<td width="5%"><div align="center">��ʼ����</div></td>
			<td width="5%"><div align="center">��������</div></td>
			<td width="5%"><div align="center">���ɹ�����</div></td>
			<td width="5%"><div align="center">�ѷ��乤����</div></td>
			<td width="5%"><div align="center">����ɹ�����</div></td>		
		</tr>

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
		<br>
	</td>
	
</tr>

</logic:iterate>		
</logic:notEmpty>

</table>





			</td>

		</tr>

	</table>

 </body>


</html:html>




