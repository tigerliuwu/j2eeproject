package edu.pm.uc.projectlist.action;

import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.dlmu.sei.struts.form.BaseSearchForm;
import edu.dlmu.sei.util.ConstantsContainer;
import edu.pm.base.PMBaseAction;
import edu.pm.base.PMBaseQuery;
import edu.pm.constants.PMConstants;
import edu.pm.vo.Projects;
import edu.pm.vo.UserRole;
import edu.pm.vo.Users;

public class UserListAction extends PMBaseAction {

	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)

	throws Exception {
		
		//第一次进入从request中获得projectId，然后将其放到session中，之后进入（从分页码）将从session中获得projectId
		String projectId = request.getParameter("projectId");
		
		if(projectId==null){
			
			projectId = (String)request.getSession().getAttribute("projectId");
			
		}
		else{
			
			request.getSession().setAttribute("projectId",projectId);
			
		}
		
		HashSet hs = new HashSet();
		
		PMBaseQuery userRoleQuery = new PMBaseQuery(UserRole.class);
		
		userRoleQuery.setLazy(true);
		
		userRoleQuery.setEQ("projectId",projectId);
		
		// 分页  -------------------------------------------------
		BaseSearchForm sform = (BaseSearchForm) form;
		sform.initConditionPost();
		userRoleQuery.setPageRange(sform.getPageinfo());
		//      -------------------------------------------------
		
		//筛选该项目所有用户
		userRoleQuery.execute();
		
		List userRoleList = userRoleQuery.getResults();
		
		for(int i=0;i<userRoleList.size();i++){
			
			UserRole userRole = (UserRole)userRoleList.get(i);
			
			Users user =(Users)ConstantsContainer.getInstants().getVO(PMConstants.Users,userRole.getUserId().toString());
			
			if(user.getIsDeleted()!=null&&user.getIsDeleted().endsWith(PMConstants.DELETED_N)){

				hs.add(user);
				
			}
			
		}
		
		request.setAttribute("result", hs.iterator());
		
		Projects project = (Projects)ConstantsContainer.getInstants().getVO(PMConstants.Projects,projectId);;
		
		request.setAttribute("project", project);
		 
		return mapping.findForward("success");

	}

}
