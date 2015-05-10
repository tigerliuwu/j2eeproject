package edu.pm.uc.workloadpic.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.dlmu.sei.util.ConstantsContainer;
import edu.pm.base.PMBaseAction;
import edu.pm.base.PMBaseQuery;
import edu.pm.constants.PMConstants;
import edu.pm.vo.Projects;
import edu.pm.vo.Weeks;

public class WorkloadPicPreAction extends PMBaseAction {

	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)

	throws Exception {
		
		String isReEntry=request.getParameter("reEntry");
		if(isReEntry!=null){
			return mapping.findForward("success");
		}

		String projectId = (String)request.getSession().getAttribute("projectId");

		// 标题信息 ----------------------------------------------------------

		Projects project = (Projects) ConstantsContainer.getInstants().getVO(
				PMConstants.Projects, projectId);

		request.setAttribute("project", project);
		
		PMBaseQuery weekQuery = new PMBaseQuery(Weeks.class);
		
		weekQuery.setEQ("projectId",project.getId());
		
		weekQuery.setOrderBy("startDate","desc");
		
		weekQuery.execute();
		
		request.setAttribute("weeks", weekQuery.getResults());

		return mapping.findForward("success");

	}

}
