package edu.pm.uc.projectlist.action;

import java.util.HashSet;
import java.util.Iterator;
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
import edu.pm.vo.Targets;
import edu.pm.vo.UserRole;

public class ProjectListAction extends PMBaseAction {

	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)

	throws Exception {
		
		HashSet hs = new HashSet();
		
		PMBaseQuery userRoleQuery = new PMBaseQuery(UserRole.class);
		
		userRoleQuery.setLazy(true);
		
		Long userId = getUser().getId();
		
		userRoleQuery.setEQ("userId",userId);
		
		// 分页  -------------------------------------------------
		BaseSearchForm sform = (BaseSearchForm) form;
		sform.initConditionPost();
		userRoleQuery.setPageRange(sform.getPageinfo());
		//      -------------------------------------------------
		
		//筛选该用户参与的所有项目
		userRoleQuery.execute();
		
		List userRoleList = userRoleQuery.getResults();
		
		for(int i=0;i<userRoleList.size();i++){
			
			UserRole userRole = (UserRole)userRoleList.get(i);
			
			Projects project = (Projects)ConstantsContainer.getInstants().getVO(PMConstants.Projects,userRole.getProjectId().toString());
			
			hs.add(project);
			
		}
		
		Iterator it=hs.iterator();
		//计算每个项目中该用户的任务数量
		PMBaseQuery targetQuery = new PMBaseQuery(Targets.class);
		while(it.hasNext()){
			Projects project = (Projects)it.next();
			targetQuery.setEQ("projectId",project.getId());
			targetQuery.setEQ("userSEId",userId);
			targetQuery.execute();
			int targetCount = targetQuery.getResults().size();
			project.setTargetCount(targetCount);
		}
		
		
		request.setAttribute("result", hs.iterator());
		 
		return mapping.findForward("success");

	}

}
