
package edu.pm.uc.gantt.form;

import java.io.Serializable;
import java.util.ArrayList;

import edu.pm.vo.Permissions;
import edu.pm.vo.Targets;

/**
 * @author guo
 *
 */
public class BigTarget implements Serializable,Comparable{

	private java.util.List childList;
	
	public Targets target = null;
	
	public BigTarget(Targets target) {
		this.target = target;
	}
	
	public void addToChildList (Object obj) {
		
		if (null == this.childList) {
			
			this.childList = new ArrayList();
			
		}
		
		this.childList.add(obj);
		
	}


	public int compareTo(Object arg0) {

		BigTarget that = (BigTarget) arg0;
		
		return this.target.getTargetOrder().compareTo(that.target.getTargetOrder());
		
	}

	public java.util.List getChildSet() {
		return this.childList;
	}

	public java.util.List getChildList() {
		return childList;
	}

	public void setChildList(java.util.List childList) {
		this.childList = childList;
	}

	public Targets getTarget() {
		return target;
	}

	public void setTarget(Targets target) {
		this.target = target;
	}



}
