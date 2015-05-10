package edu.pm.uc.projectlist.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.dlmu.sei.util.ConstantsContainer;
import edu.pm.base.PMBaseAction;
import edu.pm.base.PMBaseQuery;
import edu.pm.constants.PMConstants;
import edu.pm.uc.projectlist.bo.GetUserWorkloadBO;
import edu.pm.vo.Projects;
import edu.pm.vo.Targets;

public class TeamTargetListAction extends PMBaseAction {

	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)

	throws Exception {

		String userId = request.getParameter("userId");

		String projectId = (String) request.getSession().getAttribute("projectId");

		// 标题信息 ----------------------------------------------------------

		Projects project = (Projects) ConstantsContainer.getInstants().getVO(
				PMConstants.Projects, projectId);

		request.setAttribute("project", project);

		request.setAttribute("userId", userId);

		// 任务列表 ----------------------------------------------------------

		PMBaseQuery targetQuery = new PMBaseQuery(Targets.class);

		targetQuery.setEQ("projectId", projectId);

		targetQuery.setEQ("userSEId", userId);

		targetQuery.execute();

		List targetList = targetQuery.getResults();

		request.setAttribute("targets", targetList);

		// 工作量汇总 --------------------------------------------------------
		
		System.out.println("projectId:"+projectId +"   userId:"+userId);
		
		GetUserWorkloadBO bo = new GetUserWorkloadBO(new Long(projectId),new Long(userId));
		
		bo.execute();
		
		List weekWorkloadList = bo.getWeekWorkloadList();
		
		request.setAttribute("weekWorkloads", weekWorkloadList);

		return mapping.findForward("success");

	}

}
