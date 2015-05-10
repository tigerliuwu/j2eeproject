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

	
	var dropUrl = 'impCertificateOSearchDetailAction.do';

	var currentPars = 'certificateId';	
	

	function Search() {

		document.forms[0].action = 'impCertificateOSearchAction.do?isReturn=NO';	
		document.forms[0].submit();

	}

	

	function New()
	{
		document.forms[0].action = 'impCertificateONewSelectPreAction.do';
		document.forms[0].submit();		

	}
	
	function before_delete(id,status)
	{
		if(status!="Initial"){
			alert("Only Initial Certificate could be deleted!");
			return; 
		}
		if(confirm('Delete?')){
			location.href('impCertificateODeleteAction.do?certificateId='+id);	
		}
	}

</script>




<body>



	<html:form action="/impCertificateOSearchAction">

	<table width="98%" cellpadding="0" cellspacing="0" align="center">

	<br>



		<tr>

			<td valign="top">

				<strong><font color="#040466">&nbsp;&nbsp;Certificate&nbsp;O -&gt; Search</font>				</strong>

				<hr noshade width="100%" size="1">

				

					<table id="conditions_table" style="display: block" width="100%"

						border="1" align="center" cellpadding="2" cellspacing="0"

						bgcolor="#FFFFFF" bordercolor="#FFFFFF">
									
						<tr>
						<td width="20%" bgcolor="#E9EBEF" align="right">Automatic import licence No. :</td>        
						<td width="30%">&nbsp;<html:text name="impCertificateOSearchForm" property="condition.certificateNo" size="30" 
										styleClass="inputline" />
						</td>
						<td width="20%" bgcolor="#E9EBEF" align="right">Hscode :</td>        
						<td width="30%">&nbsp;<html:text name="impCertificateOSearchForm" property="condition.hscodeNo" styleClass="inputline"  size="30" /></td>
						</tr>
						<tr>
						<td width="20%" bgcolor="#E9EBEF" align="right">Description of goods:</td>        
						<td width="30%">&nbsp;<html:text name="impCertificateOSearchForm" property="condition.goodsDescription"  styleClass="inputline"  size="30" /></td>
						<td align="right" bgcolor="#E9EBEF" Name="Ö¤Êé×´Ì¬">Certificate Status:</td>
						<td>&nbsp;
							<gdc:defineCollection id="status" labelvalue="CertificateStatus"/>
		
							<html:select property="condition.currentStatus" >						
							
								<option value="">--All--</option>							
							
							<html:optionsCollection name="status" label="label" value="value" />
							</html:select>
						</td>
						</tr>
						<tr>
						  <td align="right"  bgcolor="#E9EBEF">Country/Region of exportation :</td>
						  <td >&nbsp;
						  
						    <gdc:defineCollection id="exportation0" labelvalue="Country"/>

							<html:select property="condition.countryOfExportation" >						
							
								<option value="">--All--</option>							
							
							<html:optionsCollection name="exportation0" label="label" value="value" />
							</html:select>
						  
						   </td>
						  <td align="right"  bgcolor="#E9EBEF">Place of clearance :</td>
						  <td >&nbsp;
						 
						 	<gdc:defineCollection id="importPort0" labelvalue="ImportPort"/>

							<html:select property="condition.importPort" >						
							
								<option value="">--All--</option>							
							
							<html:optionsCollection name="importPort0" label="label" value="value" />
							</html:select>
						 
						 </td>
						</tr>
						<tr>
						<tr>
						  <td align="right"  bgcolor="#E9EBEF">Licence date From :</td>
						  <td >&nbsp;<html:text name="impCertificateOSearchForm" property="condition.licenceDateFrom" styleClass="inputline" size="30" onfocus="selectDate(this);"/>
						  </td>
						  <td align="right"  bgcolor="#E9EBEF">Licence date To :</td>
						  <td >&nbsp;<html:text name="impCertificateOSearchForm" property="condition.licenceDateTo"  styleClass="inputline" size="30" onfocus="selectDate(this);"/>
						  </td>
						  </tr>
						  <tr>
						  <td align="right"  bgcolor="#E9EBEF">Expiry date From:</td>
						  <td >&nbsp;<html:text name="impCertificateOSearchForm" property="condition.expiredDateFrom" styleClass="inputline" size="30" onfocus="selectDate(this);"/>
						  </td>
						  <td align="right"  bgcolor="#E9EBEF">Expiry date To:</td>
						  <td >&nbsp;<html:text name="impCertificateOSearchForm" property="condition.expiredDateTo"  styleClass="inputline" size="30" onfocus="selectDate(this);"/>
						  </td>
						  </tr>
						<tr>
						<td  bgcolor="#E9EBEF" align="right">Times Remained:</td>        
						<td >&nbsp;
							<html:select name="impCertificateOSearchForm" property="condition.compareTimes">
								<html:option value="EQ" >
									==
								</html:option>
								<html:option value="GE">
									&gt;=
								</html:option>
								<html:option value="LE">
									&lt;=
								</html:option>
							</html:select>												
							<html:text name="impCertificateOSearchForm" property="condition.remainedTimes" styleClass="inputline" size="20"/>
						</td>
						<td  bgcolor="#E9EBEF" align="right">Quantity Remained:</td>        
						<td >
							&nbsp;
							<html:select name="impCertificateOSearchForm"  property="condition.compareQuantity">
								<html:option value="EQ">
									==
								</html:option>
								<html:option value="GE">
									&gt;=
								</html:option>
								<html:option value="LE">
									&lt;=
								</html:option>
							</html:select>
							<html:text name="impCertificateOSearchForm" property="condition.remainedQuantity" styleClass="inputline" size="20"/>
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


<tr bgcolor="E9EBEF">

	<td width="2%"><div align="center">NO</div></td>
	<td width="5%"><div align="center">Automatic import licence No.</div></td>
	<td width="5%"><div align="center">Hscode</div></td> 
	<td width="10%" align="center"><div align="center">Description of goods</div></td> 
	<td width="7%" align="center"><div align="center">Quantity Remained</div></td> 
	<td width="5%" align="center" ><div align="center">Times Remained</div></td>
	<td width="5%" align="center" ><div align="center">Certificate Status</div></td>
	<td width="5%" ><div align="center">Licence date</div></td> 
	<td width="5%" ><div align="center">Expiry date</div></td> 

</tr>



<logic:notEmpty name="result">
<logic:iterate id="item" name="result" indexId="index">



<tr onMouseOut="this.style.backgroundColor='#FFFFFF'" onMouseOver="this.style.backgroundColor='#DDDDDD'" >

	<td align="center"><gdc:iteratorNO indexId="index" /></td>
	
	<td align="left">&nbsp;&nbsp;
		<a href="#" onClick="javascript:dropContentArray('<bean:write name="item" property="certificateId" />',
		'<bean:write name="index" />');">
		<bean:write name="item" property="certificateNo" /></a>
	</td>
	<bean:define id="hscode0" name="item" property="pubHscode" />
	
	<td   align="left">&nbsp;&nbsp;<bean:write name="hscode0" property="hscode" /></td>
	<td   align="left">&nbsp;&nbsp;<bean:write name="item" property="goodsDescription" /></td>
	<td   align="left">&nbsp;&nbsp;<bean:write name="item" property="remainedQuantity" /></td>
	<td   align="left">&nbsp;&nbsp;<bean:write name="item" property="remainedTimes" /></td>
	<td   align="left">&nbsp;&nbsp;<gdc:write name="item" property="currentStatus" labelvalue="CertificateStatus"/></td>
	<td   align="left">&nbsp;&nbsp;<bean:write name="item" property="licenceDate" formatKey="date.formkey"/></td>
	<td   align="left">&nbsp;&nbsp;<bean:write name="item" property="expiredDate" formatKey="date.formkey"/></td>
	
</tr>

<tr style="display:none" id="tr2_<bean:write name="item" property="certificateId" />"  >
	<td align="center">&nbsp;</td>
	<td align="left" colspan="8" id="tr2_td_<bean:write name="item" property="certificateId" />" >&nbsp;
	</td>
</tr>
</logic:iterate>

						

</table>

<br>


										

</logic:notEmpty>


<html:form styleId="formpage" action="/impCertificateOSearchAction">		

			<gdc:pages />

</html:form>


				<br>



			</td>

		</tr>

	</table>

</body>


</html:html>




