package edu.pm.uc.projectreport.bo;

import edu.pm.base.PMBaseBusinessObject;
import edu.pm.base.PMBaseDAO;
import edu.pm.vo.ProjectReports;

public class ProjectReportCreateBO extends PMBaseBusinessObject {

	private ProjectReports vo;
 
	Long id;
 
	private PMBaseDAO dao = new PMBaseDAO(ProjectReports.class);

	public Long getId() {
		return id;
	}

	public ProjectReportCreateBO(ProjectReports vo) {

		this.vo = vo;

	}

	protected void performBusinessLogic() {

		id = (Long) dao.save(vo);

		
	}

}
