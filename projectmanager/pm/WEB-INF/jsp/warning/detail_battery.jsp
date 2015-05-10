<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="gbk" %>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>


<%@ taglib uri="/WEB-INF/struts-gdc.tld" prefix="gdc"%>

<br>

<table width="95%" border="1" id="results_table" style="display:block" align="center" cellpadding="2" cellspacing="0" borderColor="silver" class="datatable">

<tr>
<td align="right" bgcolor="#E9EBEF" width="25%">Registration No.:</td>
  <td width="25%">&nbsp;<bean:write name="battery" property="certificateBatteryNo"/></td>
  <td width="25%" align="right" bgcolor="#E9EBEF">Certificate Status:</td>
  <td width="25%">&nbsp;<gdc:write name="battery" property="currentStatus" labelvalue="CertificateStatus"/></td>
</tr>
<tr>
<td align="right" bgcolor="#E9EBEF">Applicant:</td>
<td>&nbsp;<bean:write name="battery" property="applicant"/></td>
<td align="right" bgcolor="#E9EBEF"> Applicant Address:</td>
<td>&nbsp;<bean:write name="battery" property="applicantAddress"/></td>
</tr>
<tr>
<td align="right" bgcolor="#E9EBEF"> Manufacturer:</td>
<td>&nbsp;<bean:write name="battery" property="manufacturer"/></td>
<td align="right" bgcolor="#E9EBEF">Manufacturer Address:</td>
<td>&nbsp;<bean:write name="battery" property="manufacturerAddress"/></td>
</tr>

<tr>
  <td align="right" bgcolor="#E9EBEF">Product Name:</td>
  <td>&nbsp;<bean:write name="battery" property="productDescription"/></td>
  <td align="right" bgcolor="#E9EBEF">Brand:</td>
  <td>&nbsp;<bean:write name="battery" property="brand"/></td>
</tr>
<tr>
  <td align="right" bgcolor="#E9EBEF"> Start Date:</td>
  <td>&nbsp;<bean:write name="battery" property="startDate" formatKey="date.formkey"/></td>
  <td align="right" bgcolor="#E9EBEF">Origin:</td>
  <td>&nbsp;<gdc:write name="battery" property="origin" labelvalue="Country"/></td>
</tr>
<tr>
  <td align="right" bgcolor="#E9EBEF">Expired Date:</td>
  <td>&nbsp;<bean:write name="battery" property="expiredDate" formatKey="date.formkey"/></td>
<td align="right"  bgcolor="#E9EBEF" >&nbsp;</td>
<td>&nbsp;</td>
</tr>


</table>



<br>



<table style="display: block" width="95%" border="1" align="center"  cellpadding="2" cellspacing="0" bgcolor="#FFFFFF" bordercolor="silver">



<tr bgcolor="#E9EBEF" align="center">

<td width="2%">NO</td>
<td width="5%">PartNo</td>
<td width="5%">Type</td>
<td width="5%">Voltage(V)</td>
<td width="5%">Capacity(mAh)</td>

</tr>


<logic:iterate id="item" name="battery" property="impCertificateBatteryLines" indexId="index2">

<tr align="center" height="" onMouseOut="this.style.backgroundColor='#FFFFFF'" onMouseOver="this.style.backgroundColor='#DDDDDD'" >

<td ><gdc:iteratorNO indexId="index2" /></td>

<td ><bean:write name="item" property="partNo" /></td>

<td ><bean:write name="item" property="productModel" /></td>

<td ><bean:write name="item" property="voltage" /></td>

<td ><bean:write name="item" property="capacity" /></td>

</tr>

</logic:iterate>


</table>

<br>

<br>
