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
		
		//��һ�ν����request�л��projectId��Ȼ����ŵ�session�У�֮����루�ӷ�ҳ�룩����session�л��projectId
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
		
		// ��ҳ  -------------------------------------------------
		BaseSearchForm sform = (BaseSearchForm) form;
		sform.initConditionPost();
		userRoleQuery.setPageRange(sform.getPageinfo());
		//      -------------------------------------------------
		
		//ɸѡ����Ŀ�����û�
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
