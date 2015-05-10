/*
 * Created on 2006-9-15
 *
 * Organization: BearingPoint Inc.
 */
package edu.pm.uc.background.action;



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
import edu.pm.uc.background.form.UserRoles;
import edu.pm.vo.Projects;
import edu.pm.vo.UserRole;
import edu.pm.vo.Users;


public class BackModifyTeamUserPreAction extends PMBaseAction {



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
			
			
			// user roles --------------------------------------------------------------------
			String userId =request.getParameter("userId");
			
			PMBaseQuery userRoleQuery = new PMBaseQuery(UserRole.class);
			
			userRoleQuery.setEQ("projectId",new Long(projectId));
			
			userRoleQuery.setEQ("userId",new Long(userId));
			
			userRoleQuery.execute();
			
			List userRoleList = userRoleQuery.getResults();
			
			UserRoles userRoles = null;
			
			Users user = null;
			
			for(int i=0;i<userRoleList.size();i++){
				
				UserRole userRole = (UserRole)userRoleList.get(i);
				
				if(userRoles==null){
					user = userRole.getUser();
					userRoles = new UserRoles(user);
				}
				
				userRoles.addToEoleSet(userRole.getRoleId());
				
			}
			
			request.setAttribute("userRoles", userRoles);
			
			
			return mapping.findForward("success");

	}



}

