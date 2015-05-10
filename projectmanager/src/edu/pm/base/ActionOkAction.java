package edu.pm.base;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;



public class ActionOkAction extends PMBaseAction {



	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response)

			throws Exception {

			String url=request.getParameter("url");
	
			request.setAttribute("url",url);

			return mapping.findForward("success");

	}



}

