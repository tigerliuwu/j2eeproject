
package edu.pm.uc.projectreport.form;

import java.text.SimpleDateFormat;

import edu.dlmu.sei.util.CoreUtils;
import edu.pm.base.PMBaseForm;
import edu.pm.vo.ProjectReports;

/**
 * @author guo
 *
 */
public class ProjectReportForm extends PMBaseForm {
	
		private String id;

	    /** The value of the projects association. */
	    private String projectId;

		private String reportDate;

	    /** The value of the simple reportName property. */
	    private java.lang.String reportName;

	    /** The value of the simple excuteStatus property. */
	    private java.lang.String excuteStatus;

	    /** The value of the simple problem property. */
	    private java.lang.String problem;

	    /** The value of the simple risk property. */
	    private java.lang.String risk;

	    /** The value of the simple nextPlan property. */
	    private java.lang.String nextPlan;


		
		public java.lang.String getExcuteStatus() {
			return excuteStatus;
		}

		public void setExcuteStatus(java.lang.String excuteStatus) {
			this.excuteStatus = excuteStatus;
		}

		public java.lang.String getNextPlan() {
			return nextPlan;
		}

		public void setNextPlan(java.lang.String nextPlan) {
			this.nextPlan = nextPlan;
		}

		public java.lang.String getProblem() {
			return problem;
		}

		public void setProblem(java.lang.String problem) {
			this.problem = problem;
		}

		public String getReportDate() {
			return reportDate;
		}

		public void setReportDate(String reportDate) {
			this.reportDate = reportDate;
		}

		public java.lang.String getReportName() {
			return reportName;
		}

		public void setReportName(java.lang.String reportName) {
			this.reportName = reportName;
		}

		public java.lang.String getRisk() {
			return risk;
		}

		public void setRisk(java.lang.String risk) {
			this.risk = risk;
		}

		public ProjectReports getVo() {
			
			ProjectReports vo = new ProjectReports();

			if (null != id && !"".equals(id)){
				vo.setId(new Long(id));
			}
			if (null != projectId && !"".equals(projectId)){
				vo.setProjectId(new Long(projectId));
			}
			
			if (null !=reportDate && !reportDate.trim().equals("")) {
				vo.setReportDate(CoreUtils.parseDate(reportDate.trim()));
			}
			
			vo.setReportName(this.getReportName());
			vo.setExcuteStatus(this.getExcuteStatus());
			vo.setProblem(this.getProblem());
			vo.setRisk(this.getRisk());
			vo.setNextPlan(this.getNextPlan());
			
			return vo;
		}

		public void setVO(ProjectReports vo) {
			
			SimpleDateFormat myFmt1=new SimpleDateFormat("yyyy-MM-dd");
			//java.text.DecimalFormat format = new java.text.DecimalFormat("#############0.00");
			
			if (null != vo.getId()){
				setId(vo.getId().toString());
			}
			if (null != vo.getProjectId()){
				setProjectId(vo.getProjectId().toString());
			}
			if (null != vo.getReportDate()) {
				setReportDate(myFmt1.format(vo.getReportDate()));
			}
			
			setReportName(vo.getReportName());
			setExcuteStatus(vo.getExcuteStatus());
			setProblem(vo.getProblem());
			setRisk(vo.getRisk());
			setNextPlan(vo.getNextPlan());
			
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
}
