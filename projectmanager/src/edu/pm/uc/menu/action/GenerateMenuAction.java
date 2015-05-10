package edu.pm.uc.menu.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.pm.base.PMBaseAction;
import edu.pm.base.PMBaseQuery;
import edu.pm.uc.menu.form.BigMenu;
import edu.pm.vo.Permissions;

public class GenerateMenuAction extends PMBaseAction {

	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)

	throws Exception {

		String projectId = (String)request.getSession().getAttribute("projectId");
		
		Set permissionIdSet = (Set)request.getSession().getAttribute("permissionid");
		
		PMBaseQuery permissionQuery = new PMBaseQuery(Permissions.class);
		
		permissionQuery.setOrderBy("permissionOrder","asc");
		
		permissionQuery.execute();
		
		HashMap bigMenuMap = new HashMap();
		
		List permissionList = permissionQuery.getResults();
		
		for(int i=0;i<permissionList.size();i++){
			
			Permissions permission = (Permissions)permissionList.get(i);
			
			String  permissionId = permission.getId()+"_"+projectId;		
			
			if (permissionIdSet.contains(permissionId) && permission.getPermissionLevel()!=null) {
				
				switch(permission.getPermissionLevel().intValue()){
					case  1 :{
						BigMenu bigMenu = new BigMenu(permission);
						bigMenuMap.put(permission.getId(),bigMenu);
						break;
					}
					case  2 :{
						BigMenu bigMenu = (BigMenu)bigMenuMap.get(permission.getParentId());
						bigMenu.addToMenuList(permission);
						break;
					}
				}
				
			} // if 是本用户的权限
			
		}//for
			
			
		// bigmenu排序
		List resultList = new ArrayList();
		resultList.addAll(bigMenuMap.values());
		Collections.sort(resultList);
		
		request.setAttribute("result", resultList);
		
		return mapping.findForward("success");
		
	}

}
