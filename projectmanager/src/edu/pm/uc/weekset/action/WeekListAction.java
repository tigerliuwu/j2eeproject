package edu.pm.uc.weekset.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.dlmu.sei.struts.form.BaseSearchForm;
import edu.dlmu.sei.util.ConstantsContainer;
import edu.pm.base.PMBaseAction;
import edu.pm.base.PMBaseQuery;
import edu.pm.constants.PMConstants;
import edu.pm.vo.Projects;
import edu.pm.vo.Weeks;

public class WeekListAction extends PMBaseAction {

	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)

	throws Exception {
		
		PMBaseQuery weekQuery = new PMBaseQuery(Weeks.class);
		
		weekQuery.setLazy(false);
		
		weekQuery.setOrderBy("startDate","desc");
		
		String projectId =(String) request.getSession().getAttribute("projectId");
		
		weekQuery.setEQ("projectId",new Long(projectId));
		
		// ·ÖÒ³  -------------------------------------------------
		BaseSearchForm sform = (BaseSearchForm) form;
		sform.initConditionPost();
		weekQuery.setPageRange(sform.getPageinfo());
		//      -------------------------------------------------
		
		request.setAttribute("result", weekQuery.getResults());
		
		Projects project = (Projects)ConstantsContainer.getInstants().getVO(PMConstants.Projects,projectId);;
		
		request.setAttribute("project", project);
		
		 
		return mapping.findForward("success");

	}

}
