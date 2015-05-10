package edu.pm.uc.projectreport.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.pm.base.PMBaseAction;
import edu.pm.uc.projectreport.bo.ProjectReportCreateBO;
import edu.pm.uc.projectreport.form.ProjectReportForm;
import edu.pm.vo.ProjectReports;

public class ProjectReportCreateAction extends PMBaseAction {

	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)

	throws Exception {

		String projectId =(String) request.getSession().getAttribute("projectId");
		
		
		ProjectReportForm aform = (ProjectReportForm) form;
		ProjectReports vo=aform.getVo();
		vo.setProjectId(new Long(projectId));
		
		// new
		ProjectReportCreateBO bo=new ProjectReportCreateBO(vo);
		bo.execute();
			
		aform.reset(mapping,request);
		
		return mapping.findForward("success");

	}

}
