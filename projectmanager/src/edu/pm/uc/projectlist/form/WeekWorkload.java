
package edu.pm.uc.projectlist.form;

import java.io.Serializable;

/**
 * @author guo
 *
 */
public class WeekWorkload implements Serializable,Comparable{

	public WeekWorkload() {
		super();
		workloadAll=0;
		
		workloadAssign=0;
		
		workloadOver=0;
		
		workDayCount=0;
	}

	private java.util.Date startDate;
	
	private java.util.Date endDate;
	
	private Long weekId;
	
	private Long userId;
	
	private int workloadAll;
	
	private int workloadAssign;
	
	private int workloadOver;
	
	private int workDayCount;

	public java.util.Date getEndDate() {
		return endDate;
	}

	public void setEndDate(java.util.Date endDate) {
		this.endDate = endDate;
	}

	public java.util.Date getStartDate() {
		return startDate;
	}

	public void setStartDate(java.util.Date startDate) {
		this.startDate = startDate;
	}

	public int getWorkDayCount() {
		return workDayCount;
	}

	public void setWorkDayCount(int workDayCount) {
		this.workDayCount = workDayCount;
	}

	public int getWorkloadAll() {
		return workloadAll;
	}

	public void setWorkloadAll(int workloadAll) {
		this.workloadAll = workloadAll;
	}

	public int getWorkloadAssign() {
		return workloadAssign;
	}

	public void setWorkloadAssign(int workloadAssign) {
		this.workloadAssign = workloadAssign;
	}

	public int getWorkloadOver() {
		return workloadOver;
	}

	public void setWorkloadOver(int workloadOver) {
		this.workloadOver = workloadOver;
	}

	public int compareTo(Object arg0) {

		WeekWorkload that = (WeekWorkload) arg0;
		if (this.getStartDate() == null || that.getStartDate() == null) {
			return this.getWorkloadAll()-that.getWorkloadAll();
		} else {
			return this.getStartDate().compareTo(that.getStartDate());
		}

	}
	
	 public boolean equals(Object rhs){
        if (rhs == null)
            return false;
        if (! (rhs instanceof WeekWorkload))
            return false;
        WeekWorkload that = (WeekWorkload) rhs;
        
        if(this.getWeekId()==null||that.getWeekId()==null){
        	return false;
        }
        
        return this.getWeekId().equals(that.getWeekId());
        
    }

	public Long getWeekId() {
		return weekId;
	}

	public void setWeekId(Long weekId) {
		this.weekId = weekId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	

	
}
