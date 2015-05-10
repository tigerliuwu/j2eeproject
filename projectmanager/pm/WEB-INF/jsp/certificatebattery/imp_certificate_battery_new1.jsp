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


	<script language="JavaScript">


	function Create()

	{

		document.forms[0].action = 'impCertificateBatteryNew1Action.do';

		document.forms[0].submit();		

	}

	

	function Next()

	{

		document.forms[0].action = 'impCertificateBatteryNew2PreAction.do';

		document.forms[0].submit();		

	}

	

	function Back()

	{

		document.forms[0].action = 'impCertificateBatterySearchAction.do';

		document.forms[0].submit();		

	}

	

	</script>

<body>
<html:form action="/impCertificateBatteryNew1Action">
	<html:hidden name="impCertificateBatteryBasicForm" property="certificateBatteryId" />
	

		<table width="98%" cellpadding="0" cellspacing="0" align="center">

			<br>

			<tr>

				<td valign="top">

					<strong><font color="#040466">&nbsp;&nbsp;Certificate Battery&nbsp;->&nbsp;New</font>	</strong>



					<hr noshade width="100%" size="1">

					


					<table width="100%" border="1" align="center" cellpadding="2"

						cellspacing="0" borderColor="#FFFFFF" class="datatable"

						id="MAIN_TABLE" style="display:block">



						<tr>

							<td colspan="4" background="././images/back_aaa.jpg"

								align="center"><strong><font color="#000000">Basic Information</font></strong></td>

						</tr>



						<tr height="25">
							<td bgcolor="#E9EBEF" align="right" width="15%" Name="备案号">Registration No.</td>
							<td bgcolor="#FFFFFF" width="35%">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:text name="impCertificateBatteryBasicForm" property="certificateBatteryNo" 
								 styleClass="inputline" size="40" />
							</td>
						</tr>
						
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right" Name="申请人" >Applicant</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:text name="impCertificateBatteryBasicForm" property="applicant" 
								 styleClass="inputline" size="40" />
							</td>
						</tr>
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right" Name="申请地址">Applicant Address</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:text name="impCertificateBatteryBasicForm" property="applicantAddress" 
								  styleClass="inputline" size="40" />
							</td>
						</tr>
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right" Name="制造商">Manufacturer</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:text name="impCertificateBatteryBasicForm" property="manufacturer" 
								 styleClass="inputline" size="40" />
							</td>
						</tr>
						<tr height="25">
							 <td align="right" bgcolor="#E9EBEF" Name="制造商地址">Manufacturer Address</td>
							 <td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:text name="impCertificateBatteryBasicForm" property="manufacturerAddress" 
								 styleClass="inputline" size="40" />
							</td>
						</tr>
						<tr height="25">
							<td align="right" bgcolor="#E9EBEF" Name="Start Date">Product Name</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:text name="impCertificateBatteryBasicForm" property="productDescription" 
								 styleClass="inputline" size="40" />
							</td>
						  </tr>
						<tr height="25">
							<td align="right" bgcolor="#E9EBEF" Name="Expired Date">Brand</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:text name="impCertificateBatteryBasicForm" property="brand" 
								 styleClass="inputline" size="40" />
							</td>
						 </tr>
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right" Name="制造商地址">Origin</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<gdc:defineCollection id="aa" labelvalue="Country"/>

								<html:select name="impCertificateBatteryBasicForm" property="origin" >	
								<html:optionsCollection name="aa" label="label" value="value" />
								</html:select>
							</td>
						</tr>
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right" Name="Start Date">Start Date</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:text name="impCertificateBatteryBasicForm" property="startDate" 
								 styleClass="inputline" size="40" onfocus="selectDate(this);"/>
							</td>
						</tr>
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right" Name="Expired Date">Expired Date</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:text name="impCertificateBatteryBasicForm" property="expiredDate" 
								 styleClass="inputline" size="40" onfocus="selectDate(this);"/>
							</td>
						</tr>					
						
						
						

						<tr>

							<td colspan="4" bgcolor="#FFFFFF" align="center" height="50">

								<input name="Submit" type="button" class="button" value=" Save " onClick="Create();">

								&nbsp;&nbsp;								

								<input name="Submit" type="button" class="button" value=" Cancel " onClick="Back();">

								&nbsp;&nbsp;

								<input name="Submit" type="button" class="button" value=" Next " onClick="Next();">
 
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