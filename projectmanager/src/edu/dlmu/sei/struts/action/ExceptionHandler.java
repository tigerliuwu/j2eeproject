/*

 * Created on 2005-1-27

 *

 * TODO To change the template for this generated file go to

 * Window - Preferences - Java - Code Style - Code Templates

 */

package edu.dlmu.sei.struts.action;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts.Globals;

import org.apache.struts.action.ActionForm;

import org.apache.struts.action.ActionMessage;

import org.apache.struts.action.ActionForward;

import org.apache.struts.action.ActionMapping;

import org.apache.struts.config.ExceptionConfig;

import edu.dlmu.sei.exception.StrutsRunException;

/**
 * 
 * @author george.lv
 * 
 * 
 * 
 * TODO To change the template for this generated type comment go to
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 * 
 */

public class ExceptionHandler extends org.apache.struts.action.ExceptionHandler {

	/**
	 * 
	 * Handle the exception.
	 * 
	 * Return the <code>ActionForward</code> instance (if any) returned by
	 * 
	 * the called <code>ExceptionHandler</code>.
	 * 
	 * 
	 * 
	 * @param ex
	 *            The exception to handle
	 * 
	 * @param ae
	 *            The ExceptionConfig corresponding to the exception
	 * 
	 * @param mapping
	 *            The ActionMapping we are processing
	 * 
	 * @param formInstance
	 *            The ActionForm we are processing
	 * 
	 * @param request
	 *            The servlet request we are processing
	 * 
	 * @param response
	 *            The servlet response we are creating
	 * 
	 * 
	 * 
	 * @exception ServletException
	 *                if a servlet exception occurs
	 * 
	 * 
	 * 
	 * @since Struts 1.1
	 * 
	 */

	public ActionForward execute(Exception ex,

	ExceptionConfig ae,

	ActionMapping mapping,

	ActionForm formInstance,

	HttpServletRequest request,

	HttpServletResponse response)

	throws ServletException {

		ActionForward forward = null;

		ActionMessage error = null;

		String property = null;

		// Build the forward from the exception mapping if it exists

		// or from the form input

		if (ae.getPath() != null) {

			forward = new ActionForward(ae.getPath());

		} else {

			forward = mapping.getInputForward();

		}

		// Figure out the error

		if (ex instanceof StrutsRunException) {

			error = ((StrutsRunException) ex).getError();

			property = ((StrutsRunException) ex).getProperty();

		} else {

			error = new ActionMessage(ae.getKey(), ex.getMessage());

			property = error.getKey();

		}

		// Store the exception

		request.setAttribute(Globals.EXCEPTION_KEY, ex);

		storeException(request, property, error, forward, ae.getScope());

		return forward;

	}

}
