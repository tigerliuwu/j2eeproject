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



<body>

		<table width="98%" cellpadding="0" cellspacing="0" align="center">

			<br>

			<tr>

				<td valign="top">

					<img src="././images/misc_arrow.gif">
					
					<strong><font color="#040466">&nbsp;&nbsp;查看项目验收报告</font></strong>

					<hr noshade width="100%" size="1">

					

					<table width="100%" border="1" align="center" cellpadding="2"

						cellspacing="0" borderColor="silver" class="datatable"

						id="MAIN_TABLE" style="display:block">


						<tr height="25">
							<td align="right" bgcolor="#E9EBEF" width="15%">项目名称：</td>
							<td bgcolor="#FFFFFF" width="35%">&nbsp;&nbsp;&nbsp;&nbsp;
								<bean:write name="project" property="projectName" />
							</td>
							<td align="right" bgcolor="#E9EBEF" width="15%">项目经理：</td>
							<td bgcolor="#FFFFFF" width="35%">&nbsp;&nbsp;&nbsp;&nbsp;
								<gdc:write name="project" property="pmId" labelvalue="Users" />
								</td>
						</tr>
						<tr height="25">
							<td align="right" bgcolor="#E9EBEF">项目概述：</td>
							<td bgcolor="#FFFFFF" colspan="3">&nbsp;&nbsp;&nbsp;&nbsp;
								<bean:write name="acceptReport" property="projectSummarize" />
							</td>
						</tr>
						<tr height="25">
							<td align="right" bgcolor="#E9EBEF">估计工作量：</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<bean:write name="acceptReport" property="workloadPlan"  />
							</td>
							<td align="right" bgcolor="#E9EBEF">实际工作量：</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<bean:write name="acceptReport" property="workloadFact"  />
							</td>
						 </tr>
						 <tr height="25">
							<td align="right" bgcolor="#E9EBEF">估计软件规模：</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<bean:write name="acceptReport" property="estimateSize" />
							</td>
							<td align="right" bgcolor="#E9EBEF">估计说明：</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<bean:write name="acceptReport" property="estimateRemark"  />
							</td>
						 </tr>
						<tr height="25">
							 <td align="right" bgcolor="#E9EBEF">第一风险：</td>
							 <td bgcolor="#FFFFFF" colspan="3">&nbsp;&nbsp;&nbsp;&nbsp;
								<bean:write  name="acceptReport" property="risk1" />
							</td>
						</tr>
						<tr height="25">
							 <td align="right" bgcolor="#E9EBEF">第二风险：</td>
							 <td bgcolor="#FFFFFF" colspan="3">&nbsp;&nbsp;&nbsp;&nbsp;
								<bean:write name="acceptReport" property="risk2" />
							</td>
						</tr>
						<tr height="25">
							 <td align="right" bgcolor="#E9EBEF">第三风险：</td>
							 <td bgcolor="#FFFFFF" colspan="3">&nbsp;&nbsp;&nbsp;&nbsp;
								<bean:write name="acceptReport" property="risk1" />
							</td>
						</tr>
						<tr height="25">
							 <td align="right" bgcolor="#E9EBEF">经验教训：</td>
							 <td bgcolor="#FFFFFF" colspan="3">&nbsp;&nbsp;&nbsp;&nbsp;
								<bean:write name="acceptReport" property="experience" />
							</td>
						</tr>
						<tr height="25">
							 <td align="right" bgcolor="#E9EBEF">验收评语：</td>
							 <td bgcolor="#FFFFFF" colspan="3">&nbsp;&nbsp;&nbsp;&nbsp;
								<bean:write name="acceptReport" property="acceptCommment" />
							</td>
						</tr>
						<tr height="25">
							 <td align="right" bgcolor="#E9EBEF">验收人：</td>
							 <td bgcolor="#FFFFFF"colspan="3">&nbsp;&nbsp;&nbsp;&nbsp;
								<bean:write name="acceptReport" property="acceptBy" />
							</td>
						</tr>
						
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right" >验收结论：</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<gdc:write name="acceptReport" property="acceptResult" labelvalue="ReportAccept"/>

							</td>
							<td align="right" bgcolor="#E9EBEF">验收日期：</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<bean:write name="acceptReport" property="acceptDate" formatKey="date.formkey"/>
							</td>
						 </tr>
				
						

					</table>

			  </td>

			</tr>

		</table>
		

		</body>

		</html>