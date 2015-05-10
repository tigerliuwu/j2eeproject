package edu.pm.base;



import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;



import org.ajaxtags.helpers.AjaxXmlBuilder;

import org.apache.struts.action.ActionForm;

import org.apache.struts.action.ActionMapping;



public class OLSBaseXmlBuildSuccessAction extends OLSBaseAjaxAction {



	public String getXmlContent(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response)

			throws Exception {



		AjaxXmlBuilder ajaxXmlBuilder = new AjaxXmlBuilder();



		ajaxXmlBuilder.addItem("success", "Y");



		return ajaxXmlBuilder.toString();



	}



}

