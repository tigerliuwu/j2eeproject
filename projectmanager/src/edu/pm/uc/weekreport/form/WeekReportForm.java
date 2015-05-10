
package edu.pm.uc.weekreport.form;

import java.text.SimpleDateFormat;

import edu.dlmu.sei.util.CoreUtils;
import edu.pm.base.PMBaseForm;
import edu.pm.vo.WeekReports;

/**
 * @author guo
 *
 */
public class WeekReportForm extends PMBaseForm {


 /** The composite primary key value. */
    private String id;

    private String targetId;
    
    private String weekId;

    /** The value of the users association. */
    private String submitById;

    /** The value of the simple submitDate property. */
    private String submitDate;

    /** The value of the simple startDateFact property. */
    private String startDateFact;

    /** The value of the simple endDateFact property. */
    private String endDateFact;

    /** The value of the simple workloadThisweek property. */
    private String workloadThisweek;

    /** The value of the simple excuteStatus property. */
    private java.lang.String excuteStatus;

    /** The value of the simple problem property. */
    private java.lang.String problem;


	public String getEndDateFact() {
		return endDateFact;
	}

	public void setEndDateFact(String endDateFact) {
		this.endDateFact = endDateFact;
	}

	public java.lang.String getExcuteStatus() {
		return excuteStatus;
	}

	public void setExcuteStatus(java.lang.String excuteStatus) {
		this.excuteStatus = excuteStatus;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public java.lang.String getProblem() {
		return problem;
	}

	public void setProblem(java.lang.String problem) {
		this.problem = problem;
	}

	public String getStartDateFact() {
		return startDateFact;
	}

	public void setStartDateFact(String startDateFact) {
		this.startDateFact = startDateFact;
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

	public String getTargetId() {
		return targetId;
	}

	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}

	public String getWeekId() {
		return weekId;
	}

	public void setWeekId(String weekId) {
		this.weekId = weekId;
	}

	public String getWorkloadThisweek() {
		return workloadThisweek;
	}

	public void setWorkloadThisweek(String workloadThisweek) {
		this.workloadThisweek = workloadThisweek;
	}

	public WeekReports getVo() {
		
		WeekReports vo = new WeekReports();

		if (null != id && !"".equals(id)){
			vo.setId(new Long(id));
		}
		if (null != targetId && !"".equals(targetId)){
			vo.setTargetId(new Long(targetId));
		}
		if (null != weekId && !"".equals(weekId)){
			vo.setWeekId(new Long(weekId));
		}
		if (null != submitById && !"".equals(submitById)){
			vo.setSubmitById(new Long(submitById));
		}
		if (null != workloadThisweek && !"".equals(workloadThisweek)){
			vo.setWorkloadThisweek(new Integer(workloadThisweek));
		}
		if (null !=submitDate && !submitDate.trim().equals("")) {
			vo.setSubmitDate(CoreUtils.parseDate(submitDate.trim()));
		}
		if (null !=startDateFact && !startDateFact.trim().equals("")) {
			vo.setStartDateFact(CoreUtils.parseDate(startDateFact.trim()));
		}
		if (null !=endDateFact && !endDateFact.trim().equals("")) {
			vo.setEndDateFact(CoreUtils.parseDate(endDateFact.trim()));
		}
		
		vo.setExcuteStatus(excuteStatus);
		vo.setProblem(problem);
		
		
		return vo;
	}

	public void setVO(WeekReports vo) {
		
		SimpleDateFormat myFmt1=new SimpleDateFormat("yyyy-MM-dd");
		//java.text.DecimalFormat format = new java.text.DecimalFormat("#############0.00");
		
		if (null != vo.getId()){
			setId(vo.getId().toString());
		}
		if (null != vo.getTargetId()){
			setTargetId(vo.getTargetId().toString());
		}
		if (null != vo.getWeekId()){
			setWeekId(vo.getWeekId().toString());
		}
		if (null != vo.getSubmitById()){
			setSubmitById(vo.getSubmitById().toString());
		}
		if (null != vo.getSubmitDate()){
			setSubmitDate(vo.getSubmitDate().toString());
		}
		if (null != vo.getWorkloadThisweek()){
			setWorkloadThisweek(vo.getWorkloadThisweek().toString());
		}
		if (null != vo.getEndDateFact()) {
			setEndDateFact(myFmt1.format(vo.getEndDateFact()));
		}
		if (null != vo.getStartDateFact()) {
			setStartDateFact(myFmt1.format(vo.getStartDateFact()));
		}
		
		setExcuteStatus(vo.getExcuteStatus());
		setProblem(vo.getProblem());
		
	}

}
