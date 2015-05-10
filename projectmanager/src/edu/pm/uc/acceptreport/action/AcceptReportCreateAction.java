package edu.pm.uc.acceptreport.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.pm.base.PMBaseAction;
import edu.pm.uc.acceptreport.bo.AcceptReportCreateBO;
import edu.pm.uc.acceptreport.form.AcceptReportForm;
import edu.pm.vo.AcceptReports;

public class AcceptReportCreateAction extends PMBaseAction {

	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)

	throws Exception {

		String projectId =(String) request.getSession().getAttribute("projectId");
		
		
		AcceptReportForm aform = (AcceptReportForm) form;
		AcceptReports vo=aform.getVo();
		vo.setProjectId(new Long(projectId));
		
		// new
		AcceptReportCreateBO bo=new AcceptReportCreateBO(vo);
		bo.execute();
			
		aform.reset(mapping,request);
		
		return mapping.findForward("success");

	}

}
