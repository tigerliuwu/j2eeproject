/*
 * Created on 2006-9-15
 *
 * Organization: BearingPoint Inc.
 */
package edu.pm.uc.teamset.action;



import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.dlmu.sei.util.ConstantsContainer;
import edu.pm.base.PMBaseAction;
import edu.pm.base.PMBaseQuery;
import edu.pm.constants.PMConstants;
import edu.pm.uc.teamset.bo.UserRoleCreateBO;
import edu.pm.uc.teamset.bo.UserRoleDeleteBO;
import edu.pm.uc.teamset.form.TeamForm;
import edu.pm.vo.Projects;
import edu.pm.vo.UserRole;
import edu.pm.vo.Users;


public class TeamModifyAction extends PMBaseAction {



	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response)

			throws Exception {

			//needTokenValid(request); 
		
			TeamForm aform = (TeamForm) form;
			
			String userList = aform.getUserList();
			
			String token="";
			
			StringTokenizer st=new StringTokenizer(userList,"/");
			
			// 删除原用户
			String projectId =(String) request.getSession().getAttribute("projectId");
			
			Projects project = (Projects)ConstantsContainer.getInstants().getVO(PMConstants.Projects,projectId);
				
			Map teamMap = project.getUserList();
			
			teamMap.remove(project.getPmId());
			
			Iterator oldUserIt = teamMap.values().iterator();
			
			while(oldUserIt.hasNext()){
				Users user =(Users)oldUserIt.next();
				PMBaseQuery userRoleQuery = new PMBaseQuery(UserRole.class);
				userRoleQuery.setEQ("projectId",new Long(projectId));
				userRoleQuery.setEQ("userId",user.getId());
				userRoleQuery.setEQ("roleId",PMConstants.ROLE_SE);
				userRoleQuery.execute();
				
				List userRoleList = userRoleQuery.getResults();
				for(int i=0;i<userRoleList.size();i++){
					UserRole userRole =(UserRole)userRoleList.get(i);
					UserRoleDeleteBO deleteBO =new UserRoleDeleteBO(userRole.getId());
					deleteBO.execute();
				}
				
			}
			
			// 添加新用户
		    while(st.hasMoreTokens()){
		        token = st.nextToken();
		        Long userId = new Long(token);
		        UserRole userRole = new UserRole();
		        userRole.setProjectId(new Long(projectId));
		        userRole.setUserId(userId);
		        userRole.setIsWorking(PMConstants.WORKING_Y);
		        userRole.setRoleId(PMConstants.ROLE_SE);
		        UserRoleCreateBO createBO =new UserRoleCreateBO(userRole);
		        createBO.execute();
		    }
			
			
			return mapping.findForward("success");

	}



}

