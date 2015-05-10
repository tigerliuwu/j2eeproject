<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="GBK"%>

<%@ page import="edu.pm.constants.PMConstants" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<%@ taglib uri="/WEB-INF/struts-gdc.tld" prefix="gdc"%>


<html:html>

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
				<strong><font color="#040466">项目名称：</font></strong>
				<bean:write name="project" property="projectName" />&nbsp;&nbsp;&nbsp;&nbsp;
				<strong><font color="#040466">项目经理：</font></strong>
				<gdc:write name="project" property="pmId" labelvalue="Users"/>
				<bean:define name="project" property="pmId" id="pmId"/>
				<hr noshade width="100%" size="1">

				
					<br>



<table width="100%" border="1" id="results_table_1" align="center" cellpadding="2" cellspacing="0" borderColor="silver" class="datatable">


<tr bgcolor="E9EBEF">

	<td width="2%"><div align="center">序号</div></td>
	<td width="2%"><div align="center">用户名</div></td>
	<td width="2%"><div align="center">性别</div></td>
	<td width="5%"><div align="center">E-Mail地址</div></td>
	<td width="5%"><div align="center">地址</div></td>
	<td width="5%"><div align="center">办公电话</div></td>
	<td width="2%"><div align="center">任务列表</div></td>
	
</tr>



<%--<logic:notEmpty name="result">

--%>
<logic:iterate id="item" name="result" indexId="index">

<tr onMouseOut="this.style.backgroundColor='#FFFFFF'" onMouseOver="this.style.backgroundColor='#DDDDDD'" >
	
	<td align="center">
		<gdc:iteratorNO indexId="index" />
	</td>
	<td align="center">
		<logic:equal name="item" property="id" value="<%=pmId.toString()%>">
		<font color='red'><bean:write name="item" property="userName" /></font>
		</logic:equal>
		<logic:notEqual name="item" property="id" value="<%=pmId.toString()%>">
		<bean:write name="item" property="userName" />
		</logic:notEqual>
	</td>
	<td align="center"><gdc:write name="item" property="sex" labelvalue="Sex"/></td>
	<td align="center"><bean:write name="item" property="email" /></td>
	<td align="center"><bean:write name="item" property="address" /></td>
	<td align="center"><bean:write name="item" property="phone" /></td>
	<td align="center">
		<a href="teamTargetListAction.do?userId=<bean:write name="item" property="id" />" >
			查看
		</a>
	</td>
	
</tr>

</logic:iterate>		

</table>
<%--

</logic:notEmpty>

--%>
<br>

  <html:form styleId="formpage" action="/userListAction">
			<gdc:pages />
  </html:form>


			</td>

		</tr>
		<tr><td align="center">
			<input  type="button" class="button" value="  返 回  " onClick="location.href('projectListAction.do');">
		</td><tr>

	</table>

 </body>


</html:html>




