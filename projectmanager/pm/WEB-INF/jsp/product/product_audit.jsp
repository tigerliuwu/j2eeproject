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
					
					<strong><font color="#040466">&nbsp;&nbsp;工作产品列表&nbsp;-->&nbsp;审批</font></strong>

					<hr noshade width="100%" size="1">

					

					<table width="100%" border="1" align="center" cellpadding="2"

						cellspacing="0" borderColor="#FFFFFF" class="datatable"

						id="MAIN_TABLE" style="display:block">

						<tr height="25">
							<td bgcolor="#E9EBEF" align="right" width="15%">产品名称：</td>
							<td bgcolor="#FFFFFF" width="35%">&nbsp;&nbsp;&nbsp;&nbsp;
								<bean:write name="productForm" property="productName" />
								<html:hidden name="productForm" property="productName" />
							</td>
						</tr>
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right" width="15%">所属任务名称：</td>
							<td bgcolor="#FFFFFF" width="35%">&nbsp;&nbsp;&nbsp;&nbsp;
								<bean:write name="productForm" property="targetName" />
								<html:hidden name="productForm" property="targetName" />
							</td>
						</tr>
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right" width="15%">计划规模：</td>
							<td bgcolor="#FFFFFF" width="35%">&nbsp;&nbsp;&nbsp;&nbsp;
								<bean:write name="productForm" property="productSizePlan" />
								<gdc:write name="productForm" property="productUnit" labelvalue="ProductUnit" />
								<html:hidden name="productForm" property="productSizePlan" />
								<html:hidden name="productForm" property="productUnit" />
							</td>
						</tr>
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right" width="15%">目前规模：</td>
							<td bgcolor="#FFFFFF" width="35%">&nbsp;&nbsp;&nbsp;&nbsp;
								<bean:write name="productForm" property="productSizeFact" />
								<gdc:write name="productForm" property="productUnit" labelvalue="ProductUnit" />
								<html:hidden name="productForm" property="productSizeFact" />
							</td>
						</tr>
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right" width="15%">提交人：</td>
							<td bgcolor="#FFFFFF" width="35%">&nbsp;&nbsp;&nbsp;&nbsp;
								<gdc:write name="productForm" property="referById" labelvalue="Users"/>
								<html:hidden name="productForm" property="referById" />
							</td>
						</tr>
						<tr height="25">
							<td align="right" bgcolor="#E9EBEF">提交日期：</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:text name="productForm" property="referDate" styleClass="inputline" size="40" onfocus="selectDate(this);"/>
								<html:hidden name="productForm" property="referDate" />
							</td>
						  </tr>
						  <tr height="25">
							<td bgcolor="#E9EBEF" align="right" >审批结果：</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:select property="status" >	
								<option value="<%=PMConstants.StatusProductPass%>">审批通过</option>	
								<option value="<%=PMConstants.StatusProductFail%>">审批不通过</option>	
								</html:select>

							</td>
						</tr>
						<tr height="25">
							 <td align="right" bgcolor="#E9EBEF">审批说明：</td>
							 <td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:textarea cols="40" rows="3" name="productForm" property="auditRemark" />
							
							</td>
						</tr>
						
						
						<tr>
							<td colspan="4" bgcolor="#FFFFFF" align="center" height="50">
									<input type="submit" class="button" value="  提 交  " />
									&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="button" class="button" value="  返 回  " onClick="location.href('productSearchPreAction.do');"/>
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