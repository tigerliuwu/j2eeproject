<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="gbk" %>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>


<%@ taglib uri="/WEB-INF/struts-gdc.tld" prefix="gdc"%>

<br>

<table width="95%" border="1" id="results_table" align="center" cellpadding="2" cellspacing="0" borderColor="silver" class="datatable">

<tr>
<td align="right" bgcolor="#E9EBEF" width="25%">��������:</td>
  <td width="25%">&nbsp;<bean:write name="target" property="targetName"/></td>
  <td align="right" bgcolor="#E9EBEF" width="25%">����״̬:</td>
  <td width="25%">&nbsp;<gdc:write name="target" property="status" labelvalue="TargetStatus"/></td>
</tr>
<tr>
<td align="right" bgcolor="#E9EBEF">�ƻ���ʼʱ��:</td>
<td>&nbsp;<bean:write name="target" property="startDatePlan" formatKey="date.formkey"/></td>
<td align="right" bgcolor="#E9EBEF">�ƻ�����ʱ��:</td>
<td>&nbsp;<bean:write name="target" property="endDatePlan" formatKey="date.formkey"/></td>
</tr>
<tr>
<td align="right" bgcolor="#E9EBEF">ʵ�ʿ�ʼʱ��:</td>
<td>&nbsp;<bean:write name="target" property="startDateFact" formatKey="date.formkey"/></td>
<td align="right" bgcolor="#E9EBEF">ʵ�ʽ���ʱ��:</td>
<td>&nbsp;<bean:write name="target" property="endDateFact" formatKey="date.formkey"/></td>
</tr>
<tr>
   <td align="right" bgcolor="#E9EBEF" width="25%">������:</td>
  <td width="25%">&nbsp;<gdc:write name="target" property="userSEId" labelvalue="Users"/></td>
  <td align="right" bgcolor="#E9EBEF">������������:</td>
  <td>&nbsp;<bean:write name="target" property="remark"/></td>
</tr>
<tr>
  <td align="right" bgcolor="#E9EBEF">�ƻ�������:</td>
  <td>&nbsp;<bean:write name="target" property="workloadPlan"/></td>
  <td align="right" bgcolor="#E9EBEF">ʵ�ʹ�����:</td>
  <td>&nbsp;<bean:write name="target" property="workloadFact"/></td>
</tr>
<tr>
  <td align="right" bgcolor="#E9EBEF">ִ�����:</td>
  <td>&nbsp;<bean:write name="target" property="excuteStatus" /></td>
<td align="right"  bgcolor="#E9EBEF" >&nbsp;</td>
<td>&nbsp;</td>
</tr>


</table>



<br>
