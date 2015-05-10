/*
 * Created on 2006-9-15
 *
 * Organization: BearingPoint Inc.
 */
package edu.pm.uc.targetsearch.form;

import edu.dlmu.sei.struts.form.SearchCondition;


public class TargetCondition extends SearchCondition {

		private String userSEId;

	    /** The value of the users1 association. */
	    private String userPLId;

	    /** The value of the targets association. */
	    private String parentId;

	    /** The value of the simple isParent property. */
	    private java.lang.String isParent;

	    /** The value of the simple targetName property. */
	    private java.lang.String targetName;

	    /** The value of the simple remark property. */
	    private java.lang.String remark;

	    /** The value of the simple isMilestone property. */
	    private java.lang.String isMilestone;

	    /** The value of the simple startDatePlan property. */
	    private String startDatePlanFrom;

	    /** The value of the simple endDatePlan property. */
	    private String endDatePlanFrom;

	    /** The value of the simple startDateFact property. */
	    private String startDatePlanTo;

	    /** The value of the simple endDateFact property. */
	    private String endDatePlanTo;

	    /** The value of the simple workloadFact property. */
	    private String workloadFact;

	    /** The value of the simple workloadPlan property. */
	    private String workloadPlan;

	    /** The value of the simple displayColor property. */
	    private java.lang.String displayColor;

	    /** The value of the simple status property. */
	    private java.lang.String status;

	    /** The value of the simple excuteStatus property. */
	    private java.lang.String excuteStatus;

	    /** The value of the simple isDeleted property. */
	    private java.lang.String isDeleted;
	    
	    private String targetLevel;
	    
	    private java.lang.String targetOrder;

		public java.lang.String getDisplayColor() {
			return displayColor;
		}

		public void setDisplayColor(java.lang.String displayColor) {
			this.displayColor = displayColor;
		}

		public java.lang.String getExcuteStatus() {
			return excuteStatus;
		}

		public void setExcuteStatus(java.lang.String excuteStatus) {
			this.excuteStatus = excuteStatus;
		}

		public java.lang.String getIsDeleted() {
			return isDeleted;
		}

		public void setIsDeleted(java.lang.String isDeleted) {
			this.isDeleted = isDeleted;
		}

		public java.lang.String getIsMilestone() {
			return isMilestone;
		}

		public void setIsMilestone(java.lang.String isMilestone) {
			this.isMilestone = isMilestone;
		}

		public java.lang.String getIsParent() {
			return isParent;
		}

		public void setIsParent(java.lang.String isParent) {
			this.isParent = isParent;
		}

		public String getParentId() {
			return parentId;
		}

		public void setParentId(String parentId) {
			this.parentId = parentId;
		}

		public java.lang.String getRemark() {
			return remark;
		}

		public void setRemark(java.lang.String remark) {
			this.remark = remark;
		}

		public String getEndDatePlanFrom() {
			return endDatePlanFrom;
		}

		public void setEndDatePlanFrom(String endDatePlanFrom) {
			this.endDatePlanFrom = endDatePlanFrom;
		}

		public String getEndDatePlanTo() {
			return endDatePlanTo;
		}

		public void setEndDatePlanTo(String endDatePlanTo) {
			this.endDatePlanTo = endDatePlanTo;
		}

		public String getStartDatePlanFrom() {
			return startDatePlanFrom;
		}

		public void setStartDatePlanFrom(String startDatePlanFrom) {
			this.startDatePlanFrom = startDatePlanFrom;
		}

		public String getStartDatePlanTo() {
			return startDatePlanTo;
		}

		public void setStartDatePlanTo(String startDatePlanTo) {
			this.startDatePlanTo = startDatePlanTo;
		}

		public java.lang.String getStatus() {
			return status;
		}

		public void setStatus(java.lang.String status) {
			this.status = status;
		}

		public String getTargetLevel() {
			return targetLevel;
		}

		public void setTargetLevel(String targetLevel) {
			this.targetLevel = targetLevel;
		}

		public java.lang.String getTargetName() {
			return targetName;
		}

		public void setTargetName(java.lang.String targetName) {
			this.targetName = targetName;
		}

		public java.lang.String getTargetOrder() {
			return targetOrder;
		}

		public void setTargetOrder(java.lang.String targetOrder) {
			this.targetOrder = targetOrder;
		}

		public String getUserPLId() {
			return userPLId;
		}

		public void setUserPLId(String userPLId) {
			this.userPLId = userPLId;
		}

		public String getUserSEId() {
			return userSEId;
		}

		public void setUserSEId(String userSEId) {
			this.userSEId = userSEId;
		}

		public String getWorkloadFact() {
			return workloadFact;
		}

		public void setWorkloadFact(String workloadFact) {
			this.workloadFact = workloadFact;
		}

		public String getWorkloadPlan() {
			return workloadPlan;
		}

		public void setWorkloadPlan(String workloadPlan) {
			this.workloadPlan = workloadPlan;
		}


}

