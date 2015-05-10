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
<html:form action="/acceptReportCreateAction">
	<html:hidden name="acceptReportForm" property="id" />
	<html:hidden name="acceptReportForm" property="projectId" />

		<table width="98%" cellpadding="0" cellspacing="0" align="center">

			<br>

			<tr>

				<td valign="top">

					<img src="././images/misc_arrow.gif">
					
					<strong><font color="#040466">&nbsp;&nbsp;��д��Ŀ���ձ���</font></strong>

					<hr noshade width="100%" size="1">

					

					<table width="100%" border="1" align="center" cellpadding="2"

						cellspacing="0" borderColor="#FFFFFF" class="datatable"

						id="MAIN_TABLE" style="display:block">


						<tr height="25">
							<td align="right" bgcolor="#E9EBEF" width="15%">��Ŀ���ƣ�</td>
							<td bgcolor="#FFFFFF" width="35%">&nbsp;&nbsp;&nbsp;&nbsp;
								<bean:write name="project" property="projectName" />
							</td>
							<td align="right" bgcolor="#E9EBEF" width="15%">��Ŀ����</td>
							<td bgcolor="#FFFFFF" width="35%">&nbsp;&nbsp;&nbsp;&nbsp;
								<gdc:write name="project" property="pmId" labelvalue="Users" />
								</td>
						</tr>
						<tr height="25">
							<td align="right" bgcolor="#E9EBEF">��Ŀ������</td>
							<td bgcolor="#FFFFFF" colspan="3">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:textarea cols="120" rows="3" name="acceptReportForm" property="projectSummarize" />
							</td>
						</tr>
						<tr height="25">
							<td align="right" bgcolor="#E9EBEF">���ƹ�������</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:text name="acceptReportForm" property="workloadPlan"  styleClass="inputline" size="40" />
							</td>
							<td align="right" bgcolor="#E9EBEF">ʵ�ʹ�������</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:text name="acceptReportForm" property="workloadFact"  styleClass="inputline" size="40" />
							</td>
						 </tr>
						 <tr height="25">
							<td align="right" bgcolor="#E9EBEF">���������ģ��</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:text name="acceptReportForm" property="estimateSize"  styleClass="inputline" size="40" />
							</td>
							<td align="right" bgcolor="#E9EBEF">����˵����</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:text name="acceptReportForm" property="estimateRemark"  styleClass="inputline" size="40" />
							</td>
						 </tr>
						<tr height="25">
							 <td align="right" bgcolor="#E9EBEF">��һ���գ�</td>
							 <td bgcolor="#FFFFFF" colspan="3">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:textarea cols="120" rows="3" name="acceptReportForm" property="risk1" />
							</td>
						</tr>
						<tr height="25">
							 <td align="right" bgcolor="#E9EBEF">�ڶ����գ�</td>
							 <td bgcolor="#FFFFFF" colspan="3">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:textarea cols="120" rows="3" name="acceptReportForm" property="risk2" />
							</td>
						</tr>
						<tr height="25">
							 <td align="right" bgcolor="#E9EBEF">�������գ�</td>
							 <td bgcolor="#FFFFFF" colspan="3">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:textarea cols="120" rows="3" name="acceptReportForm" property="risk1" />
							</td>
						</tr>
						<tr height="25">
							 <td align="right" bgcolor="#E9EBEF">�����ѵ��</td>
							 <td bgcolor="#FFFFFF" colspan="3">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:textarea cols="120" rows="3" name="acceptReportForm" property="experience" />
							</td>
						</tr>
						<tr height="25">
							 <td align="right" bgcolor="#E9EBEF">�������</td>
							 <td bgcolor="#FFFFFF" colspan="3">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:textarea cols="120" rows="3" name="acceptReportForm" property="acceptCommment" />
							</td>
						</tr>
						<tr height="25">
							 <td align="right" bgcolor="#E9EBEF">�����ˣ�</td>
							 <td bgcolor="#FFFFFF"colspan="3">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:textarea cols="120" rows="3" name="acceptReportForm" property="acceptBy" />
							</td>
						</tr>
						
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right" >���ս��ۣ�</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<gdc:defineCollection id="accept0" labelvalue="ReportAccept"/>

								<html:select property="acceptResult" >	
								<html:optionsCollection name="accept0" label="label" value="value" />
								</html:select>
								

							</td>
							<td align="right" bgcolor="#E9EBEF">�������ڣ�</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:text name="acceptReportForm" property="acceptDate" onfocus="selectDate(this);" styleClass="inputline" size="40" />
							</td>
						 </tr>
						
						
						<logic:equal name="acceptReportForm" property="id" value="">
		
							<tr>
							<td colspan="4" bgcolor="#FFFFFF" align="center" height="50">
									<input type="submit" class="button" value="  �� ��  " />
							</td>
							</tr>
							
						</logic:equal>
						

					</table>

			  </td>

			</tr>

		</table>
		
		<html:errors />
		<gdc:errors />

		</html:form>

		</body>

		</html>