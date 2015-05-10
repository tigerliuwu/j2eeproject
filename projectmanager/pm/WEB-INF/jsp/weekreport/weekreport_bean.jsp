<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="gbk" %>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>


<%@ taglib uri="/WEB-INF/struts-gdc.tld" prefix="gdc"%>

<br>

<table width="95%" border="1" id="results_table" align="center" cellpadding="2" cellspacing="0" borderColor="silver" class="datatable">

<tr>
<td align="right" bgcolor="#E9EBEF" width="15%">实际开始时间:</td>
<td width="35%">&nbsp;<bean:write name="weekReport" property="startDateFact" formatKey="date.formkey"/></td>
<td align="right" bgcolor="#E9EBEF" width="15%">实际结束时间:</td>
<td width="35%">&nbsp;<bean:write name="weekReport" property="endDateFact" formatKey="date.formkey"/></td>
</tr>
<tr>
<td align="right" bgcolor="#E9EBEF">提交时间:</td>
<td>&nbsp;<bean:write name="weekReport" property="submitDate" formatKey="date.formkey"/></td>
<td align="right" bgcolor="#E9EBEF">本周实际工作量:</td>
  <td>&nbsp;<bean:write name="weekReport" property="workloadThisweek"/></td>
</tr>
<tr>
  <td align="right" bgcolor="#E9EBEF">任务执行情况:</td>
  <td colspan="3" >&nbsp;<bean:write name="weekReport" property="excuteStatus" /></td>
</tr>
<tr>
  <td align="right" bgcolor="#E9EBEF">存在的问题:</td>
  <td colspan="3" >&nbsp;<bean:write name="weekReport" property="problem" /></td>
</tr>

</table>



<br>
