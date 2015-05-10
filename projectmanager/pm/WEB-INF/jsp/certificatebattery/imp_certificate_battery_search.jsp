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

<script type="text/javascript" src="./js/olsUtil.js"></script>

<script type="text/javascript" src="./js/selectDateTime.js"></script>


<script language="JavaScript">

	
	var dropUrl = 'impCertificateBatterySearchDetailAction.do';

	var currentPars = 'certificateBatteryId';	
	

	function Search() {

		document.forms[0].action = 'impCertificateBatterySearchAction.do?isReturn=NO';	
		document.forms[0].submit();

	}

	

	function New()
	{
		document.forms[0].action = 'impCertificateBatteryNew1PreAction.do';
		document.forms[0].submit();		

	}
	
	function before_delete(id,status)
	{
		if(status!="Initial"){
			alert("Only Initial Certificate could be deleted!");
			return; 
		}
		if(confirm('Delete?')){
			location.href('impCertificateBatteryDeleteAction.do?certificateBatteryId='+id);	
		}
	}
	

</script>




<body>



	<html:form action="/impCertificateBatterySearchAction">

	<table width="98%" cellpadding="0" cellspacing="0" align="center">

	<br>



		<tr>

			<td valign="top">

				<strong><font color="#040466">&nbsp;&nbsp;Certificate Battery&nbsp;->&nbsp;Search</font>				</strong>

				<hr noshade width="100%" size="1">

				

					<table id="conditions_table" style="display: block" width="100%"

						border="1" align="center" cellpadding="2" cellspacing="0"

						bgcolor="#FFFFFF" bordercolor="#FFFFFF">
												
						<tr>
							<td width="20%" bgcolor="#E9EBEF" align="right">Registration No.:</td>        
							<td width="30%">&nbsp;
								<html:text name="impCertificateBatterySearchForm" property="condition.certificateBatteryNo" size="30" 
								styleClass="inputline" />
								
							</td>
							<td align="right" bgcolor="#E9EBEF" >Certificate Status:</td>
							<td>&nbsp;
							
							<gdc:defineCollection id="status" labelvalue="CertificateStatus"/>

							<html:select property="condition.currentStatus" >						
							
								<option value="">--All--</option>							
							
							<html:optionsCollection name="status" label="label" value="value" />
							</html:select>
							
							
							</td>
						</tr>
						<tr>
							<td width="20%" bgcolor="#E9EBEF" align="right">Applicant:</td>        
							<td width="30%">&nbsp;
								<html:text name="impCertificateBatterySearchForm" property="condition.applicant" size="30" 
								styleClass="inputline" />
							</td>
							<td width="20%" bgcolor="#E9EBEF" align="right">Manufacturer:</td>        
							<td width="30%">&nbsp;
								<html:text name="impCertificateBatterySearchForm" property="condition.manufacturer" size="30" 
								styleClass="inputline" />
								
							</td>
						</tr>
						<tr>
						    <td bgcolor="#E9EBEF" align="right">Product Name:</td>
						    <td width="30%">&nbsp;
								<html:text name="impCertificateBatterySearchForm" property="condition.productDescription" size="30" 
								styleClass="inputline" />
							</td>
						    <td bgcolor="#E9EBEF" align="right">Brand:</td>
						    <td width="30%">&nbsp;
								<html:text name="impCertificateBatterySearchForm" property="condition.brand" size="30" 
								styleClass="inputline" />
							</td>
						</tr>
						<tr>
						    <td align="right" bgcolor="#E9EBEF">Start Date From:</td>
						    <td>&nbsp;
							  <html:text name="impCertificateBatterySearchForm" property="condition.startDateFrom" size="30" onfocus="selectDate(this);"
								styleClass="inputline" />
							</td>
						    <td bgcolor="#E9EBEF" align="right">Start Date To:</td>
						    <td width="30%">&nbsp;
								<html:text name="impCertificateBatterySearchForm" property="condition.startDateTo" size="30" onfocus="selectDate(this);"
								styleClass="inputline" />
							</td>
						</tr>
						<tr>
						    <td align="right" bgcolor="#E9EBEF">Expired Date From:</td>
						    <td>&nbsp;
							    <html:text name="impCertificateBatterySearchForm" property="condition.expiredDateFrom" size="30" onfocus="selectDate(this);"
								styleClass="inputline" />
							</td>
						    <td bgcolor="#E9EBEF" align="right">Expired Date To:</td>
						    <td width="30%">&nbsp;
								<html:text name="impCertificateBatterySearchForm" property="condition.expiredDateTo" size="30" onfocus="selectDate(this);"
								styleClass="inputline" />
							</td>
						</tr>
						<tr>
						    <td align="right" bgcolor="#E9EBEF">Origin:</td>
						    <td>&nbsp;
							    <gdc:defineCollection id="origin0" labelvalue="Country"/>

								<html:select property="condition.origin" >						
								
									<option value="">--All--</option>							
								
								<html:optionsCollection name="origin0" label="label" value="value" />
								</html:select>
							</td>
						    <td width="20%"  align="right"></td>        
						    <td width="30%"></td>
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


<tr bgcolor="E9EBEF">

	<td width="7%"><div align="center">NO</div></td>
	<td width="18%"><div align="center">Registration No.</div></td>
	<td width="18%" align="center"><div align="center">Product Name</div></td>
	<td width="25%"><div align="center">Applicant</div></td> 
	<td width="22%" align="center"><div align="center">Manufacturer</div></td> 
	<td width="8%" align="center" ><div align="center">Certificate Status</div></td>
	<td width="10%" ><div align="center">Start Date</div></td> 
	<td width="10%" ><div align="center">Expired Date</div></td> 

</tr>



<logic:notEmpty name="result">

<logic:iterate id="item" name="result" indexId="index">



<tr onMouseOut="this.style.backgroundColor='#FFFFFF'" onMouseOver="this.style.backgroundColor='#DDDDDD'" >

	<td align="center"><gdc:iteratorNO indexId="index" /></td>
	
	<td align="left">&nbsp;&nbsp;
		<a href="#" onClick="javascript:dropContentArray('<bean:write name="item" property="certificateBatteryId" />',
		'<bean:write name="index" />');">
		<bean:write name="item" property="certificateBatteryNo" /></a>
	</td>
	
	<td align="left">&nbsp;&nbsp;<bean:write name="item" property="productDescription" /></td>
	<td align="left">&nbsp;&nbsp;<bean:write name="item" property="applicant" /></td>
	<td align="left">&nbsp;&nbsp;<bean:write name="item" property="manufacturer" /></td>
	<td align="left">&nbsp;&nbsp;<gdc:write name="item" property="currentStatus" labelvalue="CertificateStatus"/></td>
	<td align="left">&nbsp;&nbsp;<bean:write name="item" property="startDate" formatKey="date.formkey"/></td>
	<td align="left">&nbsp;&nbsp;<bean:write name="item" property="expiredDate" formatKey="date.formkey"/></td>
	
</tr>

<tr style="display:none" id="tr2_<bean:write name="item" property="certificateBatteryId" />"  >
	<td align="center">&nbsp;</td>
	<td align="left" colspan="8" id="tr2_td_<bean:write name="item" property="certificateBatteryId" />" >&nbsp;
	</td>
</tr>
</logic:iterate>

						

</table>

<br>


										

</logic:notEmpty>


<html:form styleId="formpage" action="/impCertificateBatterySearchAction">		

			<gdc:pages />

</html:form>


				<br>



			</td>

		</tr>

	</table>

</body>


</html:html>




