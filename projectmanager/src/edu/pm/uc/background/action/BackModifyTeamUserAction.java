/*
 * Created on 2006-9-15
 *
 * Organization: BearingPoint Inc.
 */
package edu.pm.uc.background.action;



import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.pm.base.PMBaseAction;
import edu.pm.base.PMBaseQuery;
import edu.pm.constants.PMConstants;
import edu.pm.uc.background.form.UserRoles;
import edu.pm.uc.teamset.bo.UserRoleCreateBO;
import edu.pm.uc.teamset.bo.UserRoleDeleteBO;
import edu.pm.vo.UserRole;
import edu.pm.vo.Users;


public class BackModifyTeamUserAction extends PMBaseAction {



	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response)

			throws Exception {

			//needTokenValid(request); 
			
			String projectId =request.getParameter("projectId");
			
			// 删除原有 roles --------------------------------------------------------------------
			String userId =request.getParameter("userId");
			
			PMBaseQuery userRoleQuery = new PMBaseQuery(UserRole.class);
			
			userRoleQuery.setEQ("projectId",new Long(projectId));
			
			userRoleQuery.setEQ("userId",new Long(userId));
			
			userRoleQuery.setNOEQ("roleId",PMConstants.ROLE_PM);
			
			userRoleQuery.execute();
			
			List userRoleList = userRoleQuery.getResults();
			
			UserRoles userRoles = null;
			
			Users user = null;
			
			for(int i=0;i<userRoleList.size();i++){
				
				UserRole userRole = (UserRole)userRoleList.get(i);
				
				UserRoleDeleteBO deleteBO = new UserRoleDeleteBO(userRole.getId());
				
				deleteBO.execute();
				
			}
			
			// 添加选中的 roles --------------------------------------------------------------------
			Enumeration checkboxes = request.getParameterNames();
						
			while (checkboxes.hasMoreElements()) {
			
				String checkboxname = (String) checkboxes.nextElement();	
				
				if(checkboxname.indexOf("checkbox_")!=-1){
					
					String roleId=checkboxname.substring(9);
			        UserRole userRole = new UserRole();
			        userRole.setProjectId(new Long(projectId));
			        userRole.setUserId(new Long(userId));
			        userRole.setIsWorking(PMConstants.WORKING_Y);
			        userRole.setRoleId(new Long(roleId));
			        UserRoleCreateBO createBO =new UserRoleCreateBO(userRole);
			        createBO.execute();
					
				}
			}//while
			
			request.setAttribute("id", projectId);
			
			return mapping.findForward("success");

	}



}

