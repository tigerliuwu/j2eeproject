package edu.pm.uc.gantt.bo;

import edu.pm.base.PMBaseBusinessObject;
import edu.pm.base.PMBaseDAO;
import edu.pm.vo.Targets;

public class TargetDeleteBO extends PMBaseBusinessObject {

	Long id;

	private PMBaseDAO dao = new PMBaseDAO(Targets.class);

	public Long getId() {
		return id;
	}

	public TargetDeleteBO(Long id) {

		this.id = id;

	}

	protected void performBusinessLogic() {

		Targets po = (Targets) dao.loadAndLock(id);
		dao.delete(po);
	}

}
