/*
 * Created on 2006-9-15
 *
 * Organization: BearingPoint Inc.
 */
package edu.pm.uc.background.action;



import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.pm.base.PMBaseAction;
import edu.pm.base.PMBaseQuery;
import edu.pm.uc.background.bo.RolePermissionCreateBO;
import edu.pm.uc.background.bo.RolePermissionDeleteBO;
import edu.pm.vo.RolePermission;
import edu.pm.vo.Users;


public class BackModifyRoleAction extends PMBaseAction {



	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response)

			throws Exception {

			//needTokenValid(request); 
			
			// 删除原有 permissions --------------------------------------------------------------------
			String roleId =request.getParameter("roleId");
			
			PMBaseQuery rolePermissionQuery = new PMBaseQuery(RolePermission.class);
			
			rolePermissionQuery.setEQ("roleId",new Long(roleId));
			
			rolePermissionQuery.execute();
			
			List myPermissionList = rolePermissionQuery.getResults();
			
			RolePermission rolePermission = null;
			
			Users user = null;
			
			for(int i=0;i<myPermissionList.size();i++){
				
				rolePermission = (RolePermission)myPermissionList.get(i);
				
				RolePermissionDeleteBO createBO =new RolePermissionDeleteBO(rolePermission.getId());
				
			    createBO.execute();
				
			}
			
			// 添加选中的 permissions --------------------------------------------------------------------
			String permissionList=request.getParameter("permissionList");
			String token="";
			StringTokenizer st=new StringTokenizer(permissionList,"/");
			
			 while(st.hasMoreTokens()){
		        token = st.nextToken();
		        Long userId = new Long(token);
		        RolePermission avo = new RolePermission();
		        avo.setRoleId(new Long(roleId));
		        avo.setPermissionId(new Long(token));
		        RolePermissionCreateBO createBO =new RolePermissionCreateBO(avo);
		        createBO.execute();
		    }
					
			
			return mapping.findForward("success");

	}



}

