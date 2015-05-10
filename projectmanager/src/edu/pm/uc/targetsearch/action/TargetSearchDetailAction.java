package edu.pm.uc.targetsearch.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.pm.base.PMBaseAction;
import edu.pm.base.PMBaseQuery;
import edu.pm.vo.Targets;

public class TargetSearchDetailAction extends PMBaseAction {

	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)

	throws Exception {
		
		String targetId = request.getParameter("id");
		
		PMBaseQuery targetQuery = new PMBaseQuery(Targets.class);
	
		Targets target = (Targets) targetQuery.loadByID(Targets.class,new Long(targetId),true);
		
		request.setAttribute("target", target);
		 
		return mapping.findForward("success");

	}

}
