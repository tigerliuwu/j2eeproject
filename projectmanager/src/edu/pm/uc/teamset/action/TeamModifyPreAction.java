/*
 * Created on 2006-9-15
 *
 * Organization: BearingPoint Inc.
 */
package edu.pm.uc.teamset.action;



import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.dlmu.sei.util.ConstantsContainer;
import edu.pm.base.PMBaseAction;
import edu.pm.constants.PMConstants;
import edu.pm.vo.Projects;
import edu.pm.vo.Users;


public class TeamModifyPreAction extends PMBaseAction {



	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response)

			throws Exception {

			//needTokenValid(request); 
			String isReEntry=request.getParameter("reEntry");
			if(isReEntry!=null){
				return mapping.findForward("success");
			}
			
			// project infor ----------------------------------------------------------------------
			String projectId =(String) request.getSession().getAttribute("projectId");
		
			Projects project = (Projects)ConstantsContainer.getInstants().getVO(PMConstants.Projects,projectId);
			
			request.setAttribute("project", project);
			
			
			
			// not team users --------------------------------------------------------------------
			Map teamMap = project.getUserList();
			
			Collection userList = ConstantsContainer.getInstants().getCollection(PMConstants.Users);
			
			HashMap notTeamMap = new HashMap();
			
			Iterator userIt = userList.iterator();
			
			while(userIt.hasNext()){
				
				Users user = (Users)userIt.next();

				if(!teamMap.containsKey(user.getId())){
					notTeamMap.put(user.getId(),user);
				}
				
			}
			// 按照 用户名 排序
			List notTeamList = new ArrayList();
			
			notTeamList.addAll(notTeamMap.values());
			
			Collections.sort(notTeamList);
			
			request.setAttribute("notTeam", notTeamList);
			
			// team users -----------------------------------------------------------------------
			// 去除项目经理并排序
			if(teamMap.containsKey(project.getPmId())){
				teamMap.remove(project.getPmId());
			}
			List teamList = new ArrayList();
			
			teamList.addAll(teamMap.values());
			
			Collections.sort(teamList);
			
			request.setAttribute("team", teamList);
			
			
			return mapping.findForward("success");

	}



}

