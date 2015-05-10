<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="GBK"%>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<br>

<bean:define name="impCertificateODetailForm" property="certificateLineId" id="certificateOLineId"></bean:define>

<html:form action="/impCertificateOSaveDetailAction" styleId="<%=certificateOLineId.toString()%>">

	<html:hidden name="impCertificateODetailForm" property="certificateLineId" />

	<table width="95%" border="1" id="results_table" align="center" cellpadding="2" cellspacing="0" borderColor="silver" class="datatable">

		<tr>
			<td bgcolor="#E9EBEF" align="right">
				Specification:
			</td>
			<td>
				<html:text styleId="itemID" name="impCertificateODetailForm" property="specification" styleClass="inputline" />
			</td>
			<td bgcolor="#E9EBEF" align="right">
				Unit:
			</td>
			<td>
				<html:text name="impCertificateODetailForm" property="unit" styleClass="inputline" />
			</td>
		</tr>

		<tr>
			<td bgcolor="#E9EBEF" align="right">
				Quantity:
			</td>
			<td>
				<html:text name="impCertificateODetailForm" property="quantity" styleClass="inputline" />
			</td>
			<td bgcolor="#E9EBEF" align="right">
				Unit price:
			</td>
			<td>
				<html:text name="impCertificateODetailForm" property="unitPrice" styleClass="inputline" />
			</td>
		</tr>

	</table><br>
&nbsp;&nbsp;&nbsp;&nbsp;<input name="Submit" type="button" class="button" value=" Save " onclick="updateContent('<bean:write name="impCertificateODetailForm" property="certificateLineId" />');">
&nbsp;&nbsp;<input name="Submit" type="button" class="button" value=" Delete " onclick="if(confirm('Delete?')){del('<bean:write name="impCertificateODetailForm" property="certificateLineId" />');}">
<br><br><div id="errors_<bean:write name="impCertificateODetailForm" property="certificateLineId" />" color="red"></div>
	
</html:form>
