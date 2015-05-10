/* * Created on 2004-7-9 * * TODO To change the template for this generated file go to *
 *  Window - Preferences - Java - Code Style - Code Templates */
package edu.dlmu.sei.struts.action;

import java.math.BigDecimal;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.Globals;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.MessageResources;

import edu.dlmu.sei.exception.HttpTokenException;

/**
 * * *
 * 
 * @author stony.feng * * * * TODO To change the template for this generated
 *         type comment go to Window - * * Preferences - Java - Code Style -
 *         Code Templates *
 */
public abstract class BaseAction extends Action {

	protected static BigDecimal ZERO = new BigDecimal("0");

	protected long startTime = 0;

	private static Logger logger = Logger.getLogger(BaseAction.class);
	
	protected HttpServletRequest request;

	protected String getMessages(HttpServletRequest request, String key) {
		MessageResources resources = (MessageResources) request
				.getAttribute(Globals.MESSAGES_KEY);
		Locale locale = (Locale) request.getSession().getAttribute(
				Globals.LOCALE_KEY);
		return resources.getMessage(locale, key);
	}

	protected String getMessages(HttpServletRequest request,
			ActionMessage message) {

		MessageResources resources = (MessageResources) request
				.getAttribute(Globals.MESSAGES_KEY);
		Locale locale = (Locale) request.getSession().getAttribute(
				Globals.LOCALE_KEY);

		return resources.getMessage(locale, message.getKey(), message
				.getValues());
	}

	protected void needTokenValid(HttpServletRequest request) {
		if (!isTokenValid(request, true)) {
			throw new HttpTokenException();
		}
	}

	protected void performTokenCheck(ActionMapping mapping,
			HttpServletRequest request) {
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		this.request = request;

		startTime = System.currentTimeMillis();

		performTokenCheck(mapping, request);

		ActionForward forward = doAction(mapping, form, request, response);

		log("execute " + getClass().getName(), startTime);

		return forward;
	}

	protected abstract ActionForward doAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception;

	protected void log(String message, long startTime) {
		if (System.currentTimeMillis() - startTime > 10000)
			logger.error(message + " time: "
					+ (System.currentTimeMillis() - startTime) + " msecs.");

		if (logger.isInfoEnabled())
			logger.info(message + " time: "
					+ (System.currentTimeMillis() - startTime) + " msecs.");
	}
}