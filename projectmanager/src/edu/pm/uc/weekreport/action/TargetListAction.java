package edu.pm.uc.weekreport.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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
import edu.pm.vo.Projects;
import edu.pm.vo.Targets;
import edu.pm.vo.WeekReports;
import edu.pm.vo.Weeks;

public class TargetListAction extends PMBaseAction {

	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)

	throws Exception {

		String weekId = request.getParameter("weekId");
		Long weekIdLong = new Long(weekId);
		
		PMBaseQuery weekQuery = new PMBaseQuery(Weeks.class);
		Weeks week = (Weeks)weekQuery.loadByID(Weeks.class,weekIdLong,false);
		Date startDate = week.getStartDate();
		Date endDate = week.getEndDate();


		// project infor ----------------------------------------------------------------------
		String projectId = (String) request.getSession().getAttribute("projectId");

		Projects project = (Projects) ConstantsContainer.getInstants().getVO(PMConstants.Projects, projectId);

		request.setAttribute("project", project);


		List resultList = new ArrayList();

		// 任务列表 ----------------------------------------------------------

		PMBaseQuery targetQuery = new PMBaseQuery(Targets.class);

		targetQuery.setEQ("projectId", projectId);

		targetQuery.setEQ("userSEId", this.getUser().getId());

		targetQuery.execute();

		List targetList = targetQuery.getResults();

		if(targetList!=null && targetList.size()>0){
			
			Iterator targetIt = targetList.iterator();
			while (targetIt.hasNext()) {
				Targets target = (Targets) targetIt.next();
				Date startDate00 = target.getStartDatePlan();
				Date endDate00 = target.getEndDatePlan();	
				if ((startDate.getTime() >= startDate00.getTime() && startDate.getTime() <= endDate00.getTime())
						|| (endDate.getTime() >= startDate00.getTime() && endDate.getTime() <= endDate00.getTime())) {
					// 检查是否已经填写了周报
					PMBaseQuery weekReportQuery = new PMBaseQuery(WeekReports.class);
					weekReportQuery.setEQ("targetId",target.getId());
					weekReportQuery.setEQ("weekId", weekIdLong );
					weekReportQuery.setEQ("submitById",this.getUser().getId());
					weekReportQuery.execute();
					List reportList = weekReportQuery.getResults();
					if(reportList!=null && reportList.size()>0){
						target.setHasReport(true);
					}
					else{
						target.setHasReport(false);
					}
					//添加这个任务
					resultList.add(target);
				}
				
			}//while targetIt
			
		}
	
		request.setAttribute("result", resultList);
		
		request.setAttribute("weekId", weekId);

		return mapping.findForward("success");

	}

}
