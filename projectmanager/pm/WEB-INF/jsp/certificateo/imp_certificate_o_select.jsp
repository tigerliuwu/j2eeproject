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



<script language="JavaScript">


	function Search() {

		document.forms[0].action = 'impCertificateOSelectSearchAction.do?isReturn=NO';	
		document.forms[0].submit();

	}
	
	function Back()
	{
		document.forms[0].action = 'impCertificateOSearchAction.do';
		document.forms[0].submit();		

	}
	

</script>




<body>



	<html:form action="/impCertificateOSelectSearchAction">

	<table width="98%" cellpadding="0" cellspacing="0" align="center">

	<br>



		<tr>

			<td valign="top">

				<strong><font color="#040466">&nbsp;&nbsp;Certificate&nbsp;O -&gt; Select</font></strong>

				<hr noshade width="100%" size="1">

				

					<table id="conditions_table" style="display: block" width="100%"

						border="1" align="center" cellpadding="2" cellspacing="0"

						bgcolor="#FFFFFF" bordercolor="#FFFFFF">
									
						<tr>
						<td width="20%" bgcolor="#E9EBEF" align="right">Hscode:</td>        
						<td width="30%">&nbsp;<html:text name="impCertificateOSelectSearchForm" property="condition.hscode" 
												size="30" styleClass="inputline" />
						</td>
						<td width="20%" >&nbsp;</td>        
						<td width="30%">&nbsp;</td>
						</tr>
						


						<tr>
						
							<td colspan="8" align="left" height="35">

								<input name="Submit" type="button" class="button" value="Search" onClick="Search();">
								&nbsp;&nbsp;&nbsp;
								<input name="Submit" type="button" class="button" value="  Back  " onClick="Back();">
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



<logic:notEmpty name="result">



<table width="100%" border="1" id="results_table_1" align="center" cellpadding="2" cellspacing="0" borderColor="silver" class="datatable">


<tr bgcolor="E9EBEF">

	<td width="2%"><div align="center">NO</div></td>
	<td width="5%"><div align="center">Hscode</div></td> 
	<td width="10%" align="center"><div align="center">Description of goods</div></td> 
	<td width="7%" align="center"><div align="center">First Measure Unit</div></td> 
	<td width="7%" align="center" ><div align="center">Second Measure Unit</div></td>
	<td width="5%" align="center" ><div align="center"></div></td>

</tr>


<logic:iterate id="item" name="result" indexId="index">


<tr onMouseOut="this.style.backgroundColor='#FFFFFF'" onMouseOver="this.style.backgroundColor='#DDDDDD'" align="center">

	<td   ><gdc:iteratorNO indexId="index" /></td>
	<td   >&nbsp;&nbsp;<bean:write name="item" property="hscode" /></td>
	<td   >&nbsp;&nbsp;<bean:write name="item" property="customsDescription" /></td>
	<td   >&nbsp;&nbsp;<bean:write name="item" property="firstMeasureUnit" /></td>
	<td   >&nbsp;&nbsp;<bean:write name="item" property="secondMeasureUnit" /></td>
	<td   >&nbsp;&nbsp;<a href="impCertificateONew1PreAction.do?hscodeIdFromSelect=<bean:write name="item" property="hscodeId" />">
		   Select</font></a>
	</td>
	
</tr>

</logic:iterate>

						

</table>

<br>


</logic:notEmpty>


<html:form styleId="formpage" action="/impCertificateOSelectSearchAction">		

			<gdc:pages />

</html:form>


				<br>



			</td>

		</tr>

	</table>

</body>


</html:html>




