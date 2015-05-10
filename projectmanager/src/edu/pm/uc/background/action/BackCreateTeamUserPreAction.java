/*
 * Created on 2006-9-15
 *
 * Organization: BearingPoint Inc.
 */
package edu.pm.uc.background.action;



import java.util.HashMap;
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
import edu.pm.vo.UserRole;
import edu.pm.vo.Users;


public class BackCreateTeamUserPreAction extends PMBaseAction {



	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response)

			throws Exception {

			//needTokenValid(request); 
			String isReEntry=request.getParameter("reEntry");
			if(isReEntry!=null){
				return mapping.findForward("success");
			}
			
			// project infor ----------------------------------------------------------------------
			String projectId =request.getParameter("projectId");
		
			Projects project = (Projects)ConstantsContainer.getInstants().getVO(PMConstants.Projects,projectId);
			
			request.setAttribute("project", project);
			
			
			// not team users --------------------------------------------------------------------
			// 首先检索出 team users
			HashMap notTeamUserMap = new HashMap();
			HashMap teamUserMap = new HashMap();
			
			PMBaseQuery userRoleQuery = new PMBaseQuery(UserRole.class);
			
			userRoleQuery.setLazy(true);
			
			userRoleQuery.setEQ("projectId",new Long(projectId));
			
			userRoleQuery.execute();
			
			List userRoleList = userRoleQuery.getResults();
			
			for(int i=0;i<userRoleList.size();i++){
				
				UserRole userRole = (UserRole)userRoleList.get(i);
				Users user = (Users)ConstantsContainer.getInstants().getVO(PMConstants.Users,userRole.getUserId().toString());
				if(!teamUserMap.containsKey(userRole.getUserId())){
					teamUserMap.put(userRole.getUserId(),user);
				}
				
			}
			// 检索出 所有 users ， 然后从中剔除 team users
			Iterator usersIt=ConstantsContainer.getInstants().getCollection(PMConstants.Users).iterator();
			
			while(usersIt.hasNext()){
				Users user = (Users) usersIt.next();
				if(!teamUserMap.containsKey(user.getId())){
					notTeamUserMap.put(user.getId(),user);
				}
			}
			
			request.setAttribute("notTeam", notTeamUserMap.values());
			
			
			return mapping.findForward("success");

	}



}

