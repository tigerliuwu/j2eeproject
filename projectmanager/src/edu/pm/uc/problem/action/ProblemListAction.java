package edu.pm.uc.problem.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.dlmu.sei.util.ConstantsContainer;
import edu.pm.base.PMBaseAction;
import edu.pm.base.PMBaseQuery;
import edu.pm.constants.PMConstants;
import edu.pm.vo.Problems;
import edu.pm.vo.Projects;

public class ProblemListAction extends PMBaseAction {

	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)

	throws Exception {
		
		// project infor
		String projectId =(String) request.getSession().getAttribute("projectId");
		
		Projects project = (Projects)ConstantsContainer.getInstants().getVO(PMConstants.Projects,projectId);;
		
		request.setAttribute("project", project);
		
		// 已汇总问题列表
		PMBaseQuery problemQuery = new PMBaseQuery(Problems.class);
		
		problemQuery.setLazy(false);
		
		problemQuery.setOrderBy("submitDate","desc");

		problemQuery.setEQ("projectId",new Long(projectId));
		
		problemQuery.setNOEQ("status",PMConstants.StatusProblemtWait);
		
		problemQuery.execute();
		
		request.setAttribute("result1", problemQuery.getResults());
		
		// 待汇总问题列表
		problemQuery.setOrderBy("submitDate","desc");

		problemQuery.setEQ("projectId",new Long(projectId));
		
		problemQuery.setEQ("status",PMConstants.StatusProblemtWait);
		
		problemQuery.execute();
		
		request.setAttribute("result2", problemQuery.getResults());
		
		 
		return mapping.findForward("success");

	}

}
