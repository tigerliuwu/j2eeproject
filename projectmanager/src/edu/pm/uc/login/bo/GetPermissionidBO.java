package edu.pm.uc.login.bo;

import java.util.HashSet;
import java.util.List;

import edu.pm.base.PMBaseBusinessObject;
import edu.pm.base.PMBaseQuery;
import edu.pm.vo.RolePermission;
import edu.pm.vo.UserRole;
import edu.pm.vo.Users;


public class GetPermissionidBO extends PMBaseBusinessObject {

	Users user;
	
	HashSet hs=new HashSet();

	public GetPermissionidBO(Users user) {

		this.user = user;
		
	}

	protected void performBusinessLogic() {

		String userId = user.getId().toString();
		
		PMBaseQuery userRoleQuery = new PMBaseQuery(UserRole.class);
		
		userRoleQuery.setLazy(true);
		
		userRoleQuery.setEQ("userId",userId);
		
		userRoleQuery.execute();
		
		List userRoleList = userRoleQuery.getResults();
		
		for(int i=0;i<userRoleList.size();i++){
			
			UserRole userRole = (UserRole)userRoleList.get(i);
			
			PMBaseQuery rolePermissionQuery = new PMBaseQuery(RolePermission.class);
			
			rolePermissionQuery.setLazy(true);
			
			rolePermissionQuery.setEQ("roleId",userRole.getRoleId());
			
			rolePermissionQuery.execute();
			
			List rolePermissionList = rolePermissionQuery.getResults();
			
			for(int j=0;j<rolePermissionList.size();j++){
				
				RolePermission rolePermission = (RolePermission)rolePermissionList.get(j);
				
				hs.add(rolePermission.getPermissionId()+"_"+userRole.getProjectId().toString());
				
			}
			
		}
		

	}

	public HashSet getHs() {
		return hs;
	}

	public void setHs(HashSet hs) {
		this.hs = hs;
	}
}