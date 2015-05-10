/*
 * Created on 2006-9-15
 *
 * Organization: BearingPoint Inc.
 */
package edu.pm.uc.background.action;



import java.util.ArrayList;
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
import edu.pm.vo.Permissions;
import edu.pm.vo.RolePermission;
import edu.pm.vo.Roles;
import edu.pm.vo.Users;


public class BackModifyRolePreAction extends PMBaseAction {



	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response)

			throws Exception {

			//needTokenValid(request); 
			String isReEntry=request.getParameter("reEntry");
			if(isReEntry!=null){
				return mapping.findForward("success");
			}


			String roleId =request.getParameter("id");
		
			Roles role = (Roles)ConstantsContainer.getInstants().getVO(PMConstants.Roles,roleId);
			
			request.setAttribute("role", role);
			
			
			// 检索出当前用户有的所有权限ID 并存放到 myPermissionIds 中 ------------------------------------------------
			
			PMBaseQuery rolePermissionQuery = new PMBaseQuery(RolePermission.class);
			
			rolePermissionQuery.setEQ("roleId",new Long(roleId));
			
			rolePermissionQuery.execute();
			
			List myPermissionList = rolePermissionQuery.getResults();
			
			List myPermissionIds = new ArrayList();
			
			RolePermission rolePermission = null;
			
			Users user = null;
			
			for(int i=0;i<myPermissionList.size();i++){
				
				rolePermission = (RolePermission)myPermissionList.get(i);
				
				myPermissionIds.add(rolePermission.getPermissionId());
				
			}
			// 检索出所有权限 并设置当前用户是否有该权限的标志 -----------------------------------------------
			PMBaseQuery permissionQuery = new PMBaseQuery(Permissions.class);
			
			permissionQuery.setOrderBy("permissionOrder","asc");
			
			permissionQuery.execute();
			
			List permissionList = permissionQuery.getResults();
			
			Permissions permission = null;
			
			for(int i=0;i<permissionList.size();i++){
				
				permission = (Permissions)permissionList.get(i);
				
				if(myPermissionIds.contains(permission.getId())){
					permission.setChecked("true");
				}
				else{
					permission.setChecked("false");
				}
				
			}
			
			
			request.setAttribute("result", permissionList);
			
			for(int i=0;i<permissionList.size();i++){
				
				permission = (Permissions)permissionList.get(i);
				
			}
			
			return mapping.findForward("success");

	}



}

