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
<html:form action="/riskCreateAction">
	<html:hidden name="riskForm" property="id" />
	<html:hidden name="riskForm" property="projectId" />

		<table width="98%" cellpadding="0" cellspacing="0" align="center">

			<br>

			<tr>

				<td valign="top">

					<img src="././images/misc_arrow.gif">
					
					<strong><font color="#040466">&nbsp;&nbsp;项目风险&nbsp;-->&nbsp;新建风险</font></strong>

					<hr noshade width="100%" size="1">

					

					<table width="100%" border="1" align="center" cellpadding="2"

						cellspacing="0" borderColor="#FFFFFF" class="datatable"

						id="MAIN_TABLE" style="display:block">


						<tr height="25">
							<td align="right" bgcolor="#E9EBEF" width="15%">风险描述：</td>
							<td bgcolor="#FFFFFF" width="35%">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:textarea cols="40" rows="3" name="riskForm" property="riskDescription" />
							</td>
						  </tr>
						<tr height="25">
							<td align="right" bgcolor="#E9EBEF">风险级别：</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<gdc:defineCollection id="level" labelvalue="RiskLevel"/>

								<html:select property="riskLevel" >	
								<html:optionsCollection name="level" label="label" value="value" />
								</html:select>
							</td>
						 </tr>
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right">发生概率：</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<gdc:defineCollection id="pro" labelvalue="RiskPro"/>

								<html:select property="probability" >	
								<html:optionsCollection name="pro" label="label" value="value" />
								</html:select>
							</td>
						</tr>
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right">提出人：</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:select property="submitById" >	
								<html:optionsCollection name="team" label="label" value="value" />
								</html:select>
							</td>
						</tr>
						<tr height="25">
							 <td align="right" bgcolor="#E9EBEF">产生的影响：</td>
							 <td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:textarea cols="40" rows="3" name="riskForm" property="influence" />
							</td>
						</tr>
						<tr height="25">
							 <td align="right" bgcolor="#E9EBEF">防范措施：</td>
							 <td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:textarea cols="40" rows="3" name="riskForm" property="keepAwayMeasure" />
							</td>
						</tr>
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right">风险状态：</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<gdc:defineCollection id="status0" labelvalue="RiskStatus"/>

								<html:select property="status" >	
								<html:optionsCollection name="status0" label="label" value="value" />
								</html:select>
							</td>
						</tr>
						
						
						<tr>
							<td colspan="4" bgcolor="#FFFFFF" align="center" height="50">
									<input type="submit" class="button" value="  提 交  " />
									&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="button" class="button" value="  返 回  " onClick="location.href('riskListAction.do');"/>
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