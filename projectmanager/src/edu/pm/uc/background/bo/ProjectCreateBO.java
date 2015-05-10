package edu.pm.uc.background.bo;

import edu.dlmu.sei.util.ConstantsContainer;
import edu.pm.base.PMBaseBusinessObject;
import edu.pm.base.PMBaseDAO;
import edu.pm.constants.PMConstants;
import edu.pm.vo.Projects;

public class ProjectCreateBO extends PMBaseBusinessObject {

	private Projects vo;
 
	Long id;
 
	private PMBaseDAO dao = new PMBaseDAO(Projects.class);

	public Long getId() {
		return id;
	}

	public ProjectCreateBO(Projects vo) {

		this.vo = vo;

	}

	protected void performBusinessLogic() {

		id = (Long) dao.save(vo);
		
		vo.setId(id);
		
		// update cache
		ConstantsContainer.getInstants().setVO(PMConstants.Projects,vo);

		
	}

}
