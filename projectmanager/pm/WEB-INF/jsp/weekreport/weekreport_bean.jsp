<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="gbk" %>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>


<%@ taglib uri="/WEB-INF/struts-gdc.tld" prefix="gdc"%>

<br>

<table width="95%" border="1" id="results_table" align="center" cellpadding="2" cellspacing="0" borderColor="silver" class="datatable">

<tr>
<td align="right" bgcolor="#E9EBEF" width="15%">ʵ�ʿ�ʼʱ��:</td>
<td width="35%">&nbsp;<bean:write name="weekReport" property="startDateFact" formatKey="date.formkey"/></td>
<td align="right" bgcolor="#E9EBEF" width="15%">ʵ�ʽ���ʱ��:</td>
<td width="35%">&nbsp;<bean:write name="weekReport" property="endDateFact" formatKey="date.formkey"/></td>
</tr>
<tr>
<td align="right" bgcolor="#E9EBEF">�ύʱ��:</td>
<td>&nbsp;<bean:write name="weekReport" property="submitDate" formatKey="date.formkey"/></td>
<td align="right" bgcolor="#E9EBEF">����ʵ�ʹ�����:</td>
  <td>&nbsp;<bean:write name="weekReport" property="workloadThisweek"/></td>
</tr>
<tr>
  <td align="right" bgcolor="#E9EBEF">����ִ�����:</td>
  <td colspan="3" >&nbsp;<bean:write name="weekReport" property="excuteStatus" /></td>
</tr>
<tr>
  <td align="right" bgcolor="#E9EBEF">���ڵ�����:</td>
  <td colspan="3" >&nbsp;<bean:write name="weekReport" property="problem" /></td>
</tr>

</table>



<br>
