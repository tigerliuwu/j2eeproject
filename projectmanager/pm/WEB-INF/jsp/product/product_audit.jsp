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



<body>
<html:form action="/productAuditAction">
	<html:hidden name="productForm" property="id" />
	<html:hidden name="productForm" property="targetId" />

		<table width="98%" cellpadding="0" cellspacing="0" align="center">

			<br>

			<tr>

				<td valign="top">

					<img src="././images/misc_arrow.gif">
					
					<strong><font color="#040466">&nbsp;&nbsp;������Ʒ�б�&nbsp;-->&nbsp;����</font></strong>

					<hr noshade width="100%" size="1">

					

					<table width="100%" border="1" align="center" cellpadding="2"

						cellspacing="0" borderColor="#FFFFFF" class="datatable"

						id="MAIN_TABLE" style="display:block">

						<tr height="25">
							<td bgcolor="#E9EBEF" align="right" width="15%">��Ʒ���ƣ�</td>
							<td bgcolor="#FFFFFF" width="35%">&nbsp;&nbsp;&nbsp;&nbsp;
								<bean:write name="productForm" property="productName" />
								<html:hidden name="productForm" property="productName" />
							</td>
						</tr>
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right" width="15%">�����������ƣ�</td>
							<td bgcolor="#FFFFFF" width="35%">&nbsp;&nbsp;&nbsp;&nbsp;
								<bean:write name="productForm" property="targetName" />
								<html:hidden name="productForm" property="targetName" />
							</td>
						</tr>
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right" width="15%">�ƻ���ģ��</td>
							<td bgcolor="#FFFFFF" width="35%">&nbsp;&nbsp;&nbsp;&nbsp;
								<bean:write name="productForm" property="productSizePlan" />
								<gdc:write name="productForm" property="productUnit" labelvalue="ProductUnit" />
								<html:hidden name="productForm" property="productSizePlan" />
								<html:hidden name="productForm" property="productUnit" />
							</td>
						</tr>
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right" width="15%">Ŀǰ��ģ��</td>
							<td bgcolor="#FFFFFF" width="35%">&nbsp;&nbsp;&nbsp;&nbsp;
								<bean:write name="productForm" property="productSizeFact" />
								<gdc:write name="productForm" property="productUnit" labelvalue="ProductUnit" />
								<html:hidden name="productForm" property="productSizeFact" />
							</td>
						</tr>
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right" width="15%">�ύ�ˣ�</td>
							<td bgcolor="#FFFFFF" width="35%">&nbsp;&nbsp;&nbsp;&nbsp;
								<gdc:write name="productForm" property="referById" labelvalue="Users"/>
								<html:hidden name="productForm" property="referById" />
							</td>
						</tr>
						<tr height="25">
							<td align="right" bgcolor="#E9EBEF">�ύ���ڣ�</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:text name="productForm" property="referDate" styleClass="inputline" size="40" onfocus="selectDate(this);"/>
								<html:hidden name="productForm" property="referDate" />
							</td>
						  </tr>
						  <tr height="25">
							<td bgcolor="#E9EBEF" align="right" >���������</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:select property="status" >	
								<option value="<%=PMConstants.StatusProductPass%>">����ͨ��</option>	
								<option value="<%=PMConstants.StatusProductFail%>">������ͨ��</option>	
								</html:select>

							</td>
						</tr>
						<tr height="25">
							 <td align="right" bgcolor="#E9EBEF">����˵����</td>
							 <td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:textarea cols="40" rows="3" name="productForm" property="auditRemark" />
							
							</td>
						</tr>
						
						
						<tr>
							<td colspan="4" bgcolor="#FFFFFF" align="center" height="50">
									<input type="submit" class="button" value="  �� ��  " />
									&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="button" class="button" value="  �� ��  " onClick="location.href('productSearchPreAction.do');"/>
							</td>
						</tr>



					</table>



			  </td>

			</tr>

		</table>
		
		<html:errors />
		<gdc:errors />

		</html:form>

		</body>

		</html>