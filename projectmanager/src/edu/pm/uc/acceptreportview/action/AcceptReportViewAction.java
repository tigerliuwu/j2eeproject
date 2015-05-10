package edu.pm.uc.acceptreportview.action;

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
import edu.pm.vo.AcceptReports;
import edu.pm.vo.Projects;

public class AcceptReportViewAction extends PMBaseAction {

	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)

	throws Exception {
		
		String projectId = (String)request.getSession().getAttribute("projectId");

		// 标题信息 ----------------------------------------------------------

		Projects project = (Projects) ConstantsContainer.getInstants().getVO(PMConstants.Projects, projectId);

		request.setAttribute("project", project);
		
		//  报告信息 ----------------------------------------------------------
		
		PMBaseQuery acceptReportQuery = new PMBaseQuery(AcceptReports.class);
		
		acceptReportQuery.setEQ("projectId",new Long(projectId));
			
		acceptReportQuery.execute();
		
		List aList = acceptReportQuery.getResults();
		
		if(aList!=null && aList.size()!=0){
			
			AcceptReports acceptReport = (AcceptReports)aList.get(0);
			
			request.setAttribute("acceptReport",acceptReport);
			
			return mapping.findForward("success");
		}
		else{
			
			return mapping.findForward("fail");
			
		}
	


	}

}
