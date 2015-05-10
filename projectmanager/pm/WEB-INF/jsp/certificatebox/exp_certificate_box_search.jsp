<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="GBK"%>



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

<script type="text/javascript" src="./js/selectDateTime.js"></script>

<script type="text/javascript" src="./js/olsUtil.js"></script>



<script language="JavaScript">

	
	var dropUrl = 'expCertificateBoxSearchDetailAction.do';

	var currentPars = 'certificateBoxId';	
	

	function Search() {

		document.forms[0].action = 'expCertificateBoxSearchAction.do?isReturn=NO';	
		document.forms[0].submit();

	}

	

	function New()
	{
		document.forms[0].action = 'expCertificateBoxNew1PreAction.do';
		document.forms[0].submit();		

	}
	
	function before_delete(id)
	{
		if(confirm('Delete?')){
			location.href('expCertificateBoxDeleteAction.do?certificateBoxId='+id);	
		}
	}

</script>




<body>



	<html:form action="/expCertificateBoxSearchAction">

	<table width="98%" cellpadding="0" cellspacing="0" align="center">

	<br>



		<tr>

			<td valign="top">

				<strong><font color="#040466">&nbsp;&nbsp;Certificate Box&nbsp;->&nbsp;Search</font>				</strong>

				<hr noshade width="100%" size="1">

				

					<table id="conditions_table" style="display: block" width="100%"

						border="1" align="center" cellpadding="2" cellspacing="0"

						bgcolor="#FFFFFF" bordercolor="#FFFFFF">
												
						<tr>
							<td width="20%" bgcolor="#E9EBEF" align="right">Packing Certificate No.:</td>        
							<td width="30%">&nbsp;
								<html:text name="expCertificateBoxSearchForm" property="condition.certificateBoxNo" size="30" 
								styleClass="inputline" />
								
							</td>
							<td align="right" bgcolor="#E9EBEF" >Length:</td>
							<td>&nbsp;
							<html:text name="expCertificateBoxSearchForm" property="condition.boxLength" size="30" 
								styleClass="inputline" />
							</td>
						</tr>
						<tr>
							<td width="20%" bgcolor="#E9EBEF" align="right">Width:</td>        
							<td width="30%">&nbsp;
								<html:text name="expCertificateBoxSearchForm" property="condition.boxWidth" size="30" 
								styleClass="inputline" />
							</td>
							<td width="20%" bgcolor="#E9EBEF" align="right">Height:</td>        
							<td width="30%">&nbsp;
								<html:text name="expCertificateBoxSearchForm" property="condition.boxHeight" size="30" 
								styleClass="inputline" />
								
							</td>
						</tr>
						<tr>
						    <td bgcolor="#E9EBEF" align="right">Packing Material:</td>
						    <td width="30%">&nbsp;
					
								<gdc:defineCollection id="packType0" labelvalue="BoxPackType"/>

								<html:select property="condition.packType" >						
								
									<option value="">--All--</option>							
								
								<html:optionsCollection name="packType0" label="label" value="value" />
								</html:select>
								
							</td>
						    <td bgcolor="#E9EBEF" align="right">Transport mode:</td>
						    <td width="30%">&nbsp;
								
								<gdc:defineCollection id="trans0" labelvalue="BoxTransType"/>

								<html:select property="condition.transportMode" >						
								
									<option value="">--All--</option>							
								
								<html:optionsCollection name="trans0" label="label" value="value" />
								</html:select>
								
							</td>
						</tr>
						<tr>
						    <td align="right" bgcolor="#E9EBEF">Times Available:</td>
						    <td>&nbsp;
							  <html:text name="expCertificateBoxSearchForm" property="condition.timesAvailable" size="30" 
								styleClass="inputline" />
							</td>
						    <td bgcolor="#E9EBEF" align="right">Times Used :</td>
						    <td width="30%">&nbsp;
							
								<html:text name="expCertificateBoxSearchForm" property="condition.timesUsed" size="30" 
								styleClass="inputline" />
								
							</td>
						</tr>
						<tr>
						    <td align="right" bgcolor="#E9EBEF">Expired Date From:</td>
						    <td>&nbsp;
							    <html:text name="expCertificateBoxSearchForm" property="condition.expireDateFrom" size="30" onfocus="selectDate(this);"
								styleClass="inputline" />
							</td>
						    <td bgcolor="#E9EBEF" align="right">Expired Date To:</td>
						    <td width="30%">&nbsp;
								<html:text name="expCertificateBoxSearchForm" property="condition.expireDateTo" size="30" onfocus="selectDate(this);"
								styleClass="inputline" />
								
							</td>
						</tr>
						
						


						<tr>

							<td colspan="8" align="left" height="35">



								<input name="Submit" type="button" class="button" value="Search"

									onClick="Search();">

								&nbsp;&nbsp;&nbsp;

								<input name="Submit" type="button" class="button"

									value="  New  " onClick="New();">

							</td>

						</tr>

					</table>

					
					<html:errors />
					<gdc:errors />
					

					<table width="100%">

						<tr>

							<td colspan="8" align="center"

								background="././images/splitter_bg_2.gif">

								<img id="hidden_img" src="././images/splitter_d.gif" onClick="hidden_conditions();" style="cursor:hand">

							</td>

						</tr>

					</table>

					<br>

					

</html:form>






<table width="100%" border="1" id="results_table_1" align="center" cellpadding="2" cellspacing="0" borderColor="silver" class="datatable">


<tr bgcolor="E9EBEF" align="center">

	<td width="2%">NO</td>
	<td width="5%">Pack size</td>
	<td width="5%">Packing Certificate No.</td>
	<td width="3%">Packing Material</td> 
	<td width="3%">Transport mode</td> 
	<td width="3%">Times Available</td>
	<td width="3%">Times Used</td> 
	<td width="3%">Expired Date</td> 

</tr>


<logic:notEmpty name="result">

<logic:iterate id="item" name="result" indexId="index">



<tr onMouseOut="this.style.backgroundColor='#FFFFFF'" onMouseOver="this.style.backgroundColor='#DDDDDD'" >

	<td align="center"><gdc:iteratorNO indexId="index" /></td>
	
	<td align="left">&nbsp;&nbsp;
		<a href="#" onClick="javascript:dropContentArray('<bean:write name="item" property="certificateBoxId" />',
		'<bean:write name="index" />');">
		<bean:write name="item" property="boxLength" />
		*<bean:write name="item" property="boxWidth" />
		*<bean:write name="item" property="boxHeight" /></a>
	</td>
	
	<td align="left">&nbsp;&nbsp;<bean:write name="item" property="certificateBoxNo" /></td>
	<td align="left">&nbsp;&nbsp;<gdc:write name="item" property="packType" labelvalue="BoxPackType" /></td>
	<td align="left">&nbsp;&nbsp;<gdc:write name="item" property="transportMode" labelvalue="BoxTransType" /></td>
	<td align="left">&nbsp;&nbsp;<bean:write name="item" property="timesAvailable" /></td>
	<td align="left">&nbsp;&nbsp;<bean:write name="item" property="timesUsed" /></td>
	<td align="left">&nbsp;&nbsp;<bean:write name="item" property="expireDate" formatKey="date.formkey"/></td>
	
</tr>

<tr style="display:none" id="tr2_<bean:write name="item" property="certificateBoxId" />"  >
	<td align="center">&nbsp;</td>
	<td align="left" colspan="8" id="tr2_td_<bean:write name="item" property="certificateBoxId" />" >&nbsp;
	</td>
</tr>
</logic:iterate>


</table>

<br>


										

</logic:notEmpty>


<html:form styleId="formpage" action="/expCertificateBoxSearchAction">		

			<gdc:pages />

</html:form>


				<br>



			</td>

		</tr>

	</table>

</body>


</html:html>




