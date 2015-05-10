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
<html:form action="/backUserCreateAction" target="leftFrame">

		<table width="98%" cellpadding="0" cellspacing="0" align="center">

			<br>

			<tr>

				<td valign="top">

					<img src="././images/misc_arrow.gif">
					
					<strong><font color="#040466">&nbsp;&nbsp;�½��û���Ϣ</font>	</strong>

					<hr noshade width="100%" size="1">

					

					<table width="100%" border="1" align="center" cellpadding="2"

						cellspacing="0" borderColor="#FFFFFF" class="datatable"

						id="MAIN_TABLE" style="display:block">



						<tr height="25">
							<td bgcolor="#E9EBEF" align="right" width="15%">��¼����</td>
							<td bgcolor="#FFFFFF" width="35%">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:text name="userForm" property="loginName" styleClass="inputline" size="40" />
							</td>
						</tr>
						
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right" >��¼���룺</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:text name="userForm" property="password" styleClass="inputline" size="40"/>
							</td>
						</tr>
						
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right" >�û�������</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:text name="userForm" property="userName" styleClass="inputline" size="40"/>
							</td>
						</tr>
						
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right" >�Ա�</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<gdc:defineCollection id="sex" labelvalue="Sex"/>
								<html:select property="sex" >	
								<html:optionsCollection name="sex" label="label" value="value" />
								</html:select>
							</td>
						</tr>
						
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right" >���䣺</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:text name="userForm" property="email" styleClass="inputline" size="40"/>
							</td>
						</tr>
						
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right" >��ַ��</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:text name="userForm" property="address" styleClass="inputline" size="40"/>
							</td>
						</tr>	
						
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right" >�����绰��</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:text name="userForm" property="phone" styleClass="inputline" size="40"/>
							</td>
						</tr>
						
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right" >�ֻ���</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:text name="userForm" property="handset" styleClass="inputline" size="40"/>
							</td>
						</tr>
						
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right" >�Ƿ����Ա��</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<gdc:defineCollection id="isAdmin" labelvalue="IsAdmin"/>
								<html:select property="isAdmin" >	
								<html:optionsCollection name="isAdmin" label="label" value="value" />
								</html:select>
							</td>
						</tr>
						
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right" >�Ƿ���ɾ����</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<gdc:defineCollection id="isDeleted" labelvalue="IsDeleted"/>
								<html:select property="isDeleted" >	
								<html:optionsCollection name="isDeleted" label="label" value="value" />
								</html:select>
							</td>
						</tr>
						
						<tr>
							<td colspan="4" bgcolor="#FFFFFF" align="center" height="50">
									<input type="submit" class="button" value="  �� ��  " />
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