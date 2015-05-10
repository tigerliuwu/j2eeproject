package edu.pm.uc.projectreport.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.pm.base.PMBaseAction;
import edu.pm.base.PMBaseQuery;
import edu.pm.vo.ProjectReports;

public class ProjectReportSearchDetailAction extends PMBaseAction {

	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)

	throws Exception {
		
		String reportId = request.getParameter("id");
		
		PMBaseQuery reportQuery = new PMBaseQuery(ProjectReports.class);
	
		ProjectReports report = (ProjectReports) reportQuery.loadByID(ProjectReports.class,new Long(reportId),true);
		
		request.setAttribute("report", report);
		 
		return mapping.findForward("success");

	}

}
