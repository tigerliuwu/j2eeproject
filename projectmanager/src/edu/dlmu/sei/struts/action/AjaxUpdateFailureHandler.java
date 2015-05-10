package edu.dlmu.sei.struts.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ajaxtags.helpers.AjaxXmlBuilder;
import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

public class AjaxUpdateFailureHandler extends AjaxAction {

	public void doAjax(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	}

	public String getXmlContent(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		List errorList = new ArrayList();

		ActionMessages errors = (ActionMessages) request.getAttribute(Globals.ERROR_KEY);

		NameValuePair nameValuePairInit = new NameValuePair();

		nameValuePairInit.setName("SUCCESS");

		nameValuePairInit.setValue("N");

		errorList.add(nameValuePairInit);

		for (Iterator propertyNames = errors.properties(); propertyNames
				.hasNext();) {

			String propertyName = (String) propertyNames.next();

			Iterator errorDesKey = errors.get(propertyName);

			StringBuffer msgValue = new StringBuffer();

			NameValuePair errorNameValuePair = new NameValuePair();

			while (errorDesKey.hasNext()) {

				ActionMessage key = (ActionMessage) errorDesKey.next();

				msgValue.append(getMessages(request, key));
			}

			errorNameValuePair.setName(propertyName);

			errorNameValuePair.setValue(msgValue.toString());

			errorList.add(errorNameValuePair);

		}

		return new AjaxXmlBuilder().addItems(errorList, "name", "value")
				.toString();

	}
}
