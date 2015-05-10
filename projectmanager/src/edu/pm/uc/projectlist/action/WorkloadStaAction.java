package edu.pm.uc.projectlist.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.TimeSeriesDataItem;

import edu.dlmu.sei.util.ChartUtil;
import edu.dlmu.sei.util.ConstantsContainer;
import edu.pm.base.PMBaseAction;
import edu.pm.base.PMBaseQuery;
import edu.pm.constants.PMConstants;
import edu.pm.uc.projectlist.bo.GetUserWorkloadBO;
import edu.pm.uc.projectlist.form.WeekWorkload;
import edu.pm.vo.Projects;
import edu.pm.vo.UserRole;

public class WorkloadStaAction extends PMBaseAction {

	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)

	throws Exception {

		// 图像数据准备-------------------------------------------------------
		String projectId = request.getParameter("projectId");
		
		PMBaseQuery userRoleQuery = new PMBaseQuery(UserRole.class);
		
		userRoleQuery.setEQ("projectId",projectId);
		
		userRoleQuery.execute();
		
		Map workMap = new HashMap();
		
		List userRoleList = userRoleQuery.getResults();
		
		for(int i=0;i<userRoleList.size();i++){
			UserRole userRole = (UserRole)userRoleList.get(i);			
			Long userId = userRole.getUserId();		
			GetUserWorkloadBO bo = new GetUserWorkloadBO(new Long(projectId),userId);		
			bo.execute();		
			List weekWorkloadList = bo.getWeekWorkloadList();
			Iterator weekWorkloadIt = weekWorkloadList.iterator();	
			
			while(weekWorkloadIt.hasNext()){
				WeekWorkload weekWorkload = (WeekWorkload) weekWorkloadIt.next();
				WeekWorkload weekWorkloadOld = (WeekWorkload) workMap.get(weekWorkload.getWeekId());
				if(weekWorkloadOld!=null){
					weekWorkloadOld.setWorkloadAssign(weekWorkloadOld.getWorkloadAssign()+weekWorkload.getWorkloadAssign());
					weekWorkloadOld.setWorkloadOver(weekWorkloadOld.getWorkloadOver()+weekWorkload.getWorkloadOver());	
				}
				else{	
					workMap.put(weekWorkload.getWeekId(),weekWorkload);
				}

			}//weekWorkloadIt
	
		}//userRoleList
		
		// 按照开始时间排序
		List resultList = new ArrayList();
		resultList.addAll(workMap.values());
		Collections.sort(resultList);
		
		// 图像数据设置-------------------------------------------------------
		TimeSeriesCollection seriesCollection=new TimeSeriesCollection();
    	//设置一条线的名字
    	TimeSeries seriesPlan=new TimeSeries("计划");
    	TimeSeries seriesFact=new TimeSeries("实际");
    	Iterator weekWorkloadIt = resultList.iterator();	
    	while(weekWorkloadIt.hasNext()){
    		WeekWorkload weekWorkload = (WeekWorkload) weekWorkloadIt.next();
    		Date centerDate = new Date();
    		centerDate.setTime((weekWorkload.getStartDate().getTime()+weekWorkload.getEndDate().getTime())/2);
    		
    		seriesPlan.add(new TimeSeriesDataItem(new Day(centerDate.getDate(),1+centerDate.getMonth(),1900+centerDate.getYear()),weekWorkload.getWorkloadAssign()));
    		seriesFact.add(new TimeSeriesDataItem(new Day(centerDate.getDate(),1+centerDate.getMonth(),1900+centerDate.getYear()),weekWorkload.getWorkloadOver()));
    		
    	}
    	
    	seriesCollection.addSeries(seriesPlan);
    	seriesCollection.addSeries(seriesFact);
    	
    	String title = "工作量统计";	
	    String xAxis = "日期";
	    String yAxis = "工作量（单位：人时）";
	    String filename = ChartUtil.createDateChart(title, xAxis, yAxis, seriesCollection ,request.getSession());
	    
	    request.setAttribute("filename",filename);

		// 标题信息 ----------------------------------------------------------

		Projects project = (Projects) ConstantsContainer.getInstants().getVO(
				PMConstants.Projects, projectId);

		request.setAttribute("project", project);

		return mapping.findForward("success");

	}

}
