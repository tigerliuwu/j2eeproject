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

		document.forms[0].action = 'productSearchAction.do?isReturn=NO';	
		document.forms[0].submit();

	}


</script>

<body>




	<table width="98%" cellpadding="0" cellspacing="0" align="center">

	<br>



		<tr>

			<td valign="top">
				
				<html:form action="/productSearchAction">
				
				<img src="././images/misc_arrow.gif">
				<strong><font color="#040466">������Ʒ�б�</font></strong>
				
				<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<strong><font color="#040466">��Ŀ���ƣ�</font></strong>
				<bean:write name="project" property="projectName" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<strong><font color="#040466">��Ŀ����</font></strong>
				<gdc:write name="project" property="pmId" labelvalue="Users"/>
				
				<hr noshade width="100%" size="1">
				
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;<B>�ύ�ˣ�</B>&nbsp;&nbsp;
					<html:select name="productSearchForm" property="condition.referById">
						<option value="">--����--</option>	
						<html:optionsCollection name="team" label="label" value="value" />
					</html:select>
					
					&nbsp;&nbsp;<B>��Ʒ״̬��</B>&nbsp;&nbsp;
					
					<gdc:defineCollection id="status0" labelvalue="ProductStatus"/>
					<html:select name="productSearchForm" property="condition.status">
						<option value="">--����--</option>	
						<html:optionsCollection name="status0" label="label" value="value" />
					</html:select>
					
					&nbsp;&nbsp;&nbsp;&nbsp;<input  type="button" class="button" value="  �� ѯ  " onclick="Search();" >
					
					
				
				<br>
				<html:errors />
				<gdc:errors />
				<br>



<table width="100%" border="1" id="results_table_1" align="center" cellpadding="2" cellspacing="0" borderColor="silver" class="datatable">


<tr bgcolor="E9EBEF">

	<td width="2%"><div align="center">���</div></td>
	<td width="8%"><div align="center">������Ʒ����</div></td>
	<td width="8%"><div align="center">������������</div></td>
	<td width="5%"><div align="center">�ƻ���ģ</div></td>
	<td width="5%"><div align="center">Ŀǰ��ģ</div></td>
	<td width="5%"><div align="center">��ģ��λ</div></td>
	<td width="5%"><div align="center">�ύ��</div></td>
	<td width="5%"><div align="center">�ύ����</div></td>
	<td width="5%"><div align="center">״̬</div></td>
	<td width="5%"><div align="center">����</div></td>
	
</tr>


<logic:notEmpty name="result">
<logic:iterate id="item" name="result" indexId="index">

<tr onMouseOut="this.style.backgroundColor='#FFFFFF'" onMouseOver="this.style.backgroundColor='#DDDDDD'" >
	
	<td align="center"><gdc:iteratorNO indexId="index" /></td>
	<td align="center"><bean:write name="item" property="productName" /></td>
	<td align="center"><bean:write name="item" property="targets.targetName" /></td>
	<td align="center"><bean:write name="item" property="productSizePlan" /></td>
	<td align="center"><bean:write name="item" property="productSizeFact" /></td>
	<td align="center"><gdc:write name="item" property="productUnit" labelvalue="ProductUnit" /></td>
	<td align="center"><gdc:write name="item" property="referById" labelvalue="Users"/></td>
	<td align="center"><bean:write name="item" property="referDate" formatKey="date.formkey"/></td>
	<td align="center"><gdc:write name="item" property="status" labelvalue="ProductStatus" /></td>
	<td align="center">
	
		<logic:equal name="item" property="status" value="<%=PMConstants.StatusProductHandin%>">
		
			<img src="././images/audit.gif" style="cursor:hand" alt="����"
			onClick="location.href('productAuditPreAction.do?id=<bean:write name="item" property="id"/>');" >
		
		</logic:equal>
		
	</td>
	
</tr>


</logic:iterate>
</logic:notEmpty>	

</table>

</html:form>


<br>
  <html:form styleId="formpage" action="/productSearchAction">
			<gdc:pages />
  </html:form>
<br>



			</td>

		</tr>

	</table>

 </body>


</html:html>




