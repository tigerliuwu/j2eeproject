package edu.dlmu.sei.struts.form;

import java.io.UnsupportedEncodingException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts.Globals;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.MessageResources;
import org.apache.struts.validator.ValidatorForm;

public class BaseActionForm extends ValidatorForm {
	private static Logger logger = Logger.getLogger(BaseActionForm.class);

	protected HttpServletRequest request;

	protected static String FORMID_prefix = "gdc_ajax_id_form_";

	public BaseActionForm() {
		super();
	}

	public String getMessages(String key, Object args[]) {
		MessageResources resources = (MessageResources) request
				.getAttribute(Globals.MESSAGES_KEY);
		Locale locale = (Locale) request.getSession().getAttribute(
				Globals.LOCALE_KEY);
		return resources.getMessage(locale, key, args);
	}

	public String getMessages(ActionMessage message) {

		MessageResources resources = (MessageResources) request
				.getAttribute(Globals.MESSAGES_KEY);
		Locale locale = (Locale) request.getSession().getAttribute(
				Globals.LOCALE_KEY);

		return resources.getMessage(locale, message.getKey(), message
				.getValues());
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		try {
			
			if (request.getMethod().equals("GET"))
				request.setCharacterEncoding("GBK");
			else
				request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		this.request = request;
	}

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		logger.debug("begin validate");
		ActionErrors errors = super.validate(mapping, request);
		logger.debug("end validate.xml validate and error size is "
				+ errors.size());
		return errors;
	}

}