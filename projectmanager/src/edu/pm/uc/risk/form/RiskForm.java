
package edu.pm.uc.risk.form;

import java.text.SimpleDateFormat;

import edu.dlmu.sei.util.CoreUtils;
import edu.pm.base.PMBaseForm;
import edu.pm.vo.Risks;

/**
 * @author guo
 *
 */
public class RiskForm extends PMBaseForm {
	
		private String id;

	    /** The value of the projects association. */
	    private String projectId;

	    /** The value of the simple riskDescription property. */
	    private java.lang.String riskDescription;

	    /** The value of the simple riskLevel property. */
	    private java.lang.String riskLevel;

	    /** The value of the simple probability property. */
	    private java.lang.String probability;

	    /** The value of the simple submitById property. */
	    private String submitById;

	    /** The value of the simple submitDate property. */
	    private String submitDate;

	    /** The value of the simple influence property. */
	    private java.lang.String influence;

	    /** The value of the simple keepAwayMeasure property. */
	    private java.lang.String keepAwayMeasure;

	    /** The value of the simple status property. */
	    private java.lang.String status;

		
		
		public Risks getVo() {
			
			Risks vo = new Risks();

			if (null != id && !"".equals(id)){
				vo.setId(new Long(id));
			}
			if (null != projectId && !"".equals(projectId)){
				vo.setProjectId(new Long(projectId));
			}
			if (null != submitById && !"".equals(submitById)){
				vo.setSubmitById(new Long(submitById));
			}
			if (null !=submitDate && !submitDate.trim().equals("")) {
				vo.setSubmitDate(CoreUtils.parseDate(submitDate.trim()));
			}
			
			vo.setRiskDescription(this.getRiskDescription());
			vo.setRiskLevel(this.getRiskLevel());
			vo.setProbability(this.getProbability());
			vo.setInfluence(this.getInfluence());
			vo.setKeepAwayMeasure(this.getKeepAwayMeasure());
			vo.setStatus(this.getStatus());
			
			return vo;
		}

		public void setVO(Risks vo) {
			
			SimpleDateFormat myFmt1=new SimpleDateFormat("yyyy-MM-dd");
			//java.text.DecimalFormat format = new java.text.DecimalFormat("#############0.00");
			
			if (null != vo.getId()){
				setId(vo.getId().toString());
			}
			if (null != vo.getProjectId()){
				setProjectId(vo.getProjectId().toString());
			}
			if (null != vo.getSubmitById()){
				setSubmitById(vo.getSubmitById().toString());
			}
			if (null != vo.getSubmitDate()) {
				setSubmitDate(myFmt1.format(vo.getSubmitDate()));
			}
			
			setRiskDescription(vo.getRiskDescription());
			setRiskLevel(vo.getRiskLevel());
			setProbability(vo.getProbability());
			setInfluence(vo.getInfluence());
			setKeepAwayMeasure(vo.getKeepAwayMeasure());
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

		public java.lang.String getInfluence() {
			return influence;
		}

		public void setInfluence(java.lang.String influence) {
			this.influence = influence;
		}

		public java.lang.String getKeepAwayMeasure() {
			return keepAwayMeasure;
		}

		public void setKeepAwayMeasure(java.lang.String keepAwayMeasure) {
			this.keepAwayMeasure = keepAwayMeasure;
		}

		public java.lang.String getProbability() {
			return probability;
		}

		public void setProbability(java.lang.String probability) {
			this.probability = probability;
		}

		public java.lang.String getRiskDescription() {
			return riskDescription;
		}

		public void setRiskDescription(java.lang.String riskDescription) {
			this.riskDescription = riskDescription;
		}

		public java.lang.String getRiskLevel() {
			return riskLevel;
		}

		public void setRiskLevel(java.lang.String riskLevel) {
			this.riskLevel = riskLevel;
		}

		public java.lang.String getStatus() {
			return status;
		}

		public void setStatus(java.lang.String status) {
			this.status = status;
		}

		public String getSubmitById() {
			return submitById;
		}

		public void setSubmitById(String submitById) {
			this.submitById = submitById;
		}

		public String getSubmitDate() {
			return submitDate;
		}

		public void setSubmitDate(String submitDate) {
			this.submitDate = submitDate;
		}
}
