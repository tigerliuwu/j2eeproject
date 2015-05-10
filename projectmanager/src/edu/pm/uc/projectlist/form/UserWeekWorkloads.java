
package edu.pm.uc.projectlist.form;

import java.io.Serializable;

import edu.pm.vo.Users;

/**
 * @author guo
 *
 */
public class UserWeekWorkloads implements Serializable,Comparable{

	private java.util.Set weekWorkloadSet;
	
	public Users user = null;
	
	public UserWeekWorkloads(Users user) {
		this.user = user;
	}
	
	public void addToWeekWorkloadSet (Object obj) {
		
		if (null == this.weekWorkloadSet) {
			
			this.weekWorkloadSet = new java.util.HashSet();
			
		}
		
		this.weekWorkloadSet.add(obj);
		
	}


	public int compareTo(Object arg0) {

		UserWeekWorkloads that = (UserWeekWorkloads) arg0;
		
		return this.weekWorkloadSet.size()-that.weekWorkloadSet.size();
		
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public java.util.Set getWeekWorkloadSet() {
		return weekWorkloadSet;
	}

	public void setWeekWorkloadSet(java.util.Set weekWorkloadSet) {
		this.weekWorkloadSet = weekWorkloadSet;
	}

}
