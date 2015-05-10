package edu.pm.uc.projectlist.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.dlmu.sei.util.ConstantsContainer;
import edu.pm.base.PMBaseAction;
import edu.pm.constants.PMConstants;
import edu.pm.vo.Projects;

public class HumanResPreAction extends PMBaseAction {

	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)

	throws Exception {
		
		String isReEntry=request.getParameter("reEntry");
		if(isReEntry!=null){
			return mapping.findForward("success");
		}

		String projectId = request.getParameter("projectId");
		
		request.getSession().setAttribute("projectId",projectId);

		// 标题信息 ----------------------------------------------------------

		Projects project = (Projects) ConstantsContainer.getInstants().getVO(
				PMConstants.Projects, projectId);

		request.setAttribute("project", project);

		return mapping.findForward("success");

	}

}
