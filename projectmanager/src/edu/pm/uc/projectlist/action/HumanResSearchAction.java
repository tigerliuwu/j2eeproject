package edu.pm.uc.projectlist.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.dlmu.sei.util.ConstantsContainer;
import edu.dlmu.sei.util.CoreUtils;
import edu.pm.base.PMBaseAction;
import edu.pm.base.PMBaseQuery;
import edu.pm.constants.PMConstants;
import edu.pm.uc.projectlist.bo.GetUserWorkloadBO;
import edu.pm.uc.projectlist.form.HumanResSearchForm;
import edu.pm.uc.projectlist.form.UserWeekWorkloads;
import edu.pm.uc.projectlist.form.WeekWorkload;
import edu.pm.vo.Projects;
import edu.pm.vo.UserRole;
import edu.pm.vo.Users;

public class HumanResSearchAction extends PMBaseAction {

	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)

	throws Exception {

		String projectId = (String)request.getSession().getAttribute("projectId");
		
		HumanResSearchForm aForm = (HumanResSearchForm)form;
		
		Date startDate00 = CoreUtils.parseDate(aForm.getStartDate());
		
		Date endDate00 = CoreUtils.parseDate(aForm.getEndDate());
		
		if(startDate00==null){
			startDate00= new Date(1,1,1);
		}
		if(endDate00==null){
			endDate00= new Date(2000,1,1);
		}
		
		//System.out.println("startDate00:"+startDate00+"   endDate00:"+endDate00);
		
		PMBaseQuery userRoleQuery = new PMBaseQuery(UserRole.class);
		
		userRoleQuery.setEQ("projectId",projectId);
		
		userRoleQuery.execute();
		
		HashSet hs = new HashSet();
		
		List userRoleList = userRoleQuery.getResults();
		
		//System.out.println("userRoleList size:"+userRoleList.size());
		
		for(int i=0;i<userRoleList.size();i++){
			UserRole userRole = (UserRole)userRoleList.get(i);			
			Long userId = userRole.getUserId();		
			GetUserWorkloadBO bo = new GetUserWorkloadBO(new Long(projectId),userId);		
			bo.execute();		
			List weekWorkloadList = bo.getWeekWorkloadList();
		
			
			
			Iterator weekWorkloadIt = weekWorkloadList.iterator();		
			UserWeekWorkloads userWeekWorkloads = null;
			
			while(weekWorkloadIt.hasNext()){
				WeekWorkload weekWorkload = (WeekWorkload) weekWorkloadIt.next();
				Date startDate = weekWorkload.getStartDate();
				Date endDate = weekWorkload.getEndDate();
				
				if ((startDate.getTime() >= startDate00.getTime() && startDate.getTime() <= endDate00.getTime())
						|| (endDate.getTime() >= startDate00.getTime() && endDate.getTime() <= endDate00.getTime())) {
			
					
					// 是否有空余工作量
					if(weekWorkload.getWorkloadAssign()<weekWorkload.getWorkloadAll()){
						if(userWeekWorkloads==null){
							Users currentUser = (Users)ConstantsContainer.getInstants().getVO(PMConstants.Users,userId.toString());
							userWeekWorkloads = new UserWeekWorkloads(currentUser);
						}
						userWeekWorkloads.addToWeekWorkloadSet(weekWorkload);
			
					}
					
				}// if

			}//weekWorkloadIt
			
			if(userWeekWorkloads!=null){
				hs.add(userWeekWorkloads);
			}
			
		}//userRoleList
		
		// 按照开始时间排序
		List resultList = new ArrayList();
		resultList.addAll(hs);
		Collections.sort(resultList);
		
		request.setAttribute("result", resultList);

		// 标题信息 ----------------------------------------------------------

		Projects project = (Projects) ConstantsContainer.getInstants().getVO(
				PMConstants.Projects, projectId);

		request.setAttribute("project", project);

		return mapping.findForward("success");

	}

}
