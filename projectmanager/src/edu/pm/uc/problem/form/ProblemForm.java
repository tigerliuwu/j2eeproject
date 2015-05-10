
package edu.pm.uc.problem.form;

import java.text.SimpleDateFormat;

import edu.dlmu.sei.util.CoreUtils;
import edu.pm.base.PMBaseForm;
import edu.pm.vo.Problems;

/**
 * @author guo
 *
 */
public class ProblemForm extends PMBaseForm {
	
		private String id;

	    /** The value of the projects association. */
	    private String projectId;

	    private String submitById;

	    /** The value of the users1 association. */
	    private String solveById;

	    /** The value of the users2 association. */
	    private String validateById;

	    /** The value of the simple submitDate property. */
	    private String submitDate;

	    /** The value of the simple problemLevel property. */
	    private String problemLevel;
	    
	    private String problemDescription;

	    /** The value of the simple correctMeasure property. */
	    private java.lang.String correctMeasure;

	    /** The value of the simple status property. */
	    private java.lang.String status;

	    /** The value of the simple closeDate property. */
	    private String closeDate;
		
		public Problems getVo() {
			
			Problems vo = new Problems();

			if (null != id && !"".equals(id)){
				vo.setId(new Long(id));
			}
			if (null != projectId && !"".equals(projectId)){
				vo.setProjectId(new Long(projectId));
			}
			if (null != submitById && !"".equals(submitById)){
				vo.setSubmitById(new Long(submitById));
			}
			if (null != validateById && !"".equals(validateById)){
				vo.setValidateById(new Long(validateById));
			}
			if (null != solveById && !"".equals(solveById)){
				vo.setSolveById(new Long(solveById));
			}
			if (null !=submitDate && !submitDate.trim().equals("")) {
				vo.setSubmitDate(CoreUtils.parseDate(submitDate.trim()));
			}
			if (null !=closeDate && !closeDate.trim().equals("")) {
				vo.setCloseDate(CoreUtils.parseDate(closeDate.trim()));
			}
			
			vo.setProblemLevel(this.getProblemLevel());
			vo.setCorrectMeasure(correctMeasure);
			vo.setProblemDescription(this.getProblemDescription());
			vo.setStatus(this.getStatus());
			
			return vo;
		}

		public void setVO(Problems vo) {
			
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
			if (null != vo.getValidateById()){
				setValidateById(vo.getValidateById().toString());
			}
			if (null != vo.getSolveById()){
				setSolveById(vo.getSolveById().toString());
			}
			if (null != vo.getSubmitDate()) {
				setSubmitDate(myFmt1.format(vo.getSubmitDate()));
			}
			if (null != vo.getCloseDate()) {
				setCloseDate(myFmt1.format(vo.getCloseDate()));
			}
			
			setProblemLevel(vo.getProblemLevel());
			setProblemDescription(vo.getProblemDescription());
			setCorrectMeasure(vo.getCorrectMeasure());
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

		public String getCloseDate() {
			return closeDate;
		}

		public void setCloseDate(String closeDate) {
			this.closeDate = closeDate;
		}

		public java.lang.String getCorrectMeasure() {
			return correctMeasure;
		}

		public void setCorrectMeasure(java.lang.String correctMeasure) {
			this.correctMeasure = correctMeasure;
		}

		public String getProblemLevel() {
			return problemLevel;
		}

		public void setProblemLevel(String problemLevel) {
			this.problemLevel = problemLevel;
		}

		public String getSolveById() {
			return solveById;
		}

		public void setSolveById(String solveById) {
			this.solveById = solveById;
		}

		public String getValidateById() {
			return validateById;
		}

		public void setValidateById(String validateById) {
			this.validateById = validateById;
		}

		public String getProblemDescription() {
			return problemDescription;
		}

		public void setProblemDescription(String problemDescription) {
			this.problemDescription = problemDescription;
		}
}
