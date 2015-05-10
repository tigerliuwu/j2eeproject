<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="GBK"%>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<br>

<bean:define name="impCertificateBatteryDetailForm" property="certificateBatteryLineId" id="certificateBatteryLineId"></bean:define>

<html:form action="/impCertificateBatterySaveDetailAction" styleId="<%=certificateBatteryLineId.toString()%>">

	<html:hidden name="impCertificateBatteryDetailForm" property="certificateBatteryLineId" />
	<html:hidden name="impCertificateBatteryDetailForm" property="certificateBatteryId" />

	<table width="95%" border="1" id="results_table" align="center" cellpadding="2" cellspacing="0" borderColor="silver" class="datatable">

		<tr>
			<td width="25%" bgcolor="#E9EBEF" align="right">
				PartNo:
			</td>
			<td width="25%">
				<html:text styleId="itemID" name="impCertificateBatteryDetailForm" property="partNo" styleClass="inputline" />
			</td>
			<td width="25%" bgcolor="#E9EBEF" align="right">
				Type:
			</td>
			<td width="25%">
				<html:text name="impCertificateBatteryDetailForm" property="productModel" styleClass="inputline" />
			</td>
		</tr>

		<tr>
			<td bgcolor="#E9EBEF" align="right">
				Voltage(V):
			</td>
			<td>
				<html:text name="impCertificateBatteryDetailForm" property="voltage" styleClass="inputline" />
			</td>
			<td bgcolor="#E9EBEF" align="right">
				Capacity(mAh):
			</td>
			<td>
				<html:text name="impCertificateBatteryDetailForm" property="capacity" styleClass="inputline" />
			</td>
		</tr>

	</table><br>
&nbsp;&nbsp;&nbsp;&nbsp;<input name="Submit" type="button" class="button" value=" Save " onclick="updateContent('<bean:write name="impCertificateBatteryDetailForm" property="certificateBatteryLineId" />');">
&nbsp;&nbsp;<input name="Submit" type="button" class="button" value=" Delete " onclick="if(confirm('Delete?')){del('<bean:write name="impCertificateBatteryDetailForm" property="certificateBatteryLineId" />');}">
<br><br><div id="errors_<bean:write name="impCertificateBatteryDetailForm" property="certificateBatteryLineId" />" color="red"></div>
	
</html:form>
