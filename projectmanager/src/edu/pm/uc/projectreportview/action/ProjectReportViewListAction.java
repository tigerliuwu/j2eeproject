package edu.pm.uc.projectreportview.action;

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
import edu.pm.vo.ProjectReports;
import edu.pm.vo.Projects;

public class ProjectReportViewListAction extends PMBaseAction {

	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)

	throws Exception {
		
		PMBaseQuery projectReportQuery = new PMBaseQuery(ProjectReports.class);
		
		projectReportQuery.setLazy(false);
		
		projectReportQuery.setOrderBy("reportDate","desc");
		
		String projectId =(String) request.getSession().getAttribute("projectId");
		
		projectReportQuery.setEQ("projectId",new Long(projectId));
		
		// ·ÖÒ³  -------------------------------------------------
		BaseSearchForm sform = (BaseSearchForm) form;
		sform.initConditionPost();
		projectReportQuery.setPageRange(sform.getPageinfo());
		//      -------------------------------------------------
		
		request.setAttribute("result", projectReportQuery.getResults());
		
		Projects project = (Projects)ConstantsContainer.getInstants().getVO(PMConstants.Projects,projectId);;
		
		request.setAttribute("project", project);
		
		 
		return mapping.findForward("success");

	}

}
