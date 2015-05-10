package edu.pm.uc.background.bo;

import edu.dlmu.sei.util.ConstantsContainer;
import edu.pm.base.PMBaseBusinessObject;
import edu.pm.base.PMBaseDAO;
import edu.pm.constants.PMConstants;
import edu.pm.vo.Projects;

public class ProjectDeleteBO extends PMBaseBusinessObject {

	Long id;

	private PMBaseDAO dao = new PMBaseDAO(Projects.class);

	public Long getId() {
		return id;
	}

	public ProjectDeleteBO(Long id) {

		this.id = id;

	}

	protected void performBusinessLogic() {

		Projects po = (Projects) dao.loadAndLock(id);
		dao.delete(po);
		
		// update cache
		ConstantsContainer.getInstants().removeVO(PMConstants.Projects,id.toString());
		
	}

}
