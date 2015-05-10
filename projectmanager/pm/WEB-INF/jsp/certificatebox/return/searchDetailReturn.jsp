<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="gbk" %>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>


<%@ taglib uri="/WEB-INF/struts-gdc.tld" prefix="gdc"%>

<br>

<table width="95%" border="1" id="results_table" style="display:block" align="center" cellpadding="2" cellspacing="0" borderColor="silver" class="datatable">

<tr>
<td  width="25%" align="right" bgcolor="#E9EBEF">Pack size:</td>
  <td width="25%">&nbsp;<bean:write name="box" property="boxLength" />
		*<bean:write name="box" property="boxWidth" />
		*<bean:write name="box" property="boxHeight" /></td>
  <td width="25%" align="right" bgcolor="#E9EBEF">Packing Certificate No.:</td>
  <td width="25%">&nbsp;<bean:write name="box" property="certificateBoxNo" /></td>
</tr>
<tr>
<td align="right" bgcolor="#E9EBEF">Packing Material:</td>
<td>&nbsp;<gdc:write name="box" property="packType" labelvalue="BoxPackType" /></td>
<td align="right" bgcolor="#E9EBEF"> Transport mode:</td>
<td>&nbsp;<gdc:write name="box" property="transportMode" labelvalue="BoxTransType" /></td>
</tr>
<tr>
<td align="right" bgcolor="#E9EBEF"> Times Available:</td>
<td>&nbsp;<bean:write name="box" property="timesAvailable"/></td>
<td align="right" bgcolor="#E9EBEF">Times Used :</td>
<td>&nbsp;<bean:write name="box" property="timesUsed"/></td>
</tr>

<tr>
  <td align="right" bgcolor="#E9EBEF">Expired Date:</td>
  <td>&nbsp;<bean:write name="box" property="expireDate" formatKey="date.formkey"/></td>
  
  <td align="right" bgcolor="#E9EBEF">&nbsp;</td>
  <td>&nbsp;</td>
</tr>


</table>


<br>

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="expCertificateBoxModify1PreAction.do?certificateBoxId=<bean:write name="box" property="certificateBoxId" />">Edit</a>
&nbsp;&nbsp;&nbsp;&nbsp;
<a href="#" onclick="before_delete('<bean:write name="box" property="certificateBoxId" />')">Delete</a>
<br>
<br>
