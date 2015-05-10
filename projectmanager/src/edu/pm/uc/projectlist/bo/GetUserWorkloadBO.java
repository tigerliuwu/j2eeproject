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
		
// �����б� ----------------------------------------------------------

		PMBaseQuery targetQuery = new PMBaseQuery(Targets.class);

		targetQuery.setEQ("projectId", projectId);

		targetQuery.setEQ("userSEId", userId);

		targetQuery.execute();

		List targetList = targetQuery.getResults();

// ���������� --------------------------------------------------------

		// ���������й�����

		PMBaseQuery weekQuery = new PMBaseQuery(Weeks.class);

		weekQuery.setEQ("projectId", projectId);

		weekQuery.execute();

		List weekList = weekQuery.getResults();

		Iterator weekIt = null;

		// ����ÿһ�������ҳ����Ӧ�Ĺ����ܣ�������WeekWorkload �������ڸ��ܵ��ѷ��乤����������ɹ��������ý�ȥ
		// �����㷨��
				//��������Ŀ�ʼʱ��ͽ���ʱ�䣬ɸѡ��صĹ����ܣ�����WeekWorkload�����ԭ�����ڸ�WeekWorkload����û�д��������򴴽�������ȡ����WeekWorkload��workMap�ռ���
				//�ڸ�WeekWorkload�����ϼ�¼���ܹ���������ͬʱ�ۼ������ܹ�����������hs�ռ�WeekWorkload��workMap�е�����
				//����������ڸ��ܵ�����ɹ��������������ڸ��ܵ��ܱ�����ʵ����ɹ���������Ȼ���䱣�浽WeekWorkload������
		        //�����������ܺ���������ÿ�칤����������ƻ�������/�����ܹ���������
				//����hs�е�WeekWorkload��workMap�е�������һһ�������WeekWorkload�ĸ�����Ĺ�������ԭ�й�����+������ÿ�칤����*���ܹ���������
		
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
					// �����ܱ����� ����ɹ�����*****************************************
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
			// ����ÿ����ع����ܵ� �ѷ��乤����
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
		
		// ���տ�ʼʱ������
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