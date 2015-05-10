<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="gbk" %>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>


<%@ taglib uri="/WEB-INF/struts-gdc.tld" prefix="gdc"%>

<br>

<table width="95%" border="1" align="center" cellpadding="2" cellspacing="0" borderColor="silver" class="datatable">

<tr>
<td align="right" bgcolor="#E9EBEF" width="25%">报告名称:</td>
  <td width="25%">&nbsp;<bean:write name="report" property="reportName"/></td>
  <td align="right" bgcolor="#E9EBEF" width="25%">报告时间:</td>
  <td width="25%">&nbsp;<bean:write name="report" property="reportDate" formatKey="date.formkey"/></td>
</tr>
<tr>
  <td align="right" bgcolor="#E9EBEF" width="25%">项目进展情况:</td>
  <td colspan="3" width="75%">&nbsp;<bean:write name="report" property="excuteStatus" /></td>
</tr>
<tr>
  <td align="right" bgcolor="#E9EBEF" >主要问题:</td>
  <td colspan="3" >&nbsp;<bean:write name="report" property="problem" /></td>
</tr>
<tr>
  <td align="right" bgcolor="#E9EBEF" >主要风险:</td>
  <td colspan="3" >&nbsp;<bean:write name="report" property="risk" /></td>
</tr>
<tr>
  <td align="right" bgcolor="#E9EBEF" >下阶段安排 :</td>
  <td colspan="3" >&nbsp;<bean:write name="report" property="nextPlan" /></td>
</tr>

</table>


<br>
