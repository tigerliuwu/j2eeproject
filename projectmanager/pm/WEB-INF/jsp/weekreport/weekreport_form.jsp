<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="gbk" %>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<%@ taglib uri="/WEB-INF/struts-gdc.tld" prefix="gdc"%>

<br>
<html:form action="/weekReportCreateAction">
	<html:hidden name="weekReportForm" property="id" />
	<html:hidden name="weekReportForm" property="targetId" />
	<html:hidden name="weekReportForm" property="weekId" />
	<html:hidden name="weekReportForm" property="submitById" />
	<html:hidden name="weekReportForm" property="submitDate" />
	
	

<table width="95%"  id="results_table" align="center" border="1" cellpadding="2" cellspacing="0" borderColor="#FFFFFF"  class="datatable">

<tr>
<td align="right" bgcolor="#E9EBEF" width="15%">ʵ�ʿ�ʼʱ��:</td>
<td width="35%">&nbsp;
<html:text name="weekReportForm" property="startDateFact" styleClass="inputline" size="40" onfocus="selectDate(this);"/>
</td>
<td align="right" bgcolor="#E9EBEF" width="15%">ʵ�ʽ���ʱ��:</td>
<td width="35%">&nbsp;
<html:text name="weekReportForm" property="endDateFact" styleClass="inputline" size="40" onfocus="selectDate(this);"/>
</td>
</tr>
<tr>
<td align="right" bgcolor="#E9EBEF">����ʵ�ʹ�����:</td>
  <td>&nbsp;
  <html:text name="weekReportForm" property="workloadThisweek" styleClass="inputline" size="40" />
  </td>
  <td>&nbsp;</td><td>&nbsp;</td>
</tr>
<tr>
  <td align="right" bgcolor="#E9EBEF">����ִ�����:</td>
  <td bgcolor="#FFFFFF">&nbsp;
		<html:textarea cols="40" rows="3" name="weekReportForm" property="excuteStatus" />
  </td>
  <td align="right" bgcolor="#E9EBEF">���ڵ����⣺</td>
	 <td bgcolor="#FFFFFF">&nbsp;
		<html:textarea cols="40" rows="3" name="weekReportForm" property="problem" />
  </td>
</tr>

<tr valign="bottom">
	<td colspan="4" bgcolor="#FFFFFF" align="center" height="40" >
			<input type="submit" class="button" value="  �� ��  " />
	</td>
</tr>

</table>

<html:errors />
<gdc:errors />

</html:form>

