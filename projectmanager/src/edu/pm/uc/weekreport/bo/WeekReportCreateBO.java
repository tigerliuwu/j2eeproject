
package edu.pm.uc.weekreport.bo;

import edu.pm.base.PMBaseBusinessObject;
import edu.pm.base.PMBaseDAO;
import edu.pm.vo.WeekReports;

public class WeekReportCreateBO extends PMBaseBusinessObject {

	private WeekReports vo;
 
	Long id;
 
	private PMBaseDAO dao = new PMBaseDAO(WeekReports.class);

	public Long getId() {
		return id;
	}

	public WeekReportCreateBO(WeekReports vo) {

		this.vo = vo;

	}

	protected void performBusinessLogic() {

		id = (Long) dao.save(vo);

		
	}

}
