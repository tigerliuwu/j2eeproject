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
<html:form action="/projectInforUpdateAction">
	<html:hidden name="projectForm" property="id" />
	<html:hidden name="projectForm" property="isDeleted" />

		<table width="98%" cellpadding="0" cellspacing="0" align="center">

			<br>

			<tr>

				<td valign="top">

					<img src="././images/misc_arrow.gif">
					
					<strong><font color="#040466">&nbsp;&nbsp;项目信息</font>	</strong>

					<hr noshade width="100%" size="1">

					

					<table width="100%" border="1" align="center" cellpadding="2"

						cellspacing="0" borderColor="#FFFFFF" class="datatable"

						id="MAIN_TABLE" style="display:block">



						<tr height="25">
							<td bgcolor="#E9EBEF" align="right" width="15%">项目编号：</td>
							<td bgcolor="#FFFFFF" width="35%">&nbsp;&nbsp;&nbsp;&nbsp;
								<bean:write name="projectForm" property="projectCode" />
								<html:hidden name="projectForm" property="projectCode" />
							</td>
						</tr>
						
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right" >项目名称：</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<bean:write name="projectForm" property="projectName" />
								<html:hidden name="projectForm" property="projectName" />
							</td>
						</tr>
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right" >项目经理：</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<gdc:write name="projectForm" property="pmId" labelvalue="Users" />
								<html:hidden name="projectForm" property="pmId" />
							</td>
						</tr>
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right">项目成员：</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<bean:write name="projectForm" property="userList" />
							</td>
						</tr>
						<tr height="25">
							<td align="right" bgcolor="#E9EBEF">开始日期：</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:text name="projectForm" property="startDate" styleClass="inputline" size="40" onfocus="selectDate(this);"/>
							</td>
						  </tr>
						<tr height="25">
							<td align="right" bgcolor="#E9EBEF">结束日期：</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:text name="projectForm" property="closeDate" onfocus="selectDate(this);" styleClass="inputline" size="40" />
							</td>
						 </tr>
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right">项目预算：</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:text name="projectForm" property="budget" styleClass="inputline" size="40" />
							</td>
						</tr>
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right" >团队规模：</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:text name="projectForm" property="teamSize" styleClass="inputline" size="40" />
							</td>
						</tr>
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right" >开发平台：</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:text name="projectForm" property="developRoof" styleClass="inputline" size="40" />
							</td>
						</tr>
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right" >开发语言：</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:text name="projectForm" property="developLanguage" styleClass="inputline" size="40" />
							</td>
						</tr>				
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right" >人员成本：</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:text name="projectForm" property="personCost" styleClass="inputline" size="40" />
							</td>
						</tr>				
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right" >项目状态：</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								
								<gdc:defineCollection id="status" labelvalue="ProjectStatus"/>

								<html:select property="status" >	
								<html:optionsCollection name="status" label="label" value="value" />
								</html:select>

							</td>
						</tr>
						<tr height="25">
							 <td align="right" bgcolor="#E9EBEF">项目目标：</td>
							 <td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:textarea cols="40" rows="3" name="projectForm" property="projectGoal" />
							
							</td>
						</tr>	
						
						
						<gdc:Permission  permissionId="10101" >
							
							<tr>
								<td colspan="4" bgcolor="#FFFFFF" align="center" height="50">
										<input type="submit" class="button" value="  提 交  " />
								</td>
							</tr>

						</gdc:Permission>
						

						



					</table>



			  </td>

			</tr>

		</table>
		
		<html:errors />
		<gdc:errors />

		</html:form>

		</body>

		</html>