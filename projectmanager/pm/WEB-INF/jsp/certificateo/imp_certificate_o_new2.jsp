<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="gbk"%>



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

<script type="text/javascript" src="./js/olsUtil_guo.js"></script>


<script type="text/javascript">

	var currentPars = 'certificateLineId';

	var dropUrl     = 'impCertificateOSearchLineAction.do';	

	var addUrl      = 'impCertificateOAddDetailAction.do';

	var deleteUrl   = 'impCertificateODeleteDetailAction.do';

    var	modifyUrl   = 'impCertificateOSaveDetailAction.do';

	

	function setCellStyle(cell,name) {

		if ( name == 'special')

			cell.align = 'left';

		

		cell.align = 'center';		

		return cell;	

	}   
	
	function Finish()

	{
		
		document.addLineForm.action = 'impCertificateOSearchAction.do';

		document.addLineForm.submit();	

	}

	

	function Back()

	{

		document.addLineForm.action = 'impCertificateONew1PreAction.do';

		document.addLineForm.submit();		

	}

	 function computeAmount()

	{

		quantity=trim(document.addLineForm.quantity.value);
		unitPrice=trim(document.addLineForm.unitPrice.value);

		if(isInt(quantity)==false){
			document.amountForm.amount.value="";	
			document.amountForm.amount2.value="";	
			return;
		}
		
		if(isNumber(unitPrice)==false){
			document.amountForm.amount.value="";	
			document.amountForm.amount2.value="";	
			return;
		}
		
		quantityInt=parseInt(quantity);
		unitPriceFloat=parseFloat(unitPrice);
		unitPriceFloat=adv_format(unitPriceFloat,2);
		theAmount=quantityInt*unitPriceFloat;
		document.amountForm.amount.value=adv_format(theAmount,2);	
		document.amountForm.amount2.value=adv_format(theAmount,2);	
		document.addLineForm.unitPrice.value=unitPriceFloat;

	}
	
	function adv_format(value,num)
	{
		var a_str = formatnumber(value,num);
		var a_int = parseFloat(a_str);
		if (value.toString().length>a_str.length)
		{
			var b_str = value.toString().substring(a_str.length,a_str.length+1)
			var b_int = parseFloat(b_str);
			if (b_int<5)
			{
				return a_str
			}
			else
			{
				var bonus_str,bonus_int;
				if (num==0)
				{
					bonus_int = 1;
				}
				else
				{
					bonus_str = "0."
					for (var i=1; i<num; i++)
					bonus_str+="0";
					bonus_str+="1";
					bonus_int = parseFloat(bonus_str);
				}
				a_str = formatnumber(a_int + bonus_int, num)
			}
		}
		return a_str
	}
	
	function formatnumber(value,num) 
	{
		var a,b,c,i
		a = value.toString();
		b = a.indexOf('.');
		c = a.length;
		if (num==0)
		{
			if (b!=-1)
			a = a.substring(0,b);
		}
		else
		{
			if (b==-1)
			{
				a = a + ".";
				for (i=1;i<=num;i++)
				a = a + "0";
			}
			else
			{
				a = a.substring(0,b+num+1);
				for (i=c;i<=b+num;i++)
				a = a + "0";
			}
		}
		return a
	}
	
	function trim(szStr){  
	  //去掉字符串头部的空格
	  while(szStr.length > 0){    
		  if( szStr.substring(0, 1) != ' '){      
		  break;    
		  }
		  else{      
		  szStr = szStr.substring(1);    
		  } 
	  }
	  //去掉字符串尾部的空格  
	  while(szStr.length > 0){    
		  if( szStr.substring(szStr.length - 1, szStr.length) != ' '){     
		   break;    
		   }
		   else{      
		   szStr = szStr.substring(0,szStr.length - 1);    
		   }  
	   } 
	   return szStr;
	}
	
	function isNumber(numStr){
	  numStr=trim(numStr);
	  if(numStr=="")
	  	return false;
	  return !isNaN(numStr);
	}
	
	function isInt(numStr){
	  return (parseInt(numStr)==numStr);
	}
	
	 function after_add()
	{
		document.addLineForm.specification.value="";
		document.addLineForm.unit.value="";
		document.addLineForm.quantity.value="";
		document.addLineForm.unitPrice.value="";
		document.amountForm.amount.value="";
		document.amountForm.amount2.value="";
		
	}


</script>



<body>

<table width="98%" cellpadding="0" cellspacing="0" align="center">

<br>

<tr>

	<td valign="top"><strong><font color="#040466">&nbsp;&nbsp;Certificate&nbsp;O &nbsp;-&gt;&nbsp;New</font></strong>

	<hr noshade width="100%" size="1">

		<table width="100%" border="1" align="center" cellpadding="2" cellspacing="0" borderColor="#FFFFFF" 
			class="datatable" id="MAIN_TABLE" style="display:block" >
		<tr>
		<td colspan="4" background="./images/back_aaa.jpg"  align="center"><strong><font color="#000000">Basic Information</font></strong></td>
		</tr>
		<tr >
		<td bgcolor="#E9EBEF" align="right" width="20%">Hscode:</td>
		<bean:define id="hscode0" name="o" property="pubHscode" />
		<td bgcolor="#FFFFFF" width="30%">&nbsp;&nbsp;&nbsp;&nbsp;<bean:write name="hscode0" property="hscode" /></td>
		
		<td align="right" bgcolor="#E9EBEF" width="20%">Description of goods:</td>
		<td width="30%">&nbsp;&nbsp;&nbsp;&nbsp;<bean:write name="o" property="goodsDescription" /></td>
		</tr>
		
		<tr>
		  <td align="right"  bgcolor="#E9EBEF">
							Use of goods :
						</td>
		  <td >&nbsp;&nbsp;&nbsp;&nbsp;
				<gdc:write name="o" property="goodsUse" labelvalue="GoodUse"/>
		  </td>
		<td align="right" bgcolor="#E9EBEF">Status of goods :</td>
		<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;<gdc:write name="o" property="goodsStatus" labelvalue="GoodStatus" /></td>
		</tr>
		
		<tr>
		  <td align="right" bgcolor="#E9EBEF">Automatic import licence No:</td>
		  <td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;<bean:write name="o" property="certificateNo" /></td>
		<td align="right" bgcolor="#E9EBEF">Applicant:</td>
		<td bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;<gdc:write name="o" property="agent" labelvalue="ImportMode" /></td>
		</tr>
		<tr>
		  <td align="right" bgcolor="#E9EBEF">Importer:</td>
		  <td>&nbsp;&nbsp;&nbsp;&nbsp;<gdc:write name="o" property="importer" labelvalue="Importer" /></td>
		  <td align="right" bgcolor="#E9EBEF">Consignee:</td>
		  <td>&nbsp;&nbsp;&nbsp;&nbsp;<gdc:write name="o" property="consignee" labelvalue="Consignee" /></td>
		</tr>
		<tr>
		  <td align="right" bgcolor="#E9EBEF">
							Certificate Status:
						</td>
		  <td>&nbsp;&nbsp;&nbsp;&nbsp;<gdc:write name="o" property="currentStatus" labelvalue="CertificateStatus" /></td>
		  <td align="right" bgcolor="#E9EBEF">
							Automatic import licence expiry date:
						</td>
		  <td>&nbsp;&nbsp;&nbsp;&nbsp;<bean:write name="o" property="expiredDate" formatKey="date.formkey"/></td>
		</tr>
		<tr>
		  <td align="right" bgcolor="#E9EBEF">
							Terms of trade:
						</td>
		  <td>&nbsp;&nbsp;&nbsp;&nbsp;<gdc:write name="o" property="termsOfTrade" labelvalue="ImpTradeTerm" /></td>
		  <td align="right" bgcolor="#E9EBEF">
							Terms of foreign exchange:
						</td>
		  <td>&nbsp;&nbsp;&nbsp;&nbsp;<gdc:write name="o" property="temsOfForeignExchange" labelvalue="OForeignExchange" /></td>
		</tr>
		<tr>
		  <td align="right" bgcolor="#E9EBEF">
							Country/Region of exportation:
						</td>
		  <td>&nbsp;&nbsp;&nbsp;&nbsp;<gdc:write name="o" property="countryOfExportation" labelvalue="Country" /></td>
		  <td align="right" bgcolor="#E9EBEF">
							Country/Region of origin :
						</td>
		  <td>&nbsp;&nbsp;&nbsp;&nbsp;<bean:write name="o" property="countryOfOrigin" /></td>
		</tr>
		<tr>
		  <td align="right" bgcolor="#E9EBEF">
							Place of clearance:
						</td>
		  <td>&nbsp;&nbsp;&nbsp;&nbsp;<gdc:write name="o" property="importPort" labelvalue="ImportPort" /></td>
		  <td align="right" bgcolor="#E9EBEF">
							Supplementary details:
						</td>
		  <td>&nbsp;&nbsp;&nbsp;&nbsp;<bean:write name="o" property="remark" /></td>
		</tr>
		<tr>
		  <td align="right" bgcolor="#E9EBEF">
							Issuing authority's stamp:
						</td>
		  <td>&nbsp;&nbsp;&nbsp;&nbsp;<bean:write name="o" property="issueStamp" /></td>
		  <td align="right" bgcolor="#E9EBEF">
							Licence date:
						</td>
		  <td>&nbsp;&nbsp;&nbsp;&nbsp;<bean:write name="o" property="licenceDate" formatKey="date.formkey"/></td>
		</tr>
		<tr>
		  <td align="right" bgcolor="#E9EBEF">
							Archive No.:
						</td>
		  <td>&nbsp;&nbsp;&nbsp;&nbsp;<bean:write name="o" property="archiveNo" /></td>
		  <td align="right" bgcolor="#E9EBEF">
							Times Remained:
						</td>
		  <td>&nbsp;&nbsp;&nbsp;&nbsp;<bean:write name="o" property="remainedTimes" /></td>
		</tr>
		
		</table>

		<br>
		
		<table width="100%" border="1" align="center" cellpadding="2" cellspacing="0" borderColor="silver" class="datatable" id="displayTable">
		
		<tr>
			<td colspan="15" background="./images/back_aaa.jpg" align="center">
			<strong><font color="#000000">Affix Information</font></strong>
			</td>
		</tr>
		
		<tr bgcolor="#F3F3F3" align="center">
		<td width="2%">NO</td>
		<td width="2%">Edit</td>
		<td width="5%" id="td00">Specification</td>
		<td width="5%">Unit</td>
		<td width="5%">Quantity</td>
		<td width="5%">Unit price</td>
		<td width="5%">Amount</td>
		<td width="5%">Amount in USD</td>
		</tr>
		
		
		<logic:iterate id="item" name="o" property="impCertificateOlines" indexId="index">
		
		<tr height="" id="tr1_<bean:write name="item" property="certificateLineId" />"  onMouseOut="this.style.backgroundColor='#FFFFFF'" onMouseOver="this.style.backgroundColor='#DDDDDD'" >
		<td align="center"><gdc:iteratorNO indexId="index" /></td>
		<td  align="center"><a href="#" onclick="javascript:dropContent('<bean:write name="item" property="certificateLineId" />');">
			Edit</a>
		</td>
		<td  align="center"><bean:write name="item" property="specification" /></td>
		<td  align="center"><bean:write name="item" property="unit" /></td>
		<td  align="center"><bean:write name="item" property="quantity" /></td>
		<td  align="center"><bean:write name="item" property="unitPrice" formatKey="currency.2.formkey"/></td>
		<td  align="center"><bean:write name="item" property="amount" formatKey="currency.2.formkey"/></td>
		<td  align="center"><bean:write name="item" property="amount" formatKey="currency.2.formkey"/></td>
		
		</tr>
		
		<tr style="display:none" id="tr2_<bean:write name="item" property="certificateLineId" />"  >
			<td align="center">&nbsp;</td>
			<td align="left" colspan="8" id="tr2_td_<bean:write name="item" property="certificateLineId" />" >&nbsp;
			</td>
		</tr>
		
		
		
		</logic:iterate>
		
		
		</table>
		
		<br>

		<html:form action="/impCertificateOAddDetailAction" styleId="addLineForm">
		<html:hidden name="o" property="certificateId" />
		
		<table width="100%" border="1" align="center" cellpadding="2" cellspacing="0" borderColor="silver" class="datatable" id="add_view_table_2">
		
		<!-- add line  -->
		<tr bgcolor="#FFFFFF" align="center">
		
		<td width="2%">&nbsp;</td>
		<td width="2%" align="center">
		<a href="#" onClick="add();after_add();">Add</a>
		</td>
		<td width="5%" align="center">
		<html:text name="impCertificateODetailForm" property="specification" size="15" styleClass="inputline"  />
		</td>
		<td width="5%" align="center">
		<html:text name="impCertificateODetailForm" property="unit" size="15" styleClass="inputline" />
		</td>
		<td width="5%" align="center">
		<html:text name="impCertificateODetailForm" property="quantity" size="15" styleClass="inputline" onblur="computeAmount()" />
		</td>
		<td width="5%" align="center">
		<html:text name="impCertificateODetailForm" property="unitPrice" size="15" styleClass="inputline" onblur="computeAmount()" />
		</td>
		
		</html:form>
		
		<form name="amountForm">
		<td width="5%" align="center">
		<input disabled="true" name="amount" size="15" Class="inputline" type="text"/>
		</td>
		<td width="5%" align="center">
		<input disabled="true" name="amount2" size="15" Class="inputline" type="text"/>
		
		</tr>
		</form>
		</table>
		<br>
		<div id="addLine_errors" color="red">
		</div>
	
		
		

		<br>

		<div align="center">

		<input type="button" value=" Back " class="button" onClick="Back();">
		&nbsp;&nbsp;
		<input type="button" value=" Finish " class="button" onClick="Finish();">
		
		</div>

	</td>

	</tr>

	</table>

</body>

</html:html>
