
package edu.pm.uc.weekset.form;

import java.text.SimpleDateFormat;

import edu.dlmu.sei.util.CoreUtils;
import edu.pm.base.PMBaseForm;
import edu.pm.vo.Weeks;

/**
 * @author guo
 *
 */
public class WeekForm extends PMBaseForm {


 /** The composite primary key value. */
    private String id;

    /** The value of the projects association. */
    private String projectId;

    /** The value of the simple startDate property. */
    private String startDate;

    /** The value of the simple endDate property. */
    private String endDate;

    /** The value of the simple workloadPerDay property. */
    private String workloadPerDay;

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
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

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getWorkloadPerDay() {
		return workloadPerDay;
	}

	public void setWorkloadPerDay(String workloadPerDay) {
		this.workloadPerDay = workloadPerDay;
	}

	public Weeks getVo() {
		
		Weeks vo = new Weeks();

		if (null != id && !"".equals(id)){
			vo.setId(new Long(id));
		}
		if (null != projectId && !"".equals(projectId)){
			vo.setProjectId(new Long(projectId));
		}
		if (null != workloadPerDay && !"".equals(workloadPerDay)){
			vo.setWorkloadPerDay(new Integer(workloadPerDay));
		}
		if (null !=endDate && !endDate.trim().equals("")) {
			vo.setEndDate(CoreUtils.parseDate(endDate.trim()));
		}
		if (null !=startDate && !startDate.trim().equals("")) {
			vo.setStartDate(CoreUtils.parseDate(startDate.trim()));
		}
		
		return vo;
	}

	public void setVO(Weeks vo) {
		
		SimpleDateFormat myFmt1=new SimpleDateFormat("yyyy-MM-dd");
		//java.text.DecimalFormat format = new java.text.DecimalFormat("#############0.00");
		
		if (null != vo.getId()){
			setId(vo.getId().toString());
		}
		if (null != vo.getProjectId()){
			setProjectId(vo.getProjectId().toString());
		}
		
		if (null != vo.getWorkloadPerDay()){
			setWorkloadPerDay(vo.getWorkloadPerDay().toString());
		}
		if (null != vo.getEndDate()) {
			setEndDate(myFmt1.format(vo.getEndDate()));
		}
		if (null != vo.getStartDate()) {
			setStartDate(myFmt1.format(vo.getStartDate()));
		}
		
	}

}
