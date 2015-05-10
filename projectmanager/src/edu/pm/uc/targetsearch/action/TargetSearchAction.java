package edu.pm.uc.targetsearch.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.dlmu.sei.util.ConstantsContainer;
import edu.dlmu.sei.util.CoreUtils;
import edu.pm.base.PMBaseAction;
import edu.pm.base.PMBaseQuery;
import edu.pm.constants.PMConstants;
import edu.pm.uc.targetsearch.form.TargetCondition;
import edu.pm.uc.targetsearch.form.TargetSearchForm;
import edu.pm.vo.Projects;
import edu.pm.vo.Targets;

public class TargetSearchAction extends PMBaseAction {

	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)

	throws Exception {
		
		String projectId =(String) request.getSession().getAttribute("projectId");
		
		TargetSearchForm sform = (TargetSearchForm) form;
		
		sform.initConditionPost();
		
		TargetCondition condition = (TargetCondition) sform.getCondition();

		PMBaseQuery targetQuery = new PMBaseQuery(Targets.class);
		
		targetQuery.setLazy(false);
		
		targetQuery.setEQ("projectId",new Long(projectId));
		
		targetQuery.setDateBetween("startDatePlan", CoreUtils
				.parseDate(condition.getStartDatePlanFrom()), CoreUtils
				.parseDate(condition.getStartDatePlanTo()));
		
		targetQuery.setDateBetween("endDatePlan", CoreUtils
				.parseDate(condition.getEndDatePlanFrom()), CoreUtils
				.parseDate(condition.getEndDatePlanTo()));
		
		System.out.println("condition.getUserSEId():"+condition.getUserSEId());
		
		System.out.println("condition.getStatus():"+condition.getStatus());
		
		if(!(condition.getUserSEId()==null || condition.getUserSEId().equals(""))){
			targetQuery.setEQ("userSEId",new Long(condition.getUserSEId()));
		}
		
		if(!(condition.getStatus()==null || condition.getStatus().equals(""))){
			targetQuery.setEQ("status",condition.getStatus());
		}

		targetQuery.setLIKE("targetName",condition.getTargetName());

		targetQuery.setPageRange(sform.getPageinfo());

		targetQuery.setOrderBy("targetOrder","asc");
		
		targetQuery.execute();
		
		request.setAttribute("result", targetQuery.getResults());
		
		// project -----------------------------------------------------------------------
		
		Projects project = (Projects)ConstantsContainer.getInstants().getVO(PMConstants.Projects,projectId);;
		
		request.setAttribute("project", project);
		
		 
		return mapping.findForward("success");

	}

}
