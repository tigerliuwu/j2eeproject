package edu.pm.uc.background.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.pm.base.PMBaseAction;

public class BackHrefAction extends PMBaseAction {

	protected ActionForward doWork(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)

	throws Exception {

		String treeid = request.getParameter("treeid");
		String kind = "";
		String id = "";
		
		if(treeid!=null){
			treeid=treeid.trim();
			kind = treeid.substring(0,4);
			id = treeid.substring(4);
		}
		
		request.setAttribute("kind", kind);
		
		request.setAttribute("id", id);

		return mapping.findForward("success");
	}

}
