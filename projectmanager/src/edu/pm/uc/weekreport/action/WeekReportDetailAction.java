package edu.pm.uc.weekreport.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.pm.base.PMBaseAction;
import edu.pm.base.PMBaseQuery;
import edu.pm.uc.weekreport.form.WeekReportForm;
import edu.pm.vo.WeekReports;

public class WeekReportDetailAction extends PMBaseAction {

	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)

	throws Exception {
		
		String weekTargetId = request.getParameter("weekTargetId");
		
		int i = weekTargetId.indexOf("_");
		
		String weekId = weekTargetId.substring(0,i);
		
		String targetId = weekTargetId.substring(i+1);
		
		PMBaseQuery weekReportQuery = new PMBaseQuery(WeekReports.class);
		
		weekReportQuery.setEQ("targetId",new Long(targetId));
		
		weekReportQuery.setEQ("weekId",new Long(weekId));
		
		weekReportQuery.setEQ("submitById",this.getUser().getId());
		
		weekReportQuery.execute();
		
		List resultList = weekReportQuery.getResults();
		
		if(resultList!=null && resultList.size()>0){
			WeekReports weekReport = (WeekReports)resultList.get(0);
			request.setAttribute("weekReport", weekReport);
			
			return mapping.findForward("bean");
		}
		else{
			WeekReportForm aform = (WeekReportForm) form;
			aform.setTargetId(targetId);
			aform.setWeekId(weekId);
			
			return mapping.findForward("form");
		}
		

	}

}
