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
<html:form action="/projectReportCreateAction">
	<html:hidden name="projectReportForm" property="id" />
	<html:hidden name="projectReportForm" property="projectId" />

		<table width="98%" cellpadding="0" cellspacing="0" align="center">

			<br>

			<tr>

				<td valign="top">

					<img src="././images/misc_arrow.gif">
					
					<strong><font color="#040466">&nbsp;&nbsp;新建项目报告</font></strong>

					<hr noshade width="100%" size="1">

					

					<table width="100%" border="1" align="center" cellpadding="2"

						cellspacing="0" borderColor="#FFFFFF" class="datatable"

						id="MAIN_TABLE" style="display:block">


						<tr height="25">
							<td align="right" bgcolor="#E9EBEF" width="15%">报告名称：</td>
							<td bgcolor="#FFFFFF" width="35%">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:text name="projectReportForm" property="reportName" styleClass="inputline" size="40" />
							</td>
						  </tr>
						<tr height="25">
							<td align="right" bgcolor="#E9EBEF">报告日期：</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:text name="projectReportForm" property="reportDate" onfocus="selectDate(this);" styleClass="inputline" size="40" />
							</td>
						 </tr>
						<tr height="25">
							 <td align="right" bgcolor="#E9EBEF">项目进展情况：</td>
							 <td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:textarea cols="40" rows="3" name="projectReportForm" property="excuteStatus" />
							</td>
						</tr>
						<tr height="25">
							 <td align="right" bgcolor="#E9EBEF">主要问题：</td>
							 <td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:textarea cols="40" rows="3" name="projectReportForm" property="problem" />
							</td>
						</tr>
						<tr height="25">
							 <td align="right" bgcolor="#E9EBEF">主要风险：</td>
							 <td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:textarea cols="40" rows="3" name="projectReportForm" property="risk" />
							</td>
						</tr>
						<tr height="25">
							 <td align="right" bgcolor="#E9EBEF">下阶段安排：</td>
							 <td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:textarea cols="40" rows="3" name="projectReportForm" property="nextPlan" />
							</td>
						</tr>
						
						
						<tr>
							<td colspan="4" bgcolor="#FFFFFF" align="center" height="50">
									<input type="submit" class="button" value="  提 交  " />
									&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="button" class="button" value="  返 回  " onClick="location.href('projectReportListAction.do');"/>
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