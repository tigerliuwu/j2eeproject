<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="GBK"%>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<%@ taglib uri="/WEB-INF/struts-gdc.tld" prefix="gdc"%>


<br>

<table style="display: block" width="95%" border="1" align="center"  cellpadding="2" cellspacing="0" bgcolor="#FFFFFF" bordercolor="silver">


<tr bgcolor="#E9EBEF" align="center">

<td width="2%">序号</td>
<td width="5%">任务名称</td>
<td width="5%">个人任务描述</td>
<td width="5%">计划开始时间</td>
<td width="5%">计划结束时间</td>
<td width="5%">个人计划工作量</td>
<td width="5%">填写周报</td>

</tr>


<%--
<logic:iterate id="item" name="battery" property="impCertificateBatteryLines" indexId="index2">
--%>
<logic:iterate id="item" name="result" indexId="index2">

<tr align="center" height="" onMouseOut="this.style.backgroundColor='#FFFFFF'" onMouseOver="this.style.backgroundColor='#DDDDDD'" >

<td ><gdc:iteratorNO indexId="index2" /></td>

<td ><bean:write name="item" property="targetName" /></td>

<td ><bean:write name="item" property="remark" /></td>

<td ><bean:write name="item" property="startDatePlan" formatKey="date.formkey"/></td>

<td ><bean:write name="item" property="endDatePlan" formatKey="date.formkey"/></td>

<td ><bean:write name="item" property="workloadPlan" />（已完成：<bean:write name="item" property="workloadFact" />）</td>

<td >操作</td>

</tr>

</logic:iterate>


</table>

<br>