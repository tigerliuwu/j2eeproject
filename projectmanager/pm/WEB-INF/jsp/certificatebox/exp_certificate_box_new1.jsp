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

		document.forms[0].action = 'expCertificateBoxNew1Action.do';

		document.forms[0].submit();		

	}

	function Back()

	{

		document.forms[0].action = 'expCertificateBoxSearchAction.do';

		document.forms[0].submit();		

	}

	

	</script>

<body>
<html:form action="/expCertificateBoxNew1Action">
	<html:hidden name="expCertificateBoxBasicForm" property="certificateBoxId" />
	

		<table width="98%" cellpadding="0" cellspacing="0" align="center">

			<br>

			<tr>

				<td valign="top">

					<strong><font color="#040466">&nbsp;&nbsp;Certificate Box&nbsp;->&nbsp;New</font>	</strong>



					<hr noshade width="100%" size="1">

					


					<table width="100%" border="1" align="center" cellpadding="2"

						cellspacing="0" borderColor="#FFFFFF" class="datatable"

						id="MAIN_TABLE" style="display:block">



						<tr>

							<td colspan="4" background="././images/back_aaa.jpg"

								align="center"><strong><font color="#000000">Certificate Exp Box Information</font></strong></td>

						</tr>



						<tr height="25">
							<td bgcolor="#E9EBEF" align="right" width="15%" Name="±¸°¸ºÅ">Packing Certificate No.</td>
							<td bgcolor="#FFFFFF" width="35%">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:text name="expCertificateBoxBasicForm" property="certificateBoxNo" 
								 styleClass="inputline" size="40" />
							</td>
						</tr>
						
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right" Name="length" >Length</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:text name="expCertificateBoxBasicForm" property="boxLength" 
								styleClass="inputline" size="40" />
							</td>
						</tr>
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right" >Width</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:text name="expCertificateBoxBasicForm" property="boxWidth" 
								  styleClass="inputline" size="40" />
							</td>
						</tr>
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right" >Height</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:text name="expCertificateBoxBasicForm" property="boxHeight" 
								 styleClass="inputline" size="40" />
							</td>
						</tr>
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right" >Packing Material</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<gdc:defineCollection id="packType0" labelvalue="BoxPackType"/>

								<html:select name="expCertificateBoxBasicForm" property="packType" >						
									
								<html:optionsCollection name="packType0" label="label" value="value" />
								</html:select>
							</td>
						</tr>
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right" >Transport mode</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<gdc:defineCollection id="trans0" labelvalue="BoxTransType"/>

								<html:select name="expCertificateBoxBasicForm" property="transportMode" >						
								
								<html:optionsCollection name="trans0" label="label" value="value" />
								</html:select>
							</td>
						</tr>
						<tr height="25">
							 <td align="right" bgcolor="#E9EBEF" >Times Available</td>
							 <td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:text name="expCertificateBoxBasicForm" property="timesAvailable" 
								 styleClass="inputline" size="40" />
							</td>
						</tr>
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right" Name="Expired Date">Expired Date</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:text name="expCertificateBoxBasicForm" property="expireDate" onfocus="selectDate(this);"
								 styleClass="inputline" size="40" />
							</td>
						</tr>					
						
						
						

						<tr>

							<td colspan="4" bgcolor="#FFFFFF" align="center" height="50">

								<input name="Submit" type="button" class="button" value=" Save " onClick="Create();">

								&nbsp;&nbsp;								

								<input name="Submit" type="button" class="button" value=" Back " onClick="Back();">

								
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