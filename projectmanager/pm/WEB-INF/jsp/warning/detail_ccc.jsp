<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="gbk" %>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>


<%@ taglib uri="/WEB-INF/struts-gdc.tld" prefix="gdc"%>

<br>

<table width="95%" border="1" id="results_table" style="display:block" align="center" cellpadding="2" cellspacing="0" borderColor="silver" class="datatable">

<tr>
<td width="25%" align="right" bgcolor="#E9EBEF">CCC Certificate No.:</td>
  <td width="25%">&nbsp;<bean:write name="ccc" property="certificateCccno"/></td>
  <td width="25%" align="right" bgcolor="#E9EBEF">Certificate Status:</td>
  <td width="25%">&nbsp;<gdc:write name="ccc" property="currentStatus" labelvalue="CertificateStatus"/></td>
</tr>

<tr>
  <td align="right" bgcolor="#E9EBEF"> Certificate Type:</td>
  <td>&nbsp;<gdc:write name="ccc" property="certificateType" labelvalue="CCCType"/></td>
  <td align="right" bgcolor="#E9EBEF">Archive No.:</td>
  <td>&nbsp;<bean:write name="ccc" property="archiveNo" /></td>
</tr>
<tr>
  <td align="right" bgcolor="#E9EBEF">Expired Date:</td>
  <td>&nbsp;<bean:write name="ccc" property="expiredDate" formatKey="date.formkey"/></td>
<td align="right"  bgcolor="#E9EBEF" >&nbsp;</td>
<td>&nbsp;</td>
</tr>


</table>



<br>



<table style="display: block" width="95%" border="1" align="center"  cellpadding="2" cellspacing="0" bgcolor="#FFFFFF" bordercolor="silver">



<tr bgcolor="#E9EBEF" align="center">

<td width="2%">NO</td>
<td width="5%">PartNo</td>
<td width="5%">Product Description</td>
<td width="5%">Unit</td>
<td width="5%">Unit/Weight</td>
<td width="5%">Remark</td>

</tr>


<logic:iterate id="item" name="ccc" property="pubItems" indexId="index2">

<tr align="center" height="" onMouseOut="this.style.backgroundColor='#FFFFFF'" onMouseOver="this.style.backgroundColor='#DDDDDD'" >

<td ><gdc:iteratorNO indexId="index2" /></td>

<td ><bean:write name="item" property="partno" /></td>

<td ><bean:write name="item" property="productDescription" /></td>

<td ><bean:write name="item" property="unit" /></td>

<td ><bean:write name="item" property="unitWeight" /></td>

<td ><bean:write name="item" property="remark" /></td>

</tr>

</logic:iterate>


</table>

<br>

<br>
