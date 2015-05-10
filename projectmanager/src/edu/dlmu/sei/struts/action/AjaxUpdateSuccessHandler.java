package edu.dlmu.sei.struts.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ajaxtags.helpers.AjaxXmlBuilder;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class AjaxUpdateSuccessHandler extends AjaxAction {

	public void doAjax(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	}

	private static final long serialVersionUID = 1L;

	public String getXmlContent(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		List successList = new ArrayList();

		NameValuePair nameValuePair = new NameValuePair();

		nameValuePair.setName("SUCCESS");

		nameValuePair.setValue("Y");

		successList.add(nameValuePair);

		return new AjaxXmlBuilder().addItems(successList, "name", "value")
				.toString();

	}

}
