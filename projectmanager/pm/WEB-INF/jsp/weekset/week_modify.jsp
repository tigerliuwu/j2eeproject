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
<html:form action="/weekModifyAction">
	<html:hidden name="weekForm" property="id" />
	<html:hidden name="weekForm" property="projectId" />

		<table width="98%" cellpadding="0" cellspacing="0" align="center">

			<br>

			<tr>

				<td valign="top">

					<img src="././images/misc_arrow.gif">
					
					<strong><font color="#040466">&nbsp;&nbsp;工作周设置&nbsp;-->&nbsp;修改工作周</font></strong>

					<hr noshade width="100%" size="1">

					

					<table width="100%" border="1" align="center" cellpadding="2"

						cellspacing="0" borderColor="#FFFFFF" class="datatable"

						id="MAIN_TABLE" style="display:block">


						<tr height="25">
							<td align="right" bgcolor="#E9EBEF">开始日期：</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:text name="weekForm" property="startDate" styleClass="inputline" size="40" onfocus="selectDate(this);"/>
							</td>
						  </tr>
						<tr height="25">
							<td align="right" bgcolor="#E9EBEF">结束日期：</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:text name="weekForm" property="endDate" onfocus="selectDate(this);" styleClass="inputline" size="40" />
							</td>
						 </tr>
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right">单日工作量：</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:text name="weekForm" property="workloadPerDay" styleClass="inputline" size="40" />
							</td>
						</tr>
						
						
						<tr>
							<td colspan="4" bgcolor="#FFFFFF" align="center" height="50">
									<input type="submit" class="button" value="  提 交  " />
									&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="button" class="button" value="  返 回  " onClick="location.href('weekListAction.do');"/>
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