/*


 * Created on 2004/03/10


 *


 * To change the template for this generated file go to


 * Window - Preferences - Java - Code Generation - Code and Comments


 */

package edu.dlmu.sei.struts.validator;

import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.validator.ValidatorResources;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.validator.Resources;

/**
 * 
 * 
 * @author Administrator
 * 
 * 
 * 
 * 
 * 
 * To change the template for this generated type comment go to Window -
 * 
 * 
 * Preferences - Java - Code Generation - Code and Comments
 * 
 * 
 */

public class ValidatorUtils {

	/**
	 * 
	 * 
	 * Resources key the <code>ServletContext</code> is stored under.
	 * 
	 * 
	 */

	public static String SERVLET_CONTEXT_KEY = "javax.servlet.ServletContext";

	/**
	 * 
	 * 
	 * Resources key the <code>HttpServletRequest</code> is stored under.
	 * 
	 * 
	 */

	public static String HTTP_SERVLET_REQUEST_KEY = "javax.servlet.http.HttpServletRequest";

	/**
	 * 
	 * 
	 * Resources key the <code>ActionErrors</code> is stored under.
	 * 
	 * 
	 */

	public static String ACTION_ERRORS_KEY = "org.apache.struts.action.ActionErrors";

	/**
	 * 
	 * 
	 * Initialize the <code>Validator</code> to perform validation.
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @param key
	 *            The key that the validation rules are under (the form elements
	 * 
	 * 
	 * name attribute).
	 * 
	 * 
	 * @param bean
	 *            The bean validation is being performed on.
	 * 
	 * 
	 * @param application
	 *            servlet context
	 * 
	 * 
	 * @param request
	 *            The current request object.
	 * 
	 * 
	 * @param errors
	 *            The object any errors will be stored in.
	 * 
	 * 
	 * @param page
	 *            This in conjunction with the page property of a
	 * 
	 * 
	 * <code>Field<code> can control the processing of fields.  If the field's 


	 * page is less than or equal to this page value, it will be processed.


	 */

	public static Validator4Me initLilliput3Validator(String key,

	Object bean, ServletContext application,

	HttpServletRequest request, ActionErrors errors, int page) {

		ValidatorResources resources = Resources.getValidatorResources(

		application, request);

		Locale locale = Resources.getLocale(request);

		Validator4Me validator = new Validator4Me(resources, key);

		validator.setUseContextClassLoader(true);

		validator.setPage(page);

		validator.addResource(SERVLET_CONTEXT_KEY, application);

		validator.addResource(HTTP_SERVLET_REQUEST_KEY, request);

		validator.addResource(Validator4Me.LOCALE_KEY, locale);

		validator.addResource(ACTION_ERRORS_KEY, errors);

		validator.addResource(Validator4Me.BEAN_KEY, bean);

		return validator;

	}

}
