
package edu.pm.uc.acceptreport.form;

import java.text.SimpleDateFormat;

import edu.dlmu.sei.util.CoreUtils;
import edu.pm.base.PMBaseForm;
import edu.pm.vo.AcceptReports;

/**
 * @author guo
 *
 */
public class AcceptReportForm extends PMBaseForm {
	
		private String id;

	    /** The value of the projects association. */
	    private String projectId;

	    /** The value of the simple projectSummarize property. */
	    private java.lang.String projectSummarize;

	    /** The value of the simple workloadPlan property. */
	    private java.lang.String workloadPlan;

	    /** The value of the simple estimateSize property. */
	    private java.lang.String estimateSize;

	    /** The value of the simple workloadFact property. */
	    private java.lang.String workloadFact;

	    /** The value of the simple estimateRemark property. */
	    private java.lang.String estimateRemark;

	    /** The value of the simple risk1 property. */
	    private java.lang.String risk1;

	    /** The value of the simple risk2 property. */
	    private java.lang.String risk2;

	    /** The value of the simple risk3 property. */
	    private java.lang.String risk3;

	    /** The value of the simple experience property. */
	    private java.lang.String experience;

	    /** The value of the simple acceptCommment property. */
	    private java.lang.String acceptCommment;

	    /** The value of the simple acceptBy property. */
	    private java.lang.String acceptBy;

	    /** The value of the simple acceptDate property. */
	    private String acceptDate;

	    /** The value of the simple acceptResult property. */
	    private java.lang.String acceptResult;



		public AcceptReports getVo() {
			
			AcceptReports vo = new AcceptReports();

			if (null != id && !"".equals(id)){
				vo.setId(new Long(id));
			}
			if (null != projectId && !"".equals(projectId)){
				vo.setProjectId(new Long(projectId));
			}
			if (null !=acceptDate && !acceptDate.trim().equals("")) {
				vo.setAcceptDate(CoreUtils.parseDate(acceptDate.trim()));
			}
			if (null != workloadPlan && !"".equals(workloadPlan)){
				vo.setWorkloadPlan(new Integer(workloadPlan));
			}
			if (null != workloadFact && !"".equals(workloadFact)){
				vo.setWorkloadFact(new Integer(workloadFact));
			}
			if (null != estimateSize && !"".equals(estimateSize)){
				vo.setEstimateSize(new Integer(estimateSize));
			}
			
			vo.setProjectSummarize(this.getProjectSummarize());
			vo.setEstimateRemark(this.getEstimateRemark());
			vo.setRisk1(this.getRisk1());
			vo.setRisk2(this.getRisk2());
			vo.setRisk3(this.getRisk3());
			vo.setExperience(this.getExperience());
			vo.setAcceptCommment(this.getAcceptCommment());
			vo.setAcceptBy(this.getAcceptBy());
			vo.setAcceptResult(this.getAcceptResult());
			
			
			return vo;
		}

		public void setVO(AcceptReports vo) {
			
			SimpleDateFormat myFmt1=new SimpleDateFormat("yyyy-MM-dd");
			//java.text.DecimalFormat format = new java.text.DecimalFormat("#############0.00");
			
			if (null != vo.getId()){
				setId(vo.getId().toString());
			}
			if (null != vo.getProjectId()){
				setProjectId(vo.getProjectId().toString());
			}
			if (null != vo.getAcceptDate()) {
				setAcceptDate(myFmt1.format(vo.getAcceptDate()));
			}
			if (null != vo.getWorkloadFact()){
				setWorkloadFact(vo.getWorkloadFact().toString());
			}
			if (null != vo.getWorkloadPlan()){
				setWorkloadPlan(vo.getWorkloadPlan().toString());
			}
			if (null != vo.getEstimateSize()){
				setEstimateSize(vo.getEstimateSize().toString());
			}
			
			setProjectSummarize(vo.getProjectSummarize());
			setEstimateRemark(vo.getEstimateRemark());
			setRisk1(vo.getRisk1());
			setRisk2(vo.getRisk2());
			setRisk3(vo.getRisk3());
			setExperience(vo.getExperience());
			setAcceptCommment(vo.getAcceptCommment());
			setAcceptBy(vo.getAcceptBy());
			setAcceptResult(vo.getAcceptResult());
			
			
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

		public java.lang.String getAcceptBy() {
			return acceptBy;
		}

		public void setAcceptBy(java.lang.String acceptBy) {
			this.acceptBy = acceptBy;
		}

		public java.lang.String getAcceptCommment() {
			return acceptCommment;
		}

		public void setAcceptCommment(java.lang.String acceptCommment) {
			this.acceptCommment = acceptCommment;
		}

		public String getAcceptDate() {
			return acceptDate;
		}

		public void setAcceptDate(String acceptDate) {
			this.acceptDate = acceptDate;
		}

		public java.lang.String getAcceptResult() {
			return acceptResult;
		}

		public void setAcceptResult(java.lang.String acceptResult) {
			this.acceptResult = acceptResult;
		}

		public java.lang.String getEstimateRemark() {
			return estimateRemark;
		}

		public void setEstimateRemark(java.lang.String estimateRemark) {
			this.estimateRemark = estimateRemark;
		}

		public java.lang.String getEstimateSize() {
			return estimateSize;
		}

		public void setEstimateSize(java.lang.String estimateSize) {
			this.estimateSize = estimateSize;
		}

		public java.lang.String getExperience() {
			return experience;
		}

		public void setExperience(java.lang.String experience) {
			this.experience = experience;
		}

		public java.lang.String getProjectSummarize() {
			return projectSummarize;
		}

		public void setProjectSummarize(java.lang.String projectSummarize) {
			this.projectSummarize = projectSummarize;
		}

		public java.lang.String getRisk1() {
			return risk1;
		}

		public void setRisk1(java.lang.String risk1) {
			this.risk1 = risk1;
		}

		public java.lang.String getRisk2() {
			return risk2;
		}

		public void setRisk2(java.lang.String risk2) {
			this.risk2 = risk2;
		}

		public java.lang.String getRisk3() {
			return risk3;
		}

		public void setRisk3(java.lang.String risk3) {
			this.risk3 = risk3;
		}

		public java.lang.String getWorkloadFact() {
			return workloadFact;
		}

		public void setWorkloadFact(java.lang.String workloadFact) {
			this.workloadFact = workloadFact;
		}

		public java.lang.String getWorkloadPlan() {
			return workloadPlan;
		}

		public void setWorkloadPlan(java.lang.String workloadPlan) {
			this.workloadPlan = workloadPlan;
		}
}
