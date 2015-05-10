
package edu.pm.uc.menu.form;

import java.io.Serializable;
import java.util.ArrayList;

import edu.pm.vo.Permissions;

/**
 * @author guo
 *
 */
public class BigMenu implements Serializable,Comparable{

	private java.util.List menuList;
	
	public Permissions permission = null;
	
	public BigMenu(Permissions permission) {
		this.permission = permission;
	}
	
	public void addToMenuList (Object obj) {
		
		if (null == this.menuList) {
			
			this.menuList = new ArrayList();
			
		}
		
		this.menuList.add(obj);
		
	}


	public int compareTo(Object arg0) {

		BigMenu that = (BigMenu) arg0;
		
		return this.permission.getPermissionOrder().compareTo(that.permission.getPermissionOrder());
		
	}

	public java.util.List getMenuSet() {
		return this.menuList;
	}

	public void setMenuList(java.util.List menuList) {
		this.menuList = menuList;
	}

	public Permissions getPermission() {
		return permission;
	}

	public void setPermission(Permissions permission) {
		this.permission = permission;
	}



}
