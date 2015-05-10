
package edu.pm.uc.payout.form;

import java.text.SimpleDateFormat;

import edu.dlmu.sei.util.CoreUtils;
import edu.pm.base.PMBaseForm;
import edu.pm.vo.Payouts;

/**
 * @author guo
 *
 */
public class PayoutForm extends PMBaseForm {
	
		private String id;

	    /** The value of the projects association. */
	    private String projectId;

		private String startDate;

	    /** The value of the simple endDatePlan property. */
	    private String endDate;


	    /** The value of the simple payPlan property. */
	    private String payPlan;

	    /** The value of the simple payFact property. */
	    private String payFact;

	    /** The value of the simple remark property. */
	    private java.lang.String remark;

		public String getEndDate() {
			return endDate;
		}

		public void setEndDate(String endDate) {
			this.endDate = endDate;
		}

		public String getPayFact() {
			return payFact;
		}

		public void setPayFact(String payFact) {
			this.payFact = payFact;
		}

		public String getPayPlan() {
			return payPlan;
		}

		public void setPayPlan(String payPlan) {
			this.payPlan = payPlan;
		}

		public java.lang.String getRemark() {
			return remark;
		}

		public void setRemark(java.lang.String remark) {
			this.remark = remark;
		}

		public String getStartDate() {
			return startDate;
		}

		public void setStartDate(String startDate) {
			this.startDate = startDate;
		}
		
		public Payouts getVo() {
			
			Payouts vo = new Payouts();

			if (null != id && !"".equals(id)){
				vo.setId(new Long(id));
			}
			if (null != projectId && !"".equals(projectId)){
				vo.setProjectId(new Long(projectId));
			}
			if (null != payPlan && !"".equals(payPlan)){
				vo.setPayPlan(new Double(payPlan));
			}
			if (null != payFact && !"".equals(payFact)){
				vo.setPayFact(new Double(payFact));
			}
			if (null !=endDate && !endDate.trim().equals("")) {
				vo.setEndDate(CoreUtils.parseDate(endDate.trim()));
			}
			if (null !=startDate && !startDate.trim().equals("")) {
				vo.setStartDate(CoreUtils.parseDate(startDate.trim()));
			}
			
			vo.setRemark(this.getRemark());
			
			return vo;
		}

		public void setVO(Payouts vo) {
			
			SimpleDateFormat myFmt1=new SimpleDateFormat("yyyy-MM-dd");
			//java.text.DecimalFormat format = new java.text.DecimalFormat("#############0.00");
			
			if (null != vo.getId()){
				setId(vo.getId().toString());
			}
			if (null != vo.getProjectId()){
				setProjectId(vo.getProjectId().toString());
			}
			
			if (null != vo.getPayPlan()){
				setPayPlan(vo.getPayPlan().toString());
			}
			if (null != vo.getPayFact()){
				setPayFact(vo.getPayFact().toString());
			}
			if (null != vo.getEndDate()) {
				setEndDate(myFmt1.format(vo.getEndDate()));
			}
			if (null != vo.getStartDate()) {
				setStartDate(myFmt1.format(vo.getStartDate()));
			}
			
			setRemark(vo.getRemark());
			
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
