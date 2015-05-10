<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="gbk" %>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>


<%@ taglib uri="/WEB-INF/struts-gdc.tld" prefix="gdc"%>

<br>

<table width="95%" border="1" id="results_table" style="display:block" align="center" cellpadding="2" cellspacing="0" borderColor="silver" class="datatable">

<tr>
<td width="25%" bgcolor="#E9EBEF" align="right">Importer:</td>
<td width="25%"><gdc:write name="o" property="importer" labelvalue="Importer"/></td>
<td width="25%" bgcolor="#E9EBEF" align="right">Consignee:</td>
<td width="25%"><gdc:write name="o" property="consignee" labelvalue="Consignee" /></td>
</tr>

<tr>
<td bgcolor="#E9EBEF" align="right">Terms of foreign exchange:</td>
<td><gdc:write name="o" property="temsOfForeignExchange" labelvalue="OForeignExchange"/></td>
<td align="right"  bgcolor="#E9EBEF">Terms of trade:</td>
<td><gdc:write name="o" property="termsOfTrade" labelvalue="ImpTradeTerm"/></td>
</tr>

<tr>
<td bgcolor="#E9EBEF" align="right">Hscode:</td>
<td>
<bean:define id="hscode0" name="o" property="pubHscode" />
<bean:write name="hscode0" property="hscode" />
</td>
<td bgcolor="#E9EBEF" align="right">Status of Goods :</td>
<td><gdc:write name="o" property="goodsStatus" labelvalue="GoodStatus" /></td>
</tr>

<tr>
<td bgcolor="#E9EBEF" align="right">Description of goods:</td>
<td><bean:write name="o" property="goodsDescription" /></td>
<td bgcolor="#E9EBEF" align="right">Place of clearance:</td>
<td><gdc:write name="o" property="importPort" labelvalue="ImportPort" /></td>
</tr>

<tr>
<td bgcolor="#E9EBEF" align="right">Country/Region of exportation:</td>
<td><gdc:write name="o" property="countryOfExportation" labelvalue="Country" /></td>
<td bgcolor="#E9EBEF" align="right">Country/Region of origin: </td>
<td><bean:write name="o" property="countryOfOrigin" /></td>
</tr>
<tr>
  <td bgcolor="#E9EBEF" align="right">Times Remained:</td>
  <td><bean:write name="o" property="remainedTimes" /></td>
  <td bgcolor="#E9EBEF" align="right">Applicant:</td>
  <td><gdc:write name="o" property="agent" labelvalue="ImportMode"/></td>
  
</tr>
<tr>
  <td bgcolor="#E9EBEF" align="right">Archive No.:</td>
  <td><bean:write name="o" property="archiveNo" /></td>
  <td bgcolor="#E9EBEF" align="right">Certificate Status:</td>
  <td><gdc:write name="o" property="currentStatus" labelvalue="CertificateStatus"/></td>
</tr>
<tr>
<td bgcolor="#E9EBEF" align="right">Licence date :</td>
<td><bean:write name="o" property="licenceDate" formatKey="date.formkey"/></td>
<td bgcolor="#E9EBEF" align="right">Expiry date:</td>
<td><bean:write name="o" property="expiredDate" formatKey="date.formkey"/></td>
</tr>




</table>



<br>



<table style="display: block" width="95%" border="1" align="center"  cellpadding="2" cellspacing="0" bgcolor="#FFFFFF" bordercolor="silver">



<tr bgcolor="#E9EBEF" align="center">

<td width="5%">NO</td>
<td width="16%">Specification</td>
<td width="17%">Unit</td>
<td width="22%">Quantity</td>
<td width="16%">Unit price </td> 
<td width="13%">Amount</td>
<td width="11%">Amount in USD </td>

</tr>


<logic:iterate id="item" name="o" property="impCertificateOlines" indexId="index2">

<tr align="center" height="" onMouseOut="this.style.backgroundColor='#FFFFFF'" onMouseOver="this.style.backgroundColor='#DDDDDD'" >

<td align="center"><gdc:iteratorNO indexId="index2" /></td>

<td ><bean:write name="item" property="specification" /></td>
<td ><bean:write name="item" property="unit" /></td>
<td ><bean:write name="item" property="quantity" /></td>
<td ><bean:write name="item" property="unitPrice" formatKey="currency.2.formkey"/></td>
<td ><bean:write name="item" property="amount" formatKey="currency.2.formkey"/></td>
<td ><bean:write name="item" property="amount" formatKey="currency.2.formkey"/></td>

</tr>

</logic:iterate>


</table>

<br>

<br>
