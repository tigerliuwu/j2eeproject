package edu.pm.uc.projectlist.bo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import edu.pm.base.PMBaseBusinessObject;
import edu.pm.base.PMBaseQuery;
import edu.pm.uc.projectlist.form.WeekWorkload;
import edu.pm.vo.Targets;
import edu.pm.vo.WeekReports;
import edu.pm.vo.Weeks;


public class GetUserWorkloadBO extends PMBaseBusinessObject {

	Long projectId;
	
	Long userId;
	
	List weekWorkloadList = new ArrayList();

	public GetUserWorkloadBO(Long projectId,Long userId) {

		this.projectId = projectId;
		
		this.userId = userId;
		
	}

	protected void performBusinessLogic() {
		try{
		
// 任务列表 ----------------------------------------------------------

		PMBaseQuery targetQuery = new PMBaseQuery(Targets.class);

		targetQuery.setEQ("projectId", projectId);

		targetQuery.setEQ("userSEId", userId);

		targetQuery.execute();

		List targetList = targetQuery.getResults();

// 工作量汇总 --------------------------------------------------------

		// 检索出所有工作周

		PMBaseQuery weekQuery = new PMBaseQuery(Weeks.class);

		weekQuery.setEQ("projectId", projectId);

		weekQuery.execute();

		List weekList = weekQuery.getResults();

		Iterator weekIt = null;

		// 遍历每一个任务找出其对应的工作周，并创建WeekWorkload ，将其在该周的已分配工作量，已完成工作量设置进去
		// 具体算法：
				//根据任务的开始时间和结束时间，筛选相关的工作周，创建WeekWorkload（如果原来对于该WeekWorkload对象没有创建过，则创建，否则取出，WeekWorkload用workMap收集）
				//在该WeekWorkload对象上记录该周工作天数，同时累加任务总工作天数，用hs收集WeekWorkload在workMap中的索引
				//计算该任务在该周的已完成工作量（该任务在该周的周报上有实际完成工作量），然后将其保存到WeekWorkload对象中
		        //遍历完所有周后计算该任务每天工作量（任务计划工作量/任务总工作天数）
				//根据hs中的WeekWorkload在workMap中的索引，一一回填相关WeekWorkload的该任务的工作量（原有工作量+该任务每天工作量*该周工作天数）
		
		Map workMap = new HashMap();

		Iterator targetIt = targetList.iterator();

		while (targetIt.hasNext()) {
			
			Targets target = (Targets) targetIt.next();
			Date startDate00 = target.getStartDatePlan();
			Date endDate00 = target.getEndDatePlan();			
			int workdayCount = 0;
			
			HashSet hs = new HashSet();
			weekIt = weekList.iterator();
			
			while (weekIt.hasNext()) {
				
				int workdayThisWeek = 0;
				Weeks week = (Weeks) weekIt.next();
				Date startDate = week.getStartDate();
				Date endDate = week.getEndDate();

				if ((startDate.getTime() >= startDate00.getTime() && startDate.getTime() <= endDate00.getTime())
						|| (endDate.getTime() >= startDate00.getTime() && endDate.getTime() <= endDate00.getTime())) {
					if(startDate.getTime() >= startDate00.getTime() && endDate.getTime()<= endDate00.getTime()){
						workdayThisWeek = (int)( 1 +(endDate.getTime() - startDate.getTime()) / ((long)60*60*24*1000));	
					}
					else{
						if(startDate.getTime() >= startDate00.getTime() && startDate.getTime() <= endDate00.getTime()){	
							workdayThisWeek = 1 + (int)((endDate00.getTime() - startDate.getTime()) / ((long)60*60*24*1000));	
						}
						else{	
							workdayThisWeek =  1 + (int)((endDate.getTime() - startDate00.getTime()) / ((long)60*60*24*1000));							
						}						
					}
					
					workdayCount += workdayThisWeek;				
					hs.add(week.getId());					
					WeekWorkload weekWorkload = (WeekWorkload) workMap.get(week.getId());
					if(weekWorkload!=null){
						weekWorkload.setWorkDayCount(workdayThisWeek);
					}
					else{
						weekWorkload = new WeekWorkload();	
						weekWorkload.setUserId(userId);
						weekWorkload.setWeekId(week.getId());
						weekWorkload.setStartDate(week.getStartDate());
						weekWorkload.setEndDate(week.getEndDate());
						weekWorkload.setWorkloadAll(week.getWorkloadAll());
						weekWorkload.setWorkDayCount(workdayThisWeek);
						workMap.put(week.getId(),weekWorkload);
					}
					// 根据周报设置 已完成工作量*****************************************
					PMBaseQuery weekReportQuery = new PMBaseQuery(WeekReports.class);
					weekReportQuery.setEQ("targetId",target.getId());
					weekReportQuery.setEQ("weekId",week.getId());
					weekReportQuery.execute();
					List weekReportList = weekReportQuery.getResults();
					if(weekReportList.size()>0){
						WeekReports weekReport = (WeekReports)weekReportList.get(0);
						if(weekReport.getWorkloadThisweek()!=null){
							weekWorkload.setWorkloadOver(weekWorkload.getWorkloadOver()+weekReport.getWorkloadThisweek().intValue());
						}
					}
					
				}// if

			}// while weekIt
			
			double workloadPerDay =(double)(target.getWorkloadPlan().intValue())/(double)workdayCount;
			// 回填每个相关工作周的 已分配工作量
			Iterator useWeekIt=hs.iterator();
			while(useWeekIt.hasNext()){
				Long weekId = (Long)useWeekIt.next();
				WeekWorkload weekWorkload = (WeekWorkload) workMap.get(weekId);
				int workdayThisWeek = weekWorkload.getWorkDayCount();
				double workloadAssignDouble = (double)workloadPerDay*workdayThisWeek;
				int workloadAssignInt =(int)workloadAssignDouble;
				if(workloadAssignDouble>(double)workloadAssignInt){
					workloadAssignInt++;
				}
				weekWorkload.setWorkloadAssign(weekWorkload.getWorkloadAssign()+workloadAssignInt);  
			}
			

		}// while targetIt
		
		// 按照开始时间排序
		this.weekWorkloadList.addAll(workMap.values());
		Collections.sort(weekWorkloadList);
		

		
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}

	public List getWeekWorkloadList() {
		return weekWorkloadList;
	}

	public void setWeekWorkloadList(List weekWorkloadList) {
		this.weekWorkloadList = weekWorkloadList;
	}

}//class