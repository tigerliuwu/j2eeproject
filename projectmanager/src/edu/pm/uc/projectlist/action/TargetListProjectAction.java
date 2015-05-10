package edu.pm.uc.projectlist.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.pm.base.PMBaseAction;
import edu.pm.base.PMBaseQuery;
import edu.pm.vo.Targets;

public class TargetListProjectAction extends PMBaseAction {

	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)

	throws Exception {
		
		String projectId = request.getParameter("id");
		
		Long userId = getUser().getId();
		
		PMBaseQuery targetQuery = new PMBaseQuery(Targets.class);
	
		targetQuery.setEQ("projectId",projectId);
		
		targetQuery.setEQ("userSEId",userId);
		
		targetQuery.execute();
		
		request.setAttribute("result", targetQuery.getResults());
		 
		return mapping.findForward("success");

	}

}
