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

		document.forms[0].action = 'impCertificateOModify1Action.do';

		document.forms[0].submit();		

	}

	

	function Next()

	{

		document.forms[0].action = 'impCertificateOModify2PreAction.do';

		document.forms[0].submit();		

	}

	

	function Back()

	{

		document.forms[0].action = 'impCertificateOSearchAction.do';

		document.forms[0].submit();		

	}

	

	</script>

<body>
<html:form action="/impCertificateOModify1Action">
	<html:hidden name="impCertificateOBasicForm" property="certificateId" />
	<html:hidden name="impCertificateOBasicForm" property="hscodeId" />

		<table width="98%" cellpadding="0" cellspacing="0" align="center">

			<br>

			<tr>

				<td valign="top">

					<strong><font color="#040466">&nbsp;&nbsp;Certificate O&nbsp;->&nbsp;Update</font>	</strong>



					<hr noshade width="100%" size="1">

					


					<table width="100%" border="1" align="center" cellpadding="2"

						cellspacing="0" borderColor="#FFFFFF" class="datatable"

						id="MAIN_TABLE" style="display:block">



						<tr>

							<td colspan="4" background="././images/back_aaa.jpg"

								align="center"><strong><font color="#000000">Basic Information</font></strong></td>

						</tr>


						<tr height="25">
							<td bgcolor="#E9EBEF" align="right" >Hscode</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<bean:write name="impCertificateOBasicForm" property="hscode" />
							</td>
						</tr>
						
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right" >Description of goods</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<bean:write name="impCertificateOBasicForm" property="goodsDescription" />
							</td>
						</tr>

						
						
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right">Status of goods </td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<gdc:defineCollection id="goodstatus0" labelvalue="GoodStatus"/>
								<html:select name="impCertificateOBasicForm" property="goodsStatus" >	
								<html:optionsCollection name="goodstatus0" label="label" value="value" />
								</html:select>
							</td>
						</tr>
						
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right">Applicant</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<gdc:defineCollection id="importMode0" labelvalue="ImportMode"/>
								<html:select name="impCertificateOBasicForm" property="agent" >	
								<html:optionsCollection name="importMode0" label="label" value="value" />
								</html:select>
							</td>
						</tr>
						
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right">Importer</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<gdc:defineCollection id="importer0" labelvalue="Importer"/>
								<html:select name="impCertificateOBasicForm" property="importer" >	
								<html:optionsCollection name="importer0" label="label" value="value" />
								</html:select>
							</td>
						</tr>
						
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right">Consignee</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<gdc:defineCollection id="consignee0" labelvalue="Consignee"/>
								<html:select name="impCertificateOBasicForm" property="consignee" >	
								<html:optionsCollection name="consignee0" label="label" value="value" />
								</html:select>
							</td>
						</tr>
						
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right" width="15%" >Automatic import licence No.</td>
							<td bgcolor="#FFFFFF" width="35%">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:text name="impCertificateOBasicForm" property="certificateNo" 
								 styleClass="inputline" size="40" />
							</td>
						</tr>
						
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right" >Automatic import licence expiry date</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:text name="impCertificateOBasicForm" property="expiredDate" onfocus="selectDate(this);"
								 styleClass="inputline" size="40" />
							</td>
						</tr>
						
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right">Terms of trade</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<gdc:defineCollection id="termsOfTrade0" labelvalue="ImpTradeTerm"/>
								<html:select name="impCertificateOBasicForm" property="termsOfTrade" >	
								<html:optionsCollection name="termsOfTrade0" label="label" value="value" />
								</html:select>
							</td>
						</tr>
						
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right">Terms of foreign exchange</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<gdc:defineCollection id="foreign0" labelvalue="OForeignExchange"/>
								<html:select name="impCertificateOBasicForm" property="temsOfForeignExchange" >	
								<html:optionsCollection name="foreign0" label="label" value="value" />
								</html:select>
							</td>
						</tr>
						
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right">Place of clearance</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<gdc:defineCollection id="importPort0" labelvalue="ImportPort"/>
								<html:select name="impCertificateOBasicForm" property="importPort" >	
								<html:optionsCollection name="importPort0" label="label" value="value" />
								</html:select>
							</td>
						</tr>
						
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right">Country/Region of exportation</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<gdc:defineCollection id="impCountry0" labelvalue="Country"/>
								<html:select name="impCertificateOBasicForm" property="countryOfExportation" >	
								<html:optionsCollection name="impCountry0" label="label" value="value" />
								</html:select>
							</td>
						</tr>
						
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right">Country/Region of origin </td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:text name="impCertificateOBasicForm" property="countryOfOrigin" 
								 styleClass="inputline" size="40" />&nbsp;&nbsp;(Input several country ab. separate with English comma)
							</td>
						</tr>
						
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right">Use of goods </td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<gdc:defineCollection id="goodUse0" labelvalue="GoodUse"/>
								<html:select name="impCertificateOBasicForm" property="goodsUse" >	
								<html:optionsCollection name="goodUse0" label="label" value="value" />
								</html:select>
							</td>
						</tr>
						
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right">Supplementary details</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:text name="impCertificateOBasicForm" property="remark" 
								 styleClass="inputline" size="40" />
							</td>
						</tr>
						
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right">Issuing authority's stamp</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:text name="impCertificateOBasicForm" property="issueStamp" 
								 styleClass="inputline" size="40" />
							</td>
						</tr>
						
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right" >Licence date</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:text name="impCertificateOBasicForm" property="licenceDate" onfocus="selectDate(this);"
								 styleClass="inputline" size="40" />
							</td>
						</tr>					
						
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right">Archive No.</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<html:text name="impCertificateOBasicForm" property="archiveNo" 
								 styleClass="inputline" size="40" />
							</td>
						</tr>
						
						<tr height="25">
							<td bgcolor="#E9EBEF" align="right">Times Remained</td>
							<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
								<bean:write name="impCertificateOBasicForm" property="remainedTimes"  />
								<html:hidden name="impCertificateOBasicForm" property="remainedTimes" />
							</td>
						</tr>
						
						<tr height="25">
						<td align="right" bgcolor="#E9EBEF" Name="Ö¤Êé×´Ì¬">Certificate Status:</td>
						  <td>&nbsp;&nbsp;&nbsp;&nbsp;
							  <html:select name="impCertificateOBasicForm" property="currentStatus">
								<html:option value="001" >Initial</html:option>
								<html:option value="002">Efficient</html:option>
								<html:option value="003">Overdue</html:option>
							</html:select></td>				
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