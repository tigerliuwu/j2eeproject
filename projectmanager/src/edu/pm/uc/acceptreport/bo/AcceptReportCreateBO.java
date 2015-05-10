package edu.pm.uc.acceptreport.bo;

import edu.pm.base.PMBaseBusinessObject;
import edu.pm.base.PMBaseDAO;
import edu.pm.vo.AcceptReports;

public class AcceptReportCreateBO extends PMBaseBusinessObject {

	private AcceptReports vo;
 
	Long id;
 
	private PMBaseDAO dao = new PMBaseDAO(AcceptReports.class);

	public Long getId() {
		return id;
	}

	public AcceptReportCreateBO(AcceptReports vo) {

		this.vo = vo;

	}

	protected void performBusinessLogic() {

		id = (Long) dao.save(vo);

		
	}

}
