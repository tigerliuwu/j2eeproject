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
<html:form action="/problemModifyAction">
	<html:hidden name="problemForm" property="id" />
	<html:hidden name="problemForm" property="projectId" />
	<html:hidden name="problemForm" property="submitById" />
	<html:hidden name="problemForm" property="submitDate" />

		<table width="98%" cellpadding="0" cellspacing="0" align="center">

			<br>

			<tr>

				<td valign="top">

					<img src="././images/misc_arrow.gif">
					
					<strong><font color="#040466">&nbsp;&nbsp;项目问题&nbsp;-->&nbsp;编辑问题</font></strong>

					<hr noshade width="100%" size="1">

					

					<table width="100%" border="1" align="center" cellpadding="2"

						cellspacing="0" borderColor="#FFFFFF" class="datatable"

						id="MAIN_TABLE" style="display:block">


						<tr height="25">
							<td align="right" bgcolor="#E9EBEF" width="15%">问题描述：</td>
							<td bgcolor="#FFFFFF" width="35%">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:textarea cols="40" rows="3" name="problemForm" property="problemDescription" />
							</td>
						  </tr>
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right">提出人：</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<gdc:write name="problemForm" property="submitById" labelvalue="Users"/>
							</td>
						</tr>
						<tr height="25">
							<td align="right" bgcolor="#E9EBEF">提出日期：</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<bean:write name="problemForm" property="submitDate" formatKey="date.formkey"/>
							</td>
						  </tr>
						<tr height="25">
							<td align="right" bgcolor="#E9EBEF">严重程度：</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<gdc:defineCollection id="level" labelvalue="ProblemLevel"/>

								<html:select property="problemLevel" >	
								<html:optionsCollection name="level" label="label" value="value" />
								</html:select>
							</td>
						</tr>
						<tr height="25">
							 <td align="right" bgcolor="#E9EBEF">纠正措施：</td>
							 <td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:textarea cols="40" rows="3" name="problemForm" property="correctMeasure" />
							</td>
						</tr>
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right">解决人：</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:select property="solveById" >	
								<html:optionsCollection name="team" label="label" value="value" />
								</html:select>
							</td>
						</tr>
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right">验证人：</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:select property="validateById" >	
								<html:optionsCollection name="team" label="label" value="value" />
								</html:select>
							</td>
						</tr>
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right">问题状态：</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<gdc:defineCollection id="status0" labelvalue="ProblemStatus"/>

								<html:select property="status" >	
								<html:optionsCollection name="status0" label="label" value="value" />
								</html:select>
							</td>
						</tr>
						<tr height="25">
							<td align="right" bgcolor="#E9EBEF">关闭日期：</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:text name="problemForm" property="closeDate" styleClass="inputline" size="40" onfocus="selectDate(this);"/>
							</td>
						  </tr>
						
						
						
						<tr>
							<td colspan="4" bgcolor="#FFFFFF" align="center" height="50">
									<input type="submit" class="button" value="  提 交  " />
									&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="button" class="button" value="  返 回  " onClick="location.href('problemListAction.do');"/>
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