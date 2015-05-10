package edu.dlmu.sei.struts.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public abstract class AjaxAction extends BaseAction {

	protected ActionForward doAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		doAjax(mapping, form, request, response);

		String xml = null;
		try {
			xml = getXmlContent(mapping, form, request, response);
		} catch (Exception ex) {
			// Send back a 500 error code. ex.printStackTrace();
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
					"Can not create response");
			return null;
		}

		// Set content to xml
		response.setContentType("text/xml; charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter pw = response.getWriter();
		pw.write(xml);
		pw.close();

		return null;
	}

	/**
	 * Each child class should override this method to generate the specific XML
	 * content necessary for each AJAX action.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 *            the {@javax.servlet.http.HttpServletRequest} object
	 * @param response
	 *            the {@javax.servlet.http.HttpServletResponse} object
	 * @return a {@java.lang.String} representation of the XML response/content
	 * @throws Exception
	 */
	public abstract void doAjax(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception;

	public abstract String getXmlContent(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception;
}
