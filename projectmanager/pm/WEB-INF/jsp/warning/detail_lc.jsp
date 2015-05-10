<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="GBK"%>

<%@ taglib uri="/tags/struts-html" prefix="html"%>

<%@ taglib uri="/tags/struts-bean" prefix="bean"%>

<%@ taglib uri="/tags/struts-logic" prefix="logic"%>

<%@ taglib uri="/tags/struts-gdc" prefix="gdc"%>



<br>
<table width="95%" border="1" id="results_tableabc" style="display:block" align="center" cellpadding="2" cellspacing="0" borderColor="silver" class="datatable">

<tr>
<td bgcolor="#E9EBEF" align="left" width=30%>LcNo:</td>
<td width=20%><bean:write name="lcvo" property="lcno" /></td>
<td  bgcolor="#E9EBEF" align="left" width=30%>Period of Validity:</td>
<td width=20%><bean:write name="lcvo" property="validity" /></td>
</tr>

<tr> 
<td bgcolor="#E9EBEF" align="left">the Latest L/C Date of Shipping:</td>
<td><bean:write name="lcvo" property="lastestshippingdate" formatKey="date.formkey"/></td>
<td bgcolor="#E9EBEF" align="left">the actual Date of Transport:</td>
<td><bean:write name="lcvo" property="actualDeliveryDate" formatKey="date.formkey"/>
</td>
</tr>

<tr> 
<td width="19%"  bgcolor="#E9EBEF" align="left">the Latest Date of Submit:</td>
<td><bean:write name="lcvo" property="lastestsubmitdate" formatKey="date.formkey"/></td>
<td width="14%"  bgcolor="#E9EBEF" align="left">Status:</td>
<td><gdc:write name="lcvo" property="currentStatus" labelvalue="LCStatus"/></td>
</tr>

</table>

<br>

<br>
