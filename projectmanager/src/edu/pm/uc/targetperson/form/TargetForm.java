
package edu.pm.uc.targetperson.form;

import java.text.SimpleDateFormat;

import edu.dlmu.sei.util.CoreUtils;
import edu.pm.base.PMBaseForm;
import edu.pm.vo.Targets;

/**
 * @author guo
 *
 */
public class TargetForm extends PMBaseForm {
	
		private String id;

	    /** The value of the projects association. */
	    private String projectId;

	    /** The value of the users association. */
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
	    private String startDatePlan;

	    /** The value of the simple endDatePlan property. */
	    private String endDatePlan;

	    /** The value of the simple startDateFact property. */
	    private String startDateFact;

	    /** The value of the simple endDateFact property. */
	    private String endDateFact;

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

		
		
		public Targets getVo() {
			
			Targets vo = new Targets();

			if (null != id && !"".equals(id)){
				vo.setId(new Long(id));
			}
			if (null != projectId && !"".equals(projectId)){
				vo.setProjectId(new Long(projectId));
			}
			if (null != userSEId && !"".equals(userSEId)){
				vo.setUserSEId(new Long(userSEId));
			}
			if (null != userPLId && !"".equals(userPLId)){
				vo.setUserPLId(new Long(userPLId));
			}
			if (null != parentId && !"".equals(parentId)){
				vo.setParentId(new Long(parentId));
			}
			if (null !=startDatePlan && !startDatePlan.trim().equals("")) {
				vo.setStartDatePlan(CoreUtils.parseDate(startDatePlan.trim()));
			}
			if (null !=endDatePlan && !endDatePlan.trim().equals("")) {
				vo.setEndDatePlan(CoreUtils.parseDate(endDatePlan.trim()));
			}
			if (null !=startDateFact && !startDateFact.trim().equals("")) {
				vo.setStartDateFact(CoreUtils.parseDate(startDateFact.trim()));
			}
			if (null !=endDateFact && !endDateFact.trim().equals("")) {
				vo.setEndDateFact(CoreUtils.parseDate(endDateFact.trim()));
			}
			if (null != workloadFact && !"".equals(workloadFact)){
				vo.setWorkloadFact(new Integer(workloadFact));
			}
			if (null != workloadPlan && !"".equals(workloadPlan)){
				vo.setWorkloadPlan(new Integer(workloadPlan));
			}
			if (null != targetLevel && !"".equals(targetLevel)){
				vo.setTargetLevel(new Integer(targetLevel));
			}
			
			vo.setIsParent(isParent);
			vo.setTargetName(targetName);
			vo.setRemark(remark);
			vo.setIsMilestone(isMilestone);
			vo.setDisplayColor(displayColor);
			vo.setExcuteStatus(excuteStatus);
			vo.setIsDeleted(isDeleted);
			vo.setTargetOrder(targetOrder);
			vo.setStatus(status);
			
			return vo;
		}

		public void setVO(Targets vo) {
			
			SimpleDateFormat myFmt1=new SimpleDateFormat("yyyy-MM-dd");
			//java.text.DecimalFormat format = new java.text.DecimalFormat("#############0.00");
			
			if (null != vo.getId()){
				setId(vo.getId().toString());
			}
			if (null != vo.getProjectId()){
				setProjectId(vo.getProjectId().toString());
			}
			if (null != vo.getUserSEId()){
				setUserSEId(vo.getUserSEId().toString());
			}
			if (null != vo.getUserPLId()){
				setUserPLId(vo.getUserPLId().toString());
			}
			if (null != vo.getParentId()){
				setParentId(vo.getParentId().toString());
			}
			if (null != vo.getWorkloadFact()){
				setWorkloadFact(vo.getWorkloadFact().toString());
			}
			if (null != vo.getWorkloadPlan()){
				setWorkloadPlan(vo.getWorkloadPlan().toString());
			}
			if (null != vo.getTargetLevel()){
				setTargetLevel(vo.getTargetLevel().toString());
			}
			if (null != vo.getStartDatePlan()) {
				setStartDatePlan(myFmt1.format(vo.getStartDatePlan()));
			}
			if (null != vo.getEndDatePlan()) {
				setEndDatePlan(myFmt1.format(vo.getEndDatePlan()));
			}
			if (null != vo.getStartDateFact()) {
				setStartDateFact(myFmt1.format(vo.getStartDateFact()));
			}
			if (null != vo.getEndDateFact()) {
				setEndDateFact(myFmt1.format(vo.getEndDateFact()));
			}
			
			setIsParent(vo.getIsParent());
			setTargetName(vo.getTargetName());
			setRemark(vo.getRemark());
			setIsMilestone(vo.getIsMilestone());
			setDisplayColor(vo.getDisplayColor());
			setExcuteStatus(vo.getExcuteStatus());
			setIsDeleted(vo.getIsDeleted());
			setTargetOrder(vo.getTargetOrder());
			setStatus(vo.getStatus());
			
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getProjectId() {
			return projectId;
		}

		public void setProjectId(String projectId) {
			this.projectId = projectId;
		}


		public java.lang.String getStatus() {
			return status;
		}

		public void setStatus(java.lang.String status) {
			this.status = status;
		}

		public java.lang.String getDisplayColor() {
			return displayColor;
		}

		public void setDisplayColor(java.lang.String displayColor) {
			this.displayColor = displayColor;
		}

		public String getEndDateFact() {
			return endDateFact;
		}

		public void setEndDateFact(String endDateFact) {
			this.endDateFact = endDateFact;
		}

		public String getEndDatePlan() {
			return endDatePlan;
		}

		public void setEndDatePlan(String endDatePlan) {
			this.endDatePlan = endDatePlan;
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

		public String getStartDateFact() {
			return startDateFact;
		}

		public void setStartDateFact(String startDateFact) {
			this.startDateFact = startDateFact;
		}

		public String getStartDatePlan() {
			return startDatePlan;
		}

		public void setStartDatePlan(String startDatePlan) {
			this.startDatePlan = startDatePlan;
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
