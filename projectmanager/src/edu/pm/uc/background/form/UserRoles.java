package edu.pm.uc.background.form;

import java.io.Serializable;

import edu.pm.vo.Users;

/**
 * @author guo
 *
 */
public class UserRoles implements Serializable,Comparable{

	private java.util.Set roleSet;
	
	public Users user = null;
	
	public UserRoles(Users user) {
		this.user = user;
	}
	
	public void addToEoleSet (Object obj) {
		
		if (null == this.roleSet) {
			
			this.roleSet = new java.util.HashSet();
			
		}
		
		this.roleSet.add(obj);
		
	}


	public int compareTo(Object arg0) {

		UserRoles that = (UserRoles) arg0;
		
		return this.user.getUserName().compareTo(user.getUserName());
		
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public java.util.Set getRoleSet() {
		return roleSet;
	}

	public void setRoleSet(java.util.Set roleSet) {
		this.roleSet = roleSet;
	}

}
