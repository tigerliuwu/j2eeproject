
package edu.pm.uc.background.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.pm.base.PMBaseAction;
import edu.pm.uc.background.bo.UserDeleteBO;



public class BackUserDeleteAction extends PMBaseAction {

	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)

	throws Exception {
		
		String Id = request.getParameter("id");

		Long IdLong = new Long(Id);
	
		UserDeleteBO bo = new UserDeleteBO(IdLong);
	
		bo.execute();
		
		return mapping.findForward("success");


	}

}
