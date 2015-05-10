<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="gbk" %>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>


<%@ taglib uri="/WEB-INF/struts-gdc.tld" prefix="gdc"%>

<br>

<table width="95%" border="1" id="results_table" style="display:block" align="center" cellpadding="2" cellspacing="0" borderColor="silver" class="datatable">

<tr>
<td bgcolor="#E9EBEF" align="right" width="25%">HSCode:</td>
<td width="25%">&nbsp;<bean:write name="hscode" property="hscode" /></td>
<td  bgcolor="#E9EBEF" align="right" width="25%">Customs Description:</td>
<td width="25%">&nbsp;<bean:write name="hscode" property="customsDescription"  /></td>
</tr>

</table>


<br>


<table style="display: block" width="95%" border="1" align="center"  cellpadding="2" cellspacing="0" bgcolor="#FFFFFF" bordercolor="silver">



<tr bgcolor="#E9EBEF" align="center">

<td width="2%">NO</td>
<td width="5%">Automatic import licence No.</td>
<td width="5%">Quantity Remained</td>
<td width="5%">Times Remained</td>
<td width="5%">Certificate Status </td> 
<td width="5%">Expiry date</td>

</tr>


<logic:iterate id="item" name="hscode" property="impCertificateOs" indexId="index2">

<tr align="center" height="" onMouseOut="this.style.backgroundColor='#FFFFFF'" onMouseOver="this.style.backgroundColor='#DDDDDD'" >

<td align="center"><gdc:iteratorNO indexId="index2" /></td>

<td ><bean:write name="item" property="certificateNo" /></td>
<td ><bean:write name="item" property="remainedQuantity" /></td>
<td ><bean:write name="item" property="remainedTimes" /></td>
<td ><gdc:write name="item" property="currentStatus" labelvalue="CertificateStatus"/></td>
<td ><bean:write name="item" property="expiredDate" formatKey="date.formkey"/></td>

</tr>

</logic:iterate>


</table>

<br>

<br>
