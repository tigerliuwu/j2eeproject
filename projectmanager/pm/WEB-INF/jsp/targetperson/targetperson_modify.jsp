<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="GBK"%>

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
<html:form action="/targetPersonModifyAction">
	<html:hidden name="targetForm" property="id" />
	<html:hidden name="targetForm" property="projectId" />
	<html:hidden name="targetForm" property="userSEId" />
	<html:hidden name="targetForm" property="userPLId" />
	<html:hidden name="targetForm" property="parentId" />
	<html:hidden name="targetForm" property="startDatePlan" />
	<html:hidden name="targetForm" property="endDatePlan" />
	<html:hidden name="targetForm" property="workloadPlan" />
	<html:hidden name="targetForm" property="targetLevel" />
	<html:hidden name="targetForm" property="isParent" />
	<html:hidden name="targetForm" property="displayColor" />
	<html:hidden name="targetForm" property="isDeleted" />
	<html:hidden name="targetForm" property="targetOrder" />
	<html:hidden name="targetForm" property="targetName" />

		<table width="98%" cellpadding="0" cellspacing="0" align="center">

			<br>

			<tr>

				<td valign="top">

					<img src="././images/misc_arrow.gif">
					
					<strong><font color="#040466">&nbsp;&nbsp;����������Ϣ&nbsp;-->&nbsp;�༭����</font></strong>

					<hr noshade width="100%" size="1">

					

					<table width="100%" border="1" align="center" cellpadding="2"

						cellspacing="0" borderColor="#FFFFFF" class="datatable"

						id="MAIN_TABLE" style="display:block">


						<tr height="25">
							<td bgcolor="#E9EBEF" align="right">�������ƣ�</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<bean:write name="targetForm" property="targetName" />
							</td>
						</tr>
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right">�����ˣ�</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<gdc:write name="targetForm" property="userSEId" labelvalue="Users"/>
							</td>
						</tr>
						<tr height="25">
							<td align="right" bgcolor="#E9EBEF" width="15%">��������������</td>
							<td bgcolor="#FFFFFF" width="35%">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:textarea cols="40" rows="3" name="targetForm" property="remark" />
							</td>
						  </tr>
						<tr height="25">
							<td align="right" bgcolor="#E9EBEF">�ƻ���ʼʱ�䣺</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<bean:write name="targetForm" property="startDatePlan" formatKey="date.formkey"/>
							</td>
						  </tr>
						  <tr height="25">
							<td align="right" bgcolor="#E9EBEF">�ƻ�����ʱ�䣺</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<bean:write name="targetForm" property="endDatePlan" formatKey="date.formkey"/>
							</td>
						  </tr>
						  <tr height="25">
							<td align="right" bgcolor="#E9EBEF">ʵ�ʿ�ʼ���ڣ�</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:text name="targetForm" property="startDateFact" styleClass="inputline" size="40" onfocus="selectDate(this);"/>
							</td>
						  </tr>
						   <tr height="25">
							<td align="right" bgcolor="#E9EBEF">ʵ�ʽ������ڣ�</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:text name="targetForm" property="endDateFact" styleClass="inputline" size="40" onfocus="selectDate(this);"/>
							</td>
						  </tr>
						  <tr height="25">
							<td align="right" bgcolor="#E9EBEF">�ƻ���������</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<bean:write name="targetForm" property="workloadPlan" />
							</td>
						  </tr>
						  <tr height="25">
							<td bgcolor="#E9EBEF" align="right">ʵ�ʹ�������</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:text name="targetForm" property="workloadFact" styleClass="inputline" size="40"  />
							</td>
						</tr>
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right">����״̬��</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<gdc:defineCollection id="status0" labelvalue="TargetStatus"/>

								<html:select property="status" >	
								<html:optionsCollection name="status0" label="label" value="value" />
								</html:select>
							</td>
						</tr>
						<tr height="25">
							 <td align="right" bgcolor="#E9EBEF">ִ�������</td>
							 <td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:textarea cols="40" rows="3" name="targetForm" property="excuteStatus" />
							</td>
						</tr>
						
						
						<tr>
							<td colspan="4" bgcolor="#FFFFFF" align="center" height="50">
									<input type="submit" class="button" value="  �� ��  " />
									&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="button" class="button" value="  �� ��  " onClick="location.href('targetPersonPreAction.do');"/>
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